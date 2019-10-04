/**
 * @Description: tree工具
 * @author: clm
 */
layui.define(["layer"], function(exports){
	var layer = layui.layer,
	
	MyTree = function (){
		this.config = {
			url : undefined,//请求url地址
			id:"",
			autoParam : ["id=pid"],  //参数
			statusName : 'resultCode',
			msgName : 'message',
			dataName : "resultlist",  //结果集对象
			clickCallback : null,  //点击回掉函数
			async : false,
			hasCheckbox : false
		}
	};
  
	MyTree.prototype.render = function(options){
		var _this = this;
		$.extend(true, _this.config, options);
		if(_this.config.id == null || _this.config.id == ''){
			layer.msg("id不能为空!");
			return;
	    }
		this.queryTree();
		return _this;
	};
	
	//显示树
	MyTree.prototype.showTree = function(data) {
		var _this = this;
		var url = _this.config.url;//请求url
		if(url == null || url == ''){
			layer.msg("请求地址为空!");
			return;
		}
		var setting = {
			view: {
				showLine: false
			},
			async: {
				enable: _this.config.async,
				url:url,
				autoParam:_this.config.autoParam,
				dataFilter: function ajaxDataFilter(treeId, parentNode, responseData) {
			    if(responseData[_this.config.statusName] == 1) {
			    	return responseData[_this.config.dataName];
				} else {
					//提示错误消息
					layer.alert(responseData[_this.config.msgName], {icon:0})
				}
			    return responseData;
				}
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: _this.config.clickCallback
			},
			check: {
				enable: _this.config.hasCheckbox
			}
		};
		$.fn.zTree.init($("#"+_this.config.id), setting,data);
	};
	
	MyTree.prototype.queryTree = function() {
		var _this = this;
		var url = _this.config.url;//请求url
		if(url == null || url == ''){
			layer.msg("请求地址为空!");
			return;
		}
		$.ajax({
			url:url,
			type:'GET',
			contentType:'application/x-www-form-urlencoded',
			data:'',
			dataType:'json',
			success:function(result){
				_this.showTree(result[_this.config.dataName]);
			},
			error:function(result){
				layer.alert(result[_this.config.msgName]?result[_this.config.msgName]:'系统繁忙，稍后再试', {icon: 2});
			}
		});
	};
	
	MyTree.prototype.getCancelledNodes = function(checked) {
		var cancelledNodes = [];
		var _this = this;
		var zTree = $.fn.zTree.getZTreeObj(_this.config.id);
		var nodes = zTree.getChangeCheckedNodes();
		for (var i=0, length=nodes.length; i<length; i++) {
			if (nodes[i].checkedOld) {
				if (!nodes[i].checked) { //现在被取消
					cancelledNodes.push(nodes[i]);
				}
			}
		}
		return cancelledNodes;
	}
	
	MyTree.prototype.getSelectNodes = function(checked) {
		var selectNodes = [];
		var _this = this;
		var zTree = $.fn.zTree.getZTreeObj(_this.config.id);
		var nodes = zTree.getChangeCheckedNodes();
		for (var i=0, length=nodes.length; i<length; i++) {
			if (!nodes[i].checkedOld) {
				if (nodes[i].checked) { //现在选中
					selectNodes.push(nodes[i]);
				}
			}
		}
		return selectNodes;
	}
	
	var myTree = new MyTree();
	exports("myTree",myTree);

});