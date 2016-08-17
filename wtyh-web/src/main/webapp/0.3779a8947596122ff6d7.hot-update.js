webpackHotUpdate(0,{

/***/ 958:
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

	var data;
	var BottomRight = _react2.default.createClass({
	  displayName: 'BottomRight',
	  getInitialState: function getInitialState() {
	    return {};
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeNews = this.props.getRealTimeNews; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeNews(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeNewsRequest, this.props.realTimeNewsResult); //判断数据是否变化
	    if (!isEqual) {
	      var realTimeNewsRequest = nextProps.realTimeNewsRequest;
	      var realTimeNewsResult = nextProps.realTimeNewsResult;

	      if (realTimeNewsRequest == true) {
	        if (realTimeNewsRequest == true) {
	          alert("ssss");
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
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'h4',
	            null,
	            _react2.default.createElement(
	              'a',
	              { href: 'http://wwww.baidu.com' },
	              '1.某某公司打造先进的风控体系'
	            )
	          ),
	          _react2.default.createElement(
	            'p',
	            null,
	            '昨日下午,市政协重点提案办理工作座谈会举行,围绕市工商联提出的“关于加强我市小额贷款行业发展的建议”的提案,展开办理协商、沟通交流。该提案是今年市政协主席...'
	          ),
	          _react2.default.createElement(
	            'span',
	            null,
	            '光明网 2016年6月30日'
	          )
	        )
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