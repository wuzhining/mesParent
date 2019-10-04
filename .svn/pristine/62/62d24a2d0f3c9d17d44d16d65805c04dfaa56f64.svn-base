/**
 * @Description: tree工具
 * @author: clm
 */
layui.define(["layer"], function(exports){
	var layer = layui.layer,
	
	MyEcharts = function (){
		this.config = {
				id:""
			};
		//this.myChart;
	};
  
	MyEcharts.prototype.render = function(options){
		var _this = this;
		$.extend(true, _this.config, options);
		if(_this.config.id == null || _this.config.id == ''){
			layer.msg("id不能为空!");
			return;
	    }
		var myChart = echarts.init(document.getElementById(_this.config.id)); 
		//return _this;
		return myChart;
	};
	
	MyEcharts.prototype.show = function(option) {
		var _this = this;
		
		_this.myChart.setOption(option);
	};
	
	
	var myEcharts = new MyEcharts();
	exports("myEcharts",myEcharts);

});