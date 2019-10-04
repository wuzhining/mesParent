(function () {
    /*递归加载树数据*/
    loadTree = function (data, idFiled, textFiled) {
        if (!data) return;
        var i, l, treeData = [], tmpMap = [];
        for (i = 0, l = data.length; i < l; i++) {
            data[i]['id'] = data[i][idFiled];
            data[i]['text'] = data[i][textFiled];
            if (data[i]['children']) {
                loadTree(data[i]['children'], idFiled, textFiled)
            }
        }
        return data;
    };
    //重写树控件值域、文本域绑定
    $.fn.tree.defaults.loadFilter = function (data, parent) {
        var opt = $(this).data().tree.options;
        var idFiled, textFiled, parentField;
        if (opt.parentField) {
            idFiled = opt.idFiled || 'id';
            textFiled = opt.textFiled || 'text';
            parentField = opt.parentField || 'pid';
            var i, l, treeData = [], tmpMap = [];
            loadTree(data, idFiled, textFiled);
        }
        return data
    };
    $.fn.combotree.defaults.loadFilter = function (data, parent) {
        var opt = $(this).data().tree.options;
        var idFiled,
	    textFiled,
	    parentField;
        if (opt.parentField) {
            idFiled = opt.idFiled || 'id';
            textFiled = opt.textFiled || 'text';
            parentField = opt.parentField || 'pid';
            var i, l, treeData = [], tmpMap = [];
            loadTree(data, idFiled, textFiled);
        }
        return data
    };	
    /*请求树数据并绑定到树控件*/
    reqTreeData = function (url, reqData) {
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                var rowCollection = createSourceObj(data);
                var jsonData = rowCollection;
                bindTreeData(jsonData);
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    /*请求下拉框树数据并绑定到树控件*/
    reqComboTreeData = function (url, reqData) {
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                var rowCollection = createSourceObj(data);
                var jsonData = rowCollection;
                bindCombotree(jsonData);
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    /*初始化树控件*/
    initComboTree = function (tree) {
        if (!tree) retrun;
        $('#' + tree.name).combotree({
            method: tree.method,
            parentField: tree.parentField || "pid",
            textFiled: tree.parentField || "text",
            idFiled: tree.idFiled || "id",
            onClick: tree.onClick
        });
    };

    /*初始化树控件*/
    initTree = function (tree) {
        if (!tree) retrun;
        $('#' + tree.name).tree({
            method: tree.method,
            parentField: tree.parentField || "pid",
            textFiled: tree.parentField || "text",
            idFiled: tree.idFiled || "id",
            onClick: tree.onClick
        });
    };
    /*分页*/
    pagerFilter = function (data) {
        var dg = $('#' + data.gridId);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
        	showPageList:false,
        	showRefresh:false,
            onSelectPage: function (pageNum, pageSize) {
                opts.pageNumber = pageNum;
                opts.pageSize = pageSize;
                dg.pageSize = pageSize;
                var reqData = {
                    IFS: data.IFS,
                    pageIndex: pageNum,
                    pageSize: pageSize
                }
                for(var p in data){
                	var name=p;//属性名称 
                	if(name=="pageIndex" || name =="pageSize" || name=="rows" || name=="total" ||name=="originalRows"){
                		continue;
                	}
                	var value=data[p];//属性对应的值 
                	reqData[name]=data[p]; 
                }
                reqGridData('/iPlant_app', data.gridId, reqData);
            }
        	,
            onRefresh: function (pageNumber, pageSize) {
                opts.pageNumber = 1;
                var reqData = {
                    IFS: data.IFS,
                    pageIndex: 1,
                    pageSize: pageSize
                }
                reqGridData('/iPlant_app', data.gridId, reqData);
            }
        });
        if (!data.originalRows) {
            data.originalRows = (data.rows);
        }
        var start = 0;
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    };
     ajaxLoading = function (){  
		    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");  
		    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
	 
     };
		ajaxLoadEnd = function (){  
		     $(".datagrid-mask").remove();  
		     $(".datagrid-mask-msg").remove();              
		}; 
    /*请求列表数据并绑定到列表控件，并解析后台返回Json格式*/
//  reqGridData = function (url, gridId, reqData,pageSize) {
//      
//      var ajaxParam = {
//          url: url,
//          data: reqData,
////          async:false,
//			beforeSend:function(){
////				alert('111');
//				ajaxLoading();
//			},
//          successCallBack: function (data) {
//              if (data) {
//                  var rowNum = 0
//                  if(!data.RESPONSE["0"].RESPONSE_HDR) rowNum=0;
//                  else if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
//                      rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
//                  }
//                  if (rowNum == 0) {
//                      //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数 
//                      //var gridColsCnt=$('#'+gridId).columns
//                      /*$('#'+gridId).datagrid('appendRow', { DICT_IT: '<div style="text-align:center;color:red">没有相关记录！</div>' })
//                      .datagrid('mergeCells', { index: 0, field: 'DICT_IT', colspan: }); 
//                      $('#'+gridId).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();*/
//
//                      /*var divWidth=$('body').width()-10;
//                      var divHtml="<div id='box' style=' width:"+divWidth+"px;height:20px;line-height:20px;margin:10px auto;border:1px solid #E0ECFF;text-align:center;color:red'>没有相关记录！</div>";
//                      $('body').html(divHtml);
//                      $("#box").animate({height:"30px"});
//                      $("#box").css("height:30px;line-height:30px");*/
//                      if($.messager.alert('提示', '没有相关记录')){
//                      	ajaxLoadEnd();
//                      }
//                      return;
//                  }
//                  var rowCollection = createSourceObj(data);
//                  var jsonData = {
//                      total: rowNum,
//                      rows: rowCollection,
//                      IFS: reqData.IFS,
//                      gridId: gridId
//                  }
//                  if (reqData.DICT_CD) {
//                      $.extend(jsonData, { DICT_CD: reqData.DICT_CD });
//                  }
//                  bindGridData(reqData, jsonData, pageSize);
//					ajaxLoadEnd();
//              }
//          }
//          
//      }
//      iplantAjaxRequest(ajaxParam);
//  };
  	 reqGridData = function (url, gridId, reqData) {
    	if("pageSize" in reqData){
    		 //存在
    		reqData.pageSize=initHeight();
    	}
    	
        var ajaxParam = {
            url: url,
            data: reqData,
            beforeSend:function(){
//				alert('111');
				ajaxLoading();
			},
            successCallBack: function (data) {
                if (data) {
                    var rowNum = 0
                    if(data.RESPONSE.length>0){
                       if(!data.RESPONSE["0"].RESPONSE_HDR) rowNum=0;
                       else if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
                           rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
                       }
                    }
                    if (rowNum == 0) {
                        //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数 
                        //var gridColsCnt=$('#'+gridId).columns
                        /*$('#'+gridId).datagrid('appendRow', { DICT_IT: '<div style="text-align:center;color:red">没有相关记录！</div>' })
                        .datagrid('mergeCells', { index: 0, field: 'DICT_IT', colspan: }); 
                        $('#'+gridId).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();*/

                        /*var divWidth=$('body').width()-10;
                        var divHtml="<div id='box' style=' width:"+divWidth+"px;height:20px;line-height:20px;margin:10px auto;border:1px solid #E0ECFF;text-align:center;color:red'>没有相关记录！</div>";
                        $('body').html(divHtml);
                        $("#box").animate({height:"30px"});
                        $("#box").css("height:30px;line-height:30px");*/
//                      $.messager.alert('提示', '没有相关记录');
                        if($.messager.alert('提示', '没有相关记录')){
                        	ajaxLoadEnd();
                        }
                        
                    }
                    var rowCollection = createSourceObj(data);
                    var jsonData = {
                        total: rowNum,
                        rows: rowCollection,
                        IFS: reqData.IFS,
                        gridId: gridId
                    }
                    for(var p in reqData){
                    	var name=p;//属性名称 
                    	if(name=="pageIndex" || name =="pageSize" || name=="rows" || name=="total" ||name=="originalRows"){
                    		continue;
                    	}
                    	var value=reqData[p];//属性对应的值 
                    	jsonData[name]=reqData[p]; 
                    }
                    bindGridData(reqData, jsonData);
                    ajaxLoadEnd();
                }
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    reqAGVData = function (url, gridId, reqData) {
    	if("pageSize" in reqData){
    		 //存在
    		reqData.pageSize=initHeight();
    	}
    	
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                if (data) {
                    var rowNum = 0
                    if(data.RESPONSE.length>0){
                       if(!data.RESPONSE["0"].RESPONSE_HDR) rowNum=0;
                       else if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
                           rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
                       }
                    }
                    if (rowNum == 0) {
                        //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数 
                        //var gridColsCnt=$('#'+gridId).columns
                        /*$('#'+gridId).datagrid('appendRow', { DICT_IT: '<div style="text-align:center;color:red">没有相关记录！</div>' })
                        .datagrid('mergeCells', { index: 0, field: 'DICT_IT', colspan: }); 
                        $('#'+gridId).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();*/

                        /*var divWidth=$('body').width()-10;
                        var divHtml="<div id='box' style=' width:"+divWidth+"px;height:20px;line-height:20px;margin:10px auto;border:1px solid #E0ECFF;text-align:center;color:red'>没有相关记录！</div>";
                        $('body').html(divHtml);
                        $("#box").animate({height:"30px"});
                        $("#box").css("height:30px;line-height:30px");*/
//                      $.messager.alert('提示', '没有相关记录');
                        if($.messager.alert('提示', '没有相关记录')){
                        	ajaxLoadEnd();
                        }
                        
                    }
                    var rowCollection = createSourceObj(data);
                    var jsonData = {
                        total: rowNum,
                        rows: rowCollection,
                        IFS: reqData.IFS,
                        gridId: gridId
                    }
                    for(var p in reqData){
                    	var name=p;//属性名称 
                    	if(name=="pageIndex" || name =="pageSize" || name=="rows" || name=="total" ||name=="originalRows"){
                    		continue;
                    	}
                    	var value=reqData[p];//属性对应的值 
                    	jsonData[name]=reqData[p]; 
                    }
                    bindGridData(reqData, jsonData);
                    ajaxLoadEnd();
                }
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
  	initHeight = function () {
      	var ccheight= document.body.clientHeight-120;
      	var ipg = parseInt(ccheight/25);
      	return ipg;
   }  			
    /*初始化列表控件*/
    initGridView = function (reqData, grid) {
        if (!grid) return
        var isPaginaion=true;
        if(grid.pagination!=null &&  grid.pagination==false){isPaginaion=false;}
        $('#' + grid.name).datagrid({
            title: grid.title,
            dataType: grid.dataType,
            pagination: isPaginaion,
            pageSize: grid.pageSize || 6,
            pageList: grid.pageList || [6,10, 20, 30, 40],
            columns: grid.columns,
            rownumbers: grid.rownumbers,
            loadMsg: '数据加载中...',
            onClickRow: grid.onClickRow || function (index, row) {

            },
            onDblClickRow: grid.onDblClickRow || function (index, row) {

            },
            onLoadSuccess: grid.onLoadSuccess ||function(){
            	
            }

        });
//      $('#' + grid.name).datagrid({ loadFilter: pagerFilter });
    };
    /*序列化表单*/
    serializeForm = function (objs) {
        var parmString = $(objs).serialize();
        var parmArray = parmString.split("&");
        var parmStringNew = "";
        $.each(parmArray,function (index, data) {
	        var li_pos = data.indexOf("=");
	        if (li_pos > 0) {
	            var name = data.substring(0, li_pos);
	            var value = decodeURIComponent(data.substr(li_pos + 1));
	            var parm = name + "=" + value;
	            parmStringNew = parmStringNew == "" ? parm : parmStringNew + '&' + parm;
	        }
	    });
        return parmStringNew;
    };
    /*将字符串序列化为数组对象*/
    serializeToJson = function (para) {
        var ary = para.split('&'),
	    obj = {};
        for (var i = 0; i < ary.length; i++) {
            if (!ary[i] || ary[i].charAt(0) == '=') continue;
            var eqCharIndex = ary[i].indexOf('=');
            if (eqCharIndex == -1) continue;
            obj[ary[i].substring(0, eqCharIndex)] = ary[i].substring(eqCharIndex + 1, ary[i].length);
        }
        para = obj;
        return para;
    };
    /*将对象转换为字符串*/
    jsonToString = function (json) {
        var item = '',
	    itemFormat = '"{0}":"{1}"';
        for (var i = 0; i < json.length; i++) {
            for (var name in json[i]) {
                var b = itemFormat.replace('{0}', name).replace('{1}', json[i][name]);
                item += item.length == 0 ? b : ',' + b;
            }
        }

        return '[{' + item + '}]';
    };
    /*将对象转换为字符串*/
    jsonArryToString = function (json) {
        var item = '',
	    itemFormat = '{0}:"{1}"';
        for (var i = 0; i < json.length; i++) {
            var temp = '{';
            for (var name in json[i]) {
                var b = itemFormat.replace('{0}', name).replace('{1}', json[i][name]);
                temp += temp == '{' ? b : ',' + b;
            }
            temp += "}";
            //遍历完一条请求
            item += item == '' ? temp : ',' + temp;
        }
        return '{reqstr:[' + item + ']}';
    };
	/*将后台返回数据进行转换为控件可以绑定格式*/
	createSourceObj=function(data) {
	    var rowArray = new Array();
	    if(data.RESPONSE.length>0){
	       if(!data.RESPONSE["0"].RESPONSE_DATA) return rowArray;
	       for (var i = 0; i < data.RESPONSE["0"].RESPONSE_DATA.length; i++) {
	          if (data.RESPONSE["0"].RESPONSE_DATA[i]) {
	              rowArray.push($.extend(data.RESPONSE["0"].RESPONSE_DATA[i],{code:''}));
	          }
	       }
	    }
	    return rowArray;
	}
	/*重新组合行数据列*/
	reCreateDataSource=function(data,grid){
	    if(grid){
	    	var rowArray = new Array();
	    	if(data.RESPONSE.length>0){
	    	   if(!data.RESPONSE["0"].RESPONSE_DATA) return rowArray;
		       for (var i = 0; i < data.RESPONSE["0"].RESPONSE_DATA.length; i++) {
		          if (data.RESPONSE["0"].RESPONSE_DATA[i]) {
		             rowArray.push($.extend(data.RESPONSE["0"].RESPONSE_DATA[i],{code:grid.code,name:grid.name}));
		          }
		       }
	    	}
		    return rowArray;
	    }	
	}
	
	
	
	
	reqGroundData1=function(url,reqData,grounpName){
	    var ajaxParam={
	          url:url,
	          data:reqData,
	          successCallBack:function(data){
	            var rowNum=0
	            if(data.RESPONSE.length>0){
	              if(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS){
	                rowNum=parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
	              }
	            }
	            var rowCollection=createSourceObj(data);
	            var jsonData={
	                  total:rowNum,
	                  rows:rowCollection
	            }
				$("#"+grounpName).datagrid("loadData", jsonData);
//				grounpsAjax(jsonData,grounpName);
	         }
	      }
	     iplantAjaxRequest(ajaxParam);
	}
	
	
	setUserID=function(value){
		window.userID=value;
	}
	getUserID=function(){
		 return window.userID;
	}
	/*将后台返回数据进行转换为控件可以绑定格式*/
    createSourceObj = function (data) {
        var rowArray = new Array();
        if(data.RESPONSE.length>0){
           if (!data.RESPONSE["0"].RESPONSE_DATA) return rowArray;
           for (var i = 0; i < data.RESPONSE["0"].RESPONSE_DATA.length; i++) {
              if (data.RESPONSE["0"].RESPONSE_DATA[i]) {
                  rowArray.push($.extend(data.RESPONSE["0"].RESPONSE_DATA[i], { code: '' }));
              }
           }
        }
        return rowArray;
    };
    /*重新组合行数据列*/
    reCreateDataSource = function (data, grid) {
        if (grid) {
            var rowArray = new Array();
            if(data.RESPONSE.length>0){
               if (!data.RESPONSE["0"].RESPONSE_DATA) return rowArray;
               for (var i = 0; i < data.RESPONSE["0"].RESPONSE_DATA.length; i++) {
                 if (data.RESPONSE["0"].RESPONSE_DATA[i]) {
                     rowArray.push($.extend(data.RESPONSE["0"].RESPONSE_DATA[i], { code: grid.code, name: grid.name }));
                 }
               }
            }
            return rowArray;
        }
    };
    
    /*发送请求*/
    iplantAjaxRequest = function (ajaxParam) {
        var reqData = ajaxParam.data;
        $.extend(reqData, { reqType: 'APP' });
        //请求路径字符串操作
        //var reqUrl = ajaxParam.url || '/WebMes/iPlant_app';
        var reqUrl = '/iTaurus/iPlant_app';
        var reqStr = '';
        if (reqData != null) {
            reqStr = '{\"REQ\":[{\"REQ_DATA\":' + JSON.stringify(reqData) + '}]}';
        }
        //将对象转换为json字符串
        var params = {
            url: reqUrl,
            type: 'POST',
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            async: String(ajaxParam.async) == 'false' ? false : true,
            data: { "reqStr": reqStr },
            beforeSend: ajaxParam.beforeSend || function () {
            },
            success: ajaxParam.successCallBack || function (data) {
            },
            error: ajaxParam.errorCallBack || function (e) {
            }
        }
        $.ajax(params);
    };
    reqCombogridData = function (url, reqData) {
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                var rowNum = 0
                if(data.RESPONSE.length>0){
                   if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
                      rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
                   }
                }
                var rowCollection = createSourceObj(data);
                var jsonData = {
                    total: rowNum,
                    rows: rowCollection
                }
                bindCombogrid(jsonData);
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    reqGroundData = function (url, reqData) {
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                var rowNum = 0
                if(data.RESPONSE.length>0){
                  if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
                     rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
                  }
                }
                var rowCollection = createSourceObj(data);
                var jsonData = {
                    total: rowNum,
                    rows: rowCollection
                }
                bindGroundgrid(jsonData);
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    initCombogrid = function (grid) {
        if (!grid) return
        $('#' + grid.name).combogrid({
            idtField: grid.idField,
            textField: grid.textField,
            mode: grid.mode,
            panelWidth: grid.panelWidth,
            columns: grid.columns
        });
    };
    gridToDate = function (value) {
        if (value) {
            var oDate = new Date();
            var nDate = new Date(value);
            var newDate = nDate.toLocaleDateString();
            return newDate;
        }
        else {
            return '';
        }
    };
    /*add by zhuss 2016/11/08    初始化多选列表框 */
    /*注册按钮事件*/
    registBtnEvent = function (grid, btnId) {
        /*注册添加按钮事件*/
        $('#' + btnId).click(function () {
            var options = $('#' + grid.focuseGridId).datagrid('getSelections');
            for (var i = 0; i < options.length; i++) {
                var addRowData = getReRowData(options[i]);
                $('#' + grid.targetGridId).datagrid('appendRow', addRowData);
                var index = $('#' + grid.focuseGridId).datagrid('getRowIndex', options[i]);
                $('#' + grid.focuseGridId).datagrid('clearChecked');
                $('#' + grid.focuseGridId).datagrid('deleteRow', index);
            };

        });
    };
    getReRowData = function (rowData) {
        var valueField = rowData.code;
        var textField = rowData.name;
        // 用来保存所有的属性名称和值
        var props = "{";
        // 开始遍历
        for (var p in rowData) {
            if (typeof (rowData[p]) == " function ") {
                rowData[p]();
            }
            else {
                if (p.toString() == valueField || p.toString() == textField || p.toString() == 'code' || p.toString() == 'name') {
                    props += p + " : '" + rowData[p] + "',";
                }
            }
        }
        props = props.substring(0, props.length - 1) + "}";
        var addRowData = eval('(' + props + ')');
        return addRowData;
    };
    bindComboData = function (grid, jsonData) {
        /*  grid对象
         *  {
         *      focuseGridId:  焦点列表ID
         *      targetGridId:  目标列表ID
         *      code:编码
         *      codeTitle:编码标题
         *      name:名称
         *      nameTitle:名称标题
         *   }
         *  
        */
        if (!grid) return;
        $("#" + grid.focuseGridId).datagrid({
            selectOnCheck: 'false',
            dataType: 'json',
            columns: [[
                   { field: "ck", checkbox: "true" },
                   { field: grid.code, title: grid.codeTitle, width: 103, hidden: 'true', align: 'center' },
                   { field: grid.name, title: grid.nameTitle, width: 170, align: 'center' }
            ]]
        });
        $("#" + grid.focuseGridId).datagrid("loadData", jsonData);

        /*注册左边列表双击事件*/
        $("#" + grid.focuseGridId).datagrid({
            onDblClickRow: function (rowIndex, rowData) {
                var addRowData = getReRowData(rowData);
                $("#" + grid.targetGridId).datagrid('appendRow', addRowData);
                $("#" + grid.focuseGridId).datagrid('clearChecked');
                $("#" + grid.focuseGridId).datagrid('deleteRow', rowIndex);

            }
        });
        /*注册右边列表双击事件*/
        $("#" + grid.targetGridId).datagrid({
            onDblClickRow: function (rowIndex, rowData) {
                var addRowData = getReRowData(rowData);
                $("#" + grid.focuseGridId).datagrid('appendRow', addRowData);
                $("#" + grid.targetGridId).datagrid('clearChecked');
                $("#" + grid.targetGridId).datagrid('deleteRow', rowIndex);
            }
        });
    };
    reqComboData = function (url, reqData, grid) {
        var ajaxParam = {
            url: url,
            data: reqData,
            successCallBack: function (data) {
                if (data) {
                    var rowNum = 0;
                    if(data.RESPONSE.length>0){
                       if (data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS) {
                          rowNum = parseInt(data.RESPONSE["0"].RESPONSE_HDR.DATA_ROWS);
                       }
                    }
                    var rowCollection = reCreateDataSource(data, grid);
                    var jsonData = {
                        total: rowNum,
                        rows: rowCollection,
                        IFS: reqData.IFS,
                        gridId: grid.focuseGridId
                    }
                    bindComboData(grid, jsonData);
                }
            }
        }
        iplantAjaxRequest(ajaxParam);
    };
    //滑屏判断
	slideScreen = function(){
//		var firstpointX;
//		var secondpointX;
//		var firstpointY;
//		var secondpointY;
//		$('.easyui-navpanel').on('touchstart',function(ev){
//			var touch = ev.originalEvent.changedTouches[0];
//			 firstpointY = touch.clientY ;
//			 firstpointX = touch.clientX ;
//			$('.easyui-navpanel').on('touchmove',function(ev){
//			 	var touch = ev.originalEvent.changedTouches[0];
//			 	secondpointX =touch.clientY;
//			 	secondpointY =touch.pageY;
//			 	$('.easyui-navpanel').on('touchend',function(ev){
//				 	if(firstpointY>secondpointY){
//							$('#hh').css('display','none');
//							$('.datagrid-view').css('height','320px');
//							$('.datagrid-view2 .datagrid-body').css('height','250px');
//							
//						}else if(firstpointY<secondpointY){
//							$('#hh').css('display','block');
//						}
//				})
//		
//			})
//		})
		//返回角度
function GetSlideAngle(dx, dy) {
    return Math.atan2(dy, dx) * 180 / Math.PI;
}
 
//根据起点和终点返回方向 1：向上，2：向下，3：向左，4：向右,0：未滑动
function GetSlideDirection(startX, startY, endX, endY) {
    var dy = startY - endY;
    var dx = endX - startX;
    var result = 0;
 
    //如果滑动距离太短
    if (Math.abs(dx) < 2 && Math.abs(dy) < 2) {
        return result;
    }
 
    var angle = GetSlideAngle(dx, dy);
    if (angle >= -45 && angle < 45) {
        result = 4;
    } else if (angle >= 45 && angle < 135) {
        result = 1;
    } else if (angle >= -135 && angle < -45) {
        result = 2;
    }
    else if ((angle >= 135 && angle <= 180) || (angle >= -180 && angle < -135)) {
        result = 3;
    }
 
    return result;
}
 
//滑动处理
var startX, startY;
document.addEventListener('touchstart', function (ev) {
    startX = ev.touches[0].pageX;
    startY = ev.touches[0].pageY;   
}, false);
document.addEventListener('touchend', function (ev) {
    var endX, endY;
    endX = ev.changedTouches[0].pageX;
    endY = ev.changedTouches[0].pageY;
    var direction = GetSlideDirection(startX, startY, endX, endY);
    switch (direction) {
        case 0:
//          alert("没滑动");
            break;
        case 1:
            $('#hh').css('display','none');
            $('.datagrid-view').css('height','320px');
			$('.datagrid-view2 .datagrid-body').css('height','250px');
            break;
        case 2:
            $('#hh').css('display','block');
            break;
        case 3:
//          alert("向左");
            break;
        case 4:
//          alert("向右");
            break;
        default:            
    }   
}, false);
		}
    /*****************************************************************************end add by zhuss 初始化多选列表框 **************************************************************************/
    /*****************************************************************************add by zhuss 功能权限控制 **************************************************************************/
    btnConfig = {
        /*btnAddId:pageBtnConfig.btnAddId ||'btnAdd',
		btnDelId:pageBtnConfig.btnDelId || 'btnDelete',
		btnUpdateId:pageBtnConfig.btnUpdateId || 'btnUpdate',
		btnSearchId:pageBtnConfig.btnSearchId || 'btnSearch'*/
        btnAddId: 'btnAdd',                //添加
        btnDelId: 'btnDelete',            //删除
        btnUpdateId: 'btnUpdate',        //更新
        btnSearchId: 'btnSearch',       //搜索
        btnExportId:'btnExprt',         //导出 
        btnCheckId:'btnCheck'           //审核
    };
    getQueryString = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };
    initBtnAuthority = function () {
        var userName = getQueryString("userName");
        var cdId = getQueryString("cdId");
        if (userName != '' && cdId != '') {
            var ajaxParam = {
                url: '/iPlant_app',
                dataType: 'JSON',
                data: {
                    USE_CD: userName,//用户组id
                    MN_CD: cdId,
                    IFS: 'D000057'
                },
                successCallBack: function (data) {
                	 //for (var p in btnConfig) {
                        // $('#'+btnConfig[p]).hide();
                    //}
                	if(data.RESPONSE.length>0){
                	  var btnAuthorData=data.RESPONSE["0"].RESPONSE_DATA;
                	  $.each(btnAuthorData, function (index, item) {
                        if (item.FUN_CD == "F002") {           //新增权限
                            $('#' + btnConfig.btnAddId).show();
                        }
                        else if (item.FUN_CD == "F003") {      //修改权限
                            $('#' + btnConfig.btnUpdateId).show();
                        }
                        else if (item.FUN_CD == "F004") {     //删除权限
                            $('#' + btnConfig.btnDelId).show();
                        }
                        else if (item.FUN_CD == "F001") {    //查询
                            $('#' + btnConfig.btnSearchId).show();
                        }
                      });
                	}
                }
            }
            iplantAjaxRequest(ajaxParam);
        }

    };
    /*****************************************************************************end add by zhuss 功能权限 **************************************************************************/
})();
initBtnAuthority();
/**
 * 
 */