<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>AdminLTE 2 | Make Complaint</title>
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

				<h1>Complaint / Grievance Entry</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Make Complaint</li>
				</ol>
				
			</section>


			<section class="content">
				<div class="row">
					<div class="col-md-8">
						<div class="box box-danger">
							<div class="box-header with-border">
								<h3 class="box-title">Make Complaint</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form role="form">

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
	<script type="text/javascript">
		
	<%//String result = request.getParameter("usageList");

			Object value = request.getAttribute("usageList");
			String result[] = (String[]) value;
			out.println("var dataSet=" + result[1] + ";");
			out.println("var labelSet=" + result[0] + ";");
			out.println("console.log(dataSet);");%>
		
	</script>
	<script src="resources/chartjs/chart.js"></script>
	<script src="resources/controllers/customerusagecontroller.js"></script>

</body>
</html>
<!-- 

<body>
	<div class="container-fluid" id="make_complaint_container"> 
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					Consumer Complaint Entry Form
				</h1>
			</div>
			<p>You can now submit your complaints/grievances that could not be solved through our division or sub-division catering to your locality. 
			</p><p>It is expected that you provide us with the details regarding your efforts to solve the problem locally before it became necessary to submit your grievence through this channel. </p>
			<form class="form-horizontal" role="form">
			
			    Input Name
				<div class="form-group"> 
					<label for="input_name" class="col-sm-2 control-label">
						Name
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_name" />
					</div>
				</div>
				
				Input Account No.
				<div class="form-group"> 
					<label for="input_accountNo" class="col-sm-2 control-label">
						Account No.
					</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="input_accountNo" />
					</div>
				</div>
				
				Input Address
				<div class="form-group"> 
					<label for="input_address" class="col-sm-2 control-label">
						Address
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_address" />
					</div>
				</div>
				
				Input Email
				<div class="form-group"> 
					<label for="input_email" class="col-sm-2 control-label">
						Email
					</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="input_email" />
					</div>
				</div>
				
				Input Telephone Number
				<div class="form-group"> 
					<label for="input_tel" class="col-sm-2 control-label">
						Telephone Number
					</label>
					<div class="col-sm-10">
						<input type="tel" class="form-control" id="input_tel" />
					</div>
				</div>
				
				Input Complaint Subject
				<div class="form-group"> 
					<label for="input_subject" class="col-sm-2 control-label">
						Complaint Subject
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_subject" />
					</div>
				</div>
				
				Input Complaint Type
				<div class="form-group">
					<label for="input_complaintType" class="col-sm-2 control-label">
					  	Complaint Type
					</label>
					<div class="col-sm-10">
						<select class="form-control" id="input_complaintType">
						    <option>Electricity Bills</option>
						    <option>Calculation of electricity consumption</option>
						    <option>3Electricity tariff category you belong to</option>
						    <option>Electricity meter</option>
						    <option>Power lines going over your land</option>
						    <option>Damage to your electrical equipment due to power fluctuations</option>
						    <option>Other</option>
						</select>
					</div>
				</div>
				
				Input Complaint Description
				<div class="form-group"> 
					<label for="input_description" class="col-sm-2 control-label">
						Complaint Description
					</label>
					<div class="col-sm-10">
						<textarea id="input_description" name="input_description" style="width:100%; height:150px; border-color: #BCD4E6;"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default">
							Submit
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


	jQuery 2.2.3
	<script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
	Bootstrap 3.3.6
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	iCheck
	<script src="resources/plugins/iCheck/icheck.min.js"></script>
	
</body>
</html>

 -->