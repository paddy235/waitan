webpackHotUpdate(0,{

/***/ 962:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718); /**
	                                       * 招聘人员分布
	                                       */

	var data;
	var series = [{
	    "name": "11制造业",
	    "value": 18
	}, {
	    "name": "信息传输软件",
	    "value": 15
	}, {
	    "name": "信息技术服务业",
	    "value": 23
	}, {
	    "name": "商务服务业",
	    "value": 28
	}, {
	    "name": "其他",
	    "value": 16
	}];
	var PersonIndexChart = _react2.default.createClass({
	    displayName: 'PersonIndexChart',
	    getInitialState: function getInitialState() {
	        return {
	            chart: null
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var _this = this;
	        if (nextProps.CompanyInfoD2Request) {
	            data = nextProps.CompanyInfoD2Result.content.rdata;
	            // data.map(function(item,index){
	            //     xDate.push(item.x_value);
	            //     series.push(item.y_value);
	            // });
	            this.setState({
	                chart: _react2.default.createElement(_BasePie2.default, { option: this.setParm(), style: { height: '100%', width: '100%' } })
	            });
	            console.log(data, "第2个图");
	        }
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyInfoD2 = this.props.getCompanyInfoD2; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	        var jsonData = {
	            company: "四川环福置地有限公司"
	        }; //ajax传递给后台的data键值对
	        getCompanyInfoD2(jsonData);
	    },

	    setParm: function setParm() {
	        var option = {
	            "color": ["#F98D2B", "#FFDB03", "#04B4EF", "#0479FC", "#10A8AB"],
	            "title": "招聘人员分布",
	            "titleLeft": 250,
	            "titleTop": 20,
	            "xtitle": "",
	            "titleWeight": "bold",
	            "legend": ["11制造业", "信息传输软件", "信息技术服务业", "商务服务业", "其他"],
	            "legendShow": true,
	            "legendOrient": "vertical",
	            "legendLeft": "5%",
	            "legendTop": 100,
	            "legendItemGap": 30,
	            "seriesName": "企业数",
	            "radius": ["40%", "85%"],
	            "roseType": "area",
	            "lable": {
	                normal: {
	                    show: true,
	                    position: 'inner',
	                    formatter: '{d}%'
	                },
	                emphasis: { show: false }
	            },
	            "center": ['55%', '55%'],
	            "series": series
	        };
	        return option;
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { id: 'person-index' },
	            this.state.chart
	        );
	    }
	});
	exports.default = PersonIndexChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PersonIndexPie.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})