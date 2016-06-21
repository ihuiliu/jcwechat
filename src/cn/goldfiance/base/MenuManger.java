package cn.goldfiance.base;

import org.apache.log4j.Logger;
import org.sword.lang.HttpUtils;
import org.sword.wechat4j.token.TokenProxy;

/**
 * 菜单管理
 * @author Administrator
 *
 */
public class MenuManger {
	Logger logger = Logger.getLogger(MenuManger.class);
	private String accessToken;
	private static final String CREAT_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	public MenuManger() {
		this.accessToken = TokenProxy.accessToken();
	}
	/**
	 * 创建菜单
	 * @return
	 */
	public void createMenu(String  menu) {
		String resultStr = HttpUtils.post(CREAT_MENU+this.accessToken,menu);
		logger.info("return data "+resultStr);
	}

}
