<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@page import ="com.booking.util.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Small Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="<c:url value='/template/vendor/bootstrap/css/bootstrap.min.css' />" />

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="<c:url value='/template/css/small-business.css' />" />
  

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Booking Application</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Hello, <%=SecurityUtils.getPrincipal().getUsername()%> !
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <security:authorize access="hasAnyAuthority('ADMIN')">
          	<li class="nav-item">
            	<a class="nav-link" href="/admin">Administrator</a>
          	</li>
          </security:authorize>
          
         <%--  <security:authorize access="isAuthenticated()">
          	<li class="nav-item">
            	<a class="nav-link" onClick="logoutForm.submit()">Logout</a>
            	<c:url var="logoutUrl" value="/logout" />
		        <form action="${logoutUrl}" method="post" id="logoutForm" hidden=true>
		            <input type="hidden"/>
		        </form>
          	</li>
          </security:authorize> --%>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Content Row -->
    <div class="row mt-3">
	  <div class="col-6">
	  	<c:forEach var="item" items="${rooms}">
	  		<div class="mb-3">
		        <div class="card h-100">
		          <div class="card-body">
		            <h2 class="card-title text-danger">[Room] - ${item.name}</h2>
		            <h3>Price (1h): ${item.pricePerHour}</h3>
		            <h4>Detail:     ${item.note}</h4>	
		          </div>
		          <div class="card-footer">
		            <a href="/booking/room/${item.id}" class="btn btn-primary btn-sm">Booking</a>
		          </div>
		        </div>
		      </div>
	  	</c:forEach>
			 
	 </div>
	 <div class="col-6">
	 	<c:forEach var="item" items="${seats}">
			 <div class="mb-3">
		        <div class="card h-100">
		          <div class="card-body">
		            <h2 class="card-title text-primary">[Seat] - ${item.name}</h2>
					<h3>Price (1h): ${item.pricePerHour}</h3>
		            <h4>Detail:     ${item.note}</h4>	          
		          </div>
		          <div class="card-footer">
		            <a href="/booking/seat/${item.id}" class="btn btn-primary btn-sm">Booking</a>
		          </div>
		        </div>
		      </div>
		    </c:forEach>
	 </div>
      

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  
  <script src="<c:url value='/template/vendor/jquery/jquery.min.js' />"></script>
  <script src="<c:url value='/template/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
  


</body>
</html>