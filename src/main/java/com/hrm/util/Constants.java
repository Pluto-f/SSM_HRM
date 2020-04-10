package com.hrm.util;

public class Constants {
	// 数据库表常量
		public static final String USERTABLE = "user_inf";
		public static final String DEPTTABLE = "dept_inf";
		public static final String JOBTABLE = "job_inf";
		public static final String EMPLOYEETABLE = "employee_inf";
		public static final String NOTICETABLE = "notice_inf";
		public static final String DOCUMENTTABLE = "document_inf";
		
		// 登录
		public static final String LOGIN = "loginForm";
		// 用户的session对象
		public static final String USER_SESSION = "user_session";
		
		// 默认每页5条数据
		public static int PAGE_DEFAULT_SIZE = 10;

		//文件保存路径
		public static final String savePath = "F:\\SSM\\fileServer\\apache-tomcat-8.5.31\\webapps\\hrmsysDocument\\download";
		//文件读取路径
		public static final String readPath = "http://localhost:9090/hrmsysDocument/download/";
}
