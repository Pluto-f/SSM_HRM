package com.hrm.service;

import com.hrm.domain.User;

public interface LoginService {

    User login(String loginname, String password);

}
