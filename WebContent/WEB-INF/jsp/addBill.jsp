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
	<jsp:include page="partials/header.jsp"></jsp:include>
	
	 <div class="page-header text-center">
  			<h1 >Add New Bill</h1>
	</div>
	<script>

</script>
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
			data : {msg:JSON.stringify(search)},
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
</body>
</html>



