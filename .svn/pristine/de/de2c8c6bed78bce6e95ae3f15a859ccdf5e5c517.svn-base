

layui.define(['layer','form','util'], function(exports){
	var $ = layui.jquery
	,layer = layui.layer
	,form = layui.form
	,util = layui.util;
	
	var layuiformajax = {
		
		//ajax提交
		/* 
		 * url ： 地址
		 * data : 数据
		 * success ： 成功回调（res.isSuccess为true时，要处理的方法）
		 * options ：额外参数json类型（非必须） {escape : true转义xss字符，false不转, error : 失败回调, type : post或者get, dataType : json, 
		 * 						  isClose ： true关闭当前页, reload : true刷新列表}
		 * 
		 */
		postJson: function(url, data, success, options){
			if( laypostLock == 0){
				laypostLock = 1;
			}else{
				return;
			} 
			var index = layer.load(1, {shade: [0.1,'#fff'] }); 
	    	var that = this, type = typeof data === 'function';
	    	if (type) {
		        options = success
		        success = data;
		        data = {};
	    	}
	    	options = options || {};
	    	console.log(data);
	    	if (options.contentType && options.contentType == 'application/json') {
	    		data = JSON.stringify(data);
	    	} else {
	    		if (isJson(data)) {
		    		var param = [];
				    for(var k in data){
				    	if (data[k] != '') {
				    		param.push(k + '=' + data[k]);
				    	}
				    }
				    data = param.join('&');
		    	}
	    		data = URLencode(data);
	    	}
	    	
	    	if (options.escape) {
	    		//data = util.escape(data); //转义 xss 字符  暂时不实现
	    	}
	    	console.log(data);
	    	return $.ajax({
		        type: options.type || 'post',
		        contentType: options.contentType || 'application/x-www-form-urlencoded',
		        dataType: options.dataType || 'json',
		        data: data,
		        url: url,
		        success: function(res){
					layer.close(index);
					laypostLock = 0;
		        	if(res.isSuccess) {
		        		success && success(res);
		        		
		        	} else {
		        		layer.msg(res.message || '操作失败', {shift: 6});
		        		options.error && options.error();
		        	}
		        }, error: function(e){
					layer.close(index);
					laypostLock = 0;
		        	options.error && options.error();
		        	layer.msg('请求异常，请重试', {shift: 6});
		        }
	    	});
	    }
		,form: {}
	}
	
	//表单提交 （快捷方法），设置lay-filter=* 
	form.on('submit(*)', function(data){
		
		var action = $(data.form).attr('action'), button = $(data.elem);
		layuiformajax.postJson(action, data.field, function(res){
		    
			var end = function(){
				layuiformajax.form[button.attr('key')] && layuiformajax.form[button.attr('key')](data.field, data.form);
			};
			button.attr('alert') ? layer.alert(res.message, {
				icon: 1,
				time: 5*1000,
				end: end
			}) : end();
			
			
		});
		return false;
	});
	
	function isJson(obj){
		var isjson = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length; 
		return isjson;
	}
	
	function URLencode(sStr) {
	    return sStr.replace(/%/g,"%25").replace(/\+/g, '%2B').replace(/\"/g,'%22').replace(/\'/g, '%27').replace(/\//g,'%2F');
	}

	
	exports('layuiformajax', layuiformajax);
});
