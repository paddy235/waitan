/*
 调用方式：
 id:搜索框input的id
 $('#autocomplete').inputAutoComplete({
 requestType: 'get',
 requestUrl: '/json/document/searchAutocomplete',
 requestData: {
 type: $selectType.val(),
 limit: 10
 },
 wrap: $('body'),
 callback: function () {

 }
 });
 */

;
(function($) {
	var timer = false;
	var defaults = {
		requestType: 'get', //类型
		requestUrl: '', //url
		requestData: {}, //传递的对象
		wrap: null, //生成的元素的父元素
		group: '', //分组的标记
		acClass: 'ac_results',
		acId: 'ac_results',
		delayFlag: false, //延迟加载标记
		callback: function() {
			return false;
		}
	}

	function Autocomplete(element, opt) {
		this.element = element;
		this.autoParam = $.extend({}, defaults, opt);
		this.init();
		this.autoWatch();
	}
	Autocomplete.prototype = {
		init: function() {
			var that = this;
			var element = this.element;
			var nowEleId = $(this.element).attr('id');
			var acId = that.autoParam.acId;
			$('body').on('click', function(e) {
				var nowClickId = e.target.id;
				if (nowEleId == nowClickId) {
					that.show();
				} else {
					that.hide();
				}
			});
			// $("li.group-item").unbind('click').bind('click', function() {
			// 	that.selectEle();
			// })
		},
		autoWatch: function() {
			var that = this;
			var $ele = $(this.element);
			$ele.on('input propertychange', function() {
				var oldValue = $(this).data('oldValue');
				var newValue = $(this).val();
				$(this).attr({
					company: "",
					data_flag: "noWorld",
				});
				if (oldValue == newValue) {
					that.show();
					return false;
				} else if (newValue == "") {
					return false;
				} else {
					// console.log("我来过请求地址=============================")
					that.delayRequest(newValue, 0);
				}
			})
		},
		delayRequest: function(newValue, i) { //延时请求处理
			var that = this;
			var j = 10;
			if (timer) {
				clearInterval(timer);
			}
			timer = setInterval(function() {
				++i;
				if (i == j) {
					console.log(i, j);
					that.requestData(newValue);
					clearInterval(timer);
				}
			}, 100);
		},
		requestData: function(newValue) {
			var that = this;
			if (that.autoParam.requestData.form == "base") {
				that.autoParam.requestData.keyword = newValue;
				that.autoParam.requestData.timestamp = +new Date();
			} else {
				that.autoParam.requestData.platName = newValue;
				that.autoParam.requestData.timestamp = +new Date();
			}

			$.ajax({
				type: that.autoParam.requestType,
				url: that.autoParam.requestUrl,
				data: that.autoParam.requestData,
				dataType: 'json',
				success: function(data) {
					that.dataHandle(data, that.autoParam.requestData.form);
				}
			});
		},
		dataHandle: function(data, type) {
			var $wrap = this.autoParam.wrap;
			var acClass = this.autoParam.acClass;
			var acId = this.autoParam.acId;
			var dataList = [];
			var _getBaseKey = $(this.element).val();

			dataList.push('<div class=' + acClass + ' id=' + acId + ' style="display:none"><ul>');

			if (type == "base") {
				if (data.content.length > 0) {
					for (var i = 0; i < data.content.length; i++) {
						var _getColor = data.content[i].replace(_getBaseKey, '<span class="strong">' + _getBaseKey + '</span>');
						dataList.push('<li class="group-item" data-key=' + data.content[i] + ' data-company="">' + _getColor + '</li>');
					};
				} else {
					dataList.push('<li class="group" >暂无相关数据。</li>');
				}
			} else {
				if (data.content) {
					var _getColor = data.content.platformName.replace(_getBaseKey, '<span class="strong">' + _getBaseKey + '</span>');
					dataList.push('<li class="group-item" data-key=' + data.content.platformName + ' data-company=' + data.content.name + '>' + _getColor + '</li>');
				} else {
					dataList.push('<li class="group" >暂无相关数据。</li>');
				}
			}

			dataList.push('</ul></div>');
			var dataListStr = dataList.join('');
			$('.' + acClass).remove();
			$wrap.append(dataListStr);
			this.selectEle();
			this.show();
		},
		show: function() {
			var acClass = this.autoParam.acClass;
			this.setPos();
			$('.' + acClass).show();
		},
		hide: function() {
			var acClass = this.autoParam.acClass;
			$('.' + acClass).html("").hide();
		},
		setPos: function() {
			var acClass = this.autoParam.acClass;
			var $element = $(this.element);
			var offset = $element.offset();
			var inputHeight = parseInt($element.outerHeight());
			$('.' + acClass).css({
				position: 'absolute',
				width: $element.outerWidth(),
				top: offset.top + inputHeight,
				left: offset.left
			});
		},
		selectEle: function() {
			var that = this;
			var acClass = this.autoParam.acClass;
			var $element = $(this.element);
			var $resultLi = $('.' + acClass).find('ul li');
			// $resultLi.each(function() {
			$('.' + acClass).find('ul li').unbind('click').on('click', function() {
				var key = $(this).data('key');
				var keyCompany = $(this).data('company');
				var isgroup = $(this).hasClass('group');
				if (isgroup) {
					$element.attr({
						data_flag: "noWorld",
						company: ""
					});
					return false;
				}
				document.getElementById("autocomplete").value = key;
				document.getElementById("autocomplete").setAttribute("company", keyCompany);
				document.getElementById("autocomplete").setAttribute("data_flag", "hasWorld")
					// $element.attr({
					// 	company: keyCompany,
					// 	data_flag: "hasWorld",
					// });
				that.hide();
			});
			// });
		}
	}

	$.fn.inputAutoComplete = function(opt) {
		return new Autocomplete(this, opt);
	}
})(jQuery)