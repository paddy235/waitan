webpackHotUpdate(0,{

/***/ 948:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	//子模块引入


	__webpack_require__(949);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(721);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _topLeft = __webpack_require__(951);

	var _topLeft2 = _interopRequireDefault(_topLeft);

	var _topMiddle = __webpack_require__(952);

	var _topMiddle2 = _interopRequireDefault(_topMiddle);

	var _topRight = __webpack_require__(953);

	var _topRight2 = _interopRequireDefault(_topRight);

	var _bottomLeft = __webpack_require__(954);

	var _bottomLeft2 = _interopRequireDefault(_bottomLeft);

	var _bottomRight = __webpack_require__(955);

	var _bottomRight2 = _interopRequireDefault(_bottomRight);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//实时监测首页s
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
	        windowHeight: $(window).height()
	      });
	    }.bind(this));
	  },
	  componentWillMount: function componentWillMount() {
	    this.setState({
	      windowHeight: $(window).height()
	    });
	  },
	  getRange: function getRange(range) {
	    this.setState({
	      indexRange: range
	    });
	  },

	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-index wrap', style: { "height": this.state.windowHeight - 60 } },
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-top' },
	        _react2.default.createElement(_topLeft2.default, _extends({ getRange: this.getRange }, this.props)),
	        _react2.default.createElement(_topMiddle2.default, _extends({ pushRange: this.state.indexRange }, this.props)),
	        _react2.default.createElement(_topRight2.default, null)
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'realtime-bottom' },
	        _react2.default.createElement(_bottomLeft2.default, null),
	        _react2.default.createElement(_bottomRight2.default, null)
	      )
	    );
	  }
	});

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {
	    realTimeTableResult: state.RealTimeTable.result,
	    realTimeTableRequest: state.RealTimeTable.request //RealTimeTable注册在reduce里面的index。拿到处理后的两个返回值。
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(SmallLoanActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RealtimeMonitorIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 951:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(949);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var TopLeft = _react2.default.createClass({
	  displayName: 'TopLeft',
	  getInitialState: function getInitialState() {
	    return {
	      table: _react2.default.createElement(
	        'div',
	        { className: 'table-wrap' },
	        _react2.default.createElement(
	          'table',
	          null,
	          _react2.default.createElement(
	            'thead',
	            null,
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'th',
	                null,
	                '����'
	              ),
	              _react2.default.createElement(
	                'th',
	                null,
	                '��˾����'
	              ),
	              _react2.default.createElement(
	                'th',
	                null,
	                '���ձ�¶����'
	              )
	            )
	          ),
	          _react2.default.createElement(
	            'tbody',
	            null,
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '1'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ��޵й������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '2'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������ŲƸ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '3'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������Ƹ�������˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '4'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '5'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '6'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '7'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '8'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '9'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '10'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '1'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ��޵й������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '2'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������ŲƸ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '3'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������Ƹ�������˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '4'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '5'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '6'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '7'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '8'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '9'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '10'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '2016-07-25'
	              )
	            )
	          )
	        )
	      )
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeTable = this.props.getRealTimeTable; // ȡ��props������getRealTimeTable������Ҳ����˵������action

	    var jsonData = {}; //ajax���ݸ���̨��data��ֵ��
	    getRealTimeTable(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.realTimeTableRequest, this.props.realTimeTableResult); //�ж������Ƿ��仯
	    if (!isEqual) {
	      var realTimeTableRequest = nextProps.realTimeTableRequest;
	      var realTimeTableResult = nextProps.realTimeTableResult;

	      if (realTimeTableRequest == true) {
	        if (realTimeTableResult.code == 200) {
	          alert('�Ƹ��ɹ���');
	          //�������Կ�ʼ��Ⱦ����
	        } else {
	            alert(404);
	          }
	      }
	    }
	  },
	  titleRange: function titleRange(e) {
	    //�����Ϻ���ͼû�г�������setOption���ܻᱨ��
	    var range = $(e.target).data("range");
	    this.props.getRange(range);
	    var threeContent = range == 1 ? "2014/3/3" : parseInt(Math.random() * 5000);
	    var threeTitle = range == 1 ? "���ձ�¶����" : "ע���ʱ�";
	    this.setState({
	      table: _react2.default.createElement(
	        'div',
	        { className: 'table-wrap' },
	        _react2.default.createElement(
	          'table',
	          null,
	          _react2.default.createElement(
	            'thead',
	            null,
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'th',
	                null,
	                '����'
	              ),
	              _react2.default.createElement(
	                'th',
	                null,
	                '��˾����'
	              ),
	              _react2.default.createElement(
	                'th',
	                null,
	                threeTitle
	              )
	            )
	          ),
	          _react2.default.createElement(
	            'tbody',
	            null,
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '1'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ��޵й������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '2'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������ŲƸ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '3'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������Ƹ�������˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '4'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '5'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '6'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '7'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '8'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '9'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '10'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '1'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ��޵й������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '2'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������ŲƸ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '3'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�Ϻ������Ƹ�������˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '4'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '5'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '6'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '7'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '8'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '9'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            ),
	            _react2.default.createElement(
	              'tr',
	              null,
	              _react2.default.createElement(
	                'td',
	                null,
	                '10'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                '�̾��ʲ��������޹�˾'
	              ),
	              _react2.default.createElement(
	                'td',
	                null,
	                threeContent
	              )
	            )
	          )
	        )
	      )

	    });
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-top-left' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '���׷�������'
	      ),
	      _react2.default.createElement(
	        'ul',
	        { className: 'title', onClick: this.titleRange },
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '4' },
	          '�ص���ע'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '3' },
	          'һ����ע'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '2' },
	          '����'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '1' },
	          '�ѳ�����'
	        )
	      ),
	      this.state.table,
	      _react2.default.createElement(
	        'div',
	        { className: 'color' },
	        _react2.default.createElement('img', { src: './images/bar.png', alt: '' })
	      )
	    );
	  }
	});

	//��stateֲ�� �� props
	exports.default = TopLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 958:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _CompanyGrade = __webpack_require__(959);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _DevTrend = __webpack_require__(960);

	var _DevTrend2 = _interopRequireDefault(_DevTrend);

	var _Volume = __webpack_require__(1260);

	var _Volume2 = _interopRequireDefault(_Volume);

	var _Map = __webpack_require__(1261);

	var _Map2 = _interopRequireDefault(_Map);

	var _AreaRanking = __webpack_require__(1262);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1263);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _ProblemScale = __webpack_require__(1264);

	var _ProblemScale2 = _interopRequireDefault(_ProblemScale);

	var _IndustrySentiment = __webpack_require__(1265);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _NetCreditContrast = __webpack_require__(1266);

	var _NetCreditContrast2 = _interopRequireDefault(_NetCreditContrast);

	var _BaseMsg = __webpack_require__(1267);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1268);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1269);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _Litigation = __webpack_require__(1270);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1271);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1272);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1273);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _realtimeTableRuducer = __webpack_require__(1274);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*实时监测 end*/

	//评分雷达图

	//平台舆情

	//核心数据

	/*p2p平台首页 end*/

	/*p2p画像平台 begin*/
	//基本信息

	//行业人气

	//网贷平台数据展示

	//地图

	/*p2p平台首页 begin*/
	//P2P平台监测
	var rootReducer = (0, _redux.combineReducers)({
	  /*行业监测模块*/
	  //P2P平台监测
	  DevTrend: _DevTrend2.default,
	  Volume: _Volume2.default,
	  Map: _Map2.default,
	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  ProblemScale: _ProblemScale2.default,
	  IndustrySentiment: _IndustrySentiment2.default,
	  NetCreditContrast: _NetCreditContrast2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default,
	  Litigation: _Litigation2.default,
	  PublicOpinion: _PublicOpinion2.default,
	  RankPic: _RankPic2.default,
	  ScoreLeida: _ScoreLeida2.default,

	  //小额贷款
	  CompanyGrade: _CompanyGrade2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});

	/*p2p画像平台 end*/

	/*实时监测 begin*/
	//左侧表格

	//动态图谱

	//诉讼信息

	//公司基本信息

	//网贷对比

	//问题平台比例

	//上海区域发展指数排名

	//成交量和综合利率


	/*行业监测模块*/

	//小额贷款

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1274:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = realTimeTable;

	var _RealTimeTableAction = __webpack_require__(1275);

	//这个函数就是处理，action里面成功和失败的2个返回函数。
	//当ajax请求成功了，就可以调用这个两个返回函数进行操作。
	console.log(_RealTimeTableAction.REALTIME_TABLE_SUCCESS);
	function realTimeTable() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? { //这个名字无所谓，最后都是用index里面对外暴露的名字。
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _RealTimeTableAction.REALTIME_TABLE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _RealTimeTableAction.REALTIME_TABLE_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "realtimeTableRuducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1275:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getRealTimeTable = getRealTimeTable;
	/*
	  实时监测左侧表格action
	*/
	var REALTIME_TABLE_SUCCESS = exports.REALTIME_TABLE_SUCCESS = 'REALTIME_TABLE_SUCCESS';
	var REALTIME_TABLE_FAIL = exports.REALTIME_TABLE_FAIL = 'REALTIME_TABLE_FAIL';

	function RealTimeTableSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: REALTIME_TABLE_SUCCESS,
	    result: result
	  };
	}
	function RealTimeTableFail(result) {
	  //请求失败调用方法
	  return {
	    type: REALTIME_TABLE_FAIL,
	    result: result
	  };
	}

	function getRealTimeTable(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        console.log("陈胜云的此次请求成功");
	        return dispatch(RealTimeTableSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeTableFail(result));
	      }
	    });
	  };
	}
	/*企业评级end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RealTimeTableAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})