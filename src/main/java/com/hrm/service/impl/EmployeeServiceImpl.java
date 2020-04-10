package com.hrm.service.impl;

import com.hrm.domain.*;
import com.hrm.mapper.EmployeeMapper;
import com.hrm.service.EmployeeService;
import com.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> findEmployee(PageModel pageModel) {
        int totalRecordSum = employeeMapper.queryEmployeeCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return employeeMapper.findEmployee(start,end);
    }

    @Override
    public List<Employee> findEmployeeByContent(Condition condition, PageModel pageModel) {
        int totalRecordSum = employeeMapper.queryEmployeeCountByContent(condition);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        condition.setStart(start);
        condition.setEnd(end);
        return employeeMapper.findEmployeeByContent(condition);
    }

    @Override
    public Dept findDeptById(Integer id) {
        return employeeMapper.findDeptById(id);
    }

    @Override
    public Job findJobById(Integer id) {
        return employeeMapper.findJobById(id);
    }

    @Override
    public Employee getEmployeeInfo(Integer id) {
        return employeeMapper.getEmployeeInfo(id);
    }

    @Override
    public List<Dept> findAllDept() {
        return employeeMapper.findAllDept();
    }

    @Override
    public List<Job> findAllJob() {
        return employeeMapper.findAllJob();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }
}
