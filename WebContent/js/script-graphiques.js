/**
 * JS pour les graphiques
 */


$(document).ready(function () {
	Highcharts.setOptions({
		global: {
			useUTC: false
		}
	});
		
	
	var y_nbr_commande=0;
	var y_distance = 0;
	var y_nbr_obstacle_visible=0;
	var y_nbr_obstacle_rencontre=0;


	// ____________ REFRESH ____________
	$("#ButtonRefresh").click(function(){
		
		$.post("rest/cmd/NB_COMMANDES",
				{},
				function(data,status){
					save_data(data);
					alert("Post Done received data: " + data + "\nStatus: " + status);
					console.log(data);
				});
		console.log("test :");
		
		});
	
	function save_data_commande(data) {
		y_nbr_commande =data;
	}
	
	function save_data_nbr_obstacle_visible(data) {
		y_nbr_obstacle_visible =data;
	}
	
	function save_data_nbr_obstacle_rencontre(data) {
		y_nbr_obstacle_rencontre =data;
	}
	
	function save_data_distance(data) {
		y_distance =data;
	}
	

	

    Highcharts.chart('graph1', {
        chart: {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            events: {
                load: function () {
                	
                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	$.post("rest/cmd/NB_COMMANDES",
                				{},
                				function(data,status){
                					save_data_commande(data);
                					console.log(data);
                				});
                    }, 1000);
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = parseInt(y_nbr_commande);
                        series.addPoint([x, y], true, true);
                    }, 5000);
                }
            }
        },
        title: {
            text: 'Number of command entered'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#FF358B'
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
            name: 'Obstacles encountered',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -9; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 5000,
                        y: 0
                    });
                }
                return data;
            }())
        }]
    });
    
	
	
    
    Highcharts.chart('graph2', {
        chart: {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	$.post("rest/cmd/DISTANCE",
                				{},
                				function(data,status){
                					save_data_distance(data);
                					console.log(data);
                				});
                    }, 900);
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = parseInt(y_distance);
                        series.addPoint([x, y], true, true);
                    }, 5000);
                }
            }
        },
        title: {
            text: 'Distance travelled'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#01B0F0'
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
            name: 'Obstacles encountered',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -9; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 5000,
                        y: 0
                    });
                }
                return data;
            }())
        }]
    });
    
    
    Highcharts.chart('graph3', {
        chart: {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	$.post("rest/cmd/NB_OBS_VISIBLE",
                				{},
                				function(data,status){
                					save_data_nbr_obstacle_visible(data);
                					console.log(data);
                				});
                    }, 900);
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = parseInt(y_nbr_obstacle_visible);
                        series.addPoint([x, y], true, true);
                    }, 5000);
                }
            }
        },
        title: {
            text: 'Obstacles Visible'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: ''
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
            name: 'Obstacles Visible',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -9; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 5000,
                        y: 0
                    });
                }
                return data;
            }())
        }]
    });
    
    
    
    
    Highcharts.chart('graph4', {
        chart: {
            type: 'spline',
            animation: Highcharts.svg, // don't animate in old IE
            events: {
                load: function () {

                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	$.post("rest/cmd/NB_OBS_RENCONTRE",
                				{},
                				function(data,status){
                					save_data_nbr_obstacle_rencontre(data);
                					console.log(data);
                				});
                    }, 900);
                    setInterval(function () {
                        var x = (new Date()).getTime(), // current time
                            y = parseInt(y_nbr_obstacle_rencontre);
                        series.addPoint([x, y], true, true);
                    }, 5000);
                }
            }
        },
        title: {
            text: 'Obstacles Seen'
        },
        xAxis: {
            type: 'datetime',
            tickPixelInterval: 150
        },
        yAxis: {
            title: {
                text: ''
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
            name: 'Obstacles Seen',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -9; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 5000,
                        y: 0
                    });
                }
                return data;
            }())
        }]
    });
    
    });