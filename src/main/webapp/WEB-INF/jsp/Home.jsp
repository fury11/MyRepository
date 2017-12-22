<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/font/font/font-awesome.min.css" />" />
<script src="<c:url value="/script/script/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/script/script/bootstrap.min.js" />"></script>
<title>HomePage</title>
</head>
<body style="background-color: #404040; font-weight: 700">
<jsp:include page="head.jsp" />
<div class="container" style="margin-top: 20%">
	<div class="row">
      <div class="col-lg-3">
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <i class="fa fa-plus-circle fa-5x"></i>
              </div>
              <div class="col-xs-6 text-right">
                <p class="announcement-text">New Business</p>
              </div>
            </div>
          </div>
        
            <div class="panel-footer announcement-bottom clicker" onclick="window.location.href = '${pageContext.request.contextPath}/AddNewBusiness'">
              <div class="row">
                <div class="col-xs-6">
                   Explore
                </div>
                <div class="col-xs-6 text-right">
                  <i class="fa fa-arrow-circle-right"></i>
                </div>
              </div>
            </div>
        
        </div>
      </div>
      <div class="col-lg-3">
        <div class="panel panel-success">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <i class="fa fa-search fa-5x"></i>
              </div>
              <div class="col-xs-6 text-right">
              
                <p class="announcement-text"> Search Business</p>
              </div>
            </div>
          </div>
        
            <div class="panel-footer announcement-bottom clicker" onclick="window.location.href = '${pageContext.request.contextPath}/Search'">
              <div class="row">
                <div class="col-xs-6">
                   Explore
                </div>
                <div class="col-xs-6 text-right">
                  <i class="fa fa-arrow-circle-right"></i>
                </div>
              </div>
            </div>
          
        </div>
      </div>
      <div class="col-lg-3">
        <div class="panel panel-danger">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <i class="fa fa-print fa-5x"></i>
              </div>
              <div class="col-xs-6 text-right">
                <p class="announcement-text"> Print Reports</p>
              </div>
            </div>
          </div>
         
            <div class="panel-footer announcement-bottom clicker" onclick="window.location.href = '${pageContext.request.contextPath}/Print'">
              <div class="row">
                <div class="col-xs-6">
                   Explore
                </div>
                <div class="col-xs-6 text-right">
                  <i class="fa fa-arrow-circle-right"></i>
                </div>
              </div>
            </div>
          
        </div>
      </div>
      <div class="col-lg-3">
        <div class="panel panel-warning">
          <div class="panel-heading">
            <div class="row">
              <div class="col-xs-6">
                <i class="fa fa-gears fa-5x"></i>
              </div>
              <div class="col-xs-6 text-right">
                <p class="announcement-text"> eBRS Settings</p>
              </div>
            </div>
          </div>
         
            <div class="panel-footer announcement-bottom clicker" onclick="window.location.href = '${pageContext.request.contextPath}/Admin'">
              <div class="row">
                <div class="col-xs-6">
                  Explore
                </div>
                <div class="col-xs-6 text-right">
                  <i class="fa fa-arrow-circle-right"></i>
                </div>
              </div>
            </div>
         
        </div>
      </div>
    </div><!-- /.row -->
    <div class="col-sm-12">
    <div class="row" style="background-color: white;">
<table class="table table-responsive" style="display: none;">
<thead>
<tr>
<th>ID</th>
<th>USERNAME</th>
<th>PASSWORD</th>
</tr>
</thead>
<tbody>
<c:forEach items="${getalls}" var="c">
<tr>
<td><c:out value="${c.id}" /></td>
<td><c:out value="${c.username}" /></td>
<td><c:out value="${c.password}" /></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
    </div>
    </div>

</body>
<style>
.clicker{
cursor: pointer;
color: #31708f;
}
</style>
</html>