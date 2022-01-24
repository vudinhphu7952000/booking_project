<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@page import="com.booking.util.SecurityUtils"%>


<!DOCTYPE html>
<html>
<head>



<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Small Business - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="<c:url value='/template/vendor/bootstrap/css/bootstrap.min.css' />" />

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/all.min.css" />

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" />

<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="<c:url value='/template/css/small-business.css' />" />


<link rel='stylesheet'
	href='https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.css'>
<script
	src='https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.min.js'></script>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Booking Application</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Hello,
							<%=SecurityUtils.getPrincipal().getUsername()%> ! <span
							class="sr-only">(current)</span>
					</a></li>
					<security:authorize access="hasAnyAuthority('ADMIN')">
						<li class="nav-item"><a class="nav-link" href="/admin">Administrator</a>
						</li>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/logout' />">Log out</a></li>
					</security:authorize>

				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Content Row -->
		<div class="row mt-3">
			<div class="col-6">
				<div class="mb-3">
					<div class="card h-150">
						<div class="card-body">
							<h2 class="card-title text-danger">[${type}] - ${model.name}</h2>
							<h3>Price (1h): ${model.pricePerHour}</h3>
							<h4>Detail: ${model.note}</h4>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary btn-sm">VIP</a>
						</div>
					</div>
				</div>

				<h3>Booking:</h3>
				<div class="container-fluid">
					<form id="formSubmit" class="mb-5">
						<div class="row">
							<div class="col-4 form-group">
								<label>Date</label>
								<div class="input-group date" id="datepicker">
									<input name="day" class="form-control" placeholder="MM/DD/YYYY"
										required /><span class="input-group-append input-group-addon"><span
										class="input-group-text"><i class="fa fa-calendar"></i></span></span>
								</div>
							</div>
							<div class="col-4 form-group">
								<label>Start time:</label>
								<div class="input-group time" id="timepicker">
									<input id="startTime" class="form-control" name="startTime"
										required placeholder="HH:MM" /><span
										class="input-group-append input-group-addon"><span
										class="input-group-text"><i class="fa fa-clock"></i></span></span>
								</div>
							</div>

							<div class="col-4 form-group">
								<label>End time</label>
								<div class="input-group time" id="timepicker2">
									<input id="endTime" class="form-control" name="endTime"
										required placeholder="HH:MM" /><span
										class="input-group-append input-group-addon"><span
										class="input-group-text"><i class="fa fa-clock"></i></span></span>
								</div>
							</div>


						</div>
						<input type="hidden" id="${type}Id" name="${type}Id" value='${id}'>
						<button type="submit" id="booking"
							class="btn btn-primary pl-3 pr-3">Booking</button>
					</form>
					<input type="hidden" id="typeApi" name="typeApi" value='${type}'>
				</div>





			</div>
			<div class="col-6 border" style="min-height: 400px;">
				<h3>Booked</h3>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Date</th>
							<th scope="col">Start Time</th>
							<th scope="col">End Time</th>
							<th scope="col">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${models}">
							<tr>
								<td>${item.day}</td>
								<td>${item.startTime}</td>
								<td>${item.endTime}</td>
								<td>${item.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>


		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->

	<%-- <script src="<c:url value='/template/vendor/jquery/jquery.min.js' />"></script> --%>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"
		integrity="sha512-+NqPlbbtM1QqiK8ZAo4Yrj2c4lNQoGv8P79DPtKzj++l5jnN39rHA/xsqn8zE9l0uSoxaCdrOgFs6yjyfbBxSg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="<c:url value='/template/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha512-Ah5hWYPzDsVHf9i2EejFBFrG2ZAPmpu4ZJtW4MfSgpZacn+M9QHDt+Hd/wL1tEkk1UgbzqepJr6KnhZjFKB+0A=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/eonasdan-bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>




	<script type="text/javascript">
		var api = "/" + $('#typeApi').val() + "/" + $('#typeApi').val()
				+ "booking";
		$('#formSubmit').submit(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});

			insert(data);

		});
		function insert(data) {
			$.ajax({
				url : api,
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					swal({
						title : "Successfully !",
						text : "Total Price: " + result['price'],
						type : "success",
						showCancelButton : true,
						confirmButtonColor : '#008000',
						confirmButtonText : 'Ok !',
						closeOnConfirm : false,
						closeOnCancel : true
					}, function(isConfirm) {
						if (isConfirm) {
							window.location.href = "/";
						}
					});
				},
				error : function(error) {
					swal({
						title : "Duplicated data !",
						type : "error",
						showCancelButton : true,
						confirmButtonColor : '#008000',
						confirmButtonText : 'Ok',
						closeOnConfirm : true,
					}, function(isConfirm) {
						if (isConfirm) {
						}
					});
					console.log(error);
				}
			});
		};

		if (/Mobi/.test(navigator.userAgent)) {
			// if mobile device, use native pickers
			$(".date input").attr("type", "date");
			$(".time input").attr("type", "time");
		} else {
			// if desktop device, use DateTimePicker
			$("#datepicker").datetimepicker({
				useCurrent : false,
				format : "L",
				showTodayButton : true,
				icons : {
					next : "fa fa-chevron-right",
					previous : "fa fa-chevron-left",
					today : 'todayText',
				}
			});
			$("#timepicker").datetimepicker({
				format : "HH:mm",
				icons : {
					up : "fa fa-chevron-up",
					down : "fa fa-chevron-down"
				}
			});
			$("#timepicker2").datetimepicker({
				format : "HH:mm",
				icons : {
					up : "fa fa-chevron-up",
					down : "fa fa-chevron-down"
				}
			});
		}
	</script>
</body>
</html>