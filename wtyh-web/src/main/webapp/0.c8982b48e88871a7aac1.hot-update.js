webpackHotUpdate(0,{

/***/ 685:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(686);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Header = _react2.default.createClass({
	  displayName: 'Header',

	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'header' },
	      _react2.default.createElement(
	        'a',
	        { href: '/', className: 'logo' },
	        _react2.default.createElement('span', { className: 'img' }),
	        this.props.text
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'right' },
	        _react2.default.createElement(
	          'span',
	          { className: 'name' },
	          _react2.default.createElement('i', { className: 'iconfont icon-user' }),
	          _react2.default.createElement(
	            'span',
	            null,
	            'Admin'
	          ),
	          _react2.default.createElement('i', { className: 'iconfont icon-arrowdown' })
	        ),
	        _react2.default.createElement(
	          'a',
	          { href: 'javascript:;', className: 'quit' },
	          _react2.default.createElement('i', { className: 'iconfont icon-quit' })
	        )
	      )
	    );
	  }
	});

	module.exports = Header;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Header.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 691:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(686);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	var _reactRouter = __webpack_require__(243);

	var _index = __webpack_require__(692);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _MenuParkAction = __webpack_require__(717);

	var MenuParkActionCreaters = _interopRequireWildcard(_MenuParkAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var Menu = _react2.default.createClass({
	  displayName: 'Menu',

	  getInitialState: function getInitialState() {
	    return {
	      subNav: false,
	      value: '',
	      selectDataArr: []
	    };
	  },
	  componentWillMount: function componentWillMount() {
	    this.getMenuParkSelectList();
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.menuParkSelectListResult, this.props.menuParkSelectListResult); //判断数据是否变化
	    if (!isEqual) {
	      var menuParkSelectListRequest = nextProps.menuParkSelectListRequest;
	      var menuParkSelectListResult = nextProps.menuParkSelectListResult;

	      if (menuParkSelectListRequest == true) {
	        if (menuParkSelectListResult.success == true) {
	          this.dataFomat(menuParkSelectListResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content;
	    var len = content.length;
	    var selectArr = [];
	    for (var i = 0; i < len; i++) {
	      selectArr.push({ value: content[i].areaId, label: content[i].name });
	    }
	    this.getMenuParkSelectVal(selectArr[0].value, selectArr[0].name);
	    this.setState({ selectDataArr: selectArr, value: selectArr[0].value });
	  },
	  getMenuParkSelectList: function getMenuParkSelectList(data) {
	    var getMenuParkSelectList = this.props.getMenuParkSelectList;

	    getMenuParkSelectList();
	  },
	  getMenuParkSelectVal: function getMenuParkSelectVal(areaId, name) {
	    var getMenuParkSelectVal = this.props.getMenuParkSelectVal;

	    var data = { areaId: areaId, name: name };
	    getMenuParkSelectVal(data);
	  },
	  menuSlide: function menuSlide(e) {
	    var $this = $(e.target);
	    var text = $this.text();
	    if (text != '行业监测平台') {
	      this.setState({ subNav: false });
	    } else {
	      var isTrue = this.state.subNav;
	      console.log(isTrue);
	      if (!isTrue) {
	        this.setState({ subNav: true });
	      } else {
	        this.setState({ subNav: false });
	      }
	    }
	  },
	  subMenu: function subMenu(e) {
	    this.setState({ subNav: false });
	  },

	  render: function render() {
	    var select = null;
	    if (this.state.value) {
	      var selectProp = {
	        width: '160px',
	        className: 'index-selected',
	        value: this.state.value,
	        placeholder: '',
	        name: 'testselect',
	        id: 'indexSelected',
	        data: this.state.selectDataArr,
	        onChange: function (areaId, name) {
	          var routPath = this.props.location.pathname;
	          if (routPath == "/buildDetail") {
	            this.props.history.push('/parkMonitor?areaId=' + areaId);
	          } else {
	            this.getMenuParkSelectVal(areaId, name);
	          }
	        }.bind(this)
	      };
	      select = _react2.default.createElement(_index.Selected, selectProp);
	    }
	    var navActive = false;
	    var routPath = this.props.location.pathname;
	    if (routPath == '/P2P' || routPath == '/lineFinance' || routPath == '/smallLoan' || routPath == '/financeGuara' || routPath == '/privateFund') {
	      navActive = true;
	    } else {
	      navActive = false;
	    }

	    return _react2.default.createElement(
	      'div',
	      { className: 'menu' },
	      _react2.default.createElement(
	        'ul',
	        { className: 'nav' },
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;', className: navActive ? 'active' : '', onClick: this.menuSlide },
	            '行业监测平台'
	          ),
	          _react2.default.createElement(
	            'ul',
	            { className: this.state.subNav ? 'sub-nav show' : 'sub-nav hide' },
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/P2P', onClick: this.subMenu },
	                'P2P'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/lineFinance', onClick: this.subMenu },
	                '线下理财'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/smallLoan', onClick: this.subMenu },
	                '小额贷款'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/financeGuara', onClick: this.subMenu },
	                '融资担保'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/privateFund', onClick: this.subMenu },
	                '私募基金'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/TradingPlaces', onClick: this.subMenu },
	                '交易场所'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/RaiseIndex', onClick: this.subMenu },
	                '众筹监测'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/PawnMonitoring', onClick: this.subMenu },
	                '典当行业监测'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/financeLease', onClick: this.subMenu },
	                '融资租赁'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/commercialSecret', onClick: this.subMenu },
	                '商业保理'
	              )
	            ),
	            _react2.default.createElement(
	              'li',
	              null,
	              _react2.default.createElement(
	                _reactRouter.Link,
	                { activeClassName: 'active', to: '/prepaidCard', onClick: this.subMenu },
	                '预付卡'
	              )
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/parkMonitor', onClick: this.menuSlide },
	            '园区监测平台'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/InfoSearchIndex', onClick: this.menuSlide },
	            '企业全息信息查询平台'
	          )
	        ),
	        _react2.default.createElement(
	          'li',
	          null,
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: '/realtimeMonitor', onClick: this.menuSlide },
	            '实时监测平台'
	          )
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'right' },
	        _react2.default.createElement(
	          'div',
	          { className: 'right-park' },
	          select,
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;' },
	            '进入信息填报系统'
	          )
	        )
	      )
	    );
	  }
	});

	//module.exports = Menu;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	//   ,{selectval}
	// )(Menu)

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {
	    //获取下拉列表数据
	    menuParkSelectListRequest: state.MenuParkSelectList.request,
	    menuParkSelectListResult: state.MenuParkSelectList.result
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(MenuParkActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(Menu);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MenuPark.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 759:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDBasePie = _react2.default.createClass({
	  displayName: "BBDBasePie",

	  propTypes: {
	    option: _react2.default.PropTypes.object.isRequired,
	    style: _react2.default.PropTypes.object,
	    className: _react2.default.PropTypes.string,
	    theme: _react2.default.PropTypes.string,
	    onChartReady: _react2.default.PropTypes.func,
	    showLoading: _react2.default.PropTypes.bool,
	    onEvents: _react2.default.PropTypes.object
	  },
	  setOption: function setOption(parm) {
	    var option = {
	      color: parm.color,
	      title: {
	        text: parm.title,
	        x: parm.xtitle,
	        left: parm.titleLeft == undefined ? "auto" : parm.titleLeft,
	        top: parm.titleTop == undefined ? "auto" : parm.titleTop,
	        bottom: parm.titleBottom == undefined ? "auto" : parm.titleBottom,
	        textStyle: {
	          color: "#fff",
	          fontSize: 14,
	          fontWeight: parm.titleWeight || "normal",
	          fontFamily: 'Microsoft Yahei'
	        }
	      },
	      tooltip: {
	        trigger: 'item',
	        backgroundColor: 'rgba(0,0,0,0.7)',
	        padding: [10, 10, 10, 10],
	        formatter: function formatter(v) {
	          var _until = "";
	          if (parm.unit == undefined) {
	            _until = "";
	          } else {
	            _until = parm.unit;
	          }
	          if (parm.flag == "balanceDistri") {
	            return v.name + "<br/>" + v.seriesName + "<span style='color:#00b7f0'>" + v.value + _until + "亿元(" + v.percent + "%)" + "</span>";
	          } else {

	            return v.name + ":&nbsp;<span style='color:#00b7f0'>" + v.value + _until + "(" + v.percent + "%)" + "</span>";
	          }
	        }
	      },
	      legend: {
	        show: parm.legendShow,
	        orient: parm.legendOrient == undefined ? "vertical" : parm.legendOrient,
	        left: parm.legendLeft == undefined ? "auto" : parm.legendLeft,
	        top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	        right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	        bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	        itemGap: parm.legendItemGap || 10,
	        data: parm.legend,
	        textStyle: {
	          color: "#e6e6e6",
	          fontSize: 12,
	          fontWeight: "normal",
	          fontFamily: 'Microsoft Yahei'
	        }
	      },
	      series: [{
	        name: parm.seriesName,
	        type: 'pie',
	        avoidLabelOverlap: false,
	        selectedOffset: "5",
	        roseType: parm.roseType == undefined ? false : parm.roseType,
	        radius: parm.radius,
	        center: parm.center,
	        label: parm.lable,
	        labelLine: parm.labelLine == undefined ? {} : parm.labelLine,
	        data: parm.series,
	        itemStyle: {
	          emphasis: {
	            shadowBlur: 10,
	            shadowOffsetX: 0,
	            shadowColor: 'rgba(0, 0, 0, 0.5)'
	          }
	        }
	      }]
	    };

	    return option;
	  },
	  componentDidMount: function componentDidMount() {
	    var echartObj = this.renderEchartDom();
	    var onEvents = this.props.onEvents || [];

	    var _loop = function _loop(eventName) {
	      if (typeof eventName === 'string' && typeof onEvents[eventName] === 'function') {
	        echartObj.on(eventName, function (param) {
	          onEvents[eventName](param, echartObj);
	        });
	      }
	    };

	    for (var eventName in onEvents) {
	      _loop(eventName);
	    }
	    // if (typeof this.props.onChartReady === 'function') this.props.onChartReady(echartObj);
	    // elementResizeEvent(this.refs.echartsDom, function() {
	    // 	echartObj.resize();
	    // });
	    //
	    $(window).resize(function () {
	      echartObj.resize();
	    });
	  },
	  componentDidUpdate: function componentDidUpdate() {
	    this.renderEchartDom();
	  },
	  componentWillUnmount: function componentWillUnmount() {
	    echarts.dispose(this.refs.chart);
	  },
	  renderEchartDom: function renderEchartDom() {
	    var echartObj = this.getEchartsInstance();
	    echartObj.setOption(this.setOption(this.props.option));
	    if (this.props.showLoading) {
	      echartObj.showLoading();
	    } else {
	      echartObj.hideLoading();
	    }
	    return echartObj;
	  },
	  getEchartsInstance: function getEchartsInstance() {
	    return echarts.getInstanceByDom(this.refs.echartsDom) || echarts.init(this.refs.echartsDom, this.props.theme);
	  },
	  render: function render() {
	    var style = this.props.style || {
	      height: '300px'
	    };
	    return _react2.default.createElement("div", { ref: "echartsDom", style: style });
	  }
	});
	exports.default = BBDBasePie;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BasePie.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 805:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _PieChart = __webpack_require__(792);

	var _PieChart2 = _interopRequireDefault(_PieChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyQuality = _react2.default.createClass({
	    displayName: 'CompanyQuality',

	    getInitialState: function getInitialState() {
	        return {
	            pieData: null,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyQuality, this.props.companyQuality);
	        if (!isEqual) {
	            var companyQuality = nextProps.companyQuality;
	            //列表数据格式化

	            var _listData = [],
	                _legendData = [],
	                pieData = [];

	            for (var item in companyQuality) {
	                var items = {
	                    type: item,
	                    totleNum: companyQuality[item].length,
	                    companyList: companyQuality[item].join("、")
	                };

	                var _setPieData = {
	                    value: companyQuality[item].length,
	                    name: item
	                };

	                _listData.push(items);
	                _legendData.push(item);
	                pieData.push(_setPieData);
	            }

	            var _setParm = {
	                id: 'small-loan-company-chart', //必传
	                color: ['#efd79b', '#e24340'],
	                height: '300px', //必传 带上单位
	                title: '',
	                legendBottom: "0",
	                legendData: _legendData,
	                data: pieData
	            };
	            this.setState({ listData: _listData });
	            this.setState({ pieData: _setParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.pieData) {
	            chartBox = _react2.default.createElement(_PieChart2.default, { param: this.state.pieData });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: ' top-left-r' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                '试点企业性质'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                chartBox,
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pic-remark' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { style: { width: "40%" }, className: 'padding-l20' },
	                                    '类型'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { style: { width: "20%" } },
	                                    '数量'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { style: { width: "40%" } },
	                                    '机构名称'
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'td',
	                                            { className: 'padding-l20' },
	                                            item.type
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.totleNum,
	                                            '家'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': item.companyList, title: item.companyList },
	                                                item.companyList
	                                            )
	                                        )
	                                    );
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CompanyQuality;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 807:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var FundClass = _react2.default.createClass({
	    displayName: 'FundClass',

	    getInitialState: function getInitialState() {
	        return {
	            pieLeft: null,
	            pieRight: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getFundClassRequest = this.props.getFundClassRequest;

	        var jsonData = {};
	        getFundClassRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.fundClassRequest, this.props.fundClassResult);
	        if (!isEqual) {
	            var fundClassRequest = nextProps.fundClassRequest;
	            var fundClassResult = nextProps.fundClassResult;

	            if (fundClassRequest == true) {
	                if (fundClassResult.success) {
	                    var _setPieLegend = [],
	                        _setPieData = [],
	                        _setRosePieLegend = [],
	                        _setRosePieData = [];
	                    for (var i = 0; i < fundClassResult.content.length; i++) {
	                        var items = {};
	                        _setPieLegend.push(fundClassResult.content[i].typeName);
	                        if (fundClassResult.content[i].typeName == "股权投资基金") {
	                            for (var j = 0; j < fundClassResult.content[i].children.length; j++) {
	                                _setRosePieLegend.push(fundClassResult.content[i].children[j].typeName);
	                                var itemsChild = {
	                                    value: fundClassResult.content[i].children[j].amount,
	                                    name: fundClassResult.content[i].children[j].typeName
	                                };
	                                _setRosePieData.push(itemsChild);
	                            }

	                            items = {
	                                value: fundClassResult.content[i].amount,
	                                name: fundClassResult.content[i].typeName,
	                                selected: true
	                            };
	                        } else {
	                            items = {
	                                value: fundClassResult.content[i].amount,
	                                name: fundClassResult.content[i].typeName
	                            };
	                        }

	                        _setPieData.push(items);
	                    }
	                    var _setPieLeft = {
	                        "color": ["#e14340", "#deab61"],
	                        "title": "私募基金总分类",
	                        "xtitle": "",
	                        "titleLeft": "18%",
	                        "titleTop": "60%",
	                        "legend": _setPieLegend,
	                        "legendShow": true,
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "基金类型",
	                        "radius": "60%",
	                        "unit": "家",
	                        "lable": {
	                            normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '35%'],
	                        "series": _setPieData
	                    };

	                    var _setPieRight = {
	                        "color": ["#ff9b93", "#d58469", "#8bcaad", "#6b9f88", "#dfab62", "#c09f9a", "f7cf8a"],
	                        "title": "私募股权基金细分",
	                        "xtitle": "",
	                        "titleLeft": "19%",
	                        "titleTop": "60%",
	                        "legend": _setRosePieLegend,
	                        "legendShow": true,
	                        "roseType": "radius", //是否玫瑰型
	                        "radius": [20, 110],
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "基金类型",
	                        "unit": "家",
	                        "lable": {
	                            normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '35%'],
	                        "series": _setRosePieData
	                    };

	                    this.setState({ pieLeft: _setPieLeft });
	                    this.setState({ pieRight: _setPieRight });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var pieLeftBox = "",
	            pieRightBox = "";
	        if (this.state.pieLeft) {
	            pieLeftBox = _react2.default.createElement(_BasePie2.default, { option: this.state.pieLeft, style: { height: '550px', width: '100%' } });
	        }
	        if (this.state.pieRight) {
	            pieRightBox = _react2.default.createElement(_BasePie2.default, { option: this.state.pieRight, style: { height: '550px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                '私募基金分类'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-l' },
	                    pieLeftBox
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-r' },
	                    pieRightBox
	                )
	            )
	        );
	    }
	});

	module.exports = FundClass;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FundClass.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 808:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _HorizontalBarChart = __webpack_require__(809);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var FundCase = _react2.default.createClass({
	    displayName: 'FundCase',

	    getInitialState: function getInitialState() {
	        return {
	            pieLeft: null,
	            barRight: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var _props = this.props;
	        var getFundCaseRequest = _props.getFundCaseRequest;
	        var getFundCaseTopRequest = _props.getFundCaseTopRequest;

	        var jsonData = {};
	        getFundCaseRequest(jsonData);
	        getFundCaseTopRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.fundCaseRequest, this.props.fundCaseResult);
	        if (!isEqual) {
	            var fundCaseRequest = nextProps.fundCaseRequest;
	            var fundCaseResult = nextProps.fundCaseResult;

	            if (fundCaseRequest == true) {
	                if (fundCaseResult.success) {
	                    var _pieData = [],
	                        _pieLegend = [];
	                    for (var item in fundCaseResult.content) {
	                        _pieLegend.push(fundCaseResult.content[item].typeName);
	                        var pieItem = {
	                            value: fundCaseResult.content[item].amount,
	                            name: fundCaseResult.content[item].typeName
	                        };
	                        _pieData.push(pieItem);
	                    }
	                    var _setPieLeft = {
	                        "color": ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	                        "title": "上海私募证券投资机构发行产品类型分析",
	                        "xtitle": "",
	                        "titleLeft": "0",
	                        "legend": _pieLegend,
	                        "legendShow": true,
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "基金类型",
	                        "radius": "60%",
	                        "unit": "个",
	                        "lable": {
	                            normal: {
	                                show: true,
	                                formatter: function formatter(val) {
	                                    return val.value;
	                                }

	                            },
	                            emphasis: { show: false }
	                        },
	                        labelLine: {
	                            normal: {
	                                show: false
	                            }
	                        },
	                        "center": ['52%', '35%'],
	                        "series": _pieData
	                    };
	                    this.setState({ pieLeft: _setPieLeft });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqual = Immutable.is(nextProps.fundCaseTopRequest, this.props.fundCaseTopResult);
	        if (!isEqual) {
	            var fundCaseTopRequest = nextProps.fundCaseTopRequest;
	            var fundCaseTopResult = nextProps.fundCaseTopResult;

	            if (fundCaseTopRequest == true) {
	                var _barData = [],
	                    _baryAxis = [];

	                for (var item in fundCaseTopResult.content) {
	                    _baryAxis.push(fundCaseTopResult.content[item].companyName);
	                    var barItem = {
	                        value: fundCaseTopResult.content[item].productNumber,
	                        name: fundCaseTopResult.content[item].companyName
	                    };
	                    _barData.push(barItem);
	                }
	                var _setBarRight = {
	                    color: ["#e14340"],
	                    titleName: "上海私募证券投资机构发行产品数量前十",
	                    titleShow: true,
	                    barWidth: 20,
	                    legendRight: "20",
	                    xAxisLine: true,
	                    xAxisLabel: true,
	                    gridBottom: "20%",
	                    gridTop: "10%",
	                    gridRight: '15%',
	                    yAxisName: "",
	                    xAxisName: "产品数量",
	                    gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
	                    legend: [""],
	                    unit: "个",
	                    yAxis: _baryAxis,
	                    series: [_barData]

	                };
	                this.setState({ barRight: _setBarRight });
	            } else {
	                //错误后提示
	            }
	        }
	    },
	    render: function render() {
	        var pieBox = "",
	            barBox = "";
	        if (this.state.pieLeft) {
	            pieBox = _react2.default.createElement(_BasePie2.default, { option: this.state.pieLeft, style: { height: '550px', width: '100%' } });
	        }
	        if (this.state.barRight) {
	            barBox = _react2.default.createElement(_HorizontalBarChart2.default, { option: this.state.barRight, style: { height: '550px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                '私募证券基本情况'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-l' },
	                    pieBox
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-r' },
	                    barBox
	                )
	            )
	        );
	    }
	});

	module.exports = FundCase;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "FundCase.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 809:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDHorizontalBar = _react2.default.createClass({
	    displayName: "BBDHorizontalBar",

	    propTypes: {
	        option: _react2.default.PropTypes.object.isRequired,
	        style: _react2.default.PropTypes.object,
	        className: _react2.default.PropTypes.string,
	        theme: _react2.default.PropTypes.string,
	        onChartReady: _react2.default.PropTypes.func,
	        showLoading: _react2.default.PropTypes.bool,
	        onEvents: _react2.default.PropTypes.object
	    },
	    setOption: function setOption(parm) {
	        var itemStyle = {};
	        if (parm.gradient) {
	            itemStyle = {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{
	                        offset: 0,
	                        color: parm.gradient[0]
	                    }, {
	                        offset: 1,
	                        color: parm.gradient[1]
	                    }])
	                }
	            };
	        }

	        //值阀最大值
	        var seriesLineData = [];
	        for (var i = 0; i < parm.series.length; i++) {
	            var seriesBarItem = {
	                "type": "bar",
	                "name": parm.legend[i],
	                "itemStyle": itemStyle,
	                "label": parm.label == undefined ? {} : parm.label,
	                "barWidth": parm.barWidth,
	                "data": parm.series[i]
	            };
	            seriesLineData.push(seriesBarItem);
	        }

	        var option = {
	            color: parm.color,
	            title: {
	                show: parm.titleShow == undefined ? false : parm.titleShow,
	                text: parm.titleName,
	                // padding: [10, 0, 0, 15],
	                padding: parm.padding,
	                textStyle: {
	                    color: parm.textColor == undefined ? "#fff" : parm.textColor,
	                    //color: "#fff",
	                    fontSize: "12",
	                    fontWeight: "normal",
	                    fontFamily: "microsoft yahei"
	                }
	            },
	            grid: {
	                left: parm.gridLeft == undefined ? "auto" : parm.gridLeft,
	                right: parm.gridRight == undefined ? "auto" : parm.gridRight,
	                bottom: parm.gridBottom == undefined ? "auto" : parm.gridBottom,
	                top: parm.gridTop == undefined ? "auto" : parm.gridTop,
	                containLabel: true
	            },
	            legend: {
	                data: parm.legend,
	                show: parm.legendShow == undefined ? true : parm.legendShow,
	                itemWidth: 20,
	                itemHeight: 5,
	                // padding: [10, 0, 0, 30],
	                right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	                textStyle: {
	                    color: "#8f949a",
	                    fontSize: 12,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            tooltip: {
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                borderWidth: 1,
	                trigger: 'item',
	                formatter: function formatter(v) {
	                    var _until = "";
	                    if (parm.unit == undefined) {
	                        _until = "";
	                    } else {
	                        _until = parm.unit;
	                    }
	                    return v.name + " :&nbsp;<span style='color:" + parm.color[0] + "'>" + v.value + _until + "</span>";
	                }
	            },
	            xAxis: {

	                type: 'value',
	                name: parm.xAxisName,
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLine: {
	                    show: parm.xAxisLine == undefined ? false : parm.xAxisLine,
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.xAxisLabel == undefined ? false : parm.xAxisLabel,
	                    textStyle: {
	                        color: "#99a3b7"
	                    }
	                }
	            },
	            yAxis: {
	                type: 'category',
	                name: parm.yAxisName,
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: parm.yAxis,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    textStyle: {
	                        color: "#99a3b7"
	                    }
	                }
	            },
	            series: seriesLineData
	        };
	        return option;
	    },
	    componentDidMount: function componentDidMount() {
	        var echartObj = this.renderEchartDom();
	        var onEvents = this.props.onEvents || [];

	        var _loop = function _loop(eventName) {
	            if (typeof eventName === 'string' && typeof onEvents[eventName] === 'function') {
	                echartObj.on(eventName, function (param) {
	                    onEvents[eventName](param, echartObj);
	                });
	            }
	        };

	        for (var eventName in onEvents) {
	            _loop(eventName);
	        }
	        // if (typeof this.props.onChartReady === 'function') this.props.onChartReady(echartObj);
	        // elementResizeEvent(this.refs.echartsDom, function() {
	        // 	echartObj.resize();
	        // });
	        //
	        $(window).resize(function () {
	            echartObj.resize();
	        });
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        this.renderEchartDom();
	    },
	    componentWillUnmount: function componentWillUnmount() {
	        echarts.dispose(this.refs.chart);
	    },
	    renderEchartDom: function renderEchartDom() {
	        var echartObj = this.getEchartsInstance();
	        echartObj.setOption(this.setOption(this.props.option));
	        if (this.props.showLoading) {
	            echartObj.showLoading();
	        } else {
	            echartObj.hideLoading();
	        }
	        return echartObj;
	    },
	    getEchartsInstance: function getEchartsInstance() {
	        return echarts.getInstanceByDom(this.refs.echartsDom) || echarts.init(this.refs.echartsDom, this.props.theme);
	    },
	    render: function render() {
	        var style = this.props.style || {
	            height: '300px'
	        };
	        return _react2.default.createElement("div", { ref: "echartsDom", style: style });
	    }
	});
	exports.default = BBDHorizontalBar;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "HorizontalBarChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 810:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var EquityL = _react2.default.createClass({
	    displayName: 'EquityL',


	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getEquityLRequest = this.props.getEquityLRequest;

	        var jsonData = {};
	        getEquityLRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.equityLRequest, this.props.equityLResult);
	        if (!isEqual) {
	            var equityLRequest = nextProps.equityLRequest;
	            var equityLResult = nextProps.equityLResult;

	            if (equityLRequest == true) {
	                if (equityLResult.success) {

	                    var _chartData1 = [],
	                        _chartData2 = [],
	                        chartxAxis = [];
	                    for (var item in equityLResult.content) {
	                        chartxAxis.push(equityLResult.content[item].typeName);
	                        _chartData1.push(equityLResult.content[item].managedCapitalAmount);
	                        _chartData2.push(equityLResult.content[item].publishCompanyNumber);
	                    }
	                    var option = {
	                        "title": "截至2015年底上海市股权投资机构管理资本量",
	                        "color": ["#f5b94b", "#01b6ed"],
	                        "titleShow": "show",
	                        "titleX": "center",
	                        "legend": ["私募机构数量", "管理资本金额"],
	                        "legendShow": true,
	                        "legendLeft": "10%",
	                        "legendBottom": "20",
	                        "gridBottom": "20%",
	                        "barName": ["私募机构数量", "管理资本金额"],
	                        "xAxis": chartxAxis,
	                        "unit": ["", "亿元"],
	                        "yAxisName": ["亿元", "个数"],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [_chartData2, _chartData1]
	                        }
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var barbox = "";
	        if (this.state.chartData) {
	            barbox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartData, style: { height: '330px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bottom-r radius4' },
	            barbox
	        );
	    }
	});

	module.exports = EquityL;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityL.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 812:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var EquityM = _react2.default.createClass({
	    displayName: 'EquityM',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getEquityMRequest = this.props.getEquityMRequest;

	        var jsonData = {};
	        getEquityMRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.equityMRequest, this.props.equityMResult);
	        if (!isEqual) {
	            var equityMRequest = nextProps.equityMRequest;
	            var equityMResult = nextProps.equityMResult;

	            if (equityMRequest == true) {
	                if (equityMResult.success) {
	                    var _lineData = [],
	                        _barData1 = [],
	                        _barData2 = [],
	                        _barData3 = [],
	                        chartxAxis = [];
	                    for (var item in equityMResult.content) {
	                        chartxAxis.push(equityMResult.content[item].year);
	                        _lineData.push(equityMResult.content[item].quitNumber);
	                        _barData1.push(equityMResult.content[item].lessNumber);
	                        _barData2.push(equityMResult.content[item].betweenNumber);
	                        _barData3.push(equityMResult.content[item].greaterNumber);
	                    }
	                    var option = {
	                        "title": "2013-2015上海市股权投资市场退出及退出回报情况",
	                        "color": ["#efd79b", "#f6b750", "#e24340", "#02bde6"],
	                        "titleShow": "show",
	                        "titleX": "center",
	                        "legend": ["回报倍数小于1的数量", "回报数小于1-10倍", "回报数大于10倍", "退出数量"],
	                        "legendShow": true,
	                        "legendLeft": "10%",
	                        "legendBottom": "10",
	                        "gridBottom": "20%",
	                        "barName": ["回报倍数小于1的数量", "回报数小于1-10倍", "回报数大于10倍"],
	                        "lineName": ["退出数量"],
	                        "stack": "true", //是否堆叠
	                        "xAxis": ["2012", "2013", "2014", "2015"],
	                        "yAxisName": ["回报分布企业数", "退出企业数"],
	                        "barWidth": 30,
	                        "symbolSize": 5,
	                        "unit": ["家", "家", "家", "家"],
	                        "series": {
	                            "bar": [_barData1, _barData2, _barData3],
	                            "line": [_lineData]
	                        }
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var barbox = "";
	        if (this.state.chartData) {
	            barbox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartData, style: { height: '330px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bottom-r radius4' },
	            barbox
	        );
	    }
	});

	module.exports = EquityM;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityM.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 813:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var EquityR = _react2.default.createClass({
	    displayName: 'EquityR',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getEquityRRequest = this.props.getEquityRRequest;

	        var jsonData = {};
	        getEquityRRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.equityRRequest, this.props.equityRResult);
	        if (!isEqual) {
	            var equityRRequest = nextProps.equityRRequest;
	            var equityRResult = nextProps.equityRResult;

	            if (equityRRequest == true) {
	                if (equityRResult.success) {
	                    var _lineData = [],
	                        _barData = [],
	                        chartxAxis = [];
	                    for (var item in equityRResult.content) {
	                        chartxAxis.push(equityRResult.content[item].year);
	                        // _lineData.push(equityRResult.content[item].quitNumber);
	                        _barData.push(equityRResult.content[item].publishNumber);
	                        _lineData.push(equityRResult.content[item].investmentAmount);
	                    }
	                    var option = {
	                        "title": "2013-2015上海市股权投资市场投资金额情况",
	                        "color": ["#efd79b", "#e14340"],
	                        "titleShow": "show",
	                        "titleX": "center",
	                        "legend": ["投资金额", "披露数量"],
	                        "legendShow": true,
	                        "legendLeft": "10%",
	                        "legendBottom": "20",
	                        "gridBottom": "20%",
	                        "barName": ["投资金额"],
	                        "lineName": ["披露数量"],
	                        "xAxis": chartxAxis,
	                        "yAxisName": ["亿元", "数量"],
	                        "unit": ["亿元", "个"],
	                        "barWidth": 30,
	                        "symbolSize": 5,
	                        "series": {
	                            "bar": [_lineData],
	                            "line": [_barData]
	                        }
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var barbox = "";
	        if (this.state.chartData) {
	            barbox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartData, style: { height: '330px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bottom-r radius4' },
	            barbox
	        );
	    }
	});

	module.exports = EquityR;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityR.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 854:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _RadarChart = __webpack_require__(855);

	var _RadarChart2 = _interopRequireDefault(_RadarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var ScoreLeida = _react2.default.createClass({
		displayName: 'ScoreLeida',

		getInitialState: function getInitialState() {
			var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
			return {
				listData: [],
				leidaData: null,
				companyVal: _selectVal
			};
		},
		componentDidMount: function componentDidMount() {},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			if (nextProps.companyData == "") {
				return;
			}
			var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
			if (!isEqualCompany) {
				var getscoreLeidaRequest = this.props.getscoreLeidaRequest;

				getscoreLeidaRequest({ "platName": this.state.companyVal });
			}
			var isEqual = Immutable.is(nextProps.scoreLeidaResult, this.props.scoreLeidaResult);
			if (!isEqual) {
				var scoreLeidaRequest = nextProps.scoreLeidaRequest;
				var scoreLeidaResult = nextProps.scoreLeidaResult;

				if (scoreLeidaRequest == true) {
					if (scoreLeidaResult.success) {
						var socreNum = $(this.refs.scoreNum).html(scoreLeidaResult.content.score);
						var _setindicator = [];
						for (var item in scoreLeidaResult.content.indicator) {
							var items = {
								"name": scoreLeidaResult.content.indicator[item].name,
								"max": scoreLeidaResult.content.indicator[item].max + 30
							};
							_setindicator.push(items);
						}
						var chartOption = {
							"color": ["#00b8ee"],
							"legend": ["评分"],
							"legendShow": false,
							"series": scoreLeidaResult.content.series,
							"radarRadius": 110,
							"indicator": _setindicator
						};
						this.setState({ listData: scoreLeidaResult.content.indicator });
						this.setState({ leidaData: chartOption });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBoxBar = "";
			if (this.state.leidaData) {
				chartBoxBar = _react2.default.createElement(_RadarChart2.default, { option: this.state.leidaData, style: { height: '380px', width: '100%' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'right-t radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'评分雷达图'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						{ className: 'content-ul' },
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-l' },
							_react2.default.createElement(
								'p',
								{ className: 'orange socre-title' },
								'总评分：'
							),
							_react2.default.createElement('p', { className: 'orange score', ref: 'scoreNum' })
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-c' },
							_react2.default.createElement(
								'div',
								{ className: 'leida-c-pic' },
								chartBoxBar
							)
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-r' },
							_react2.default.createElement(
								'ul',
								{ className: 'score-leida-r-ul' },
								this.state.listData.map(function (item, index) {
									{

										return _react2.default.createElement(
											'li',
											null,
											_react2.default.createElement(
												'p',
												null,
												item.max
											),
											_react2.default.createElement(
												'span',
												null,
												item.name
											)
										);
									}
								})
							)
						)
					)
				)
			);
		}
	});

	module.exports = ScoreLeida;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "scoreLeida.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 901:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//融资租赁企业目录
	var Immutable = __webpack_require__(718);
	var innerdata = [];
	var outerdata = [];
	var Catalog = _react2.default.createClass({
	    displayName: 'Catalog',

	    getInitialState: function getInitialState() {
	        return {
	            CatalogCentent: [],
	            CompanyDirectoryData: [],
	            CatalogDirectoryData: [],
	            CatalogSelect: [],
	            CatalogAdd: []
	        };
	    },
	    //初始
	    componentDidMount: function componentDidMount() {
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        var jsonData = { 'areaName': '黄浦区' };
	        getContrastCatalognumRequest(jsonData);

	        var getSelectRequest = this.props.getSelectRequest;

	        var jsonData = { 'areaId': 104 };
	        getSelectRequest(jsonData);

	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //下拉框
	        var isEqual = Immutable.is(nextProps.CatalogSelectNumChartRequest, this.props.CatalogSelectNumChartResult);
	        if (!isEqual) {
	            var CatalogSelectNumChartRequest = nextProps.CatalogSelectNumChartRequest;
	            var CatalogSelectNumChartResult = nextProps.CatalogSelectNumChartResult;

	            if (CatalogSelectNumChartRequest == true) {
	                if (CatalogSelectNumChartResult.success) {
	                    this.dataCatalogSelect(CatalogSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        //列表
	        var isEqual = Immutable.is(nextProps.ContrastCatalogNumChartRequest, this.props.ContrastCatalogNumChartResult);
	        if (!isEqual) {
	            var ContrastCatalogNumChartRequest = nextProps.ContrastCatalogNumChartRequest;
	            var ContrastCatalogNumChartResult = nextProps.ContrastCatalogNumChartResult;

	            if (ContrastCatalogNumChartRequest == true) {
	                if (ContrastCatalogNumChartResult.success) {
	                    this.dataFomat(ContrastCatalogNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    //列表
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ CatalogCentent: content });
	    },
	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("qqqqqqqqqqqqqqqqqqqqqq",selectVar)
	        this.setState({ CatalogSelect: selectVar });
	    },
	    //风险状态判断
	    quarterChoice: function quarterChoice(value) {
	        var areaName = $("#indexSelected").find('.mt-select-title').text();
	        var analysisResult = $("#indexSelectedFeng").attr('data-val');
	        var riskA = $("#indexSelectedShi").attr('data-val');
	        var riskB = $("#indexSelectedWei").attr('data-val');
	        var riskC = $("#indexSelectedAdd").attr('data-val');
	        var riskD = $("#indexSelectedBtt").attr('data-val');
	        var areaNameData = { 'areaName': areaName, 'analysisResult': analysisResult, "riskA": riskA, "riskB": riskB, "riskC": riskC, "riskD": riskD };
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        getContrastCatalognumRequest(areaNameData);
	        //console.info("jifei++++",areaNameData)
	    },
	    render: function render() {
	        //下拉选择列表头         
	        var selectProp = {
	            width: '110px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '黄浦区',
	            name: 'testselect',
	            data: this.state.CatalogSelect,
	            onChange: function (value, label) {
	                this.quarterChoice(label);
	            }.bind(this)
	        };
	        //下拉选择风险状态
	        var selectPropL = {
	            width: '55px',
	            className: 'index-selected',
	            value: '',
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: '', label: '全部' }, { value: 0, label: '正常' }, { value: 1, label: '潜在' }],
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);         
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        //下拉选择全部
	        var selectProps = {
	            width: '55px',
	            className: 'index-selected',
	            value: '',
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: '', label: '全部' }, { value: 1, label: '是' }],
	            onChange: function (value, label) {
	                console.log('当前值为：', value);
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'Catalog mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市融资租赁企业目录'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'total' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { ref: 'totleCount' },
	                        this.state.CatalogCentent.length
	                    ),
	                    '家企业'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'right' },
	                    _react2.default.createElement(
	                        'em',
	                        null,
	                        '地区筛选'
	                    ),
	                    _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelected' }))
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'tabs' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'wtyh-table table-border-b' },
	                    _react2.default.createElement(
	                        'thead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width1' },
	                                '序号'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width2' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '公司名称'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width3' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '注册地址'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width4' },
	                                '风险状态',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectPropL, { id: 'indexSelectedFeng' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { colSpan: '4', className: 'width5' },
	                                '潜在风险'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '失联',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedShi' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '未参加自查',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedWei' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上零认缴',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedAdd' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上未经营',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedBtt' }))
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box', id: 'platformBase-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.CatalogCentent.map(function (item, index) {
	                                var Green = '';
	                                item.riskStatus == "正常" ? Green = 'Green' : Green = 'Yellow';
	                                var riskStatusA = item.riskStatusA == null ? "—" : item.riskStatusA;
	                                var riskStatusB = item.riskStatusB == null ? "—" : item.riskStatusB;
	                                var riskStatusC = item.riskStatusC == null ? "—" : item.riskStatusC;
	                                var riskStatusD = item.riskStatusD == null ? "—" : item.riskStatusD;
	                                if (index % 2) {
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
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD', title: item.companyName },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD', title: item.address },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
	                                        )
	                                    );
	                                } else {
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
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD', title: item.companyName },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD', title: item.address },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
	                                        )
	                                    );
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = Catalog;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Catalog.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 908:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".commercialS-index .right-bottom tbody td,\r\n.commercialS-index .right-bottom thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content {\r\n\theight: 560px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content .mt-table,\r\n.commercialS-index .right-bottom .table-title  .mt-table {\r\n\tmargin: 0px;\r\n}\r\n\r\n.commercialS-index .right-bottom  .mod-content {\r\n\tpadding: 10px 20px 20px 20px;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table {\r\n\r\n\t/*height: 100%*/\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table  td {\r\n\tpadding: 16px 0px;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-content  table tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.commercialS-index .right-bottom .table-title th {\r\n\theight: 50px\r\n}\r\n\r\n.commercialS-index .right-bottom  .mod-title .totle-num {\r\n\tfont-size: 14px;\r\n\tcolor: #fff;\r\n\tfloat: right;\r\n\tdisplay: inline-block;\r\n\tmargin: 15px 20px 0px 0px;\r\n}\r\n\r\n.commercialS-index a {\r\n\tcolor: #e14340 !important\r\n}\r\n\r\n.mt-select.company-dire {\r\n\tbackground: #393a48;\r\n\tborder: 1px #393a48 solid;\r\n\tmargin-left: 5px;\r\n\theight: 25px;\r\n\tline-height: 25px;\r\n}\r\n\r\n.mt-select.company-dire .mt-select-title {\r\n\theight: 25px;\r\n}\r\n\r\n.mt-select.company-dire .mt-select-box {\r\n\tbackground: #1f1f27;\r\n\tborder: 1px #1f1f27 solid\r\n}\r\n\r\n.modLong .long {\r\n\twidth: 250px;\r\n}\r\n\r\n.commercialS-index .wtyh-table tbody td .word-limit-5 {\r\n\twidth: 150px;\r\n}", ""]);

	// exports


/***/ },

/***/ 926:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(927);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//园区监测
	var Imgs = _react2.default.createClass({
	    displayName: 'Imgs',

	    getInitialState: function getInitialState() {
	        return {
	            areaId: "",
	            parImg: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        if (areaId != undefined) {
	            this.setState({ areaId: areaId });
	            var jsonData = { areaId: areaId };
	            this.getParkImg(jsonData);
	        }
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var isSelectValEqual = Immutable.is(nextProps.menuParkSelectVal, this.props.menuParkSelectVal);
	        if (!isSelectValEqual) {
	            var menuParkSelectVal = nextProps.menuParkSelectVal;

	            var jsonData = { areaId: menuParkSelectVal.areaId };
	            this.setState({ areaId: menuParkSelectVal.areaId });

	            this.getParkImg(jsonData);
	        }
	        //园区图片
	        var isParkEqual = Immutable.is(nextProps.parkImgResult, this.props.parkImgResult); //判断数据是否变化
	        if (!isParkEqual) {
	            var parkImgRequest = nextProps.parkImgRequest;
	            var parkImgResult = nextProps.parkImgResult;

	            if (parkImgRequest == true) {
	                if (parkImgResult.success == true) {
	                    console.log(parkImgResult, 99999999999);
	                    this.parkImgFomat(parkImgResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    parkImgFomat: function parkImgFomat(data) {
	        var imgUrl = data.content;
	        console.log(imgUrl, 'imgUrl');
	        $('.Imgs').css({
	            "background": "url(" + imgUrl + ")",
	            "background-size": "100% auto",
	            "background-repeat": "no-repeat"
	        });
	    },
	    getParkImg: function getParkImg(json) {
	        var getParkImg = this.props.getParkImg;

	        getParkImg(json);
	    },

	    render: function render() {
	        return _react2.default.createElement('div', { className: 'Imgs' });
	    }
	});
	module.exports = Imgs;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Imgs.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 929:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(927);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//舆情
	var Consensu = _react2.default.createClass({
	  displayName: 'Consensu',

	  getInitialState: function getInitialState() {
	    return {
	      consensu: []
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var areaId = this.props.location.query.areaId;
	    if (areaId != undefined) {
	      var jsonData = { areaId: areaId };
	      this.getParkNews(jsonData);
	    }
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isSelectValEqual = Immutable.is(nextProps.menuParkSelectVal, this.props.menuParkSelectVal);
	    if (!isSelectValEqual) {
	      var menuParkSelectVal = nextProps.menuParkSelectVal;

	      var jsonData = { areaId: menuParkSelectVal.areaId };
	      console.log(jsonData, 11111111);
	      this.getParkNews(jsonData);
	    }

	    var isEqual = Immutable.is(nextProps.parkNewsResult, this.props.parkNewsResult); //判断数据是否变化
	    if (!isEqual) {
	      var parkNewsRequest = nextProps.parkNewsRequest;
	      var parkNewsResult = nextProps.parkNewsResult;

	      if (parkNewsRequest == true) {
	        if (parkNewsResult.success == true) {
	          this.dataFomat(parkNewsResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var contentStr = data.content;
	    console.log(contentStr, 9999);
	    var contentJson = null;
	    var results = null;
	    if (contentStr) {
	      contentJson = JSON.parse(contentStr);
	      results = contentJson.results;
	    } else {
	      results = [];
	    }
	    this.setState({ consensu: results });
	  },

	  getParkNews: function getParkNews(menuParkSelectVal) {
	    var getParkNews = this.props.getParkNews;

	    getParkNews(menuParkSelectVal);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Consensu mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-title' },
	        _react2.default.createElement(
	          'h3',
	          null,
	          '舆情'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'mod-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'box' },
	          this.state.consensu.map(function (elem, index) {
	            return _react2.default.createElement(
	              'div',
	              { className: 'list', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  _react2.default.createElement(
	                    'a',
	                    { href: elem.bbd_url },
	                    index + 1,
	                    _react2.default.createElement(
	                      'span',
	                      { className: 'liLeft' },
	                      elem.search_key
	                    )
	                  )
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  elem.news_title
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  _react2.default.createElement(
	                    'span',
	                    { className: 'liRight' },
	                    _react2.default.createElement(
	                      'span',
	                      { className: 'spanLeft' },
	                      elem.fromSite
	                    ),
	                    elem.pubdate
	                  )
	                )
	              )
	            );
	          })
	        )
	      )
	    );
	  }
	});
	module.exports = Consensu;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	// )(Consensu)

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Consensu.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 930:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(927);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//类金融企业集中度
	var Finance = _react2.default.createClass({
	    displayName: 'Finance',

	    getInitialState: function getInitialState() {
	        return {
	            item: [],
	            areaId: 0
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        if (areaId != undefined) {
	            var jsonData = { areaId: areaId };
	            this.getParkFinance(jsonData);
	        }
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var isSelectValEqual = Immutable.is(nextProps.menuParkSelectVal, this.props.menuParkSelectVal);
	        if (!isSelectValEqual) {
	            var menuParkSelectVal = nextProps.menuParkSelectVal;

	            var jsonData = { areaId: menuParkSelectVal.areaId };
	            this.setState({ areaId: menuParkSelectVal.areaId });
	            this.getParkFinance(jsonData);
	        }

	        var isEqual = Immutable.is(nextProps.parkFinanceResult, this.props.parkFinanceResult); //判断数据是否变化
	        console.log(isEqual, 'xuyao isEqual');
	        if (!isEqual) {
	            var parkFinanceRequest = nextProps.parkFinanceRequest;
	            var parkFinanceResult = nextProps.parkFinanceResult;

	            if (parkFinanceRequest == true) {
	                if (parkFinanceResult.success == true) {
	                    console.log(parkFinanceResult, '类金融企业集中度11111');
	                    this.dataFomat(parkFinanceResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ item: content });
	    },
	    getParkFinance: function getParkFinance(menuParkSelectVal) {
	        var getParkFinance = this.props.getParkFinance;

	        getParkFinance(menuParkSelectVal);
	    },
	    //获取大厦的名称
	    ImgbtnAdd: function ImgbtnAdd(e) {
	        var imgId = $(e.target).attr("data-img");
	        var nameId = $(e.target).attr("data-name");
	        console.log(imgId);
	    },

	    render: function render() {
	        var areaId = this.state.areaId;
	        return _react2.default.createElement(
	            'div',
	            { className: 'Finance mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '类金融企业集中度'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'item' },
	                        _react2.default.createElement(
	                            'ul',
	                            null,
	                            this.state.item.map(function (elem, index) {
	                                var buildingId = elem.buildingId;
	                                var idex = index % 3;
	                                console.log(idex, index, 222222222222);
	                                return _react2.default.createElement(
	                                    'li',
	                                    { key: index },
	                                    _react2.default.createElement(
	                                        _reactRouter.Link,
	                                        { to: { pathname: '/buildDetail', query: { areaId: areaId, buildingId: buildingId } } },
	                                        _react2.default.createElement('img', { onClick: this.ImgbtnAdd, 'data-img': elem.buildingId, src: "../images/lou" + (idex + 1) + ".png" }),
	                                        _react2.default.createElement(
	                                            'span',
	                                            { 'data-name': elem.name, className: 'name' },
	                                            elem.name
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'num-ratio' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'num' },
	                                            elem.finComNum
	                                        ),
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'ratio' },
	                                            elem.finComRatio
	                                        )
	                                    )
	                                );
	                            }.bind(this))
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = Finance;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	// )(Finance)

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Finance.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 931:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(927);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var myChart;
	var option;
	//园区行业分布
	var Park = _react2.default.createClass({
	    displayName: 'Park',

	    getInitialState: function getInitialState() {
	        return {
	            Park: [],
	            ParkEnd: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        if (areaId != undefined) {
	            var jsonData = { areaId: areaId };
	            this.getParkIndustry(jsonData);
	        }
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isSelectValEqual = Immutable.is(nextProps.menuParkSelectVal, this.props.menuParkSelectVal);
	        if (!isSelectValEqual) {
	            var menuParkSelectVal = nextProps.menuParkSelectVal;

	            var jsonData = { areaId: menuParkSelectVal.areaId };
	            this.getParkIndustry(jsonData);
	        }

	        var isEqual = Immutable.is(nextProps.parkIndustryResult, this.props.parkIndustryResult); //判断数据是否变化
	        if (!isEqual) {
	            var parkIndustryRequest = nextProps.parkIndustryRequest;
	            var parkIndustryResult = nextProps.parkIndustryResult;

	            if (parkIndustryRequest == true) {
	                if (parkIndustryResult.success == true) {
	                    console.log(parkIndustryResult, '园区行业分布111');
	                    this.dataFomat(parkIndustryResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        var ParkBox = [];
	        var ParkContent = [];
	        for (var i = 0; i < content.length; i++) {
	            ParkBox.push({ value: content[i].count, name: content[i].type });
	        };
	        for (var j = 0; j < content[0].children.length; j++) {
	            ParkContent.push({ value: content[0].children[j].count, name: content[0].children[j].type });
	        };
	        this.initMap(ParkBox, ParkContent);
	    },
	    getParkIndustry: function getParkIndustry(menuParkSelectVal) {
	        var getParkIndustry = this.props.getParkIndustry;

	        getParkIndustry(menuParkSelectVal);
	    },
	    initMap: function initMap(ParkBox, ParkEnd) {
	        myChart = echarts.init(document.getElementById("myChart"));
	        option = {
	            backgroundColor: '#2b323c',
	            color: ['#c33533', '#61a0a9', '#54656f', '#6e6f71', '#2f4553', '#c09f9a', '#dfab62'],
	            title: {
	                text: "园区行业分布",
	                x: "left",
	                y: "top",
	                top: "5px",
	                left: "5px",
	                textStyle: {
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    color: '#fff',
	                    fontFamily: "microsoft yahei"
	                }
	            },
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b}{c}"
	            },
	            legend: {
	                orient: 'vertical',
	                x: '80%',
	                y: "80%",
	                textStyle: {
	                    color: "#dddddd"
	                },
	                data: ['金融', '类金融', '其他']
	            },
	            series: [{
	                type: 'pie',
	                selectedMode: 'single',
	                center: ['45%', 200],
	                radius: [0, '30%'],
	                label: {
	                    normal: {
	                        show: false
	                    }
	                },
	                labelLine: {
	                    normal: {
	                        show: false
	                    }
	                },
	                data: ParkBox
	            }, {
	                type: 'pie',
	                center: ['45%', 200],
	                radius: ['40%', '60%'],
	                data: ParkEnd
	            }]
	        };
	        myChart.setOption(option);
	        myChart.resize();
	    },

	    // ajaxPark(){
	    //     $.ajax({
	    //         url: 'park/businessDistribute.do',
	    //         type: 'get',
	    //         dataType: 'json',
	    //         data: {areaId: ""},
	    //         success:function(res){
	    //             if(res.success){
	    //                 var ParkBox = [];
	    //                 var ParkContent = [];
	    //                 for(var i=0; i< res.content.length; i++){
	    //                     ParkBox.push({value:res.content[i].count,name:res.content[i].type});
	    //                 };
	    //                 for(var j=0; j< res.content[0].children.length; j++){
	    //                     ParkContent.push({value:res.content[0].children[j].count,name:res.content[0].children[j].type})
	    //                 };
	    //             }
	    //           this.initMap(ParkBox,ParkContent)
	    //         }.bind(this)
	    //     })
	    // },

	    // componentDidMount() {   
	    //   this.ajaxPark();

	    //     $(window).resize(function(event) {
	    //       this.initMap();
	    //     }.bind(this));
	    // },

	    // componentWillReceiveProps(nextProps) {
	    //     this.ajaxPark();
	    // },

	    render: function render() {
	        return _react2.default.createElement('div', { className: 'Park', id: 'myChart' });
	    }
	});
	module.exports = Park;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	// )(Park)

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Park.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 932:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(927);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(809);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//在营时间分布
	var TheCamp = _react2.default.createClass({
	    displayName: 'TheCamp',

	    getInitialState: function getInitialState() {
	        return {
	            TheCamp: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        if (areaId != undefined) {
	            var jsonData = { areaId: areaId };
	            this.getParkCamp(jsonData);
	        }
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isSelectValEqual = Immutable.is(nextProps.menuParkSelectVal, this.props.menuParkSelectVal);
	        if (!isSelectValEqual) {
	            console.log(33333333333333);
	            var menuParkSelectVal = nextProps.menuParkSelectVal;

	            var jsonData = { areaId: menuParkSelectVal.areaId };
	            this.getParkCamp(jsonData);
	        }

	        var isEqual = Immutable.is(nextProps.parkCampResult, this.props.parkCampResult); //判断数据是否变化
	        if (!isEqual) {
	            var parkCampRequest = nextProps.parkCampRequest;
	            var parkCampResult = nextProps.parkCampResult;

	            if (parkCampRequest == true) {
	                if (parkCampResult.success == true) {
	                    this.dataFomat(parkCampResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        var TheCampBox = [];
	        for (var i = 0; i < content.length; i++) {
	            TheCampBox.push(content[i].count);
	        }
	        this.setState({ TheCamp: TheCampBox });
	    },
	    getParkCamp: function getParkCamp(menuParkSelectVal) {
	        var getParkCamp = this.props.getParkCamp;

	        getParkCamp(menuParkSelectVal);
	    },
	    setBarParm: function setBarParm() {
	        var option = {
	            color: ["#e14340"],
	            titleName: "在营分布",
	            titleNameX: "28px",
	            gridRight: "11%",
	            gridLeft: "2%",
	            gridTop: "5%",
	            padding: [10, 10, 10, 12],
	            Color: "#919bae",
	            titleShow: true,
	            barWidth: 25,
	            legendRight: "20",
	            xAxisName: "企业数",
	            xAxisLine: true,
	            xAxisLabel: true,
	            gradient: ['rgb(193, 42, 39)', 'rgb(251, 99, 96)'],
	            legend: [""],
	            yAxis: ['10年以上', '5-10年', '3-5年', '1-3年', '1年以下'],
	            series: [this.state.TheCamp]
	        };
	        return option;
	    },

	    //ajax请求
	    // ajaxTheCamp(val){
	    //    $.ajax({
	    //         url: 'park/inBusiness.do',
	    //         type: 'get',
	    //         dataType: 'json',
	    //         data: {areaId: val},
	    //         success:function(res){
	    //             console.log(res)
	    //             if(res.success){
	    //                     var TheCampBox = [];
	    //                     for(var i=0 ; i< res.content.length ; i++){
	    //                     TheCampBox.push(res.content[i].count)
	    //                 } 
	    //                 this.setState({
	    //                     TheCamp:TheCampBox
	    //             }) 
	    //         }
	    //         }.bind(this)
	    //     });
	    // },   
	    // componentDidMount(){
	    //     this.ajaxTheCamp(this.props.val);    
	    // },
	    // componentWillReceiveProps(nextProps){
	    //     this.ajaxTheCamp();
	    // },

	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'TheCamp mod', id: 'TheCamp' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '在营时间分布'
	                )
	            ),
	            _react2.default.createElement(_HorizontalBarChart2.default, {
	                option: this.setBarParm(),
	                style: { height: '270px', width: '97%' } })
	        );
	    }
	});
	module.exports = TheCamp;
	// export default connect(
	//   state => ({
	//     val : state.selectval.val
	//   })
	// )(TheCamp)

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TheCamp.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 935:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(936);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//import { ImgFinanceval } from '../../ions/parkMonitor/ImgFinancek/ImgFinance'

	//园区监测
	var BuildRisk = _react2.default.createClass({
	    displayName: 'BuildRisk',

	    getInitialState: function getInitialState() {
	        return {
	            parkImg: "",
	            //大厦
	            buildList: [],
	            curBuild: "",
	            curBuildIndex: 0,
	            areaId: 0,
	            buildingId: 0,
	            buildingImg: "",
	            //风险企业
	            buildRisk: [],

	            haveRiskCompany: [], //已出风险 黑灯
	            focusCompany: [], //重点关注 红灯
	            generalCompany: [], //一般关注企业 黄灯
	            normalCompany: [], //正常企业 绿灯

	            showBuildRisk: [], //存储当前风险企业的数组

	            haveRiskLen: 0,
	            focusLen: 0,
	            generalLen: 0,
	            normalLen: 0,

	            show: false, //控制风险企业列表显示隐藏
	            warnClass: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        var buildingId = this.props.location.query.buildingId;

	        this.setState({ areaId: areaId, buildingId: buildingId });

	        var buildingIdJson = { buildingId: buildingId };
	        var areaIdJson = { areaId: areaId };
	        this.getBuildList(areaIdJson);
	        this.getBuildRisk(buildingIdJson);

	        this.riskListSwitch();
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //切换大厦
	        var isSwitchValEqual = Immutable.is(nextProps.buildSwitchVal, this.props.buildSwitchVal);
	        if (!isSwitchValEqual) {
	            var buildSwitchVal = nextProps.buildSwitchVal;

	            console.log(buildSwitchVal, 9666666666666);
	            var areaId = this.state.areaId;
	            var buildingId = buildSwitchVal.buildId;

	            this.setState({ buildingId: buildingId });

	            var buildingIdJson = { buildingId: buildingId };
	            var areaIdJson = { areaId: areaId };
	            this.getBuildList(areaIdJson);
	            this.getBuildRisk(buildingIdJson);
	        }

	        //风险企业
	        var isRiskEqual = Immutable.is(nextProps.buildRiskResult, this.props.buildRiskResult); //判断数据是否变化
	        if (!isRiskEqual) {
	            var buildRiskRequest = nextProps.buildRiskRequest;
	            var buildRiskResult = nextProps.buildRiskResult;

	            if (buildRiskRequest == true) {
	                if (buildRiskResult.success == true) {
	                    this.riskCompanyDataFomat(buildRiskResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	        //大厦列表
	        var isListEqual = Immutable.is(nextProps.buildListResult, this.props.buildListResult); //判断数据是否变化
	        if (!isListEqual) {
	            var buildListRequest = nextProps.buildListRequest;
	            var buildListResult = nextProps.buildListResult;

	            if (buildListRequest == true) {
	                if (buildListResult.success == true) {
	                    this.listDataFomat(buildListResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    riskCompanyDataFomat: function riskCompanyDataFomat(data) {
	        //设置风险企业列表
	        var _this = this;
	        var content = data.content;
	        this.setState({ buildRisk: content, showBuildRisk: content }, function () {
	            _this.riskCompanyScreen(); //风险企业筛选
	        });
	    },
	    riskCompanyScreen: function riskCompanyScreen() {
	        //风险企业筛选
	        var buildRisk = this.state.buildRisk;
	        var len = buildRisk.length;

	        var haveRiskCompany = []; //已出风险 黑灯
	        var focusCompany = []; //重点关注 红灯
	        var generalCompany = []; //一般关注企业 黄灯
	        var normalCompany = []; //正常企业 绿灯

	        for (var i = 0; i < len; i++) {
	            var r = buildRisk[i];
	            var flag = r.analysisResult;
	            if (flag == 1) {
	                haveRiskCompany.push(r);
	            } else if (flag == 2) {
	                focusCompany.push(r);
	            } else if (flag == 3) {
	                generalCompany.push(r);
	            } else {
	                normalCompany.push(r);
	            }
	        }
	        this.setState({
	            haveRiskCompany: haveRiskCompany,
	            focusCompany: focusCompany,
	            generalCompany: generalCompany,
	            normalCompany: normalCompany,
	            haveRiskLen: haveRiskCompany.length,
	            focusLen: focusCompany.length,
	            generalLen: generalCompany.length,
	            normalLen: normalCompany.length
	        });
	    },
	    listDataFomat: function listDataFomat(data) {
	        //大厦
	        var _this = this;
	        var content = data.content;
	        var curBuildId = this.state.buildingId; //取得当前buildingId
	        var len = content.length;
	        var j = 0;
	        for (var i = 0; i < len; i++) {
	            console.log(content[i]);
	            var bId = content[i].buildingId;
	            console.log(bId, curBuildId, '对比');
	            if (bId == curBuildId) {
	                j = i;
	                break;
	            }
	        }
	        var imgUrl = content[j].imgUrl;

	        $('.Img').css({
	            "background": "url(" + imgUrl + ")",
	            "background-size": "100% auto",
	            "background-repeat": "no-repeat"
	        });
	        this.setState({ buildList: content, curBuild: content[j], curBuildIndex: j });
	    },
	    getBuildRisk: function getBuildRisk(json) {
	        var getBuildRisk = this.props.getBuildRisk;

	        getBuildRisk(json);
	    },
	    getBuildList: function getBuildList(json) {
	        var getBuildList = this.props.getBuildList;

	        getBuildList(json);
	    },
	    getBuildSwitchVal: function getBuildSwitchVal(json) {
	        var getBuildSwitchVal = this.props.getBuildSwitchVal;

	        getBuildSwitchVal(json);
	    },
	    riskListSwitch: function riskListSwitch() {
	        //风险企业切换
	        console.log('切换');
	        var _this = this;
	        $('.risk-list').on('click', 'tr', function () {
	            var $this = $(this);
	            var num = $this.find('.r').text();
	            if (num == "0") {
	                return false;
	            } else {
	                var tbody = $(this).parent('tbody').find('tr').removeClass('active');
	                $this.addClass('active');
	                var val = $this.data('val');
	                var riskCompany = "";
	                var warnClass = "";
	                if (val == "haveRisk") {
	                    riskCompany = _this.state.haveRiskCompany;
	                    warnClass = "Black";
	                } else if (val == "focus") {
	                    riskCompany = _this.state.focusCompany;
	                    warnClass = "Red";
	                } else if (val == "general") {
	                    riskCompany = _this.state.generalCompany;
	                    warnClass = "Yellow";
	                } else {
	                    riskCompany = _this.state.normalCompany;
	                    warnClass = "Green";
	                }
	                console.log(warnClass, '333333333333');
	                _this.setState({ showBuildRisk: riskCompany, show: true, warnClass: warnClass });
	            }
	        });
	    },
	    handleBuild: function handleBuild(ele, e) {
	        //大厦切换
	        var len = this.state.buildList.length; //获取大厦的个数
	        var index = this.state.curBuildIndex;
	        if (ele == -1) {
	            if (index > 0) {
	                index = index - 1;
	            }
	        } else {
	            if (index < len - 1) {
	                index = index + 1;
	            }
	        }
	        var curBuild = this.state.buildList[index];
	        var curBuildId = this.state.buildList[index].buildingId;
	        var curBuildName = this.state.buildList[index].name;
	        var parkId = this.state.buildList[index].parkId;
	        this.setState({ curBuildIndex: index, curBuild: curBuild });

	        this.getBuildSwitchVal({ buildId: curBuildId, buildName: curBuildName, parkId: parkId });
	    },
	    render: function render() {

	        return _react2.default.createElement(
	            'div',
	            { className: 'Img mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'carousel' },
	                _react2.default.createElement('i', { className: 'iconfont icon-jianLeft left', onClick: this.handleBuild.bind(this, -1) }),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'list-box' },
	                    _react2.default.createElement(
	                        'ul',
	                        null,
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            this.state.curBuild.name
	                        )
	                    )
	                ),
	                _react2.default.createElement('i', { className: 'iconfont icon-jianRight right', onClick: this.handleBuild.bind(this, 1) })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'tabs risk-list' },
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
	                                '风险等级'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '数量'
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tbody',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            { className: '', 'data-val': 'focus' },
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Red' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'color r' },
	                                this.state.focusLen
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            { 'data-val': 'general' },
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Yellow' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                this.state.generalLen
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            { 'data-val': 'normal' },
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Green' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                this.state.normalLen
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            { 'data-val': 'haveRisk' },
	                            _react2.default.createElement(
	                                'td',
	                                null,
	                                _react2.default.createElement('i', { className: 'iconfont icon-warning Black' })
	                            ),
	                            _react2.default.createElement(
	                                'td',
	                                { className: 'r' },
	                                this.state.haveRiskLen
	                            )
	                        )
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'onTabs' },
	                _react2.default.createElement(
	                    'div',
	                    { className: this.state.show ? "tableLeft show" : "tableLeft" },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'mod-title' },
	                        _react2.default.createElement(
	                            'h3',
	                            null,
	                            '已出风险企业'
	                        ),
	                        _react2.default.createElement('i', { className: "iconfont icon-warning " + this.state.warnClass })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'box' },
	                        _react2.default.createElement(
	                            'table',
	                            null,
	                            _react2.default.createElement(
	                                'tbody',
	                                null,
	                                this.state.showBuildRisk.map(function (elem, index) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                null,
	                                                elem.name
	                                            )
	                                        )
	                                    );
	                                })
	                            )
	                        )
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'yuan' },
	                _react2.default.createElement('img', { src: '' })
	            )
	        );
	    }
	});
	module.exports = BuildRisk;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BuildRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 937:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*@parkMonitor jifei  图片\r\n---------------------------------------------------------*/\r\n.Img{\r\n\twidth: 100%;\r\n\theight: 948px;\r\n\t/*background: url(\"/images/floor.png\") no-repeat;*/\r\n\tbackground-size: 100% 948px;\r\n}\r\n.Img .carousel{\r\n\twidth: 180px;\r\n\theight: 30px;\r\n\tbackground: #e2f1fc;\r\n\tborder-radius: 3px;\r\n\tposition: relative;\r\n    top: 10px;\r\n    left: 10px;\r\n}\r\n.Img .carousel i{\r\n\tdisplay: block;\r\n\tline-height: 30px;\r\n\tmargin-left: 3px;\r\n\tcolor: #1a2029;\r\n\tfont-size: 18px;\r\n\tcursor: pointer;\r\n}\r\n.Img .carousel i.left{\r\n\tfloat: left;\r\n}\r\n.Img .carousel i.right{\r\n\tfloat: right;\r\n}\r\n.Img .carousel .list-box{\r\n\twidth: 136px;\r\n\tfloat: left;\r\n\toverflow: hidden;\r\n}\r\n.Img .carousel ul{\r\n\tfloat: left;\r\n\twidth: 100%;\r\n\toverflow: hidden;\r\n}\r\n.Img .carousel ul li{\r\n\tline-height: 30px;\r\n\tfloat: left;\r\n\twidth: 100%;\r\n\tcolor: #1a2029;\r\n\ttext-align: center;\r\n\twidth: 100%;\r\n\ttext-align: center;\r\n}\r\n.Img  .tabs{\r\n\twidth: 30%;\r\n    height: 150px;\r\n    float: right;\r\n    margin-right: 20px;\r\n    margin-top: -10px;\r\n}\r\n.Img  .tabs table{\r\n\twidth: 100%;\r\n\tborder-radius: 3px;\r\n\toverflow: hidden;\r\n}\r\n.Img  .tabs table tr th{\r\n\theight: 30px;\r\n\ttext-align: center;\r\n\twidth: 50%;\r\n\tbackground: #e14340;\r\n\tcolor: #fff;\r\n}\r\n.Img  .tabs table tr td{\r\n\tcursor: pointer;\r\n\twidth: 50%;\r\n\theight: 35px;\r\n\ttext-align: center;\r\n\tbackground: #5383a1;\r\n\tborder-bottom: 1px solid #75c5f1;\r\n\tcolor: #fff;\r\n}\r\n.Img  .tabs table tbody tr.active td{\r\n\tbackground: rgba(183,223,248,0.5);\r\n}\r\n.Img  .tabs table tr td .Red{\r\n\tcolor: #e14340;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Yellow{\r\n\tcolor: #f39800;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Green{\r\n\tcolor: #32b16c;\r\n\tfont-size: 18px;\r\n}\r\n.Img  .tabs table tr td .Black{\r\n\tcolor: #000000;\r\n\tfont-size: 18px;\r\n}\r\n\r\n\r\n.Img .onTabs{\r\n\twidth: 43.6%;\r\n    height: 280px;\r\n    border-radius: 3px;   \r\n    position: absolute;\r\n    left: 3%;\r\n    top: 17%;\r\n}\r\n.Img .onTabs .tableLeft{\r\n\twidth: 85%;\r\n\theight: 274px;\r\n\tbackground: rgba(100, 131, 152, 0.5) none repeat scroll 0 0;\r\n\tfloat: left;\r\n\tdisplay: none;\r\n}\r\n.Img .onTabs .tableLeft.show{\r\n\tdisplay: block;\r\n}\r\n.Img .onTabs .solidRight{\r\n\twidth: 15%;\r\n    border: 1px solid #ffffff;\r\n    position: absolute;\r\n    right: 0;\r\n    top: 46.8%;\r\n}\r\n.Img .onTabs .mod-title{\r\n\tborder-bottom: 1px solid #495b69;\r\n}\r\n.Img .onTabs .mod-title i{\r\n\tfloat: right;\r\n    margin: 10px;\r\n    font-size: 18px;\r\n}\r\n.Img .onTabs .mod-title i.Black{\r\n    color: #000000;\r\n}\r\n.Img .onTabs .mod-title i.Green{\r\n    color: #32b16c;\r\n}\r\n.Img .onTabs .mod-title i.Yellow{\r\n    color:#f39800;\r\n}\r\n.Img .onTabs .mod-title i.Red{\r\n    color: #e14340;\r\n}\r\n.Img .onTabs .box{\r\n\twidth: 100%;\r\n\theight: 234px;\r\n\toverflow: auto;\r\n}\r\n.Img .onTabs .box table {\r\n\twidth: 93%;\r\n    margin: 0 10px;\r\n}\r\n.Img .onTabs .box table  tr td{\r\n\theight: 33px;\r\n\twidth: 95%;\r\n\twhite-space: nowrap;\r\n}\r\n.Img .onTabs .box table  tr td span{\r\n\tfloat: left;\r\n\tpadding-right: 10px;\r\n}\r\n.Img .yuan{\r\n\tposition: absolute;\r\n    right: 52%;\r\n    top: 29.7%;\r\n}\r\n/*@parkMonitor jifei  楼宇企业列表\r\n---------------------------------------------------------*/\r\n.Enterprise{\r\n\twidth: 100%;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n\theight: 560px;\r\n}\r\n.Enterprise .right{\r\n\tcolor: #e14340;\r\n\tfloat: right;\r\n\tfont-size: 16px;\r\n\tpadding: 10px 33px;\r\n}\r\n.Enterprise .mod-content{\r\n    width: 100%;\r\n    margin: 10px auto;\r\n}\r\n.Enterprise .mod-content .table-content{\r\n\theight: 470px;\r\n    overflow: auto;\r\n}\r\n.Enterprise .mod-content .wtyh-table{\r\n\twidth: 96%;\r\n    margin: 0 auto;\r\n}\r\n\r\n.Enterprise .mod-content .wtyh-table tr td{\r\n\theight: 40px;\r\n\tfont-size: 12px;\r\n\tborder-bottom: 1px solid #444951;\r\n}\r\n.Enterprise .mod-content .wtyh-table tr:nth-child(even){\r\n\tbackground: #222932;\r\n}\r\n.Enterprise .mod-content .wtyh-table tr td span{\r\n\tfloat: left;\r\n\tpadding-left: 10%;\r\n\tcolor: #fff;\r\n\tcursor: pointer;\r\n}\r\n.Enterprise .mod-content .wtyh-table tr td a{\r\n\tcolor:#ffffff;\r\n}\r\n\r\n/*@parkMonitor jifei  楼宇行业分布\r\n---------------------------------------------------------*/\r\n.Industry{\r\n\twidth: 49.5%;\r\n\theight: 398px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n\tmargin-top: 10px;\r\n\tfloat: left;\r\n}\r\n/*@parkMonitor jifei  企业背景情况\r\n---------------------------------------------------------*/\r\n.Context{\r\n\twidth: 49.5%;\r\n\theight: 398px;\r\n\tbackground: #2b323c;\r\n\tborder-radius: 3px;\r\n\tmargin-top: 10px;\r\n\tfloat: right;\r\n}\r\n/*@parkMonitor jifei  舆情更新\r\n---------------------------------------------------------*/\r\n.Footer{\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tposition: fixed;\r\n    bottom: 0;\r\n    left: 0;\r\n    background: rgba(43, 50, 60, 0.9) none repeat scroll 0 0;\r\n    box-shadow: 2px 2px 10px #000;\r\n}\r\n.Footer .box{\r\n\twidth: 95%;\r\n\theight: 40px;\r\n\tmargin: 10px auto;\r\n\tposition: relative;\r\n}\r\n.Footer .boxLeft{\r\n\twidth: 10%;\r\n\theight: 40px;\r\n\tborder-right: 1px solid #8a9199;\r\n\tline-height: 40px;\r\n\tfloat: left;\r\n}\r\n.Footer .boxLeft .icon-news{\r\n\tfont-size: 35px;\r\n\tcolor: #e14340;\r\n}\r\n.Footer .boxLeft .size{\r\n\tfont-size: 18px;\r\n    vertical-align: super;\r\n    padding-left: 25%;\r\n}\r\n.Footer .boxRight{\r\n\twidth: 85%;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tfloat: right;\r\n\t/* background: #666 */\r\n}\r\n.Footer .boxRight ul li{\r\n\tfloat: left;\r\n}\r\n.Footer .boxRight ul li:nth-child(1){\r\n\twidth: 20%;\r\n    font-size: 16px;\r\n    color: #e14340;\r\n    overflow: hidden;\r\n    text-overflow: ellipsis;\r\n    white-space: nowrap;\r\n    display: inline-block;\r\n}\r\n.Footer .boxRight ul li:nth-child(1) em{\r\n\tpadding-left: 5%;\r\n}\r\n.Footer .boxRight ul li:nth-child(2){\r\n\twidth: 60%;\r\n\tfont-size: 14px;\r\n    overflow: hidden;\r\n    text-overflow: ellipsis;\r\n    white-space: nowrap;\r\n    display: inline-block;\r\n}\r\n.Footer .boxRight ul li:nth-child(2) .liTop{\r\n\tpadding-left: 8%;\r\n}\r\n.Footer .boxRight ul li:nth-child(3){\r\n\twidth: 20%;\r\n\tfont-size: 12px;\r\n}\r\n.Footer .boxRight ul li:nth-child(3) em{\r\n\tpadding-left: 5%;\r\n}\r\n.Footer .boxRight ul li:nth-child(3) .liRight{\r\n\tpadding-left: 18%;\r\n}\r\n.boxRight{\r\noverflow: hidden;\r\nposition: relative;\r\n}\r\n.boxRight ul{\r\n\t/* background: red; */\r\n\twidth: 100%;height: 40px;\r\n}\r\n\r\n.boxRightScroll {\r\n\twidth: 100%;\r\n\theight: auto;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n}", ""]);

	// exports


/***/ },

/***/ 938:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(936);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//楼宇企业列表
	var BuildCompanyList = _react2.default.createClass({
	    displayName: 'BuildCompanyList',

	    getInitialState: function getInitialState() {
	        return {
	            Enterprise: [],
	            orderType: "desc", //默认降序
	            orderField: "", //需要排序的字段
	            areaId: 0,
	            buildingId: 0
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        var buildingId = this.props.location.query.buildingId;

	        this.setState({ areaId: areaId, buildingId: buildingId });

	        var json = { buildingId: buildingId };
	        this.getBuildCompanyList(json);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //切换大厦
	        var isSwitchValEqual = Immutable.is(nextProps.buildSwitchVal, this.props.buildSwitchVal);
	        if (!isSwitchValEqual) {
	            var buildSwitchVal = nextProps.buildSwitchVal;

	            var buildingId = buildSwitchVal.buildId;

	            this.setState({ buildingId: buildingId });

	            var json = { buildingId: buildingId };
	            this.getBuildCompanyList(json);
	        }

	        var isEqual = Immutable.is(nextProps.buildCompanyListResult, this.props.buildCompanyListResult); //判断数据是否变化
	        if (!isEqual) {
	            var buildCompanyListRequest = nextProps.buildCompanyListRequest;
	            var buildCompanyListResult = nextProps.buildCompanyListResult;

	            if (buildCompanyListRequest == true) {
	                if (buildCompanyListResult.success == true) {
	                    this.dataFomat(buildCompanyListResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ Enterprise: content });
	    },
	    getBuildCompanyList: function getBuildCompanyList(json) {
	        var getBuildCompanyList = this.props.getBuildCompanyList;

	        getBuildCompanyList(json);
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domIco = _dom.find("i"),
	            _domAttr = _dom.attr("data-order"),
	            _domIcoIs = _dom.find("i").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.Enterprise, field, this.state.orderType);
	            this.setState({ Enterprise: _basedata });
	        });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'Enterprise mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '楼宇企业列表'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'right' },
	                    '1122家'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-title' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table mt-mod' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '30%' },
	                                    '公司名'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '10%', 'data-order': this.state.orderType, ref: 'backgroundCN', onClick: this.handleClick.bind(this, "backgroundCN") },
	                                    '企业背景',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '10%', 'data-order': this.state.orderType, ref: 'comTypeCN', onClick: this.handleClick.bind(this, "comTypeCN") },
	                                    '行业',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '10%', 'data-order': this.state.orderType, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital") },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '10%', 'data-order': this.state.orderType, ref: 'registeredDate', onClick: this.handleClick.bind(this, "registeredDate") },
	                                    '注册时间',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { className: 'talign-left', width: '15%', 'data-order': this.state.orderType, ref: 'registeredType', onClick: this.handleClick.bind(this, "registeredType") },
	                                    '企业类型',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'wtyh-table table-border-b mod-left' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.Enterprise.map(function (elem, index) {

	                                return _react2.default.createElement(
	                                    'tr',
	                                    { key: index },
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '30%' },
	                                        _react2.default.createElement(
	                                            _reactRouter.Link,
	                                            { to: { pathname: '/SearchResultDetail', query: { companyName: elem.name } } },
	                                            elem.name
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '10%' },
	                                        elem.backgroundCN
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '10%' },
	                                        elem.comTypeCN
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '10%' },
	                                        elem.registeredCapital
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '10%' },
	                                        elem.registeredDate
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        { className: 'talign-left', width: '15%' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', title: elem.registeredType },
	                                            elem.registeredType
	                                        )
	                                    )
	                                );
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = BuildCompanyList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BuildCompanyList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 939:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(936);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//楼宇行业分布
	var BuildIndDistri = _react2.default.createClass({
	    displayName: 'BuildIndDistri',

	    getInitialState: function getInitialState() {
	        return {
	            Industry: [],
	            IndustryEnd: [],
	            areaId: 0,
	            buildingId: 0
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var areaId = this.props.location.query.areaId;
	        var buildingId = this.props.location.query.buildingId;

	        this.setState({ areaId: areaId, buildingId: buildingId });

	        var json = { buildingId: buildingId };
	        this.getBuildIndDistri(json);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //切换大厦
	        var isSwitchValEqual = Immutable.is(nextProps.buildSwitchVal, this.props.buildSwitchVal);
	        if (!isSwitchValEqual) {
	            var buildSwitchVal = nextProps.buildSwitchVal;

	            var buildingId = buildSwitchVal.buildId;

	            this.setState({ buildingId: buildingId });

	            var json = { buildingId: buildingId };
	            this.getBuildIndDistri(json);
	        }

	        var isEqual = Immutable.is(nextProps.buildIndDistriResult, this.props.buildIndDistriResult); //判断数据是否变化
	        if (!isEqual) {
	            var buildIndDistriRequest = nextProps.buildIndDistriRequest;
	            var buildIndDistriResult = nextProps.buildIndDistriResult;

	            if (buildIndDistriRequest == true) {
	                if (buildIndDistriResult.success == true) {
	                    this.dataFomat(buildIndDistriResult);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        var IndustryBox = [];
	        var IndustryContent = [];
	        for (var i = 0; i < content.length; i++) {
	            IndustryBox.push({ value: content[i].count, name: content[i].type });
	        };
	        for (var j = 0; j < content[0].children.length; j++) {
	            IndustryContent.push({ value: content[0].children[j].count, name: content[0].children[j].type });
	        };
	        this.initMap(IndustryBox, IndustryContent);
	    },
	    getBuildIndDistri: function getBuildIndDistri(json) {
	        var getBuildIndDistri = this.props.getBuildIndDistri;

	        getBuildIndDistri(json);
	    },
	    initMap: function initMap(IndustryBox, IndustryEnd) {
	        console.log(IndustryBox, 'IndustryBox');
	        var myChart = echarts.init(document.getElementById("Industry"));
	        var option = {
	            backgroundColor: '#2b323c',
	            color: ['#c33533', '#61a0a9', '#54656f', '#6e6f71', '#2f4553', '#c09f9a', '#dfab62'],
	            title: {
	                text: "楼宇行业分布",
	                x: "left",
	                y: "top",
	                top: "5px",
	                left: "5px",
	                textStyle: {
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    color: '#fff',
	                    fontFamily: "microsoft yahei"
	                }
	            },
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b}{c}"
	            },
	            legend: {
	                orient: 'vertical',
	                x: '80%',
	                y: "70%",
	                textStyle: {
	                    color: "#dddddd"
	                },
	                data: ['金融', '类金融', '其他']
	            },
	            series: [{
	                name: '访问来源',
	                type: 'pie',
	                selectedMode: 'single',
	                center: ['45%', 200],
	                radius: [0, '30%'],
	                label: {
	                    normal: {
	                        show: false
	                    }
	                },
	                labelLine: {
	                    normal: {
	                        show: false
	                    }
	                },
	                data: IndustryBox
	            }, {
	                name: '',
	                type: 'pie',
	                center: ['45%', 200],
	                radius: ['40%', '60%'],
	                data: IndustryEnd
	            }]
	        };
	        myChart.setOption(option);
	        myChart.resize();
	    },

	    // ajaxIndustry(val){
	    //     $.ajax({
	    //         url: 'park/buildingBusinessDistribute.do',
	    //         type: 'get',
	    //         dataType: 'json',
	    //         data: {areaId: val},
	    //         success:function(res){
	    //             if(res.success){
	    //                 var IndustryBox = [];
	    //                 var IndustryContent = [];
	    //                 for(var i=0; i< res.content.length; i++){
	    //                     IndustryBox.push({value:res.content[i].count,name:res.content[i].type});
	    //                 };
	    //                 for(var j=0; j< res.content[0].children.length; j++){
	    //                     IndustryContent.push({value:res.content[0].children[j].count,name:res.content[0].children[j].type})
	    //                 };
	    //             }
	    //           this.initMap(IndustryBox,IndustryContent)
	    //         }.bind(this)
	    //     })
	    // },

	    render: function render() {
	        return _react2.default.createElement('div', { className: 'Industry', id: 'Industry' });
	    }
	});
	module.exports = BuildIndDistri;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BuildIndDistri.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})