package com.yzq.bbs.backcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzq.bbs.pojo.User;
import com.yzq.bbs.service.AdminService;
import com.yzq.bbs.vo.SysResult;

@Controller
public class BackLoginController {
	
	@Autowired
	AdminService adminService;

	@RequestMapping("admin/login")
	@ResponseBody
	public SysResult adminLogin(User user,HttpSession session){
		User exists=adminService.login(user);
		SysResult result=new SysResult();
		
		if(null==exists){
			result.setStatus(0);
			result.setMsg("登录失败");
			return result;
		}else{
			session.setAttribute("userName", exists.getUserName());
			session.setAttribute("userId", exists.getUserId());
			result.setStatus(1);
			System.out.println("success");
			return result;
		}
	}
}
