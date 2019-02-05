package com.yzq.bbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.bbs.mapper.AdminMapper;
import com.yzq.bbs.pojo.User;
import com.yzq.bbs.util.MD5Util;
import com.yzq.bbs.util.UUIDUtil;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	public int checkUserName(String userName) {
		int exists=adminMapper.checkUserName(userName);
		return exists; 
	}
	public int regist(User user) {
		user.setUserId(UUIDUtil.getUUID());
		user.setUserPassword(MD5Util.md5(user.getUserPassword()));
		return adminMapper.insertUser(user);
	}
	public User login(User user){
//		user.setUserPassword(MD5Util.md5(user.getUserPassword()));
		User exists=adminMapper.checkLogin(user);
		return exists;
	}
}
