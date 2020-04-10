package com.hrm.controller;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.domain.Notice;
import com.hrm.domain.User;
import com.hrm.service.NoticeService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

		// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/notice/")
		 public ModelAndView index1(ModelAndView mv){
			mv.setViewName("notice/NoticeList");
			return mv;
		}

		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/notice/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/notice/listNotice";
			return blank;
		}
		@RequestMapping(value="/notice/listNotice",method=RequestMethod.GET)
		 public String listNotice(Model model,HttpServletRequest request){
			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<Notice> noticeList = noticeService.getNoticeList(pageModel);
			System.out.println(noticeList);

			model.addAttribute("noticeList",noticeList);
			model.addAttribute("pageModel",pageModel);
			return "notice/NoticeList";
		}

		@RequestMapping(value="/notice/selectNotice",method=RequestMethod.GET)
		public String selectNotice(Model model, Condition condition, HttpServletRequest request){

			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<Notice> noticeList = noticeService.getNoticeListByContent(condition,pageModel);
			System.out.println(noticeList);

			model.addAttribute("noticeList",noticeList);
			model.addAttribute("pageModel",pageModel);
			return "notice/NoticeList";
		}

		@RequestMapping(value="/notice/addNotice",method=RequestMethod.GET)
		 public String addNotice(Model model,Integer id){
			System.out.println(id);
			if(id!=null){
				Notice notice = noticeService.getNoticeInfo(id);
				model.addAttribute("notice",notice);
			}
			return "notice/NoticeAdd";
		}
		@RequestMapping(value="/notice/editNotice",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv, @ModelAttribute Notice notice , Integer id, HttpSession session){
			System.out.println(id);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createDate = formatter.format(new Date());
			notice.setCreate_date(createDate);
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			notice.setUsername(user.getUsername());
			System.out.println(notice);
			if(id!=null){
				noticeService.updateNoticeInfo(notice);
			}else{
				noticeService.insertNoticeInfo(notice);
			}
			mv.setViewName("redirect:/notice/listNotice");
			return mv;
		}
		@RequestMapping(value="/notice/deleteNotice",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				noticeService.deleteNoticeInfo(id);
			}
		}
}
