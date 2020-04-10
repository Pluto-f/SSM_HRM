package com.hrm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hrm.domain.*;
import com.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

		// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/employee/")
		 public ModelAndView index1(ModelAndView mv){
			mv.setViewName("employee/EmployeeList");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/employee/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/employee/listEmployee";
			return blank;
		}
		@RequestMapping(value="/employee/listEmployee",method=RequestMethod.GET)
		 public String listEmployee(Model model, HttpServletRequest request){
			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<Employee> employeeList = employeeService.findEmployee(pageModel);
			List<Employee> employeeList1 = new ArrayList<>();
			for (Employee employee:employeeList) {
				employee.setDept(employeeService.findDeptById(employee.getDeptId()));
				employee.setJob(employeeService.findJobById(employee.getJobId()));
				employeeList1.add(employee);
			}
			List<Dept> deptList = employeeService.findAllDept();
			List<Job> jobList = employeeService.findAllJob();
			model.addAttribute("job_list", jobList);
			model.addAttribute("dept_list",deptList);
			System.out.println(employeeList1);
			model.addAttribute("employeeList",employeeList1);
			model.addAttribute("pageModel",pageModel);

			return "employee/EmployeeList";
		}
		@RequestMapping(value="/employee/selectEmployee",method=RequestMethod.GET)
		public String selectEmployee(Model model, Condition condition,HttpServletRequest request){

			System.out.println("aaaaaaaaaaaaaaa"+condition);

			//获取pageIndex页码
			String pageIndex=request.getParameter("pageIndex");
			System.out.println(pageIndex);

			PageModel pageModel=new PageModel();
			pageModel.setPageIndex(pageIndex !=null && !pageIndex.equals("") ? Integer.parseInt(pageIndex) : 1 );

			List<Employee> employeeList = employeeService.findEmployeeByContent(condition,pageModel);
			List<Employee> employeeList1 = new ArrayList<>();
			for (Employee employee:employeeList) {
				employee.setDept(employeeService.findDeptById(employee.getDeptId()));
				employee.setJob(employeeService.findJobById(employee.getJobId()));
				employeeList1.add(employee);
			}

			List<Dept> deptList = employeeService.findAllDept();
			List<Job> jobList = employeeService.findAllJob();
			model.addAttribute("job_list", jobList);
			model.addAttribute("dept_list",deptList);
			model.addAttribute("employeeList",employeeList1);
			model.addAttribute("pageModel",pageModel);

			return "employee/EmployeeList";
		}

		@RequestMapping(value="/employee/addEmployee",method=RequestMethod.GET)
		 public String addEmployee(Model model,Integer id){
			if(id!=null){
				Employee employee = employeeService.getEmployeeInfo(id);
				model.addAttribute("employee",employee);
			}
			List<Dept> deptList = employeeService.findAllDept();
			List<Job> jobList = employeeService.findAllJob();
			model.addAttribute("job_list", jobList);
			model.addAttribute("dept_list",deptList);
			return "/employee/EmployeeAdd";
		}
		@RequestMapping(value="/employee/editEmployee",method=RequestMethod.POST)
		 public ModelAndView editEmployee(ModelAndView mv,@ModelAttribute Employee employee ,Integer id){
			System.out.println(id);
			System.out.println("add" + employee);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String createDate = formatter.format(new Date());
			employee.setCreateDate(createDate);
			if(id!=null){
				employeeService.updateEmployee(employee);
			}else{
				employeeService.insertEmployee(employee);
			}
			mv.setViewName("redirect:/employee/listEmployee");
			return mv;
		}
		@RequestMapping(value="/employee/deleteEmployee",method=RequestMethod.GET)
		 public void deleteEmployee(Integer id){

			if(id!=null){
				employeeService.deleteEmployee(id);
			}
		}
}
