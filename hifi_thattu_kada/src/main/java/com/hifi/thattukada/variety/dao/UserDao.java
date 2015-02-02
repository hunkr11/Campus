package com.hifi.thattukada.variety.dao;

import java.util.List;

import com.hifi.thattukada.variety.entity.UserEntity;
import com.hifi.thattukada.variety.pojo.UserDetailsPojo;
import com.hifi.thattukada.variety.vo.UserVO;

public interface UserDao {
	public List userList();
	public boolean userLogin(UserVO userVo);
	public String userRegister(UserVO userVo,UserEntity userPojo);
}
