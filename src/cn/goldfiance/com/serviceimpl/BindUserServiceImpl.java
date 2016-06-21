package cn.goldfiance.com.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.goldfiance.com.domain.BindUser;
import cn.goldfiance.com.mapper.BindUserMapper;
import cn.goldfiance.com.service.BindUseService;
@Service
public class BindUserServiceImpl implements BindUseService{

	
	@Resource
	private BindUserMapper mapper;
	@Override
	public BindUser getBindUserByOpenid(String openid) {
		return mapper.getBindUserByOpenid(openid);
	}
	@Override
	public void insertBindUser(BindUser bindUser) {
		mapper.insertBindUser(bindUser);
	}
	@Override
	public BindUser getBindUserByCustno(String custno) {
		return null;
	}

}
