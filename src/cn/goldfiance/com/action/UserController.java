package cn.goldfiance.com.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.goldfiance.base.ComeFromBack;
import cn.goldfiance.base.Config;
import cn.goldfiance.base.LoginBack;
import cn.goldfiance.base.OAuthCode;
import cn.goldfiance.base.OauthManger;
import cn.goldfiance.base.OauthResponse;
import cn.goldfiance.base.ReturnResult;
import cn.goldfiance.com.domain.BindUser;
import cn.goldfiance.com.domain.LoginIdentityno;
import cn.goldfiance.com.domain.LoginMobileno;
import cn.goldfiance.com.domain.User;
import cn.goldfiance.com.service.BindUseService;
import cn.goldfiance.com.utils.HttpUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final String HTTP="http://api.gold-finance.com.cn:8008";
	
	@Resource
	private BindUseService bindUseService;


	@RequestMapping("/getCode.action")
	public @ResponseBody  OAuthCode getCode(OAuthCode oAuthCode) {
		return oAuthCode;
	}
	
	@RequestMapping("/getuser.action")
	public void getuser(HttpServletResponse response) throws Exception {
		
		LoginMobileno loginRequest=new LoginMobileno();
		
		loginRequest.setPassword("435435");
		loginRequest.setMobileno("13735478178");
		//LoginData data=new LoginData();
		//data.setData(loginRequest);
		//JSONArray jsonArray=JSONArray.fromObject(loginRequest);
		
		 JSONObject jsonObj = JSONObject.fromObject(loginRequest);
		
		//jsonArray.getString(index)
		//System.out.println(jsonArray.get(0));
		String data=jsonObj.toString();
		//System.out.println(a);
		//jsonArray.get(0);
		String loginback=HttpUtils.sendPost(HTTP+"/api/vip/login",data);
		//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
		String custno=null;
		System.out.println("---------"+loginback);
		JSONObject  json=JSONObject.fromObject(loginback);
		//JSONObject  j=JSONObject.fromObject(s);
		System.out.println(json.getString("result"));
		System.out.println(json.getString("content"));
		if(200==json.getInt("result")){
			String user=json.getString("content");
			JSONObject  jsonUser=JSONObject.fromObject(user);
			custno=jsonUser.getString("custno");
			BindUser bindUser=new BindUser();
			bindUser.setCustno(custno);
			
		}else{
			
		}
		response.getWriter().print(loginback);
		
	}
	
	@RequestMapping("/haha.action")
	public ModelAndView  haha(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView=new ModelAndView();
		String comefrom=(String) request.getSession().getAttribute("comefrom");
		System.out.println("---------"+comefrom);
		modelAndView.setViewName("/about.html");
		
		return modelAndView;
	}
	
	@RequestMapping("/login.action")
	public void  login(HttpServletRequest request,HttpServletResponse response,String status,String comefrom,String password,String mobileno,String identityno) throws Exception {
		
		String openid=null;
		
			String code = request.getParameter("code");
			OauthManger manger = new OauthManger();
			String ret = manger.getOpenid(code);
			OauthResponse oauthResponse = (OauthResponse) JSONObject.toBean(
					JSONObject.fromObject(ret), OauthResponse.class);
			if (oauthResponse.getOpenid() != null) {
				openid=oauthResponse.getOpenid();
			
			}
		
		ReturnResult returnResult=new ReturnResult();
		
		if(openid!=null){
			//手机登录
			if(Config.MOBILENOSTATUS.equals(status)){
				LoginMobileno loginMobileno=new LoginMobileno();
				if(null!=mobileno&&null!=password){
					loginMobileno.setMobileno(mobileno);
					loginMobileno.setPassword(password);
					
					JSONArray jsonArray=JSONArray.fromObject(loginMobileno);
				
					String data=jsonArray.getString(0);
				//求情登录
					toLogin(request, openid, returnResult, data,comefrom);
					
				}else{
					returnResult.setResult(Config.ERROR);
					returnResult.setContent("参数错误");
				}
				
			}else{
				//证件登录
				LoginIdentityno loginIdentityno=new LoginIdentityno();
				if(null!=identityno&&null!=password){
					loginIdentityno.setIdentityno(identityno);
					loginIdentityno.setPassword(password);
					JSONArray jsonArray=JSONArray.fromObject(loginIdentityno);
					
					String data=jsonArray.getString(0);
					//求情登录
					toLogin(request, openid, returnResult, data,comefrom);
				}else{
					returnResult.setResult(Config.ERROR);
					returnResult.setContent("参数错误");
				}
			}
		}else{
			returnResult.setResult(Config.ERROR);
			returnResult.setContent("服务器忙");
		}
		JSONObject json = JSONObject.fromObject(returnResult);//将java对象转换为json对象  
	    String str = json.toString();
		response.getWriter().print(str);
		
	}

	private void toLogin(HttpServletRequest request, String openid,
			ReturnResult returnResult, String data,String comefrom) {
		String custno=null;
		String loginback=HttpUtils.sendPost(HTTP+"/api/vip/login",data);
		
		JSONObject  json=JSONObject.fromObject(loginback);
		String content=json.getString("content");
		if(200==json.getInt("result")){
			
			JSONObject  jsonContent=JSONObject.fromObject(content);
			String user=jsonContent.getString("user");
			
			
			JSONObject obj = new JSONObject().fromObject(user);//将json字符串转换为json对象
			//将json对象转换为java对象
			User use = (User)JSONObject.toBean(obj,User.class);//将建json对象转换为Person对象
			if(null!=use){
				LoginBack back=new LoginBack();
				custno=use.getCustno();
				String ticket=use.getTicket();
				String riskType=use.getRiskType();
				//JSONObject  jsonUser=JSONObject.fromObject(user);
				//custno=jsonUser.getString("custno");
				//String ticket=jsonUser.getString("jsonUser");
				BindUser bindUser=new BindUser();
				bindUser.setCustno(custno);
				bindUser.setOpenid(openid);
				bindUser.setTicket(ticket);
				if("1000".equals(riskType)){
					returnResult.setResult(Config.UNRISK);
					returnResult.setContent("未作风险测评");
				}else{
					//先查询有没有绑定在插入
					BindUser bind =bindUseService.getBindUserByOpenid(openid);
					BindUser bind2 =bindUseService.getBindUserByCustno(openid);
					if(null==bind&&null!=bind2){
						bindUseService.insertBindUser(bindUser);
					}else{
						
					}
					request.getSession().setAttribute("bindUser", bindUser);
					back.setComefrom(comefrom);
					back.setMsg("登录成功");
					returnResult.setResult(Config.SUCCESS);
					returnResult.setContent(back);
					
				}
				//把客户号custno放入session
				request.getSession().setAttribute("custno", custno);
		
			}
			
			
		}else{
			returnResult.setResult(Config.ERROR);
			returnResult.setContent(content);
		}
	}
	
	@RequestMapping("/comefrom.action")
	public void comefrom(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String comefrom=(String) request.getSession().getAttribute("comefrom");
		ComeFromBack comeFromBack=new ComeFromBack();
		if(null!=comefrom){
			comeFromBack.setComefrom(comefrom);
			comeFromBack.setResult(Config.SUCCESS);
		}else{
			comeFromBack.setComefrom(Config.COMEFROM1);
			comeFromBack.setResult(Config.SUCCESS);
		}
		//JSONArray jsonArray = JSONArray.fromObject(comeFromBack);
		 JSONObject jsonObj = JSONObject.fromObject(comeFromBack);
		response.getWriter().print(jsonObj.toString());
		
	}
	//持有资产
	@RequestMapping("/shares.action")
	public void shares(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BindUser bind=(BindUser) request.getSession().getAttribute("bindUser");
		if(null!=bind){
			String shares=HttpUtils.sendGetByTicket(HTTP+"/api/vip/shares",bind.getTicket());
			//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
			//String custno=null;
			System.out.println("---------"+shares);
			//JSONArray jsonArray = JSONArray.fromObject("["+shares+"]");
			response.getWriter().print(shares);
		}else{
			
		}
		
		
	}
	
	//资产详情
		@RequestMapping("/sharesAll.action")
		public void shares2(HttpServletRequest request,HttpServletResponse response,String id) throws Exception {
			id="21f5cd20-4e2d-e611-80cc-ecf4bbf1c777";
			String shares2=HttpUtils.sendGetByTicket(HTTP+"/api/vip/shares?id="+id,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
			//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
			//String custno=null;
			System.out.println("---------"+shares2);
			//JSONArray jsonArray = JSONArray.fromObject("["+shares2+"]");
			response.getWriter().print(shares2);
			
		}
	//风险测评
	@RequestMapping("/risk.action")
	public void risk(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String riskback=HttpUtils.sendGet(HTTP+"/api/vip/risk","type=1010");
		//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
		//String custno=null;
		System.out.println("---------"+riskback);
		//JSONArray jsonArray = JSONArray.fromObject("["+riskback+"]");
		response.getWriter().print(riskback);
		
	}
	//产品列表
	@RequestMapping("/prdtlist.action")
	public void prdtlist(HttpServletRequest request,HttpServletResponse response,String page,String size) throws Exception {
		page="1";
		size="10";
		String prdtlist=HttpUtils.sendGetByTicket(HTTP+"/api/vip/prdtlist?page="+page+"&size="+size,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
		//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
		//String custno=null;
		System.out.println("---------"+prdtlist);
		//JSONArray jsonArray = JSONArray.fromObject("["+prdtlist+"]");
		response.getWriter().print(prdtlist);
		
	}
	
	//产品详情
	@RequestMapping("/product.action")
	public void product(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		code="JC02NR";
		String product=HttpUtils.sendGetByTicket(HTTP+"/api/vip/product?code="+code,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
		//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
		//String custno=null;
		System.out.println("---------"+product);
		//JSONArray jsonArray = JSONArray.fromObject(comeFromBack);
		response.getWriter().print(product);
		
	}
	
	//礼品列表
		@RequestMapping("/services.action")
		public void services(HttpServletRequest request,HttpServletResponse response,String page,String size) throws Exception {
			page="1";
			size="10";
			String services=HttpUtils.sendGetByTicket(HTTP+"/api/vip/services?page="+page+"&size="+size,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
			//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
			//String custno=null;
			System.out.println("---------"+services);
			//JSONArray jsonArray = JSONArray.fromObject(comeFromBack);
			response.getWriter().print(services);
			
		}
		
		//礼品详情
				@RequestMapping("/servicesDetail.action")
				public void servicesDetail(HttpServletRequest request,HttpServletResponse response,String id) throws Exception {
					id="1551";
					String servicesDetail=HttpUtils.sendGetByTicket(HTTP+"/api/vip/services?id="+id,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
					//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
					//String custno=null;
					System.out.println("---------"+servicesDetail);
					//JSONArray jsonArray = JSONArray.fromObject("["+shares2+"]");
					response.getWriter().print(servicesDetail);
					
				}
				//积分兑换
				@RequestMapping("/tradelog.action")
				public void tradelog(HttpServletRequest request,HttpServletResponse response,String id) throws Exception {
					id="1551";
					String servicesDetail=HttpUtils.sendGetByTicket(HTTP+"/api/vip/services?id="+id,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
					//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
					//String custno=null;
					System.out.println("---------"+servicesDetail);
					//JSONArray jsonArray = JSONArray.fromObject("["+shares2+"]");
					response.getWriter().print(servicesDetail);
					
				}
				//找回密码
				@RequestMapping("/forget.action")
				public void forget(HttpServletRequest request,HttpServletResponse response,String id) throws Exception {
					id="1551";
					String servicesDetail=HttpUtils.sendGetByTicket(HTTP+"/api/vip/services?id="+id,"77E9DC8B8276355F33705A5E141AEA0019978837F0A82EA8B495722A2D32D91E51ABCE0592B7EB10F2D06BCEEE0067DCB25612579C5D2A4CCD26ECAC5143B58EADE7A75E863BDA4E60A21665B35359458A2A20832B011D8C059E81EB5BFCF7208BBAC2BE021503A2E1A740C6F77F95360C68E3F75216E3884C0D8C81C573795D859743094AAA8C0717A52261C9EE85F11DDF2862AD87938D749CC50954E3865DEFC1D46F84C5E44A6AC1DD615281B334BBBB10BF");
					//JSONObject jsStr = JSONObject.fromObject(s); //将字符串{“id”：1}
					//String custno=null;
					System.out.println("---------"+servicesDetail);
					//JSONArray jsonArray = JSONArray.fromObject("["+shares2+"]");
					response.getWriter().print(servicesDetail);
					
				}
	

}
