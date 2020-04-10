package com.hrm.service;


import com.hrm.domain.*;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployee(PageModel pageModel);

    List<Employee> findEmployeeByContent(Condition condition, PageModel pageModel);

    Dept findDeptById(Integer id);

    Job findJobById(Integer id);

    Employee getEmployeeInfo(Integer id);

    List<Dept> findAllDept();

    List<Job> findAllJob();

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);



}
