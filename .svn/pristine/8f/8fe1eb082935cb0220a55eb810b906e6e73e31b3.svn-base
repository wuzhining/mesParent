

//Highcharts.setOptions(my_skin); 
var tm = ['a10001','a10002','a10003','a10004','a10005','a10006','a10007','a10008','a10009','a10010','a10011','a10012','a10013','a10014','a10015','a10016'];
		       Highcharts.chart('container1', {
      			    chart: {
      			        type: 'column',
      			        backgroundColor:'',
      			    },
      			    title: {
      			        text: null//'<span>次品示意图</span>'
      			    },
      			    plotOptions: {
      			        column: {
      			             depth: 25,
	       			          dataLabels:{
	                              enabled:true, // dataLabels设为true
	                              style:{
	                                  color:'#D7DEE9'
	                              }
	                          }
      			        },
	       			     series: {
	       		            animation: {
	       		                duration: 5000,
	       		                easing: 'easeOutBounce'
	       		            }
	       			     }
      			    },
      			    xAxis: {
      			    	categories: ['a10001','a10002','a10003','a10004','a10005','a10006']/*tm*/,
      			    	min : 0,
				    	max: tm.length - 1
      			    },
      			    yAxis: {
      			        title: {
      			            text: null
      			        },
      			        min:0,
      			        minRange: 1
      			    },
      			    series: [{
      			        name: '<span>产量</span>',
      			        data: [3,7,8,4,2,5]/*Aarr*/
      			    }],
      			    legend: {                                                                  
    			    	enabled: false                                                         
    			  	},
      			    credits: {
      			          enabled:false
      			    },exporting: {
      			    	enabled:false
      			    },
      			});	


	//
		       Highcharts.chart('container2',{
		    		chart: {
		    			type: 'area',
		    			backgroundColor:'',
		    		},
		    		title: {
		    			text: null
		    		},
		    		xAxis: {
		    			allowDecimals: false,
		    			categories:['09-09','09-01','07-08','04-02','08-09','06-07'],
		    		},
		    		yAxis: {
		    			labels: {
		    				formatter: function () {
		    					return this.value / 1000 + 'k';
		    				}
		    			}
		    		},
		    		tooltip: {
		    			pointFormat: '{series.name} 制造 <b>{point.y:,.0f}</b>枚弹头'
		    		},
		    		plotOptions: {
		    			area: {
		    				marker: {
		    					enabled: false,
		    					symbol: 'circle',
		    					radius: 2,
		    					states: {
		    						hover: {
		    							enabled: true
		    						}
		    					}
		    				}
		    			}
		    		},
		    		series: [{
		    			name: '美国',
		    			data: [ 6, 11, 32, 110, 235, 369]
		    		}],
		    		legend: {                                                                  
		    			enabled: false                                                         
	    			},
	      			credits: {
	      			    enabled:false
	      			},exporting: {
	      			    enabled:false
	      			},
		    	});

		       
		       var div1="";
		       var tj1,tj2;
		       var span1,span2,span3,span4,dImg;
		       var top1=0;
		       var left=0;
		       var Left;
		       var Top;
		       
		       for(var k=0;k<tm.length;k++){
		    	   if(k%4 == 0 && k!=0){
			    		  top1++;
			    		  left=0;
		    	   }
		    	   Top=2+top1*32;
		    	   Left=2+left*24;
		    	   
		    	   tj1="<div class='chickNow' pid='"+k+"'  style='width:20%;height:20%;position:absolute;top:"+Top+"%;left:"+Left+"%;padding:1%;'>";//border:1px solid #363a3e;
		    	   span1="<div class='changeNow' cid='"+k+"'  style='width:100%;height:100%;background-color:#062646;font-size:16px;'>";//border:2px dashed #9dffe4;
		    	   span2="<p style=''>设备：<span style='color:#fff;'>"+tm[k]+"</span></p>";
		    	   span3="<p>运行时间：<span style='color:#fff;'>12</span></p>"
		    	   span4="<p>转态：<span id='eqStatus' style='color:#fff;'>正常</span></p>";
		    	   $("#p1").append(tj1);
		    	   $("[pid="+k+"]").append(span1);
		    	   $("[cid="+k+"]").append(span2,span3,span4);
		    	   left++;
		    	   
		    	   
		       }
		       
		       
		       var clickCount=0;
		       var pidEver=[];
		       $("div .chickNow").click (function(){
		    		   
		    		
		    			   //if($("#eqStatus"). == "正常"){
		    			   var pid = $(this).attr("pid");
		    			   pidEver.push(pid);
		    			   $(".chickNow[pid="+pid+"]").css({/*"border":"2px dashed #9dffe4",*/"background-color":"#062646"});
		    			   $(".changeNow[cid="+pid+"]").css({/*"border":"1px dashed #1996c6",*/"background-color":"#081828"});
		    			   $(".changeNow[cid="+pid+"] span").css({"color":"#9dffe4"});
		    			   
		    			   $("#equipmentImg").attr({/*"src":"static/image/a00001.jpg",*/"alt":""+tm[pid]+".jpg"});
		    			   $("#equipmentNm").html(tm[pid]);
		    			   //}
		    			   for(var p=0;p<pidEver.length-1;p++){
		    				   
		    				   if(clickCount > 0 && pidEver[0]!=pidEver[1] ){
		    					   pid=pidEver[p];
		    					   $(".chickNow[pid="+pid+"]").css({/*"border":"1px solid #363a3e",*/"background-color":"#081828"});
		    					   $(".changeNow[cid="+pid+"]").css({/*"border":"2px dashed #9dffe4",*/"background-color":"#062646"});
		    					   $(".changeNow[cid="+pid+"] span").css({"color":"#fff"});
		    				   }
		    			   }
		    			   clickCount++;
		    			   if(clickCount>1){
		    				   pidEver.splice(0,1);
		    			   }
		    	  // }
		       });
		       
		       
		       
/* 启动时加载 

 
var S=0,D=0,H=0,Y=0,G=0,W=0;
var etcd=0;
(function() {
	OpenFrameAttribute = function (){
		var fl='float:left;'
			var avg=0;
		 var a1=$("#p1");
		 var te1,te2,te3,te4,t5;
		 var a2,a3,a4;
		 var e='eq';
		 var o='';
		 var o1='';
		 var count=0;
		 var sum=0;
		 var count1=0;
		 var u;
		 var mu=0;
		 var ajaxParam = {
				 url : '/iPlant_ajax',
    			 dataType : 'JSON',
    			 data:{
    				 IFS : 'B1001'
    			 },successCallBack : function(data){
    				 var op = data.RESPONSE[0].RESPONSE_DATA;
    					$.each(op,function(n,obj) {
    						
    						if(obj.ET_NM!=null){
    						count1++;
    						mu=obj;
    						if(obj.PRM_PRODDURA!=0 && obj.PRM_PRODDURA!=0){//查存在的机器，以便算平均稼动率
    							count++;
    							 u=Math.floor(obj.PRM_PRODQTY/(obj.PRM_STDCAP*obj.PRM_PRODDURA)*100 );
    							 sum+=u;
    						}
    						 s=Math.floor(obj.PRM_PRODQTY/(obj.PRM_STDCAP*obj.PRM_PRODDURA)*100 )+'%';
    						 if(s=='NaN%'){
    							 s=0;
    						 }
    						 if(obj.ET_ST=='生产中'){
    							 S++;
    						 }
    						 if(obj.ET_ST=='已报废'){
    							 Y++;
    						 }
    						 if(obj.ET_ST=='换线中'){
    							 H++;
    						 }
    						 if(obj.ET_ST=='待机中'){
    							 D++;
    						 }
    						 if(obj.ET_ST=='维修中'){
    							 W++;
    						 }
    						 if(obj.ET_ST=='故障中'){
    							 G++;
    						 }
    						 
    						o=obj.ET_CD+','+obj.EQ_IP+','+'START';
    						o1=obj.ET_CD+','+obj.EQ_IP+','+'STOP';
    						s1=$("<span style='color:#30CCC4;'>");
    						s2=$("<span style='color:#30CCC4;'>");
    						s3=$("<span style='color:#30CCC4;'>");
    						bu1=$("<button onclick='scadaPar(\""+o+ "\")' style='width: 10px;height: 10px;border-radius: 50%;border: none;background:#42E041;cursor: pointer'>");
    						bu2=$("<button onclick='scadaPar(\""+o1+ "\")' style='width: 10px;height: 10px;border-radius: 50%;border: none;background:red;cursor: pointer'>");
    						bu3=$("<button style='width: 10px;height: 10px;border-radius: 50%;border: none;background:gray;cursor: pointer'>");
    						te1=$("<button style='background-color: rgba(241, 241, 241, 0.6);" +  
    						"box-shadow: 0 5px 20px rgba(100, 196, 15, .5);border:0'>");te2=$("<p>");te3=$("<p>");te4=$("<p>");te5=$("<span>");t5=$("<div style='margin-top:3%';height:32%;>");
    						a2=$("<div class='easyui-layout' data-options='fit:true' style='width:12%;height:32%;margin-left:15px;"+fl+"margin-top:8px;border-top:2px solid #081828;color:#30CCC4" +
    								"background:#081828;width:fit-content; width:-webkit-fit-content; width:-moz-fit-content;border-radius: 25px;border-left:2px solid #081828;border-bottom:2px solid #081828;box-shadow: 50 50 5px black;'>");
    						a3=$("<div  class='easyui-layout' data-options='fit:true' style='width:12%;height:32%;"+fl+"margin-top:8px;border-bottom:2px solid #081828;border-top:2px solid #081828;border-right:2px solid black;" +
							"background:#081828;box-shadow: 0 0 5px black;' >");
    						a4=$("<img id='d1' src='../../../common/RootImages/"+obj.ET_PL+"' onclick='test1(&quot;"+obj.ET_CD+"&quot;)' width='105' height='105' style='margin-left:5px;border:0;cursor: pointer'>");
    						t5.append(a4);
    						a3.append(t5);
    						if(count1<=9){
    							te1.html("0"+ count1+"#" );
    						}else{
    							te1.html(count1+"#" );
    						}
    						te5.html("&nbsp;"+obj.ET_NM)
    						te2.html("&nbsp;运行时间 : "+obj.PRM_PRODDURA);
    						te3.html("&nbsp;停机时间 : "+obj.PRM_DOWNTIME);
    						te4.html("&nbsp;稼动率 : "+s);
    						s1.html(" 开机&nbsp;&nbsp;");s2.html(" 暂停 &nbsp;");s3.html("设置参数&nbsp;&nbsp;");
    						a2.append(te1,te5,te2,te3,te4,bu1,s1,bu2,s2,bu3,s3);
    						a1.append(a2,a3);
    						}
    					});
    					$("#d1").click();
    					avg=sum/count;//平均稼动率
    					a(Math.floor(avg));
    					charts();
    		 }	
		 	}
		 iplantAjaxRequest(ajaxParam);
		
	}	
	OpenFrameAttribute();
	scadaPar = function(e){
		var str=e.split(',');
		 var ajaxParam = {
				 url : '/iPlant_ajax',
    			 dataType : 'JSON',
    			 data:{
    				 CTR_CD: str[0],
    				 CTR_IP: str[1],
    				 CTR_CMD: str[2],
    				 IFS : 'C1001'
    			 },successCallBack : function(data) {
    				if( parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS)>0){
    					if(str[2]=='START'){
    						$.messager.alert('提示','已开机');
    					}else{
    						$.messager.alert('提示','已暂停');
    					}
    				}
    			 }
		 }
		 iplantAjaxRequest(ajaxParam);
	}

	charts = function(){
        	var char=  Highcharts.chart('container1',{
        			chart: {
        				type: 'column',
        				 backgroundColor: '#081828'
        			},
        			title: {
        				text: '设备状态图',
        				align: 'left',
        				y: 15,
        				x: 20,
        				style: {
        					color: '#3EFFFD',
        					fontSize: '16'
        				}
        			},
        			
        			xAxis: {
        				categories: [
        					'生产','待机','故障','维修','换线','报废'
        				],
        				crosshair: true
        			},
        			yAxis: {
        				min: 0,
        				title: {
        					text: null
        				},
        			},
        			tooltip: {
        				// head + 每个 point + footer 拼接成完整的 table
        				headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        				pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
        				'<td style="padding:0"><b>{point.y:.0f} 台</b></td></tr>',
        				footerFormat: '</table>',
        				shared: true,
        				useHTML: true
        			},
        			
        			plotOptions: {
        				column: {
        					borderWidth: 0,
        					dataLabels:{
        	                       enabled:true, // dataLabels设为true  代表显示柱子上的数据
        	                   	style :{
   	  	                    	 'fontSize' : '12px'  
   	  	                       },
        	                       color:  "blue",//柱子上数据颜色
        					},
        				},
        			},
        			series: [{
        				name: '德富莱',
        				colorByPoint:true,
        				data: [S, D, G, W,H,Y],
        			}],
        			exporting: {
        		           enabled:false //不显示下载链接
        				},
        				credits: {
        			          enabled:false //不显示版权信息
        			}
        		});
	}
	
	
	function a(avg){
    	  $("#sps").html(avg+"%");
    	  $('#pro').progressbar({ 
    		  value: avg ,
    		  height: 20,
    		  color: 'red'
    		  }); 
    	  $(".progressbar-value .progressbar-text").css("background-color", "#67D3C9");
    }
  
	var m=0;
	test1 = function (etcd){
		if(etcd != undefined){
			m=etcd;
		}
		var ajaxParam = {
				url : '/iPlant_ajax',
				dataType : 'JSON',
				data:{
					prm_cd : m,
					IFS : 'O1001'
				},successCallBack : function(data){
					var p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19;
					var op = data.RESPONSE[0].RESPONSE_DATA;
					$("#p").empty();
					var a1=$("<marquee class='easyui-layout' data-options='fit:true' style='height:80%;width:99%' scrollamount='1' direction='up'>");
					var br;
					var count=0;
					$.each(op,function(n,obj) {
						p1=$("<span>"); p2=$("<span>"); p3=$("<span>"); p4=$("<span>"); p5=$("<span>");
						p6=$("<span>");p7=$("<span>");p8=$("<span>");p9=$("<span>");p10=$("<span>");
						p11=$("<span>");p12=$("<span>");p13=$("<span>");p14=$("<span>");p15=$("<span>");
						p16=$("<span>");p17=$("<span>");p18=$("<span>");p19=$("<span>");
						p1.html('id: ' +obj.PRM_ID+',&nbsp;');
						if(obj.PRM_TIME != null){
							p19.html('inspecttime: ' +obj.PRM_TIME+',&nbsp;' );
						}
						if(obj.PRM_CD != null){
							p2.html('设备ip: '+obj.PRM_IP+',&nbsp;' );
						}
						if(obj.PRM_NO != null){
							p3.html('机器状态编码: '+obj.PRM_NO+',&nbsp;' );
						}
						if(obj.PRM_DESC != null){
							p4.html('机器状态描述: '+obj.PRM_DESC+',&nbsp;');
						}
						if(obj.PRM_GOODQTY != null){
							p5.html('良品数量: '+obj.PRM_GOODQTY+',&nbsp;');
						}
						if(obj.PRM_BADQTY != null){
							p6.html('不良数量: '+obj.PRM_BADQTY+',&nbsp;');
						}
						if(obj.PRM_PRODQTY != null){
							p7.html('生产数量: '+obj.PRM_PRODQTY+',&nbsp;');
						}
						if(obj.PRM_PRODDURA != null){
							p8.html('生产时长: '+obj.PRM_PRODDURA+',&nbsp;');
						}
						if(obj.PRM_CONVDURA != null){
							p9.html('转产时长: '+obj.PRM_CONVDURA+',&nbsp;');
						}
						if(obj.PRM_TPRODDURA != null){
							p10.html('总生产时长: '+obj.PRM_TPRODDURA+',&nbsp;');
						}
						if(obj.PRM_DOWNTIME != null){
							p11.html('停机时长: '+obj.PRM_DOWNTIME+',&nbsp;');
						}
						if(obj.PRM_TDOWNTIME != null){
							p12.html('总停机时长: '+obj.PRM_TDOWNTIME+',&nbsp;');
						}
						if(obj.PRM_TIMEUNIT != null){
							p13.html('时长: '+obj.PRM_TIMEUNIT+',&nbsp;');
						}
						if(obj.PRM_STDCAP != null){
							p14.html('标准产能: '+obj.PRM_STDCAP+',&nbsp;');
						}
						if(obj.PRM_TAKT != null){
							p15.html('生产节拍: '+obj.PRM_TAKT+',&nbsp;');
						}
						if(obj.PRM_TEMPER != null){
							p16.html('温度: '+obj.PRM_TEMPER+',&nbsp;');
						}
						if(obj.PRM_PRESS != null){
							p17.html('压力: '+obj.PRM_PRESS+',&nbsp;');
						}
						if(obj.PRM_SN != null){
							p18.html('产品编码: '+obj.PRM_SN+'&nbsp;');
						}
						br=$("<p>");
						a1.append(p1 ,p19 ,p2 ,p3 ,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,br);
					}); 
					$("#p").append(a1);
				}
		}
		iplantAjaxRequest(ajaxParam);
	}
	setInterval(test1,20000);
})();*/