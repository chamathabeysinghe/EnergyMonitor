<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="com.ceb.models.EnergyConsumption" %>
<%@ page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <title>Admin | Home</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <jsp:include page="partials/styles.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
	   
	  <jsp:include page="partials/header.jsp"></jsp:include>
	  <jsp:include page="partials/sidenav.jsp"></jsp:include>
	  
	  <div class="content-wrapper">

			

			<section class="content">
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3>
									<%
										//String result = request.getParameter("usageList");

										int value =(Integer) request.getAttribute("newConnection");
										
										out.println(value+"");
									%>


								</h3>

								<p>New Order Requests</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-green">
							<div class="inner">
								<h3>
									<%
										//String result = request.getParameter("usageList");

										int changes =(Integer) request.getAttribute("changeConnection");
										
										out.println(changes);
									%>
								</h3>

								<p>Change Requests</p>
							</div>
							<div class="icon">
								<i class="ion ion-edit"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-red">
							<div class="inner">
								<h3>
								<%
										//String result = request.getParameter("usageList");

										int errors =(Integer) request.getAttribute("complaints");
										
										out.println(errors);
									%>
								</h3>

								<p>Complaints</p>
							</div>
							<div class="icon">
								<i class="ion ion-bug"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-yellow">
							<div class="inner">
							<h3>
							<%
										//String result = request.getParameter("usageList");

										int consumer =(Integer) request.getAttribute("customerCount");
										
										out.println(consumer);
									%>
							
							</h3>
								
								<p>Consumers</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					
					<!-- ./col -->
				</div>


				<div class="lockscreen-wrapper">
					<div class="lockscreen-logo">
						<b>Energy</b>Monitor
					</div>

					<div class="lockscreen-item">
						<div class="lockscreen-image">
							<img src="resources/dist/img/user1-128x128.jpg" alt="User Image">
						</div>
						
					
						<form class="lockscreen-credentials">
							<div class="input-group">
							<label><%
								String name=(String)request.getAttribute("userName");
								out.println(name);
							%></label>
								
							</div>
						</form>

					</div>
					<br><br>
					<div class="lockscreen-footer text-center">
						Copyright © 2014-2016 <b><a href="http://almsaeedstudio.com"
							class="text-black">Almsaeed Studio</a></b><br> All rights
						reserved
					</div>
				</div>

			</section>


		</div>
	  
	  <jsp:include page="partials/footer.jsp"></jsp:include>
	
	</div>

	<jsp:include page="partials/scripts.jsp"></jsp:include>

	
	<!-- ChartJS 1.0.1 -->
	
	<script src="resources/plugins/chartjs/Chart.min.js"></script>
	
		<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js"></script>
	
	
	
     
</body>
</html>
