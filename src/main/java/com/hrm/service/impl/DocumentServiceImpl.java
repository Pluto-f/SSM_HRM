package com.hrm.service.impl;

import com.hrm.domain.Condition;
import com.hrm.domain.Document;
import com.hrm.domain.PageModel;
import com.hrm.mapper.DocumentMapper;
import com.hrm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;


    @Override
    public List<Document> findDocument(PageModel pageModel) {
        int totalRecordSum = documentMapper.queryDocumentCount();
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        return documentMapper.findDocument(start,end);
    }

    @Override
    public List<Document> findDocumentByContent(Condition condition, PageModel pageModel) {
        int totalRecordSum = documentMapper.queryDocumentCountByContent(condition);
        pageModel.setTotalRecordSum(totalRecordSum);
        int start = 0;
        if (pageModel.getStartRowNum()>=0){
            start = pageModel.getStartRowNum();
        }
        int end = start + pageModel.getPageSize();
        condition.setStart(start);
        condition.setEnd(end);
        System.out.println(condition);
        return documentMapper.findDocumentByContent(condition);
    }

    @Override
    public Document getDocumentInfo(Integer id) {
        return documentMapper.getDocumentInfo(id);
    }

    @Override
    public void insertDocument(Document document) {
        documentMapper.insertDocument(document);
    }

    @Override
    public void updateDocument(Document document) {
        documentMapper.updateDocument(document);
    }

    @Override
    public void deleteDocument(Integer id) {
        documentMapper.deleteDocument(id);
    }
}
