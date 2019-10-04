$(function () {
	var dtime;
	iplantAjaxRequest({
        url: '/iPlant_ajax',
        data: {
            IFS: 'S0000021',
        },
        async: false,
        successCallBack: function (data) {
     	   if(data.RESPONSE[0].RESPONSE_DATA.length>0){
     		   oldTime = data.RESPONSE[0].RESPONSE_DATA[0].SYS_TIME;
     		   var year = parseInt(oldTime.slice(0,4));
	        		 //判断小于10，前面补0
	       			if (year < 10) {
	       				year = "0" + year;
	       			}
	       			
     		   var month = parseInt(oldTime.slice(5,7));
	        		 //判断小于10，前面补0
	       			if (month < 10) {
	       				month = "0" + month;
	       			}
	       			
     		   var day = parseInt(oldTime.slice(8,10));
	        		 //判断小于10，前面补0
	       			if (day < 10) {
	       				day = "0" + day;
	       			}
     		   
     		   var hours = parseInt(oldTime.slice(11,13));
	        		if (hours < 10) {
	       				hours = "0" + hours;
	       			}
	        		
     		  var minutes = parseInt(oldTime.slice(14,16));
	        		//判断小于10，前面补0
	      			if (minutes < 10) {
	      				minutes = "0" + minutes;
	      			}
	      			
     		   var seconds = parseInt(oldTime.slice(17));
	        		 //判断小于10，前面补0
	       			if (seconds < 10) {
	       				seconds = "0" + seconds;
	       			}
	       			
	       			var date_str ="";
	    			if(parseInt(hours)>=8 && parseInt(hours)<20){
	    				dtime = year + "-" + month + "-" + day + " " + "08" + ":" + "00" ;
	    			}else{
	    				if(parseInt(hours)<8){
	    					var year1 = parseInt(oldTime.slice(0,4));
	    					//判断小于10，前面补0
	    					if (year1 < 10) {
	    						year1 = "0" + year;
	    					}
	    			
	    					//月
	    					var month1 = parseInt(oldTime.slice(5,7));
	    					//判断小于10，前面补0
	    					if (month1 < 10) {
	    						month1 = "0" + month1;
	    					}
	    			
	    					//日
	    					var day1 = parseInt(oldTime.slice(8,10))-1;
	    					//判断小于10，前面补0
	    					if (day1 < 10) {
	    						day1 = "0" + day1;
	    					}
	    					//拼接年月日时分秒
	    					dtime = year1 + "-" + month1 + "-" + day1 + " " + "20" + ":" + "00" ;
	    				}else{
	    					//拼接年月日时分秒
	    					dtime = year + "-" + month + "-" + day + " " + "20" + ":" + "00" ;
	    				}
	    			}
     	   }
        }
    });
	var lx = getQueryString("line");
	var sbbm = getQueryString("shebei");
	var cctm  = {A:'08-09', B:'09-10',C:'10-11', D:'11-12', E:'12-13', F:'13-14', G:'14-15', H:'15-16', I:'16-17', J:'17-18',K:'18-19', L:'19-20'};
	ccFUn();
	var t=setInterval(function  () {
		ccFUn();
	},60000);
	/*产能完成情况*/
	function ccFUn(){
	var timeCategory=[];
	var prodCnt=[],finishedCnt=[],targetCnt=[];
	var ajaxFinishParam={
			url: '/iPlant_ajax',
			data:{
				   IFS: 'MES_R0007',
	               REQ_TIME:dtime,
	               LINE_CD:lx,
	               ET_CD:sbbm,
	               SHIFT_CD:'A'
			},
			successCallBack:function(data){
				if(data.RESPONSE[0].RESPONSE_DATA.length>0){
					var channengData = data.RESPONSE["0"].RESPONSE_DATA;
					var keys = [];
		        	var tm = [];
					for(var o in cctm){
	        			   keys.push(o);
	        		   }
	        		   $.each(channengData,function(b,op){
	        			   tm.push(op.TM);
	        		   });
	        		   $.each(keys,function(k,objs){
	        			   for(var i=0; i<channengData.length; i++){
	        				   if($.inArray(objs,tm)<0){
	        					   prodCnt.push('');
	        					   finishedCnt.push('');
	        					   return
	        				   }
	        				   if(objs == channengData[i].TM){
	        						prodCnt.push(parseInt(channengData[i].WC_QTY1));
	        						finishedCnt.push(parseInt(channengData[i].WC_QTY2));
	        				   }
	        			   }
	        		   });
	        		   for(var i=0;i<12;i++){
	        			   targetCnt.push(parseInt(channengData[0].CAPA));
	        		   }
				}else{
					prodCnt=[0,0,0,0,0,0,0,0,0,0,0,0];
					targetCnt=[360,360,360,360,360,360,360,360,360,360,360,360];
					finishedCnt=[0,0,0,0,0,0,0,0,0,0,0,0];
				}
				
        		  
				var seriesData= [{name: '<span style="font-size:6px;">完成数<span>',data: finishedCnt},{
		            type: 'spline',
		            name: '<span style="font-size:6px;">目标数<span>',
		            data: targetCnt,
		            marker: {
		                lineWidth: 2,
		                lineColor: 'yellow',
		                fillColor: 'red'
		            }},{
					    type: 'spline',
					    name: '<span style="font-size:6px;">完成数量<span>',
					    data: prodCnt,
					    marker: {
					        lineWidth: 2,
					        lineColor: 'green'
				}}];
				$('#divProdFinished').highcharts({
			    	 chart: {
			             type: 'column'
			         },
			         credits:{
			         	enabled:false
			         },
			         title: {
			             text: ''
			         },
			         colors: ['#0099FF', '#00CC99', '#FFFF33', '#f7a35c', '#8085e9','#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'], 
			         xAxis: 
			         {
			        	 min : 0,
		       		     max : 11,
			             categories: ['08-09', '09-10', '10-11', '11-12', '12-13', '13-14',
		 		       					'14-15', '15-16', '16-17', '17-18', '18-19', '19-20'],
			             crosshair: true
			         },
			         yAxis: 
			         {
			        	 labels: {
		                        style: {
		                            color: '#19a0f5',//颜色
		                            fontSize:'4px'  //字体
		                        }
		                 },
			             min: 1,
			             title: {
			                 text: ''
			             }
			         },
			         tooltip: {
			             headerFormat: '<span style="font-size:6px">{point.key}</span><table>',
			             pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			             '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
			             footerFormat: '</table>',
			             shared: true,
			             useHTML: true
			         },
			         plotOptions: {
			             column: {
			                 pointPadding: 0.2,
			                 borderWidth: 0,
			                 dataLabels:{
		                            enabled:true, // dataLabels设为true
		                            style:{
		                                color:'#D7DEE9'
		                            },
		                            formatter : function(){
		                            	if(this.y=='undefined'){
		                            		this.y = '';
		                            	}
		                            	return this.y
		                            }
		                        }
			             }
			         },
			         series: seriesData,
					    credits: {
					          enabled:false
					},exporting: {
				        enabled:false
					},legend: {
						align: "center", //程度标的目标地位
						verticalAlign: "bottom", //垂直标的目标地位
						x: 0, //间隔x轴的间隔
						y: 0,//间隔Y轴的间隔
						itemStyle : {
					        'fontSize' : '4px'
					    }
					}
			    }); 
				
	     },
	     errorCallBack:function(e){
				var a=e;
	     }
	}
	iplantAjaxRequest(ajaxFinishParam);
	}
});


