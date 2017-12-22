<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<li><a href="/eBRS2/">Log In</a></li>
	<li class="active"><a href="#">Register</a></li>
</ul>
<div class="tab-content tabs-login col-lg-12 col-md-12 col-sm-12 cols-xs-12">
	<div id="login-access" class="tab-pane fade active in">
	
		<h2>Registration</h2>		
		<form:form method="post" action="saveUser" accept-charset="utf-8" autocomplete="off" role="form" class="form-horizontal">
			<div class="form-group ">
				<label for="login" class="sr-only">Name</label>
				<form:input type="text" class="form-control" required="required" path="fullname" id="login_value" placeholder="Full Name" tabindex="1" value="" />
			</div>
			<div class="form-group ">
				<label for="login" class="sr-only">Baranggay</label>
				<form:select required="required" class="form-control" path="brgy">
				<form:option value="NONE" label="Select.." />
				<form:options items="${brgyList}" />
				</form:select>
			</div>
			<div class="form-group ">
				<label for="login" class="sr-only">Username</label>
				<form:input type="text" class="form-control" path="username" id="login_value" placeholder="Username" tabindex="1" value="" />
			</div>
			<div class="form-group ">
				<label for="password" class="sr-only">Password</label>
					<form:input type="password" class="form-control" required="required" path="password" id="nospaceC" placeholder="Password" value="" tabindex="2" />				
			</div>
			<div class="form-group ">
				<label for="password" class="sr-only">Password</label>
					<input type="password" class="form-control" required="required" id="nospaceD" placeholder="Confirm Password" value="" tabindex="2" />
					<span id="message" style="font-weight: 700"></span>
					<input type="hidden" id="hid" />
			</div>
			<br/>
			<div class="form-group ">				
					<button type="submit" disabled="disabled" name="log-me-in" id="submit" tabindex="5" class="btn btn-lg btn-primary">Submit</button>
			</div>
		</form:form>		
			
	</div>
</div>

</section>
</article>
</div>
<div class="footer-copyright" style="padding: 5px; font-size: 12px; position: fixed; bottom: 0; left: 0; color: #ffffff; width: 100%;">
        <small>© 2017 QCITDO Powered by JAVA EE</small><small class="pull-right">Created by : Keymart Alcantara</small>
    </div>
<script type="text/javascript">

$('#nospaceD').on('keyup', function () {
    if ($(this).val() === $('#nospaceC').val()) {
        $('#message').html('Matched').css('color', 'green');
        $('#message').show();
        $('#hid').val("won");        
    }else {
        $('#message').html('Not matching').css('color', 'red');
        $('#hid').val(null);
    }
    
    if($('#hid').val() === "won"){
    	$('#submit').prop('disabled', false);
         if ($(this).val() === "" || $(this).val() === null ) {
         $('#message').hide();
         $('#submit').prop('disabled', true);
     }
     }else{        
    	 $('#submit').prop('disabled', true);
    }
    
});
$('#nospaceC').on('keyup', function () {
    if ($(this).val() === $('#nospaceD').val()) {
        $('#message').html('Matched').css('color', 'green');
        $('#message').show();
        $('#hid').val("won");        
    }else {
        $('#message').html('Not matching').css('color', 'red');
        $('#hid').val(null);
    }
    if($('#hid').val() === "won"){
    	$('#submit').prop('disabled', false);
         if ($(this).val() === "" || $(this).val() === null ) {
         $('#message').hide();
         $('#submit').prop('disabled', true);
     }
     }else{        
    	 $('#submit').prop('disabled', true);
    }
});
</script>
</body>
</html>