package com.hrm.mapper;

import com.hrm.domain.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.DEPTTABLE;
import static com.hrm.util.Constants.USERTABLE;

@Component
public interface DeptMapper {

    @Select("select * from "+DEPTTABLE+" LIMIT #{start},#{end} ")
    List<Dept> findDept(@Param("start")int start,@Param("end")int end);

    @Select("SELECT COUNT(*) from "+DEPTTABLE+"")
    int queryDeptCount();

    @Select("SELECT COUNT(*) from "+DEPTTABLE+" where name like CONCAT('%',#{content},'%') or remark like CONCAT('%',#{content},'%')")
    int queryDeptCountByContent(@Param("content") String content);

    @Select("select * from "+DEPTTABLE+" where name like CONCAT('%',#{content},'%') or remark like CONCAT('%',#{content},'%') LIMIT #{start},#{end}")
    List<Dept> findDeptByContent(@Param("content")String content,@Param("start")int start,@Param("end")int end);

    @Select("select * from "+DEPTTABLE+" where id = #{id}")
    Dept getDeptInfo(Integer id);

    void updateDept(Dept dept);

    void insertDept(Dept dept);

    @Delete(" delete from "+DEPTTABLE+" where id = #{id} ")
    void deleteDept(Integer id);

}
