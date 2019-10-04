// JavaScript Document
$(function(){
	var id = $("#id").val();            //工艺路线ID
	var version = $("#processVersion").val();  //工艺路线版本
	
	initialLoadingData(id,version);
	 
	//-------------------编辑(start)-------------------
	var topocontent = $('#topocontent'),
		lefticon = $('#lefticon'),
		linewrap = $('#linewrap');
	
	//连接样式
	// 多条线
//	var lineColorArr = ['#b267ce', '#7c4f2e', '#0074b0', '#b02929', '#e28b1a', '#48daff', '#61b7cf', '#2f8e00',"#000","#ccc"],
//    relationArr = ['文档', '使用', '冷备', '热备', '依赖', '父子', '安装在...上', '连接','pass','Fail'],

	
	var lineColorArr = ["#000","red"],
	    relationArr = ['PASS','FAIL'],
	    instance = jsPlumb.getInstance({
			Endpoint : ["Dot", {radius:2}],
			ConnectionOverlays : [
				[ "Arrow", {location: 1, id:"arrow", length:10, foldback:0.8, width: 10} ],
				[ "Label", { label:"关系", id:"label", cssClass:"labelstyle" }]
			],
			DragOptions : { zIndex:2000 },
			Container:"topocontent"
		});
	window.jsp = instance;
	
	var labelTxt = relationArr[0],			//默认线条文字
	    lineColor = lineColorArr[0],		//默认线条颜色
	    pstyle = {
			Endpoint: ["Dot", { radius: 2 }],
			paintStyle: {
				strokeStyle: lineColor,
				fillStyle: lineColor
			},
			connector: ["Flowchart", {stub: [0, 0], gap: 2, cornerRadius: 5, alwaysRespectStubs: true }],
			connectorStyle: {
				lineWidth: 1,
				strokeStyle: lineColor
			},
			maxConnections: -1
		};
	
	//加载已有数据
//	topocontent.load('json/connection.json', function(response, status){
//	    if(status == "success"){
//			$.closePop('loadingPop');
//			editData(response);
//		}else{
//		    $.popupEle('loadingPop');
//		}
//	});
	function editData(listLine,blocks){
	    var list = eval(listLine),
			blocks = eval(blocks),
			htmlText = "",
			conn = "";
		//------------插入元素-------------
		for( var i in blocks){
			var viewstyle = 'left:'+blocks[i].BlockX+'px;top:'+blocks[i].BlockY+'px;',
				viewid = blocks[i].BlockId,
				viewClass = blocks[i].BlockClass,
				viewsrc = blocks[i].BlockImg,
				viewTxt = blocks[i].BlockText;
			htmlText = htmlText + '<div class="elebox '+viewClass+'" id='+viewid+' style='+viewstyle+'><img src='+viewsrc+'><span class="dragPoint">'+viewTxt+'</span></div>';
		};
		topocontent.html(htmlText);
		
		//------------默认连接-------------
		var windowsDrag = jsPlumb.getSelector("#topocontent .elebox");
		renderConnect(windowsDrag);
		
		//------------更改样式-------------
		for( var i in list){
			var conor = instance.connect({ source: list[i].PageSourceId, target:list[i].PageTargetId});
			conor.getOverlay("label").setLabel(list[i].connectionLabel);
			conor.setPaintStyle({fillStyle : list[i].lineColor, strokeStyle: list[i].lineColor});
			conor.bind('click',function(){
				detachLine(this);
			});
		};
		$("div.elebox").draggable({ containment: "parent" });
	}
	
	//自定义鼠标事件
	var rightkeyPop = $('#rightkeyPop'),
		relationWrap = $('#relationWrap'),
		relevanceBox = $('#relevanceBox'),
	    delEle = $('#delEle');
	
	linewrap.find('span').each(function(i) {//点解切换关系
		var $this = $(this);
		$this.click(function(){
			linewrap.find('span').removeClass('focus');
			$this.addClass('focus');
			labelTxt = relationArr[i];
			lineColor = lineColorArr[i];
		});
	});
	$(document).on("contextmenu", function() { return false; }); 
	$(document).on('mousedown', '#topocontent div.elebox', function(event){
        if(event.which == 3){
		    var $this = $(this),
			    event = event || window.event,
			    oLeft = parseInt(event.clientX),
				oTop = parseInt(event.clientY),
				span = $this.children('span'),
				idStr = $this.attr('id');
			rightkeyPop.css({left : oLeft, top : oTop, zIndex : 2999}).attr('rightkey_click_id', idStr).show();
		}
	});
	$(document).on('mouseout', '#topocontent div.elebox', function(){
		rightkeyPop.hide();
	});
	$(document).on('mouseover', '#topocontent div.elebox', function(){
		return false;
	});
	$(document).on('click', '#delEle', function(){
		idStr = rightkeyPop.attr('rightkey_click_id');
	    $.confirmInfo({
			title : '删除元素及链接',
			text : '确认删除此元素及其链接吗？',
			sure : function(){
				instance.removeAllEndpoints(idStr);
				instance.remove(idStr);
			}
		});
	});

    $(document).on('click', '#ReName', function(){
    	var name=prompt("编辑","");
    	 var  idStr = rightkeyPop.attr('rightkey_click_id');
		$('#' + idStr).children('span').text(name);
		relationWrap.hide();
		rightkeyPop.hide();
		instance.revalidate(idStr);
		});
    
//	$(document).on('click', '#relationWrap a', function(){
//	    var txt = $(this).text(),
//		    idStr = rightkeyPop.attr('rightkey_click_id');
//		$('#' + idStr).children('span').text(txt);
//		relationWrap.hide();
//		rightkeyPop.hide();
//		instance.revalidate(idStr);
//	});
	rightkeyPop.mouseover(function(){
		$(this).show();
		return false;
	});
	relevanceBox.hover(function(){
	    relationWrap.show();
	}, function(){
	    relationWrap.hide();
	});
	$('body').mouseover(function(){
	    rightkeyPop.hide();
	});
	
	//jsPlumb事件
	/*instance.bind("click", function(info) {//点解连接线删除连接（bug,点击endpoint也能删除，但是点击label能提示不能删除）
	    detachLine(info);
	});*/
	instance.bind("connection", function(info) {//更改label关系
		info.connection.getOverlay("label").setLabel(labelTxt);
	});
	instance.bind("connectionDrag", function(info) {//更改连接链颜色
		info.setPaintStyle({fillStyle : lineColor, strokeStyle: lineColor});
	});
	instance.bind("connectionDragStop", function(info) {//点击连接线、overlay、label提示删除连线 + 不能以自己作为目标元素
	    if(info.sourceId == info.targetId){
			$.popupTips('不能以自己作为目标元素');
		    instance.detach(info); 
		}else{
			info.unbind('click');
			info.bind('click',function(){
				detachLine(info);
			});
		};
	});
	function detachLine(info){//删除连接
	    $.confirmInfo({
			title : '删除连接',
			text : '确认删除此链接吗？',
			sure : function(){
			   instance.detach(info); 
			}
		});
	}
	function renderConnect(newid){//渲染
		instance.draggable(newid);
		instance.doWhileSuspended(function(){
			var isFilterSupported = instance.isDragFilterSupported();
			if(isFilterSupported){
				instance.makeSource(newid, {filter:".dragPoint",anchor:"Continuous"}, pstyle);
			}else{
				var eps = jsPlumb.getSelector(".dragPoint");
				for (var i = 0; i < eps.length; i++) {
					var e = eps[i], p = e.parentNode;
					instance.makeSource(e, {parent:p, anchor:"Continuous"}, pstyle);
				}
			}
		});
		instance.makeTarget(newid, {dropOptions:{hoverClass:"dragHover"}, anchor:"Continuous"}, pstyle);
	}
	
	//拖动创建元素
    lefticon.find('div.iconitems').draggable({
	    helper: 'clone',
		scope: 'topo'
	});
	topocontent.droppable({
	    scope: 'topo',
		drop: function(event, ui){
			//获取基本元素与参数
			var $this = $(this),
				dragui = ui.draggable,
				fatop = parseInt($this.offset().top),
				faleft = parseInt($this.offset().left),
				uitop = parseInt(ui.offset.top),
				uileft = parseInt(ui.offset.left),
				imgsrc = dragui.find('img').attr('src'),
				spantxt = dragui.find('span').text(),
				uid = dragui.attr('icontype'),
				alluid = topocontent.find('div.' + uid);
			//ID计算
			var allicon = alluid.length,
				idnum = 0,
				idArr  = new Array;
			alluid.each(function(i) {
				idArr.push(parseInt($(this).attr('id').split('_')[1]));
			});
			idArr.sort(function(a,b){return a>b?1:-1});
			for(i = 0; i < allicon; i++){
			   var idArrOne = parseInt(idArr[i]);
				if(i != idArrOne){
					idnum = idArrOne - 1;
					break;
				}else{
					idnum = allicon;
				} 
			}
			
			//插入元素组织
		    var newstyle = 'left:' + (uileft - faleft) + 'px;top:' + (uitop - fatop) + 'px',
				newid = uid + '_' + idnum,
				newsrc = imgsrc.replace('little-icon', 'big-icon'),
				str = '<div class="elebox '+uid+'" id='+newid+' style='+newstyle+'><img src='+newsrc+'><span class="dragPoint">'+spantxt+'</span></div>';
			
			$this.append(str);
			renderConnect(newid);
			instance.revalidate(newid);
			$("#" + newid).draggable({ containment: "parent" });
		}
	});
	//-------------------编辑(end)-------------------
	
	
	//-------------------保存(start)-------------------
	var saveTopoBtn = $('#saveTopoBtn'),
		serliza = '';
	saveTopoBtn.click(function(){
	    var connects = [];
		$.each(instance.getAllConnections(), function (idx, connection) {
			connects.push({
				lineColor: connection.getPaintStyle('label').fillStyle,
				connectionLabel : connection.getOverlay('label').label,
				PageSourceId: connection.sourceId,
				PageTargetId: connection.targetId
			});
		});
		var blocks = [];
		$("#topocontent .elebox").each(function (idx, elem) {
			var $elem = $(elem);
			blocks.push({
				BlockId: $elem.attr('id'),
				BlockClass: $elem.attr('class').split(' ')[1],
				BlockImg: $elem.children('img').attr('src'),
				BlockText: $elem.children('span').text(),
				BlockX: parseInt($elem.css("left")),
				BlockY: parseInt($elem.css("top"))
			});
		});
		serliza = JSON.stringify(connects) + "&" + JSON.stringify(blocks);
		
		if(topocontent.children('div.elebox').length == 0){
			alert('请先创建元素或连接');
		}else{
			$.ajax({
		        url:'/struct/structProcessLine/save',
		        type:"POST",
		        contentType: "application/x-www-form-urlencoded; charset=utf-8",
		        data:{
		        	"serliza":serliza,
		        	"id":id,
		        	"processVersion":version
		        },
	            success:function (data) {
	               var obj = JSON.parse(data);
	               if (obj.isSuccess) {
	            	   alert('流程图保存成功');
		           }else{
		        	   alert("流程图保存失败");
	       		  }
	            }
		    });
		    
		}
		
		$('#num').text(serliza);

	});
	//-------------------保存(end)-------------------
	
	
	//-------------------预览(start)-------------------
	/*var topoView = $('#topoView'),
	    viewTopoBtn = $('#viewTopoBtn');
	viewTopoBtn.click(function(){
		console.log(1111);
		//technologicalProcess-view.html
	    $.iframePop('technologicalProcess-view.html', 640, 900);
	});
	topoView.load('json/connection.json', function(response, status){
	    if(status == "success"){
			$.closePop('loadingPop');
			viewPop(response);
		}else{
		    $.popupEle('loadingPop');
		}
	});*/
	
	function viewPop(listLine,dataBlocks){
	    var list = eval(listLine),
			blocks = eval(dataBlocks),
			htmlText = "",
			conn = "";
		//------------插入元素-------------
		for( var i in blocks){
			var viewstyle = 'left:'+blocks[i].BlockX+'px;top:'+blocks[i].BlockY+'px;',
				viewid = blocks[i].BlockId,
				viewClass = blocks[i].BlockClass,
				viewsrc = blocks[i].BlockImg,
				viewTxt = blocks[i].BlockText;
			htmlText = htmlText + '<div class="elebox cursor_default '+viewClass+'" id='+viewid+' style='+viewstyle+'><img src='+viewsrc+'><span class="dragPoint cursor_default">'+viewTxt+'</span></div>';
		};
		//topoView.html(htmlText);
		topocontent.html(htmlText);
		
		//------------默认连接-------------
		var instanceView = jsPlumb.getInstance({
				Endpoint : ["Dot", {radius:2}],
				ConnectionOverlays : [
					[ "Arrow", {location: 1, id:"arrow", length:10, foldback:0.8, width: 10} ],
					[ "Label", { label:"关系", id:"label", cssClass:"labelstyle" }]
				],
				Container:"topocontent"
			});
		window.jsp = instanceView;
		var windows = jsPlumb.getSelector("#topocontent .elebox");
		instanceView.doWhileSuspended(function() {
			var isFilterSupported = instanceView.isDragFilterSupported();
			if (isFilterSupported) {
				instanceView.makeSource(windows, {filter:'none',anchor:"Continuous"}, pstyle);
			}else {
				var eps = jsPlumb.getSelector(".elebox");
				for (var i = 0; i < eps.length; i++) {
					var e = eps[i], p = e.parentNode;
					instanceView.makeSource(e, {parent:p,anchor:"Continuous"}, pstyle);
				}
			}
		});
		instanceView.makeTarget(windows, {anchor:"Continuous"}, pstyle);
		
		//------------更改样式-------------
		for( var i in list){
			var conor = instanceView.connect({ source: list[i].PageSourceId, target:list[i].PageTargetId});
			conor.getOverlay("label").setLabel(list[i].connectionLabel);
			conor.setPaintStyle({fillStyle : list[i].lineColor, strokeStyle: list[i].lineColor});
		};
	}
	//-------------------预览(end)-------------------
	
	//-------------------清屏(start)-------------------
	//
	var delTopoBtn = $('#delTopoBtn');
	delTopoBtn.click(function(){
	    $("#topocontent").html("");
	});
	
	function ObjLine(lineColor,connectionLabel,PageSourceId,PageTargetId){
		this.lineColor = lineColor;
		this.connectionLabel = connectionLabel;
		this.PageSourceId = PageSourceId;
		this.PageTargetId = PageTargetId;
	}
	function ObjNode(BlockId,BlockClass,BlockImg,BlockText,BlockX,BlockY){
		this.BlockId = BlockId;
		this.BlockClass = BlockClass;
		this.BlockImg = BlockImg;
		this.BlockText = BlockText;
		this.BlockX = BlockX;
		this.BlockY = BlockY;
	}
	
	//-------------------清屏(end)-------------------
	
	//初始加载jsplumb页面时 判断所选择的的工艺路线是否已存在，如存在在页面显示
	function initialLoadingData(routId,routVersion){
		var listLine = [],blocks=[],dataBlocks=[],connectionLabel,lineColor;
		$.ajax({
	        url:'/struct/structProcessLine/routList',
	        type:"POST",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        data:{
	        	"routId":routId,
	        	"routVersion":routVersion
	        },
            success:function (data) {
               var obj = JSON.parse(data);
               var processList = obj.map.list;
	           if(processList.length>0){
	               //节点
	               for (var i=0; i<processList.length; i++) {
	            	   var objPrevNode = {},objNextNode = {};
	            	   //blocks.push(new objNode(processList[i].prevNodeId,processList[i].prevNodeId,"/static/images/flow/big-icon/firework.gif","A",processList[i].prevNodeCoordinateX,processList[i].prevNodeCoordinateY));
	            	   if(i==0){
	            		   objPrevNode['BlockId'] = processList[i].prevNodeId+"_0";
	            		   objPrevNode['BlockClass'] = processList[i].prevNodeId;
	            		   objPrevNode['BlockImg'] = "/static/images/flow/big-icon/firework.gif";
	            		   objPrevNode['BlockText'] = getNodeNames(processList[i].prevNodeId);
	            		   objPrevNode['BlockX'] = processList[i].prevNodeCoordinateX;
	            		   objPrevNode['BlockY'] = processList[i].prevNodeCoordinateY;
	            		   dataBlocks.push(objPrevNode);
	                	   
	                	   objNextNode['BlockId'] = processList[i].nextNodeId+"_0";
	                	   objNextNode['BlockClass'] = processList[i].nextNodeId;
	                	   objNextNode['BlockImg'] = "/static/images/flow/big-icon/firework.gif";
	                	   objNextNode['BlockText'] = getNodeNames(processList[i].nextNodeId);
	                	   objNextNode['BlockX'] = processList[i].nextNodeCoordinateX;
	                	   objNextNode['BlockY'] = processList[i].nextNodeCoordinateY;
	                	   dataBlocks.push(objNextNode);
	            	   }else{
	            		   var nextFlag=prevFlag=prevInt=nextInt=0;
	            		   for (var j=0; j<dataBlocks.length; j++) {
	            			   // nextFlag,prevFlag
	            			   var BlockIdData = dataBlocks[j].BlockId.split("_");
	            			   var BlockId = BlockIdData[0]
	            			   
	            			   var prevNodeId = processList[i].prevNodeId.toString();
	            			   var nextNodeId = processList[i].nextNodeId.toString();
	            			   
	            			   if(prevNodeId === BlockId && processList[i].prevNodeCoordinateX === dataBlocks[j].BlockX && processList[i].prevNodeCoordinateY === dataBlocks[j].BlockY){
	            				   prevFlag +=1;
	            			   }else if(prevNodeId === BlockId && (processList[i].prevNodeCoordinateX != dataBlocks[j].BlockX || processList[i].prevNodeCoordinateY != dataBlocks[j].BlockY)){
	            				   prevInt +=1;
	            			   }else{
	            				   if(j == dataBlocks.length -1){
	            					   if(prevFlag === 0){
	            						    //objPrevNode =  new objNode(processList[i].prevNodeId,processList[i].prevNodeId,"/static/images/flow/big-icon/firework.gif","A",processList[i].prevNodeCoordinateX,processList[i].prevNodeCoordinateY);
	            						   objPrevNode['BlockId'] = processList[i].prevNodeId+"_"+prevInt;
	            						   objPrevNode['BlockClass'] = processList[i].prevNodeId;
	            						   objPrevNode['BlockImg'] = "/static/images/flow/big-icon/firework.gif";
	            						   objPrevNode['BlockText'] = getNodeNames(processList[i].prevNodeId);
	            						   objPrevNode['BlockX'] = processList[i].prevNodeCoordinateX;
	            						   objPrevNode['BlockY'] = processList[i].prevNodeCoordinateY;
	            					   };
	            				   };
	            			   };
	            			   if(nextNodeId === BlockId && processList[i].nextNodeCoordinateX === dataBlocks[j].BlockX && processList[i].nextNodeCoordinateY === dataBlocks[j].BlockY){
	            				   nextFlag+=1;
	            			   }else if(nextNodeId === BlockId && (processList[i].nextNodeCoordinateX != dataBlocks[j].BlockX || processList[i].nextNodeCoordinateY != dataBlocks[j].BlockY)){
	            				   nextInt +=1;
	            			   }else{
	            				   if(j == dataBlocks.length -1){
	            					   if(nextFlag === 0){
	            						   //objNextNode =  new objNode(processList[i].nextNodeId,processList[i].nextNodeId,"/static/images/flow/big-icon/firework.gif","A",processList[i].nextNodeCoordinateX,processList[i].nextNodeCoordinateY);
	            						   objNextNode['BlockId'] = processList[i].nextNodeId+"_"+nextInt;
	            	                	   objNextNode['BlockClass'] = processList[i].nextNodeId;
	            	                	   objNextNode['BlockImg'] = "/static/images/flow/big-icon/firework.gif";
	            	                	   objNextNode['BlockText'] = getNodeNames(processList[i].nextNodeId);
	            	                	   objNextNode['BlockX'] = processList[i].nextNodeCoordinateX;
	            	                	   objNextNode['BlockY'] = processList[i].nextNodeCoordinateY;
	            					   }
	            				   }
	            			   };
	            		   };
	            		   
	            		   if(JSON.stringify(objPrevNode) != "{}"){
	            			   dataBlocks.push(objPrevNode);
	            		   }
	            		   if(JSON.stringify(objNextNode) != "{}"){
	            			   dataBlocks.push(objNextNode);
	            		   }
	            	   }
	            	   
				   };
	               
				   /*
	                * 根据节点X Y坐标位置 赋值给连线  PageSourceId PageTargetId 下标索引
	                */
	               for (var i=0; i<processList.length; i++) {
	            	   var objLine = {},PageSourceId,PageTargetId;
	            	   if(processList[i].lineTypeDictId=='10516'){
	            		   connectionLabel = "PASS";
	            		   lineColor = "#000";
	            	   }else{
	            		   connectionLabel = "FAIL";
	            		   lineColor = "red";
	            	   }
	            	   var prevNodeId = processList[i].prevNodeId.toString();
	            	   var prevNodeCoordinateX = processList[i].prevNodeCoordinateX.toString();
	            	   var prevNodeCoordinateY = processList[i].prevNodeCoordinateY.toString();
	            	   
	            	   var nextNodeId = processList[i].nextNodeId.toString();
	            	   var nextNodeCoordinateX = processList[i].nextNodeCoordinateX.toString();
	            	   var nextNodeCoordinateY = processList[i].nextNodeCoordinateY.toString();
	            	   
		               for (var k=0; k<dataBlocks.length; k++) {
		            	   var BlockIddata = dataBlocks[k].BlockId.split("_");
		            	   var BlockId = BlockIddata[0];
		            	   var Id = BlockIddata[1];
		            	   var BlockX = dataBlocks[k].BlockX.toString();
		            	   var BlockY = dataBlocks[k].BlockY.toString();
		            	   if(prevNodeId===BlockId && prevNodeCoordinateX===BlockX && prevNodeCoordinateY===BlockY){
		            		   PageSourceId = BlockId+"_"+Id;
		            	   }
		            	   if(nextNodeId===BlockId && nextNodeCoordinateX===BlockX && nextNodeCoordinateY===BlockY){
		            		   PageTargetId = BlockId+"_"+Id;
		            	   }
		               }
		               //连线
	            	   listLine.push(new ObjLine(lineColor,connectionLabel,PageSourceId,PageTargetId));
	                }
	               editData(JSON.stringify(listLine),JSON.stringify(dataBlocks));
	            }
            }
	    });
	};
	
	/*根据节点ID获取节点名称*/
	function getNodeNames(NodeId){
		var nodeNames;
		$.ajax({
	        url:'/struct/structProcessLine/getNodeNames',
	        type:"POST",
	        async:false,
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        data:{
	        	"NodeId": NodeId
	        },
            success:function (data) {
               var obj = JSON.parse(data);
               var processList = obj.map.list;
               nodeNames = processList.nodeNames;
            }
		});
		return nodeNames;
	}
});


