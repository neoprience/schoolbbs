package com.yzq.bbs.service;


import java.util.List;

import com.yzq.bbs.pojo.Tab;

public interface TabService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
