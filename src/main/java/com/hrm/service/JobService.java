package com.hrm.service;

import com.hrm.domain.Job;
import com.hrm.domain.PageModel;

import java.util.List;

public interface JobService {

    List<Job> findJob(PageModel pageModel);

    List<Job> findJobByContent(String content, PageModel pageModel);

    Job getJobInfo(Integer id);

    void insertJob(Job job);

    void updateJob(Job job);

    void deleteJob(Integer id);
    
}
