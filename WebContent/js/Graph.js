
$(function graph() {
    $(document).ready(function () {
        $('#container1').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        /*setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random();
                            series.addPoint([x, y], true, true);
                        }, 5000);*/
                        
                        setInterval(function(){
                    		$.get("rest/cmd/env",function(data, status) {
                    			console.log("GRAPH"); 
                    			var x = (new Date()).getTime(); // current time
                    			for(i in data.data){           
                    				
                    				 }
                    			y = data.data[0].value;
                    			console.log("y = "+y)
                                
                            series.addPoint([x, y], true, true);
                    		});
                    		console.log('testgraph');
                    	},5000);
                    }
                }
            },
            title: {
                text: 'Nombre de Commandes'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Nombre de Commandes'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Nombre de Commandes',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 0,
                        });
                    }
                    return data;
                }())
            }]
        });
		$('#container2').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        /*setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random();
                            series.addPoint([x, y], true, true);
                        }, 5000);*/
                        
                        setInterval(function(){
                    		$.get("rest/cmd/env",function(data, status) {
                    			console.log("GRAPH"); 
                    			var x = (new Date()).getTime(); // current time
                    			for(i in data.data){           
                    				
                    				 }
                    			y = data.data[1].value;
                    			console.log("y = "+y)
                                
                            series.addPoint([x, y], true, true);
                    		});
                    		console.log('testgraph');
                    	},5000);
                    }
                }
            },
            title: {
                text: 'Nombre d’obstacles rencontrés'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Nombre d’obstacles rencontrés'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Nombre d’obstacles rencontrés',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 0,
                        });
                    }
                    return data;
                }())
            }]
        });
		$('#container3').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        /*setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random();
                            series.addPoint([x, y], true, true);
                        }, 5000);*/
                        
                        setInterval(function(){
                    		$.get("rest/cmd/env",function(data, status) {
                    			console.log("GRAPH"); 
                    			var x = (new Date()).getTime(); // current time
                    			for(i in data.data){           
                    				
                    				 }
                    			y = data.data[2].value;
                    			console.log("y = "+y)
                                
                            series.addPoint([x, y], true, true);
                    		});
                    		console.log('testgraph');
                    	},5000);
                    }
                }
            },
            title: {
                text: 'Nombre d’obstacles visibles'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Nombre d’obstacles visibles'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Nombre d’obstacles visibles',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 0,
                        });
                    }
                    return data;
                }())
            }]
        });
		
		$('#container4').highcharts({
            chart: {
                type: 'spline',
                animation: Highcharts.svg, // don't animate in old IE
                marginRight: 10,
                events: {
                    load: function () {

                        // set up the updating of the chart each second
                        var series = this.series[0];
                        /*setInterval(function () {
                            var x = (new Date()).getTime(), // current time
                                y = Math.random();
                            series.addPoint([x, y], true, true);
                        }, 5000);*/
                        
                        setInterval(function(){
                    		$.get("rest/cmd/env",function(data, status) {
                    			console.log("GRAPH"); 
                    			var x = (new Date()).getTime(); // current time
                    			for(i in data.data){           
                    				
                    				 }
                    			y = data.data[3].value;
                    			console.log("y = "+y)
                                
                            series.addPoint([x, y], true, true);
                    		});
                    		console.log('testgraph');
                    	},5000);
                    }
                }
            },
            title: {
                text: 'Distance parcourue'
            },
            xAxis: {
                type: 'datetime',
                tickPixelInterval: 150
            },
            yAxis: {
                title: {
                    text: 'Distance parcourue'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + '</b><br/>' +
                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                        Highcharts.numberFormat(this.y, 2);
                }
            },
            legend: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            series: [{
                name: 'Distance parcourue',
                data: (function () {
                    // generate an array of random data
                    var data = [],
                        time = (new Date()).getTime(),
                        i;

                    for (i = -19; i <= 0; i += 1) {
                        data.push({
                            x: time + i * 1000,
                            y: 0,
                        });
                    }
                    return data;
                }())
            }]
        });
    });
});







