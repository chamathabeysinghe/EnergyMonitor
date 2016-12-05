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
       			 <div class="col-md-6">
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
	    	
	    </section>
	    
	    
	  </div>
	  
	  <jsp:include page="partials/footer.jsp"></jsp:include>
	
	  <jsp:include page="partials/controllsidebar.jsp"></jsp:include>
	</div>

	<jsp:include page="partials/scripts.jsp"></jsp:include>


	
</body>
</html>
