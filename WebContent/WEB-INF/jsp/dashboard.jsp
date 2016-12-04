<%@ page contentType="text/html; charset=UTF-8" %>

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
	  
	    <jsp:include page="partials/contentheader.jsp"></jsp:include>
	    
	    <section class="content">
	    </section>
	   
	  
	  </div>
	  
	  <jsp:include page="partials/footer.jsp"></jsp:include>
	
	  <jsp:include page="partials/controllsidebar.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->
<jsp:include page="partials/scripts.jsp"></jsp:include>

</body>
</html>
