webpackHotUpdate(0,{

/***/ 972:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(966);

	__webpack_require__(973);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var data;
	var BottomRight = _react2.default.createClass({
	  displayName: 'BottomRight',
	  getInitialState: function getInitialState() {
	    return {
	      list: null
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(">>>>>>>>>>>>>>>>", nextProps.realTimeNewsResult);
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeNews = this.props.getRealTimeNews; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeNews(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    console.log(nextProps.realTimeNewsResult);
	    console.log(this.props.realTimeNewsResult);
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeNewsRequest, this.props.realTimeNewsResult); //判断数据是否变化
	    if (!isEqual) {
	      var realTimeNewsRequest = nextProps.realTimeNewsRequest;
	      var realTimeNewsResult = nextProps.realTimeNewsResult;

	      if (realTimeNewsRequest == true) {
	        if (realTimeNewsRequest == true) {
	          console.log(realTimeNewsResult, "top");
	          var data = JSON.parse(realTimeNewsResult);
	          console.log(data, "fixfixfix");
	          // _this.setState({
	          //   list:(
	          //         realTimeNewsResult.content.map(function(item,index){
	          //           return (
	          //                 <li key={index} className="animated zoomIn" style={{'WebkitAnimationDelay':index*0.1+'s'}}>
	          //                   <h4>
	          //                     <a href="http://wwww.baidu.com">{item.searchKey}</a>
	          //                   </h4>
	          //                   <p>
	          //                     {item.newsTitle}
	          //                   </p>
	          //                   <span>
	          //                     <p>{item.newsSite}</p>  <p>{item.pubDate}</p>
	          //                   </span>
	          //                 </li>
	          //             )
	          //         })
	          //         )
	          // })
	        } else {
	            alert(404);
	          }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-bottom-right' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '舆情'
	      ),
	      _react2.default.createElement(
	        'ul',
	        null,
	        this.state.list
	      )
	    );
	  }
	});

	//将state植入 到 props
	exports.default = BottomRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "bottomRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})