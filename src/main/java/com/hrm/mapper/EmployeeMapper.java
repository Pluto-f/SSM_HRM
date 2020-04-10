package com.hrm.mapper;


import com.hrm.domain.Condition;
import com.hrm.domain.Dept;
import com.hrm.domain.Employee;
import com.hrm.domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.*;

@Component
public interface EmployeeMapper {

//    @Select("select * from "+EMPLOYEETABLE+" LIMIT #{start},#{end} ")
    List<Employee> findEmployee(@Param("start") int start, @Param("end") int end);

    @Select("SELECT COUNT(*) from "+EMPLOYEETABLE+"")
    int queryEmployeeCount();


    int queryEmployeeCountByContent(Condition condition);

    List<Employee> findEmployeeByContent(Condition condition);

    @Select("SELECT * FROM "+DEPTTABLE+" WHERE id = #{id}")
    Dept findDeptById(@Param("id")Integer id);

    @Select("SELECT * FROM "+JOBTABLE+" WHERE id = #{id}")
    Job findJobById(@Param("id")Integer id);

    Employee getEmployeeInfo(Integer id);

    @Select("select * from "+DEPTTABLE+" ")
    List<Dept> findAllDept();

    @Select("select * from "+JOBTABLE+" ")
    List<Job> findAllJob();

    void updateEmployee(Employee employee);

    void insertEmployee(Employee employee);

    @Delete(" delete from "+EMPLOYEETABLE+" where id = #{id} ")
    void deleteEmployee(Integer id);

}
