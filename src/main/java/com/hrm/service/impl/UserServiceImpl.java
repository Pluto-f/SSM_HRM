package com.hrm.service.impl;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.domain.User;
import com.hrm.mapper.UserMapper;
import com.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(PageModel pageModel) {
        int totalRecordSum = userMapper.queryUserCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
//        System.out.println(start+","+end);
        return userMapper.getUserList(start,end);
    }

    @Override
    public List<User> getUserLikeList(Condition condition, PageModel pageModel) {
        int totalRecordSum = userMapper.queryUserCountByContent(condition);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        condition.setStart(start);
        condition.setEnd(end);
        return userMapper.getUserLikeList(condition);
    }

    @Override
    public User getUserInfo(Integer id) {
        return userMapper.getUserInfo(id);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public void insertUserInfo(User user) {
        userMapper.insertUserInfo(user);
    }

    @Override
    public void deleteUserInfo(Integer id) {
        userMapper.deleteUserInfo(id);
    }
}
