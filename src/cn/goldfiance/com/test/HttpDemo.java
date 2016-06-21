package cn.goldfiance.com.test;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.goldfiance.base.Config;
import cn.goldfiance.base.LoginBack;
import cn.goldfiance.base.ReturnResult;
import cn.goldfiance.com.domain.Broker;
import cn.goldfiance.com.domain.LoginData;
import cn.goldfiance.com.domain.LoginMobileno;
import cn.goldfiance.com.domain.User;
import cn.goldfiance.com.utils.HttpUtils;

import com.alibaba.fastjson.JSON;

public class HttpDemo {

	public static void main(String[] args) {

		/*
		 * ReturnResult returnResult=new ReturnResult();
		 * returnResult.setResult(Config.SUCCESS);
		 * returnResult.setContent("nihao"); JSONObject
		 * j=JSONObject.fromObject(returnResult);
		 * System.out.println(j.toString());
		 */
		LoginMobileno loginRequest = new LoginMobileno();

		loginRequest.setPassword("006302");
		loginRequest.setMobileno("18268323020");
		// LoginData data=new LoginData();
		// data.setData(loginRequest);
		JSONArray jsonArray = JSONArray.fromObject(loginRequest);
		// jsonArray.getString(index)
		// System.out.println(jsonArray.get(0));
		String a = jsonArray.getString(0);
		System.out.println(a);
		// System.out.println(a);
		// jsonArray.get(0);
		String s = HttpUtils.sendPost(
				"http://api.gold-finance.com.cn:8008/api/vip/login", a);
		System.out.println("---------" + s);
		com.alibaba.fastjson.JSONObject j = JSON.parseObject(s);
		// JSONObject j=JSONObject.fromObject(s);
		System.out.println(j.getString("result"));
		System.out.println(j.getString("content"));
		String user = j.getString("content");
		com.alibaba.fastjson.JSONObject jj = JSON.parseObject(user);

		String u = jj.getString("user");
		System.out.println("+++++++++" + u);

		com.alibaba.fastjson.JSONObject fist = JSON.parseObject(u);

		String firstBroker = fist.getString("firstBroker");
		JSONObject obj = new JSONObject().fromObject(u);// 将json字符串转换为json对象
		// Map<String, Class> classMap = new HashMap<String, Class>();
		// classMap.put("firstBroker",Broker.class);
		// 将json对象转换为java对象
		User use = (User) JSONObject.toBean(obj, User.class);// 将建json对象转换为Person对象

		System.out.println(use);
		com.alibaba.fastjson.JSONObject jju = JSON.parseObject(u);
		String custno = jju.getString("custno");
		System.out.println(custno);

		// String
		// str="{\"student\":[{\"name\":\"leilei\",\"age\":23},{\"name\":\"leilei02\",\"age\":23}]}";
		// Student stu = null;
		// List<Student> list = null;
		/*
		 * try { ObjectMapper objectMapper=new ObjectMapper(); User
		 * studentList=objectMapper.readValue(u, User.class);
		 * //list=studentList.getStudent(); System.out.println(studentList); }
		 * catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// say();
		// {
		/*
		 * "data": { "mobileno": "13323456789", "password": "041919" } } OR {
		 * "data": { "identityno": "411526199405041919", "password": "041919" }
		 * }
		 */

		// System.out.println("-----------"+s);
	}

	public static void say() {
		ReturnResult returnResult = new ReturnResult();
		LoginBack back = new LoginBack();
		back.setComefrom("1");
		back.setMsg("登录成功");
		returnResult.setResult(Config.SUCCESS);
		returnResult.setContent(back);
		returnResult.setResult(Config.UNRISK);
		returnResult.setContent("未作风险测评");
		returnResult.setResult(Config.ERROR);
		returnResult.setContent("登录失败");
		JSONObject json = JSONObject.fromObject(returnResult);// 将java对象转换为json对象
		String str = json.toString();
		// JSONArray jsonArray=JSONArray.fromObject(returnResult);
		System.out.println(str);
	}

}
