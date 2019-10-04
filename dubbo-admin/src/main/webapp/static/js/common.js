var cookieName_LoginUserId ='userId';
var cookieName_LoginUsername ='username';
var LODOP;

//提交表单数据  data的格式：key=fdsa&lang=zh
var laypostLock = 0;//1：锁住表示有一个请示正在提交

$.postForm=function(url,data,callback,errorback) {
	var layuiIndex = layer.load(1); 
	if( laypostLock == 0){
		laypostLock = 1;
	}else{
		return;
	} 
	
	if(typeof(data)!='undefined'){
		if(data instanceof Object){
			var param=[];	//参数数组
		    for(var k in data){
		    	if (data[k] != '') {
		    		param.push(k + '=' + data[k]);
		    	}
		    }
		    
		    data = param.join('&');
			
		}
	}

	//data = typeof(data)!='undefined'?data.replace("%","%25"):'';
	
	 
	$.ajax({
		url:url,
		type:'POST',
		contentType:'application/x-www-form-urlencoded',
		data:data,
		dataType:'json',
		success: function(res){
			layer.close(layuiIndex);
			laypostLock = 0;
			callback && callback(res);
        },
		error: function(e){
			layer.close(layuiIndex);
			laypostLock = 0;
			errorback && errorback();
        }
	});
};


 $(function () {
    //加载弹出层
    layui.use(['form','element'],
    function() {
        layer = layui.layer;
        element = layui.element;
    });

    //触发事件
  var tab = {
        tabAdd: function(title,url,id){
          //新增一个Tab项
          element.tabAdd('xbs_tab', {
            title: title 
            ,content: '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe"></iframe>'
            ,id: id
          })
        }
        ,tabDelete: function(othis){
          //删除指定Tab项
          element.tabDelete('xbs_tab', '44'); //删除：“商品管理”
          
          
          othis.addClass('layui-btn-disabled');
        }
        ,tabChange: function(id){
          //切换到指定Tab项
          element.tabChange('xbs_tab', id); //切换到：用户管理
        }
      };


    tableCheck = {
        init:function  () {
            $(".layui-form-checkbox").click(function(event) {
                if($(this).hasClass('layui-form-checked')){
                    $(this).removeClass('layui-form-checked');
                    if($(this).hasClass('header')){
                        $(".layui-form-checkbox").removeClass('layui-form-checked');
                    }
                }else{
                    $(this).addClass('layui-form-checked');
                    if($(this).hasClass('header')){
                        $(".layui-form-checkbox").addClass('layui-form-checked');
                    }
                }
                
            });
        },
        getData:function  () {
            var obj = $(".layui-form-checked").not('.header');
            var arr=[];
            obj.each(function(index, el) {
                arr.push(obj.eq(index).attr('data-id'));
            });
            return arr;
        }
    }

    //开启表格多选
    tableCheck.init();
      

    $('.container .left_open i').click(function(event) {
        if($('.left-nav').css('left')=='0px'){
            $('.left-nav').animate({left: '-221px'}, 100);
            $('.page-content').animate({left: '0px'}, 100);
            $('.page-content-bg').hide();
        }else{
            $('.left-nav').animate({left: '0px'}, 100);
            $('.page-content').animate({left: '221px'}, 100);
            if($(window).width()<768){
                $('.page-content-bg').show();
            }
        }

    });

    $('.page-content-bg').click(function(event) {
        $('.left-nav').animate({left: '-221px'}, 100);
        $('.page-content').animate({left: '0px'}, 100);
        $(this).hide();
    });

    $('.layui-tab-close').click(function(event) {
        $('.layui-tab-title li').eq(0).find('i').remove();
    });

   $("tbody.x-cate tr[fid!='0']").hide();
    // 栏目多级显示效果
    $('.x-show').click(function () {
        if($(this).attr('status')=='true'){
            $(this).html('&#xe625;'); 
            $(this).attr('status','false');
            cateId = $(this).parents('tr').attr('cate-id');
            $("tbody tr[fid="+cateId+"]").show();
       }else{
            cateIds = [];
            $(this).html('&#xe623;');
            $(this).attr('status','true');
            cateId = $(this).parents('tr').attr('cate-id');
            getCateId(cateId);
            for (var i in cateIds) {
                $("tbody tr[cate-id="+cateIds[i]+"]").hide().find('.x-show').html('&#xe623;').attr('status','true');
            }
       }
    })

    //左侧菜单效果
    // $('#content').bind("click",function(event){
    $('.left-nav #nav li').click(function (event) {
        if($(this).children('.sub-menu').length){
            if($(this).hasClass('open')){
                $(this).removeClass('open');
                $(this).find('.nav_right').html('&#xe697;');
                $(this).children('.sub-menu').stop().slideUp();
                $(this).siblings().children('.sub-menu').slideUp();
            }else{
                $(this).addClass('open');
                $(this).children('a').find('.nav_right').html('&#xe6a6;');
                $(this).children('.sub-menu').stop().slideDown();
                $(this).siblings().children('.sub-menu').stop().slideUp();
                $(this).siblings().find('.nav_right').html('&#xe697;');
                $(this).siblings().removeClass('open');
            }
        }else{

            var url = $(this).children('a').attr('_href');
            var title = $(this).find('cite').html();
            var index  = $('.left-nav #nav li').index($(this));

            for (var i = 0; i <$('.x-iframe').length; i++) {
                if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                    tab.tabChange(index+1);
                    event.stopPropagation();
                    return;
                }
            };
            
            tab.tabAdd(title,url,index+1);
            tab.tabChange(index+1);
        }
        
        event.stopPropagation();
         
    })
    
})
var cateIds = [];
function getCateId(cateId) {
    
    $("tbody tr[fid="+cateId+"]").each(function(index, el) {
        id = $(el).attr('cate-id');
        cateIds.push(id);
        getCateId(id);
    });
}

/*弹出层*/
/*
    参数解释：
    title   标题
    url     请求的url
    id      需要操作的数据id
    w       弹出层宽度（缺省调默认值）
    h       弹出层高度（缺省调默认值）
*/
function layer_window_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.9);
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
        //content: [url , 'no']
    });
}

/*关闭弹出框口*/
function layer_window_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}






//将表单域数据转换json对象
$.fn.jsonObject=function(){
	var serializeObj={};
    var array=this.serializeArray();
    var str=this.serialize();
    $(array).each(function(){
        if(serializeObj[this.name]){
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value; 
        }
    });
    return serializeObj;
};






/**
 * 去掉空格
 * 
 * @param str
 * @returns
 */
function trimNull(str){
	var len = str.length;
	var i= 0 ;
	var j = len-1 ;
	for(;i<len;i++){
		if (str.charAt(i)==' ') {
			continue;
		}else{
			break;
		}
	}
	if (i==len) return ''; // 全是空格
	for(;j>i;j--)  { 
		if (str.charAt(j)==' ') {
			continue;
		}else{
			break;                             
		}
	} 
	return str.substring(i,j+1);
}
/**
 * 判断是否为空字符串
 * @param str
 * @returns {Boolean}
 */
function checkIsNull(str){
	 if (trimNull(str) == ""){
		  return true;
	  }else{
		  return false;
	  }
 }

/**
 * 判断是否为浮点型
 * @param str
 * @returns
 */
function isFloat(str){
	if (str.search(/^\d*\.?\d{0,2}$/) != -1){
	    return true;
    }
    return false;
}

/**
 * 判断是否为整型
 * @param str
 * @returns
 */
function isDigit(str){
	if (str.search(/^\d*$/) != -1){
	    return true;
    }
    return false;
}

/**
 * 判断是否为整型
 * @param str
 * @returns
 */
function isInt(str){
	if (str.search(/^\d*$/) != -1){
	    return true;
    }
    return false;
}

/**
 * 验证邮箱
 * 
 * @param email
 * @returns {Boolean}
 */
function isEmail(email){
    if (email.search(/^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/) != -1){
	    return true;
    }
    return false;
}

/**
 * 验证电话号码
 * 
 * @param telphone
 * @returns {Boolean}
 */
function fucCheckTelPhone(telphone){
	if (telphone.search(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/) != -1){
	    return true;
    }
    return false;
}

/**
 * 验证手机号码
 * 
 * @param tel
 * @returns {Boolean}
 */
function fucCheckTEL(tel){
    if (tel.search(/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/) != -1){
    	return true; 
    }
    return false;
}


function checkAllCnText(id,infor){
	var reg=/[\u4E00-\u9FA5]/g;
	var str = $("#"+id).val();
	// if (reg.test(str)){
		alertMessageBox(testChar(str));
	// }
}

//特殊字符
function testChar(str){
	var pattern = new RegExp("[`~@#$^*<>&%]") 
	 return !pattern.test(str); 
}

//textarea 最大长度限制
function TxtMaxlength(textareaId,MaxCount){
	if(MaxCount==null || typeof(Number(MaxCount))!=="number") MaxCount=64;
		var length=$("#"+textareaId).val().length;
		if (length > MaxCount){
			$("#"+textareaId).val($("#"+textareaId).val().substr(0, MaxCount));
	}
}



/**
** 加法函数，用来得到精确的加法结果
** 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
** 调用：accAdd(arg1,arg2)
** 返回值：arg1加上arg2的精确结果
**/
function accAdd(arg1, arg2) {
   var r1, r2, m, c;
   try {
       r1 = arg1.toString().split(".")[1].length;
   }
   catch (e) {
       r1 = 0;
   }
   try {
       r2 = arg2.toString().split(".")[1].length;
   }
   catch (e) {
       r2 = 0;
   }
   c = Math.abs(r1 - r2);
   m = Math.pow(10, Math.max(r1, r2));
   if (c > 0) {
       var cm = Math.pow(10, c);
       if (r1 > r2) {
           arg1 = Number(arg1.toString().replace(".", ""));
           arg2 = Number(arg2.toString().replace(".", "")) * cm;
       } else {
           arg1 = Number(arg1.toString().replace(".", "")) * cm;
           arg2 = Number(arg2.toString().replace(".", ""));
       }
   } else {
       arg1 = Number(arg1.toString().replace(".", ""));
       arg2 = Number(arg2.toString().replace(".", ""));
   }
   return (arg1 + arg2) / m;
}

/**
 ** 减法函数，用来得到精确的减法结果
 ** 说明：javascript的减法结果会有误差，在两个浮点数相减的时候会比较明显。这个函数返回较为精确的减法结果。
 ** 调用：accSub(arg1,arg2)
 ** 返回值：arg1加上arg2的精确结果
 **/
function accSub(arg1, arg2) {
    var r1, r2, m, n;
    try {
        r1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
        r2 = 0;
    }
    m = Math.pow(10, Math.max(r1, r2)); //last modify by deeka //动态控制精度长度
    n = (r1 >= r2) ? r1 : r2;
    return ((arg1 * m - arg2 * m) / m).toFixed(n);
}


/**
 ** 乘法函数，用来得到精确的乘法结果
 ** 说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
 ** 调用：accMul(arg1,arg2)
 ** 返回值：arg1乘以 arg2的精确结果
 **/
function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try {
        m += s1.split(".")[1].length;
    }
    catch (e) {
    }
    try {
        m += s2.split(".")[1].length;
    }
    catch (e) {
    }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}
/** 
 ** 除法函数，用来得到精确的除法结果
 ** 说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
 ** 调用：accDiv(arg1,arg2)
 ** 返回值：arg1除以arg2的精确结果
 **/
function accDiv(arg1, arg2) {
    var t1 = 0, t2 = 0, r1, r2;
    try {
        t1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
    }
    try {
        t2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
    }
    with (Math) {
        r1 = Number(arg1.toString().replace(".", ""));
        r2 = Number(arg2.toString().replace(".", ""));
        return (r1 / r2) * pow(10, t2 - t1);
    }
}

//判断是否是IE
function isIE(){
	var arVersion = navigator.appVersion.split("MSIE");
  var version = parseFloat(arVersion[1]);
  if ((version > 5.5))return version;
	else return false;
}
//得到元素实际坐标
function getElementPosition(OB)
{	var posX=OB.offsetLeft;
	var posY=OB.offsetTop;
	var aBox=OB;//需要获得位置的对象
	while(aBox.tagName.toLowerCase()!="body")
	{	aBox=aBox.offsetParent;
		if(!aBox)break;
		posX+=aBox.offsetLeft;
		posY+=aBox.offsetTop;
	}
	return {left:posX,top:posY};
}
//获取url参数
function getUrlParam(sName)
{	
	if(sName)
	{
		var sValue='';
		var re= new RegExp("\\b"+sName+"\\b=([^&=]+)");
		var st=null;
		st=window.location.search.match(re);
		if(st&&st.length==2)
		{	
			st[1]=st[1].replace(/^\s*|\s*$/g,'');
			sValue=st[1];
		}
		return sValue;
	}
	else
	{
		alert("参数不能为空");
		return false;
	}
}
function locationHref(url,target){
	//可以支持多种跳转方式，而且document.referrer做记录
	var fun=function(){
		target=target?target:'_self';
		var a=document.createElement("a");
		a.style.display='none';
		a.href=url;
		a.target=target;
		a.innerHTML='&nbsp;';
		document.body.appendChild(a);
		a.click();
		if(target!='_self')document.body.removeChild(a);
	};
	//解决IE6超链接javascript:void(0)不跳转
	if(isIE()&&isIE()<7.0)setTimeout(fun,1);
	else fun();
}


//判断用户是否登录
function isUserLogin(){ 
	var loginUserId = getCookie(cookieName_LoginUserId);

	if(loginUserId==null)loginUserId='';
	if((loginUserId=='')||(loginUserId=='""')) { 
		return false;
	} else {
		return true;	
	}
}
function getCookie(name){
	var start=document.cookie.indexOf(name+"=");
	if(start==-1) return null;
	var len=start + name.length + 1;
	var end = document.cookie.indexOf(';',len);
	if (end==-1) end=document.cookie.length;
	return unescape(document.cookie.substring(len, end));
}



function logout(returnUrl){
	     if ((typeof(returnUrl) == "undefined")||(returnUrl == null)) {
		    returnUrl ='';
	     } 
	  
	
	    $.ajax({
			 type: "post",
			 dataType: "",
			 contentType:'application/x-www-form-urlencoded',
			 url: "/passport/logout",
			 data:"",				  
			 beforeSend: function(XMLHttpRequest){						
			 },
			 success: function(responseText, textStatus){  
				 window.location.href ='/'+returnUrl;
			  
			 },
			 complete: function(XMLHttpRequest, textStatus){ 
			  },  
	         error: function(){			 
		  	 }
		   });     
	}

/**
 * author Wangc
 * version 2019年4月18日上午11:22:53
 * @param keyId 后台实体类对象ID名字 例如工厂表 工厂对象的ID为factoryId  那么 keyId=factoryId
 * @param keyValue	后台实体类对象ID的值 例如 工厂对象factoryId=100025 那么 keyValue=100025
 * @param selectId	需要绑定的下拉框的ID 需要渲染的下拉框
 * @param linkName  后台得到的name字段 例如 factoryName
 * @param linkId    等同于keyValue 用做编辑时下拉框自动绑定对应
 * @param url	    请求后台地址
 */
function linkCommonMethod(keyId,keyValue,selectId,linkName,linkId,url){
	layui.use([ 'form'], function(){
		var form = layui.form;
		var resjosn=null;
		var obj = {};
		var key = keyId;
		var value = keyValue;
		obj[key] = value;
		 
			 $.ajax({
			         type: "post",
					 dataType: "",
					 contentType:'application/x-www-form-urlencoded',
					 url:url,
					 data:obj,		
			         success: function(res){
				 	    resjosn=JSON.parse(res);
			 	        resjosn.forEach(function(val,key){
			 	        	var selectName = linkName;
			 				var option1 = $("<option></option>");
			 				option1.attr("value",val.id).text(val[selectName]);
						 	if (val.id == linkId){
						 		option1.attr("selected","selected");
						    };
						    $("#"+selectId).append(option1);
			 			});
			 			form.render('select');
			       }
			   });
		});
	}


/**选择仓库下拉框加载 (货位) 下拉级联
 * @param factoryId  	传入的仓库ID
 * @param selectId   	选中下拉框ID
 * @param selectName    仓库名称字段 
 * @param linkId	 	编辑时传入ID
 * @param url		 	请求地址
 */
function linkWarehouseLocationByWarehouse(warehouseId,selectId,selectName,linkId,url){
	layui.use([ 'form'], function(){
		var form = layui.form;
		var resjosn=null;
		$.ajax({
			type: "post",
			dataType: "",
			contentType:'application/x-www-form-urlencoded',
			url:url,
			data:{warehouseId:warehouseId},		
			        success: function(res){
				resjosn=JSON.parse(res);
				console.log(resjosn);
				resjosn.forEach(function(val,key){
					var option1 = $("<option></option>");
					option1.attr("value",val.id).text(val[selectName]);
					if (val.id == linkId){
						option1.attr("selected","selected");
					};
					$("#"+selectId).append(option1);
				});
				form.render('select');
				      }
			  });
	});
}

/**
 * 根据datajson数组参数查询明细
 * @param data json数组格式参数
 * @param url 请求路径
 * @returns 返回一个json数组
 */
function selectItemById(data,url){
	var resjosn=null;
		$.ajax({
			type: "post",
			dataType: "",
			contentType:'application/x-www-form-urlencoded',
			url:url,
			async:false,//将同步标志改为false，代表执行完后续代码才返回结果
			data:data,		
	        success: function(res){
			resjosn=JSON.parse(res);
				//resjosn=res;
				      }
			  });
		return resjosn;
}
function selectItemByIdNew(data,url){
	var resjosn=null;
	$.ajax({
		type: "post",
		dataType: "",
		contentType:'application/x-www-form-urlencoded',
		url:url,
		async:false,//将同步标志改为false，代表执行完后续代码才返回结果
		data:data,		
		        success: function(res){
				//resjosn=JSON.parse(res);
			resjosn=res;
			      }
	  });
	return resjosn;
}

/**
 * 弹出框通用
 * 物品弹窗框url: '/product/productMain/productMainOpen'
 * 物料弹出框url:'/product/productMaterial/productMaterialOpen'
 * author xiang
 * @param url 访问的url页面
 * @param inputId 输入框id
 * @param inputName 名称输入框NameId 名称字段要跟表字段对应 否则查询不到对应的名称
 */
function openWinSelect(url,inputId,inputName){
	layer.open({
		  	type: 2, 
		  	title :'请选择数据',
		  	maxmin: true,
			area: ['750px', '500px'],
		 	btn: ['确定', '取消'],
		  	content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
	  		yes: function(index, layero){
	  			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
	            var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
	  			if (selectData.length <= 0) {
	  				layer.msg('请至少选择一个！');
	  			} else {
						var id=selectData[0][0].id;
						var name=selectData[0][0][inputName];	
						if(inputName == 'nodeName'){
							inputName = "nodeNames";
						}
	  					$("#"+inputId).val(id);
	  					$("#"+inputName).val(name);
		  				layer.close(index);
	  				
	  			}
	  		},
  		 
		}); 
}
function openWinSelect2(url,inputId,inputName,productid,productname){
	layer.open({
		type: 2, 
		title :'请选择数据',
		maxmin: true,
		area: ['850px', '550px'],
		btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		yes: function(index, layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
			if (selectData.length <= 0) {
				layer.msg('请至少选择一个！');
			} else {
				var id=selectData[0][0].id;
				var name=selectData[0][0][inputName];
				var productId=selectData[0][0].productId;
				var productName=selectData[0][0].productMain.productName;
				$("#"+inputId).val(id);
				$("#"+inputName).val(name);
				$("#"+productid).val(productId);
				$("#"+productname).val(productName);
				 
				layer.close(index);
				
			}
		},
		
	}); 
}
//根据物品类型确定输入框是否出现
function openWinSelectProductType(url,inputId,inputName,productid,productname,bomname){
	layer.open({
		type: 2, 
		title :'请选择数据',
		maxmin: true,
		area: ['850px', '550px'],
		btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		yes: function(index, layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
			if (selectData.length <= 0) {
				layer.msg('请至少选择一个！');
			} else {
				var id=selectData[0][0].id;
				var name=selectData[0][0][inputName];
				var productId=selectData[0][0].productId;
				var productName=selectData[0][0].productMain.productName;
				var productTypeDictId=selectData[0][0].productTypeDictId;
				if(productTypeDictId != 10319){
		        	  $("#"+bomname).parent('td').css('display','');
		        	  $("#"+bomname).parent('td').prev().css('display','');
		    	  }else{
		    		  $("#"+bomname).parent('td').css('display','none');
		    		  $("#"+bomname).parent('td').prev().css('display','none');
		    	  }
				$("#"+inputId).val(id);
				$("#"+inputName).val(name);
				$("#"+productid).val(productId);
				$("#"+productname).val(productName);
				
				layer.close(index);
				
			}
		},
		
	}); 
}
function openWinSelect3(url,inputId,inputName,productid,productname,materialid,materialname){
	layer.open({
		type: 2, 
		title :'请选择数据',
		maxmin: true,
		area: ['850px', '550px'],
		btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		yes: function(index, layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
			if (selectData.length <= 0) {
				layer.msg('请至少选择一个！');
			} else {
				console.log(selectData[0][0]);
				var id=selectData[0][0].id;
				var name=selectData[0][0][inputName];
				var productId=selectData[0][0].productId;
				var productName=selectData[0][0].productMain.productName;
				var materialId=selectData[0][0].materialId;
				var materialName=selectData[0][0].productMaterial.materialName;
				$("#"+inputId).val(id);
				$("#"+inputName).val(name);
				$("#"+productid).val(productId);
				$("#"+productname).val(productName);
				$("#"+materialid).val(materialId);
				$("#"+materialname).val(materialName);
				
				layer.close(index);
				
			}
		},
		
	}); 
}

/**
 * 打开小窗口显示详情信息通用版
 * 支持回填三个文本框
 */                                                                         
function openWinSelectCurrency(url,inputId,inputName,object0,inputId0,inputName0,object1,inputId1,inputName1){
	layer.open({
		type: 2, 
		title :'请选择数据',
		maxmin: true,
		area: ['750px', '500px'],
		btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		yes: function(index, layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
			console.log(selectData);
			if (selectData.length <= 0) {
				layer.msg('请至少选择一个！');
			} else {
				var id=selectData[0][0].id;
				var name=selectData[0][0][inputName];
				$("#"+inputId).val(id);
				$("#"+inputName).val(name);	
				 
				if(object0 !="" && inputId0!="" && inputName0!="" ){
					var id0 = selectData[0][0][inputId0];
					var name0 = selectData[0][0][object0][inputName0];
					$("#"+inputId0).val(id0);
					$("#"+inputName0).val(name0);
				}
				
				if(object1 !="" && inputId1!="" && inputName1!="" ){
					var id1 = selectData[0][0][inputId1];
					var name1 = selectData[0][0][object1][inputName1];
					$("#"+inputId1).val(id1);
					$("#"+inputName1).val(name1);
				}
				layer.close(index);
				
			}
		},
		
	}); 
}


function skuOpen(url,inputId){
	layer.open({
		type: 2, 
		title :'请选择数据',
		maxmin: true,
		area: ['750px', '500px'],
		//btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		 
		
	}); 
}


/**
 * 根据产品BOM树选择物料通用弹窗
 *  author xiang
 *  @param url 访问的产品BOM弹窗的url页面 ：'product/productBom/productBomOpen'
 */
function openWinProductBom(url){
 
	layer.open({
	  	type: 2, 
	  	title :'请选择物料',
	  	maxmin: true,
		area: ['850px', '500px'],
	 	btn: ['确定', '取消'],
	  	content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
  		yes: function(index, layero){
  			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
            var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
  			if (selectData.length <= 0) {
  				layer.msg('请至少选择一个！');
  			} else {
  				    returnDatas(selectData);
	  				layer.close(index);
  				
  			}
  		},
		 
	});
}
 
function openWinPrint(url){
	layer.open({
		type: 2, 
		title :'选择标签模板类型',
		maxmin: true,
		area: [ '852px', '600px' ],
		//btn: ['确定', '取消'],
		content: url, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com ', 'no']
		success: function(layero, index) {
             var body = layer.getChildFrame('body', index);//建立父子联系
             var iframeWin = window[layero.find('iframe')[0]['name']];
           //  var inputList = body.find('materialId');
             //$(inputList).val(materialId);
         }
 
		/*yes: function(index, layero){
			var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
			var selectData = iframeWin.selected();//调用子页面的方法，得到子页面返回的ids
			
			layer.close(index);
			return 	selectData;
			
		},*/
		
	}); 
}



///------------ 打印管理-----------------
function insertPrintData(data,url){

	$.ajax({
		type: "post",
		dataType: "json",
		contentType:'application/json;charset=utf-8',
		url:url,
		data:JSON.stringify(data),		
		success: function(res){
			
			}
		  });
	
}



/**
 * 导入模板通用方法
 * @param textName:文本域的id,用来显示加载模板代码块，如果不需要显示代码块，可以不传参
 * @returns
 */
function myReadFile(textName) {
	if(textName==null)textName='codeBlock';
	if (LODOP.CVERSION) CLODOP.On_Return=function(TaskID,Value){
		var strFilename=Value;
		CLODOP.On_Return=function(TaskID,Value){document.getElementById(textName).value=Value};
		LODOP.GET_FILE_TEXT(strFilename);
	};
	var strFilename=LODOP.GET_DIALOG_VALUE("LocalFileFullNameforOpen","导入的文件名.txt");
 	if (!LODOP.CVERSION) {
		return LODOP.GET_FILE_TEXT(strFilename);
	};		
	
};

/**
 * 生成一个指定位数的随机数
 * @param n 随机数位数
 * @returns {String}
 */
function RndNum(n){
	  var rnd="";
	  for(var i=0;i<n;i++)
	     rnd+=Math.floor(Math.random()*10);
	  return rnd;
	}

/**
 * 请重写该方法，方法名自定义：因为变量赋值需要声明与标签模板相匹配的变量名
 * datas:要打印的数据集
 * str:需要打印的模板下半部代码块，不需要你们传参
 * @param datas,str
 */
function print_newPage(datas,str){
	for (var i = 0; i < datas.length; i++) {
		LODOP.NewPage();
		/**
		 * 该方法下面需要写自己对应模板的变量名赋值；下面的两个变量是例子，可以替换成自己需要的字段
		 */
		
		var MODULE_SN=datas[i].MODULE_SN;//举例说明：MODULE_SN是标签模板中设定的变量，需要在这里声明并赋值；
		var MODULE_NM=datas[i].MODULE_NM;//举例说明：MODULE_NM是标签模板中设定的变量，需要在这里声明并赋值；
	eval(str); //加载模板
	}	
}
/**
 * 预览打印方法，执行该方法之前，请先调用下面的调用模板方法
 * 
 * 
 * @param datas：你需要打印的结果集，json格式数组集合
 * @param methodName:自定义方法名，方法体如上：print_newPage()模式
 * @param textName:文本域的id,用来显示加载模板代码块，如果不需要显示代码块，可以不传参
 */
function print_Preview(datas,methodName,textName) {
	LODOP=getLodop();
	if(textName==null)textName='codeBlock';
	var str=document.getElementById(textName).value;
	var str2=document.getElementById(textName).value;
	if(str!=null&&str!=""){
		str.trim().split('\n').forEach(function(v, i) {//按行拿出前两行模板代码块
			window['str' + (i+1)] = v
			if(i<2){
				str =str.replace(v,"").trim();
			}
		})
		str2.trim().split('\n').forEach(function(v, i) {//按行拿出前两行以外的模板代码块
			window['str2' + (i+1)] = v
			if(i>1){
				str2 =str2.replace(v,"").trim();
			}
		})		
		
		eval(str2); 
		methodName(datas,str);	
	}else{
		methodName(datas);	
		
	}
		//LODOP.PRINT();
	
	/*if (LODOP.CVERSION) {//判断打印是否成功
		
		result(function(message){//这里调用异步回调函数，可以得到打印结果
			console.log(message);
		});
		
		//LODOP.SET_PREVIEW_WINDOW(0,1,0,800,600,"");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		
		//LODOP.PRINTA();//直接打印,返回的是boolean
		LODOP.PREVIEW();//打印预览
		return ;
	}*/
};

/**
 * 用来判断预览打印是否成功，或者直接打印是否成功
 * @param resultMessage 预览打印，返回的是数字，代表打印次数，直接打印返回的是boolean,true:成功，false:失败
 */
function result(resultMessage){
	CLODOP.On_Return=function(TaskID,Value){
		resultMessage(Value); 
		if(!Value||Value==0){
			alert("放弃打印");
		}
		
	};
	
}





/**
 * 打印表格，面单之类
 * @param Top:表格数据头(页头thead)在纸张内的上边距，整数或字符型，整数时缺省长度单位为px,字符型时可包含单位名：in(英寸)、cm(厘米) 、mm(毫米) 、pt(磅)、px(1/96英寸) 、%(百分比)，如“10mm”表示10毫米
 * @param Left:表格数据头(页头thead)在纸张内的左边距，整数或字符型，字符型时可包含单位名：in(英寸)、cm(厘米) 、mm(毫米) 、pt(磅)、px(1/96英寸) 、%(百分比)，如“10mm”表示10毫米
 * @param Width:打印区域的宽度，整数或字符型，整数时缺省长度单位为px。字符型时可包含单位名：in(英寸)、cm(厘米) 、mm(毫米) 、pt(磅)、px(1/96英寸) 、%(百分比)，如“10mm”表示10毫米。本参数可以用RightMargin关键字转义为打印区域相对于纸张的“右边距”
 * @param Height:表格数据体(tbody)区域的高度，整数或字符型，整数时缺省长度单位为px。字符型时可包含单位名：in(英寸)、cm(厘米) 、mm(毫米) 、pt(磅)、px(1/96英寸) 、%(百分比)，如“10mm”表示10毫米。当内容的高度超出本参数值时，控件会自动分页，后面的内容在下一页对应位置输出，每页至少打印一个TR行(由于table可以嵌套多层子table，这里的TR行是指首层TR)
 * @param strHtml:超文本代码内容，字符型，未限制长度。可以是一个完整的页面超文本代码，或者是一个代码段落，也可以是URL:web地址形式的URL地址。要求实际内容中至少包含一个table元素
 * @param iRadioValue:数字型， 0-代表不包含（默认），1-代表包含头和尾 2-只包含页头 3-只包含页尾。这个值仅对TABLE对象有效
 */
function DesignMytable(Top,Left,Width,Height,strHtml,iRadioValue){
	LODOP=getLodop();  
	LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_打印设计表格");
	//LODOP.ADD_PRINT_TABLE(100,5,500,800,document.getElementById("strHtml").innerHTML);
	LODOP.ADD_PRINT_HTM(Top,Left,Width,Height,document.getElementById(strHtml).innerHTML);
	LODOP.SET_PRINT_STYLEA(0,"TableHeightScope",iRadioValue);
	LODOP.SET_PRINT_MODE("FULL_WIDTH_FOR_OVERFLOW",true);
	LODOP.SET_PRINT_MODE("FULL_HEIGHT_FOR_OVERFLOW",true);
	LODOP.SET_PREVIEW_WINDOW(1,3,0,0,0,"");
	//LODOP.PREVIEW();//表格预览
	LODOP.PRINT_DESIGN();//打印设计方法
};	
///------------ 地区-----------------

$(document).ready(function() {
			$("#provinceConfigAreaDict").change(function() {
						var pid = $(this).val();
						$("#cityConfigAreaDict option[value!='']").remove();
						$("#areaConfigAreaDict option[value!='']").remove();
						if (pid != "") {
							loadArea(pid, 1);
						}
					});

			$("#cityConfigAreaDict").change(function() {
						var pid = $(this).val();
						$("#areaConfigAreaDict option[value!='']").remove();
						if (pid != "") {
							loadArea(pid, 2);
						}
					});					
		});

function loadArea(pid, showSelect, selectid) {
/*	$.post("/config/configareadict/0/json?pid="+pid, function(data, textStatus) {
				if (data != "f") {
					areaJson = $.parseJSON(data);
					for (var i = 0; i < areaJson.length; i++) {
							var $option = $("<option></option>");
							$option.attr("value", areaJson[i].id);
							$option.text(areaJson[i].name);
							if (areaJson[i].id == selectid) {
								$option.attr("selected", "selected");
							}
							if (showSelect == 0) {
								$("#provinceConfigAreaDict").append($option);
							} else if (showSelect == 1) {
								$("#cityConfigAreaDict").append($option);
							} else {
								$("#areaConfigAreaDict").append($option);
							}
					}
				}

			});*/
	$.post("/config/areaDict/getByPid/"+pid, function(responseText) {
		    var areaJson = jQuery.parseJSON(responseText);
		    
			for (var i = 0; i < areaJson.length; i++) {
					var $option = $("<option></option>");
		 
					$option.attr("value", areaJson[i].id);
					$option.text(areaJson[i].areaName);
					if (areaJson[i].id == selectid) {
						$option.attr("selected", "selected");
					}
					if (showSelect == 0) {
						$("#provinceConfigAreaDict").append($option);
					} else if (showSelect == 1) {
						$("#cityConfigAreaDict").append($option);
					} else {
						$("#areaConfigAreaDict").append($option);
					}
			}
	});
}

function initArea(pid, cid, aid) {
	$("#cityConfigAreaDict option[value!='']").remove();
	$("#areaConfigAreaDict option[value!='']").remove();
	loadArea(8100000, 0, pid);
	loadArea(pid, 1, cid);
    loadArea(cid, 2, aid);
}
 

//base64加密开始  
var keyBase64Str = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"  + "wxyz0123456789+/" + "=";  
  
function encode64(input) {  

    var output = "";  
    var chr1, chr2, chr3 = "";  
    var enc1, enc2, enc3, enc4 = "";  
    var i = 0;  
    do {  
        chr1 = input.charCodeAt(i++);  
        chr2 = input.charCodeAt(i++);  
        chr3 = input.charCodeAt(i++);  
        enc1 = chr1 >> 2;  
        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
        enc4 = chr3 & 63;  
        if (isNaN(chr2)) {  
            enc3 = enc4 = 64;  
        } else if (isNaN(chr3)) {  
            enc4 = 64;  
        }  
        output = output + keyBase64Str.charAt(enc1) + keyBase64Str.charAt(enc2)  
                + keyBase64Str.charAt(enc3) + keyBase64Str.charAt(enc4);  
        chr1 = chr2 = chr3 = "";  
        enc1 = enc2 = enc3 = enc4 = "";  
    } while (i < input.length);  

    return output;  
}  


/*获取url参数  2019-6-13*/
function getParam(paraName){
	if(!paraName){
		alert('公共方法参数参数为空');
		return;
	};
	var urlArr = decodeURI(decodeURI(window.location.href)).toString().split("?");
	if (urlArr.length > 1) {
		var arrPara = urlArr[1].split("&"),arr;
		for (var i = 0; i < arrPara.length; i++) {
			arr = arrPara[i].split("=");
			if (arr != null && arr[0] == paraName) {
				return arr[1];
			}
		}
		return "";
	}else {
		return "";
	}
}













