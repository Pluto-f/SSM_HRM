package com.hrm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hrm.domain.Condition;
import com.hrm.domain.PageModel;
import com.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/user/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("user/UserList");
			return mv;
		}

		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/user/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/user/listUser";
			return blank;
		}
		@RequestMapping(value="/user/listUser",method=RequestMethod.GET)
		 public String listUser(Model model,HttpServletRequest request){
			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<User> jobList = userService.getUserList(pageModel);
			System.out.println(jobList);

			model.addAttribute("list",jobList);
			model.addAttribute("pageModel",pageModel);
			return "user/UserList";
		}

		@RequestMapping(value="/user/selectUser",method=RequestMethod.GET)
		public String selectUser(Model model, Condition condition, HttpServletRequest request){
			System.out.println(condition);
			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<User> job_list = userService.getUserLikeList(condition,pageModel);
			System.out.println(job_list);

			model.addAttribute("list",job_list);
			model.addAttribute("pageModel",pageModel);
			return "user/UserList";
		}

		@RequestMapping(value="/user/addUser",method=RequestMethod.GET)
		 public String addUser(Model model,Integer id){
			System.out.println(id);
			if(id!=null){
				User user = userService.getUserInfo(id);
				model.addAttribute("user",user);
			}
			return "user/UserAdd";
		}
		@RequestMapping(value="/user/editUser",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv, @ModelAttribute User user , Integer id){
			System.out.println(id);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createDate = formatter.format(new Date());
			user.setCreateDate(createDate);
			user.setStatus(1);
			System.out.println(user);
			if(id!=null){
				userService.updateUserInfo(user);
			}else{
				userService.insertUserInfo(user);
			}
			mv.setViewName("redirect:/user/listUser");
			return mv;
		}
		@RequestMapping(value="/user/deleteUser",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				userService.deleteUserInfo(id);
			}
		}
}
