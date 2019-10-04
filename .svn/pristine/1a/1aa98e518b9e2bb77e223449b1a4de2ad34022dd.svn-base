/**
 * 全局配置文件
 * @author: clm
 */
layui.define(['layer'], function(exports){
	var layer = layui.layer,
	
	defaultLimit = 20;//默认分页数量
	
	layuiconfig = function (){
	};
  
    
	/**
	 * 弹新窗口
	 * title 标题
	 * url 链接
	 * mod 模块
	*/
	layuiconfig.prototype.openWindow = function(title,url,mod){
		mod = mod || '';
		var index = layui.layer.open({
            title : title,
            area: ['100%', '100%'],
            type : 2,
            content : url,
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回'+mod+'列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        return index;
	};
	
   
	
	var layuiconfig = new layuiconfig();
	exports("layuiconfig",layuiconfig);

});