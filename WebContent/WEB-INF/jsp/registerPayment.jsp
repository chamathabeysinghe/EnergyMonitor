<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ADD Payment</title>
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
				<li class="active">Add Payments</li>
			</ol>

			</section>


			<section class="content">
			<div>
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">Add Payments</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form role="form">
						<div class="box-body">
							<div class="form-group">
								<label>Date</label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control pull-right"
										id="datepicker">
								</div>
								<!-- /.input group -->
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Connection ID</label> <input
									type="text" class="form-control" id="connectionID"
									placeholder="Enter connection ID">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Amount</label> <input
									type="text" class="form-control" id="amount"
									placeholder="enter amount">
							</div>


						</div>
						<!-- /.box-body -->


					</form>
				</div>
				<div>
					<div>
						<button type="submit" id="bth-save" class="btn btn-primary"
							onclick="validate()">Save</button>
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
	function validate() {
		//console.log("validate working");
		var search = {}
		search["connectionID"] = $("#connectionID").val();
		search["amount"] = $("#amount").val();
		var check = true;
		for ( var val in search) {
			//console.log("loop works for "+search[val]);
			if (!numcheck(search[val])) {
				//console.log("loop check works and fail for "+search[val]);
				check = false;
			}
		}
		if (check) {
			saveViaAjax();
		} else {
			$('#feedback').html("Please check input values again.");
		}

	}
	function numcheck(data) {

		return (data - 0) == data && data.length > 0;
	}

	function saveViaAjax() {
		//console.log("SUCCESS: ", $("#datepicker").val());
		var search = {}
		search["connectionID"] = $("#connectionID").val();
		search["date"] = $("#datepicker").val();
		search["amount"] = $("#amount").val();

		$.ajax({
			type : "POST",
			url : "/EnergyMonitor/savePayment",
			data : {
				connectionID : search["connectionID"],
				date : search["date"],
				amount : search["amount"]
			},
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
		var json = "<h4>" + JSON.stringify(data, null, 4) + "</h4>";
		$('#feedback').html(json);
	}

	$('#datepicker').datepicker({
		autoclose : true
	});
</script>

</html>



