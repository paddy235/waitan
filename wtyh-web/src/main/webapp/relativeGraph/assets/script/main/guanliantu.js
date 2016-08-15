$(function() {
	$(".down-pdf-tips").remove();
})

// 所有模块都通过 define 来定义
define(function(require, exports, module) {

	// nodes links 是全局变量，ajax加载进来

	//配置信息
	var conf = require('./guanliantu_conf');
	var fun = require('./guanliantu_fun');
	var dynamic = null;
	var getEachNodesNum = null;

	/**
	 *   需要传入画布的参数，以及画布的方法有
	 *   参数： {
	 *            nodes:jsonData, //结点数据
	 *            links:jsonData, //关系数据
	 *            isDrag:Boolean //是否可拖动
	 *        }
	 *   方法：
	 *   draw() //绘制画布
	 *   reDraw() //数据重绘
	 *   clearCanvas() //清除画布
	 *   hideCanvas() //隐藏画布
	 *   showCanvas() //显示画布
	 *   回调函数：
	 *   clickNodeFun() //点击结点的回调函数
	 *   drawCallBack() //绘制画布完成后的回调函数
	 *   drawBefore() //绘制前的回调函数
	 */
	//bean
	function Dynamic(nodes, links, isDrag) {
		this.nodes = deepClone(nodes);
		this.links = deepClone(links);
		this.isDrag = isDrag;
	};

	//坐标对象
	function Coordinate(x, y) {
		this.x = x;
		this.y = y;
		this.equals = function(new_coordinate) {
			if (new_coordinate != undefined && new_coordinate != null && new_coordinate.x == this.x && new_coordinate.y == y) {
				return true;
			}
			return false;
		}
	};

	//console.log(nodes);
	//console.log(links);

	/**
	 *   画出线条+箭头
	 *   @data null
	 *   @return null
	 */
	Dynamic.prototype.initLinks = function() {
		//return false
		// 遍历links，画出箭头
		var links = this.links;
		for (var i = 0; i < links.length; i++) {

			var source = links[i].source; //目标公司
			var target = links[i].target; //起点公司

			//console.log(links[i]);

			//如果有关联信息,绘制关联图
			if (source != undefined && source != null && target != undefined && target != null) {
				if (conf.linksData[source] == undefined || conf.linksData[target] == undefined) {
					continue;
				}
				//console.log(linksData[target]);
				//获取起始坐标点
				var start_node_shape = conf.linksData[source].symbol;
				var start_node = conf.linksData[source].zr_shape;
				var end_node_shape = conf.linksData[source].symbol;
				var end_node = conf.linksData[target].zr_shape;

				var line_color = conf.linksData[source].color;

				//开始坐标
				var start_coordinate = new Coordinate(start_node.style.x, start_node.style.y);
				if (start_node_shape == "rect") {
					start_coordinate.x += conf.rect_width / 2;
					start_coordinate.y += conf.rect_width / 2;
				}

				//终点坐标
				var end_coordinate = new Coordinate(end_node.style.x, end_node.style.y);
				end_coordinate.x += conf.rect_width / 2;
				end_coordinate.y += conf.rect_width / 2;

				//绘制箭头+线条
				var addflag = (links[i].addflag == "true");
				var arrow = fun.create_arrow(start_coordinate, end_coordinate, links[i].line == "dotted", addflag, line_color);

				//console.log(addflag);
				//绘制箭头
				if (!addflag) {
					conf.zr_links.addShape(arrow.polygon);
				}
				conf.zr_links.addShape(arrow.line);

				// 添加到对象的ins, outs这两个数组里面。方便后面做遍历
				conf.linksData[links[i].source].outs.push({
					name: links[i].target,
					arrow: arrow,
					guanlian: links[i].guanlian
				});
				conf.linksData[links[i].target].ins.push({
					name: links[i].source,
					arrow: arrow,
					guanlian: links[i].guanlian
				});

			} else {
				if (console && console.log) {
					console.log("Empty data:" + links[i])
				}
			}

		} //end for
		// console.log("linksData===>",conf.linksData);
	};

	/**
	 *   画出形状
	 *   @data 
	 *   @return
	 */
	Dynamic.prototype.initShapes = function() {

		var nodes = this.nodes;

		//总节点长度
		var nodesLen = nodes.length;
		conf.linksData = {};

		//统计每个层的节点数,分离值
		getEachNodesNum = function() {
			var nodesData = {};
			//var companyStr = [];
			for (var i = 0; i < nodesLen; i++) {
				if (nodes[i] != "null" && nodes[i] != undefined) { //在点击checkbox时，把不显示的节点nodes设置为null
					var category = nodes[i].category;
					//计算每层的坐标数量
					if (!nodesData[category]) {
						nodesData[category] = [];
					}
					//初始化关联图对象
					if (conf.linksData[nodes[i].name] == undefined) {
						var name = nodes[i].name;
						var symbol = nodes[i].symbol;
						var color = nodes[i].color;
						var ins = [];
						var outs = [];
						var zr_shape = null; // 在 setNodesCoordinate()  里面设置
						var category = nodes[i].category;
						var addflag = nodes[i].addflag;
						conf.linksData[name] = {
							textColor: '#000000',
							width: 40, //中心点宽度
							hight: 40, //中心点高度
							name: name,
							symbol: symbol,
							color: color,
							ins: ins,
							outs: outs,
							zr_shape: zr_shape,
							category: category,
							addflag: addflag,
							num: i
						};
					}
					nodesData[category].push(nodes[i]);

					//给侧面公司列表赋值
					var name = nodes[i].name;
					name = (name.length > 10 ? (name.substring(0, 10) + "...") : name);
					var check = '<input class="company-check" checked="checked" value="' + nodes[i].name + '" type="checkbox">';
					if (nodes[i].name == conf.centerCompanyName) {
						check = '';
					}
					if (nodes[i].addflag == "true") {
						check = '<input style="display:none;" class="company-check" checked="checked" value="' + nodes[i].name + '" type="checkbox"><a href="javascript:;" class="del-add-company"><i class="iconfont icon-icon13"></i></a>';
					}
					conf.allCompanyStr.push('<div class="item" data-name="' + nodes[i].name + '">' + check + '\
                                                <span class="num">' + (i + 1) + '</span>\
                                                <span class="item-name" data-name="' + nodes[i].name + '">' + name + '</span>\
                                                <a class="down" href="javascript:;"><i class="iconfont icon-ms_xiazai"></i></a>\
                                                <a class="links" href="javascript:;"><i class="iconfont icon-link"></i></a>\
                                            </div>');
				}
			}
			return nodesData;
		};

		//设置坐标 传入当前的半径，数组对象, 每圈容量, 角度偏移量（双：true,单：false）
		var setNodesCoordinate = function(nowRadius, nodesData, eachNum, offset, level) {
			//var nodesLen = nodesData.length;
			//每圈的角度偏移量
			offset = offset ? 0 : 180 / eachNum;
			for (var i = 0; i < eachNum; i++) {
				//如果一圈排不满，那么就留空~
				if (!nodesData[i]) {
					return false;
				}
				//设置坐标
				var angle = (360 * i) / eachNum + offset + 15;
				var y = nowRadius * Math.sin(angle * Math.PI / 180) + conf.$cavNodes.height() / 2;
				var x = nowRadius * Math.cos(angle * Math.PI / 180) + conf.$cavNodes.width() / 2;
				var name = nodesData[i].name;
				x = Math.ceil(x);
				y = Math.ceil(y);

				//设置x,y坐标,设置参数
				nodesData[i].x = x;
				nodesData[i].y = y;
				nodesData[i].level = level;

				//console.log(level);

				//设置线条起始坐标
				conf.linksData[name].zr_shape = fun.create_node(conf.linksData[name].symbol, {
					x: x,
					y: y
				}, conf.linksData[name].color, conf.linksData[name].name).node;

				//渲染，绘制节点
				var shape = fun.create_node(nodesData[i].symbol, new Coordinate(x, y), nodesData[i].color, nodesData[i].name);
				conf.zr.addShape(shape.node);
				shape.text.style.color = '#cccccc'
				conf.zr_text.addShape(shape.text);

			}
		};

		//计算坐标
		var getNodesCoordinate = function() {
			var nodesData = getEachNodesNum(); //第几层，每层的节点数

			//设置画布尺寸
			var nodesObj = {};
			for (a in nodesData) {
				if (nodesObj[a] == undefined) {
					nodesObj[a] = nodesData[a].length;
				}
			};
			fun.setCanvasSize(nodesObj);

			//模拟坐标点
			for (level in nodesData) {
				//初始化每圈的宽度
				if (level == 0) {
					conf.nowRadius = 0;
				} else {
					conf.nowRadius += conf.radius;
				}
				//节点总长
				var nodesLen = nodesData[level].length;
				//计算周长
				var perimeter = 2 * Math.PI * conf.nowRadius;
				//每圈的数量//第一圈的情况也考虑到了
				var eachNum = parseInt(perimeter / conf.eachMargin);
				eachNum = eachNum == 0 ? 1 : eachNum;
				//有几圈 能有多少圈？
				var maxLevel = Math.ceil(nodesLen / eachNum);

				if (maxLevel == 1) {
					eachNum = nodesLen;
				}

				//遍历每圈数据，然后渲染出来
				for (var i = 0; i < maxLevel; i++) {
					//如果不是第一个点，每环上面以 conf.radiusInner 的宽度进行递增
					if (level != 0) {
						conf.nowRadius += conf.radiusInner;
					}
					//设置坐标，渲染图 传入当前的半径，数组对象, 每圈容量, 角度偏移量（双：true,单：false）
					setNodesCoordinate(conf.nowRadius, nodesData[level].slice(i * eachNum, (i + 1) * eachNum), eachNum, (i % 2 == 0), level);
				}

			} //end for

		};
		getNodesCoordinate();

	};

	/**
	 *   获取当前画布的中心点
	 *   @data null
	 *   @return obj eg:{x:0,y:0}
	 */
	Dynamic.prototype.getCenterPoint = function() {
		var point = {};
		point.x = conf.winWid / 2;
		point.y = conf.winHei / 2;
		return point;
	};

	var iniNodes = function() {

		dynamic = new Dynamic(conf.thisNodes, conf.thisLinks, false);
		//画图形, 赋值 conf.allCompanyStr
		dynamic.initShapes();
		//画线条
		dynamic.initLinks();

		if ($(document).data("linksData") == undefined) {
			$(document).data("linksData", conf.linksData);
		}
	};

	//选择度
	$(".select-nav").off('click.level22').on('click.level22', '.level', function(event) {
		var level = $(this).attr("data-level");
		var version = mtui.getQueryString("version");
		if (!version) {
			version = $(".dateul .active").attr("data-ver");
		}

		var url = window.location.pathname + "?companyName=" + mtui.getQueryString("companyName") + "&level=" + level + '&mid=3';
		if (version) {
			url = url + '&version=' + version;
		}
		url = url + '&isopen=' + $("#GLOBAL").attr("data-isopen");
		window.location.href = url;
	});

	//默认选择2度
	var iniAjax = function() {
		conf.level = mtui.getQueryString("level") == undefined ? 2 : mtui.getQueryString("level");
		//console.log("conf.level",conf.level);
		$(".select-nav .levels").eq(conf.level - 1).addClass('active-level');
		var companyNameCode = mtui.getQueryString("companyName");
		var versionCode = mtui.getQueryString("version");
		var isEncode = mtui.getQueryString("encode");

		//设置套系
		conf.taoxi = $("#GLOBAL").attr("data-taoxi");

		if (versionCode == undefined) {
			versionCode = null;
			//return;
		}

		var data = {
			level: conf.level,
			companyName: companyNameCode,
			version: versionCode,
			encode: isEncode
		};

		if (typeof(defaultLevel) != "undefined") {
			data.dl = defaultLevel;
		}

		//初始化数据

		$.ajax({
			//url: '/relativeGraph/json/queryRelationship'+conf.level+'.json',
			url: '/relativeGraph/json/queryRelationship2.json',
			type: 'GET',
			dataType: 'json',
			data: data,
			success: function(data) {
				//console.log(data);

				//如果为空
				if (data.nodes == null) {
					data = {
						"nodes": [{
							"addflag": "false",
							"category": "0",
							"color": "#FF0000",
							"name": data.decCompany,
							"symbol": "rect"
						}],
						"links": [],
						"versions": data.versions
					}
				}

				//赋值
				conf.LEGAL_PERSON = data.LEGAL_PERSON;
				conf.NATURE_PERSON = data.NATURE_PERSON;
				conf.SUB_COMPANY = data.SUB_COMPANY;

				//节点赋值
				NODES = deepClone(data.nodes);
				LINKS = deepClone(data.links);

				conf.centerCompanyName = data.decCompany;
				$("#companyName").html(data.decCompany);

				//实例化
				conf.thisNodes = data.nodes;
				conf.thisLinks = data.links;

				LINKS = null; //释放内存

				//ini图形尺寸
				if (conf.thisNodes.length > 2000) {
					conf.radius = 40;
					conf.eachMargin = 20;
					conf.radiusInner = 20;
					conf.circle_radius = 5;
					conf.rect_width = 10;
				}

				if (conf.thisNodes.length > 4000) {
					conf.radius = 30;
					conf.eachMargin = 10;
					conf.radiusInner = 10;
					conf.circle_radius = 5;
					conf.rect_width = 10;
				}

				iniNodes();

				//设置公司列表
				conf.$allCompany.html(conf.allCompanyStr);
				conf.allCompanyStr = []; //释放内存

				//设置日期
				if (data.versions) {
					var ulstr = "";
					var a = 0;

					//获取当前的年，月
					var myDate = new Date();
					var now_year = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
					var now_month = parseInt(myDate.getMonth()) + 1; //获取当前月份(0-11,0代表1月)

					var mark = true;

					for (var i = 0; i < data.versions.length; i++) {
						var arr = data.versions[i].date.split("-");
						if (now_year == arr[0] && now_month == arr[1]) {
							mark = false;
							//return
						}
					}

					if (versionCode != null) {
						for (var i = 0; i < data.versions.length; i++) {
							if (data.versions[i].version == versionCode) {
								data.versions[i].isChecked = true;
							} else {
								data.versions[i].isChecked = false;
							}
						}
					}


					//此处必定要改
					for (var i = 0; i < data.versions.length; i++) {
						var arr = data.versions[i].date.split("-");
						a++;
						if (!mark) {
							var nDate = arr[0] + "-" + arr[1];
							if (i == data.versions.length - 1) {
								nDate = '最新'
							}
							ulstr += '<li class="' + (data.versions[i].isChecked ? "active" : "") + '" data-ver="' + data.versions[i].version + '"><a href="javascript:;">' + nDate + '</a></li>';
						} else {
							if (arr[1] == 12) {
								arr[1] = 1;
								arr[0] = parseInt(arr[0]) + 1;
							} else {
								arr[1] = parseInt(arr[1]) + 1;
							}
							var nDate = arr[0] + "-" + arr[1];
							if (i == data.versions.length - 1) {
								nDate = '最新'
							}
							ulstr += '<li class="' + (data.versions[i].isChecked ? "active" : "") + '" data-ver="' + data.versions[i].version + '"><a href="javascript:;">' + nDate + '</a></li>';
						}
					}
					$(".dateul").width(a * 102).html(ulstr);
				}

				//设置type选项
				switch (mtui.getQueryString("type")) {
					case "all":
						$(".tz[data-type='all']").trigger('click');
						break;
					case "shareholder":
						$(".tz[data-type='shareholder']").trigger('click');
						break;
					case "direct":
						$(".tz[data-type='direct']").trigger('click');
						break;
					case "leader":
						$(".tz[data-type='leader']").trigger('click');
						break;
					default:
						$(".tz[data-type='all']").addClass('active');
						break;
				}

				$(".loadingBox").hide();

			}
		});
	};
	iniAjax();

	//事件方法的结合
	require('./guanliantu_event.js').iniEvent();

	//文字隐藏
	$("#cavHideText").off('click.hiddentext').on('click.hiddentext', function(e) {
		if (conf.$cavNodesText.is(":hidden")) {
			conf.$cavNodesText.show();
		} else {
			conf.$cavNodesText.hide();
		}
	});

	//缩小
	var num = 2;
	$("#cavToMin").off('click.cavToMin').on('click.cavToMin', function(e) {
		conf.$cavNodesText.show();
		conf.zr.clear();
		conf.zr_text.clear();
		conf.zr_links.clear();

		conf.radius -= 10;
		conf.radiusInner -= num;
		conf.eachMargin -= num;
		if (conf.radius <= 60) {
			conf.circle_radius = 5;
			conf.rect_width = 10;
			conf.eachMargin = 10;
			conf.radiusInner = 10;
		}

		//绘制节点
		dynamic.initShapes();
		//绘制线条
		dynamic.initLinks();

		conf.$cavHover.hide();
		conf.$cavMainHover.hide();
		conf.$cavHoverNodes.hide();
		conf.$cavLinks.css('opacity', 0.2);
	});

	//放大
	$("#cavToMax").off('click.cavToMax').on('click.cavToMax', function(e) {
		conf.$cavNodesText.show();
		conf.zr.clear();
		conf.zr_text.clear();
		conf.zr_links.clear();
		conf.radius += 10;
		conf.radiusInner += num;
		conf.eachMargin += num;

		if (conf.radius >= 120) {
			conf.circle_radius = 10;
			conf.rect_width = 20;
			conf.eachMargin = 40;
			conf.radiusInner = 30;
		}
		//conf.circle_radius += num;
		//conf.rect_width += (num*2);

		//绘制节点
		dynamic.initShapes();
		//绘制线条
		dynamic.initLinks();

		conf.$cavHover.hide();
		conf.$cavMainHover.hide();
		conf.$cavHoverNodes.hide();
		conf.$cavLinks.css('opacity', 0.2);
	});

	//搜索接口
	require('./guanliantu_search');

	//对外提供接口
	exports.iniNodes = function() {
		iniNodes();
	}

	//设置 列表页面
	exports.getEachNodesNum = function() {
		getEachNodesNum();
	}

});