<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>ADD BILL</title>
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

				<h1>Add Bill</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Add bill</li>
				</ol>
				
			</section>


			<section class="content">
				<form class="form-horizontal" id="save-form ">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Connection ID</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="connectionID">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Month/Year</label>
				<div class="col-sm-4" >
					<input type="text" class="form-control"   id="month" >
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Usage</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="usage">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Amount</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="amount">
				</div>
			</div>
			
			
		</form>
		<div >
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-save"
						class="btn btn-primary btn-lg" onclick="saveViaAjax()">Save</button>
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
	function saveViaAjax() {

		var search = {}
		search["connectionID"] = $("#connectionID").val();
		search["month"] = $("#month").val().split("/")[0];
		search["year"] = $("#month").val().split("/")[1];
		search["usage"] = $("#usage").val();
		search["amount"] = $("#amount").val();

		$.ajax({
			type : "POST",
			url : "/EnergyMonitor/saveBill",
			data : {connectionID:search["connectionID"],month:search["month"],year:search["year"],usage:search["usage"],amount:search["amount"]},
			dataType : 'text',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
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
</script>

</html>



