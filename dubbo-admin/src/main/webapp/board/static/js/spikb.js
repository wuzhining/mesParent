var loadstaute;	
var errorCount1=0,errorCount2=0,errorCount3=0;
var errorMessage1='',errorMessage2='',errorMessage3='';
(function(){
	function csbkbInfo(){
		ccfunc = function (){
			
var equipAjax2 = function (){
		
		$.ajax({
			url:"/board/equipWork/list?factoryId="+1000067,
			type: "post",
			dataType: "json",
			success: function (returnValue) {
				console.log(returnValue);
			},	
			error: function (returnValue) {
				alert("对不起！数据加载失败！");
			}
		})
	};
	var equipAjax = function (){
		
		$.ajax({
			url:"/board/equipWork/detail?factoryId="+1000067+"&equipCode="+"EQ006",//"ECD004",
			type: "post",
			dataType: "json",
			success: function (returnValue) {
				console.log(returnValue);
				var data=returnValue.map.list[0];
				if(Object.keys(data).length > 0){
     			   	$("#txtsbbm").text(data.equipCode); 			//设备编码
	        		$("#txtsbmc").text(data.equipName); 		//设备名称
	        		$("#txttpdz").text(data.imagePath); 		//图片地址
	        		$("#txtbysc").text(data.hoursMaintain); 	//保养时长
	        		$("#txtbzsm").text(data.standarlive);		//标准寿命
	        		$("#txtztjsc").text(data.hoursShutdown);	//总停机时长
	        		$("#txtzscsc").text(data.hoursWork);		//总生产时长
	        		$("#txtzgzsc").text(data.hoursFault);		//总故障时长
	        		$("#txtzzrq").text(data.dateMake);		//制造日期
	        		$("#txtrcrq").text(data.dateEnter);		//入厂日期
	        		$("#txtzcl").text(data.quantityOutput);		//总产量
	        		$("#txtcjmc").text(data.structWorkshop.workshopName);		//所在车间名称
	        		
	        		errorCount1=1;
	        		errorMessage1 = "正常";
					errorInfo();
				}else{
					errorMessage1 = returnValue.message;
					errorInfo();
				}
				},
			error: function (returnValue) {
				alert("对不起！数据加载失败！");
			}
		})
	};
	var listAjax1 = function (){
		
		$.ajax({
			url:"/board/equipWork/listScada?factoryId="+1000067+"&equipCode="+"EQ006",
			type: "post",
			dataType: "json",
			success: function (returnValue) {
				console.log(returnValue);
				var map=returnValue.map;
				if(returnValue.isSuccess == true){
				if(Object.keys(map).length > 0){
				var newAarry=[];
				var newAarryJson={};
				var AverageSpeed=[],InsertCell=[],TakeCell=[],ThrowCell=[],NullCell=[],Speed=[],TotalCount=[],LineSpeed=[],MachineSpeed=[],Time=[];
				for(var q=0;q<map.AverageSpeed.length;q++){
					var AverageSpeeds=map.AverageSpeed[q].paramvalue;
					AverageSpeed.push(AverageSpeeds);
				}
				for(var w=0;w<map.InsertCell.length;w++){
					var InsertCells=map.InsertCell[w].paramvalue;
					InsertCell.push(InsertCells);
				}
				for(var r=0;r<map.TakeCell.length;r++){
					var TakeCells=map.TakeCell[r].paramvalue;
					TakeCell.push(TakeCells);
				}
				for(var t=0;t<map.ThrowCell.length;t++){
					var ThrowCells=map.ThrowCell[t].paramvalue;
					ThrowCell.push(ThrowCells);
				}
				for(var y=0;y<map.NullCell.length;y++){
					var NullCells=map.NullCell[y].paramvalue;
					NullCell.push(NullCells);
				}
				for(var u=0;u<map.Speed.length;u++){
					var Speeds=map.Speed[u].paramvalue;
					Speed.push(Speeds);
				}
				for(var o=0;o<map.TotalCount.length;o++){
					var TotalCounts=map.TotalCount[o].paramvalue;
					TotalCount.push(TotalCounts);
				}
				for(var a=0;a<map.LineSpeed.length;a++){
					var LineSpeeds=map.LineSpeed[a].paramvalue;
					LineSpeed.push(LineSpeeds);
				}
				for(var s=0;s<map.MachineSpeed.length;s++){
					var MachineSpeeds=map.MachineSpeed[s].paramvalue;
					MachineSpeed.push(MachineSpeeds);
				}
				for(var d=0;d<map.AverageSpeed.length;d++){
					var Times=map.TotalCount[d].uploadtime;
					Time.push(Times);
				}
				
				for(var e=0;e<20;e++){
					newAarryJson={AverageSpeed:AverageSpeed[e],InsertCell:InsertCell[e],TakeCell:TakeCell[e],ThrowCell:ThrowCell[e],NullCell:NullCell[e],Speed:Speed[e],TotalCount:TotalCount[e],LineSpeed:LineSpeed[e],MachineSpeed:MachineSpeed[e],Time:Time[e],};
					newAarry.push(newAarryJson);
				}
				console.log(newAarry);
				
				
				 //注册索引+1的helper
				var handleHelper = Handlebars.registerHelper("Addone",function(index){
				    //利用+1的时机，在父级循环对象中添加一个_index属性，用来保存父级每次循环的索引
				    this._index = index+1;
				    //返回+1之后的结果
				    return this._index;
				});
				
				errorCount2=1;
				errorMessage2 = "正常";
				errorInfo();
				
				}
				
			}else{
				errorMessage2 = returnValue.message;
				errorInfo();
			}
				//抓取模板数据  ,编译模板
				var myTemplate = Handlebars.compile($("#tableTemplate").html());
				//把数据传送到模板
				var strHtml = myTemplate({'tableData':newAarry});
				//更新到模板
				$('#slide-container').html(strHtml);
				loadstaute=1;
				if(loadstaute == 1){
					var theight=document.getElementById('tableInfo');
					var sheight=document.getElementById('slide-container');
					if(theight.offsetHeight > sheight.offsetHeight){
						clearInterval(a);
						var a = setInterval(function(){doscroll()}, 2000);
					}
				}
					
			},
			error: function (returnValue) {
				alert("对不起！数据加载失败！");
			}
		})
	};

var listAjax2 = function (){
		
		$.ajax({
			url:"/board/equipWork/listWork?factoryId="+1000067+"&equipCode="+"EQ006",
			type: "post",
			dataType: "json",
			success: function (returnValue) {
				var map=returnValue.map.list;
				console.log(Object.keys(map).length);
				var mapLength=Object.keys(map).length;
				if(returnValue.isSuccess == true){
				if(mapLength > 0){
				var newAarry=[];
				var newAarryJson={};
				var Barcode=[],WorkorderCode=[],NodeName=[],MaterialCode=[],MaterialName=[],SkuValue=[],CreateTime=[];
				for(var q=0;q<mapLength;q++){
					var barcodes=map[q].barcode;
					Barcode.push(barcodes);
					var billWorkorders=map[q].billWorkorder.workorderCode;
					WorkorderCode.push(billWorkorders);
					var nodeNames=map[q].structProcessNode.nodeName;
					NodeName.push(nodeNames);
					var materialCodes=map[q].productMaterial.materialCode;
					MaterialCode.push(materialCodes);
					var materialNames=map[q].productMaterial.materialName;
					MaterialName.push(materialNames);
					var skuValues=map[q].productMaterial.skuValue;
					SkuValue.push(skuValues);
					var createTimes=map[q].createTime;
					CreateTime.push(createTimes);
				}
				
				for(var e=0;e<mapLength;e++){
					newAarryJson={Barcode:Barcode[e],WorkorderCode:WorkorderCode[e],NodeName:NodeName[e],MaterialCode:MaterialCode[e],MaterialName:MaterialName[e],SkuValue:SkuValue[e],CreateTime:CreateTime[e]};
					newAarry.push(newAarryJson);
				}
				console.log(newAarry);
				
				
				//注册索引+1的helper
				var handleHelper = Handlebars.registerHelper("Addone",function(index){
				    //利用+1的时机，在父级循环对象中添加一个_index属性，用来保存父级每次循环的索引
				    this._index = index+1;
				    //返回+1之后的结果
				    return this._index;
				});
				
				errorCount3=1;
				errorMessage3 = "正常";
				errorInfo();
			}
		}else{
			errorMessage3= returnValue.message;
			errorInfo();
		}
				//抓取模板数据  ,编译模板
				var myTemplate = Handlebars.compile($("#listTemplate").html());
				//把数据传送到模板
				var strHtml = myTemplate({'listData':newAarry});
				//更新到模板
				$('#list-container').html(strHtml);
				loadstaute=2;
				if(loadstaute == 2){
					var theight=document.getElementById('listInfo');
					var sheight=document.getElementById('list-container');
					if(theight.offsetHeight > sheight.offsetHeight){
						clearInterval(b);
						var b = setInterval(function(){doscroll2()}, 2000);
					}
				}
			},
			error: function (returnValue) {
				alert("对不起！数据加载失败！");
			}
		})
	};
	
	equipAjax();	//设备详情表格
	listAjax1(); 	//设备执行信息列表
	listAjax2();	//设备作业信息列表
	
	//异常信息
	var errorInfo = function (){
	if(errorCount1==0||errorCount2==0||errorCount3==0){
		$("#abnormalInfo_title").css('display','block');
		$('#abnormalInfo').html("设备详情:"+errorMessage1+"</br>"+"设备执行信息:"+errorMessage2+"</br>"+"设备作业信息:"+errorMessage3);
	}else if(errorCount1==1&&errorCount2==1&&errorCount3==1){
		$("#abnormalInfo_title").css('display','none');
		$('#abnormalInfo').html('');
	}
	};
		}
	}
	
	
	
	csbkbInfo.prototype={
				init: function () {
						$(function () {
							ccfunc();
							/*clearInterval(c);
							var c = setInterval(function  () {
								ccfunc();
							},30000);*/
							
						})
					}
				}
				
		var csbkb = new csbkbInfo();
		var ccINdext = 0;
		csbkb.init();
})();

//滚动
var doscroll = function(){
	 var $parent = $('#tableInfo');
	 var $first = $parent.find('tr:nth-child(2)');
	 var height = $first.height();
	 $first.animate({
		 marginTop: -height + 'px' //或者改成： height: '0px'
	  }, 500, function() {// 动画结束后，把它插到最后，形成无缝
	  //$first.css('height', height).appendTo($parent);
	  $first.css('marginTop', 0).appendTo($parent);
	 });
	};
	
	var doscroll2 = function(){
		 var $parent = $('#listInfo');
		 var $first = $parent.find('tr:nth-child(2)');
		 var height = $first.height();
		 $first.animate({
			 marginTop: -height + 'px' //或者改成： height: '0px'
		  }, 500, function() {// 动画结束后，把它插到最后，形成无缝
		  //$first.css('height', height).appendTo($parent);
		  $first.css('marginTop', 0).appendTo($parent);
		 });
		};
	