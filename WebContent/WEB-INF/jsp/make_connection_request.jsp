<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>AdminLTE 2 | Make Request</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<jsp:include page="partials/styles.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="partials/header.jsp"></jsp:include>
		<jsp:include page="partials/sidenav.jsp"></jsp:include>

		<div class="content-wrapper">



			<section class="content-header">

				<h1>Request Entry</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Make Request</li>
				</ol>

			</section>


			<section class="content">
				<div class="row">
					<div class="col-md-8">
						<div class="box box-danger">
							<div class="box-header with-border">
								<h3 class="box-title">Make Request</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form:form method="post" action="make_connection_request" modelAttribute="connectionRequest">

									
									<!-- Display ConnectionRequest ID --> 
									<div class="form-group">
										<label>Request ID</label> 
										<input type="text" class="form-control"
											id="id" value="${id}" path="id" disabled/>					
									</div> 
									
									
									<!-- textarea input ConnectionRequest Details -->
									<div class="form-group">
										<label>Request Details</label>
										<form:textarea class="form-control" placeholder="Enter ..." id="newConnectionDetails" path="newConnectionDetails" rows="3"/>
									</div>
									
									<%-- <!-- Display Complaint Status --> 
									<div class="form-group">
										<label>ConnectionID</label> 
										<form:input type="text" class="form-control"
											placeholder="1" id="connectionID" path="connectionID" disabled/>
											<select class="form-control">
							                    <option>option 1</option>
							                    <option>option 2</option>
							                    <option>option 3</option>
							                    <option>option 4</option>
							                    <option>option 5</option>
							                  </select>
									</div> --%>

									<div class="box-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>

								</form:form>
							</div>
							<!-- /.box-body -->
						</div>
					</div>
				</div>
			</section>


		</div>

		<jsp:include page="partials/footer.jsp"></jsp:include>

		<jsp:include page="partials/controllsidebar.jsp"></jsp:include>
	</div>

	<jsp:include page="partials/scripts.jsp"></jsp:include>


	<!-- ChartJS 1.0.1 -->
	<script src="resources/plugins/chartjs/Chart.min.js"></script>
	<!-- FastClick -->
	<script src="resources/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js"></script>
	<script src="resources/chartjs/chart.js"></script>
	<script src="resources/controllers/customerusagecontroller.js"></script>

</body>
</html>