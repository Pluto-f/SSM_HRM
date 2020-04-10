package com.hrm.mapper;



import com.hrm.domain.Condition;
import com.hrm.domain.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.NOTICETABLE;

@Component
public interface NoticeMapper {

    @Select("SELECT * from "+NOTICETABLE+" LIMIT #{start},#{end}")
    List<Notice> getNoticeList(@Param("start") int start, @Param("end") int end);

    @Select("SELECT COUNT(*) from "+NOTICETABLE+"")
    int queryNoticeCount();

    int queryNoticeCountByContent(Condition condition);

    List<Notice> getNoticeListByContent(Condition condition);

    void insertNoticeInfo(Notice notice);

    @Select("SELECT * from "+NOTICETABLE+" WHERE id= #{id}")
    Notice getNoticeInfo(Integer id);

    void updateNoticeInfo(Notice notice);
    // 根据id删除部门
    @Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
    void deleteNoticeInfo(Integer id);

}
