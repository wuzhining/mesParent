$(function () {
	var dtime  = getBCtime();
	var lx = getQueryString("line");
	var sbbm = getQueryString("shebei");
	 
	$('#cccd').datagrid({       
		name:'edit_tab',
		dataType: 'json', 
		columns: [[
		{ field: 'ZS',  title: '工单总数',width: document.body.clientWidth*0.25, align:'center'},
		{ field: 'JHZS',  title: '计划总数量', width: document.body.clientWidth*0.25,align:'center'},
		{ field: 'TYZS',  title: '投入总数量', width: document.body.clientWidth*0.25,align:'center'},
		{ field: 'WCZS',  title: '完成总数量',width: document.body.clientWidth*0.245, align:'center'}
    ]]   
	});
	ccFun();
	var t=setInterval(function  () {
		ccFun();
	},60000);
	function ccFun(){
	/*工单部分*/
//	var ajaxWoParam={
//	    url:'/iPlant_ajax',
//		data:{
//			IFS: 'MES_R0073',
//	        LINE_CD:lx
//		},
//		successCallBack:function(data){
//			if(data.RESPONSE.length !=0){
//			if(data.RESPONSE["0"].RESPONSE_DATA.length>0){
//				var zs = data.RESPONSE["0"].RESPONSE_DATA.length;
//				var jhzs=0;
//				var tyzs = 0;
//				var wczs = 0;
//				for(var i=0 ; i<data.RESPONSE["0"].RESPONSE_DATA.length; i++){
//					jhzs += parseInt(data.RESPONSE["0"].RESPONSE_DATA[i].PLAN_WO_QTY);
//					tyzs += parseInt(data.RESPONSE["0"].RESPONSE_DATA[i].PAI_QTY);
//					wczs += parseInt(data.RESPONSE["0"].RESPONSE_DATA[i].PROD_QTY);
//				}
//				var ccData = [{ZS:zs,JHZS:jhzs,TYZS:tyzs,WCZS:wczs}];
//				$('#cccd').datagrid('loadData',{total:1,rows:ccData});
//			}else{
//				$('#cccd').datagrid('loadData',{total:0,rows:[]});
//			}
//			}
//		},
//		errorCallBack:function(e){
//			var a=e;
//		}
//	}        
//	iplantAjaxRequest(ajaxWoParam);
    
    /*工单完成情况*/
	var woCategory=[];
	var createCnt=[],dispatchCnt=[],finishedCnt=[];
	var ajaxFinishParam={
			url: '/iPlant_ajax',
		    data: {
		        IFS: 'MES_R0071',
		        LINE_CD:lx
		    },
			successCallBack:function(data){
				if(data.RESPONSE.length != 0){
					var woData=data.RESPONSE["0"].RESPONSE_DATA;
					var zs = 0;
					var jhzs=0;
					var tyzs = 0;
					var wczs = 0;
					for(var i=0;i<woData.length;i++){
						zs += parseInt(woData[i].PLAN_PO_QTY);
						jhzs += parseInt(woData[i].PAI_QTY);
						tyzs += parseInt(woData[i].INPUT_QTY);
						wczs += parseInt(woData[i].TOTAL_QTY);
					}
					var ccData = [{ZS:zs,JHZS:jhzs,TYZS:tyzs,WCZS:wczs}];
					$('#cccd').datagrid('loadData',{total:1,rows:ccData});
					woCategory.push(zs);
					createCnt.push(jhzs);
					dispatchCnt.push(tyzs);
					finishedCnt.push(wczs);
				}else{
					$('#cccd').datagrid('loadData',{total:0,rows:[]});
				}	
				var seriesData= [{name: '<span style="font-size:4px;">工单数量<span>',data: woCategory},{name: '<span style="font-size:4px;">计划总数量<span>',data: createCnt},{name: '<span style="font-size:4px;">投入总数量<span>',data: dispatchCnt},{name: '<span style="font-size:4px;">完成总数量<span>',data:finishedCnt}];
				$('#workOrderFinished').highcharts({
			    	 chart: {
			             type: 'column'
			         },
			         credits:{
			         	enabled:false
			         },
			         title: {
			             text: '<span style="color:#1771B3;font-weight: bold;font-size:6px;">工单完成情况</span>'
			         },
			         colors: ['#0099FF', '#00CC99', '#FFFF33', '#f7a35c', '#8085e9','#f15c80', '#e4d354', '#8085e8', '#8d4653', '#91e8e1'], 
			         xAxis: 
			         {	
			        	 labels: {
			        		enabled: false,
	                        style: {
	                            color: '#19a0f5',//颜色
	                            fontSize:'4px'  //字体
	                        }
	                 },
			             categories: woCategory,
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
			             min: 0,
			             title: {
			                 text: ''
			             }
			         },
			         tooltip: {
			             headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			             pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			             '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
			             footerFormat: '</table>',
			             shared: true,
			             useHTML: true
			         },
			         plotOptions: {
			             column: {
			            	 dataLabels:{
						        	enabled:true
		                     },
			                 pointPadding: 0.2,
			                 borderWidth: 0
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


