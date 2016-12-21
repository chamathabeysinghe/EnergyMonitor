<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ceb.models.EnergyConsumption"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import=" com.ceb.models.Complaint"%>
<%@ page import=" com.ceb.models.ConnectionRequest"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<title>Requests & Complaints</title>
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

				<h1>Requests & Complaints</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Requests & Complaints</li>
				</ol>

			</section>


			<section class="content">
				<div class="row">
					<div class="col-md-6">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">New Connection Requests</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form role="form">		
									<div class="panel-group" id="panel-978813">
									
										<% Object oConnectionRequests=request.getAttribute("allconnectionrequests");
										for(ConnectionRequest connectionrequest: (ArrayList<ConnectionRequest>)oConnectionRequests){ %>
									       	 
									       	 <div class="panel panel-default">
												<div class="panel-heading">
													 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-978813" href="#panel-complaint-<% out.println(connectionrequest.getId()); %>">Connection Request ID: <% out.println(connectionrequest.getId()); %></a>
												</div>
												<div id="panel-complaint-<% out.println(connectionrequest.getId()); %>" class="panel-collapse collapse in">
													<div class="panel-body">
														<% out.println(connectionrequest.getNewConnectionDetails()); %>
													</div>
												</div>
											</div>
									    <% }; %>
									    
									</div>	
									</form>							
							</div>
							<!-- /.box-body -->
						</div>
					</div>
					
					<div class="col-md-6">
						<div class="box box-danger">
							<div class="box-header with-border">
								<h3 class="box-title">Consumer Complaints</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<form role="form">
									<div class="panel-group" id="panel-978814">
										
										<% Object oComplaints=request.getAttribute("allcomplaints"); 
										/* List<Complaint> allcomplaints = List<Complaint>o; */
										for(Complaint complaint: (ArrayList<Complaint>)oComplaints){ %>
									       	 
									       	 <div class="panel panel-default">
												<div class="panel-heading">
													 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-978814" href="#panel-complaint-<% out.println(complaint.getId()); %>">Complaint ID: <% out.println(complaint.getId()); %></a>
												</div>
												<div id="panel-complaint-<% out.println(complaint.getId()); %>" class="panel-collapse collapse in">
													<div class="panel-body">
														<% out.println(complaint.getComplaintDetails()); %>
													</div>
												</div>
											</div>
									    <% }; %>
										
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