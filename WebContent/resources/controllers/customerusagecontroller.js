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
		success : function(dataReturn) {
			console.log(dataSet);
			console.log("SUCCESS: ", dataReturn);
			var data=dataReturn.split("::")[0];
			var result=(data.replace("[","")).replace("]","");
			console.log(result);
			
			var myArray = result.split(",");
			for(var i=0; i<myArray.length; i++) { myArray[i] = +myArray[i]; } 
			console.log(myArray);
			dataSet=myArray;
			drawBillUsageCharts();
			
			var dataAmount=dataReturn.split("::")[1];
			var resultAmount=(dataAmount.replace("[","")).replace("]","");
			console.log(resultAmount);
			
			var myArrayAmount = resultAmount.split(",");
			for(var i=0; i<myArrayAmount.length; i++) { myArrayAmount[i] = +myArrayAmount[i]; } 
			console.log("MyArrayAmount"+myArrayAmount);
			console.log(myArrayAmount);
			dataSet2=myArrayAmount;
			drawBillAmountCharts();			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});	
}