
var html = '';
$.ajax({
        type: "post",
        url:'/pda/pdaMenu/menu',
        dataType: "json",  
        success: function (data) {
		
/*		for (var i = res.length-1; i >=0 ; i--) {
			if(res[i].parentId==null){//一级菜单进入
				html += "<ul id='nav'><li>";
				html += '<a href="javascript:'+res[i].menuUrl+';"><cite>'+res[i].menuName+'</cite></a>';
			
			for (var j = res.length-1; j >=0 ; j--) {
				if(res[j].parentId!=null){//二级菜单进入
				html += "<ul class='sub-menu'>";
				if(res[j].parentId==res[i].id){
					html += "<li><a href='javascript:'"+res[j].menuUrl+"'><cite>"+res[j].menuName+"</cite></a></li>";
					
				}
				html += "</ul>";
				}
			}
			
				html += '</li></ul>';	
		};
		//渲染html
		$('#side-nav').html(html);	
		};*/
		var res=data.map.list;
			html += "<ul id='nav'>";
				$.each(res,function(i,item){
					if(item.parentId==null){//一级菜单进入
						html += '<li><a href="javascript:;"><i class="iconfont">&#xeb8b;</i><cite>'+item.menuName+'</cite><i class="iconfont2 nav_right">&#xe6a7;</i></a>';
					
					var aa = item.id
					var index=0;
					html += "<ul class='sub-menu'>";
					$.each(res,function(j,item2){
							if(item2.parentId!=null){
								//二级菜单进入	
								if(item2.parentId==aa){
									html += "<li><a _href='javascript:'"+item2.menuUrl+"'><cite>"+item2.menuName+"</cite></a></li>";
								}
							}
						  
						});
						html += '</ul>';
					html += '</li>';
						}
				
			
		//渲染html
		});
		 html += '</ul>';
		$('#side-nav').html(html);	
		}
});
		
