webpackHotUpdate(0,{

/***/ 977:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(974);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//抽离出来的地图实例
	var chartChina, chartShanghai;
	//用来保存ajax返回的地图数据
	var ajaxDataChina, ajaxDataSH;
	//存储上海的经纬度
	var SHposition = {};

	/*上海地图接口的全局变量*/
	var TopMiddle = _react2.default.createClass({
	    displayName: 'TopMiddle',
	    getInitialState: function getInitialState() {
	        return {
	            mapeType: "china"
	        };
	    },
	    mapChina: function mapChina() {
	        var _this = this;
	        //中国点的经纬度
	        var geoCoordMap = {
	            '上海': [121.4648, 31.2891],
	            '东莞': [113.8953, 22.901],
	            '东营': [118.7073, 37.5513],
	            '中山': [113.4229, 22.478],
	            '临汾': [111.4783, 36.1615],
	            '临沂': [118.3118, 35.2936],
	            '丹东': [124.541, 40.4242],
	            '丽水': [119.5642, 28.1854],
	            '乌鲁木齐': [87.9236, 43.5883],
	            '佛山': [112.8955, 23.1097],
	            '保定': [115.0488, 39.0948],
	            '兰州': [103.5901, 36.3043],
	            '包头': [110.3467, 41.4899],
	            '北京': [116.4551, 40.2539],
	            '北海': [109.314, 21.6211],
	            '南京': [118.8062, 31.9208],
	            '南宁': [108.479, 23.1152],
	            '南昌': [116.0046, 28.6633],
	            '南通': [121.1023, 32.1625],
	            '厦门': [118.1689, 24.6478],
	            '台州': [121.1353, 28.6688],
	            '合肥': [117.29, 32.0581],
	            '呼和浩特': [111.4124, 40.4901],
	            '咸阳': [108.4131, 34.8706],
	            '哈尔滨': [127.9688, 45.368],
	            '唐山': [118.4766, 39.6826],
	            '嘉兴': [120.9155, 30.6354],
	            '大同': [113.7854, 39.8035],
	            '大连': [122.2229, 39.4409],
	            '太原': [112.3352, 37.9413],
	            '威海': [121.9482, 37.1393],
	            '宁波': [121.5967, 29.6466],
	            '宝鸡': [107.1826, 34.3433],
	            '宿迁': [118.5535, 33.7775],
	            '常州': [119.4543, 31.5582],
	            '广州': [113.5107, 23.2196],
	            '廊坊': [116.521, 39.0509],
	            '延安': [109.1052, 36.4252],
	            '张家口': [115.1477, 40.8527],
	            '徐州': [117.5208, 34.3268],
	            '德州': [116.6858, 37.2107],
	            '惠州': [114.6204, 23.1647],
	            '成都': [103.9526, 30.7617],
	            '扬州': [119.4653, 32.8162],
	            '承德': [117.5757, 41.4075],
	            '拉萨': [91.1865, 30.1465],
	            '无锡': [120.3442, 31.5527],
	            '日照': [119.2786, 35.5023],
	            '昆明': [102.9199, 25.4663],
	            '杭州': [119.5313, 29.8773],
	            '枣庄': [117.323, 34.8926],
	            '柳州': [109.3799, 24.9774],
	            '株洲': [113.5327, 27.0319],
	            '武汉': [114.3896, 30.6628],
	            '汕头': [117.1692, 23.3405],
	            '江门': [112.6318, 22.1484],
	            '沈阳': [123.1238, 42.1216],
	            '沧州': [116.8286, 38.2104],
	            '河源': [114.917, 23.9722],
	            '泉州': [118.3228, 25.1147],
	            '泰安': [117.0264, 36.0516],
	            '泰州': [120.0586, 32.5525],
	            '济南': [117.1582, 36.8701],
	            '济宁': [116.8286, 35.3375],
	            '海口': [110.3893, 19.8516],
	            '淄博': [118.0371, 36.6064],
	            '淮安': [118.927, 33.4039],
	            '深圳': [114.5435, 22.5439],
	            '清远': [112.9175, 24.3292],
	            '温州': [120.498, 27.8119],
	            '渭南': [109.7864, 35.0299],
	            '湖州': [119.8608, 30.7782],
	            '湘潭': [112.5439, 27.7075],
	            '滨州': [117.8174, 37.4963],
	            '潍坊': [119.0918, 36.524],
	            '烟台': [120.7397, 37.5128],
	            '玉溪': [101.9312, 23.8898],
	            '珠海': [113.7305, 22.1155],
	            '盐城': [120.2234, 33.5577],
	            '盘锦': [121.9482, 41.0449],
	            '石家庄': [114.4995, 38.1006],
	            '福州': [119.4543, 25.9222],
	            '秦皇岛': [119.2126, 40.0232],
	            '绍兴': [120.564, 29.7565],
	            '聊城': [115.9167, 36.4032],
	            '肇庆': [112.1265, 23.5822],
	            '舟山': [122.2559, 30.2234],
	            '苏州': [120.6519, 31.3989],
	            '莱芜': [117.6526, 36.2714],
	            '菏泽': [115.6201, 35.2057],
	            '营口': [122.4316, 40.4297],
	            '葫芦岛': [120.1575, 40.578],
	            '衡水': [115.8838, 37.7161],
	            '衢州': [118.6853, 28.8666],
	            '西宁': [101.4038, 36.8207],
	            '西安': [109.1162, 34.2004],
	            '贵阳': [106.6992, 26.7682],
	            '连云港': [119.1248, 34.552],
	            '邢台': [114.8071, 37.2821],
	            '邯郸': [114.4775, 36.535],
	            '郑州': [113.4668, 34.6234],
	            '鄂尔多斯': [108.9734, 39.2487],
	            '金华': [120.0037, 29.1028],
	            '铜川': [109.0393, 35.1947],
	            '银川': [106.3586, 38.1775],
	            '镇江': [119.4763, 31.9702],
	            '长春': [125.8154, 44.2584],
	            '长沙': [113.0823, 28.2568],
	            '长治': [112.8625, 36.4746],
	            '阳泉': [113.4778, 38.0951],
	            '青岛': [120.4651, 36.3373],
	            '韶关': [113.7964, 24.7028],
	            //省名
	            '天津': [117.11, 39.09],
	            '重庆': [106.32, 29.32],
	            '黑龙江': [126.41, 45.45],
	            '吉林': [125.19, 43.52],
	            '辽宁': [123.24, 41.5],
	            '内蒙古': [111.48, 40.49],
	            '河北': [114.28, 38.02],
	            '山西': [112.34, 37.52],
	            '山东': [117, 36.38],
	            '河南': [113.42, 34.48],
	            '陕西': [108.54, 34.16],
	            '甘肃': [103.49, 36.03],
	            '宁夏': [106.16, 38.2],
	            '青海': [101.45, 36.38],
	            '新疆': [87.36, 43.48],
	            '安徽': [117.18, 31.51],
	            '江苏': [118.5, 32.02],
	            '浙江': [120.09, 30.14],
	            '湖南': [113, 28.11],
	            '江西': [115.52, 28.41],
	            '湖北': [114.21, 30.37],
	            '四川': [104.05, 30.39],
	            '贵州': [106.42, 26.35],
	            '福建': [119.18, 26.05],
	            '台湾': [121.31, 25.03],
	            '广东': [113.15, 23.08],
	            '海南': [110.2, 20.02],
	            '广西': [108.2, 22.48],
	            '云南': [102.41, 25],
	            '西藏': [90.08, 29.39]
	        };
	        var convertData = function convertData(data) {
	            var res = [];
	            for (var i = 0; i < data.length; i++) {
	                var dataItem = data[i];
	                var fromCoord = geoCoordMap[dataItem[0].name];
	                var toCoord = geoCoordMap[dataItem[1].name];
	                if (fromCoord && toCoord) {
	                    res.push({
	                        fromName: dataItem[0].name,
	                        toName: dataItem[1].name,
	                        coords: [fromCoord, toCoord]
	                    });
	                }
	            }
	            return res;
	        };
	        var res = [];
	        // var SHData = [
	        //   [{name:'包头',value:95},{name:'上海'}],
	        //   [{name:'昆明',value:90},{name:'上海'}],
	        //   [{name:'广州',value:80},{name:'上海'}],
	        //   [{name:'郑州',value:70},{name:'上海'}],
	        //   [{name:'长春',value:60},{name:'上海'}],
	        //   [{name:'重庆',value:50},{name:'上海'}],
	        //   [{name:'长沙',value:40},{name:'上海'}],
	        //   [{name:'北京',value:30},{name:'上海'}],
	        //   [{name:'丹东',value:20},{name:'上海'}],
	        //   [{name:'大连',value:10},{name:'上海'}]
	        // ];
	        // var SHData =  [
	        //         [
	        //             {
	        //                 "name": "大连",
	        //                 "value": 204433
	        //             },
	        //             {
	        //                 "name": "上海"
	        //             }
	        //         ],
	        //         [
	        //             {
	        //                 "name": "重庆",
	        //                 "value": 1594
	        //             },
	        //             {
	        //                 "name": "上海"
	        //             }
	        //         ]
	        //     ]
	        var SHData = ajaxDataChina.content.SHData;

	        var color = ['#facd89', '#ffa022', '#46bee9'];
	        chartChina = echarts.init(document.getElementById("demo"));
	        var option = {
	            backgroundColor: 'none',
	            title: {
	                left: 'center',
	                textStyle: {
	                    color: '#fff'
	                }
	            },
	            tooltip: {
	                trigger: 'item'
	            },
	            grid: {},
	            geo: {
	                map: 'china',
	                top: "2%",
	                left: "5%",
	                right: "5%",
	                bottom: "2%",
	                roam: true,
	                label: {
	                    emphasis: {
	                        show: false
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        areaColor: '#25a9c3',
	                        borderColor: 'darkgreen',
	                        borderWidth: 0.5
	                    },
	                    emphasis: {
	                        areaColor: '#25a9c3'
	                    }
	                }
	            },
	            series: [{ //线
	                name: "",
	                type: 'lines',
	                zlevel: 1,
	                effect: {
	                    show: true,
	                    period: 6,
	                    trailLength: 0.7,
	                    color: 'yellow',
	                    symbolSize: 3
	                },
	                lineStyle: {
	                    normal: {
	                        color: color[0],
	                        width: 0,
	                        curveness: 0.2
	                    }
	                },
	                data: convertData(SHData)
	            }, { //线上移动的图标
	                name: "",
	                type: 'lines',
	                zlevel: 2,
	                effect: {
	                    show: false,
	                    period: 6,
	                    trailLength: 0,
	                    symbol: "",
	                    symbolSize: 15
	                },
	                lineStyle: {
	                    normal: {
	                        color: color[0],
	                        width: 1,
	                        opacity: 0.4,
	                        curveness: 0.2
	                    }
	                },
	                data: convertData(SHData)
	            }, { //圆点
	                name: "",
	                type: 'effectScatter',
	                coordinateSystem: 'geo',
	                zlevel: 2,
	                rippleEffect: {
	                    brushType: 'stroke'
	                },
	                label: {
	                    normal: {
	                        show: true,
	                        position: 'right',
	                        formatter: '{b}'
	                    }
	                },
	                symbolSize: function symbolSize(val) {
	                    return 8;
	                },
	                itemStyle: {
	                    normal: {
	                        color: color[0]
	                    }
	                },
	                data: SHData.map(function (dataItem) {
	                    return {
	                        name: dataItem[0].name,
	                        value: geoCoordMap[dataItem[0].name].concat([dataItem[0].value])
	                    };
	                })
	            }, { //圆点
	                name: "",
	                type: 'effectScatter',
	                coordinateSystem: 'geo',
	                zlevel: 2,
	                rippleEffect: {
	                    brushType: 'stroke'
	                },
	                label: {
	                    normal: {
	                        show: false,
	                        position: 'right',
	                        formatter: '{b}'
	                    }
	                },
	                symbolSize: function symbolSize(val) {
	                    return val[2] / 8 + 10;
	                },
	                itemStyle: {
	                    normal: {
	                        color: "red"
	                    }
	                },
	                data: [{
	                    name: "上海",
	                    value: [121.4648, 31.2891, 40]
	                }]
	            }]
	        };
	        chartChina.setOption(option);
	        chartChina.on("click", function (params) {
	            console.log(params);
	            if (params.componentSubType == "effectScatter" && params.name == "上海") {
	                this.dispose();
	                _this.mapShanghai();
	                $(".realtime-top-middle .info,.realtime-top-middle .return,.realtime-top-middle .bar").show();
	            }
	        });
	    },
	    mapShanghai: function mapShanghai() {
	        var _this = this;
	        var convertData = function convertData(data) {
	            var res = [];
	            for (var i = 0; i < data.length; i++) {
	                var geoCoord = SHposition[data[i].name];
	                if (geoCoord) {
	                    res.push({
	                        name: data[i].name,
	                        value: geoCoord.concat(data[i].value),
	                        data: data[i].data || ""
	                    });
	                }
	            }
	            return res;
	        };
	        var getRandomInScope = function getRandomInScope(min, max) {
	            return Math.floor(min + Math.random() * (max - min));
	        };
	        /* geoSereis =[
	                    {name:"黄浦区",value:1,date:222}
	                   ];*/
	        var geoSereis = ajaxDataSH.SHsereis; //后台请求回来的ajax数据值~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	        SHposition = ajaxDataSH.SHposition; //后台请求回来的ajax经纬度~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	        chartShanghai = echarts.init(document.getElementById("demo"));
	        var option = {
	            tooltip: {
	                trigger: 'item',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                hideDelay: 1000,
	                showDelay: 300,
	                enterable: true,
	                formatter: function formatter(v) {
	                    console.log(v.name);

	                    function dot() {
	                        var range = parseInt(v.data.value[2]);
	                        var typeP = null;
	                        var typeLabel = null;
	                        //这个就是hover点的ajax方法。
	                        var hoverName = v.name.toString();
	                        var numORdate = ajaxDataSH.SHhoverDot[hoverName];

	                        switch (range) {

	                            case 1:
	                                typeP = "曝光日期<span> " + numORdate + " </span>";typeLabel = "<label class='testLable black'>已出风险</label>";
	                                break;

	                            case 2:
	                                typeP = "风险值<span> " + numORdate + " </span>";typeLabel = "<label class='testLable yellow'>一般关注</label>";
	                                break;

	                            case 3:
	                                typeP = "风险值<span> " + numORdate + " </span>";typeLabel = "<label class='testLable yellow'>一般关注</label>";
	                                break;

	                            case 4:
	                                typeP = "风险值<span> " + numORdate + " </span>";typeLabel = "<label class='testLable red'>重点关注</label>";
	                                break;

	                        };
	                        var scatterTootip = "<div class='testTo'>\
	                                <h4>" + v.name + "</h4>" + typeLabel + "\
	                                <p class='testP'>" + typeP + "</p>\
	                         </div>";

	                        return scatterTootip;
	                    }

	                    function area() {
	                        var html = "";
	                        var hoverName = v.name.toString();
	                        var length = 0;
	                        // var length = ajaxDataSH.SHhoverArea[hoverName].companyName.length;
	                        if (ajaxDataSH.SHhoverArea[hoverName]) {
	                            ajaxDataSH.SHhoverArea[hoverName].companyName.map(function (item, index) {
	                                if (item != null) {

	                                    html += "<span>" + item + "</span>";
	                                    length += 1;
	                                }
	                            });
	                        }
	                        var mapTootip = "<div class='testTo'>\
	                                      <h4 class='tableH4'>" + v.name + "</h4>\
	                                      <table>\
	                                        <tbody>\
	                                          <tr>\
	                                            <td>检测企业数量</td>\
	                                            <td>" + length + "</td>\
	                                          </tr>\
	                                          <tr>\
	                                            <td>重点检测楼宇</td>\
	                                            <td>\
	                                              <div class='tip-scroll'>" + html + "</div>\
	                                            </td>\
	                                          </tr>\
	                                        </tbody>\
	                                      </table>\
	                        </div>";

	                        return mapTootip;
	                    }
	                    // 以下是区域的hoverAjax

	                    if (v.componentSubType == "map") {
	                        return area();
	                    } else if (v.componentSubType == "scatter") {
	                        return dot();
	                    }
	                }
	            },
	            visualMap: {
	                type: 'piecewise',
	                show: false,
	                itemWidth: "15",
	                right: "50",
	                bottom: "30",
	                padding: [0, 0, 20, 50],
	                text: ['高', '低'],
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                pieces: [{ value: 4, label: '123（自定义特殊颜色）', color: 'red' }, { value: 3, label: '123（自定义特殊颜色）', color: 'yellow' }, { value: 2, label: '123（自定义特殊颜色）', color: 'green' }, { value: 1, label: '123（自定义特殊颜色）', color: 'black' }, { value: 1000, label: '123（自定义特殊颜色）', color: '#246e86' }, { value: 500, label: '123（自定义特殊颜色）', color: '#72b3c7' }],
	                inRange: {
	                    color: ['red', "green"]
	                }
	            },
	            geo: {
	                map: 'shanghai',
	                label: {
	                    emphasis: {
	                        show: false
	                    }
	                },
	                roam: true,
	                itemStyle: {
	                    // normal: {
	                    //     areaColor: '#246e86',
	                    //     borderColor: '#fff',
	                    //     borderWidth:1
	                    // },
	                    // emphasis: {
	                    //     areaColor: '#72b3c7'
	                    // }
	                }
	            },
	            series: [{
	                name: '公司分布',
	                type: 'scatter',
	                coordinateSystem: 'geo',
	                symbolSize: 12,
	                label: {
	                    normal: {
	                        show: false
	                    },
	                    emphasis: {
	                        show: false
	                    }
	                },
	                itemStyle: {
	                    emphasis: {
	                        borderColor: '#fff',
	                        borderWidth: 1
	                    }
	                },
	                data: convertData(geoSereis)
	            }, {
	                type: 'map',
	                name: '',
	                map: 'shanghai',
	                roam: true,
	                animationDurationUpdate: 1000,
	                animationEasingUpdate: 'quinticInOut',
	                itemStyle: {
	                    normal: {
	                        label: {
	                            show: false
	                        },
	                        borderColor: '#a7d1df',
	                        areaColor: '#fff'
	                    },
	                    emphasis: {
	                        label: {
	                            show: false
	                        },
	                        areaColor: '#a7d1df',
	                        borderWidth: 0
	                    }
	                },
	                data: [{
	                    "name": "嘉定区",
	                    "value": 1000
	                }, {
	                    "name": "青浦区",
	                    "value": 1000
	                }, {
	                    "name": "松江区",
	                    "value": 1000
	                }, {
	                    "name": "金山区",
	                    "value": 1000
	                }, {
	                    "name": "崇明县",
	                    "value": 1000
	                }, {
	                    "name": "宝山区",
	                    "value": 1000
	                }, {
	                    "name": "杨浦区",
	                    "value": 1000
	                }, {
	                    "name": "徐汇区",
	                    "value": 1000
	                }, {
	                    "name": "长宁区",
	                    "value": 1000
	                }, {
	                    "name": "普陀区",
	                    "value": 1000
	                }, {
	                    "name": "静安区",
	                    "value": 1000
	                }, {
	                    "name": "黄浦区",
	                    "value": 500
	                }, {
	                    "name": "闸北区",
	                    "value": 1000
	                }, {
	                    "name": "闵行区",
	                    "value": 1000
	                }, {
	                    "name": "虹口区",
	                    "value": 500
	                }, {
	                    "name": "浦东新区",
	                    "value": 500
	                }, {
	                    "name": "奉贤区",
	                    "value": 1000
	                }]
	            }]
	        };
	        chartShanghai.setOption(option);
	        chartShanghai.on("click", function (v) {
	            console.log(v);
	            if (v.name == "浦东新区" || v.name == "黄浦区" || v.name == "虹口区") {
	                _this.props.history.push("/parkMonitor");
	            }
	            if (v.name == "普陀区" && v.seriesType == "scatter") {
	                _this.props.history.push("/InfoSearchIndex");
	            }
	        });
	        $(".realtime-top-middle").on("click", ".return", function () {
	            chartShanghai.dispose();
	            _this.mapChina();
	            $(".realtime-top-middle .info,.realtime-top-middle .return,.realtime-top-middle .bar").hide();
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var _this = this;
	        var isEqual = Immutable.is(nextProps.realTimeMapResult /*now*/, this.props.realTimeMapResult /*before*/); //判断数据是否变化
	        if (!isEqual) {
	            var realTimeMapRequest = nextProps.realTimeMapRequest;
	            var realTimeMapResult = nextProps.realTimeMapResult;

	            if (realTimeMapRequest == true) {
	                if (realTimeMapRequest == true) {
	                    ajaxDataChina = realTimeMapResult;
	                    // console.log(ajaxDataChina.content.SHData,"fuck u")
	                } else {
	                        alert(404);
	                    }
	            }
	        }

	        var isEqualSh = Immutable.is(nextProps.realTimeMapShResult, this.props.realTimeMapShResult); //判断数据是否变化
	        if (!isEqualSh) {
	            var realTimeMapShRequest = nextProps.realTimeMapShRequest;
	            var realTimeMapShResult = nextProps.realTimeMapShResult;

	            if (realTimeMapShRequest == true) {
	                if (realTimeMapShRequest == true) {
	                    //可以判断一下  如果echarts的实例存在的话，就不要去实例化了，这样就不会重新渲染。oh yeah。
	                    if (!chartChina) {
	                        _this.mapChina(); //只需要初始化一个，因为上海地图的实例化方法，已经包含在了mapChina里面了。
	                    }
	                    ajaxDataSH = realTimeMapShResult.content;
	                } else {
	                    alert(404);
	                }
	            }
	        }
	    },
	    componentDidMount: function componentDidMount() {
	        var _props = this.props;
	        var getRealTimeMap = _props.getRealTimeMap;
	        var getRealTimeMapSh = _props.getRealTimeMapSh; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	        var jsonData = {}; //ajax传递给后台的data键值对
	        getRealTimeMap(jsonData);
	        getRealTimeMapSh(jsonData);

	        $(window).resize(function (event) {
	            _this.state.mapeType == "china" ? this.mapChina() : this.mapShanghai();
	        }.bind(this));
	    },
	    componentDidUpdate: function componentDidUpdate(nextProps, nextState) {
	        // var convertData = function (data) {
	        //       var res = [];
	        //       for (var i = 0; i < data.length; i++) {
	        //           var geoCoord = SHposition[data[i].name];
	        //           if (geoCoord) {
	        //               res.push({
	        //                   name: data[i].name,
	        //                   value: geoCoord.concat(data[i].value)
	        //               });
	        //           }
	        //       }
	        //       return res;
	        // };
	        // var range = this.props.pushRange;
	        //   //这一块传值的时候，name是后台传的，value这个系数也是后台传过来。ps：也可以直接传递convertData处理过后的数组
	        // if (range != null && chartShanghai != undefined) {
	        //   if (range == 1) {
	        //       chartShanghai.setOption({
	        //             series:[
	        //               {
	        //                 data: convertData([
	        //                       {name:"中晋股权投资基金管理(上海)有限公司",value:1},
	        //                       {name:"融宜宝积家投资管理（北京）有限公司上海分公司",value:1},
	        //                       {name:"上海太宥恒资产管理有限公司",value:1},
	        //                       {name:"上海炳恒财富投资管理（集团）有限公司",value:1},
	        //                       {name:"上海长来资产管理有限公司",value:1}
	        //                      ])
	        //               }
	        //             ]
	        //           })
	        //   } else {
	        //           chartShanghai.setOption({
	        //             series:[
	        //               {
	        //                 data: convertData([
	        //                     {name:"黄浦区",value:this.props.pushRange},
	        //                     {name:"浦东新区",value:this.props.pushRange},
	        //                     {name:"徐汇区",value:this.props.pushRange,myName:"1243546"},
	        //                     {name:"长宁区",value:this.props.pushRange},
	        //                     {name:"静安区",value:this.props.pushRange},
	        //                     {name:"普陀区",value:this.props.pushRange},
	        //                     {name:"虹口区",value:this.props.pushRange},
	        //                     {name:"杨浦区",value:this.props.pushRange}
	        //                      ])
	        //               }
	        //             ]
	        //           })
	        //   }
	        // }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-top-middle' },
	            _react2.default.createElement('div', { id: 'demo' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'info' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'info-left' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'title' },
	                        '已监控企业数'
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'date' },
	                        '2016\\07\\01'
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'info-right' },
	                    '235,452'
	                )
	            ),
	            _react2.default.createElement(
	                'span',
	                { className: 'return mt-btn-red  ink-reaction' },
	                '辐射全国'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'bar' },
	                _react2.default.createElement('img', { src: 'images/wifi.png', alt: '' }),
	                _react2.default.createElement(
	                    'p',
	                    null,
	                    '截止2016年7月27日：收到举报信息：',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '865'
	                    ),
	                    '条;监测广告',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '465'
	                    ),
	                    '条; 打非',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '86'
	                    ),
	                    '家;互联网金融排查',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '125'
	                    ),
	                    '家'
	                )
	            )
	        );
	    }
	});

	//将state植入 到 props
	exports.default = TopMiddle;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topMiddle.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})