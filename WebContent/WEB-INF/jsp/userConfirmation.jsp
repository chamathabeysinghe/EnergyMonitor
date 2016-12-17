<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>confirmation</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<jsp:include page="partials/styles.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="partials/header.jsp"></jsp:include>
		<jsp:include page="partials/sidenav.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="box box-info">

				<div class="box-header with-border">
					<h3 class="box-title">User Confirmation</h3>
				</div>
				<!-- /.box-header -->

				<!-- form start -->
				<form:form method="POST" action="/energymonitor/addUser"
					class="form-horizontal">

					<div class="box-body">

						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">FirstName</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="firstname"
									placeholder="firstname">
							</div>

						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">LastName</label>

							<div class="col-sm-6">
								<input type="text" class="form-control" id="lastname"
									placeholder="lastname">
							</div>
						</div>

						<div class="form-group">
							<label for="NamewithInitials" class="col-sm-2 control-label">Namewith Initials</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="NamewithInitials"
									placeholder="NamewithInitials">
							</div>
						</div>

						<div class="form-group">
							<label for="Address" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="Address"
									placeholder="address">
							</div>
						</div>

						<div class="form-group">
							<label for="NIC" class="col-sm-2 control-label">NIC</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="NIC"
									placeholder="xxxxxV">
							</div>
						</div>


						<div class="form-group">
							<label for="Phone Number" class="col-sm-2 control-label">PhoneNumber</label> <span class="col-sm-4"> <input type="number"
								class="form-control" id="PhoneNumber" placeholder="0xxxxxxxx">

							</span> <span class="col-sm-4"> <input type="number"
								class="form-control" id="PhoneNumber2" placeholder="0xxxxxxxx">
							</span>
						</div>

						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email</label>

							<div class="col-sm-6">
								<input type="email" class="form-control" id="email"
									placeholder="Email">
							</div>
						</div>

						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="Password">
							</div>
						</div>

					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-info pull-right">Submit</button>
					</div>
					<!-- /.box-footer -->

				</form:form>
			</div>
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