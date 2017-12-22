<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/font/font/font-awesome.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css" />" />
<script src="<c:url value="/script/script/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/script/script/bootstrap.min.js" />"></script>
<title>eBRS Login</title>
</head>
<body>
<div class="login-body">
<article class="container-login center-block">
<section>

<ul id="top-bar" class="nav nav-tabs nav-justified">
	<li class="active"><a href="#login-access">Log In</a></li>
	<li><a href="Registration">Register</a></li>
</ul>
<div class="tab-content tabs-login col-lg-12 col-md-12 col-sm-12 cols-xs-12">
	<div id="login-access" class="tab-pane fade active in">
	
		<h2><i class="fa fa-home"></i> <label style="font-style: italic;">e</label>BRS</h2>	
				     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
		
		<form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" accept-charset="utf-8" autocomplete="off" role="form" class="form-horizontal">
			<div class="form-group ">
				<label for="login" class="sr-only">Username</label>
				<input type="text" class="form-control" name="txtuser" id="login_value" placeholder="Username" tabindex="1" value="" />
			</div>
			<div class="form-group ">
				<label for="password" class="sr-only">Password</label>
					<input type="password" class="form-control" name="txtpass" id="password" placeholder="Password" value="" tabindex="2" />
			</div>
			<div class="checkbox">
					<label class="control-label" for="remember_me">
						<input type="checkbox" name="remember_me" id="remember_me" value="1" class="" tabindex="3" /> Remember me
					</label>
			</div>
			<br/>
			<div class="form-group ">				
					<button type="submit" name="log-me-in" id="submit" tabindex="5" class="btn btn-lg btn-primary">Sign In</button>
			</div>
		</form>		
			
	</div>
</div>

</section>
</article>
</div>
<div class="footer-copyright" style="padding: 5px; font-size: 12px; position: fixed; bottom: 0; left: 0; color: #ffffff; width: 100%;">
        <small>© 2017 QCITDO Powered by JAVA EE</small><small class="pull-right">Created by : Keymart Alcantara</small>
    </div>
</body>
</html>