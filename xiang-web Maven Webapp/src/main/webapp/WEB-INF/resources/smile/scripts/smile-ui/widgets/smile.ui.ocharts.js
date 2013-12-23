/*
 * Smile UI oCharts 1.0.2
 *
 * @author yangfan, 2012-05-20
 * 
 * @history
 *
 * Depends:
 *	jquery-1.7.2.js
 *	jquery-ui-1.8.18.custom.js
 *
 */
(function($, undefined) {
	
Highcharts.setOptions({
	credits: {
		enabled: true,
		href: "http://www.nstars.com.cn/",
		text: "nstars.com.cn"
	},
	lang: {
		decimalPoint: ".",
		downloadJPEG: "下载 JPEG ",
		downloadPDF: "下载 PDF ",
		downloadPNG: "下载 PNG ",
		downloadSVG: "下载 SVG ",
		exportButtonTitle: "Export to raster or vector image",
		loading: "加载中...",
		months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		numericSymbols: ["k", "M", "G", "T", "P", "E"],
		printButtonTitle: "打印",
		rangeSelectorFrom: "开始: ",
		rangeSelectorTo: "&nbsp;&nbsp;结束: ",
		rangeSelectorZoom: "缩放",
		resetZoom: "重置缩放",
		resetZoomTitle: "重置缩放级别: 1:1",
		thousandsSep: "",
		weekdays: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"]
	},
	rangeSelector: {
		enabled: false,
		buttonSpacing: 5,
		buttons: [{
			type: "month",
			count: 1,
			text: "1月"
		}, {
			type: "month",
			count: 3,
			text: "3月"
		}, {
			type: "month",
			count: 6,
			text: "6月"
		}, {
			type: "ytd",
			text: "YTD"
		}, {
			type: "year",
			count: 1,
			text: "1年"
		}, {
			type: "all",
			text: "所有"
		}],
		inputDateFormat: "%Y-%m-%d",
		inputEditDateFormat: "%Y-%m-%d"
	},
	plotOptions: {
		candlestick: {
			dataGrouping: {
				dateTimeLabelFormats: {
				   millisecond: ["%A, %Y-%m-%d, %H:%M:%S.%L", "%A, %Y-%m-%d, %H:%M:%S.%L", "-%A, %Y-%m-%d, %H:%M:%S.%L"],
				   second: ["%A, %Y-%m-%d, %H:%M:%S", "%A, %Y-%m-%d, %H:%M:%S", "-%A, %Y-%m-%d, %H:%M:%S"],
				   minute: ["%A, %Y-%m-%d, %H:%M:%S", "%A, %Y-%m-%d, %H:%M:%S", "-%A, %Y-%m-%d, %H:%M:%S"],
				   hour: ["%A, %Y-%m-%d, %H:%M:%S", "%A, %Y-%m-%d, %H:%M:%S", "-%A, %Y-%m-%d, %H:%M:%S"],
				   day: ["%A, %Y-%m-%d", "%A, %Y-%m-%d", "-%A, %Y-%m-%d"],
				   week: ["%A, %Y-%m-%d", "%A, %Y-%m-%d", "-%A, %Y-%m-%d"],
				   month: ["%A, %Y-%m", "%A, %Y-%m", "-%A, %Y-%m"],
				   year: ["%A, %Y", "%A, %Y", "-%A, %Y"]
				}
			}
		}
	},
	xAxis: {
        dateTimeLabelFormats: {
            second: "%Y-%m-%d<br/>%H:%M:%S",
            minute: "%Y-%m-%d<br/>%H:%M",
            hour: "%Y-%m-%d<br/>%H:%M",
            day: "%Y-%m-%d",
            week: "%Y-%m-%d",
            month: "%Y-%m",
            year: "%Y"
        }
	}
});

$.widget("smile.ocharts", $.smile.obase, {

	options: {
		// 图表的类型。可取值：chart、stock
		chartType: "chart"
	},
	
	_chart: undefined,
	
	_create: function() {
		$.smile.obase.prototype._create.apply( this );
		var self = this;
		var settings = $.extend(true, {
			chart: {
		        renderTo: self.element.attr("id")
		    }
		}, self.options);
		// create the chart
		self._chart = new Highcharts.StockChart(settings);
	},
	
	_init: function() {
		
	},
	
	getChart: function() {
		return this._chart;
	}
	
});
	
})(jQuery);