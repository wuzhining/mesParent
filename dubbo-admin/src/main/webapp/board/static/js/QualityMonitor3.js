
(function(){
	function csbkbInfo(){
		test = function() 
		{ 
			var lx = getQueryString("line");
			var sbbm = getQueryString("shebei");
			var cctm  = {A:'08:00-10:00', B:'10:00-12:00', C:'12:00-14:00', D:'14:00-16:00', E:'16:00-18:00', F:'18:00-20:00', G:'20:00-22:00', H:'22:00-24:00'};
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
			
			var ajaxFinishParam={
					url: '/iPlant_ajax',
					data:{
						   IFS: 'MES_R0048',
			               REQ_TIME:dtime,
			               LINE_CD:lx
					},
					successCallBack:function(data){
						var timeCategory=[];
						var prodCnt=[];
						var colorArray=['#F6BD0F','#AFD8F8','#8BBA00','#FF8E46','#008E8E','#D64646','#8E468E','#0099FF', '#00CC99', '#FFFF33', '#f7a35c', '#8085e9','#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'];
						
						if(data.RESPONSE[0].RESPONSE_DATA.length>0){
							var prodData=data.RESPONSE["0"].RESPONSE_DATA;
							for(var i=0;i<prodData.length;i++){
								timeCategory.push(prodData[i].MT_DEF_NM);//名称
								prodCnt.push({color:colorArray[i],y:parseInt(prodData[i].DFCT_QTY)});//数量
							}
						}else{
							timeCategory = ['规格不符','按键不良','功能不达标','电池充电慢','Chl freg max'];
							prodCnt = [0,0,0,0,0];
						}
						
						Highcharts.chart('container3', {
						    chart: {
						        type: 'column',
						        options3d: {
						            
						            alpha: 2,
						            beta: 3,
						            depth: 45
						        }
						    },
						    title: {
						        text: '<span style="color:#1771B3;font-weight: bold;font-size:6px;">缺陷排名</span>'
						    },
						    plotOptions: {
						        column: {
						            depth: 25,
						            dataLabels:{
							        	enabled:true
			                        }
						        }
						    },
						    xAxis: {
						    	categories: timeCategory,
						    	labels: {
			                        style: {
			                            color: '#19a0f5',//颜色
			                            fontSize:'4px'  //字体
			                        }
			                 },
						    },
						    yAxis: {
						    	min:0,
		       			        minRange: 1,
						        title: {
						            text: null
						        },
						        labels: {
			                        style: {
			                            color: '#19a0f5',//颜色
			                            fontSize:'4px'  //字体
			                        }
			                 },
						    },
						    series: [{
						        name: '<span style="font-size: 4px;">缺陷</span>',
						        data: prodCnt}],
						    credits: {
						          enabled:false
						},exporting: {
					        enabled:false
						},legend: {                                                                    
							enabled: false                                                           
							}

						});	
						
			     },
			     errorCallBack:function(e){
						var a=e;
			     }
			}
			iplantAjaxRequest(ajaxFinishParam);
		} 
	}
		csbkbInfo.prototype={
				init: function () {
						test();
						var t=setInterval(function  () {
							test();
						},60000);
					}
				}
				
		var csbkb = new csbkbInfo();
		csbkb.init();
})();



