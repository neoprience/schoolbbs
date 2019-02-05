package com.yzq.bbs.mapper;

import com.yzq.bbs.pojo.User;

public interface AdminMapper {
	
	int checkUserName(String userName);

	int insertUser(User user);

	User checkLogin(User user);
}
