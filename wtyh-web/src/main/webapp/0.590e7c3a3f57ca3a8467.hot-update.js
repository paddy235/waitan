webpackHotUpdate(0,{

/***/ 951:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };
	//子模块引入

	//redux


	__webpack_require__(952);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _topLeft = __webpack_require__(954);

	var _topLeft2 = _interopRequireDefault(_topLeft);

	var _topMiddle = __webpack_require__(955);

	var _topMiddle2 = _interopRequireDefault(_topMiddle);

	var _topRight = __webpack_require__(956);

	var _topRight2 = _interopRequireDefault(_topRight);

	var _bottomLeft = __webpack_require__(957);

	var _bottomLeft2 = _interopRequireDefault(_bottomLeft);

	var _bottomRight = __webpack_require__(958);

	var _bottomRight2 = _interopRequireDefault(_bottomRight);

	var _RealTimeAction = __webpack_require__(1291);

	var RealTimeCreaTers = _interopRequireWildcard(_RealTimeAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

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
	        _react2.default.createElement(_topRight2.default, this.props)
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
	    realTimeTableRequest: state.RealTimeTable.request, //RealTimeTable注册在reduce里面的index。拿到处理后的两个返回值。

	    realTimeNineResult: state.RealTimeNine.result,
	    realTimeNineRequest: state.RealTimeNine.request //RealTimeNine注册在reduce里面的index。拿到处理后的两个返回值。
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

/***/ },

/***/ 954:
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

	var tableDate = {}; //假设第一次把所有的数据都拿回来
	var TopLeft = _react2.default.createClass({
	  displayName: 'TopLeft',
	  getInitialState: function getInitialState() {
	    return {
	      table: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeTable = this.props.getRealTimeTable; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeTable(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeTableRequest, this.props.realTimeTableResult); //判断数据是否变化
	    if (!isEqual) {
	      var realTimeTableRequest = nextProps.realTimeTableRequest;
	      var realTimeTableResult = nextProps.realTimeTableResult;

	      if (realTimeTableRequest == true) {
	        if (realTimeTableRequest == true) {
	          //这里可以开始渲染数据
	          tableDate = realTimeTableResult; //赋值给全局变量
	          _this.setState({
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
	                      '序号'
	                    ),
	                    _react2.default.createElement(
	                      'th',
	                      null,
	                      '公司名字'
	                    ),
	                    _react2.default.createElement(
	                      'th',
	                      null,
	                      '风险暴露日期'
	                    )
	                  )
	                ),
	                _react2.default.createElement(
	                  'tbody',
	                  null,
	                  tableDate.content[0].map(function (elem, index) {
	                    return _react2.default.createElement(
	                      'tr',
	                      { key: index },
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        index + 1
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        elem.name
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        elem.registered_capital
	                      )
	                    );
	                  })
	                )
	              )
	            )

	          });
	        } else {
	          alert(404);
	        }
	      }
	    }
	  },
	  titleRange: function titleRange(e) {
	    //如果上海地图没有出来，用setOption可能会报错
	    var _this = this;
	    var range = $(e.target).data("range");
	    var fixRange = $(e.target).attr("data-a");
	    var threeContent = range == 1 ? "2014/3/3" : parseInt(Math.random() * 5000);
	    var threeTitle = range == 1 ? "风险暴露日期" : "注册资本";
	    function setTable() {
	      _this.setState({
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
	                  '序号'
	                ),
	                _react2.default.createElement(
	                  'th',
	                  null,
	                  '公司名字'
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
	              tableDate.content[fixRange - 1].map(function (elem, index) {
	                return _react2.default.createElement(
	                  'tr',
	                  { key: index },
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    index + 1
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    elem.name
	                  ),
	                  _react2.default.createElement(
	                    'td',
	                    null,
	                    elem.registered_capital
	                  )
	                );
	              })
	            )
	          )
	        )

	      });
	    }

	    function getRange() {
	      _this.props.getRange(range); //因为这个函数会触发componentWillReceiveProps。所以说如果它后执行的话，table就会还原上上面的逻辑
	      setTable();
	    }
	    setTimeout(getRange, 0);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-top-left' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '光谱分析结果'
	      ),
	      _react2.default.createElement(
	        'ul',
	        { className: 'title', onClick: this.titleRange },
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '4', 'data-a': '1' },
	          '重点关注'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '3', 'data-a': '2' },
	          '一般关注'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '2', 'data-a': '3' },
	          '正常'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '1', 'data-a': '4' },
	          '已出风险'
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

	//将state植入 到 props
	exports.default = TopLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 956:
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

	var _ScatterChart = __webpack_require__(739);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	var _LineBarChart = __webpack_require__(799);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(777);

	var nineDate = "";
	var TopRight = _react2.default.createClass({
	    displayName: 'TopRight',
	    getInitialState: function getInitialState() {
	        return {};
	    },
	    componentDidMount: function componentDidMount() {
	        var getRealTimeNine = this.props.getRealTimeNine; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	        var jsonData = {}; //ajax传递给后台的data键值对
	        getRealTimeNine(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var _this = this;
	        var isEqual = Immutable.is(nextProps.realTimeNineRequest, this.props.realTimeNineResult); //判断数据是否变化
	        if (!isEqual) {
	            var realTimeNineRequest = nextProps.realTimeNineRequest;
	            var realTimeNineResult = nextProps.realTimeNineResult;

	            if (realTimeNineRequest == true) {
	                if (realTimeNineRequest == true) {
	                    //这里可以开始渲染数据
	                    nineDate = realTimeNineResult; //赋值给全局变量
	                    alert();
	                } else {
	                    alert(404);
	                }
	            }
	        }
	    },
	    setParam: function setParam() {
	        var paramOne = {
	            id: 'realTimeRightOne', //必传
	            height: '100%', //必传 带上单位
	            title: '小额贷款之贷款余额',
	            forMaterTitle: "贷款余额",
	            forMaterTip: '平均贷款余额',
	            legend: [],
	            xAxis: ['2010', '2011', '2012', '2013', '2014', '2015', '2016'],
	            yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	            data: [[0, 0, 300000], [1, 1, 1000000], [2, 2, 200000], [3, 3, 50], [4, 4, 60], [5, 5, 10], [6, 6, 80]],
	            series: [[{
	                color: '#e14340'
	            }]]
	        };
	        var paramTwo = {
	            "title": "私募基金",
	            "color": ["#f5b94b", "#01b6ed"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["管理资本金额", "私募机构数量"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "barName": ["管理资本金额", "私募机构数量"],
	            "xAxis": ["2012", "2013", "2014", "2015"],
	            "yAxisName": ["亿元", "个数"],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)], [Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramThree = {
	            "titleShow": true,
	            "title": "P2P平台",
	            "color": ["#12b5b0", "#e24441"],
	            "legend": ["上海新增", "上海累计"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "barName": ["上海新增"],
	            "lineName": ["上海累计"],
	            "YnameLocation": "end",
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "yFlag": "",
	            "xAxis": ["2012-Q1", "2014-Q2", "2014-Q3", "2014-Q4", "2015-Q1", "2015-Q2", "2015-Q3", "2015-Q4", "2016-Q1"],
	            "yAxisName": ["家数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramFour = {
	            "titleShow": true,
	            "title": "融资租赁",
	            "color": ["#12b5b0", "#e24441", "rgb(230,162,74)"],
	            "legend": ["注册资本($)", "注册资本(¥)", "企业数量"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "legendWidth": 600,
	            "barName": ["注册资本($)", "注册资本(¥)"],
	            "lineName": ["企业数量"],
	            "YnameRoutate": 0,
	            "YnameLocation": "end",
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "yFlag": "",
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"],
	            "yAxisName": ["亿人民币", "亿美元"],
	            "barWidth": 10,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)], [Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramFive = {
	            "title": "众筹平台",
	            "color": ["#f93330"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["新增项目数"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "axisLabelR": false,
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "labelShow": true,
	            "barName": ["新增项目数"],
	            "lablePosition": "right",
	            "yAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	            "Ytype": "category",
	            "Xtype": "value",
	            "yAxisName": ["新增项目数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramSix = {
	            "title": "众筹平台",
	            "color": ["#f93330"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["新增项目数"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "axisLabelR": false,
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "labelShow": true,
	            "barName": ["新增项目数"],
	            "xAxis": ["奖励众筹", "非公开股权融资", "公益众筹"],
	            "yAxisName": ["新增项目数", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramSeven = {
	            id: 'realTimeRightTwo', //必传
	            height: '100%', //必传 带上单位
	            title: '典当总额及业务笔数',
	            gridTop: "20%",
	            legend: [],
	            xAxis: ['2009', '2010', '2011', '2012', '2013'],
	            yAxis: ['100000', '200000', '300000', '400000', '500000'],
	            data: [[0, 0, 30], [1, 1, 10], [2, 2, 20], [3, 3, 50], [4, 4, 60]],
	            series: [[{
	                color: '#e14340'
	            }]]
	        };
	        var paramEight = {
	            "titleShow": true,
	            "title": "商业保理",
	            "color": ["rgb(249,51,48)", "rgb(246,215,147)"],
	            "legend": ["商业保理业务总额", "融资余额"],
	            "legendShow": true,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "barName": ["商业保理业务总额"],
	            "lineName": ["融资余额"],
	            "YnameLocation": "end",
	            "YnameGap": 5,
	            "gridLeft": "5%",
	            "gridRight": "0%",
	            "gridBottom": "0%",
	            "Ytype": "value",
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"],
	            "yAxisName": ["亿元", "个数"],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "itemStyle": {},
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]],
	                "line": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        var paramNine = {
	            "title": "预付卡之备案企业预付金额总额",
	            "color": ["#12b5b0", "#01b6ed"],
	            "titleShow": "show",
	            "titleX": "left",
	            "legend": ["管理资本金额"],
	            "legendShow": false,
	            "legendLeft": "center",
	            "legendTop": "20",
	            "gridBottom": "0%",
	            "gridRight": "0%",
	            "axisLabelR": false,
	            "barName": ["管理资本金额"],
	            "xAxis": ["2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"],
	            "yAxisName": ["亿元", ""],
	            "barWidth": 20,
	            "symbolSize": 10,
	            "labelShow": true,
	            "series": {
	                "bar": [[Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200), Math.round(Math.random() * 200)]]
	            }
	        };
	        return [paramOne, paramTwo, paramThree, paramFour, paramFive, paramSix, paramSeven, paramEight, paramNine];
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-top-right' },
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_ScatterChart2.default, { param: this.setParam()[0] })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[1], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[2], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[3], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[4], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[5], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_ScatterChart2.default, { param: this.setParam()[6], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[7], style: { height: '100%', width: '100%' } })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                _react2.default.createElement(_LineBarChart2.default, { param: this.setParam()[8], style: { height: '100%', width: '100%' } })
	            )
	        );
	    }
	});

	//将state植入 到 props
	exports.default = TopRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 962:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _SmallLoanMap = __webpack_require__(963);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(964);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(965);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(966);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(967);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(1283);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(1284);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(1285);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(1286);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(1287);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(968);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(969);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(970);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(971);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(972);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(973);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1288);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1289);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1290);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(974);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(975);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(976);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(977);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _realtimeTableRuducer = __webpack_require__(978);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1292);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _BusinessTypes = __webpack_require__(979);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(980);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(981);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(982);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(983);

	var _List2 = _interopRequireDefault(_List);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*众筹监测 end*/

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表

	/*p2p平台首页 begin*/
	//P2P平台监测

	//上海区域发展指数排名


	/*行业监测模块*/

	//小额贷款
	var rootReducer = (0, _redux.combineReducers)({
	  /*行业监测模块*/
	  //P2P平台监测

	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  IndexChartAll: _IndexChartAll2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default, CoreBar: _CoreBar2.default, CoreTrend: _CoreTrend2.default, CoreBalance: _CoreBalance2.default,
	  Litigation: _Litigation2.default,
	  PublicOpinion: _PublicOpinion2.default,
	  RankPic: _RankPic2.default,
	  ScoreLeida: _ScoreLeida2.default,

	  //众筹
	  BusinessTypes: _BusinessTypes2.default,
	  InvestPeople: _InvestPeople2.default,
	  NewProject: _NewProject2.default,
	  RaiseMount: _RaiseMount2.default,
	  List: _List2.default,

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	//列表

	//6月上海各类众筹平台新增项目数

	/*实时监测 end*/

	/*众筹监测 begin*/
	//业务类型


	/*p2p画像平台 end*/

	/*实时监测 begin*/
	//左侧表格

	//动态图谱

	//诉讼信息

	//核心数据

	/*p2p平台首页 end*/

	/*p2p画像平台 begin*/
	//基本信息

	//网贷平台数据展示


	//融资担保

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 978:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = realTimeTable;

	var _RealTimeAction = __webpack_require__(1291);

	//这个函数就是处理，action里面成功和失败的2个返回函数。
	//当ajax请求成功了，就可以调用这个两个返回函数进行操作。
	function realTimeTable() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? { //这个名字无所谓，最后都是用index里面对外暴露的名字。
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _RealTimeAction.REALTIME_TABLE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _RealTimeAction.REALTIME_TABLE_FAIL:
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

/***/ 1291:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getRealTimeTable = getRealTimeTable;
	exports.getRealTimeNine = getRealTimeNine;
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
	      url: "/realTimeMonitorController/spectrumAnalysis4groups.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeTableSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeTableFail(result));
	      }
	    });
	  };
	}

	/*
	  实时监测右侧的9个图的action（接口合并成了一个）
	*/
	var REALTIME_NINE_SUCCESS = exports.REALTIME_NINE_SUCCESS = 'REALTIME_NINE_SUCCESS';
	var REALTIME_NINE_FAIL = exports.REALTIME_NINE_FAIL = 'REALTIME_NINE_FAIL';

	function RealTimeNineSuccess(result) {
	  //请求成功调用方法 保存成功的数据
	  return {
	    type: REALTIME_NINE_SUCCESS,
	    result: result
	  };
	}
	function RealTimeNineFail(result) {
	  //请求失败调用方法  保存了失败的数据
	  return {
	    type: REALTIME_NINE_FAIL,
	    result: result
	  };
	}

	//最开始触发redux流程的导火线。
	function getRealTimeNine(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/realTimeMonitorController/spectrumAnalysis4groups.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        console.log("九个图的此次请求成功");
	        return dispatch(RealTimeNineSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeNineFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RealTimeAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1292:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = realTimeNine;

	var _RealTimeAction = __webpack_require__(1291);

	//这个函数就是处理，action里面成功和失败的2个返回函数。
	//当ajax请求成功了，就可以调用这个两个返回函数进行操作。

	function realTimeNine() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? { //这个名字无所谓，最后都是用index里面对外暴露的名字。
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _RealTimeAction.REALTIME_NINE_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _RealTimeAction.REALTIME_NINE_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	//（默认的2个值，根据判断action返回的两个值）
	// 这个reducer就是从action里面抽离出来的数据的状态机

	// request、result

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "realtimeNineReducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})