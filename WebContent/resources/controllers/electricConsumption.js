console.log("CAM TO CONSUMPTION 233434we2 ")
selectProvince("wer");

var timeLabel=[]
var timeData=[]
var yearLabel=[]
var yearData=[]

var predictionLabel=[]
var predictionData=[]

function selectProvince(provincename){
	console.log("REseting");
	timeLabel=[];
	timeData=[]
	yearLabel=[]
	yearData=[]
	predictionLabel=[]
	predictionData=[]
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
			var jsonPrediction=jsonObj.PredictedUsage;
			
			for(var j in jsonTime){
				timeLabel.push(j)
				timeData.push(parseFloat(jsonTime[j]))
			}
			
			
			for(var j in jsonTotal){
				yearLabel.push(j)
				yearData.push(parseFloat(jsonTotal[j]))
			}
			console.log("PREDICTIONS RECEIVED ***sdfdfasd**   "+jsonPrediction);

			for(var j in jsonPrediction){
				predictionLabel.push(j);
				predictionData.push(parseFloat(jsonPrediction[j]));
			}
			console.log(predictionLabel);
			console.log(predictionData);
			
			drawConsumptionChartForProvince();
			drawTimeChartForProvince();
			drawConsumptionChartForPrediction();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});	
}