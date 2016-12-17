
var timeLabel=[]
var timeData=[]
var yearLabel=[]
var yearData=[]

var predictionLabel=[]
var predictionData=[]

function selectProvince(provincename){
	$('#provisionalView').removeClass('hide');
	$('#provinceSummary').text(provincename);
	$('html, body').animate({ scrollTop: $('#provisionalView').offset().top }, 'slow');

	console.log("FNAME IS SETTED "+provincename)
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
			console.log("DFDF");
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

			for(var j in jsonPrediction){
				predictionLabel.push(j);
				predictionData.push(parseFloat(jsonPrediction[j]));
			}
			
			
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