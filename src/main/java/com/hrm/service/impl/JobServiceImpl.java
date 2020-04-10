package com.hrm.service.impl;

import com.hrm.domain.Job;
import com.hrm.domain.PageModel;
import com.hrm.mapper.JobMapper;
import com.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;


    @Override
    public List<Job> findJob(PageModel pageModel) {
        int totalRecordSum = jobMapper.queryJobCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return jobMapper.findJob(start,end);
    }

    @Override
    public List<Job> findJobByContent(String content, PageModel pageModel) {
        int totalRecordSum = jobMapper.queryJobCountByContent(content);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return jobMapper.findJobByContent(content,start,end);
    }

    @Override
    public Job getJobInfo(Integer id) {
        return jobMapper.getJobInfo(id);
    }

    @Override
    public void insertJob(Job job) {
        jobMapper.insertJob(job);
    }

    @Override
    public void updateJob(Job job) {
        jobMapper.updateJob(job);
    }

    @Override
    public void deleteJob(Integer id) {
        jobMapper.deleteJob(id);
    }
}
