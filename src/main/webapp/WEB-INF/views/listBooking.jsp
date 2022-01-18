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
			<i class="fas fa-table"></i> 
			<c:if test="${models[0].TYPE == 'roomBooking'}">List Room Booking</c:if>
			<c:if test="${models[0].TYPE == 'seatBooking'}">List Seat Booking</c:if>
		</div>
		<div class="card-body">
			
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>				
							<th>Id</th>
							<th>Booking Day</th>
							<th>Start Time</th>
							<th>End Time</th>							
							<c:if test="${models[0].TYPE == 'roomBooking'}"><th>Room Id</th></c:if>
							<c:if test="${models[0].TYPE == 'seatBooking'}"><th>Seat Id</th></c:if>
							<th>Price</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>Id</th>
							<th>Booking Day</th>
							<th>Start Time</th>
							<th>End Time</th>
							<c:if test="${models[0].TYPE == 'roomBooking'}"><th>Room Id</th></c:if>
							<c:if test="${models[0].TYPE == 'seatBooking'}"><th>Seat Id</th></c:if>							
							<th>Price</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="item" items="${models}">
							<tr>
								<td>${item.id}</td>
								<td>${item.day}</td>
								<td>${item.startTime}</td>
								<td>${item.endTime}</td>
								<c:if test="${models[0].TYPE == 'roomBooking'}"><th>${item.roomDto.id}</th></c:if>
								<c:if test="${models[0].TYPE == 'seatBooking'}"><th>${item.seatDto.id}</th></c:if>
								<td>${item.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>