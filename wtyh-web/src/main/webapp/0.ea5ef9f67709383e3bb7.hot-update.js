webpackHotUpdate(0,{

/***/ 973:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	//子模块引入

	//redux


	__webpack_require__(974);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _topLeft = __webpack_require__(976);

	var _topLeft2 = _interopRequireDefault(_topLeft);

	var _topMiddle = __webpack_require__(977);

	var _topMiddle2 = _interopRequireDefault(_topMiddle);

	var _topRight = __webpack_require__(978);

	var _topRight2 = _interopRequireDefault(_topRight);

	var _bottomLeft = __webpack_require__(979);

	var _bottomLeft2 = _interopRequireDefault(_bottomLeft);

	var _bottomRight = __webpack_require__(980);

	var _bottomRight2 = _interopRequireDefault(_bottomRight);

	var _RealTimeAction = __webpack_require__(983);

	var RealTimeCreaTers = _interopRequireWildcard(_RealTimeAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//实时监测首页
	var RealtimeMonitorIndex = _react2.default.createClass({
	  displayName: 'RealtimeMonitorIndex',
	  getInitialState: function getInitialState() {
	    return {
	      windowHeight: null,
	      indexRange: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    $(window).resize(function (event) {
	      this.setState({
	        windowHeight: $(window).height() - 60
	      });
	    }.bind(this));

	    $(document).keypress(function (event) {
	      if (event.keyCode == 112) {
	        this.setState({
	          windowHeight: $(window).height() - 60
	        });
	      }
	    });
	  },
	  componentWillMount: function componentWillMount() {
	    this.setState({
	      windowHeight: $(window).height() - 60
	    });
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	  getRange: function getRange(range) {
	    this.setState({
	      indexRange: range
	    });
	  },

	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-index wrap', style: { "height": this.state.windowHeight } },
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-top' },
	        _react2.default.createElement(_topLeft2.default, _extends({ getRange: this.getRange }, this.props)),
	        _react2.default.createElement(_topMiddle2.default, _extends({ pushRange: this.state.indexRange }, this.props)),
	        _react2.default.createElement(_topRight2.default, this.props)
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-bottom' },
	        _react2.default.createElement(_bottomLeft2.default, this.props),
	        _react2.default.createElement(_bottomRight2.default, this.props)
	      )
	    );
	  }
	});

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {
	    realTimeTableResult: state.RealTimeTable.result,
	    realTimeTableRequest: state.RealTimeTable.request, //RealTimeTable注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeNineResult: state.RealTimeNine.result,
	    realTimeNineRequest: state.RealTimeNine.request, //RealTimeNine注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeNewsResult: state.RealTimeNews.result,
	    realTimeNewsRequest: state.RealTimeNews.request, //RealTimeNews注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeMapResult: state.RealTimeMap.result,
	    realTimeMapRequest: state.RealTimeMap.request, //RealTimeMap注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeMapShResult: state.RealTimeMapSh.result,
	    realTimeMapShRequest: state.RealTimeMapSh.request, //Real搜索TimeMa在reduce里面的index。拿到处理后的两个返回值。

	    realTimeRiskResult: state.RealTimeRisk.result,
	    realTimeRiskRequest: state.RealTimeRisk.request //RealTimeMap注册在reduce里面的index。拿到处理后的两个返回值。
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(RealTimeCreaTers, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RealtimeMonitorIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})