<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>员工列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="${ctx}/public/logo.ico" type="image/x-icon" />
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
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>员工管理</cite></a>
      </span>
        <%--<button class="layui-btn layui-btn-small" onclick="location.href='${ctx}/employee/add'" style="line-height:1.6em;margin-top:3px;margin-left:75%;"  lay-submit="" lay-filter="sreach"><i class="layui-icon"></i>增加</button>--%>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="${ctx }/employee/listEmployee" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row" style="" align="center">
        <form class="layui-form layui-col-md12 x-so" method="get" action="${ctx }/employee/selectEmployee" id="employeeForm">
            <input type="hidden" name="pageIndex" id="pageIndex" value="${pageModel.pageIndex}" />
            <div style="float: left">
                <select name="jobId" >
                    <option value="0">职位筛选</option>
                    <c:forEach items="${requestScope.job_list}" var="job">
                        <option value="${job.id}">${job.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div style="float: left">
                <select name="deptId">
                    <option value="0">部门筛选</option>
                    <c:forEach items="${requestScope.dept_list}" var="dept">
                        <option value="${dept.id}">${dept.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div style="float: left">
                <select name="sex">
                    <option value="">性别</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <input class="layui-input" placeholder="开始日" name="startDate" id="start" style="float: left">
            <input class="layui-input" placeholder="截止日" name="endDate" id="end" style="float: left">
            <input type="text" name="userName" style="width:10%;float: left"  placeholder="姓名" autocomplete="off" class="layui-input">
            <input type="text" name="address" style="width:10%;float: left"  placeholder="地址" autocomplete="off" class="layui-input">
            <input type="text" name="phone" style="width:10%;float: left"  placeholder="手机号码" autocomplete="off" class="layui-input">

            <button class="layui-btn" id="query"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>姓名</th>
            <th>性别</th>
            <th>手机号码</th>
            <th>邮箱</th>
            <th>职位</th>
            <th>学历</th>
            <th>身份证号码</th>
            <th>部门</th>
            <th>联系地址</th>
            <th>建档日期</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.employeeList}" var="employee" varStatus="stat">
     <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${employee.name }</td>
            <td>${employee.sex }</td>
            <td>${employee.phone }</td>
            <td>${employee.email }</td>
            <td>${employee.job.name }</td>
            <td>${employee.education }</td>
            <td>${employee.cardId }</td>
            <td>${employee.dept.name }</td>
            <td>${employee.address }</td>
            <td>${employee.createDate }</td>

            <td class="td-manage">

              <%-- <a title="编辑"  onclick="x_admin_show('编辑','${ctx}/job/add?id=${dept.id }');" href="javascript:;"> --%>
              <a title="编辑"  href="${ctx}/employee/addEmployee?id=${employee.id }">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <a title="删除" onclick="member_del(this,'${employee.id }')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
          </tr>
				
			</c:forEach>

        </tbody>
      </table>
      <div class="page">
        <div>
            <%@include file="../page.jsp"%>
        </div>
      </div>

    </div>

    <script type="text/javascript">
        function toPage(pageIndex) {
            $("#pageIndex").attr("value",pageIndex);
            $("#employeeForm").submit();
        }
        $("#query").click(function(){
            $("#pageIndex").attr("value",1);
            $("#employeeForm").attr("action", "${ctx}/employee/selectEmployee");
            $("#employeeForm").submit();
        })
        $("#pagerJump").click(function(){
            var page_size=$("#pager_jump_page_size").val();

            var regu = /^[1-9]\d*$/;

            if (!regu.test(page_size)||page_size < 1 || page_size >${pageModel.totalPageSum})
            {
                alert('请输入[1-'+ ${pageModel.totalPageSum} +']之间的页码！');
            }else
            {
                $("#pageIndex").attr("value",page_size);
                $("#employeeForm").attr("action", "${ctx}/employee/listEmployee");
                $("#employeeForm").submit();
            }
        })
    </script>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              //等以后再使用异步，这里先使用
              $.get("${ctx}/employee/deleteEmployee?id="+id);
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>