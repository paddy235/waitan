webpackHotUpdate(0,{

/***/ 955:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(952);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	//���������ĵ�ͼʵ��
	var chartChina, chartShanghai;
	//��������ajax���ص�����
	var ajaxData;
	//�Ϻ��ľ�γ��
	var SHposition = {
	    "������": [127.291193, 31.237373],
	    "�ֶ�����": [121.550543, 31.227391],
	    "������": [121.42885, 31.594911],
	    "������": [121.430868, 31.426536],
	    "������": [121.453978, 31.234087],
	    "������": [121.703529, 31.455102],
	    "������": [121.511735, 31.270146],
	    "������": [121.532291, 31.465779],
	    "�н���ȨͶ�ʻ�������(�Ϻ�)���޹�˾": [121.675603, 31.281911],
	    "���˱�����Ͷ�ʹ��������������޹�˾�Ϻ��ֹ�˾": [121.473185, 31.234205],
	    "�Ϻ�̫嶺��ʲ��������޹�˾": [121.598223, 31.346895],
	    "�Ϻ������Ƹ�Ͷ�ʹ��������ţ����޹�˾": [121.491339, 31.404468],
	    "�Ϻ������ʲ��������޹�˾": [121.483775, 31.252063]
	};
	var TopMiddle = _react2.default.createClass({
	    displayName: 'TopMiddle',
	    getInitialState: function getInitialState() {
	        return {
	            mapeType: "china"
	        };
	    },
	    mapChina: function mapChina() {
	        var _this = this;
	        //�й����ľ�γ��
	        var geoCoordMap = {
	            '�Ϻ�': [121.4648, 31.2891],
	            '��ݸ': [113.8953, 22.901],
	            '��Ӫ': [118.7073, 37.5513],
	            '��ɽ': [113.4229, 22.478],
	            '�ٷ�': [111.4783, 36.1615],
	            '����': [118.3118, 35.2936],
	            '����': [124.541, 40.4242],
	            '��ˮ': [119.5642, 28.1854],
	            '��³ľ��': [87.9236, 43.5883],
	            '��ɽ': [112.8955, 23.1097],
	            '����': [115.0488, 39.0948],
	            '����': [103.5901, 36.3043],
	            '��ͷ': [110.3467, 41.4899],
	            '����': [116.4551, 40.2539],
	            '����': [109.314, 21.6211],
	            '�Ͼ�': [118.8062, 31.9208],
	            '����': [108.479, 23.1152],
	            '�ϲ�': [116.0046, 28.6633],
	            '��ͨ': [121.1023, 32.1625],
	            '����': [118.1689, 24.6478],
	            '̨��': [121.1353, 28.6688],
	            '�Ϸ�': [117.29, 32.0581],
	            '���ͺ���': [111.4124, 40.4901],
	            '����': [108.4131, 34.8706],
	            '������': [127.9688, 45.368],
	            '��ɽ': [118.4766, 39.6826],
	            '����': [120.9155, 30.6354],
	            '��ͬ': [113.7854, 39.8035],
	            '����': [122.2229, 39.4409],
	            '����': [117.4219, 39.4189],
	            '̫ԭ': [112.3352, 37.9413],
	            '����': [121.9482, 37.1393],
	            '����': [121.5967, 29.6466],
	            '����': [107.1826, 34.3433],
	            '��Ǩ': [118.5535, 33.7775],
	            '����': [119.4543, 31.5582],
	            '����': [113.5107, 23.2196],
	            '�ȷ�': [116.521, 39.0509],
	            '�Ӱ�': [109.1052, 36.4252],
	            '�żҿ�': [115.1477, 40.8527],
	            '����': [117.5208, 34.3268],
	            '����': [116.6858, 37.2107],
	            '����': [114.6204, 23.1647],
	            '�ɶ�': [103.9526, 30.7617],
	            '����': [119.4653, 32.8162],
	            '�е�': [117.5757, 41.4075],
	            '����': [91.1865, 30.1465],
	            '����': [120.3442, 31.5527],
	            '����': [119.2786, 35.5023],
	            '����': [102.9199, 25.4663],
	            '����': [119.5313, 29.8773],
	            '��ׯ': [117.323, 34.8926],
	            '����': [109.3799, 24.9774],
	            '����': [113.5327, 27.0319],
	            '�人': [114.3896, 30.6628],
	            '��ͷ': [117.1692, 23.3405],
	            '����': [112.6318, 22.1484],
	            '����': [123.1238, 42.1216],
	            '����': [116.8286, 38.2104],
	            '��Դ': [114.917, 23.9722],
	            'Ȫ��': [118.3228, 25.1147],
	            '̩��': [117.0264, 36.0516],
	            '̩��': [120.0586, 32.5525],
	            '����': [117.1582, 36.8701],
	            '����': [116.8286, 35.3375],
	            '����': [110.3893, 19.8516],
	            '�Ͳ�': [118.0371, 36.6064],
	            '����': [118.927, 33.4039],
	            '����': [114.5435, 22.5439],
	            '��Զ': [112.9175, 24.3292],
	            '����': [120.498, 27.8119],
	            'μ��': [109.7864, 35.0299],
	            '����': [119.8608, 30.7782],
	            '��̶': [112.5439, 27.7075],
	            '����': [117.8174, 37.4963],
	            'Ϋ��': [119.0918, 36.524],
	            '��̨': [120.7397, 37.5128],
	            '��Ϫ': [101.9312, 23.8898],
	            '�麣': [113.7305, 22.1155],
	            '�γ�': [120.2234, 33.5577],
	            '�̽�': [121.9482, 41.0449],
	            'ʯ��ׯ': [114.4995, 38.1006],
	            '����': [119.4543, 25.9222],
	            '�ػʵ�': [119.2126, 40.0232],
	            '����': [120.564, 29.7565],
	            '�ĳ�': [115.9167, 36.4032],
	            '����': [112.1265, 23.5822],
	            '��ɽ': [122.2559, 30.2234],
	            '����': [120.6519, 31.3989],
	            '����': [117.6526, 36.2714],
	            '����': [115.6201, 35.2057],
	            'Ӫ��': [122.4316, 40.4297],
	            '��«��': [120.1575, 40.578],
	            '��ˮ': [115.8838, 37.7161],
	            '����': [118.6853, 28.8666],
	            '����': [101.4038, 36.8207],
	            '����': [109.1162, 34.2004],
	            '����': [106.6992, 26.7682],
	            '���Ƹ�': [119.1248, 34.552],
	            '��̨': [114.8071, 37.2821],
	            '����': [114.4775, 36.535],
	            '֣��': [113.4668, 34.6234],
	            '������˹': [108.9734, 39.2487],
	            '����': [107.7539, 30.1904],
	            '����': [120.0037, 29.1028],
	            'ͭ��': [109.0393, 35.1947],
	            '����': [106.3586, 38.1775],
	            '����': [119.4763, 31.9702],
	            '����': [125.8154, 44.2584],
	            '��ɳ': [113.0823, 28.2568],
	            '����': [112.8625, 36.4746],
	            '��Ȫ': [113.4778, 38.0951],
	            '�ൺ': [120.4651, 36.3373],
	            '�ع�': [113.7964, 24.7028]
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
	        var SHData = [//ajax
	        [{ name: '��ͷ', value: 95 }, { name: '�Ϻ�' }], [{ name: '����', value: 90 }, { name: '�Ϻ�' }], [{ name: '����', value: 80 }, { name: '�Ϻ�' }], [{ name: '֣��', value: 70 }, { name: '�Ϻ�' }], [{ name: '����', value: 60 }, { name: '�Ϻ�' }], [{ name: '����', value: 50 }, { name: '�Ϻ�' }], [{ name: '��ɳ', value: 40 }, { name: '�Ϻ�' }], [{ name: '����', value: 30 }, { name: '�Ϻ�' }], [{ name: '����', value: 20 }, { name: '�Ϻ�' }], [{ name: '����', value: 10 }, { name: '�Ϻ�' }]];
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
	            series: [{ //��
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
	            }, { //�����ƶ���ͼ��
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
	            }, { //Բ��
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
	                    return val[2] / 8;
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
	            }, { //Բ��
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
	                    name: "�Ϻ�",
	                    value: [121.4648, 31.2891, 40]
	                }]
	            }]
	        };
	        chartChina.setOption(option);
	        chartChina.on("click", function (params) {
	            console.log(params);
	            if (params.componentSubType == "effectScatter" && params.name == "�Ϻ�") {
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
	        var geoSereis = [{ name: "������", value: 1 }, { name: "�ֶ�����", value: 2 }, { name: "������", value: 3 }, { name: "������", value: 4 }, { name: "������", value: 1 }, { name: "������", value: getRandomInScope(1, 5) }, { name: "������", value: getRandomInScope(1, 5) }, { name: "������", value: getRandomInScope(1, 5) }, { name: "�н���ȨͶ�ʻ�������(�Ϻ�)���޹�˾", value: 1 }, { name: "���˱�����Ͷ�ʹ��������������޹�˾�Ϻ��ֹ�˾", value: 1 }, { name: "�Ϻ�̫嶺��ʲ��������޹�˾", value: 1 }, { name: "�Ϻ������Ƹ�Ͷ�ʹ��������ţ����޹�˾", value: 1 }, { name: "�Ϻ������ʲ��������޹�˾", value: 1 }];
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
	                    //����scatter�Ĳ�ͬ���͵�p����������object[����˾����]������һ��ajax��������ȡ�ˡ�
	                    console.log(v);
	                    var range = v.value[2];
	                    var typeP = null;
	                    var typeLabel = null;
	                    switch (range) {

	                        case 1:
	                            typeP = "�ع�����<span> 43 </span>";typeLabel = "<label class='testLable black'>�ѳ�����</label>";
	                            break;

	                        case 2:
	                            typeP = "";typeLabel = "<label class='testLable green'>����</label>";
	                            break;

	                        case 3:
	                            typeP = "����ֵ<span> 43 </span>";typeLabel = "<label class='testLable yellow'>һ����ע</label>";
	                            break;

	                        case 4:
	                            typeP = "����ֵ<span> 43 </span>";typeLabel = "<label class='testLable red'>�ص���ע</label>";
	                            break;

	                    };
	                    var scatterTootip = "<div class='testTo'>\
	                            <h4>" + v.name + "</h4>" + typeLabel + "\
	                            <p class='testP'>" + typeP + "</p>\
	                     </div>";
	                    var mapTootip = "<div class='testTo'>\
	                                  <h4 class='tableH4'>" + v.name + "</h4>\
	                                  <table>\
	                                    <tbody>\
	                                      <tr>\
	                                        <td>������ҵ����</td>\
	                                        <td>321</td>\
	                                      </tr>\
	                                      <tr>\
	                                        <td>�ص�����¥��<br>(5)</td>\
	                                        <td>\
	                                          <div class='tip-scroll'>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          <span>���ҿ���Ӫ��</span>\
	                                          </div>\
	                                        </td>\
	                                      </tr>\
	                                    </tbody>\
	                                  </table>\
	                      </div>";
	                    if (v.componentSubType == "map") {
	                        return mapTootip;
	                    } else if (v.componentSubType == "scatter") {
	                        return scatterTootip;
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
	                text: ['��', '��'],
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                pieces: [{ value: 4, label: '123���Զ���������ɫ��', color: 'red' }, { value: 3, label: '123���Զ���������ɫ��', color: 'yellow' }, { value: 2, label: '123���Զ���������ɫ��', color: 'green' }, { value: 1, label: '123���Զ���������ɫ��', color: 'black' }, { value: 1000, label: '123���Զ���������ɫ��', color: '#246e86' }, { value: 500, label: '123���Զ���������ɫ��', color: '#72b3c7' }],
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
	                name: '��˾�ֲ�',
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
	                    "name": "�ζ���",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "�ɽ���",
	                    "value": 1000
	                }, {
	                    "name": "��ɽ��",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "��ɽ��",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 500
	                }, {
	                    "name": "բ����",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }, {
	                    "name": "������",
	                    "value": 500
	                }, {
	                    "name": "�ֶ�����",
	                    "value": 500
	                }, {
	                    "name": "������",
	                    "value": 1000
	                }]
	            }]
	        };
	        chartShanghai.setOption(option);
	        chartShanghai.on("click", function (v) {
	            console.log(v);
	            if (v.name == "�ֶ�����" || v.name == "������" || v.name == "������") {
	                _this.props.history.push("/parkMonitor");
	            }
	            if (v.name == "������" && v.seriesType == "scatter") {
	                _this.props.history.push("/InfoSearchIndex");
	            }
	        });
	        $(".realtime-top-middle").on("click", ".return", function () {
	            chartShanghai.dispose();
	            _this.mapChina();
	            $(".realtime-top-middle .info,.realtime-top-middle .return,.realtime-top-middle .bar").hide();
	        });
	    },

	    // componentDidMount() {

	    //   const {getRealTimeMap}=this.props;// ȡ��props������getRealTimeTable������Ҳ����˵������action
	    //   var jsonData={};//ajax���ݸ���̨��data��ֵ��
	    //   getRealTimeMap(jsonData);

	    //   $(window).resize(function(event) {
	    //     // _this.state.mapeType == "china"?this.mapChina():this.mapShanghai();
	    //   }.bind(this));

	    // },
	    // componentWillReceiveProps(nextProps) {
	    //     var isEqual=Immutable.is(nextProps.realTimeMapRequest, this.props.realTimeMapResult)//�ж������Ƿ��仯
	    //     if(!isEqual){
	    //      const {realTimeMapRequest,realTimeMapResult}=nextProps;
	    //      if(realTimeMapRequest==true){
	    //         if(realTimeMapRequest==true){
	    //             ajaxData = realTimeMapResult;
	    //             alert("map")
	    //         }else{
	    //             alert(404)
	    //         }
	    //     }
	    //   }
	    // },
	    componentDidMount: function componentDidMount() {
	        this.mapChina();
	    },
	    componentDidUpdate: function componentDidUpdate(nextProps, nextState) {
	        var convertData = function convertData(data) {
	            var res = [];
	            for (var i = 0; i < data.length; i++) {
	                var geoCoord = SHposition[data[i].name];
	                if (geoCoord) {
	                    res.push({
	                        name: data[i].name,
	                        value: geoCoord.concat(data[i].value)
	                    });
	                }
	            }
	            return res;
	        };
	        var range = this.props.pushRange;
	        //��һ�鴫ֵ��ʱ����name�Ǻ�̨���ģ�value����ϵ��Ҳ�Ǻ�̨��������ps��Ҳ����ֱ�Ӵ���convertData��������������
	        if (range != null && chartShanghai != undefined) {
	            if (range == 1) {
	                chartShanghai.setOption({
	                    series: [{
	                        data: convertData([{ name: "�н���ȨͶ�ʻ�������(�Ϻ�)���޹�˾", value: 1 }, { name: "���˱�����Ͷ�ʹ��������������޹�˾�Ϻ��ֹ�˾", value: 1 }, { name: "�Ϻ�̫嶺��ʲ��������޹�˾", value: 1 }, { name: "�Ϻ������Ƹ�Ͷ�ʹ��������ţ����޹�˾", value: 1 }, { name: "�Ϻ������ʲ��������޹�˾", value: 1 }])
	                    }]
	                });
	            } else {
	                chartShanghai.setOption({
	                    series: [{
	                        data: convertData([{ name: "������", value: this.props.pushRange }, { name: "�ֶ�����", value: this.props.pushRange }, { name: "������", value: this.props.pushRange, myName: "1243546" }, { name: "������", value: this.props.pushRange }, { name: "������", value: this.props.pushRange }, { name: "������", value: this.props.pushRange }, { name: "������", value: this.props.pushRange }, { name: "������", value: this.props.pushRange }])
	                    }]
	                });
	            }
	        }
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
	                        '�Ѽ�����ҵ��'
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
	                '����ȫ��'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'bar' },
	                _react2.default.createElement('img', { src: 'images/wifi.png', alt: '' }),
	                _react2.default.createElement(
	                    'p',
	                    null,
	                    '��ֹ2016��7��27�գ��յ��ٱ���Ϣ��',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '865'
	                    ),
	                    '��;��������',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '465'
	                    ),
	                    '��; ����',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '86'
	                    ),
	                    '��;�����������Ų�',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '125'
	                    ),
	                    '��'
	                )
	            )
	        );
	    }
	});

	exports.default = TopMiddle;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topMiddle.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})