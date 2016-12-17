<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="com.ceb.models.EnergyConsumption" %>
<%@ page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <title>Consumer | Usage Summary</title>
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
		      
		      <h1>
		        Consumer Name
		        <small>Usage</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		        <li class="active">Usage Meter</li>
		      </ol>
		</section>
	    
	    
	    <section class="content">
	    	<div class="row">
	    
	    	<!-- Should figure out what is the error in this divc -->
       			 <div class="col-md-6 hide">
				          <!-- AREA CHART -->
				          <div class="box box-primary">
				            <div class="box-header with-border">
				              <h3 class="box-title">Area Chart</h3>
				
				              <div class="box-tools pull-right">
				                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
				                </button>
				                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
				              </div>
				            </div>
				            <div class="box-body">
				              <div class="chart">
				                <canvas id="areaChart" style="height: 329px; width: 476px;" height="296" width="428"></canvas>
				              </div>
				            </div>
				            <!-- /.box-body -->
				          </div>
				          <!-- /.box -->
     		 </div>
     		 
     		 	
	    		<div class="col-md-12">
	    		
	    		
		    		<div class="form-group">
	                  <select id="billYearSelect" class="form-control selectpicker" data-style="btn-success" onchange='yearSelect()'>
	                    <option value="2016">2016 Electricity Bills</option>
	                    <option value="2015">2015 Electricity Bills</option>
	                    <option value="2014">2014 Electricity Bills</option>
	                    <option value="2013">2013 Electricity Bills</option>
	                    <option value="2012">2012 Electricity Bills</option>
	                  </select>
	                </div>
		          <div class="box box-info">
		            <div class="box-header with-border">
		              <h3 class="box-title">Line Chart</h3>
		
		              <div class="box-tools pull-right">
		                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
		                </button>
		                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
		              </div>
		            </div>
		            <div class="box-body">
		              <div class="chart">
		                <canvas id="lineChart" style="height: 181px; width: 493px;" height="203" width="554"></canvas>
		              </div>
		            </div>
		          </div>
		          
		          
		           <div class="box box-info">
		            <div class="box-header with-border">
		              <h3 class="box-title">Line Chart</h3>
		
		              <div class="box-tools pull-right">
		                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
		                </button>
		                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
		              </div>
		            </div>
		            <div class="box-body">
		              <div class="chart">
		                <canvas id="billChart" style="height: 181px; width: 493px;" height="203" width="554"></canvas>
		              </div>
		            </div>
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
	<%
    	//String result = request.getParameter("usageList");
		
		
		
		Object value=request.getAttribute("usageList");
		Object valueAmount=request.getAttribute("billList");
		String result[]=(String[])value;
		String resultAmount[]=(String[])valueAmount;
		out.println("var dataSet="+result[1]+";");
		out.println("var dataSet2="+resultAmount[1]+";");
		out.println("var labelSet="+result[0]+";");
		
		out.println("console.log(dataSet);");
	%>
	</script>
	<script src="resources/chartjs/chart.js"></script>
	<script src="resources/controllers/customerusagecontroller.js"></script>
	
</body>
</html>
