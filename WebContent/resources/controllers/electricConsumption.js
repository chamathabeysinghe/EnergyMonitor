console.log("CAM TO CONSUMPTION 233434we2 ")
selectProvince("wer");

var timeLabel=[]
var timeData=[]
var yearLabel=[]
var yearData=[]
function selectProvince(provincename){
	timeLabel=[];
	timeData=[]
	yearLabel=[]
	yearData=[]
	var province=provincename;
	var data={};
	data["province"]=province;
	
	$.ajax({
		type : "POST",
		contentType : "plain/text",
		url : "/EnergyMonitor/ajaxConsumptionForProvince",
		data : province,
		dataType : 'text',
		timeout : 100000,
		success : function(data) {
			//$('#consumptionChartProvince')[0].scrollIntoView( true );

			console.log("SUCCESS: ", data);
			var jsonStr=data
			var jsonObj=JSON.parse(jsonStr);
			var jsonTime=jsonObj.TimeUsage;
			var jsonTotal=jsonObj.TotalUsage;
			
			
			for(var j in jsonTime){
				timeLabel.push(j)
				timeData.push(parseFloat(jsonTime[j]))
			}
			
			
			for(var j in jsonTotal){
				yearLabel.push(j)
				yearData.push(parseFloat(jsonTotal[j]))
			}
			console.log(yearLabel);
			console.log(yearData);
			drawConsumptionChartForProvince();
			drawTimeChartForProvince();
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});	
}