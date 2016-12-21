<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>New connection</title>
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

				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">new connection</li>
				</ol>
				
			</section>


			<section class="content">
				<div >
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Add new Connection</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form">
                <div class="form-group">
                  <label for="exampleInputEmail2">Connection Address</label>
                  <input type="text" class="form-control" id="connectionAddress" placeholder="Enter connection address">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Connection Category</label>
                  <input type="text" class="form-control" id="connectionCategory" placeholder="Enter connection category">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">LocationID</label>
                  <input type="text" class="form-control" id="locationID" placeholder="enter locationID">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">CustomerID</label>
                  <input type="text" class="form-control" id="customerID" placeholder="enter CustomerID">
                </div>
                
                
              </div>
              <!-- /.box-body -->

           
            </form>
          </div>
		<div >
				<div >
					<button type="submit" id="bth-save"
						class="btn btn-primary" onclick="validate()">Save</button>
				</div>
			</div>
			<div id="feedback" class="col-sm-offset-2 col-sm-10"></div>

	
				
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

<script>

	function validate(){
		//console.log("validate working");
		var search = {}
		search["connectionID"] = $("#customerID").val();
		search["amount"] = $("#locationID").val();
		var check=true;
		for (var val in search) {
			//console.log("loop works for "+search[val]);
			if(!numcheck(search[val])){
				//console.log("loop check works and fail for "+search[val]);
				check=false;
			}
		}
		if(check){
			saveViaAjax();
		}else{
			$('#feedback').html("Please check input values again.");
		}
		
	}
	function numcheck(data){
		
		return (data - 0) == data && data.length > 0;
	}
	
	
	function saveViaAjax() {
		//console.log("SUCCESS: ", $("#datepicker").val());
		var search = {}
		search["connectionAddress"] = $("#connectionAddress").val();
		search["customerID"]=$("#customerID").val();
		search["category"] = $("#connectionCategory").val();
		search["locationID"] = $("#locationID").val();

		$.ajax({
			type : "POST",
			url : "/EnergyMonitor/saveConnection",
			data : {connectionAddress:search["connectionAddress"],customerID:search["customerID"],category:search["category"],locationID:search["locationID"]},
			dataType : 'text',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display("Server error occured. Please check data again.");
			},
			done : function(e) {
				console.log("DONE");
				enableSaveButton(true);
			}
		});

	}

	function enableSaveButton(flag) {
		$("#btn-save").prop("disabled", flag);
	}

	function display(data) {
		var json = "<h4>"+JSON.stringify(data, null, 4) +"</h4>";
		$('#feedback').html(json);
	}
	
	
	$('#datepicker').datepicker({
	      autoclose: true
	    });

</script>

</html>



