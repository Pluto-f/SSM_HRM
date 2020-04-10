package com.hrm.controller;


import com.hrm.domain.Job;
import com.hrm.domain.PageModel;
import com.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;

	// 如果在目录下输入为空，则跳转到指定链接
	@RequestMapping(value="/job/")
	public ModelAndView index1(ModelAndView mv){
		mv.setViewName("job/JobList");
		return mv;
	}
	// 如果在目录下输入任何不存在的参数，则跳转到list
	@RequestMapping(value="/job/{formName}")
	public String index2(@PathVariable String formName){
		String blank = "/job/listJob";
		return blank;
	}

	@RequestMapping(value="/job/listJob",method= RequestMethod.GET)
	public String listJob(Model model, HttpServletRequest request){
		//获取pageIndex页码
		String pageIndex=request.getParameter("pageIndex");
		System.out.println(pageIndex);

		PageModel pageModel=new PageModel();
		pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

		List<Job> jobList = jobService.findJob(pageModel);

		model.addAttribute("jobList",jobList);
		model.addAttribute("pageModel",pageModel);
		return "job/JobList";
	}

	@RequestMapping(value="/job/selectJob",method= RequestMethod.GET)
	public String selectJob(Model model, String content,HttpServletRequest request){
		//获取pageIndex页码
		String pageIndex=request.getParameter("pageIndex");
		System.out.println(pageIndex);

		PageModel pageModel=new PageModel();
		pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

		List<Job> jobList = jobService.findJobByContent(content,pageModel);

		model.addAttribute("jobList",jobList);
		model.addAttribute("pageModel",pageModel);

		return "job/JobList";
	}

	@RequestMapping(value="/job/addJob",method=RequestMethod.GET)
	public String addJob(Model model,Integer id){
		System.out.println(id);
		if(id!=null){
			Job job = jobService.getJobInfo(id);
			model.addAttribute("job",job);
		}
		return "/job/JobAdd";
	}
	@RequestMapping(value="/job/editJob",method=RequestMethod.POST)
	public ModelAndView editJob(ModelAndView mv, @ModelAttribute Job job , Integer id){
		System.out.println(id);
		if(id!=null){
			jobService.updateJob(job);
		}else{
			jobService.insertJob(job);
		}
		mv.setViewName("redirect:/job/listJob");
		return mv;
	}
	@RequestMapping(value="/job/deleteJob",method=RequestMethod.GET)
	public void deleteJob(Integer id){
		System.out.println(id);
		if(id!=null){
			jobService.deleteJob(id);
		}
	}
}
