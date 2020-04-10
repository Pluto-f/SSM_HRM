package com.hrm.service.impl;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.domain.Notice;
import com.hrm.mapper.NoticeMapper;
import com.hrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList(PageModel pageModel) {
        int totalRecordSum = noticeMapper.queryNoticeCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();

        return noticeMapper.getNoticeList(start,end);
    }

    @Override
    public List<Notice> getNoticeListByContent(Condition condition, PageModel pageModel) {
        int totalRecordSum = noticeMapper.queryNoticeCountByContent(condition);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        condition.setStart(start);
        condition.setEnd(end);
        return noticeMapper.getNoticeListByContent(condition);
    }

    @Override
    public Notice getNoticeInfo(Integer id) {
        return noticeMapper.getNoticeInfo(id);
    }

    @Override
    public void updateNoticeInfo(Notice notice) {
        noticeMapper.updateNoticeInfo(notice);
    }

    @Override
    public void insertNoticeInfo(Notice notice) {
        noticeMapper.insertNoticeInfo(notice);
    }

    @Override
    public void deleteNoticeInfo(Integer id) {
        noticeMapper.deleteNoticeInfo(id);
    }
}
