<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="com.ceb.models.EnergyConsumption" %>
<%@ page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <title>AdminLTE 2 | Dashboard</title>
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
				Summary 
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
     		 	<div class="col-md-4" style="position:relative; display:inline;">
     		 	<jsp:include page="partials/map.jsp"></jsp:include>
     		 		
     		 		
     		 	</div>
	    		<div class="col-md-6 col-md-offset-1">
					<div class="row">
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
		                <canvas id="consumptionChart" style="height: 181px; width: 493px;" height="203" width="554"></canvas>
		              </div>
		            </div>
		          </div>
		          </div>
		          
		          <div class="row">
		          	<div class="col-md-6">
				          <div class="box box-danger">
					            <div class="box-header with-border">
					              <h3 class="box-title">Day/Night Consumption</h3>
					
					              <div class="box-tools pull-right">
					                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
					                </button>
					                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
					              </div>
					            </div>
					            <div class="box-body">
					              <canvas id="consumptionByTime" style="height: 169px; width: 338px;" height="152" width="304"></canvas>
					            </div>
					            <!-- /.box-body -->
					     </div>
				     </div>
				     <div class="col-md-6">
				     
					     <div class="box box-danger">
					            <div class="box-header with-border">
					              <h3 class="box-title">Provisional Consumption</h3>
					
					              <div class="box-tools pull-right">
					                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
					                </button>
					                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
					              </div>
					            </div>
					            <div class="box-body">
					              <canvas id="consumptionByProvince" style="height: 169px; width: 338px;" height="152" width="304"></canvas>
					            </div>
					            <!-- /.box-body -->
					     </div>
				     </div>
				     
				</div>          
		          
		        </div>
	    	
	    	</div>
	    	
	    	<br><br><br>
	    	<!-- For the provisional view interfaces -->
	    	<div class="row " id="provisionalView">
	    		<div class="col-md-6">
	    	
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
			                <canvas id="consumptionChartProvince" style="height: 200px; width: 493px;" height="200" width="554"></canvas>
			              </div>
			            </div>
			          </div>
			         
			        
				</div>   
				
				<div class="col-md-6">
	    	
		    		<div class="box box-info">
			            <div class="box-header with-border">
			              <h3 class="box-title">Expected Growth</h3>
			
			              <div class="box-tools pull-right">
			                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
			                </button>
			                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
			              </div>
			            </div>
			            <div class="box-body">
			              <div class="chart">
			                <canvas id="expectedGrowthChart" style="height: 200px; width: 493px;" height="200" width="554"></canvas>
			              </div>
			            </div>
			          </div>
			         
			        
				</div>   
				
				<div class="col-md-3">
					 <div class="box box-danger">
			            <div class="box-header with-border">
			              <h3 class="box-title">Day/Night Consumption</h3>
			
			              <div class="box-tools pull-right">
			                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
			                </button>
			                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
			              </div>
			            </div>
			            <div class="box-body">
			              <canvas id="timeChartProvince" style="height: 169px; width: 338px;" height="152" width="304"></canvas>
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
	
		<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js"></script>
	<script type="text/javascript">
		<%
		//String result = request.getParameter("usageList");

		Object value1=request.getAttribute("usageList");
		String result[]=(String[])value1;
		out.println("var dataSet="+result[1]+";");
		out.println("var labelSet="+result[0]+";");
		
		Object value2=request.getAttribute("usageListByTime");
		String resultByTime[]=(String[])value2;
		out.println("var dataSetByTime="+resultByTime[1]+";");
		out.println("var labelSetByTime="+resultByTime[0]+";");
		out.println("console.log(dataSetByTime[0])");
		
		Object value3=request.getAttribute("usageListByProvince");
		String resultByProvince[]=(String[])value3;
		out.println("var dataSetByProvince="+resultByProvince[1]+";");
		out.println("var labelSetByProvince="+resultByProvince[0]+";");
		out.println("console.log(dataSetByProvince[0])");
		%>
	
	</script>
	
	
	<script src="resources/chartjs/consumptionChart.js"></script>
	<script src="resources/controllers/electricConsumption.js"></script>
	
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery.maphilight.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.map').maphilight();
		});
	</script>
	<script type="text/javascript">
		$(".province").on("click",function(e){
			e.preventDefault();
			var province=$(this).data("province");
			selectProvince(province)
		});
	</script>
	
	
     
</body>
</html>
