/**
 * @Description: 重写layui表格 
 */
layui.define(["table",'laypage','form'], function(exports){
	var table = layui.table,
	form = layui.form,
	laypage = layui.laypage,
	statusName = 'code',
	msgName = 'msg',
	dataName = 'list', //数据列表的字段名称，默认：data
	defaultLimit = 20,//默认分页数量
	defaultLimits = [10,20,30,50,100],//默认每页数据选择项
	loadDataType = "0";
	datagridSubmitType = "1";
	layuitable = function (){
	};
  
	layuitable.prototype.render = function(options){
		this.config = {
	  	    id:""
	  	    ,elem: ''
			,url:''
			,height:'full-180'
			,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
			,limit: 30
			,limits: [30,60,90]
			//,skin:'line'
			,even:false
			,request: {
			  	pageName: 'pageIndex' //页码的参数名称，默认：page
				,limitName: 'pageSize' //每页数据量的参数名，默认：limit
			}
			,response: {
			  	statusName: 'resultCode' //数据状态的字段名称，默认：code
				,statusCode: 1 //成功的状态码，默认：0
				,msgName: 'message' //状态信息的字段名称，默认：msg
				,countName: 'recordCount' //数据总数的字段名称，默认：count
				,dataName: 'resultlist' //数据列表的字段名称，默认：data
			} 
			,page: true
		    ,text: {
		        none: '暂无相关数据'
		    },
		    getDatagrid:null
		}
  	
		var thisTable = this;
		$.extend(true, thisTable.config, options);
    
		//执行渲染
		thisTable.table = table.render(thisTable.config);
	  
		return thisTable;
	};
      
	/**
	 * 重新load
	*/
	layuitable.prototype.reload = function(param){
		if(this.table){
	  		var options = {where:param,page: { 
			      layout: ['count', 'prev', 'page', 'next', 'skip']
			      ,curr: 1 
			      ,groups: 5 
			      ,first: false 
			      ,last: false 
		    }};
	  		this.table.reload(options);
	    }
	};
	
	/**
	 * 刷新
	 */
	layuitable.prototype.refresh = function(){
		if(this.table){
			this.table.reload();
		}
	};    
	
	var layuitable = new layuitable();
	exports("layuitable",layuitable);

});