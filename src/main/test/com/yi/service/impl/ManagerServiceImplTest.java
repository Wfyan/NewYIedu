package com.yi.service.impl;

import com.yi.entity.TbManager;
import com.yi.mapper.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImplTest extends BaseTest {

    @Autowired
    private ManagerServiceImpl  managerService;

    @Test
    public void testGetByName() throws Exception{
        String name = "管理员1";
        int id = 1;
        TbManager manager = managerService.getByName(name);
        System.out.println(manager.getPassword());

    }


}