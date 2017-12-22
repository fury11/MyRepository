<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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
<script src="<c:url value="/script/script/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/script/script/dataTables.bootstrap.min.js" />"></script>
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
<title>Print Report</title>
</head>
<body>
<body style="background-color: #404040; font-weight: 700">
<jsp:include page="head.jsp" />
<div class="container">
<div class="col-sm-12" id="nice">
<strong style="font-size: 20px; color: grey;"> PRINT BUSINESS</strong>
<strong class="pull-right"><a href="Home" style="color: #ea533f"><i class="fa fa-home" style="font-size: 28px;"></i></a></strong>  
<hr style="margin: 10px 0 20px 0; width: 100%">
<div id="content" style="margin-top: -10px">
    <ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
        <li class="active"><a href="Print">Print Local</a></li>
        <li><a href="PrintAll">Print All</a></li>
    </ul>
</div>
<div style="margin: 20px 0 20px 0">
<form:form action="Print" method="get" modelAttribute="PrintModel">
<div class="col-sm-3" style="margin-bottom: 10px">
<label>Category:</label>
<form:select class="form-control" path="txtcategory">
<form:option value="" label="Select.." />
<form:options items="${categoryList}" />
</form:select>
</div>

<div class="col-sm-9" style="margin-bottom: 10px">
<label>Keyword:</label>
<form:input type="text" value="" class="form-control" path="txtsearch" />
</div>

<div class="col-sm-4" style="margin-bottom: 10px; display: none;">
<label>Barangay:</label>
<form:select required="required" class="form-control" path="txtbrgy">
<form:option value="" label="Select.." />
<form:options items="${brgyList}" />
</form:select>
</div>

<div class="col-sm-5" style="margin-bottom: 30px">
<label>Date From:</label>
<form:input type="text" id="datefrom" required="required" value="" class="form-control" path="txtfrom" />
</div>

<div class="col-sm-5" style="margin-bottom: 30px">
<label>Date To:</label>
<form:input type="text" id="dateto" required="required" value="" class="form-control" path="txtto" />
</div>

<div class="col-sm-2" style="margin-bottom: 30px">
<label style="color:#f5f8fa">Button</label>
<form:button style="width: 100%" type="submit" class="btn btn-success"><i class="fa fa-search"></i> Search</form:button>
</div>
</form:form>
</div>

<table class="table table-responsive table-striped" id="mytables">
<thead>
<tr class="info">
<th>DATE</th>
<th>BUSINESS</th>
<th>OWNER</th>
<th>BRGY</th>
<th>TYPE</th>
<th>ADDRESS</th>
</tr>
</thead>
<tbody>
<c:forEach items="${printList}" var="p">
<tr>
<td><c:out value="${p.BFROM}" /></td>
<td><c:out value="${p.busname}" /></td>
<td><c:out value="${p.owner}" /></td>
<td><c:out value="${p.brgy}" /></td>
<td><c:out value="${p.bustype}" /></td>
<td><c:out value="${p.busaddress}" /></td>
</tr>
</c:forEach>
</tbody>
</table>


<iframe name="myframe" hidden="hidden"></iframe>

<div class="col-lg-12" style="text-align: center">
<hr>
<a href="PrintingController?txtcategory=&txtsearch=&txtfrom=&txtto=" target="myframe" class="btn btn-success btn-lg"><i class="fa fa-print"></i> PRINT RECORDS</a>&nbsp;&nbsp;
<a href="" class="btn btn-primary btn-lg"><i class="fa fa-print"></i> DOWNLOAD</a>
</div>
</div>
</div>
</body>
 <script>
$(document).ready(function() {
$('#mytables').DataTable({
 "bSort": false,
 "pageLength": 10,
 "bLengthChange": false,
 "language": {
        "lengthMenu": "Display _MENU_ records per page",
        "zeroRecords": "Nothing found - sorry",
        "info": "Showing page _PAGE_ of _PAGES_",
        "infoEmpty": "No records available",
        "infoFiltered": "(filtered from _MAX_ total records)"
    }
});
}); 
</script>
<style>
.dataTables_filter {
   display: none;
}
.dataTables_wrapper .dataTables_paginate {
    float: right ! important;
}
th{
color: #31708f;
}
</style>
</html>