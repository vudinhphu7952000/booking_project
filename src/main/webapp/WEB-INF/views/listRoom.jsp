<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Manager</title>
</head>
<body>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> List Room
		</div>
		<div class="card-body">
			<div>
				<a flag="info"
					class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
					data-toggle="tooltip" title='Add' href='/admin/save-room'> <span>
						<i class="fa fa-plus-circle bigger-110 purple"></i>
				</span>
				</a>

				<button id="btnDelete" type="button"
					class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
					data-toggle="tooltip" title='Delete'>
					<span> <i class="fa fa-trash-o bigger-110 pink"></i>
					</span>
				</button>

			</div>
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th class="text-center" width=50px><input type="checkbox"
								id="checkAll"></th>
							<th>Id</th>
							<th>Room Name</th>
							<th>Room Code</th>
							<th>Price per hour</th>
							<th>Note</th>
							<th class="text-center" width="100px">Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th></th>
							<th>Id</th>
							<th>Room Name</th>
							<th>Room Code</th>
							<th>Price per hour</th>
							<th>Note</th>
							<th class="text-center">Action</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="item" items="${models}">
							<tr>
								<td class="text-center"><input type="checkbox"
									id="checkbox_${item.id}" value="${item.id}"></td>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.code}</td>
								<td>${item.pricePerHour}</td>
								<td>${item.note}</td>
								<td class="text-center"><a
									class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
									title="Update" href='/admin/save-room?id=${item.id}'> <i
										class="fa fa-pencil-square-o" aria-hidden="true"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		$("#checkAll").click(function(e) {
			if(this.checked) {
		        // Iterate each checkbox
		        $(':checkbox').each(function() {
		            this.checked = true;                        
		        });
		    } else {
		        $(':checkbox').each(function() {
		            this.checked = false;                       
		        });
		    }		
		});
		
		$("#btnDelete").click(function(e) {
			e.preventDefault();
			swal({
			    title: "Delete rooms is checked?",
			    text: "Rooms is deleted will be delete and can not restore !",
			    type: "warning",
			    showCancelButton: true,
			    confirmButtonColor: '#008000',
			    confirmButtonText: 'Ok !',
			    cancelButtonText: "Cancel !",
			    closeOnConfirm: false,
			    closeOnCancel: true
			 },
			 function(isConfirm){
			   if (isConfirm){
			        var ids = $('tbody input[type=checkbox]:checked').map(function () {
			            return $(this).val();
			        }).get();			     
			        doDelete(ids);	
			    }
			 });
			});
		function doDelete(data) {
	        $.ajax({
	            url: '${roomAPI}/delete',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data), 
	            success: function (result){
	            	if(result !== ""){
	            		swal({
		    			    title: "Can not delete rooms: ",
		    			    text: result,
		    			    type: "warning",
		    			    //showCancelButton: true,
		    			    confirmButtonColor: '#008000',
		    			    confirmButtonText: 'Ok !',
		    			    cancelButtonText: "Cancel !",
		    			    closeOnConfirm: false,
		    			    //closeOnCancel: true
		    			 },
		    			 function(isConfirm){
		    			   if (isConfirm){
		    				 window.location.href = "/admin/list-room";
		    			    }
		    			 });
	            	}
	            	else {
	            		 window.location.href = "/admin/list-room";
					}
	    	
	            	
	            },
	            errror: function (error){
	            	$("#btnDelete").notify("BOOM!", "error");
	            }
	        });
	    }
	</script>
</body>
</html>