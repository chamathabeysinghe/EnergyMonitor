<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>AdminLTE 2 | New Change Request </title>
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

				<h1>Add Location</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Add Location</li>
				</ol>

			</section>


			<section class="content">
				<div class="row">
					<div class="col-md-8">
						<div class="box box-danger">
							<div class="box-header with-border">
								<h3 class="box-title">Add New Location</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form:form method="post" action="/EnergyMonitor/postLocation" modelAttribute="location">

									
									<!-- Display ChangeRequest ID --> 
									<div class="form-group">
										<label>Region</label> 
										<form:input type="text" class="form-control" path="region" />					
									</div>
									<div class="form-group">
										<form:select path ="province" id="province" class="form-control selectpicker">
											<option value="Western">Western</option>
											<option value="Southern">Southern</option>
											<option value="Eastern">Eastern</option>
											<option value="Central">Central</option>
											<option value="Norhtern">Northern</option>
										</form:select>
									</div>

									<!-- textarea input ChangeRequest Details -->
									
									
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