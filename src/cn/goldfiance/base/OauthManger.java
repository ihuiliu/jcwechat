package cn.goldfiance.base;
import org.apache.log4j.Logger;
import org.sword.wechat4j.common.Config;

import cn.goldfiance.com.utils.HttpUtils;
/**
 * 
 * @author liuhui
 * 网页授权Manager
 *
 */
public class OauthManger {
	
	private static Logger logger = Logger.getLogger(OauthManger.class);
	
	private static final String ACCESS_TOKEN =" https://api.weixin.qq.com/sns/oauth2/access_token";
	/**
	 * 网页授权
	 * @return
	 */
	public String getOpenid(String  code) {
		String resultStr = HttpUtils.sendGet(ACCESS_TOKEN,"appid="+Config.instance().getAppid()+"&secret="+Config.instance().getAppSecret()+"&code="+code+"&grant_type=authorization_code");
		logger.info("return data "+resultStr);
		return resultStr;
	}
	
}
