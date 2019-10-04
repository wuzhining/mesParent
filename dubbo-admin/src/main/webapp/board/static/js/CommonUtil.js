	/**
 * 文件处理js
 */
(function(){
	
	ERP_URL = "HTTP://192.168.1.211:8088/skenta/iPlant_ajax",
	MES_URL = "HTTP://139.198.127.11:10114/iTaurus/iPlant_app",
	ORA_URL = "HTTP://192.168.1.211:8080/okenta/iPlant_ajax",
	
	getPicPath = function (obj, fileQuery, transImg) {
 	   var imgSrc = '', imgArr = [], strSrc = '',file;
 	   if (window.navigator.userAgent.indexOf("MSIE") >= 1) { // IE浏览器判断
 		   if (obj.select) {
 			   obj.select();
 			   var path = document.selection.createRange().text;
 			   console.log(path);
 			   obj.removeAttribute("src");
 			   imgSrc = fileQuery.value;
 			   imgArr = imgSrc.split('.');
 			   strSrc = imgArr[imgArr.length - 1].toLowerCase();
 			   if (strSrc.localeCompare('jpg') === 0 || strSrc.localeCompare('jpeg') === 0 || strSrc.localeCompare('gif') === 0 || strSrc.localeCompare('png') === 0 || strSrc.localeCompare('pdf') === 0 || strSrc.localeCompare('xlsx') === 0 ) {
					obj.setAttribute("src", transImg);
					obj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='" + path + "', sizingMethod='scale');"; // IE通过滤镜的方式实现图片显示
				} else {
					$.messager.alert('提示', '请选择扩展名为jpg、jpeg、gif、png、pdf、xlsx的文件');
					return false;
				}
			} else {
				imgSrc = fileQuery.value;
				imgArr = imgSrc.split('.');
				strSrc = imgArr[imgArr.length - 1].toLowerCase();
				if (strSrc.localeCompare('jpg') === 0 || strSrc.localeCompare('jpeg') === 0 || strSrc.localeCompare('gif') === 0 || strSrc.localeCompare('png') === 0 || strSrc.localeCompare('pdf') === 0 || strSrc.localeCompare('xlsx') === 0) {
					obj.src = fileQuery.value;
				} else {
						$.messager.alert('提示', '请选择扩展名为jpg、jpeg、gif、png、pdf、xlsx的文件');
						return false;
					}
				}
 	   	} else {
 	   		if(fileQuery.files.length>0){
 	   			file = fileQuery.files[0];
    	   		var reader = new FileReader();
    	   		reader.onload = function(e) {
    	   		imgSrc = fileQuery.value;
				imgArr = imgSrc.split('.');
				strSrc = imgArr[imgArr.length - 1].toLowerCase();
				if (strSrc.localeCompare('jpg') === 0 || strSrc.localeCompare('jpeg') === 0 || strSrc.localeCompare('gif') === 0 || strSrc.localeCompare('png') === 0 || strSrc.localeCompare('pdf') === 0 || strSrc.localeCompare('xlsx') === 0) {
					obj.setAttribute("src", e.target.result);
					
				} else {
						$.messager.alert('提示', '请选择扩展名为jpg、jpeg、gif、png、pdf、xlsx的文件');
						return false;
					}
				}
				reader.readAsDataURL(file);
 	   		}
 	   }
    },
	filterUrlPath = function(url){
		var webroot=document.location.href, urlPath = "",arr,num;;
	    webroot=webroot.substring(webroot.indexOf('//')+2,webroot.length);
	    webroot=webroot.substring(webroot.indexOf('/')+1,webroot.length);
	    webroot=webroot.substring(0,webroot.indexOf('/'));
		if(url!=undefined && url!='' && url!=null){
			if(url.indexOf('\\')>0){
				arr = url.split('\\'),num = arr.length;
				for(var i=0;i<arr.length;i++){
					if(arr[i]=="upload"){
						urlPath = urlPath+"\\"+arr[i];
						num = i;
					}
					if(i>num)
						urlPath = urlPath+"\\"+arr[i];
				}
			}
		}
		return "/"+webroot+urlPath;
	},
	getRootPath_web = function () {
        //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
        var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPaht = curWwwPath.substring(0, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return (localhostPaht + projectName);
    },
	
	//***************************************************************************************** 通用函数方法  ****************************************************************************
	
	/** 
	 * 获取id 
	 * @param value（不同的系统用不同的字母，如系统模块SYS，mes模块MES，wms模块WMS，tpm模块TPM） 
	 * 
	 */ 
	autoCreateCode=function(value) {
		var date = new Date();
		var year = date.getFullYear().toString(),month = (date.getMonth() + 1),day = date.getDate().toString(),hour = date.getHours().toString(),minutes = date.getMinutes().toString(),seconds = date.getSeconds().toString();
        if (month < 10) month = "0" + month;
        if (day < 10) day = "0" + day;
        if (hour < 10) hour = "0" + hour;
        if (minutes < 10) minutes = "0" + minutes;
        if (seconds < 10) seconds = "0" + seconds;
        return value.concat(year, month, day, hour, minutes, seconds, Math.floor(Math.random()*10));
    },
	
	/** 
	 * 时间格式化（'yyyy-MM-dd 或者 yyyy-MM-dd hh:mm:ss.S'） 
	 * @param value 
	 * @fmt yyyy-mm-dd hh:MM:ss(根据参数格式可任意返回结果)
	 */ 
	formatterDate=function(value,fmt) {
		if(!checkNotEmpty(value)) return "";
        var date = new Date();
        var o = {
                "M+": date.getMonth() + 1, //月份 
                "d+": date.getDate(), //日 
                "h+": date.getHours(), //小时 
                "m+": date.getMinutes(), //分 
                "s+": date.getSeconds(), //秒 
                "q+": Math.floor((date.getMonth() + 3) / 3), //季度 
                "S": date.getMilliseconds() //毫秒 
            };
        if(checkNotEmpty(fmt)){
        	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }else{
        	var year = date.getFullYear().toString(),month = (date.getMonth() + 1),day = date.getDate().toString(),hour = date.getHours().toString(),minutes = date.getMinutes().toString(),seconds = date.getSeconds().toString();
            if (month < 10) month = "0" + month;
            if (day < 10) day = "0" + day;
            if (hour < 10) hour = "0" + hour;
            if (minutes < 10) minutes = "0" + minutes;
            if (seconds < 10) seconds = "0" + seconds;
//            return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
            return year + "-" + month + "-" + day;
        }
    },
    getServiceTime=function (option){
        var xhr = null,datetime='',time = null,curDate = null;
        $.ajax({type:"OPTIONS",url:"/",async:false,complete:function(x){time=x.getResponseHeader("Date")}});
    	curDate = new Date(time);
    	var year = curDate.getFullYear().toString(),month = (curDate.getMonth() + 1),day = curDate.getDate().toString(),hour = curDate.getHours().toString(),minutes = curDate.getMinutes().toString(),seconds = curDate.getSeconds().toString();
    	if (month < 10) month = "0" + month;
    	if (day < 10) day = "0" + day;
    	if (hour < 10) hour = "0" + hour;
    	if (minutes < 10) minutes = "0" + minutes;
    	if (seconds < 10) seconds = "0" + seconds;
    	datetime = year+"年"+month+"月"+day+"日";
        
        return datetime;
      },
      getBCtime = function(){
    	//获取当前日期
			var date_time = new Date();
			//年
			var year = date_time.getFullYear();
			//判断小于10，前面补0
			if (year < 10) {
				year = "0" + year;
			}
	
			//月
			var month = date_time.getMonth() + 1;
			//判断小于10，前面补0
			if (month < 10) {
				month = "0" + month;
			}
	
			//日
			var day = date_time.getDate();
			//判断小于10，前面补0
			if (day < 10) {
				day = "0" + day;
			}
	
			//时
			var hours = date_time.getHours();
			//判断小于10，前面补0
			if (hours < 10) {
				hours = "0" + hours;
			}
	
			//分
			var minutes = date_time.getMinutes();
			//判断小于10，前面补0
			if (minutes < 10) {
				minutes = "0" + minutes;
			}
	
			//秒
			var seconds = date_time.getSeconds();
			//判断小于10，前面补0
			if (seconds < 10) {
				seconds = "0" + seconds;
			}
			var date_str ="";
			if(parseInt(hours)>=8 && parseInt(hours)<20){
				date_str = year + "-" + month + "-" + day + " " + "08" + ":" + "00" ;
			}else{
				if(parseInt(hours)<8){
					var dt = new Date(new Date()-24*60*60*1000);
					var year1 = dt.getFullYear();
					//判断小于10，前面补0
					if (year1 < 10) {
						year1 = "0" + year;
					}
			
					//月
					var month1 = dt.getMonth() + 1;
					//判断小于10，前面补0
					if (month1 < 10) {
						month1 = "0" + month1;
					}
			
					//日
					var day1 = dt.getDate();
					//判断小于10，前面补0
					if (day1 < 10) {
						day1 = "0" + day1;
					}
					//拼接年月日时分秒
					date_str = year1 + "-" + month1 + "-" + day1 + " " + "20" + ":" + "00" ;
				}else{
					//拼接年月日时分秒
					date_str = year + "-" + month + "-" + day + " " + "20" + ":" + "00" ;
				}
			}
			return date_str;
      },
      /*0.5-1倍取随机数*/
      getRandomNum = function(value){
		var min = value *0.5,max = value * 1.5,
			inc = Math.round(Math.random() * (max - min)),
			newVal = value + inc;
			return newVal;
	  },
	  /*0.5-1倍取随机数      END*/
       getZHsj= function(min){
		  if(min == 'null'){
			  return "0分钟";
		  }else{
			  var day = "";
	    	  var hour ="";
	    	  var m = "";
	    	  if(parseInt(min)>60*24){
	    		  day = parseInt(parseInt(min)/(24*60));
	    		  hour = parseInt((parseInt(parseInt(min)%(24*60)))/60);
	    		  m = parseInt((parseInt(parseInt(min)%(24*60)))%60);
	    		  return day +"天"+ hour +"小时"+m +"分钟";
	    	  }else if(parseInt(min)>60){
	    		  hour = parseInt(parseInt(min)/60);
	    		  m = parseInt(parseInt(min)%60);
	    		  return  hour +"小时"+m +"分钟";
	    	  }else{
	    		  return min+"分钟";
	    	  }
		  }
      }
	/** 
	 * 判断非空 
	 * @param value 
	 */ 
	checkNotEmpty=function(value){
		if(value!=undefined && value!='' && value!=null){
			return true;
		}else{
			return false;
		}
	},
	/** 
	 * 格式化数字，小数点后是0不表示 
	 * @param value 
	 * @param fixed 小数位数 
	 */  
	formatNumber = function(value, fixed) {
		if(value == null){
			return '';
		}
	    var number = Number(value);  
	    if (isNaN(number)) {  
	        return '';  
	    } else { 
	        if(fixed == 0){
	        	return number.toFixed(0); 
	        }else if (fixed == 2) {  
	            return number.toFixed(2) * 100 / 100;  
	        } else if (fixed == 6) {  
	            return number.toFixed(6) * 1000000 / 1000000;  
	        }  
	    }  
	},
	
	//*********************************************************************************  editorDataGrid 方法  ************************************************************************************
	
	/**
	 * FUN 批量新增和修改的保存
	 * @param tabName dataGrid的名字
	 * @param insertIfs 新增的ifs
	 * @param updateIfs 更新的ifs
	 * @param messageId 提示信息的对象的id
	 */
	saveDataGrid=function(tabName,insertIfs,updateIfs,messageId){
    	 var edDataGrid = $('#'+tabName);
         if (endEditing(edDataGrid)){
        	//判断后变更数据
        	if (edDataGrid.datagrid('getChanges').length) {
                var inserted = edDataGrid.datagrid('getChanges', "inserted");  
                var updated = edDataGrid.datagrid('getChanges', "updated");
                var deleted = edDataGrid.datagrid('getChanges', "deleted");
                /**装载数据*/
                var arrInsert = new Array(),arrUpdate = new Array();
                if(inserted.length>0){
                	for(var m=0;m<inserted.length;m++){
                		arrInsert.push(inserted[m]);
                	}
                	//批量先增
                    var ajaxInsert = {
                        url: '/iPlant_ajax',
                        dataType: 'JSON',
                        data: {
                            list: arrInsert,
                            IFS: insertIfs
                        },
                        successCallBack: function (data) {
                        	edDataGrid.datagrid('acceptChanges');
                        	initGridData();
                        	if(tabName=='WorkOrderMaterialInformationQuery_tab'){
                        		initGridData();
                        	}
                        	$('#'+messageId).html('<font color=red>保存成功！</font>');
                            return;
                        },
                        errorCallBack: function (data) {
                        	$('#'+messageId).html('<font color=red>保存失败！</font>');
                            return;
                        }
                    };
                    iplantAjaxRequest(ajaxInsert);
                }
                if(updated.length>0){
                	for(var m=0;m<updated.length;m++){
                		if(updated[m].edited){
                			arrUpdate.push(updated[m]);
                		}
                	}
                	//批量修改
                    var ajaxUpdate = {
                        url: '/iPlant_ajax',
                        dataType: 'JSON',
                        data: {
                            list: arrUpdate,
                            IFS: updateIfs
                        },
                        successCallBack: function (data) {
                        	initGridData();
                        	edDataGrid.datagrid('acceptChanges');
                        	$('#'+messageId).html('<font color=red>保存成功！</font>');
                            return;
                        },
                        errorCallBack: function (data) {
                        	$('#'+messageId).html('<font color=red>保存失败！</font>');
                            return;
                        }
                    };
                    iplantAjaxRequest(ajaxUpdate);
                }
            }else{
            	$('#'+messageId).html('<font color=red>没有进行变更！</font>');
            }
		}else{
			$('#'+messageId).html('<font color=red>请输入必填项！</font>');
		}
	},
	/**
	 * FUN 批量新增和修改的保存
	 * @param tabName dataGrid的名字
	 * @param insertIfs 新增的ifs
	 * @param updateIfs 更新的ifs
	 * @param messageId 提示信息的对象的id
	 */
	saveDataGrid=function(tabName,insertIfs,updateIfs,messageId){
		var edDataGrid = $('#'+tabName);
		if (endEditing(edDataGrid)){
			//判断后变更数据
			if (edDataGrid.datagrid('getChanges').length) {
				var inserted = edDataGrid.datagrid('getChanges', "inserted");  
				var updated = edDataGrid.datagrid('getChanges', "updated");
				var deleted = edDataGrid.datagrid('getChanges', "deleted");
				/**装载数据*/
				var arrInsert = new Array(),arrUpdate = new Array();
				if(inserted.length>0){
					for(var m=0;m<inserted.length;m++){
						arrInsert.push(inserted[m]);
					}
					//批量先增
					var ajaxInsert = {
							url: '/iPlant_ajax',
							dataType: 'JSON',
							data: {
								list: arrInsert,
								IFS: insertIfs
							},
							successCallBack: function (data) {
								edDataGrid.datagrid('acceptChanges');
								initGridData();
								if(tabName=='WorkOrderMaterialInformationQuery_tab'){
									initGridData();
								}
								$('#'+messageId).html('<font color=red>保存成功！</font>');
								return;
							},
							errorCallBack: function (data) {
								$('#'+messageId).html('<font color=red>保存失败！</font>');
								return;
							}
					};
					iplantAjaxRequest(ajaxInsert);
				}
				if(updated.length>0){
					for(var m=0;m<updated.length;m++){
						if(updated[m].edited){
							arrUpdate.push(updated[m]);
						}
					}
					//批量修改
					var ajaxUpdate = {
							url: '/iPlant_ajax',
							dataType: 'JSON',
							data: {
								list: arrUpdate,
								IFS: updateIfs
							},
							successCallBack: function (data) {
								initGridData();
								edDataGrid.datagrid('acceptChanges');
								$('#'+messageId).html('<font color=red>保存成功！</font>');
								return;
							},
							errorCallBack: function (data) {
								$('#'+messageId).html('<font color=red>保存失败！</font>');
								return;
							}
					};
					iplantAjaxRequest(ajaxUpdate);
				}
			}else{
				$('#'+messageId).html('<font color=red>没有进行变更！</font>');
			}
		}else{
			$('#'+messageId).html('<font color=red>请输入必填项！</font>');
		}
	},
	
	/**
	 * 	获取IP方法
	 */
	getIP = function(){
		var myip = '';
		var params = {
	            url: '/iTaurus/iPlant_IP',
	            type: 'POST',
	            contentType: "application/x-www-form-urlencoded; charset=utf-8",
	            async: false,
	            data: {  },
	            success: function (data) {
	            	myip = data.IP
	            },
	            error: function (e) {
	            }
	        }
		$.ajax(params);
		return myip;
	},
	
	/**
	 * 表格中相同列合并
	 */
	$.extend($.fn.datagrid.methods, {
	    autoMergeCells: function(jq, fields) {
	        return jq.each(function() {
	            var target = $(this);
	            if (!fields) {
	                fields = target.datagrid("getColumnFields");
	            }
	            var rows = target.datagrid("getRows");
	            var i = 0,
	            j = 0,
	            temp = {};
	            for (i; i < rows.length; i++) {
	                var row = rows[i];
	                j = 0;
	                for (j; j < fields.length; j++) {
	                    var field = fields[j];
	                    var tf = temp[field];
	                    if (!tf) {
	                        tf = temp[field] = {};
	                        tf[row[field]] = [i];
	                    } else {
	                        var tfv = tf[row[field]];
	                        if (tfv) {
	                            tfv.push(i);
	                        } else {
	                            tfv = tf[row[field]] = [i];
	                        }
	                    }
	                }
	            }
	            
	            $.each(temp,function(field, colunm) {
	                $.each(colunm, function() {
	                    var group = this;
	                    if (group.length > 1) {
	                        var before, after, megerIndex = group[0];
	                        for (var i = 0; i < group.length; i++) {
	                            before = group[i];
	                            after = group[i + 1];
	                            if (after && (after - before) == 1) {
	                                continue;
	                            }
	                            var rowspan = before - megerIndex + 1;
	                            if (rowspan > 1) {
	                                target.datagrid('mergeCells', {
	                                    index: megerIndex,
	                                    field: field,
	                                    rowspan: rowspan
	                                });
	                            }
	                            if (after && (after - before) != 1) {
	                                megerIndex = after;
	                            }
	                        }
	                    }
	                });
	            });
	        });
	    },
	    autoMergeCellAndCells : function (jq, fields) {
	        return jq.each(function () {
	            var target = $(this);
	            if (!fields) {
	                fields = target.datagrid("getColumnFields");
	            }
	            var cfield = fields[0];
	            if (!cfield) {
	                return;
	            }
	            var rows = target.datagrid("getRows");
	            var i = 0,
	            j = 0,
	            temp = {};
	            for (i; i < rows.length; i++) {
	                var row = rows[i];
	                j = 0;
	                var tf = temp[cfield];
	                if (!tf) {
	                    tf = temp[cfield] = {};
	                    tf[row[cfield]] = [i];
	                
	                } else {
	                    var tfv = tf[row[cfield]];
	                    if (tfv) {
	                        tfv.push(i);
	                    } else {
	                        tfv = tf[row[cfield]] = [i];
	                        
	                    }
	                }
	            }
	            
	            $.each(temp, function (field, colunm) {
	                $.each(colunm, function () {
	                    var group = this;
	                    
	                    if (group.length > 1) {
	                        var before,
	                        after,
	                        megerIndex = group[0];
	                        for (var i = 0; i < group.length; i++) {
	                            before = group[i];
	                            after = group[i + 1];
	                            if (after && (after - before) == 1) {
	                                continue;
	                            }
	                            var rowspan = before - megerIndex + 1;
	                            if (rowspan > 1) {
	                                for(var j=0;j<fields.length;j++){
	                                    target.datagrid('mergeCells', {
	                                        index : megerIndex,
	                                        field : fields[j],
	                                        rowspan : rowspan
	                                   });
	                                }
	                            }
	                            if (after && (after - before) != 1) {
	                                megerIndex = after;
	                            }
	                        }
	                    }
	                });
	            });
	        });
	    }
	});
	/**
	 *模板统一访问 
	 */
	universalAccess = function(url, reqData){
		var ajaxParamMf = {
			url: url,
            data: reqData,
			successCallBack:function(data){
				
			}
		}
		iplantAjaxRequest(ajaxParamMf);
	},
	/**
	 * FUN 插入一个新的空白行
	 * @param tabName 要插入的dataGrid对象的id
	 * @param data json对象，如果没有初始化的数据可以直接放空{}
	 * @param paramIndex 新插入行的索引
	 * */
	insertDataGrid=function (tabName,data,paramIndex){
		var editorDataGrid = $('#'+tabName), row = editorDataGrid.datagrid('getSelected');
		if (row){
			var index = editorDataGrid.datagrid('getRowIndex', row);
		} else {
			index = 0;
			editIndex = 0;
		}
		if(paramIndex != '' && paramIndex !=undefined){
			index = paramIndex;
		}; 	
		editorDataGrid.datagrid('insertRow', {
			index: index,
			row:data
		});
		/**新增一个字段判断是否为新增*/ 
		var rowEdit = editorDataGrid.datagrid('getRows')[index]; 
		rowEdit.editType='add';
		editorDataGrid.datagrid('selectRow',index);
		editorDataGrid.datagrid('beginEdit',index);
		if (editIndex != index){
			if (endEditing(editorDataGrid)){
				editorDataGrid.datagrid('selectRow', index).datagrid('beginEdit', index);
				editIndex = index;
			} else {
				editorDataGrid.datagrid('selectRow', editIndex);
			}
		}else{
			endEditing(editorDataGrid);
		}
		return index;
	},
	/**
	 *  FUN dataGrid删除行
	 *  @param tabName  要删除的dataGrid对象的id
	 *  @param itemName 要删除数据的主键名称(目前不支持双主键)
	 *  @param delIfs   删除方法的ifs编号
	 *  @param showmessage 提示信息的id
	 * */
	deleteDataGridXK=function (tabName,itemName,delIfs,messageId){
		/**删除行有2中情况，一种新增的还没有保存，一种是原来就有的直接删除*/
		var edDataGrid = $('#'+tabName); 
		var indexs = datagridEditorRows(edDataGrid),del = [],row,itemValue,delData;
		if(indexs.length>0){
			$.messager.confirm("确认框", "您要删除的数据包含有工序BOM清单，如果删除会连工序BON清单一起删除，还要继续删除吗?",function(a) {
				if(a){
					for(var j=0;j<indexs.length;j++){
						row = edDataGrid.datagrid('getRows')[indexs[j]];
						if(row !=''){
							$.each(row,function(name,value) {
								if(itemName==name){
									itemValue = value;
								}
							})
							delData = {IFS: delIfs},delData[itemName]=itemValue;
						}
						if(checkNotEmpty(itemValue)){
							var e = {
									url: "/iPlant_ajax",
									dataType: "JSON",
									data: delData,
									successCallBack: function(data) {
										editIndex=undefined;
										if (data.RESPONSE["0"].RESPONSE_HDR.MSG_CODE == '0') {
											$('#'+messageId).html('<font color=red>删除成功！</font>');
											initGridData();
										} else {
											$('#'+messageId).html('<font color=red>删除失败,该数据正在使用！！</font>');
											initGridData();
										}
//		                        	dataGrid.datagrid('deleteRow', indexs[j]);
									},
									errorCallBack: function(){
										
									}
							};
							edDataGrid.datagrid('deleteRow', indexs[j]);
							iplantAjaxRequest(e);
						}else{
							/**判断多个空行只删除最顶上的*/
							del.push(indexs[j]);
						}
					}
					if(del.length>0){
						edDataGrid.datagrid('deleteRow', del[0]);
						$('#'+messageId).html('<font color=red>删除成功！</font>');
					}
					if(del.length==1){
						editIndex = undefined;
					}
				}
			})
		}else{
			$('#'+messageId).html('<font color=red>请选中要删除的数据！</font>');
		}
	},
	/**
	 *  FUN dataGrid删除行
	 *  @param tabName  要删除的dataGrid对象的id
	 *  @param itemName 要删除数据的主键名称(目前不支持双主键)
	 *  @param delIfs   删除方法的ifs编号
	 *  @param showmessage 提示信息的id
	 * */
	deleteDataGrid=function (tabName,itemName,delIfs,messageId){
		/**删除行有2中情况，一种新增的还没有保存，一种是原来就有的直接删除*/
    	var edDataGrid = $('#'+tabName); 
		var indexs = datagridEditorRows(edDataGrid),del = [],row,itemValue,delData;
		if(indexs.length>0){
			$.messager.confirm("确认框", "您确定要删除您所选择的数据?",function(a) {
				if(a){
					for(var j=0;j<indexs.length;j++){
						row = edDataGrid.datagrid('getRows')[indexs[j]];
						if(row !=''){
							$.each(row,function(name,value) {
								if(itemName==name){
									itemValue = value;
								}
							})
							delData = {IFS: delIfs},delData[itemName]=itemValue;
						}
						if(checkNotEmpty(itemValue)){
							var e = {
		                        url: "/iPlant_ajax",
		                        dataType: "JSON",
		                        data: delData,
		                        successCallBack: function(data) {
		                        	editIndex=undefined;
										if (data.RESPONSE["0"].RESPONSE_HDR.MSG_CODE == '0') {
											$('#'+messageId).html('<font color=red>删除成功！</font>');
												initGridData();
										} else {
											$('#'+messageId).html('<font color=red>删除失败,该数据正在使用！！</font>');
												initGridData();
									}
//		                        	dataGrid.datagrid('deleteRow', indexs[j]);
		                        },
		                        errorCallBack: function(){
		                        	
		                        }
		                    };
							edDataGrid.datagrid('deleteRow', indexs[j]);
		                    iplantAjaxRequest(e);
						}else{
							/**判断多个空行只删除最顶上的*/
							del.push(indexs[j]);
						}
					}
					if(del.length>0){
						edDataGrid.datagrid('deleteRow', del[0]);
						$('#'+messageId).html('<font color=red>删除成功！</font>');
					}
					if(del.length==1){
						editIndex = undefined;
					}
				}
            })
		}else{
			$('#'+messageId).html('<font color=red>请选中要删除的数据！</font>');
		}
	},
	/**
	 *  FUN dataGrid删除行
	 *  @param tabName  要删除的dataGrid对象的id
	 *  @param moreName 要删除数据的字段名，数组(多字段)
	 *  @param delIfs   删除方法的ifs编号
	 *  @param showmessage 提示信息的id
	 * */
	deleteDataGridMore=function (tabName,moreName,delIfs,messageId){
		/**删除行有2中情况，一种新增的还没有保存，一种是原来就有的直接删除*/
    	var edDataGrid = $('#'+tabName); 
		var indexs = datagridEditorRows(edDataGrid),del = [],row,itemValue=[],delData=[];
		if(indexs.length>0){
			$.messager.confirm("确认框", "您确定要删除您所选择的数据?",function(a) {
				if(a){
					for(var j=0;j<indexs.length;j++){
						row = edDataGrid.datagrid('getRows')[indexs[j]];
						$.each(row,function(name,value) {
							if(moreName.length>0){
								$.each(moreName,function(i,item){
									if(item==name){
										itemValue[i]=value;
									}
								})
							}
						});
						delData = {IFS: delIfs};
						if(row){
							for(var name in row){
								if(moreName.length>0){
									for(var m=0;m<moreName.length;m++){
										if(moreName[m]==name){
											itemValue.push({'name':moreName[m],'value':row[name]});
											delData[moreName[m]]=row[name];
										}
									}
								}
							}
						}
						if(delData){
							var e = {
		                        url: "/iPlant_ajax",
		                        dataType: "JSON",
		                        data: delData,
		                        successCallBack: function() {
		                        	editIndex=undefined;
		                        	dataGrid.datagrid('deleteRow', indexs[j]);
		                        }
		                    };
							edDataGrid.datagrid('deleteRow', indexs[j]);
		                    iplantAjaxRequest(e);
						}else{
							/**判断多个空行只删除最顶上的*/
							del.push(indexs[j]);
						}
					}
					if(del.length>0){
						edDataGrid.datagrid('deleteRow', del[0]);
					}
					if(del.length==1){
						editIndex = undefined;
					}
					$('#'+messageId).html('<font color=red>删除成功！</font>');
				}
            })
		}else{
			$('#'+messageId).html('<font color=red>请选中要删除的数据！</font>');
		}
	},
	/**
	 *  FUN dataGrid删除行
	 *  @param tabName  要删除的dataGrid对象的id
	 *  @param moreName 要删除数据的字段名，数组(多字段)
	 *  @param delIfs   删除方法的ifs编号
	 *  @param showmessage 提示信息的id
	 * */
	deleteDataGridMore2=function (tabName,moreName,delIfs,messageId){
		/**删除行有2中情况，一种新增的还没有保存，一种是原来就有的直接删除*/
		var edDataGrid = $('#'+tabName); 
		var indexs = datagridEditorRows(edDataGrid),del = [],row,itemValue=[],delData=[];
		if(indexs.length>0){
			$.messager.confirm("确认框", "您确定要删除您所选择的数据?",function(a) {
				if(a){
					for(var j=indexs.length-1;j<indexs.length;j--){
						row = edDataGrid.datagrid('getRows')[indexs[j]];
						$.each(row,function(name,value) {
							if(moreName.length>0){
								$.each(moreName,function(i,item){
									if(item==name){
										itemValue[i]=value;
									}
								})
							}
						});
						delData = {IFS: delIfs};
						if(row){
							for(var name in row){
								if(moreName.length>0){
									for(var m=0;m<moreName.length;m++){
										if(moreName[m]==name){
											itemValue.push({'name':moreName[m],'value':row[name]});
											delData[moreName[m]]=row[name];
										}
									}
								}
							}
						}
						if(delData){
							var e = {
									url: "/iPlant_ajax",
									dataType: "JSON",
									data: delData,
									successCallBack: function() {
										editIndex=undefined;
										dataGrid.datagrid('deleteRow', indexs[j]);
									}
							};
							edDataGrid.datagrid('deleteRow', indexs[j]);
							iplantAjaxRequest(e);
						}else{
							/**判断多个空行只删除最顶上的*/
							del.push(indexs[j]);
						}
					}
					if(del.length>0){
						edDataGrid.datagrid('deleteRow', del[0]);
					}
					if(del.length==1){
						editIndex = undefined;
					}
					$('#'+messageId).html('<font color=red>删除成功！</font>');
				}
			})
		}else{
			$('#'+messageId).html('<font color=red>请选中要删除的数据！</font>');
		}
	},
	//临时放到共通方法里
	/** FUN 是否增加grid行
	 * @param grid datagrid对象
	 * @param index 行序号
	 * */
	addDatagridEditor=function(grid,index){
		if (endEditing(grid)){
			grid.datagrid('selectRow', index).datagrid('beginEdit', index);
			editIndex = index;
	   } else {
			grid.datagrid('selectRow', editIndex);
	   }
	},
	/*TreeGrid*/
	addTreeGridEditor=function(grid,index){
		if (endTreeGridEditing(grid)){
			grid.treegrid('select', index).treegrid('beginEdit', index);
			editIndex = index;
	   } else {
			grid.treegrid('select', editIndex);
	   }
	},
	/**验证*/
	validateRow=function(grid,index){
		grid.datagrid('endEdit', index);//结束编辑模式
		var indexs = datagridEditorRows();
		if(indexs.length==0){//如果不存在编辑行就将全局序号清空
			editIndex = undefined;
		}
		return true;
	},
	/*TreeGrid*/
	valiTreeDateRow=function(grid,index){
		grid.treegrid('endEdit', index);//结束编辑模式
		var indexs = treegridEditorRows();
		if(indexs.length==0){//如果不存在编辑行就将全局序号清空
			editIndex = undefined;
		}
		return true;
	},
	
	/**获取到当前grid的编辑行*/
	datagridEditorRows=function(){
		var indexs = [];
		$('.datagrid-row-editing').each(function(i, row) {
            var index = row.sectionRowIndex;
            if (indexs.indexOf(index) == -1) {
                indexs.push(index);
            }
        });
		return indexs;
	},
	/*TreeGrid*/
	treegridEditorRows=function(){
		var indexs = [];
		$('.datagrid-row-editing').each(function(i, row) {
			var index = $('.datagrid-row-editing').eq(i).attr('node-id');
//            var index = row.sT_C_CD;
            if (indexs.indexOf(index) == -1) {
                indexs.push(index);
            }
        });
		return indexs;
	},
	/**结束行编辑模式*/
	endEditing = function(grid){
		var indexs = datagridEditorRows();
		console.log(indexs);
		for(var j=0;j<indexs.length;j++){
			if (grid.datagrid('validateRow', indexs[j])){
				validateRow(grid,indexs[j]);
			}
		}
		if (editIndex == undefined){return true}
		if (grid.datagrid('validateRow', editIndex)){
			validateRow(grid,editIndex);
		} else {
			return false;
		}
	},

	/*TreeGrid*/
	endTreeGridEditing = function(grid){
		var indexs = treegridEditorRows();
//		grid.treegrid('endEdit', index);
		
//		var indexs = grid.treegrid('getSelections').treegrid('');
//		console.log(indexs);
		for(var j=0;j<indexs.length;j++){
			if (grid.treegrid('validateRow', indexs[j])){
				valiTreeDateRow(grid,indexs[j]);
			}
		}
		if (editIndex == undefined){return true}
		else if (grid.treegrid('validateRow', editIndex)){
			valiTreeDateRow(grid,editIndex);
		} else {
			return true;
		}
		
	},

	/**结束行编辑模式*/
	endEditingAll = function(grid){
		var indexs = datagridEditorRows();
		for(var j=0;j<indexs.length;j++){
			if (grid.datagrid('validateRow', indexs[j])){
				grid.datagrid('endEdit', indexs[j]);
			}
		}
		editIndex = undefined;
	},

	/**获取行序号*/
	getRowIndex=function (target){
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	},

	/*TreeGrid*/
	getRowIndex=function (target){
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	},


	//************************************************************************************ 验证方法   *********************************************************************************
	

	//增加文本框验证
	$.extend($.fn.textbox.defaults.rules, {
	    specialCharacter: {
	        validator: function(value, param){
	        	var pattern =/[`~!\%\*\_\+<>\?:\"\{\},\.\\\/;'\[\]\!\%\@\#\$\￥\^\&\……\（\）\、\(\)\"\'\“\”\:\,\.\，\。\【\】\《\》\-\=\——\！/‘/；]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		},
		specialChinese: {
		        validator: function(value, param){
		        	var pattern =/^([\u0391-\uFFE5])$/,rs = "";
//		            if(!pattern.test(value)){
//		            	for (var i = 0; i < value.length; i++) { 
//		            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
//		            	} 
//		            	this.value=rs;
//		            }
		            return pattern.test(value);
		        },  
		        message: '请输入中文字符'
		},
		  specialCoding: {
		        validator: function(value, param){
		        	console.log(param);
		        	var pattern_a =/^[a-zA-Z0-9_-]{1,}$/;
		            return pattern_a.test(value);
		        },  
		        message: '只能输入字母数字下划线。'
			},
		specialTel: {
	        validator: function(value, param){
	        	var pattern_a =/^(13|15|18|14)\d{9}$/,pattern_b = /^0(((\d{2,3})-(\d){7,8})|(\d{2,3}(\d){7,8}))$/,rs = "";
	            if(!(pattern_a.test(value)||pattern_b.test(value))){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return pattern_a.test(value)||pattern_b.test(value);
	        },  
	        message: '电话格式不正确'
	    },
		specialPosenal: {
	        validator: function(value, param){
	        	var pattern_a =/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/,pattern_b = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[A-Za-z0-9]{1}$/,rs = "";
	            if(!(pattern_a.test(value)||pattern_b.test(value))){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return pattern_a.test(value)||pattern_b.test(value);
	        },  
	        message: '身份证号格式不正确'
	    },
		specialEmile: {
	        validator: function(value, param){
	        	var pattern =/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/,rs = "";
	            if(!pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return pattern.test(value);
	        },  
	        message: '邮箱格式不正确'
	    },
		specialTextCharacter: {
	        validator: function(value, param){
	        	var pattern =/[`~!\%\*\+<>\?:\"\{\},\.\\\/;'\[\]\!\%\@\#\$\￥\^\&\……\（\）\、\(\)\"\'\“\”\:\,\.\，\。\【\】\《\》\=\——\！]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		},
		specialCharacterTextArea: {
	        validator: function(value, param){
	        	var pattern =/[`~\*\_\+<>\\\[\]\!\%\@\#\$\￥\^\&]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		},
		checkMacAddress: {
	        validator: function(value, param){
	        	var regex = "([A-Fa-f0-9]{2}-){5}[A-Fa-f0-9]{2}";
	        	var regexp = new RegExp(regex);
	        	var result = regexp.test(value);
	            return result;
	        },  
	        message: 'MAC地址格式不正确。'
		} 
	}),
	$.extend($.fn.validatebox.defaults.rules, {
	    specialCharacter: {
	        validator: function(value, param){
	        	var pattern =/[`~!\%\*\_\+<>\?:\"\{\},\.\\\/;'\[\]\!\%\@\#\$\￥\^\&\……\（\）\、\(\)\"\'\“\”\:\,\.\，\。\【\】\《\》\-\=\——\！\'\;]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		},
		specialTextCharacter: {
	        validator: function(value, param){
	        	var pattern =/[`~!\%\*\+<>\?:\"\{\},\.\\\/;'\[\]\!\%\@\#\$\￥\^\&\……\（\）\、\(\)\"\'\“\”\:\,\.\，\。\【\】\《\》\=\——\！]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		},
		specialCharacterTextArea: {
	        validator: function(value, param){
	        	var pattern =/[`~\*\_\+<>\\\[\]\!\%\@\#\$\￥\^\&]/g,rs = "";
	            if(pattern.test(value)){
	            	for (var i = 0; i < value.length; i++) { 
	            		rs = rs+value.substr(i, 1).replace(pattern, ''); 
	            	} 
	            	this.value=rs;
	            }
	            return !pattern.test(value);
	        },  
	        message: '不允许输入特殊字符'
		} 
	}),
	createFrame = function (url) {
        var s = '<iframe name="mainFrame" scrolling="no" frameborder="0"  src="' + url + '" style="width:100%;height:99.6%;"></iframe>';
        return s;
	},
	addTab = function (subtitle, url) {
		var tabs = $('#tabs'),mainPanle = $('#mainPanle');
		if (tabs.tabs('exists', subtitle)) {
			if(subtitle=='首页'){
				refreshTabs(tabs.tabs('getTab',subtitle),url);
			}
			tabs.tabs('select', subtitle);
			return;
		}
		//控制展开10项
		var allTabs = tabs.tabs('tabs');
		if(allTabs.length>9){
			$.messager.confirm('提示', '您已经打开了'+allTabs.length+'张页签，继续打开会影响页面响应速度，您确定打开?', function (r) {
              	 if(r==true){
              		addTabToMain(subtitle,url,tabs,mainPanle);
              	 }else{
              		 return;
              	 }
               });
		}else{
			if (!tabs.tabs('exists', subtitle)) {
				if(subtitle=='首页'){
					tabs.tabs('add', {
			            title: subtitle,
			            content: createFrame(url),
			            closable: false,
			            width: mainPanle.width(),
			            height: mainPanle.height()
      				});
		        }else{
		        	tabs.tabs('add', {
			            title: subtitle,
			            content: createFrame(url),
			            closable: true,
			            selected: false,
			            width:mainPanle.width(),
			            height:mainPanle.height()
			        });
			    }
				tabs.tabs({
		            border: false,
		            onSelect: function (title) {
		                var pp = tabs.tabs("getSelected");
		                var tabObj = pp.panel("options").tab;    // 相应的 tab 对象
		                var iframe = $(pp.panel('options').content);
		                var src = iframe.attr('src');
		                if (src != undefined) {
		                	tabs.tabs('update', { tab: pp, options: { content: createFrame(src) } });
		                }
		            }
		        });
		        /*$('#tabs').tabs('bindDblclick', function(index, title){
		        	$('#tabs').tabs('close',index);
		        });*/
		    }
			tabs.tabs('select', subtitle);
		}
	},
	
	refreshTabs = function(currTab,url){
		//var url = $(currTab.panel('options').content).attr('src');
	    $('#tabs').tabs('update', {
	    	tab : currTab,
	    	options : {
	    		content : createFrame(url)
	    	}
	    });
	},
	addTabIndex = function (subtitle, url) {
		var tabs = parent.$('#tabs'),mainPanle = parent.$('#mainPanle');
		if (tabs.tabs('exists', subtitle)) {
			if(subtitle=='流程设计'){
				tabs.tabs('select', subtitle);
				tabs.tabs('closeCurrent');
				addTabToMain(subtitle,url,tabs,mainPanle);
			}
			return;
		}
		//控制展开10项
		var allTabs = tabs.tabs('tabs');
		if(allTabs.length>9){
			$.messager.confirm('提示', '您已经打开了'+allTabs.length+'张页签，继续打开会影响页面响应速度，您确定打开?', function (r) {
              	 if(r==true){
              		addTabToMain(subtitle,url,tabs,mainPanle);
              	 }else{
              		 return;
              	 }
               });
		}else{
			addTabToMain(subtitle,url,tabs,mainPanle);
		}
	},
	addTabToMain = function(subtitle,url,tabs,mainPanle){
		if (!tabs.tabs('exists', subtitle)) {
	        tabs.tabs('add', {
	            title: subtitle,
	            content: createFrame(url),
	            closable: true,
	            selected: false,
	            width: mainPanle.width(),
	            height: mainPanle.height()
	        });
	        tabs.tabs({
	            border: false,
	            onSelect: function (title) {
	                var pp = tabs.tabs("getSelected");
	                var tabObj = pp.panel("options").tab;    // 相应的 tab 对象
	                var iframe = $(pp.panel('options').content);
	                var src = iframe.attr('src');
	                if (src != undefined) {
	                    tabs.tabs('update', { tab: pp, options: { content: createFrame(src) } });
	                }
	            }
	        });
	        /*$('#tabs').tabs('bindDblclick', function(index, title){
        	 $('#tabs').tabs('close',index);
        	});*/
	    }
	    tabs.tabs('select', subtitle);
	},
	//*********************************************************************  打印     *********************************************************************************
	barCodeToPrinter = function (str){
		var w=window.open("", "newWindow", "toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");  
		//w.focus();此处在IE8中无效，焦点没有在w上,只有点击w页面时候才开始打印
		var objectStr = "<object id=\"WebBrowser\" width=0 height=0 classid=\"clsid:8856F961-340A-11D0-A96B-00C04FD705A2\"></object>";
		w.document.write(objectStr);
		w.document.write(str);
		w.document.close();
		w.document.all.WebBrowser.Execwb(6,6);
		//w.close();
	},
	barCodeUsbPrint=function(labName,str){
		var w = window.open("", "newWindow", "toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
		var objectStr = "<object id='print_epl' style='display: none; visibility: hidden' width='51' height='21' codebase='EPL.ocx#version=1,0,0,0' classid='CLSID:64CBDF17-E597-4309-A586-4BB8051452AB' visible='false'></object>";
		w.document.write(objectStr);
		var print_epl = w.document.getElementById('print_epl');
		//设置打印机
		print_epl.Open_Port("ZDesigner GK888t (EPL)");//选择打印机
	    print_epl.Begin_Job("2", "12", "False", "B");//设置其实位置? 
	    print_epl.Print_Winfont(120, 120, labName, "宋体", 25, 13, "True", "False", "False", "False", "False");//添加文字label 
	    print_epl.Print_BarCode(20, 160, str, "1", "48", "2", "6", "N", "0");//设置条码图片
	    print_epl.End_Job();//结束符
	    print_epl.Close_Port();//结束符
	    print_epl.Printing_USBPORT("ZDesigner GK888t (EPL)");  //启动打印机打印
	    w.document.close();
	},
	/**
	 * @param data 
	 * data 参看条码打印协议
	 */
	zbSocketPrinter = function(data){
    	var url = getRootPath_web()+"/iPlant_printer";
        //提交打印信息给socketservice，socketsevice服务下发给socketclient客户端调用打印机打印
		$.ajax({
            type: "POST",
            url: url,
            //dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            async: true,
            data: {"dataList":JSON.stringify(data)},
            success: function (data) {
            	console.log(data);
            },
            error:function(e){
            }
        });
	
    },
	
	//*********************************************************************  工作流     *********************************************************************************
	/**
	 * 启动流程
	 */
	startRunFlow = function(key){
		var IFServerNo='ACT0000';
		var ajaxParam = {
            url: '/iPlant_ajax',
            dataType: 'JSON',
            data: {
               	ACT_TYPE:'startProcess',
               	PROCESS_KEY:key,
               	PROCESS_START_TYPE:startType,
				IFS: IFServerNo
            },
            successCallBack:function(data){
            	if(data.RESPONSE["0"].RESPONSE_HDR.MSG_CODE=='0'){
         	 	}else{
         	 		//$("#showMessageInfo").html("<font color=red>提示:"+msg+"操作失败,此数据正在使用!</font>");
         	 	}
    		},
    		errorCallBack:function(data){
				//$("#showMessageInfo").html("<font color=red>提示:"+msg+"操作失败,服务器无响应!</font>");
    		}
		};
        iplantAjaxRequest(ajaxParam);
	},
	/**
	 * 提交流程
	 */
	submitFlow = function(){
		
	},
	
	/*highcharts饼状图基本配置
	 * container:放置图表的容器ID，
	 * title:图表表头标题，
	 * pieData:数据，
	 * */
	pieChart = function(container,title,pieData){
		Highcharts.chart(container, {
			chart: {
	            type: 'pie',
	            options3d: {
	                enabled: true,
	                alpha: 0,		//3D倾斜度
	                beta: 0
	            },
	        },
	        title: {
	            text: '<span style="color:#1771B3;font-weight: bold;font-size:14px;">'+title+'</span>'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                depth: 0,				//厚度
	                dataLabels: {
	                    enabled: true,
	                    format: '{point.name}'
	                },
	                showInLegend: true
	            },
	            series: {
			            animation: {
			                duration: 5000,
			                easing: 'easeOutBounce'
			            }
				     }
	        },
	        series: //badReasonData
	        	[{
	            type: 'pie',
	            name: title,
	            data: pieData
	        }],
	        credits: {
		          enabled:false
		},exporting: {
	        enabled:false
		}
		});
	},
	/*highcharts设备产能柱状图基本配置
	 * container:放置图表的容器ID，
	 * title:图表表头标题，
	 * barData:数据，数据结构为数组，数组中的数据必须是number类型。
	 * legendTitle:图例名称，
	 * xData:x轴数据，数据结构为数组
	 * */
	barChart = function(container,title,barData,legendTitle,xData){
		Highcharts.chart(container, {
		    chart: {
		        type: 'column',
		        options3d: {
		            enabled: true,
		            alpha: 2,
		            beta: 3,
		            depth: 45
		        }
		    },
		    title: {
		        text: '<span style="color:#1771B3;font-size:14px;">'+title+'</span>'
		    },
		    plotOptions: {
			        column: {
			            depth: 25,
			         dataLabels:{
                      enabled:true, // dataLabels设为true
                      style:{
                          color:'#D7DEE9'
                      }
                  }
			        },
   			     series: {
       		            animation: {			//加载动画
       		                duration: 5000,		//动画执行5秒
       		                easing: 'easeOutBounce'
       		            }
       			     }
			    },
		    xAxis: {
		    	categories: xData,
		    	min : 0,
		    	max: xData.length - 1
		    },
		    yAxis: {
		        title: {
		            text: null
		        },
		        min:0,
		        minRange:1
		    },
		    series: [{
		        name: '<span style="color:#1771B3">'+legendTitle+'</span>',
		        data: barData
		    }],
		    credits: {
		          enabled:false
		    },
			exporting: {
	            enabled:false
			}
		});
	},
	/*highcharts机器状态柱状图基本配置
	 * container:放置图表的容器ID，
	 * title:图表表头标题，
	 * barData:数据，数据结构为数组，数组中的数据必须是number类型。
	 * xData:x轴数据，数据结构为数组
	 * */
	layeredBarChart = function(container,title,barData,xData){
		 Highcharts.chart(container, {
			    chart: {
			        type: 'column',
			        options3d: {
			            enabled: true,
			            alpha: 5,
			            beta: 5,
			            viewDistance: 25,
			            depth: 50
			        }
			    },
			    title: {
			        text: '<span style="color:#1771B3;font-size:14px;">'+title+'</span>'
			    },
			    xAxis: {
			    	categories: xData,
			        min : 0,
			    	max: xData.length - 1
			    },

			    yAxis: {
			        allowDecimals: false,
			        min: 0,
			        max : 100,
			        title: {
			            text: null
			        },
		            labels:{
		                formatter:function() {//在labels里可以配置formatter属性可以对y轴设置单位之类的个性化东西
		                    return this.value+'%';//可以对照上面图表 +"L"
		                }
		            }
			    },
    			 plotOptions: {
    			        column: {
    			            stacking: 'normal',
    			            depth: 40
    			        },
	       			     series: {
		       		            animation: {
		       		                duration: 5000,
		       		                easing: 'easeOutBounce'
		       		            }
		       			     }
    			    },

			 series: barData,
			 credits: {
			         enabled:false
			 },
			 exporting: {
	            enabled:false
			 }
		});
	},
	/*highcharts设备产能柱状图基本配置
	 * container:放置图表的容器ID，
	 * title:图表表头标题，
	 * barData:数据，数据结构为对象，对象中有四个数组，数组中的数据必须是number类型。
	 * */
	columnChart = function(container,title,barData){
		Highcharts.chart(container, {
			chart: {
				type: 'column'
			},
			title: {
			    text: '<span style="color:#1771B3;font-size:14px;">'+title+'</span>'
			},
			xAxis: {
			    crosshair: true,
			    categories: ['08-10', '10-12', '12-14', '14-16', '16-18','18-20'],
			    min : 0,
		    	max: 5
			},
			yAxis: {
			    min: 0,
			    max:100,
			    title: {
			    	text: null
			    },
   			    labels:{
   		            formatter:function() {//在labels里可以配置formatter属性可以对y轴设置单位之类的个性化东西
   		            	return this.value+'%';//可以对照上面图表 +"L"
   		            }
   		        }
			},
			tooltip: {
			    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
			    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
			            '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
			    footerFormat: '</table>',
			    shared: true,
			    useHTML: true
			},
   			plotOptions: {
   			    column: {
   			    	pointPadding: 0.2,
   			            borderWidth: 0
   			        },
   			    series: {
       		        animation: {
       		            duration: 5000,
       		            	easing: 'easeOutBounce'
       		         }
       			}
   			 },
			 series: [{
			     name: '<span style="color:#1771B3">时间开动率</span>',
			     data: barData.Aarr
			 }, {
			     name: '<span style="color:#1771B3">性能开动率</span>',
			     data: barData.Barr

			 }, {
			     name: '<span style="color:#1771B3">合格品率</span>',
			     data: barData.Carr

			 }, {
			     name: '<span style="color:#1771B3">OEE</span>',
			     data: barData.Darr

			 }],
			 credits: {
			     enabled:false
			 },
			 exporting: {
	            enabled:false
			 }
		});
	},
	
	/*组装段看板接口方法*/
	screenAjaxFun = function(ifs,lx,dtime,sbbm){
		var Defer = $.Deferred();          //声明一个Defer对象
		iplantAjaxRequest({
	        url: '/iPlant_ajax',
	        data: {
	            IFS: ifs,
	            LINE_CD:lx,
	            REQ_TIME:dtime,
	            ET_CD:sbbm
	        },
	        successCallBack: function (data) {
	     	   if(data.RESPONSE[0].length != 0){
	     		   var rowCollection = createSourceObj(data);
	     		   Defer.resolve(rowCollection);               //在Defer对象的resolve状态中把combobox对象传出去
	     	   }
	        }
	    });
		return Defer.promise();                                   //返回一个promise对象
	},
	/**
	 * 日期选择框控制
	 * @param flag=1:当日之后，开始日小于等于结束日  flag=2：当日之前，开始日小于等于结束日 没有传flag:开始日期不限制，结束日期大于等于开始日期 
	 * @param startDateID 开始日期的id
	 * @param endDateID 结束日期的id
	 */
	dateValid=function (startDateID,endDateID,flag){
		var now = new Date(),nowDate = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		if(flag=='1'){
			/*计划开始日期不能小于当前日期*/
		    $('#'+startDateID).datebox('calendar').calendar({validator:function(date){
		        return nowDate <= date;
			}});
		    $('#'+endDateID).datebox('calendar').calendar({validator:function(date){
		        return nowDate <= date;
			}});
		    $('#'+startDateID).datebox({onSelect:function(date){
		    	setEndDateAfter(date,endDateID);
		    }});
		    $('#'+endDateID).datebox({onSelect:function(date){
		    	setStartDateAfter(date,startDateID,now,nowDate);
		    }});
		}else if (flag=='2') {
			$('#'+startDateID).datebox('calendar').calendar({validator:function(date){
	    		return nowDate >= date;
	    	}});
	    	$('#'+endDateID).datebox('calendar').calendar({validator:function(date){
	    		return nowDate >= date;
	    	}});
	    	$('#'+startDateID).datebox({onSelect:function(date){
	    		startDateComb = date;
	    	    setEndDateBefore(date,endDateID,now,nowDate);
	    	}});
	    	$('#'+endDateID).datebox({onSelect:function(date){
	    		endDateComb = date;
	    	    setStartDateBefore(date,startDateID,now,nowDate);
	    	}});
		}else if (flag=='3') {
			$('#'+startDateID).datetimebox('calendar').calendar({validator:function(date){
	    		return nowDate <= date;
	    	}});
	    	$('#'+endDateID).datetimebox('calendar').calendar({validator:function(date){
	    		return nowDate <= date;
	    	}});
	    	$('#'+startDateID).datetimebox({onSelect:function(date){
	    		startDateComb = date;
	    	    setEndDateBefores(date,endDateID,now,nowDate);
	    	}});
	    	 
		}else{
    	    $('#'+startDateID).datebox({onSelect:function(date){
    	    	startDateComb = date;
    	    	setEndDate(date,endDateID,now,nowDate);
    	    }});
    	    $('#'+endDateID).datebox({onSelect:function(date){
    	    	endDateComb=date;
    	    	setStartDate(date,startDateID,now,nowDate);
    	    }});
		}
	},
    setEndDateAfter=function (compareDate,controlID){
		$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return compDate<=date;
		}});
    },
	setStartDateAfter=function (compareDate,controlID,now,nowDate){
    	$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return nowDate<=date && date<=compDate;
		}});
    },
    setEndDateBefore=function (compareDate,controlID,now,nowDate){
		$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return compDate<=date && nowDate>=date;
		}});
    },
    setEndDateBefores=function (compareDate,controlID,now,nowDate){
		$('#'+controlID).datetimebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate()
	    			,compareDate.getHours(),compareDate.getMinutes(),compareDate.getSeconds());
	        return compDate<=date && nowDate<=date;
		}});
    },
	setStartDateBefore=function (compareDate,controlID,now,nowDate){
    	$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return nowDate>=date && date<=compDate;
		}});
    },
    setEndDate=function (compareDate,controlID,now,nowDate){
		$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return compDate<=date ;
		}});
    },
	setStartDate=function (compareDate,controlID,now,nowDate){
    	$('#'+controlID).datebox('calendar').calendar({validator:function(date){
	    	var compDate = new Date(compareDate.getFullYear(), compareDate.getMonth(), compareDate.getDate());
	        return  date<=compDate;
		}});
    },
    commonShowMessage = function(msg){
		$.messager.show({
     	    title:'提示',
     	    msg:msg,
     	    //showType:'show',
     	    showType:'slide',
     	    showSpeed:'8600',
     	    style:{
     	    	left:document.body.clientWidth-250, // 与左边界的距离
     	    	top:document.body.clientHeight-100 // 与顶部的距离
     	    }
     	});
	},
	getServiceDT=function (){
        var xhr = null,datetime='',time = null,curDate = null;
        $.ajax({type:"OPTIONS",url:"/",async:false,complete:function(x){time=x.getResponseHeader("Date")}});
      	curDate = new Date(time);
      	var year = curDate.getFullYear().toString(),month = (curDate.getMonth() + 1),day = curDate.getDate().toString(),hour = curDate.getHours().toString(),minutes = curDate.getMinutes().toString(),seconds = curDate.getSeconds().toString();
      	if (month < 10) month = "0" + month;
      	if (day < 10) day = "0" + day;
      	if (hour < 10) hour = "0" + hour;
      	if (minutes < 10) minutes = "0" + minutes;
      	if (seconds < 10) seconds = "0" + seconds;
      	
      	datetime = year +"-" + month +"-" +day;
        return datetime;
    }
    
    
    
})();