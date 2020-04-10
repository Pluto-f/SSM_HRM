package com.hrm.mapper;


import com.hrm.domain.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.JOBTABLE;


@Component
public interface JobMapper {

    @Select("select * from "+JOBTABLE+" LIMIT #{start},#{end} ")
    List<Job> findJob(@Param("start")int start, @Param("end")int end);

    @Select("SELECT COUNT(*) from "+JOBTABLE+"")
    int queryJobCount();

    @Select("SELECT COUNT(*) from "+JOBTABLE+" where name like CONCAT('%',#{content},'%') or remark like CONCAT('%',#{content},'%')")
    int queryJobCountByContent(@Param("content") String content);

    @Select("select * from "+JOBTABLE+" where name like CONCAT('%',#{content},'%') or remark like CONCAT('%',#{content},'%') LIMIT #{start},#{end}")
    List<Job> findJobByContent(@Param("content")String content,@Param("start")int start,@Param("end")int end);

    @Select("select * from "+JOBTABLE+" where id = #{id}")
    Job getJobInfo(Integer id);

    void updateJob(Job job);

    void insertJob(Job job);

    @Delete(" delete from "+JOBTABLE+" where id = #{id} ")
    void deleteJob(Integer id);

}
