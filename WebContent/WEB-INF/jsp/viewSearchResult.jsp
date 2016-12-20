<%@page import="com.ceb.models.Bill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>View BILL</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <jsp:include page="partials/styles.jsp"></jsp:include>
  <jsp:include page="partials/scripts.jsp"></jsp:include>
  
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="partials/header.jsp"></jsp:include>
		<jsp:include page="partials/sidenav.jsp"></jsp:include>

		<div class="content-wrapper">



			<section class="content-header">

				<h1>View Bills</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">View bill</li>
				</ol>
				
			</section>


			<section class="content">
				<%
    	//String result = request.getParameter("usageList");
		

		
		Object value=request.getAttribute("billList");
		List<Bill> bills=(List<Bill>)value;
		if(bills.size()<=0){
			out.println("<h2>No record found.</h2>");
			//out.println("dlknfkdhfnkldsnfkl");
		}else{
			for( Bill bill :bills){
				out.println("<div class=card card-inverse card-primary text-xs-center style=background-color: #333; border-color: #333;>"+
						 " <div class=card-block>"+
			    "<blockquote class=card-blockquote>"+
			    		" <div class=row>"+
			     			 "<label class= col-sm-4 label label-primary>Bill ID</label>"+
			     			 "<label class= col-sm-8 label>"+bill.getBillID()+"</label>"+
			     		" </div>"+
			     		" <div class=row>"+
		     			 	"<label class= col-sm-4 label label-primary>Connection ID</label>"+
		     			 	"<label class= col-sm-8 label>"+bill.getConnectionID()+"</label>"+
		     			" </div>"+
		     			" <div class=row>"+
	     			 		"<label class= col-sm-4 label label-primary>Month/Year</label>"+
	     			 		"<label class= col-sm-8 label>"+bill.getMonth()+" / "+bill.getYear()+"</label>"+
	     				" </div>"+
	     				" <div class=row>"+
	     			 		"<label class= col-sm-4 label label-primary>Usage</label>"+
	     			 		"<label class= col-sm-8 label>"+bill.getUsage()+"</label>"+
	     				" </div>"+
	     				" <div class=row>"+
	     			 		"<label class= col-sm-4 label label-primary>Amount</label>"+
	     			 		"<label class= col-sm-8 label>"+bill.getAmount()+"</label>"+
	     				" </div>"+
			     		
			     "</blockquote>"+
			 " </div>"+
				"</div>");
			}	
		}
		
	//	String result[]=(String[])value;
	//	out.println("var dataSet="+result[1]+";");
	//	out.println("var labelSet="+result[0]+";");
	//	out.println("console.log(dataSet);");
	%>
				
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

	

