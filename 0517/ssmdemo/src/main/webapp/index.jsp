<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/self/login.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/self/common.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
</head>
<body>  
	<div class="row">
		<div id="font">教务管理系统</div>
		<div class="col-xs-8 col-md-6 col-center-block">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="username"
							placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password"
							placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<button type="submit" class="btn btn-primary btn-lg btn-block ">登录</button>
						<button id="register" type="button" data-toggle="modal"
							data-target="#myModal" class="btn btn-primary btn-lg btn-block ">注册</button>
					</div>
				</div>
			</form>
		</div>
		<!-- 注册信息模态框 -->
		<div class="modal fade  bs-example-modal-sm" id="myModal"
			tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title text-center" id="myModalLabel">用户注册</h4>
					</div>
					<div class="modal-body" style="height: 220px">
						<div class="row">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="username1" class="col-sm-4 control-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" id="username1"
											placeholder="请输入用户名">
									</div>
								</div>
								<div class="form-group">
									<label for="password1" class="col-sm-4 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
									<div class="col-sm-7">
										<input type="password" class="form-control" id="password1"
											placeholder="请输入密码">
									</div>
								</div>
								
								<div class="form-group">
									<label for="password2" class="col-sm-4 control-label">确认密码</label>
									<div class="col-sm-7">
										<input type="password" class="form-control" id="password2"
											placeholder="请再次输入密码">
									</div>
								</div>
								
								<div class="form-group">
									<label for="password1" class="col-sm-4 control-label">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色</label>
									<div class="col-sm-7">
										<select class="form-control" id="roles">
											
										</select>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="zhuce">注册</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
   $(function(){
	   $.ajax({
		   type:"POST",
		   url:"role/roleList",
		   dataType:"json",
		   success:function(result){
			   var roleslist=result.data;
			   for(var i=0;i<roleslist.length;i++){
				   $("#roles").append("<option value='"+roleslist[i].id+"'>"+roleslist[i].rolename+"</option>");
			   }
		   }
	   });
   })
   //用户名不可为空，且不可重复
   $("#username1").blur(function(){
	   var username1=$("#username1").val();
	   if(username1 == ""){
		   alert("用户名不可为空");
		   return;
	   }else{
		   $.ajax({
			   type:"POST",
			   url:"register/isRepeatName?username="+username1,
			   dataType:"json",
			   success:function(data){
				   if(data.message!=null){
					   alert("该用户名已经存在，请重新输入！");
					   $("#username1").val("");
				   }
				   
			   }
		   })
	   }
   });
   //确认密码输入框失去焦点，触发
   $("#password2").blur(function(){
    var password1=$("#password1").val();
    var password2=$("#password2").val();
    if(password1!=password2){
    	alert("两次密码不一致，请重新输入");
    	 $("#password2").val("");
    }
  });
   //点击注册与后台交互并返回是否成功的信息
   $("#zhuce").click(function(){
	   debugger;
	   var username1=$("#username1").val();
	   var password1=$("#password1").val();
	   var role=$('#roles option:selected') .val();
	   if(username1 == ""){
		   alert("用户名不能为空");
		   return;
	   }
	   if(password1 == ""){
		   alert("密码不能为空");
		   return;
	   }
	   var register1={"username":username1,"password":password1,"roleid":role};
	   $.ajax({
		   type:"POST",
		   url:"register/addUser",
		   data:{register:JSON.stringify(register1)},
		   dataType:"json",
		   success:function(data){
			   alert(data.message);
			   window.location.reload();//注册成功后刷新当前页面
		   }
	   })
   });
</script>
</html>