$(function () {
	var dtime  = getBCtime();
	var lx = getQueryString("line");
	var sbbm = getQueryString("shebei");

	var tableHeihgt = document.body.clientHeight/2;
	ccFun();
	var t=setInterval(function  () {
		ccFun();
	},60000);
	function ccFun(){
    /*机器稼动率*/
    	Highcharts.chart('machineRate', {

    	    chart: {
    	        type: 'gauge',
    	        plotBackgroundColor: null,
    	        plotBackgroundImage: null,
    	        plotBorderWidth: 0,
    	        plotShadow: false
    	    },

    	    title: {
    	        text: '<span style="font-size:6px;">机器稼动率<span>',
    	        y:tableHeihgt*0.85
    	    },

    	    pane: {
    	        startAngle: -150,
    	        endAngle: 150,
    	        background: [{
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#FFF'],
    	                    [1, '#333']
    	                ]
    	            },
    	            borderWidth: 0,
    	            outerRadius: '109%'
    	        }, {
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#333'],
    	                    [1, '#FFF']
    	                ]
    	            },
    	            borderWidth: 1,
    	            outerRadius: '107%'
    	        }, {
    	            // default background
    	        }, {
    	            backgroundColor: '#DDD',
    	            borderWidth: 0,
    	            outerRadius: '105%',
    	            innerRadius: '103%'
    	        }]
    	    },

    	    // the value axis
    	    yAxis: {
    	        min: 0,
    	        max: 100,

    	        minorTickInterval: 'auto',
    	        minorTickWidth: 1,
    	        minorTickLength: 10,
    	        minorTickPosition: 'inside',
    	        minorTickColor: '#666',

    	        tickPixelInterval: 30,
    	        tickWidth: 2,
    	        tickPosition: 'inside',
    	        tickLength: 10,
    	        tickColor: '#666',
    	        labels: {
    	            step: 2,
    	            rotation: 'auto'
    	        },
    	        title: {
//    	            text: 'km/h'
    	        },
    	        plotBands: [{
    	            from: 0,
    	            to: 40,
    	            color: '#DF5353' // red
    	        }, {
    	            from: 40,
    	            to: 70,
    	            color: '#DDDF0D' // yellow
    	        }, {
    	            from: 70,
    	            to: 100,
    	            color: '#55BF3B' // green
    	            
    	        }]
    	    },

    	    series: [{
    	        name: '机器稼动率',
    	        data: [80],
    	        tooltip: {
//    	            valueSuffix: ' km/h'
    	        }
    	    }],
    	    credits: {
  	          enabled:false
    	    },exporting: {
    	    	enabled:false
    	    }

    	},
    	// Add some life
    	function (chart) {
    	    if (!chart.renderer.forExport) {
    	        setInterval(function () {
    	            var point = chart.series[0].points[0],
    	                newVal,
    	                inc = Math.round(Math.random() * 10);

    	            newVal = 80 + inc;
    	            if (newVal < 0 || newVal > 200) {
    	                newVal = point.y - inc;
    	            }

    	            point.update(newVal);

    	        }, 5000);
    	    }
    	});
    
    /*机器OEE*/
    	Highcharts.chart('machineOEE', {

    	    chart: {
    	        type: 'gauge',
    	        plotBackgroundColor: null,
    	        plotBackgroundImage: null,
    	        plotBorderWidth: 0,
    	        plotShadow: false
    	    },

    	    title: {
    	        text: '<span style="font-size:6px;">OEE<span>',
    	        y:tableHeihgt*0.85
    	    },

    	    pane: {
    	        startAngle: -150,
    	        endAngle: 150,
    	        background: [{
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#FFF'],
    	                    [1, '#333']
    	                ]
    	            },
    	            borderWidth: 0,
    	            outerRadius: '109%'
    	        }, {
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#333'],
    	                    [1, '#FFF']
    	                ]
    	            },
    	            borderWidth: 1,
    	            outerRadius: '107%'
    	        }, {
    	            // default background
    	        }, {
    	            backgroundColor: '#DDD',
    	            borderWidth: 0,
    	            outerRadius: '105%',
    	            innerRadius: '103%'
    	        }]
    	    },

    	    // the value axis
    	    yAxis: {
    	        min: 0,
    	        max: 100,

    	        minorTickInterval: 'auto',
    	        minorTickWidth: 1,
    	        minorTickLength: 10,
    	        minorTickPosition: 'inside',
    	        minorTickColor: '#666',

    	        tickPixelInterval: 30,
    	        tickWidth: 2,
    	        tickPosition: 'inside',
    	        tickLength: 10,
    	        tickColor: '#666',
    	        labels: {
    	            step: 2,
    	            rotation: 'auto'
    	        },
    	        title: {
//    	            text: 'km/h'
    	        },
    	        plotBands: [{
    	            from: 0,
    	            to: 40,
    	            color: '#DF5353' // red
    	        }, {
    	            from: 40,
    	            to: 70,
    	            color: '#DDDF0D' // yellow
    	        }, {
    	            from: 70,
    	            to: 100,
    	            color: '#55BF3B' // green
    	            
    	        }]
    	    },

    	    series: [{
    	        name: 'OEE',
    	        data: [55],
    	        tooltip: {
//    	            valueSuffix: ' km/h'
    	        }
    	    }],
    	    credits: {
  	          enabled:false
    	    },exporting: {
    	    	enabled:false
    	    }

    	},
    	// Add some life
    	function (chart) {
    	    if (!chart.renderer.forExport) {
    	        setInterval(function () {
    	        	var point = chart.series[0].points[0],
	                newVal,
	                inc = Math.round(Math.random() * 10);

		            newVal = 55 + inc;
		            if (newVal < 0 || newVal > 200) {
		                newVal = point.y - inc;
		            }
	
		            point.update(newVal);

    	        }, 5000);
    	    }
    	});
    
    /*班组OEE*/
    	Highcharts.chart('groupOEE', {

    	    chart: {
    	        type: 'gauge',
    	        plotBackgroundColor: null,
    	        plotBackgroundImage: null,
    	        plotBorderWidth: 0,
    	        plotShadow: false
    	    },

    	    title: {
    	        text: '<span style="font-size:6px;">班组OEE<span>',
    	        y:tableHeihgt*0.85
    	    },

    	    pane: {
    	        startAngle: -150,
    	        endAngle: 150,
    	        background: [{
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#FFF'],
    	                    [1, '#333']
    	                ]
    	            },
    	            borderWidth: 0,
    	            outerRadius: '109%'
    	        }, {
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#333'],
    	                    [1, '#FFF']
    	                ]
    	            },
    	            borderWidth: 1,
    	            outerRadius: '107%'
    	        }, {
    	            // default background
    	        }, {
    	            backgroundColor: '#DDD',
    	            borderWidth: 0,
    	            outerRadius: '105%',
    	            innerRadius: '103%'
    	        }]
    	    },

    	    // the value axis
    	    yAxis: {
    	        min: 0,
    	        max: 100,

    	        minorTickInterval: 'auto',
    	        minorTickWidth: 1,
    	        minorTickLength: 10,
    	        minorTickPosition: 'inside',
    	        minorTickColor: '#666',

    	        tickPixelInterval: 30,
    	        tickWidth: 2,
    	        tickPosition: 'inside',
    	        tickLength: 10,
    	        tickColor: '#666',
    	        labels: {
    	            step: 2,
    	            rotation: 'auto'
    	        },
    	        title: {
//    	            text: 'km/h'
    	        },
    	        plotBands: [{
    	            from: 0,
    	            to: 40,
    	            color: '#DF5353' // red
    	        }, {
    	            from: 40,
    	            to: 70,
    	            color: '#DDDF0D' // yellow
    	        }, {
    	            from: 70,
    	            to: 100,
    	            color: '#55BF3B' // green
    	            
    	        }]
    	    },

    	    series: [{
    	        name: '班组OEE',
    	        data: [55],
    	        tooltip: {
//    	            valueSuffix: ' km/h'
    	        }
    	    }],
    	    credits: {
  	          enabled:false
    	    },exporting: {
    	    	enabled:false
    	    }

    	},
    	// Add some life
    	function (chart) {
    	    if (!chart.renderer.forExport) {
    	    	setInterval(function () {
    	        	var point = chart.series[0].points[0],
	                newVal,
	                inc = Math.round(Math.random() * 10);

		            newVal = 55 + inc;
		            if (newVal < 0 || newVal > 200) {
		                newVal = point.y - inc;
		            }
	
		            point.update(newVal);

    	        }, 5000);
    	    }
    	});
    
    /*生产效率*/
    	Highcharts.chart('capacity', {

    	    chart: {
    	        type: 'gauge',
    	        plotBackgroundColor: null,
    	        plotBackgroundImage: null,
    	        plotBorderWidth: 0,
    	        plotShadow: false
    	    },

    	    title: {
    	        text: '<span style="font-size:6px;">生产效率<span>',
    	        y:tableHeihgt*0.85
    	    },

    	    pane: {
    	        startAngle: -150,
    	        endAngle: 150,
    	        background: [{
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#FFF'],
    	                    [1, '#333']
    	                ]
    	            },
    	            borderWidth: 0,
    	            outerRadius: '109%'
    	        }, {
    	            backgroundColor: {
    	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
    	                stops: [
    	                    [0, '#333'],
    	                    [1, '#FFF']
    	                ]
    	            },
    	            borderWidth: 1,
    	            outerRadius: '107%'
    	        }, {
    	            // default background
    	        }, {
    	            backgroundColor: '#DDD',
    	            borderWidth: 0,
    	            outerRadius: '105%',
    	            innerRadius: '103%'
    	        }]
    	    },

    	    // the value axis
    	    yAxis: {
    	        min: 0,
    	        max: 100,

    	        minorTickInterval: 'auto',
    	        minorTickWidth: 1,
    	        minorTickLength: 10,
    	        minorTickPosition: 'inside',
    	        minorTickColor: '#666',

    	        tickPixelInterval: 30,
    	        tickWidth: 2,
    	        tickPosition: 'inside',
    	        tickLength: 10,
    	        tickColor: '#666',
    	        labels: {
    	            step: 2,
    	            rotation: 'auto'
    	        },
    	        title: {
//    	            text: 'km/h'
    	        },
    	        plotBands: [{
    	            from: 0,
    	            to: 40,
    	            color: '#DF5353' // red
    	        }, {
    	            from: 40,
    	            to: 70,
    	            color: '#DDDF0D' // yellow
    	        }, {
    	            from: 70,
    	            to: 100,
    	            color: '#55BF3B' // green
    	            
    	        }]
    	    },

    	    series: [{
    	        name: '生产效率',
    	        data: [90],
    	        tooltip: {
//    	            valueSuffix: ' km/h'
    	        }
    	    }],
    	    credits: {
  	          enabled:false
    	    },exporting: {
    	    	enabled:false
    	    }

    	},
    	// Add some life
    	function (chart) {
    	    if (!chart.renderer.forExport) {
    	        setInterval(function () {
    	        	var point = chart.series[0].points[0],
	                newVal,
	                inc = Math.round(Math.random() * 5);

		            newVal = 90 + inc;
		            if (newVal < 0 || newVal > 200) {
		                newVal = point.y - inc;
		            }
	
		            point.update(newVal);

    	        }, 5000);
    	    }
    	});
    	
    	Highcharts.chart('container5', {
			chart: {
	            type: 'pie',
	            options3d: {
	                enabled: true,
	                alpha: 60,
	                beta: 0
	            }
	        },
	        title: {
	            text: '<span style="font-size:6px;">停机异常</span>'
	        },
	        tooltip: {
	            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                depth: 35,
	                dataLabels: {
	                    enabled: true,
	                    distance:1,
	                    format: '{point.name}',
	                    style: {     fontSize:"4px",    color :'#19a0f5'  } 
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '原因占比',
	            data: [
	                ['<span style="color:#19a0f5;font-size: 4px">机器坏 ,41.0%</span>',   41.0],						                
	                {
	                    name: '<span style="color:#19a0f5;font-size: 4px">换线,31.0%</span>',
	                    y: 31.0,
	                    sliced: true,
	                    selected: true
	                },
	                ['<span style="color:#19a0f5;font-size: 4px">来料异常,10.0%</span>',    10.0],
	                ['<span style="color:#19a0f5;font-size: 4px">软件问题,8.0%</span>',     8.0],
	                ['<span style="color:#19a0f5;font-size: 4px">视觉不良,10.0%</span>',   10.0]
	            ]
	        }],
	        credits: {
		          enabled:false
		},exporting: {
	        enabled:false
		}
		});
	}
});


