function yearSelect(){
	var year=$('#billYearSelect').val();
	console.log("Year Changed to "+year);
	var data={};
	data["year"]=year;
	
	$.ajax({
		type : "POST",
		contentType : "plain/text",
		url : "/EnergyMonitor/ajaxBillYearChange",
		data : year,
		dataType : 'text',
		timeout : 100000,
		success : function(data) {
			console.log(dataSet);
			console.log("SUCCESS: ", data);
			var result=(data.replace("[","")).replace("]","");
			console.log(result);
			
			var myArray = result.split(",");
			for(var i=0; i<myArray.length; i++) { myArray[i] = +myArray[i]; } 
			console.log(myArray);
			dataSet=myArray;
			drawBillUsageCharts();
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	

	
	
}