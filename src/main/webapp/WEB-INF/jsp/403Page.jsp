<%@page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/font/font/font-awesome.min.css" />" />
<script src="<c:url value="/script/script/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/script/script/bootstrap.min.js" />"></script>
<title>Search Business</title>
</head>
<body>
<body style="background-color: #404040; font-weight: 700">
<jsp:include page="head.jsp" />
<div class="container">
<div class="col-sm-12" id="nice">
<strong style="font-size: 20px; color: grey;"> NOTICE</strong>
<strong class="pull-right"><a href="Home" style="color: #ea533f"><i class="fa fa-home" style="font-size: 28px;"></i></a></strong>  
<hr style="margin: 10px 0 20px 0; width: 100%">
        <div class="row text-center" style="margin-bottom: 40px">
        <div class="col-sm-6 col-sm-offset-3" style="border: 1px solid #dddddd; margin-top: 30px;">
        <br><br> <h2 style="color:orange;">Opps Wait!</h2>
        <img src="<c:url value="/image/image/x.png" />">
        <h3>Dear, ${message}</h3>
        
				 
       <c:choose>
			  <c:when test="${noUser == 'none'}">
				<p style="font-size:20px;color:#5C5C5C;">Your not allowed in here!</p><br>
		        <a href="login" class="btn btn-success btn-lg" style="margin-bottom: 30px;">Go Back</a>  
			  </c:when>
			  <c:otherwise>
			    <p style="font-size:20px;color:#5C5C5C;">Your not allowed in here!</p><br>
		        <a href="Home" class="btn btn-success btn-lg" style="margin-bottom: 30px;">Home</a>  
		        <a href="logout" class="btn btn-danger btn-lg" style="margin-bottom: 30px;">Log out</a> 
  		      </c:otherwise>
		</c:choose>
        </div>       
	</div>
</div>
</div>
</body>
</html>