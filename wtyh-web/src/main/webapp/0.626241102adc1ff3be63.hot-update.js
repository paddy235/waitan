webpackHotUpdate(0,{

/***/ 949:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var SearchList = _react2.default.createClass({
	  displayName: 'SearchList',

	  getInitialState: function getInitialState() {
	    return {
	      count: 0,
	      DataList: [],
	      nowpage: 0
	    };
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.searchDataRequest, this.props.searchDataResult);
	    if (!isEqual) {
	      var searchDataRequest = nextProps.searchDataRequest;
	      var searchDataResult = nextProps.searchDataResult;

	      if (searchDataRequest == true) {
	        if (searchDataResult.success == true) {
	          this.dataFomat(searchDataResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content.rdata;
	    var count = data.content.sum;
	    if (content.length != 0) this.setState({ count: count, DataList: content });else this.setState({ count: count, DataList: null });
	  },
	  getLargeLoan: function getLargeLoan(jsonData) {
	    var getSearchDataRequest = this.props.getSearchDataRequest;

	    getSearchDataRequest(jsonData);
	  },
	  //分页回调 
	  setCallBack: function setCallBack(nowpage, eachPageCount) {
	    console.info("aaaaaaaaaaaaaaaaaaa", eachPageCount);
	    this.setState({ nowpage: nowpage - 1 });
	    var searchName = "";
	    $("#inp").val() ? searchName = $("#inp").val() : searchName = this.props.location.query.searchInfo;
	    var jsonData = {
	      "company": searchName,
	      "page_no": nowpage - 1,
	      "page_size": 4
	    };
	    if ($("#inp").val() || this.props.location.query.searchInfo) this.getLargeLoan(jsonData);
	  },
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      var jsonData = {
	        "company": this.props.location.query.searchInfo,
	        "page_no": 0,
	        "page_size": 4
	      };
	      this.getLargeLoan(jsonData);
	    }
	  },

	  render: function render() {
	    var textBox = "";
	    if (this.state.count != 0) {
	      textBox = _react2.default.createElement(
	        'span',
	        { className: 'total' },
	        '共搜索到相关',
	        _react2.default.createElement(
	          'em',
	          null,
	          this.state.count
	        ),
	        '家企业。'
	      );
	    }
	    if (this.state.DataList) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'SearchList' },
	        _react2.default.createElement(
	          'ul',
	          { className: 'ulBox xxx', id: 'show' },
	          this.state.DataList.map(function (ele, index) {
	            return _react2.default.createElement(
	              'li',
	              { className: 'liList', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  _reactRouter.Link,
	                  { to: "/SearchResultDetail?companyName=" + ele.company_name },
	                  _react2.default.createElement(
	                    'h2',
	                    null,
	                    ele.company_name
	                  )
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册号：',
	                  ele.regno
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '类型：',
	                  ele.company_type
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '法定代表人：',
	                  ele.frname
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册资本：',
	                  ele.regcap
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '成立日期：',
	                  ele.esdate
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册地址：',
	                  ele.address
	                )
	              )
	            );
	          }),
	          _react2.default.createElement(
	            'div',
	            { className: 'page' },
	            textBox,
	            _react2.default.createElement(_index.PageList, { id: 'pageList1', count: this.state.count, showPage: '6', callback: this.setCallBack })
	          )
	        )
	      );
	    } else if (this.state.DataList == null) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'noResult' },
	        '抱歉！ 暂无搜索结果'
	      );
	    }
	  }
	});
	module.exports = SearchList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

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
	        windowHeight: $(window).height()
	      });
	    }.bind(this));
	  },
	  componentWillMount: function componentWillMount() {
	    this.setState({
	      windowHeight: $(window).height()
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
	    realTimeMapShRequest: state.RealTimeMapSh.request //RealTimeMap注册在reduce里面的index。拿到处理后的两个返回值。
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

/***/ 976:
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
	    var isEqual = Immutable.is(nextProps.realTimeTableResult, this.props.realTimeTableResult); //判断数据是否变化
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
	      // _this.props.getRange(range);//因为这个函数会触发componentWillReceiveProps。所以说如果它后执行的话，table就会还原上上面的逻辑
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
	            '重庆': [107.7539, 30.1904],
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
	                    {name:"黄浦区",value:1,date:222}, 
	                    {name:"浦东新区",value:2,date:222},
	                    {name:"徐汇区",value:3,date:222},
	                    {name:"长宁区",value:4,date:222},
	                    {name:"静安区",value:1,date:222},
	                    {name:"普陀区",value:getRandomInScope(1,5),date:222},
	                    {name:"虹口区",value:getRandomInScope(1,5),date:222},
	                    {name:"杨浦区",value:getRandomInScope(1,5),date:222},
	                    {name:"中晋股权投资基金管理(上海)有限公司",value:1,date:222},
	                    {name:"融宜宝积家投资管理（北京）有限公司上海分公司",value:1},
	                    {name:"上海太宥恒资产管理有限公司",value:1},
	                    {name:"上海炳恒财富投资管理（集团）有限公司",value:1},
	                    {name:"上海长来资产管理有限公司",value:1},
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
	                                html += "<span>" + item + "</span>";
	                                length += 1;
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
	                                            <td>重点检测楼宇<br>(5)</td>\
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
	            // _this.state.mapeType == "china"?this.mapChina():this.mapShanghai();
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

/***/ },

/***/ 978:
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

	var _ScatterChart = __webpack_require__(741);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var nineDate = ""; //ajax返回回来的所有数据；
	var paramOne, paramTwo, paramThree, paramFour, paramFive, paramSix, paramSeven, paramEight, paramNine; //每一个小模块的数据，初始状态为空，render判断为空的话就不渲染。

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
	        var isEqual = Immutable.is(nextProps.realTimeNineResult, this.props.realTimeNineResult); //判断数据是否变化
	        if (!isEqual) {
	            var realTimeNineRequest = nextProps.realTimeNineRequest;
	            var realTimeNineResult = nextProps.realTimeNineResult;

	            if (realTimeNineRequest == true) {
	                if (realTimeNineRequest == true) {
	                    //这里可以开始渲染数据
	                    nineDate = realTimeNineResult; //赋值给全局变量

	                    //paramOneData-fixed == 1
	                    var paramOneData = [];
	                    nineDate.content.loan.series[0].map(function (item, index) {
	                        var xx = [index, item];
	                        paramOneData.push(xx);
	                    });
	                    nineDate.content.loan.series[1].map(function (item, index) {
	                        paramOneData[index].push(item);
	                    });
	                    //paramOneData-fixed-end
	                    paramOne = {
	                        id: 'realTimeRightOne', //必传
	                        height: '100%', //必传 带上单位
	                        title: '小额贷款之贷款余额',
	                        forMaterTitle: "贷款余额",
	                        forMaterTip: '平均贷款余额',
	                        gridTop: "20%",
	                        yType: "value",
	                        legend: [],
	                        xAxis: nineDate.content.loan.xAxis,
	                        yAxis: [],
	                        data: paramOneData,
	                        series: [[{
	                            color: '#e14340'
	                        }]]
	                    };
	                    paramTwo = {
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
	                        "xAxis": nineDate.content.private.xAxis,
	                        "yAxisName": ["亿元", "个数"],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": nineDate.content.private.series
	                        }
	                    };
	                    paramThree = {
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
	                        "xAxis": nineDate.content.p2p.xAxis,
	                        "yAxisName": ["家数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.p2p.series.bar],
	                            "line": [nineDate.content.p2p.series.line]
	                        }
	                    };
	                    paramFour = {
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
	                        "xAxis": nineDate.content.finance.xAxis,
	                        "yAxisName": ["亿人民币", "亿美元"],
	                        "barWidth": 10,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": nineDate.content.finance.series.bar,
	                            "line": [nineDate.content.finance.series.line]
	                        }
	                    };
	                    paramFive = {
	                        "title": "众筹平台",
	                        "color": ["#f93330"],
	                        "titleShow": "show",
	                        "titleX": "left",
	                        "forMaterTitle": "贷款余额",
	                        "forMaterTip": '平均贷款余额',
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
	                        "yAxis": nineDate.content.exchange.xAxis /*["奖励众筹", "非公开股权融资", "公益s众筹", "公益2q众筹", "公益众d筹"]*/
	                        , "Ytype": "category",
	                        "Xtype": "value",
	                        "yAxisName": ["新增项目数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.exchange.series]
	                        }
	                    };
	                    paramSix = {
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
	                        "xAxis": nineDate.content.crowd.xAxis,
	                        "yAxisName": ["新增项目数", ""],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [nineDate.content.crowd.series]
	                        }
	                    };
	                    //paramSevenData-fixed == 1
	                    var paramSevenData = [];
	                    nineDate.content.mortgage.series[0].map(function (item, index) {
	                        var xx = [index, item];
	                        paramSevenData.push(xx);
	                    });
	                    nineDate.content.mortgage.series[1].map(function (item, index) {
	                        paramSevenData[index].push(item);
	                    });
	                    //paramSevenData-fixed-end
	                    paramSeven = {
	                        id: 'realTimeRightTwo', //必传
	                        height: '100%', //必传 带上单位
	                        title: '典当总额及业务笔数',
	                        yType: "value",
	                        gridTop: "20%",
	                        legend: [],
	                        xAxis: nineDate.content.mortgage.xAxis,
	                        yAxis: ['100000', '200000', '3000000', '4000000', '5000000'],
	                        data: paramSevenData,
	                        series: [[{
	                            color: '#e14340'
	                        }]]
	                    };
	                    paramEight = {
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
	                            //后台暂时没得数据，莫法传
	                            "bar": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)
	                            ]],
	                            "line": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)

	                            ]]
	                        }
	                    };
	                    paramNine = {
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
	                            "bar": [[
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200),
	                                // Math.round(Math.random() * 200)
	                            ]]
	                        }
	                    };
	                } else {
	                        alert(404);
	                    }
	            }
	        }
	    },
	    render: function render() {
	        var paramOneBox, paramTwoBox, paramThreeBox, paramFourBox, paramFiveBox, paramSixBox, paramSevenBox, paramEightBox, paramNineBox;
	        if (!!paramOne) {
	            paramOneBox = _react2.default.createElement(_ScatterChart2.default, { param: paramOne, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramTwo) {
	            paramTwoBox = _react2.default.createElement(_LineBarChart2.default, { param: paramTwo, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramThree) {
	            paramThreeBox = _react2.default.createElement(_LineBarChart2.default, { param: paramThree, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramFour) {
	            paramFourBox = _react2.default.createElement(_LineBarChart2.default, { param: paramFour, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramFive) {
	            paramFiveBox = _react2.default.createElement(_LineBarChart2.default, { param: paramFive, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramSix) {
	            paramSixBox = _react2.default.createElement(_LineBarChart2.default, { param: paramSix, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramSeven) {
	            paramSevenBox = _react2.default.createElement(_ScatterChart2.default, { param: paramSeven, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramEight) {
	            paramEightBox = _react2.default.createElement(_LineBarChart2.default, { param: paramEight, style: { height: '100%', width: '100%' } });
	        }
	        if (!!paramNine) {
	            paramNineBox = _react2.default.createElement(_LineBarChart2.default, { param: paramNine, style: { height: '100%', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'realtime-top-right' },
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramOneBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramTwoBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramThreeBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramFourBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramFiveBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramSixBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramSevenBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramEightBox
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'item' },
	                paramNineBox
	            )
	        );
	    }
	});

	//将state植入 到 props
	exports.default = TopRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 980:
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

	__webpack_require__(981);

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
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeNewsResult, this.props.realTimeNewsResult);
	    if (!isEqual) {
	      var data = JSON.parse(nextProps.realTimeNewsResult.content);
	      _this.setState({
	        list: data.results.map(function (item, index) {
	          return _react2.default.createElement(
	            'li',
	            { key: index, className: 'animated zoomIn', style: { 'WebkitAnimationDelay': index * 0.1 + 's' } },
	            _react2.default.createElement(
	              'h4',
	              null,
	              _react2.default.createElement(
	                'a',
	                { href: 'http://wwww.baidu.com' },
	                item.search_key
	              )
	            ),
	            _react2.default.createElement(
	              'p',
	              null,
	              item.news_title
	            ),
	            _react2.default.createElement(
	              'span',
	              null,
	              _react2.default.createElement(
	                'p',
	                null,
	                item.news_site
	              ),
	              '  ',
	              _react2.default.createElement(
	                'p',
	                null,
	                item.pubdate
	              )
	            )
	          );
	        })
	      });
	    }
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeNews = this.props.getRealTimeNews; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeNews(jsonData);
	  },

	  /*  componentWillReceiveProps: function(nextProps) {
	      console.log(nextProps.realTimeNewsResult)
	      console.log(this.props.realTimeNewsResult)
	      var _this = this;
	      var isEqual=Immutable.is(nextProps.realTimeNewsRequest, this.props.realTimeNewsResult)//判断数据是否变化
	              if(!isEqual){
	               const {realTimeNewsRequest,realTimeNewsResult}=nextProps;
	               if(realTimeNewsRequest==true){
	                  if(realTimeNewsRequest==true){ 
	                    console.log(realTimeNewsResult,"top")
	                      return;var data=JSON.parse(realTimeNewsResult);
	                      console.log(data,"fixfixfix")
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
	                  }else{
	                      alert(404)
	                  }
	              }
	            }
	    },*/
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