package com.yzq.bbs.service;

import com.yzq.bbs.pojo.LoginLog;

public interface LoginLogService {


    /**
     * 插入一条登录日志
     */
    boolean addLog(LoginLog log);
}
