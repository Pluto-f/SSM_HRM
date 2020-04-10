package com.hrm.service.impl;

import com.hrm.domain.Dept;
import com.hrm.domain.PageModel;
import com.hrm.mapper.DeptMapper;
import com.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> findDept(PageModel pageModel) {
        int totalRecordSum = deptMapper.queryDeptCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return deptMapper.findDept(start,end);
    }

    @Override
    public List<Dept> findDeptByContent(String content, PageModel pageModel) {
        int totalRecordSum = deptMapper.queryDeptCountByContent(content);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return deptMapper.findDeptByContent(content,start,end);
    }

    @Override
    public Dept getDeptInfo(Integer id) {
        return deptMapper.getDeptInfo(id);
    }

    @Override
    public void insertDept(Dept dept) {
        deptMapper.insertDept(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
    }
}
