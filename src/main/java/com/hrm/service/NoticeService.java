package com.hrm.service;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.domain.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getNoticeList(PageModel pageModel);

    List<Notice> getNoticeListByContent(Condition condition, PageModel pageModel);

    Notice getNoticeInfo(Integer id);

    void updateNoticeInfo(Notice notice);

    void insertNoticeInfo(Notice notice);

    void deleteNoticeInfo(Integer id);
}
