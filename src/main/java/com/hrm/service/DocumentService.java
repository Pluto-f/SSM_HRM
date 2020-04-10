package com.hrm.service;


import com.hrm.domain.Condition;
import com.hrm.domain.Document;
import com.hrm.domain.PageModel;

import java.util.List;

public interface DocumentService {

    List<Document> findDocument(PageModel pageModel);

    List<Document> findDocumentByContent(Condition condition, PageModel pageModel);

    Document getDocumentInfo(Integer id);

    void insertDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(Integer id);



}
