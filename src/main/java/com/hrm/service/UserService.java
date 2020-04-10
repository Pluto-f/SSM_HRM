package com.hrm.service;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUserList(PageModel pageModel);

    List<User> getUserLikeList(Condition condition, PageModel pageModel);

    User getUserInfo(Integer id);

    void updateUserInfo(User user);

    void insertUserInfo(User user);

    void deleteUserInfo(Integer id);
}
