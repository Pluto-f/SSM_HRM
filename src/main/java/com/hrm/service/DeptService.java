package com.hrm.service;


import com.hrm.domain.Dept;
import com.hrm.domain.PageModel;

import java.util.List;

public interface DeptService {

    List<Dept> findDept(PageModel pageModel);

    List<Dept> findDeptByContent(String content,PageModel pageModel);

    Dept getDeptInfo(Integer id);

    void insertDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDept(Integer id);



}
