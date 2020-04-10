package com.hrm.controller;

import com.hrm.domain.Condition;
import com.hrm.domain.Document;
import com.hrm.domain.PageModel;
import com.hrm.domain.User;
import com.hrm.service.DocumentService;
import com.hrm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.SimpleFormatter;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;


    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value="/document/")
    public ModelAndView index1(ModelAndView mv){
        mv.setViewName("document/DocumentList");
        return mv;
    }
    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value="/document/{formName}")
    public String index2(@PathVariable String formName){
        String blank = "/document/listDocument";
        return blank;
    }

    @RequestMapping(value="/document/listDocument",method= RequestMethod.GET)
    public String listDocument(Model model, HttpServletRequest request){
        //获取pageIndex页码
        String pageIndex=request.getParameter("pageIndex");
        System.out.println(pageIndex);

        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

        List<Document> documentList = documentService.findDocument(pageModel);
        List<Document> documentList1 = new ArrayList<>();
        for (Document document: documentList) {
            document.setFilepath(Constants.readPath + document.getFilepath());
            documentList1.add(document);
        }

        model.addAttribute("documentList",documentList1);
        model.addAttribute("pageModel",pageModel);
        return "document/DocumentList";
    }

    @RequestMapping(value="/document/selectDocument",method= RequestMethod.GET)
    public String selectDocument(Model model, Condition condition, HttpServletRequest request){
        System.out.println(condition);
        //获取pageIndex页码
        String pageIndex=request.getParameter("pageIndex");
        System.out.println(pageIndex);

        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

        List<Document> documentList = documentService.findDocumentByContent(condition,pageModel);
        List<Document> documentList1 = new ArrayList<>();
        for (Document document: documentList) {
            document.setFilepath(Constants.readPath + document.getFilepath());
            documentList1.add(document);
        }
        model.addAttribute("documentList",documentList1);
        model.addAttribute("pageModel",pageModel);

        return "document/DocumentList";
    }

    @RequestMapping(value="/document/addDocument",method=RequestMethod.GET)
    public String addDocument(Model model,Integer id){
		System.out.println(id);
        if(id!=null){
            Document document = documentService.getDocumentInfo(id);
            model.addAttribute("document",document);
        }
        return "/document/DocumentAdd";
    }
    @RequestMapping(value="/document/editDocument",method=RequestMethod.POST)
    public ModelAndView editDocument(ModelAndView mv, @ModelAttribute Document document , Integer id, HttpSession session)throws Exception{

        User user = (User) session.getAttribute(Constants.USER_SESSION);
        System.out.println(user+"......");
        document.setUsername(user.getUsername());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = formatter.format(new Date());
        document.setCreate_date(createDate);

        /**
         * 上传文件
         */
        String savepath = Constants.savePath;

        String filename = document.getFile().getOriginalFilename();
        String fileType = filename.substring(filename.lastIndexOf("."),filename.length());
        System.out.println(fileType);
        String fileName = UUID.randomUUID() + fileType;

        File tempFile = new File(savepath+File.separator+fileName);
        tempFile.createNewFile();
        document.getFile().transferTo(tempFile);

        document.setFilename(filename);
        document.setFilepath(fileName);

        System.out.println(document);
        if(id!=null){
            documentService.updateDocument(document);
        }else{
            documentService.insertDocument(document);
        }
        mv.setViewName("redirect:/document/listDocument");
        return mv;
    }
    @RequestMapping(value="/document/deleteDocument",method=RequestMethod.GET)
    public void deleteDocument(Integer id){
        System.out.println(id);
        if(id!=null){
            documentService.deleteDocument(id);
        }
    }
}
