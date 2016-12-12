<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Make Complaint</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="resources/plugins/iCheck/square/blue.css">



<!--  Loading complaint_styling.css file  -->
<link rel="stylesheet"  type="text/css" href="resources/css/complaints_styling.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
	<div class="container-fluid" id="make_complaint_container"> 
	<div class="row">
		<div class="col-md-12">
			<div class="page-header">
				<h1>
					Consumer Complaint Entry Form
				</h1>
			</div>
			<p>You can now submit your complaints/grievances that could not be solved through our division or sub-division catering to your locality. 
			</p><p>It is expected that you provide us with the details regarding your efforts to solve the problem locally before it became necessary to submit your grievence through this channel. </p>
			<form class="form-horizontal" role="form">
			
			    <!-- Input Name -->
				<div class="form-group"> 
					<label for="input_name" class="col-sm-2 control-label">
						Name
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_name" />
					</div>
				</div>
				
				<!-- Input Account No. -->
				<div class="form-group"> 
					<label for="input_accountNo" class="col-sm-2 control-label">
						Account No.
					</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="input_accountNo" />
					</div>
				</div>
				
				<!-- Input Address -->
				<div class="form-group"> 
					<label for="input_address" class="col-sm-2 control-label">
						Address
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_address" />
					</div>
				</div>
				
				<!-- Input Email -->
				<div class="form-group"> 
					<label for="input_email" class="col-sm-2 control-label">
						Email
					</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="input_email" />
					</div>
				</div>
				
				<!-- Input Telephone Number -->
				<div class="form-group"> 
					<label for="input_tel" class="col-sm-2 control-label">
						Telephone Number
					</label>
					<div class="col-sm-10">
						<input type="tel" class="form-control" id="input_tel" />
					</div>
				</div>
				
				<!-- Input Complaint Subject -->
				<div class="form-group"> 
					<label for="input_subject" class="col-sm-2 control-label">
						Complaint Subject
					</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="input_subject" />
					</div>
				</div>
				
				<!-- Input Complaint Description -->
				<div class="form-group"> 
					<label for="input_description" class="col-sm-2 control-label">
						Complaint Description
					</label>
					<div class="col-sm-10">
						<textarea id="input_description" name="input_description" style="width:100%; height:150px; border-color: #BCD4E6;"></textarea>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 
						<button type="submit" class="btn btn-default">
							Submit
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


	<!-- jQuery 2.2.3 -->
	<script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/plugins/iCheck/icheck.min.js"></script>
	
</body>
</html>

