
(function(){
	var curLocation=0;
	var curAgvLocation=0;
	var curRunLocation=0;
	var curRunLoc1=0;
	var agvLocation1=[2,7,8,9];
	var agvLocation2=[1,2,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44];
	function locationHidden(){
		for(var i=0; i<28; i++){
			$("#Location"+agvLocation2[i]).hide();
		}
	}
	function locationShow(){
		var ajaxParam={
		    url: '/iPlant_ajax',
		    data:{
		    	IFS: 'ST00117',
		    	AGV_CD:2
			},
			successCallBack:function(data){
				var obj=data.RESPONSE[0].RESPONSE_DATA;
				if(obj!=null){
					/*agv当前位置*/
					if(agvLocation2.indexOf(Number(obj[0].TO_POINT))>=0){
						curLocation=obj[0].TO_POINT;
					}
					
					/*agv当前状态*/
					if(Number(obj[0].RUN_FLAG)==0){
						$('#divStop2').show();
						$('#divRun2').hide();
					}
					else
					{
						$('#divStop2').hide();
						$('#divRun2').show();
					}
					locationHidden();
					$("#Location"+curLocation).show();
					if(agvLocation2.indexOf(curLocation)>-1){
						curRunLocation=curLocation;	
					}
					else
					{
					    $('#Location'+curRunLocation).show();	
					}
					
					/*agv小车数据信息*/
					$('#agvCD2').html(obj[0].AGV_CD);
					if(Number(obj[0].RUN_FLAG)==0){
					    $('#runStatus2').html('停止');
					}
					else
					{
					    $('#runStatus2').html('运行');
					}
					$('#fontPostion2').html(obj[0].FROM_POINT);
					$('#curPostion2').html(obj[0].TO_POINT);
					$('#runDiction2').html(obj[0].RUN_DICTION);
					$('#runSpeed2').html(obj[0].SPEED_POSTION);
				}
		    }
		}
		iplantAjaxRequest(ajaxParam);
		agvRunLocation1Show();	
		
	}
	function agvRunLocation1Hide(){
		for(var j=0; j<4; j++){
			$("#AgvLocation"+agvLocation1[j]).hide();
		}
	}
	function agvRunLocation1Show(){
		var ajaxAgvParam={
			    url: '/iPlant_ajax',
			    data:{
			    	IFS: 'ST00117',
			    	AGV_CD:1
				},
				successCallBack:function(data){
					var obj=data.RESPONSE[0].RESPONSE_DATA;
					if(obj!=null){
						/*agv当前位置*/
						if(agvLocation1.indexOf(Number(obj[0].TO_POINT))>=0){
							curAgvLocation=obj[0].TO_POINT;
						}
						
						/*agv当前状态*/
						if(Number(obj[0].RUN_FLAG)==0){
							$('#divStop1').show();
							$('#divRun1').hide();
						}
						else
						{
							$('#divStop1').hide();
							$('#divRun1').show();
						}
						agvRunLocation1Hide();
						$("#AgvLocation"+curAgvLocation).show();
						if(agvLocation1.indexOf(curAgvLocation)>-1){
							curRunLoc1=curAgvLocation;	
						}
						else
						{
							$("#AgvLocation"+curRunLoc1).show();
						}
						
						/*agv小车数据信息*/
						$('#agvCD').html(obj[0].AGV_CD);
						if(Number(obj[0].RUN_FLAG)==0){
						    $('#runStatus').html('停止');
						}
						else
						{
						    $('#runStatus').html('运行');
						}
						$('#fontPostion').html(obj[0].FROM_POINT);
						$('#curPostion').html(obj[0].TO_POINT);
						$('#runDiction').html(obj[0].RUN_DICTION);
						$('#runSpeed').html(obj[0].SPEED_POSTION);
				    }
				}
			}
			iplantAjaxRequest(ajaxAgvParam);
	}
	
	$(function(){
		
		var height = document.getElementById("cctest").offsetHeight;
		var width = document.getElementById("cctest").offsetWidth;
		
		/*创建主容器div层*/
		var wid = 3*height;
		var mdiv = document.createElement("div");
		mdiv.style.height=height+'px';
		mdiv.style.width=wid+'px';
	    mdiv.style.background="url(static/image/zmb_new.png)";
	    mdiv.style.backgroundSize = "100% 100%";
	    mdiv.style.marginLeft = (width-wid)/2+"px";
	    document.getElementById("cctest").appendChild(mdiv); 
	    
	    /*创建agv设备状态层--运行*/
	    var adiv = document.createElement("div");
	    adiv.id='divRun1';
	    adiv.style.height='60px';
	    adiv.style.width='60px';
	    adiv.style.background="url(static/image/yx.png)";
	    adiv.style.backgroundSize = "100% 100%";
	    adiv.style.position ="absolute";
	    //adiv.style.left =(height-70)+"px";
	    //adiv.style.top =(height/2-5)+"px";
	    adiv.style.right =(height-160)+"px";
	    adiv.style.top =(height/2-30)+"px";
	    mdiv.appendChild(adiv); 
	    
	    /*创建agv设备状态层--停止*/
	    var rdiv = document.createElement("div");
	    rdiv.id='divStop1'
	    rdiv.style.height='60px';
	    rdiv.style.width='60px';
	    rdiv.style.background="url(static/image/tz.png)";
	    rdiv.style.backgroundSize = "100% 100%";
	    rdiv.style.position ="absolute";
	    rdiv.style.right =(height-160)+"px";
	    rdiv.style.top =(height/2-25)+"px";
	    rdiv.style.display="none";
	    mdiv.appendChild(rdiv);
	    
	    /*创建agv设备状态层--运行*/
	    var adiv2 = document.createElement("div");
	    adiv2.id='divRun2';
	    adiv2.style.height='60px';
	    adiv2.style.width='60px';
	    adiv2.style.background="url(static/image/yx.png)";
	    adiv2.style.backgroundSize = "100% 100%";
	    adiv2.style.position ="absolute";
	    adiv2.style.left =(height-50)+"px";
	    adiv2.style.top =(height/2-25)+"px";
	    adiv2.style.display='none';
	    mdiv.appendChild(adiv2); 
	    
	    /*创建agv设备状态层--停止*/
	    var bdiv = document.createElement("div");
	    bdiv.id='divStop2';
	    bdiv.style.height='60px';
	    bdiv.style.width='60px';
	    bdiv.style.background="url(static/image/tz.png)";
	    bdiv.style.backgroundSize = "100% 100%";
	    bdiv.style.position ="absolute";
	    bdiv.style.left =(height-50)+"px";
	    bdiv.style.top =(height/2-25)+"px";
	    mdiv.appendChild(bdiv);
	    
	    var locationX=5,locationY=0,tmpLocationX=0;
	    /*初始化AGV2小车*/
	    for(var i=0;i<26;i++){
	    	
	    	var locationID='Location'+agvLocation2[i];
	        var ediv=document.createElement("div");
	    	ediv.id=locationID;
	    	ediv.style.height='30px';
	    	ediv.style.width='40px';
	    	ediv.style.background="url(static/image/agvc_new.png)";
	    	ediv.style.backgroundSize = "100% 100%";
	    	ediv.style.position ="absolute";
	    	if(i<3){
            	locationX=locationX+40;
            	locationY=(height/2-5);
            	tmpLocationX=locationX;
            }
	    	else if(i>=3 &&i<15)
	    	{
	    		if(i==3)
	    		{
	    			locationX=locationX+35;
	    		}
	    		else
	    		{
	    	    	locationX=locationX+38;
	    		}
	    		//locationY=(height/4-35);
	    		locationY=(height-60);
	    	}
    		else if(i>=15 && i<26){
    			if(i==15)
	    		{
	    			locationX=tmpLocationX+33;
	    		}
	    		else
	    		{
	    	    	locationX=locationX+41;
	    		}
    			locationY=(height/4-35);
    			//locationY=(height-60);
    		}
	    	ediv.style.left =locationX+"px";
	    	ediv.style.top =locationY+"px";
	 	    mdiv.appendChild(ediv); 
	 	    $("#Location"+agvLocation2[i]).hide();
	 	}
	    
	    /*初始化AGV1小车***************************************************/
	    var agvLocationX=0,agvLocationY=0,backGroundUrl='',aHeight='40px';aWidth='60px';
	    for(var j=0;j<4;j++){
	    	 if(j==0){
	 	    	aHeight='30px';
	 	    	aWidth='40px';
	 		    backGroundUrl='url(static/image/agva_new.png)';
	 		    agvLocationX=width-121;
	 		    agvLocationY=height-57;
	 		 }
	 	     else if(j==1)
	 	     {
	 	    	 aHeight='30px';
	 		     aWidth='40px';
	 	    	 backGroundUrl='url(static/image/agvb_new.png)';
	 	    	 agvLocationX=width-162;
	 			 agvLocationY=height/2-10;
	 		 }
	 	     else if(j>1 && j<4){
	 	    	 aHeight='40px';
	 		     aWidth='30px';
	 	    	 backGroundUrl='url(static/image/agva_new.png)';
	 	    	 agvLocationX=width-150+(j-2)*65;
	 			 agvLocationY=height/4-45;
	 		 }
	 	     var agvlocationID='AgvLocation'+agvLocation1[j];
	 	     var gdiv=document.createElement("div");
	 	     gdiv.id=agvlocationID;
	 	     gdiv.style.height=aHeight;
	 	     gdiv.style.width=aWidth;
	 	     gdiv.style.background=backGroundUrl;
	 	     gdiv.style.backgroundSize = "100% 100%";
	 	     gdiv.style.position ="absolute";
	 	     gdiv.style.left =agvLocationX+"px";
	 	     gdiv.style.top =agvLocationY+"px";
	 	     mdiv.appendChild(gdiv); 
	 	 	 $("#AgvLocation"+agvLocation1[j]).hide();
	    }
	    
	    var t=setInterval(function() {
			locationShow();
		},10000);
   });
})();
