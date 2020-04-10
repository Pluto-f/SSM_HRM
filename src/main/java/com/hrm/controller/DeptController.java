package com.hrm.controller;

import com.hrm.domain.Dept;
import com.hrm.domain.PageModel;
import com.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value="/dept/")
    public ModelAndView index2(ModelAndView mv){
        mv.setViewName("dept/DeptList");
        return mv;
    }
    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value="/dept/{formName}")
    public String index2(@PathVariable String formName){
        String blank = "/dept/listDept";
        return blank;
    }

    @RequestMapping(value="/dept/listDept",method= RequestMethod.GET)
    public String listDept(Model model, HttpServletRequest request){
        //获取pageIndex页码
        String pageIndex=request.getParameter("pageIndex");
        System.out.println(pageIndex);

        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

        List<Dept> deptList = deptService.findDept(pageModel);

        model.addAttribute("deptList",deptList);
        model.addAttribute("pageModel",pageModel);
        return "dept/DeptList";
    }

    @RequestMapping(value="/dept/selectDept",method= RequestMethod.GET)
    public String selectDept(Model model, String content,HttpServletRequest request){
        //获取pageIndex页码
        String pageIndex=request.getParameter("pageIndex");
        System.out.println(pageIndex);

        PageModel pageModel=new PageModel();
        pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

        List<Dept> deptList = deptService.findDeptByContent(content,pageModel);

        model.addAttribute("deptList",deptList);
        model.addAttribute("pageModel",pageModel);

        return "dept/DeptList";
    }

    @RequestMapping(value="/dept/addDept",method=RequestMethod.GET)
    public String addDept(Model model,Integer id){
		System.out.println(id);
        if(id!=null){
            Dept dept = deptService.getDeptInfo(id);
            model.addAttribute("dept",dept);
        }
        return "/dept/DeptAdd";
    }
    @RequestMapping(value="/dept/editDept",method=RequestMethod.POST)
    public ModelAndView editDept(ModelAndView mv, @ModelAttribute Dept dept , Integer id){
        System.out.println(id);
        if(id!=null){
            deptService.updateDept(dept);
        }else{
            deptService.insertDept(dept);
        }
        mv.setViewName("redirect:/dept/listDept");
        return mv;
    }
    @RequestMapping(value="/dept/deleteDept",method=RequestMethod.GET)
    public void deleteDept(Integer id){
        System.out.println(id);
        if(id!=null){
            deptService.deleteDept(id);
        }
    }
}
