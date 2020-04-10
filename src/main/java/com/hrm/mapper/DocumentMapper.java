package com.hrm.mapper;

import com.hrm.domain.Condition;
import com.hrm.domain.Document;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.DOCUMENTTABLE;

@Component
public interface DocumentMapper {

    @Select("select * from "+DOCUMENTTABLE+" LIMIT #{start},#{end} ")
    List<Document> findDocument(@Param("start") int start, @Param("end") int end);

    @Select("SELECT COUNT(*) from "+DOCUMENTTABLE+"")
    int queryDocumentCount();

    int queryDocumentCountByContent(Condition condition);

    List<Document> findDocumentByContent(Condition condition);

    @Select("select * from "+DOCUMENTTABLE+" where id = #{id}")
    Document getDocumentInfo(Integer id);

    void updateDocument(Document document);

    void insertDocument(Document document);

    @Delete(" delete from "+DOCUMENTTABLE+" where id = #{id} ")
    void deleteDocument(Integer id);

}
