<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>

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
								<form role="form">

									<!-- select Request Type -->
									<div class="form-group">
										<label>Request Type</label> <select class="form-control">
											<option>Change Location</option>
											<option>Change Ownership</option>
										</select>
									</div>

									<!-- text input Subject -->
									<div class="form-group">
										<label>Subject</label> <input type="text" class="form-control"
											placeholder="Enter ..." id="subject">
									</div>

									<!-- textarea input Complaint Description -->
									<div class="form-group">
										<label>Description</label>
										<textarea class="form-control" id="description" rows="3">
									</textarea>
									</div>

									<div class="box-footer">
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>

								</form>
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