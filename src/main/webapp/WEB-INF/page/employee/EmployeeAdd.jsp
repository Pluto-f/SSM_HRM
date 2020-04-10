<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>添加员工</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" method="POST" id="employeeForm"  action="${ctx}/employee/editEmployee">
        <input type="hidden" name="id" id="id" value="${employee.id }" >
          <div class="layui-form-item" >
              <label class="layui-form-label">
                  <span class="x-red">*</span>姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="name" name="name" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.name }">
              </div>
             
          </div>
          <div class="layui-form-item" >
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>身份证号码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="cardId" name="cardId" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.cardId }">
              </div>
          </div>
           <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>性别
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="sex" name="sex" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.sex }">
              </div>
          </div>
            <div class="layui-form-item">
                <label for="jobId" class="layui-form-label">
                    <span class="x-red">*</span>职位
                </label>
                <div class="layui-input-inline">
                    <select id="jobId" name="jobId" class="valid" >
                        <c:forEach items="${requestScope.job_list}" var="job" varStatus="stat">
                            <option value="${job.id}" <c:if test="${employee.jobId == job.id }">selected</c:if>>${job.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="deptId" class="layui-form-label">
                    <span class="x-red">*</span>部门
                </label>
                <div class="layui-input-inline">
                    <select id="deptId" name="deptId" class="valid">
                        <c:forEach items="${requestScope.dept_list}" var="dept" varStatus="stat">
                            <option value="${dept.id}" <c:if test="${employee.deptId == dept.id }">selected</c:if>>${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="salary" class="layui-form-label">
                    <span class="x-red">*</span>薪资
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="salary" name="salary" required="" lay-verify="required"
                           autocomplete="off" class="layui-input" value="${employee.salary }">
                </div>
            </div>
            <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>学历
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="education" name="education" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.education }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="postCode" class="layui-form-label">
                  <span class="x-red">*</span>邮政编码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="postCode" name="postCode" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.postCode }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="tel" class="layui-form-label">
                  <span class="x-red">*</span>电话
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="tel" name="tel" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.tel }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="qqNum" class="layui-form-label">
                  <span class="x-red">*</span>QQ号码
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="qqNum" name="qqNum" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.qqNum }">
              </div>
          </div>
           <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="email" name="email" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.email }">
              </div>
          </div>
           <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.phone }">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="address" class="layui-form-label">
                  <span class="x-red">*</span>联系地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="address" name="address" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.address }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="party" class="layui-form-label">
                  <span class="x-red">*</span>政治面貌
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="party" name="party" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.party }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="birthday" class="layui-form-label">
                  <span class="x-red">*</span>生日
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="birthday" name="birthday" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.birthday }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="speciality" class="layui-form-label">
                  <span class="x-red">*</span>专业
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="speciality" name="speciality" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.speciality }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="hobby" class="layui-form-label">
                  <span class="x-red">*</span>爱好
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="hobby" name="hobby" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.hobby }">
              </div>
          </div>
            <div class="layui-form-item">
              <label for="remark" class="layui-form-label">
                  <span class="x-red"></span>备注
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="remark" name="remark" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${employee.remark }">
              </div>
          </div>
          

          <div class="layui-form-item">
              <label class="layui-form-label">
              </label>
              <input type="submit" value=" 提交" class="layui-btn" lay-filter="add" lay-submit=""/>
                 
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;


          //监听提交
          form.on('submit(add)', function(data){
        	  
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
            	document.getElementById('employeeForm').submit();
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
               
            });
            return false;
          });
          
          
        });
    </script>
    
  </body>

</html>