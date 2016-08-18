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

	//³éÀë³öÀ´µÄµØÍ¼ÊµÀý
	var chartChina, chartShanghai;
	//ÓÃÀ´±£´æajax·µ»ØµÄÊý¾Ý
	var ajaxData;
	//ÉÏº£µÄ¾­Î³¶È
	var SHposition = {
	    "»ÆÆÖÇø": [127.291193, 31.237373],
	    "ÆÖ¶«ÐÂÇø": [121.550543, 31.227391],
	    "Ðì»ãÇø": [121.42885, 31.594911],
	    "³¤ÄþÇø": [121.430868, 31.426536],
	    "¾²°²Çø": [121.453978, 31.234087],
	    "ÆÕÍÓÇø": [121.703529, 31.455102],
	    "ºç¿ÚÇø": [121.511735, 31.270146],
	    "ÑîÆÖÇø": [121.532291, 31.465779],
	    "ÖÐ½ú¹ÉÈ¨Í¶×Ê»ù½ð¹ÜÀí(ÉÏº£)ÓÐÏÞ¹«Ë¾": [121.675603, 31.281911],
	    "ÈÚÒË±¦»ý¼ÒÍ¶×Ê¹ÜÀí£¨±±¾©£©ÓÐÏÞ¹«Ë¾ÉÏº£·Ö¹«Ë¾": [121.473185, 31.234205],
	    "ÉÏº£Ì«å¶ºã×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾": [121.598223, 31.346895],
	    "ÉÏº£±þºã²Æ¸»Í¶×Ê¹ÜÀí£¨¼¯ÍÅ£©ÓÐÏÞ¹«Ë¾": [121.491339, 31.404468],
	    "ÉÏº£³¤À´×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾": [121.483775, 31.252063]
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
	        //ÖÐ¹úµãµÄ¾­Î³¶È
	        var geoCoordMap = {
	            'ÉÏº£': [121.4648, 31.2891],
	            '¶«Ý¸': [113.8953, 22.901],
	            '¶«Óª': [118.7073, 37.5513],
	            'ÖÐÉ½': [113.4229, 22.478],
	            'ÁÙ·Ú': [111.4783, 36.1615],
	            'ÁÙÒÊ': [118.3118, 35.2936],
	            'µ¤¶«': [124.541, 40.4242],
	            'ÀöË®': [119.5642, 28.1854],
	            'ÎÚÂ³Ä¾Æë': [87.9236, 43.5883],
	            '·ðÉ½': [112.8955, 23.1097],
	            '±£¶¨': [115.0488, 39.0948],
	            'À¼ÖÝ': [103.5901, 36.3043],
	            '°üÍ·': [110.3467, 41.4899],
	            '±±¾©': [116.4551, 40.2539],
	            '±±º£': [109.314, 21.6211],
	            'ÄÏ¾©': [118.8062, 31.9208],
	            'ÄÏÄþ': [108.479, 23.1152],
	            'ÄÏ²ý': [116.0046, 28.6633],
	            'ÄÏÍ¨': [121.1023, 32.1625],
	            'ÏÃÃÅ': [118.1689, 24.6478],
	            'Ì¨ÖÝ': [121.1353, 28.6688],
	            'ºÏ·Ê': [117.29, 32.0581],
	            'ºôºÍºÆÌØ': [111.4124, 40.4901],
	            'ÏÌÑô': [108.4131, 34.8706],
	            '¹þ¶û±õ': [127.9688, 45.368],
	            'ÌÆÉ½': [118.4766, 39.6826],
	            '¼ÎÐË': [120.9155, 30.6354],
	            '´óÍ¬': [113.7854, 39.8035],
	            '´óÁ¬': [122.2229, 39.4409],
	            'Ìì½ò': [117.4219, 39.4189],
	            'Ì«Ô­': [112.3352, 37.9413],
	            'Íþº£': [121.9482, 37.1393],
	            'Äþ²¨': [121.5967, 29.6466],
	            '±¦¼¦': [107.1826, 34.3433],
	            'ËÞÇ¨': [118.5535, 33.7775],
	            '³£ÖÝ': [119.4543, 31.5582],
	            '¹ãÖÝ': [113.5107, 23.2196],
	            'ÀÈ·»': [116.521, 39.0509],
	            'ÑÓ°²': [109.1052, 36.4252],
	            'ÕÅ¼Ò¿Ú': [115.1477, 40.8527],
	            'ÐìÖÝ': [117.5208, 34.3268],
	            'µÂÖÝ': [116.6858, 37.2107],
	            '»ÝÖÝ': [114.6204, 23.1647],
	            '³É¶¼': [103.9526, 30.7617],
	            'ÑïÖÝ': [119.4653, 32.8162],
	            '³ÐµÂ': [117.5757, 41.4075],
	            'À­Èø': [91.1865, 30.1465],
	            'ÎÞÎý': [120.3442, 31.5527],
	            'ÈÕÕÕ': [119.2786, 35.5023],
	            'À¥Ã÷': [102.9199, 25.4663],
	            'º¼ÖÝ': [119.5313, 29.8773],
	            'Ôæ×¯': [117.323, 34.8926],
	            'ÁøÖÝ': [109.3799, 24.9774],
	            'ÖêÖÞ': [113.5327, 27.0319],
	            'Îäºº': [114.3896, 30.6628],
	            'ÉÇÍ·': [117.1692, 23.3405],
	            '½­ÃÅ': [112.6318, 22.1484],
	            'ÉòÑô': [123.1238, 42.1216],
	            '²×ÖÝ': [116.8286, 38.2104],
	            'ºÓÔ´': [114.917, 23.9722],
	            'ÈªÖÝ': [118.3228, 25.1147],
	            'Ì©°²': [117.0264, 36.0516],
	            'Ì©ÖÝ': [120.0586, 32.5525],
	            '¼ÃÄÏ': [117.1582, 36.8701],
	            '¼ÃÄþ': [116.8286, 35.3375],
	            'º£¿Ú': [110.3893, 19.8516],
	            '×Í²©': [118.0371, 36.6064],
	            '»´°²': [118.927, 33.4039],
	            'ÉîÛÚ': [114.5435, 22.5439],
	            'ÇåÔ¶': [112.9175, 24.3292],
	            'ÎÂÖÝ': [120.498, 27.8119],
	            'Î¼ÄÏ': [109.7864, 35.0299],
	            'ºþÖÝ': [119.8608, 30.7782],
	            'ÏæÌ¶': [112.5439, 27.7075],
	            '±õÖÝ': [117.8174, 37.4963],
	            'Î«·»': [119.0918, 36.524],
	            'ÑÌÌ¨': [120.7397, 37.5128],
	            'ÓñÏª': [101.9312, 23.8898],
	            'Öéº£': [113.7305, 22.1155],
	            'ÑÎ³Ç': [120.2234, 33.5577],
	            'ÅÌ½õ': [121.9482, 41.0449],
	            'Ê¯¼Ò×¯': [114.4995, 38.1006],
	            '¸£ÖÝ': [119.4543, 25.9222],
	            'ÇØ»Êµº': [119.2126, 40.0232],
	            'ÉÜÐË': [120.564, 29.7565],
	            'ÁÄ³Ç': [115.9167, 36.4032],
	            'ÕØÇì': [112.1265, 23.5822],
	            'ÖÛÉ½': [122.2559, 30.2234],
	            'ËÕÖÝ': [120.6519, 31.3989],
	            'À³Îß': [117.6526, 36.2714],
	            'ºÊÔó': [115.6201, 35.2057],
	            'Óª¿Ú': [122.4316, 40.4297],
	            'ºùÂ«µº': [120.1575, 40.578],
	            'ºâË®': [115.8838, 37.7161],
	            'áéÖÝ': [118.6853, 28.8666],
	            'Î÷Äþ': [101.4038, 36.8207],
	            'Î÷°²': [109.1162, 34.2004],
	            '¹óÑô': [106.6992, 26.7682],
	            'Á¬ÔÆ¸Û': [119.1248, 34.552],
	            'ÐÏÌ¨': [114.8071, 37.2821],
	            'ºªµ¦': [114.4775, 36.535],
	            'Ö£ÖÝ': [113.4668, 34.6234],
	            '¶õ¶û¶àË¹': [108.9734, 39.2487],
	            'ÖØÇì': [107.7539, 30.1904],
	            '½ð»ª': [120.0037, 29.1028],
	            'Í­´¨': [109.0393, 35.1947],
	            'Òø´¨': [106.3586, 38.1775],
	            'Õò½­': [119.4763, 31.9702],
	            '³¤´º': [125.8154, 44.2584],
	            '³¤É³': [113.0823, 28.2568],
	            '³¤ÖÎ': [112.8625, 36.4746],
	            'ÑôÈª': [113.4778, 38.0951],
	            'Çàµº': [120.4651, 36.3373],
	            'ÉØ¹Ø': [113.7964, 24.7028]
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
	        [{ name: '°üÍ·', value: 95 }, { name: 'ÉÏº£' }], [{ name: 'À¥Ã÷', value: 90 }, { name: 'ÉÏº£' }], [{ name: '¹ãÖÝ', value: 80 }, { name: 'ÉÏº£' }], [{ name: 'Ö£ÖÝ', value: 70 }, { name: 'ÉÏº£' }], [{ name: '³¤´º', value: 60 }, { name: 'ÉÏº£' }], [{ name: 'ÖØÇì', value: 50 }, { name: 'ÉÏº£' }], [{ name: '³¤É³', value: 40 }, { name: 'ÉÏº£' }], [{ name: '±±¾©', value: 30 }, { name: 'ÉÏº£' }], [{ name: 'µ¤¶«', value: 20 }, { name: 'ÉÏº£' }], [{ name: '´óÁ¬', value: 10 }, { name: 'ÉÏº£' }]];
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
	            series: [{ //Ïß
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
	            }, { //ÏßÉÏÒÆ¶¯µÄÍ¼±ê
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
	            }, { //Ô²µã
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
	            }, { //Ô²µã
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
	                    name: "ÉÏº£",
	                    value: [121.4648, 31.2891, 40]
	                }]
	            }]
	        };
	        chartChina.setOption(option);
	        chartChina.on("click", function (params) {
	            console.log(params);
	            if (params.componentSubType == "effectScatter" && params.name == "ÉÏº£") {
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
	        var geoSereis = [{ name: "»ÆÆÖÇø", value: 1 }, { name: "ÆÖ¶«ÐÂÇø", value: 2 }, { name: "Ðì»ãÇø", value: 3 }, { name: "³¤ÄþÇø", value: 4 }, { name: "¾²°²Çø", value: 1 }, { name: "ÆÕÍÓÇø", value: getRandomInScope(1, 5) }, { name: "ºç¿ÚÇø", value: getRandomInScope(1, 5) }, { name: "ÑîÆÖÇø", value: getRandomInScope(1, 5) }, { name: "ÖÐ½ú¹ÉÈ¨Í¶×Ê»ù½ð¹ÜÀí(ÉÏº£)ÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÈÚÒË±¦»ý¼ÒÍ¶×Ê¹ÜÀí£¨±±¾©£©ÓÐÏÞ¹«Ë¾ÉÏº£·Ö¹«Ë¾", value: 1 }, { name: "ÉÏº£Ì«å¶ºã×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÉÏº£±þºã²Æ¸»Í¶×Ê¹ÜÀí£¨¼¯ÍÅ£©ÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÉÏº£³¤À´×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾", value: 1 }];
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
	                    //ÖÁÓÚscatterµÄ²»Í¬ÀàÐÍµÄp¡£¾Í×îºóÓÃobject[¡°¹«Ë¾Ãû¡±]µ¥¶À´ÓÒ»¸öajax¶ÔÏóÀïÃæÈ¡ÁË¡£
	                    console.log(v);
	                    var range = v.value[2];
	                    var typeP = null;
	                    var typeLabel = null;
	                    switch (range) {

	                        case 1:
	                            typeP = "ÆØ¹âÈÕÆÚ<span> 43 </span>";typeLabel = "<label class='testLable black'>ÒÑ³ö·çÏÕ</label>";
	                            break;

	                        case 2:
	                            typeP = "";typeLabel = "<label class='testLable green'>Õý³£</label>";
	                            break;

	                        case 3:
	                            typeP = "·çÏÕÖµ<span> 43 </span>";typeLabel = "<label class='testLable yellow'>Ò»°ã¹Ø×¢</label>";
	                            break;

	                        case 4:
	                            typeP = "·çÏÕÖµ<span> 43 </span>";typeLabel = "<label class='testLable red'>ÖØµã¹Ø×¢</label>";
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
	                                        <td>¼ì²âÆóÒµÊýÁ¿</td>\
	                                        <td>321</td>\
	                                      </tr>\
	                                      <tr>\
	                                        <td>ÖØµã¼ì²âÂ¥Óî<br>(5)</td>\
	                                        <td>\
	                                          <div class='tip-scroll'>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
	                                          <span>¹ú¼Ò¿ª·¢ÓªÑø</span>\
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
	                text: ['¸ß', 'µÍ'],
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                pieces: [{ value: 4, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: 'red' }, { value: 3, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: 'yellow' }, { value: 2, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: 'green' }, { value: 1, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: 'black' }, { value: 1000, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: '#246e86' }, { value: 500, label: '123£¨×Ô¶¨ÒåÌØÊâÑÕÉ«£©', color: '#72b3c7' }],
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
	                name: '¹«Ë¾·Ö²¼',
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
	                    "name": "¼Î¶¨Çø",
	                    "value": 1000
	                }, {
	                    "name": "ÇàÆÖÇø",
	                    "value": 1000
	                }, {
	                    "name": "ËÉ½­Çø",
	                    "value": 1000
	                }, {
	                    "name": "½ðÉ½Çø",
	                    "value": 1000
	                }, {
	                    "name": "³çÃ÷ÏØ",
	                    "value": 1000
	                }, {
	                    "name": "±¦É½Çø",
	                    "value": 1000
	                }, {
	                    "name": "ÑîÆÖÇø",
	                    "value": 1000
	                }, {
	                    "name": "Ðì»ãÇø",
	                    "value": 1000
	                }, {
	                    "name": "³¤ÄþÇø",
	                    "value": 1000
	                }, {
	                    "name": "ÆÕÍÓÇø",
	                    "value": 1000
	                }, {
	                    "name": "¾²°²Çø",
	                    "value": 1000
	                }, {
	                    "name": "»ÆÆÖÇø",
	                    "value": 500
	                }, {
	                    "name": "Õ¢±±Çø",
	                    "value": 1000
	                }, {
	                    "name": "ãÉÐÐÇø",
	                    "value": 1000
	                }, {
	                    "name": "ºç¿ÚÇø",
	                    "value": 500
	                }, {
	                    "name": "ÆÖ¶«ÐÂÇø",
	                    "value": 500
	                }, {
	                    "name": "·îÏÍÇø",
	                    "value": 1000
	                }]
	            }]
	        };
	        chartShanghai.setOption(option);
	        chartShanghai.on("click", function (v) {
	            console.log(v);
	            if (v.name == "ÆÖ¶«ÐÂÇø" || v.name == "»ÆÆÖÇø" || v.name == "ºç¿ÚÇø") {
	                _this.props.history.push("/parkMonitor");
	            }
	            if (v.name == "ÆÕÍÓÇø" && v.seriesType == "scatter") {
	                _this.props.history.push("/InfoSearchIndex");
	            }
	        });
	        $(".realtime-top-middle").on("click", ".return", function () {
	            chartShanghai.dispose();
	            _this.mapChina();
	            $(".realtime-top-middle .info,.realtime-top-middle .return,.realtime-top-middle .bar").hide();
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getRealTimeMap = this.props.getRealTimeMap; // È¡µ½propsÀïÃæµÄgetRealTimeTable·½·¨¡£Ò²¿ÉÒÔËµÊÇÇëÇóaction

	        var jsonData = {}; //ajax´«µÝ¸øºóÌ¨µÄdata¼üÖµ¶Ô
	        getRealTimeMap(jsonData);

	        $(window).resize(function (event) {
	            // _this.state.mapeType == "china"?this.mapChina():this.mapShanghai();
	        }.bind(this));
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.realTimeMapRequest, this.props.realTimeMapResult); //ÅÐ¶ÏÊý¾ÝÊÇ·ñ±ä»¯
	        if (!isEqual) {
	            var realTimeMapRequest = nextProps.realTimeMapRequest;
	            var realTimeMapResult = nextProps.realTimeMapResult;

	            if (realTimeMapRequest == true) {
	                if (realTimeMapRequest == true) {
	                    ajaxData = realTimeMapResult;
	                    debugger;
	                    alert("map");
	                } else {
	                    alert(404);
	                }
	            }
	        }
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
	        //ÕâÒ»¿é´«ÖµµÄÊ±ºò£¬nameÊÇºóÌ¨´«µÄ£¬valueÕâ¸öÏµÊýÒ²ÊÇºóÌ¨´«¹ýÀ´¡£ps£ºÒ²¿ÉÒÔÖ±½Ó´«µÝconvertData´¦Àí¹ýºóµÄÊý×é
	        if (range != null && chartShanghai != undefined) {
	            if (range == 1) {
	                chartShanghai.setOption({
	                    series: [{
	                        data: convertData([{ name: "ÖÐ½ú¹ÉÈ¨Í¶×Ê»ù½ð¹ÜÀí(ÉÏº£)ÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÈÚÒË±¦»ý¼ÒÍ¶×Ê¹ÜÀí£¨±±¾©£©ÓÐÏÞ¹«Ë¾ÉÏº£·Ö¹«Ë¾", value: 1 }, { name: "ÉÏº£Ì«å¶ºã×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÉÏº£±þºã²Æ¸»Í¶×Ê¹ÜÀí£¨¼¯ÍÅ£©ÓÐÏÞ¹«Ë¾", value: 1 }, { name: "ÉÏº£³¤À´×Ê²ú¹ÜÀíÓÐÏÞ¹«Ë¾", value: 1 }])
	                    }]
	                });
	            } else {
	                chartShanghai.setOption({
	                    series: [{
	                        data: convertData([{ name: "»ÆÆÖÇø", value: this.props.pushRange }, { name: "ÆÖ¶«ÐÂÇø", value: this.props.pushRange }, { name: "Ðì»ãÇø", value: this.props.pushRange, myName: "1243546" }, { name: "³¤ÄþÇø", value: this.props.pushRange }, { name: "¾²°²Çø", value: this.props.pushRange }, { name: "ÆÕÍÓÇø", value: this.props.pushRange }, { name: "ºç¿ÚÇø", value: this.props.pushRange }, { name: "ÑîÆÖÇø", value: this.props.pushRange }])
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
	                        'ÒÑ¼à¿ØÆóÒµÊý'
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
	                '·øÉäÈ«¹ú'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'bar' },
	                _react2.default.createElement('img', { src: 'images/wifi.png', alt: '' }),
	                _react2.default.createElement(
	                    'p',
	                    null,
	                    '½ØÖ¹2016Äê7ÔÂ27ÈÕ£ºÊÕµ½¾Ù±¨ÐÅÏ¢£º',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '865'
	                    ),
	                    'Ìõ;¼à²â¹ã¸æ',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '465'
	                    ),
	                    'Ìõ; ´ò·Ç',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '86'
	                    ),
	                    '¼Ò;»¥ÁªÍø½ðÈÚÅÅ²é',
	                    _react2.default.createElement(
	                        'span',
	                        { className: 'darkRed' },
	                        '125'
	                    ),
	                    '¼Ò'
	                )
	            )
	        );
	    }
	});

	//½«stateÖ²Èë µ½ props
	exports.default = TopMiddle;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topMiddle.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})