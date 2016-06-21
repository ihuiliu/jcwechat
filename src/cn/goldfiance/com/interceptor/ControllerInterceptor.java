package cn.goldfiance.com.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.goldfiance.base.OauthManger;
import cn.goldfiance.base.OauthResponse;
import cn.goldfiance.com.domain.BindUser;
import cn.goldfiance.com.service.BindUseService;

/**
 * 
 * @author liuhui 2016 6 16
 *
 *         拦截特有的请求
 */
public class ControllerInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private BindUseService bindUseService;

	/**
	 * 
	 * 在Controller方法前进行拦截
	 */

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("--------------------+preHandle");

		// 得到请求地址之后，放入session中
		String http = request.getRequestURI();
		if ("/wechat/user/haha.action".equals(http)) {
			request.getSession().setAttribute("comefrom", "1");
		}
		// User user=(User) request.getSession().getAttribute("user");
		// 项目名
		String contextPath = request.getContextPath();
		String custno = (String) request.getSession().getAttribute("custno");
		//String openid = (String) request.getSession().getAttribute("openid");
		String openid=null;
		if(null!=custno){
			BindUser bindUser = bindUseService.getBindUserByCustno(custno);
			request.getSession().setAttribute("bindUser", bindUser);
			request.getSession().setAttribute("custno", custno);
			return true;
		}else{
			String code = request.getParameter("code");
			OauthManger manger = new OauthManger();
			String ret = manger.getOpenid(code);
			OauthResponse oauthResponse = (OauthResponse) JSONObject.toBean(
					JSONObject.fromObject(ret), OauthResponse.class);
			if (oauthResponse.getOpenid() != null) {
				request.getSession().setAttribute("openid",
						oauthResponse.getOpenid());
				openid = oauthResponse.getOpenid();
			}
			//openid="10012051";
			BindUser bindUser = bindUseService.getBindUserByOpenid(openid);
			// 没绑定
			if (null == bindUser) {
				//跳到绑定页面
				response.sendRedirect(contextPath + "/jsp/haha.jsp");
				return false;
			} else {
				// 绑定
				return true;
			}
		}
		/*if (null == openid) {
			String code = request.getParameter("code");
			OauthManger manger = new OauthManger();
			String ret = manger.getOpenid(code);
			OauthResponse oauthResponse = (OauthResponse) JSONObject.toBean(
					JSONObject.fromObject(ret), OauthResponse.class);
			if (oauthResponse.getOpenid() != null) {
				request.getSession().setAttribute("openid",
						oauthResponse.getOpenid());
				openid = oauthResponse.getOpenid();
			}
			//openid="10012051";
			BindUser bindUser = bindUseService.getBindUserByOpenid(openid);
			// 没绑定
			if (null == bindUser) {
				//跳到绑定页面
				response.sendRedirect(contextPath + "/jsp/haha.jsp");
				return false;
			} else {
				// 绑定
				request.getSession().setAttribute("custno", 
						bindUser.getCustno());
				return true;
			}

		} else {
			return true;
		}*/

		/*
		 * String code = request.getParameter("code"); BindUser
		 * bindUser=bindUseService.getBindUserByOpenid("2");
		 * System.out.println(bindUser);
		 * 
		 * System.out.println("-------------"+http);
		 */

	}

	/**
	 * 
	 * 在Controller方法后进行拦截
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("ControllerInterceptor.afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("ControllerInterceptor.postHandle()");
	}

}
