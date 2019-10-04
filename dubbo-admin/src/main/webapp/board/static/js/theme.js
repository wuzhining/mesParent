//一般设备看板，如AOI，SPI
var my_skin = {
    //颜色数组，默认从数组第一个元素取色
    colors: ["#2B908F", "#C0393C", "#96DF95", "#3F3FDE", "#2B915D", "#2B6091",
		"#902B91", "#912B60", "#2D912B", "#915D2B"],
    //背景透明
    chart: {
		backgroundColor:'',
		borderColor: '#00f6ff',
	    borderRadius: 5,
	    borderWidth: 1,
	},
    
    //title白色字
    title: {
       
        style:{ "color": "#E0E0E3", "fontSize": "14px" }
                //align:"right"
    },
    global: { 
    	useUTC: true 
    
    },
    series: {
	        	name:{
	        		style:{
	        			"color":"#E0E0E3",
	        		}
	        	},
    },
    credits: {
	          enabled:false
	},exporting: {
     enabled:false
	},
    
};

//综合管理看板
var zH_skin = {
    //背景透明
    chart: {
		backgroundColor:'rgb(3, 36, 43)',
		borderColor: '#00f6ff',
	    borderRadius: 5,
	    borderWidth: 1,
	},
    
    //title白色字
    title: {
       
        style:{ "color": "#E0E0E3", "fontSize": "14px" }
                //align:"right"
    },
    global: { 
    	useUTC: true 
    
    },
    credits: {
	          enabled:false
	},exporting: {
     enabled:false
	},
    
};

