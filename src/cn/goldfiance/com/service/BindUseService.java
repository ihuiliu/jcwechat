package cn.goldfiance.com.service;

import cn.goldfiance.com.domain.BindUser;

public interface BindUseService {
	
	public BindUser getBindUserByOpenid(String openid);
	public void insertBindUser(BindUser bindUser);
	public BindUser getBindUserByCustno(String custno);

}
