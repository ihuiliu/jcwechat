package cn.goldfiance.com.mapper;

import org.springframework.transaction.annotation.Transactional;

import cn.goldfiance.com.domain.BindUser;
@Transactional
public interface BindUserMapper {
	public BindUser getBindUserByOpenid(String openid);
	
	public void insertBindUser(BindUser bindUser);
	
	public BindUser getBindUserByCustno(String custno);

}
