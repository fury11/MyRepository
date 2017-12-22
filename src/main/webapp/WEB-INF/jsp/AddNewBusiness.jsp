<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/font.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/font/font/font-awesome.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css" />" />
<script src="<c:url value="/script/script/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/script/script/bootstrap.min.js" />"></script>
<script src="<c:url value="/script/script/jquery-ui.js" />"></script>
  <script>
  $( function() {
    $( "#datefrom" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $( "#dateto" ).datepicker({ dateFormat: 'yy-mm-dd' });
  } );
  </script>
  <style>
  .ui-datepicker-prev span {
    background-image: url(image/prev.png) !important;
        background-position: 0px 0px !important;
}

.ui-datepicker-next span {
     background-image: url(image/next.png) !important;
        background-position: 0px 0px !important;
}
  </style>
<title>Register Business</title>
</head>
<body style="background-color: #404040; font-weight: 700">
<jsp:include page="head.jsp" />
<div class="container">
<div class="col-sm-12" id="nice">
<strong style="font-size: 20px; color: grey;"> NEW BUSINESS</strong>
<strong class="pull-right"><a href="Home" style="color: #ea533f"><i class="fa fa-home" style="font-size: 28px;"></i></a></strong>  
<hr style="margin: 10px 0 20px 0; width: 100%">
<form:form action="saveBus" method="post">

<div class="col-sm-6" style="margin-bottom: 20px">
<label>Company/Trade/Applicant Name:</label>
<form:input type="text" required="required" class="form-control" path="txta" />
</div>

<div class="col-sm-6" style="margin-bottom: 20px">
<label>Owner/Operation or Branch Manager:</label>
<form:input type="text" required="required" class="form-control" path="txtb" />
</div>

<div class="col-sm-4" style="margin-bottom: 20px">
<label>Business Type:</label>
<form:input type="text" required="required" class="form-control" path="txtc" />
</div> 

<div class="col-sm-4" style="margin-bottom: 20px">
<label>Date From:</label>
<form:input type="text" required="required" id="datefrom" class="form-control" path="txtd" />
</div>

<div class="col-sm-4" style="margin-bottom: 20px">
<label>Date to:</label>
<form:input type="text" required="required" id="dateto" class="form-control" path="txte" />
</div>

<div class="col-sm-12" style="margin-bottom: 20px">
<label>Business Address:</label>
<form:textarea required="required" class="form-control" path="txtf"></form:textarea>
</div>

<div class="col-sm-12" style="margin-bottom: 10px; text-align: center;" >
<button type="submit" class="btn btn-success btn-lg"><i class="fa fa-save"></i> Save</button>
</div>

</form:form>
</div>
</div>

</body>
</html>