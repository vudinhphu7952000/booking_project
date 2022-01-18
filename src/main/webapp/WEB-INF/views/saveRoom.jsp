<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex justify-content-center">
		<form class="col-6" id="formSubmit">
		<div class="form-group">
			<label for="name">Room Name</label> <input
				type="text" class="form-control" id="name" name="name" 
				value='${model.name}'>
		</div>
		<div class="form-group">
			<label for="code">Room Code</label> <input
				type="text" class="form-control" id="code" name="code" 
				value='${model.code}'>
		</div>
		<div class="form-group">
			<label for="pricePerHour">Price (1h)</label> <input
				type="text" class="form-control" id="pricePerHour" name="pricePerHour" 
				value='${model.pricePerHour}'>
		</div>
		<div class="form-group">
			<label for="note">Note</label> <input
				type="text" class="form-control" id="note" name="note"
				value='${model.note}'>
		</div>
		<input type="hidden" id="roomId" name="id" value='${model.id}'>
		
		<button type="submit" id="btnAddOrUpdate" class="btn btn-primary pl-3 pr-3">Lưu</button>
	</form>
	</div>
	
	<script>
	$('#formSubmit').submit(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		var id = $('#roomId').val();
		if (id == "") {			
			insert(data);
		} else {
			update(data);
		}
		
	});
	function insert(data) {
		$
				.ajax({
					url : '${roomAPI}/insert',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						swal({
						    title: "Successfully !",
						    type: "success",
						    showCancelButton: true,
						    confirmButtonColor: '#008000',
						    confirmButtonText: 'Ok !',
						    closeOnConfirm: false,
						    closeOnCancel: true
						 },
						 function(isConfirm){
						   if (isConfirm){
							   window.location.href = "/admin/save-room";	
						    }
						 });
					},
					error : function(error) {
						$("#btnAddOrUpdate").notify("BOOM!", "error");
						console.log(error);
					}
				});
	}
	function update(data) {
		$.ajax({
			url : '${roomAPI}/update',
			type : 'PUT',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				$("#btnAddOrUpdate").notify("Update successfully", "success");
			},
			error : function(error) {
				$("#btnAddOrUpdate").notify("BOOM!", "error");
			}
		});
	};
	</script>
</body>
</html>