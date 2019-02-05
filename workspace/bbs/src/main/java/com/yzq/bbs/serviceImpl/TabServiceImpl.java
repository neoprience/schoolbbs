package com.yzq.bbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.bbs.mapper.TabMapper;
import com.yzq.bbs.pojo.Tab;
import com.yzq.bbs.service.TabService;

@Service
public class TabServiceImpl implements TabService {

    @Autowired
    public TabMapper tabDao;

    public List<Tab> getAllTabs() {
        return tabDao.getAllTabs();
    }

    public Tab getByTabNameEn(String tabNameEn) {
        return tabDao.getByTabNameEn(tabNameEn);
    }
}
