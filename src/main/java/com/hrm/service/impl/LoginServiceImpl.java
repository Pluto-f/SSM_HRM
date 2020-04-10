package com.hrm.service.impl;

import com.hrm.domain.User;
import com.hrm.mapper.LoginMapper;
import com.hrm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(String loginname, String password) {
        User user = loginMapper.get_login(loginname,password);
        return user;
    }
}
