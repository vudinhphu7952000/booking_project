<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Dashboard</title>

<!-- Custom fonts for this template-->
<link rel="stylesheet"
	href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />"
	type="text/css" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script
      src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.24.0/axios.min.js"
      integrity="sha512-u9akINsQsAkG9xjc1cnGF4zw5TFDwkxuc9vUp5dltDWYCSmyd0meygbvgXrlc/z7/o4a19Fb5V0OUE58J7dcyw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <link rel='stylesheet' href='https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.css'>
	<script src='https://cdn.rawgit.com/t4t5/sweetalert/v0.2.0/lib/sweet-alert.min.js'></script>

<!-- Page level plugin CSS-->
<link rel="stylesheet"
	href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css' />"
	type="text/css" />

<!-- Custom styles for this template-->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/sb-admin.css' />"
	type="text/css" />

</head>

<body id="page-top">

	<!-- header -->
	<%@ include file="/WEB-INF/views/common/admin/header.jsp"%>
	<!-- header -->

	<div id="wrapper">

		<!-- menu -->
		<%@ include file="/WEB-INF/views/common/admin/menu.jsp"%>
		<!-- menu -->
		<div id="content-wrapper">

			<!-- body -->
			<dec:body />
			<!-- body -->
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<!-- Footer -->
			<%@ include file="/WEB-INF/views/common/admin/footer.jsp"%>
			<!-- Footer -->

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>

	<!-- Page level plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js' />"></script>
	<script
		src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js' />"></script>
		<!-- notify -->
	<script src="<c:url value='/template/admin/js/notify.min.js' />"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin.min.js' />"></script>

</body>
</html>