webpackHotUpdate(0,{

/***/ 687:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "* {\r\n\tmargin: 0px;\r\n\tpadding: 0px;\r\n}\r\n\r\nul,\r\nli {\r\n\tlist-style: none;\r\n}\r\n\r\na {\r\n\ttext-decoration: none;\r\n}\r\n\r\nhtml {\r\n\t-webkit-text-size-adjust: none;\r\n}\r\n\r\nbody {\r\n\tbackground-color: #1a2029;\r\n\tcolor: #ffffff;\r\n\tfont-family: 'Microsoft Yahei';\r\n}\r\n\r\n.clear:after {\r\n\tcontent: \".\";\r\n\theight: 0;\r\n\tvisibility: hidden;\r\n\tdisplay: block;\r\n\tclear: both;\r\n}\r\n\r\n/*头部导航 header begin*/\r\n.header {\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tbackground-color: #383e47;\r\n\toverflow: hidden;\r\n}\r\n\r\n.header .logo {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tline-height: 60px;\r\n\tcolor: #ffffff;\r\n\tfont-size: 20px;\r\n}\r\n\r\n.header .logo .img {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\twidth: 90px;\r\n\theight: 60px;\r\n\tbackground: url(/images/logo.png);\r\n}\r\n\r\n.header .right {\r\n\tfloat: right;\r\n\tmargin-top: 20px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.header .right .name {\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 30px;\r\n\tcursor: pointer;\r\n}\r\n\r\n.list-header {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tpadding: 14px;\t/*text-indent: 30px;*/\r\n}\r\n\r\n.wrap {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\tposition: relative;\r\n\tz-index: 500;\r\n\toverflow: hidden;\r\n\tbackground: #1f253d;\r\n\tbackground-size: cover;\r\n}\r\n\r\n.header .right .name span {\r\n\tmargin-left: 10px;\r\n\tmargin-right: 8px;\r\n\tfont-weight: bold;\r\n}\r\n\r\n.header .right .quit {\r\n\tfont-size: 16px;\r\n\tcolor: #e24643;\r\n}\r\n\r\n/*头部导航 header end*/\r\n.radius4 {\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  begin*/\r\n.menu {\r\n\twidth: 100%;\r\n\theight: 50px;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.menu ul.nav {\r\n\theight: 50px;\r\n\tfloat: left;\r\n}\r\n\r\n.menu ul.nav  li {\r\n\tfloat: left;\r\n\tposition: relative;\r\n}\r\n\r\n.menu ul.nav  li a {\r\n\tcolor: #ffffff;\r\n\tpadding: 0px 30px;\r\n\tline-height: 50px;\r\n}\r\n\r\n.menu ul.nav li a.active:after {\r\n\tcontent: \"\";\r\n\tposition: absolute;\r\n\tleft: 0px;\r\n\tbottom: 0px;\r\n\twidth: 100%;\r\n\theight: 0.2rem;\r\n\tbackground: #e14340;\r\n\tz-index: 0;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav {\r\n\twidth: 96px;\r\n\theight: auto;\r\n\tbackground-color: #545e6d;\r\n\tposition: absolute;\r\n\tleft: 50%;\r\n\ttop: 40px;\r\n\tmargin-left: -50px;\r\n\tz-index: 10;\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.hide {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.show {\r\n\tdisplay: block;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li {\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tfloat: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a {\r\n\tdisplay: block;\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tpadding: 0 0;\r\n\tfont-size: 14px;\r\n\tcolor: #b7b7b7;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a.active:after {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a:hover {\r\n\tbackground-color: #42b8e2;\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.menu .right-park {\r\n\tfloat: right;\r\n\tmargin-top: 12px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.menu .right-park .mt-select {\r\n\tmargin-right: 10px;\r\n}\r\n\r\n.menu .right-park .mt-select-title {\r\n\tbackground-color: #ffffff;\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park .mt-select-box {\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park a {\r\n\tbackground-color: #e14340;\r\n\tcolor: #ffffff;\r\n\tpadding: 4px 10px;\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  end*/\r\n\r\n/*控制边距的类*/\r\n.content-space-10 {\r\n\tmargin: 10px;\r\n}\r\n\r\n.content-space-top-0 {\r\n\tmargin: 0px 10px 10px 10px;\r\n}\r\n\r\n.mod-space-l {\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.mod-space-t {\r\n\tmargin-top: 0.5%;\r\n}\r\n\r\n.mod-space-dl {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.mod-space-dt {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n/*模块公用样式 begin*/\r\n.mod {\r\n\theight: 100%;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.mod .mod-title h3 {\r\n\tdisplay: inline-block;\r\n\tvertical-align: middle;\r\n\tfont-weight: normal;\r\n\tfont-style: normal;\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-left: 10px;\r\n\tpadding: 8px 0;\r\n}\r\n\r\n.mod .mod-title .mod-title-right {\r\n\tfloat: right;\r\n}\r\n\r\n/*模块标题上的下拉选择框 begind*/\r\n.mod .mod-title .mod-title-right .mt-select {\r\n\tcolor: #e5e5e5;\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n\tpadding-left: 5px;\r\n\tpadding-right: 5px;\r\n}\r\n\r\n.mod .mod-title .mod-title-right .mt-select-box {\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n}\r\n\r\n/*模块标题上的下拉选择框 end*/\r\n.mt-select {\r\n\tborder: none !important;\r\n}\r\n\r\n/*模块公用样式 end*/\r\n*:focus {\r\n\toutline: none;\r\n}\r\n\r\n/*表格公用样式*/\r\n.wtyh-table thead th {\r\n\tborder-bottom: none;\r\n\tbackground-color: #1a2029;\r\n\tcolor: #dddddd;\r\n\tfont-size: 14px;\r\n\tfont-weight: normal;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.wtyh-table thead tr {\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.wtyh-table tbody td {\r\n\tborder-bottom: none;\r\n\tcolor: #ffffff;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.wtyh-table tbody tr.odd td {\r\n\tbackground: #2b323c;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-line td {\r\n\tbackground: #36404d;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-blackbg-line td {\r\n\tbackground: #222932;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.even td {\r\n\tbackground-color: #1a2029;\r\n}\r\n\r\n.talign-left {\r\n\ttext-align: left !important;\r\n}\r\n\r\n.wtyh-table.table-border-b  tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.talign-right {\r\n\ttext-align: right !important;\r\n}\r\n\r\n.talign-center {\r\n\ttext-align: center !important;\r\n}\r\n\r\n.header-gray {\r\n\theight: 50px;\r\n\tline-height: 50px;\r\n\tbackground: #394351;\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.skublue {\r\n\tcolor: #00b8ee\r\n}\r\n\r\n.orange {\r\n\tcolor: #e14340\r\n}\r\n\r\n/*限制字数五个字*/\r\n.word-limit-5 {\r\n\toverflow: hidden; /*自动隐藏文字*/\r\n\ttext-overflow: ellipsis;/*文字隐藏后添加省略号*/\r\n\twhite-space: nowrap;/*强制不换行*/\r\n\tdisplay: inline-block;\r\n\twidth: 80px;\r\n}\r\n\r\n/*分页样式覆盖*/\r\n.mt-pagelist {\r\n\tmargin-top: 10px !important;\r\n}\r\n\r\n.mt-pagelist ul {\r\n\theight: 30px;\r\n}\r\n\r\n.mt-pagelist .mt-select,\r\n.mt-pagelist .mt-pagelist-first,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-runprev,\r\n.mt-pagelist .mt-pagelist-runnext {\r\n\tdisplay: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-prev,\r\n.mt-pagelist .mt-pagelist-next,\r\n.mt-pagelist .mt-pagelist-btn,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-first {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-input .mt-input {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a {\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n\tline-height: 26px !important;\r\n\tborder-radius: 2px !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li.on a {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-btn:hover,\r\n.mt-pagelist .mt-pagelist-prev:hover,\r\n.mt-pagelist .mt-pagelist-next:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n/*搜索框*/\r\n.mt-input .mt-iconbtn,\r\n.mt-input-block .mt-iconbtn a {\r\n\tcursor: pointer !important;\r\n}\r\n\r\n/*颜色*/\r\n.c-red {\r\n\tcolor: #e14340;\r\n}\r\n\r\n/*联想词*/\r\n.ac_results {\r\n\tpadding: 0;\r\n\toverflow: auto;\r\n\tz-index: 99999;\r\n\tmax-height: 200px;\r\n\tbackground: rgba(17, 38, 67, 0.9);\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results ul {\r\n\twidth: 100%;\r\n\tlist-style: none;\r\n\tpadding: 0;\r\n\tmargin: 0;\r\n}\r\n\r\n.ac_results ul li:last-child {\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results li {\r\n\tpadding: 5px 10px;\r\n\tdisplay: block;\r\n\tfont-size: 14px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.ac_results .group-item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.ac_results ul .group-item:hover {\r\n\tbackground: #063a5f;\r\n}\r\n\r\n.ac_results .group {\r\n\tcolor: #666;\r\n}\r\n\r\n.ac_results i {\r\n\tfont-size: 12px;\r\n\tcolor: #999;\r\n\tpadding-left: 1em;\r\n}\r\n\r\n.ac_results .strong {\r\n\tcolor: #13b7fe;\r\n}\r\n\r\n.ac-results ul li.group:hover {\r\n\tcursor: default;\r\n\tbackground-color: #172837;\r\n\tcolor: #666;\r\n}", ""]);

	// exports


/***/ },

/***/ 690:
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

	var Menu = _react2.default.createClass({
	  displayName: 'Menu',

	  getInitialState: function getInitialState() {
	    return {
	      subNav: false
	    };
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
	                '典当'
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
	      _react2.default.createElement('div', { className: 'right' })
	    );
	  }
	});

	module.exports = Menu;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Menu.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 696:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//onChange , onFocus, onBlur
	/**
	* 自定义内容的弹窗插件
	* @author : Mantou
	* @date : 2016-03-01
	*/
	var Input = _react2.default.createClass({
	    displayName: 'Input',
	    getInitialState: function getInitialState() {
	        return {
	            showValidate: false,
	            validateInfo: ''
	        };
	    },
	    getDefaultProps: function getDefaultProps() {
	        return {
	            type: "text",
	            onClick: false,
	            onChange: false,
	            onFocus: false,
	            onBlur: false,
	            width: false,
	            height: false,
	            placeholder: false,
	            value: false,
	            defaultValue: false,
	            block: false,
	            round: false,
	            icon: false,
	            iconplace: false,
	            className: false,
	            id: false,
	            disabled: false,
	            align: false,
	            validate: false
	        };
	    },
	    handleFocus: function handleFocus(e) {
	        //获取焦点
	        this.setState({
	            showValidate: false
	        });
	    },
	    handleBlur: function handleBlur(e) {
	        //失去焦点
	        var exg = this.props.validate.data;
	        //遍历数组
	        for (var key in exg) {
	            if (!RegExp(key).test(e.target.value)) {
	                this.setState({
	                    validateInfo: exg[key],
	                    showValidate: true
	                });
	                return;
	            }
	        }
	    },
	    render: function render() {
	        var props = {};
	        props['type'] = this.props.type;

	        //事件处理
	        if (this.props.onClick) {
	            props['onClick'] = this.props.onClick;
	        }
	        if (this.props.onChange) {
	            props['onChange'] = this.props.onChange;
	        }
	        if (this.props.onFocus) {
	            props['onFocus'] = this.props.onFocus;
	        }
	        if (this.props.onBlur) {
	            props['onBlur'] = this.props.onBlur;
	        }

	        //参数处理
	        if (this.props.width || this.props.height) {
	            props['style'] = {
	                width: this.props.width,
	                height: this.props.height
	            };
	        }
	        if (this.props.placeholder) {
	            props['placeholder'] = this.props.placeholder;
	        }
	        if (this.props.value) {
	            props['value'] = this.props.value;
	        }
	        if (this.props.defaultValue) {
	            props['defaultValue'] = this.props.defaultValue;
	        }
	        if (this.props.id) {
	            props['id'] = this.props.id;
	        }
	        if (this.props.round) {
	            props['className'] = 'mt-round';
	        }
	        if (this.props.disabled) {
	            props['disabled'] = 'disabled';
	        }

	        //验证
	        if (this.props.validate) {
	            props['onFocus'] = this.handleFocus;
	            props['onBlur'] = this.handleBlur;
	        }

	        //验证DOM
	        var validateDom = _react2.default.createElement(
	            'div',
	            { className: 'mt-validate-error animated fadeInRight' },
	            this.state.validateInfo
	        );

	        //对齐方式
	        var outDivStyle = {};
	        if (this.props.align) {
	            outDivStyle['verticalAlign'] = this.props.align;
	        }

	        //如果是textarea
	        if (this.props.type == 'textarea') {
	            var diyName = this.props.className ? this.props.className + ' ' : '';
	            return _react2.default.createElement(
	                'div',
	                { style: outDivStyle, className: diyName + "mt-textarea" + (this.state.showValidate ? ' mt-input-error' : '') },
	                _react2.default.createElement('textarea', props),
	                this.state.showValidate ? validateDom : ""
	            );
	        }

	        //如果是input 或者 password
	        var diyName = this.props.className ? this.props.className + ' ' : '';
	        var iconNamePlace = this.props.icon ? " mt-icon-input" + (this.props.iconplace == 'left' ? 'r' : '') : "";
	        var blockName = this.props.block ? ' mt-input-block' : '';
	        var cName = diyName + "mt-input" + blockName + iconNamePlace;
	        // console.log(this.props)
	        return _react2.default.createElement(
	            'div',
	            { style: outDivStyle, className: cName + (this.state.showValidate ? ' mt-input-error' : '') },
	            _react2.default.createElement('input', props),
	            this.props.icon ? _react2.default.createElement(
	                'a',
	                { href: 'javascript:;', className: 'mt-iconbtn', onClick: this.props.searchClick ? this.props.searchClick : '' },
	                _react2.default.createElement('i', { className: "iconfont " + this.props.icon })
	            ) : "",
	            this.state.showValidate ? validateDom : ""
	        );
	    }
	});

	//配置信息
	exports.default = Input;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Input.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 719:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(720);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _IndexAction = __webpack_require__(1349);

	var IndexActionCreaters = _interopRequireWildcard(_IndexAction);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _homeOne = __webpack_require__(723);

	var _homeOne2 = _interopRequireDefault(_homeOne);

	var _homeTwo = __webpack_require__(724);

	var _homeTwo2 = _interopRequireDefault(_homeTwo);

	var _homeThree = __webpack_require__(725);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//项目首页
	var Index = _react2.default.createClass({
	  displayName: 'Index',

	  mixins: [_setHeight2.default],
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Home wrap', id: 'home' },
	      _react2.default.createElement(_homeOne2.default, this.props),
	      _react2.default.createElement(_homeTwo2.default, null),
	      _react2.default.createElement(_homeThree2.default, this.props)
	    );
	  }
	});
	//module.exports = Index;

	//将 request  result 绑定到props的request result
	function indexStateToProps(state) {
	  return {

	    homeThreeRequest: state.homeThree.request,
	    homeThreeResult: state.homeThree.result
	  };
	}

	//将action的所有方法绑定到props上
	function indexDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(IndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(indexStateToProps, indexDispatchToProps)(Index);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 723:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var HomeOne = _react2.default.createClass({
	  displayName: 'HomeOne',

	  //{w:40,h:40,l:0,t:0,x:0,lb:0}
	  getInitialState: function getInitialState() {
	    return {
	      searchInfo: null
	    };
	  },
	  componentDidMount: function componentDidMount() {},

	  searchBtn: function searchBtn() {
	    var searchInfo = this.refs.search.value;
	    this.setState({
	      searchInfo: searchInfo
	    });
	    this.props.history.push('/InfoSearchIndex?searchInfo=' + searchInfo);
	  },
	  keySearch: function keySearch(event) {
	    if (event.which == "13") this.searchBtn();
	  },
	  render: function render() {
	    var searchInfoa = "";
	    if (this.state.searchInfo) searchInfoa = this.state.searchInfo;
	    return _react2.default.createElement(
	      'div',
	      { className: 'HomeOne' },
	      _react2.default.createElement(
	        'a',
	        { href: '#' },
	        _react2.default.createElement(
	          'div',
	          { className: 'HomeOne-tite' },
	          _react2.default.createElement(
	            'h1',
	            null,
	            _react2.default.createElement('i', { className: 'iconfont icon-qiyejibenxinxichaxun' }),
	            _react2.default.createElement(
	              'span',
	              null,
	              '上海市新型金融业态监测分析平台.'
	            )
	          )
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'HomeOne-inp' },
	        _react2.default.createElement('input', { type: 'text', placeholder: '请输入要查询的企业名称', ref: 'search', onKeyUp: this.keySearch }),
	        _react2.default.createElement(
	          'a',
	          { href: 'javascript:;', onClick: this.searchBtn, className: 'jump' },
	          _react2.default.createElement('i', { className: 'iconfont icon-search search' })
	        )
	      )
	    );
	  }
	});

	//将state植入 到 props
	exports.default = HomeOne;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "homeOne.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 725:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var HomeThree = _react2.default.createClass({
	    displayName: 'HomeThree',
	    getInitialState: function getInitialState() {
	        return {
	            homeThreeData: {}
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var gethomethreeRequest = this.props.gethomethreeRequest;

	        var jsonData = {};
	        gethomethreeRequest(jsonData);
	    },

	    changeNum: function changeNum(data) {
	        $.fn.numberAnimate = function (setting) {
	            var defaults = {
	                speed: 1000, //动画速度
	                num: "", //初始化值
	                iniAnimate: true, //是否要初始化动画效果
	                symbol: '', //默认的分割符号，千，万，千万
	                dot: 0 //保留几位小数点
	            };
	            //如果setting为空，就取default的值
	            var setting = $.extend(defaults, setting);
	            //如果对象有多个，提示出错
	            if ($(this).length > 1) {
	                alert("just only one obj!");
	                return;
	            }
	            //如果未设置初始化值。提示出错
	            if (setting.num == "") {
	                alert("must set a num!");
	                return;
	            }
	            var nHtml = '<div class="mt-number-animate-dom" data-num="{{num}}">\
	                        <span class="mt-number-animate-span">0</span>\
	                        <span class="mt-number-animate-span">1</span>\
	                        <span class="mt-number-animate-span">2</span>\
	                        <span class="mt-number-animate-span">3</span>\
	                        <span class="mt-number-animate-span">4</span>\
	                        <span class="mt-number-animate-span">5</span>\
	                        <span class="mt-number-animate-span">6</span>\
	                        <span class="mt-number-animate-span">7</span>\
	                        <span class="mt-number-animate-span">8</span>\
	                        <span class="mt-number-animate-span">9</span>\
	                        <span class="mt-number-animate-span">.</span>\
	                    </div>';
	            //数字处理
	            var numToArr = function numToArr(num) {
	                num = parseFloat(num).toFixed(setting.dot);
	                if (typeof num == 'number') {
	                    var arrStr = num.toString().split("");
	                } else {
	                    var arrStr = num.split("");
	                }
	                //console.log(arrStr);
	                return arrStr;
	            };
	            //设置DOM symbol:分割符号
	            var setNumDom = function setNumDom(arrStr) {
	                var shtml = '<div class="mt-number-animate">';
	                for (var i = 0, len = arrStr.length; i < len; i++) {
	                    if (i != 0 && (len - i) % 3 == 0 && setting.symbol != "" && arrStr[i] != ".") {
	                        shtml += '<div class="mt-number-animate-dot">' + setting.symbol + '</div>' + nHtml.replace("{{num}}", arrStr[i]);
	                    } else {
	                        shtml += nHtml.replace("{{num}}", arrStr[i]);
	                    }
	                }
	                shtml += '</div>';
	                return shtml;
	            };
	            //执行动画
	            var runAnimate = function runAnimate($parent) {
	                $parent.find(".mt-number-animate-dom").each(function () {
	                    var num = $(this).attr("data-num");
	                    num = num == "." ? 10 : num;
	                    var spanHei = $(this).height() / 11; //11为元素个数
	                    var thisTop = -num * spanHei + "px";
	                    var transform = $(this).css("transform");
	                    if (transform == 'none' || -num * spanHei != parseInt(transform.split(",")[5], 10)) {
	                        if (setting.iniAnimate) {
	                            //HTML5不支持
	                            if (!window.applicationCache) {
	                                $(this).animate({
	                                    top: thisTop
	                                }, setting.speed);
	                            } else {
	                                $(this).css({
	                                    'transform': 'translateY(' + thisTop + ')',
	                                    '-ms-transform': 'translateY(' + thisTop + ')', /* IE 9 */
	                                    '-moz-transform': 'translateY(' + thisTop + ')', /* Firefox */
	                                    '-webkit-transform': 'translateY(' + thisTop + ')', /* Safari 和 Chrome */
	                                    '-o-transform': 'translateY(' + thisTop + ')',
	                                    '-ms-transition': setting.speed / 1000 + 's',
	                                    '-moz-transition': setting.speed / 1000 + 's',
	                                    '-webkit-transition': setting.speed / 1000 + 's',
	                                    '-o-transition': setting.speed / 1000 + 's',
	                                    'transition': setting.speed / 1000 + 's'
	                                });
	                            }
	                        } else {
	                            setting.iniAnimate = true;
	                            $(this).css({
	                                top: thisTop
	                            });
	                        }
	                    }
	                });
	            };
	            //初始化
	            var init = function init($parent) {
	                //初始化
	                $parent.html(setNumDom(numToArr(setting.num)));
	                runAnimate($parent);
	            };
	            //重置参数
	            this.resetData = function (num) {
	                var newArr = numToArr(num);
	                var $dom = $(this).find(".mt-number-animate-dom");
	                if ($dom.length < newArr.length) {
	                    $(this).html(setNumDom(numToArr(num)));
	                } else {
	                    $dom.each(function (index, el) {
	                        $(this).attr("data-num", newArr[index]);
	                    });
	                }
	                runAnimate($(this));
	            };
	            //init
	            init($(this));
	            return this;
	        };
	        // 数字滚动插件
	        var numRunA = $(".homeScrollA").numberAnimate({ num: data.dataCount, speed: 2000, symbol: "," });
	        var numRunB = $(".homeScrollB").numberAnimate({ num: data.companyCount, speed: 2000, symbol: "," });
	        var numRunC = $(".homeScrollC").numberAnimate({ num: data.bugCount, speed: 2000, symbol: "," });
	        var nums = data.dataCount;
	        var numJ = data.companyCount;
	        var numF = data.bugCount;
	        setInterval(function () {
	            nums += Math.round(Math.random() * 60) + 260;
	            numJ += Math.round(Math.random() * 60) + 260;
	            numF += Math.round(Math.random() * 60) + 260;
	            numRunA.resetData(nums);
	            numRunB.resetData(numJ);
	            numRunC.resetData(numF);
	        }, 5000);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.homeThreeRequest, this.props.homeThreeResult);
	        if (!isEqual) {
	            var homeThreeRequest = nextProps.homeThreeRequest;
	            var homeThreeResult = nextProps.homeThreeResult;

	            if (homeThreeRequest == true) {
	                if (homeThreeResult.success == true) {
	                    this.changeNum(homeThreeResult.content);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'HomeThree HomeBox' },
	            _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                    'li',
	                    { className: '' },
	                    _react2.default.createElement('p', { className: 'homeScrollA iconfont icon-arrowdown' }),
	                    _react2.default.createElement(
	                        'p',
	                        null,
	                        '数据分析'
	                    )
	                ),
	                _react2.default.createElement(
	                    'li',
	                    { className: '' },
	                    _react2.default.createElement('p', { className: 'homeScrollB iconfont icon-arrowdown' }),
	                    _react2.default.createElement(
	                        'p',
	                        null,
	                        '企业数量'
	                    )
	                ),
	                _react2.default.createElement(
	                    'li',
	                    { className: '' },
	                    _react2.default.createElement('p', { className: 'homeScrollC iconfont icon-arrowdown' }),
	                    _react2.default.createElement(
	                        'p',
	                        null,
	                        '数据抓取'
	                    )
	                )
	            )
	        );
	    }
	});

	exports.default = HomeThree;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "homeThree.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 740:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	var _reactDom2 = _interopRequireDefault(_reactDom);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//散点图 横坐标为时间

	/*
	  调用方式：
	     var param={
	            id:'loan-balance-chart',//必传
	            height:'272px',//必传 带上单位
	            title:'贷款余额',
	            legend: [],
	            xAxis:['2010', '2011', '2012','2013', '2014', '2015', '2016'],
	            yAxis: ['20', '40', '60', '80', '100', '120', '140'],
	            data: [[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	            series:[
	                    [{
	                      color:'#e14340'
	                    }]
	                  ]
	        }
	*/
	var ScatterChart = _react2.default.createClass({
	    displayName: 'ScatterChart',

	    componentDidMount: function componentDidMount() {
	        var id = this.props.param.id;
	        var bubbleChart = echarts.init(document.getElementById(id));
	        var param = this.props.param;
	        var option = this.setOption(param);
	        bubbleChart.setOption(option);
	        this.resizeChart(bubbleChart);
	    },
	    resizeChart: function resizeChart(bubbleChart) {
	        //容器发生改变时重新设置图表大小
	        $(window).resize(function () {
	            bubbleChart.resize();
	        });
	    },
	    setOption: function setOption(param) {
	        console.log(param.xAxis);
	        var seriesData = [];
	        for (var i = 0; i < param.data.length; i++) {
	            var eachSeriesData = {};
	            seriesData.push(eachSeriesData);
	        }

	        var option = {
	            title: {
	                text: param.title || "",
	                textStyle: {
	                    fontSize: 14,
	                    color: "#fff",
	                    fontFamily: "microsoft yahei",
	                    fontWeight: "normal"
	                }
	            },
	            legend: {
	                data: [],
	                left: 'right'
	            },
	            tooltip: {
	                position: 'top',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(data) {
	                    if (param.formatter == "BusinessNum") {
	                        //典当总额业务笔数
	                        return data.name + ' 年<br/> 典当总额：&nbsp ' + data.data[3] + "亿元<br/>业务笔数：&nbsp  " + data.data[2];
	                    } else {
	                        return data.value[2] + ' commits in ' + ' of ' + param.xAxis[data.value[1]];
	                    }
	                }
	            },
	            grid: {
	                top: param.gridTop || '10%',
	                left: '5%',
	                bottom: '5%',
	                right: '5%',
	                containLabel: true
	            },
	            xAxis: {
	                type: 'category',
	                data: param.xAxis,
	                boundaryGap: false,
	                splitLine: {
	                    show: false,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            },
	            yAxis: {
	                type: param.yType || 'category',
	                name: param.yAxisName == undefined ? "" : param.yAxisName,
	                boundaryGap: ["10%", "10%"],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: param.yAxis,
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#353b45',
	                        type: 'solid'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            },
	            series: [{
	                name: '',
	                type: 'scatter',
	                symbolSize: function symbolSize(val) {
	                    if (val[2] < 10000) {
	                        return val[2] / 1000;
	                    } else if (10000 < val[2] && val[2] < 100000) {
	                        return val[2] / 10000;
	                    } else {
	                        return val[2] / 200000;
	                    }
	                },
	                data: param.data,
	                animationDelay: function animationDelay(idx) {
	                    return idx * 5;
	                }
	            }]
	        };
	        return option;
	    },
	    render: function render() {
	        return _react2.default.createElement('div', { id: this.props.param.id, style: { height: this.props.param.height } });
	    }
	});

	module.exports = ScatterChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 742:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(743);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//顶部搜索条
	var IndustrySearch = _react2.default.createClass({
	  displayName: 'IndustrySearch',

	  getInitialState: function getInitialState() {
	    return {
	      searchVal: ''
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    if (this.props.isHotWorld == undefined) {
	      $("#autocomplete").inputAutoComplete({
	        requestType: 'get',
	        requestUrl: '/searchCompany.do',
	        requestData: {
	          companyType: this.props.companyType, //1: P2P 2:小贷 3:融资担保 4:线下理财 5:私募基金 6:众筹 7:其他 8:金融 9:交易所 10:商业保理 11.预付卡 12.典当 13融资租赁,
	          size: 5
	        },
	        wrap: $('body'),
	        callback: function callback() {}
	      });
	    }
	  },
	  handleChange: function handleChange(e) {
	    var searchVal = $(e.target).parent().prev().val();
	    this.setState({ searchVal: searchVal });
	    this.props.searchFun(searchVal);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'industry-search ' + this.props.className },
	      _react2.default.createElement(
	        'label',
	        null,
	        this.props.label
	      ),
	      _react2.default.createElement(_index.Input, { placeholder: this.props.placeholder, id: 'autocomplete', hotWorld: this.props.isHotWorld, value: this.state.searchVal, icon: 'icon-search', iconplace: 'right', type: 'text', searchClick: this.handleChange })
	    );
	  }
	});
	module.exports = IndustrySearch;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustrySearch.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 745:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(746);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//线下理财首页
	var LineFinanceResultMod = _react2.default.createClass({
	  displayName: 'LineFinanceResultMod',

	  getInitialState: function getInitialState() {
	    return {
	      searchVal: ''
	    };
	  },
	  render: function render() {
	    var propObj = this.props.dataItem;
	    return _react2.default.createElement(
	      'div',
	      { className: 'line-finace-search-mod' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        propObj.name,
	        _react2.default.createElement('span', { className: 'c-red' })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'm-content' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(
	            'div',
	            { className: 'l-box' },
	            _react2.default.createElement(
	              'span',
	              null,
	              '静态风险指数'
	            ),
	            _react2.default.createElement(
	              'em',
	              null,
	              propObj.staticRisk
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(
	            'dl',
	            null,
	            _react2.default.createElement(
	              'dt',
	              null,
	              '法定代表人：'
	            ),
	            _react2.default.createElement(
	              'dd',
	              null,
	              propObj.legalPerson
	            ),
	            _react2.default.createElement(
	              'dt',
	              null,
	              '注册资本：'
	            ),
	            _react2.default.createElement(
	              'dd',
	              null,
	              propObj.registeredCapital
	            ),
	            _react2.default.createElement(
	              'dt',
	              null,
	              '成立时间：'
	            ),
	            _react2.default.createElement(
	              'dd',
	              null,
	              propObj.registeredDate
	            ),
	            _react2.default.createElement(
	              'dt',
	              null,
	              '企业地址：'
	            ),
	            _react2.default.createElement(
	              'dd',
	              null,
	              propObj.adddress
	            )
	          )
	        )
	      ),
	      _react2.default.createElement(
	        _reactRouter.Link,
	        { to: { pathname: '/lineFinanceStaticRisk', query: { companyName: propObj.name } } },
	        _react2.default.createElement(
	          'div',
	          { className: 'btn' },
	          '查看详情'
	        )
	      )
	    );
	  }
	});
	module.exports = LineFinanceResultMod;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ResultMod.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 747:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*线下理财 搜索结果页 begin*/\r\n.line-finace-search-mod{\r\n\tdisplay: inline-block;\r\n\twidth: 400px;\r\n\tbackground-color: #2b323c;\r\n\tpadding-bottom: 20px;\r\n\ttext-align: left;\r\n}\r\n.line-finace-search-mod h4{\r\n\tfont-size: 14px;\r\n\tcolor:#ffffff;\r\n\tbackground-color: #383e47;\r\n\ttext-align: center;\r\n\tpadding:10px 0;\r\n}\r\n.line-finace-search-mod .m-content{\r\n\toverflow: hidden;\r\n\theight:160px;\r\n\tmargin-top: 20px;\r\n}\r\n.line-finace-search-mod .m-content .left{\r\n\tfloat: left;\r\n\twidth: 32%;\r\n\theight: 100%;\r\n\tposition: relative;\r\n\tpadding-right: 5px;\r\n\tpadding-left: 5px;\r\n}\r\n.line-finace-search-mod .m-content .left .l-box{\r\n\twidth: 100%;\r\n\tposition: absolute;\r\n\ttop: 50%;\r\n\tmargin-top: -40px;\r\n}\r\n.line-finace-search-mod .m-content .left span{\r\n\tdisplay: block;\r\n\twidth: 100%;\r\n\ttext-align: center;\r\n\tfont-size: 14px;\r\n\t\r\n}\r\n.line-finace-search-mod .m-content .left em{\r\n\tdisplay:block;\r\n\twidth: 100%;\r\n\ttext-align: center;\r\n\tcolor: #e14340;\r\n\tfont-size: 30px;\r\n}\r\n.line-finace-search-mod .m-content .right{\r\n\tfloat: left;\r\n\twidth: 68%;\r\n\theight: 100%;\r\n\tborder-left: dashed 1px #5f6978;\r\n\tpadding-left: 5px;\r\n}\r\n.line-finace-search-mod .m-content .right dt{\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\twidth: 90px;\r\n\tpadding: 5px 0;\r\n\tfont-size: 14px;\r\n}\r\n.line-finace-search-mod .m-content .right dd{\r\n\tdisplay: block;\r\n\tfloat:left;\r\n\twidth: 160px;\r\n\tpadding: 5px 0;\r\n\tfont-size: 14px;\r\n}\r\n.line-finace-search-mod div.btn{\r\n\tdisplay: block;\r\n\ttext-align: center;\r\n\theight: 34px;\r\n\tline-height: 34px;\r\n\tborder-radius: 5px;\r\n\tbackground-color: #5f6978;\r\n\tcolor:#ffffff;\r\n\tfont-size: 14px;\r\n\twidth: 80%;\r\n\tmargin: 0 auto;\r\n\tmargin-top: 20px;\r\n}\r\n\r\n/*线下理财搜索结果页 end*/\r\n@media screen and (max-width: 1601px) {\r\n.line-finace-search-mod{\r\n\twidth: 340px;\r\n}\r\n\r\n.line-finace-search-mod .m-content .left{\r\n\twidth: 32%;\r\n}\r\n\r\n.line-finace-search-mod .m-content .right{\r\n\twidth: 68%;\r\n}\r\n\r\n.line-finace-search-mod .m-content .right dd{\r\n\twidth: 110px;\r\n}  \t\r\n}\r\n\r\n@media screen and (max-width: 1401px) {\r\n.line-finace-search-mod{\r\n\twidth: 310px;\r\n}\r\n\r\n.line-finace-search-mod .m-content .left{\r\n\twidth: 32%;\r\n}\r\n\r\n.line-finace-search-mod .m-content .right{\r\n\twidth: 68%;\r\n}\r\n\r\n.line-finace-search-mod .m-content .right dd{\r\n\twidth: 110px;\r\n}  \t\r\n}\r\n", ""]);

	// exports


/***/ },

/***/ 749:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(727);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _RiskSearchHeader = __webpack_require__(750);

	var _RiskSearchHeader2 = _interopRequireDefault(_RiskSearchHeader);

	var _LineFinanceRelationGraph = __webpack_require__(753);

	var _LineFinanceRelationGraph2 = _interopRequireDefault(_LineFinanceRelationGraph);

	var _LineFinanceCoCompose = __webpack_require__(756);

	var _LineFinanceCoCompose2 = _interopRequireDefault(_LineFinanceCoCompose);

	var _LineFinanceIndexConstitute = __webpack_require__(757);

	var _LineFinanceIndexConstitute2 = _interopRequireDefault(_LineFinanceIndexConstitute);

	var _LineFinanceStaticRiskAction = __webpack_require__(760);

	var LineFinanceStaticRiskAction = _interopRequireWildcard(_LineFinanceStaticRiskAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var companyName = "中智资产管理有限公司";
	//静态风险指数
	var LineFinanceStaticRisk = _react2.default.createClass({
	  displayName: 'LineFinanceStaticRisk',
	  componentWillMount: function componentWillMount() {
	    var queryDynamicPic = this.props.queryDynamicPic;

	    queryDynamicPic({ "companyName": companyName });
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {},
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'linefin-static-risk' },
	      _react2.default.createElement(_RiskSearchHeader2.default, null),
	      _react2.default.createElement(
	        'div',
	        { className: 'static-risk-box content-space-10' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(_LineFinanceRelationGraph2.default, this.props),
	          _react2.default.createElement(_LineFinanceCoCompose2.default, null)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(_LineFinanceIndexConstitute2.default, this.props)
	        )
	      )
	    );
	  }
	});
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {

	    //静态图谱
	    dynamicPicRequest: state.DynamicPic.request,
	    dynamicPicResult: state.DynamicPic.result,
	    //静态风险指数构成
	    // staticRiskRequest:state.StaticRisk.request,
	    // staticRiskResult: state.StaticRisk.result,
	    //静态风险变化趋势图

	    statisticsRequest: state.Statistics.request,
	    statisticsResult: state.Statistics.result,

	    //静态风险公司关联表&静态风险指数构成
	    riskDataRequest: state.RiskData.request,
	    riskDataResult: state.RiskData.result,

	    companyNewsRequest: state.CompanyNews.request,
	    companyNewsResult: state.CompanyNews.result
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(LineFinanceStaticRiskAction, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceStaticRisk);
	// module.exports = LineFinanceStaticRisk;
	//

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "StaticRisk.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 757:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(754);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _LineChart = __webpack_require__(759);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var _statisticsDate = [[], [], [], [], [], [], [], []],
	    _riskIndex = [[], [], [], [], [], [], [], []],
	    _avgRiskIndex = [[], [], [], [], [], [], [], []];
	//静态风险指数构成
	var LineFinanceIndexConstitute = _react2.default.createClass({
	    displayName: 'LineFinanceIndexConstitute',

	    getInitialState: function getInitialState() {
	        return {
	            statisticsDate: [],
	            riskIndex: [],
	            avgRiskIndex: [],
	            itemIndex: 0,
	            riskList: ""
	        };
	    },
	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        var isFirstItem = $itemParent.hasClass('item-first');
	        if (isTrue) {
	            if (!isFirstItem) {
	                $itemParent.removeClass('active');
	                $(this.refs.itemFirst).addClass('active');
	                $itemParent.find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	        } else {
	            if (!isFirstItem) {
	                $itemParent.find('.item-head .num i').removeClass('icon-xdown').addClass('icon-xup');
	                $(this.refs.itemFirst).removeClass('active');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	            $itemParent.addClass('active');
	        }
	    },
	    setParm: function setParm() {
	        var itemTable = this.state.riskList || '';
	        var option = {
	            "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	            "title": "",
	            "xtitle": "",
	            "legend": [""],
	            "legendShow": false,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "20%",
	            "seriesName": "静态风险指数构成",
	            "radius": "40%",
	            "lable": { normal: { show: true },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '50%'],
	            "series": [{
	                "name": "非法融资违规风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "人才结构风险",
	                "value": itemTable && itemTable.perStructRisk
	            }, {
	                "name": "实际控制人风险",
	                "value": itemTable && itemTable.realConRisk
	            }, {
	                "name": "公司扩张路径风险",
	                "value": itemTable && itemTable.comExpRisk
	            }, {
	                "name": "关联方中心集聚化风险",
	                "value": itemTable && itemTable.relInRisk
	            }, {
	                "name": "非法融资衍生风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "短期逐利风险",
	                "value": itemTable && itemTable.comExpRisk
	            }]
	        };
	        return option;
	    },
	    setLineParm: function setLineParm(param) {
	        var _optionArr = [];
	        if (this.state.statisticsDate.length == 0 || this.state.riskIndex.length == 0 || this.state.avgRiskIndex.length == 0) {
	            var option = {
	                color: ["#00b7ee", "#f8b551"],
	                bgColor: "",
	                title: "实际控制人风险趋势",
	                titleX: "left", //
	                boxId: "chartMap",
	                symbolSize: 10,
	                legendIsShow: true,
	                yFlag: "",
	                yAxisName: "",
	                legendRight: "30",
	                legend: ["公司", "行业平均"],
	                xAxis: [""],
	                series: [[""], [""]]
	            };
	        } else {
	            var option = {
	                color: ["#00b7ee", "#f8b551"],
	                bgColor: "",
	                title: "实际控制人风险趋势",
	                titleX: "left", //
	                boxId: "chartMap",
	                symbolSize: 10,
	                legendIsShow: true,
	                yFlag: "",
	                yAxisName: "",
	                legendRight: "30",
	                legend: ["公司", "行业平均"],
	                xAxis: this.state.statisticsDate[param],
	                series: [this.state.riskIndex[param], this.state.avgRiskIndex[param]]
	            };
	        }
	        return option;
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.riskDataRequest, this.props.riskDataRequest);
	        if (!isEqual) {
	            this.setState({
	                riskList: nextProps.riskDataResult.content
	            });
	        }
	        var companyNewsIsEqual = Immutable.is(nextProps.companyNewsRequest, this.props.companyNewsRequest);
	        if (!companyNewsIsEqual) {}
	    },
	    handleData: function handleData(param) {
	        var self = this;
	        if (!this.props.statisticsRequest) {
	            return;
	        }
	        this.props.statisticsResult.map(function (item, index) {
	            _statisticsDate[self.state.itemIndex].push(item.date);
	            _riskIndex[self.state.itemIndex].push(item.riskIndex);
	            _avgRiskIndex[self.state.itemIndex].push(item.avgRiskIndex);
	        });
	        this.setState({
	            statisticsDate: _statisticsDate,
	            riskIndex: _riskIndex,
	            avgRiskIndex: _avgRiskIndex,
	            itemIndex: self.state.itemIndex + 1
	        });
	    },
	    componentWillMount: function componentWillMount() {
	        var _param = this.props.location.query; //从搜索页面过来的参数
	        //请求右边表格数据
	        var queryRiskData = this.props.queryRiskData;

	        var dataObj = Object.assign(_param, { currentDate: '2016-05-30', areaCode: "长宁区" });
	        queryRiskData(dataObj);
	        //请求公司舆情
	        var companyNews = this.props.companyNews;

	        companyNews(_param);
	        //请求右面折线图
	        for (var i = 0; i < 8; i++) {
	            this.staticRiskIndex(i);
	        }
	    },
	    staticRiskIndex: function staticRiskIndex(tabIndex) {
	        //请求右面折线图
	        var _param = this.props.location.query; //从搜索页面过来的参数
	        var queryStatistics = this.props.queryStatistics;var self = this;
	        var dataObj = Object.assign(_param, { tabIndex: tabIndex, areaCode: "金山区" });
	        queryStatistics(dataObj);
	        setTimeout(function () {
	            self.handleData(tabIndex);
	        }, 1000);
	    },

	    render: function render() {
	        var selectProp = {
	            width: '85px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: 1, label: '2015-01' }, { value: 2, label: '2015-02' }, { value: 3, label: '2015-03' }, { value: 4, label: '2015-04' }],
	            onChange: function onChange(value) {
	                console.log('当前值为：', value);
	            }
	        };
	        var itemTable = this.state.riskList || '';
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-constitute mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '静态风险指数构成'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right sd' },
	                    _react2.default.createElement(_index.Selected, selectProp)
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'con-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-pie' },
	                        _react2.default.createElement(_BasePie2.default, { option: this.setParm(), style: { height: '520px', width: '100%' } })
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-info' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-first active', ref: 'itemFirst' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '静态风险指数'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        null,
	                                        '51.2'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '静态风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(0), style: { height: '290px', width: '100%' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '实际控制人风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.realConRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '单个一度关联自然人最大控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.maxComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '平均每位一度关联自然人控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.avgPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心一度关联自然人'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneLvlPer
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '实际控制人风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(1), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '公司扩张风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.comExpRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司自然人股东数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldComConPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司企业法人数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldCtlNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreCldCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '公司扩张风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(2), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联方中心积聚化风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.relInRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.ctlCldComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '一度关联企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.conCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '关联方中心积聚化风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(3), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融盗衍生风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illFinRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '三度关联自然人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.thrPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '二度关联企业法人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.twoComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心二度关联公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreTwoCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融盗衍生风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(4), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '短期逐利风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.shortRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月~1年以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立的公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '短期逐利风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(5), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融资违规风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illMoneyFinRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '投资类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.investment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '咨询类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '贸易类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '租赁类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.lease
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '保理类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.factoring
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '公司名单'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.companyList
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融资违规风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(6), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '人才结构风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.underNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '硕士以上人次（包括硕士）'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科以下人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '人才结构风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        _react2.default.createElement(_LineChart2.default, { option: this.setLineParm(7), style: { height: '290px', width: '510px' } })
	                                    )
	                                )
	                            )
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceIndexConstitute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceIndexConstitute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 760:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.queryDynamicPic = queryDynamicPic;
	exports.queryRisk = queryRisk;
	exports.queryStatistics = queryStatistics;
	exports.queryRiskData = queryRiskData;
	exports.companyNews = companyNews;
	/*
	  线下理财监测creat by yq
	*/

	//关联图谱数据
	var DYNAMIC_PIC_SUCCESS = exports.DYNAMIC_PIC_SUCCESS = 'DYNAMIC_PIC_SUCCESS';
	var DYNAMIC_PIC_FAIL = exports.DYNAMIC_PIC_FAIL = 'DYNAMIC_PIC_FAIL';

	function dynamicPicSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DYNAMIC_PIC_SUCCESS,
	    result: result
	  };
	}
	function dynamicPicFail(result) {
	  //请求失败调用方法
	  return {
	    type: DYNAMIC_PIC_FAIL,
	    result: result
	  };
	}

	function queryDynamicPic(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: " /offlineFinance/queryDynamicPicData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryDynamicSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryDynamicFail(result));
	      }
	    });
	  };
	}
	//静态风险指数构成
	var STATIC_RISK_SUCCESS = exports.STATIC_RISK_SUCCESS = 'STATIC_RISK_SUCCESS';
	var STATIC_RISK_FAIL = exports.STATIC_RISK_FAIL = 'STATIC_RISK_FAIL';
	function queryRiskSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DYNAMIC_PIC_SUCCESS,
	    result: result
	  };
	}
	function queryRiskFail(result) {
	  //请求失败调用方法
	  return {
	    type: DYNAMIC_PIC_FAIL,
	    result: result
	  };
	}

	function queryRisk(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryRiskData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryRiskSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryRiskFail(result));
	      }
	    });
	  };
	}
	//静态风险趋势图/offlineFinance/queryStatistics.do
	var STATISTICS_SUCCESS = exports.STATISTICS_SUCCESS = 'STATISTICS_SUCCESS';
	var STATISTICS_FAIL = exports.STATISTICS_FAIL = 'STATISTICS_FAIL';
	function queryStatisticsSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: STATISTICS_SUCCESS,
	    result: result
	  };
	}
	function queryStatisticsFail(result) {
	  //请求失败调用方法
	  return {
	    type: STATISTICS_FAIL,
	    result: result
	  };
	}

	function queryStatistics(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryStatistics.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryStatisticsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryStatisticsFail(result));
	      }
	    });
	  };
	}
	//公司关联情况列表/offlineFinance/queryRiskData.do
	var RISK_DATA_SUCCESS = exports.RISK_DATA_SUCCESS = 'RISK_DATA_SUCCESS';
	var RISK_DATA_FAIL = exports.RISK_DATA_FAIL = 'RISK_DATA_FAIL';
	function queryRiskDataSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RISK_DATA_SUCCESS,
	    result: result
	  };
	}
	function queryRiskDataFail(result) {
	  //请求失败调用方法
	  return {
	    type: RISK_DATA_FAIL,
	    result: result
	  };
	}
	function queryRiskData(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryRiskData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryRiskDataSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryRiskDataFail(result));
	      }
	    });
	  };
	}
	// //静态风险指数构成offlineFinance/staticRiskIndex.do
	// export const STATIC_RISK_INDEX_SUCCESS='STATIC_RISK_INDEX_SUCCESS'
	// export const STATIC_RISK_INDEX_FAIL='STATIC_RISK_INDEX_FAIL'
	// function staticRiskIndexSuccess(result) {//请求成功调用方法
	//   return {
	//     type: STATIC_RISK_INDEX_SUCCESS,
	//     result:result
	//   }
	// }
	// function staticRiskIndexFail(result) {//请求失败调用方法
	//   return {
	//     type: STATIC_RISK_INDEX_FAIL,
	//     result:result
	//   }
	// }
	// export function staticRiskIndexPie(json) {
	//   return (dispatch)=> {
	//     console.log(json)
	//      $.ajax({
	//           url: "/offlineFinance/staticRiskIndex.do",
	//           dataType:"json",
	//           data: json,
	//           type: "GET",
	//           success: function(result) {
	//                return dispatch(staticRiskIndexSuccess(result))
	//           },
	//           error:function(result){
	//                return dispatch(staticRiskIndexFail(result))
	//           }
	//       });
	//   }
	// }
	// 公司舆情/offlineFinance/companyNews.do?companyName
	var COMPANY_NEWS_SUCCESS = exports.COMPANY_NEWS_SUCCESS = 'COMPANY_NEWS_SUCCESS';
	var COMPANY_NEWS_FAIL = exports.COMPANY_NEWS_FAIL = 'COMPANY_NEWS_FAIL';
	function companyNewsSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_NEWS_SUCCESS,
	    result: result
	  };
	}
	function companyNewsFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_NEWS_FAIL,
	    result: result
	  };
	}
	function companyNews(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/companyNews.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyNewsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyNewsFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceStaticRiskAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 782:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDMap = _react2.default.createClass({
	    displayName: 'BBDMap',

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
	        //值阀最大值
	        var maxData = parm.series[0].value;
	        for (var i = 0; i < parm.series.length; i++) {
	            if (Number(parm.series[i].value) > maxData) {
	                maxData = Number(parm.series[i].value);
	            }
	        }
	        var option = {
	            tooltip: {
	                trigger: 'item',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    return v.name + "<br/>" + v.seriesName + ":" + v.value;
	                }
	            },
	            visualMap: {
	                min: 0,
	                max: maxData,
	                itemWidth: "15",
	                textGap: 30,
	                right: parm.visualMapRight == undefined ? "auto" : parm.visualMapRight,
	                bottom: parm.visualMapBottom == undefined ? "auto" : parm.visualMapBottom,
	                padding: [0, 0, 20, 50],
	                text: parm.visualMapText,
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                inRange: {
	                    color: ['rgba(4, 184, 245, 1)', 'rgba(14, 155, 200, 1)', 'rgba(34, 114, 139, 1)']
	                }
	            },
	            series: [{
	                type: 'map',
	                name: parm.seriesName == undefined ? "P2P公司数" : parm.seriesName,
	                map: 'shanghai',
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
	                data: parm.series
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
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDMap;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MapChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 792:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".privateFund-index .content {\r\n\tpadding: 20px 20px 50px 20px\r\n}\r\n\r\n.privateFund-index .privateF-m {\r\n\tmargin: 0.5% 0px;\r\n}\r\n\r\n.privateFund-index .privateF-m {\r\n}\r\n\r\n.privateFund-index .privateF-m .middle-l {\r\n\twidth: 45%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-m .middle-r {\r\n\twidth: 54.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l {\r\n\twidth: 60%;\r\n\tfloat: left;\r\n\theight: 612px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l .top-left-l {\r\n\twidth: 60%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l .top-left-r {\r\n\twidth: 39.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-r {\r\n\twidth: 39.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left;\r\n\theight: 612px;\r\n}\r\n\r\n.privateFund-index .privateF-b {\r\n}\r\n\r\n.privateFund-index .privateF-b .bottom-l,\r\n.privateFund-index .privateF-b .bottom-m,\r\n.privateFund-index .privateF-b .bottom-r {\r\n\twidth: 33.3%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index a {\r\n\tcolor: #e14340\r\n}", ""]);

	// exports


/***/ },

/***/ 793:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(794);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyProgress = _react2.default.createClass({
					displayName: 'CompanyProgress',

					getInitialState: function getInitialState() {
									return {
													list: []
									};
					},
					componentDidMount: function componentDidMount() {},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.companyProgressData, this.props.companyProgressData);
									if (!isEqual) {
													var companyProgressData = nextProps.companyProgressData;

													for (var i = 0; i < companyProgressData.length; i++) {
																	companyProgressData.shareholders = companyProgressData[i].shareholders.join("、");
													}
													this.setState({ list: companyProgressData });
									}
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ className: ' top-left-l' },
													_react2.default.createElement(
																	'div',
																	{ className: 'list-header' },
																	'QDLP试点企业最新进展'
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'mod-content' },
																	_react2.default.createElement(
																					'div',
																					{ className: 'table-title' },
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
																																					{ width: '10%', className: 'talign-center' },
																																					'序号'
																																	),
																																	_react2.default.createElement(
																																					'th',
																																					{ width: '25%' },
																																					'拟用名'
																																	),
																																	_react2.default.createElement(
																																					'th',
																																					{ width: '20%' },
																																					'股东方'
																																	),
																																	_react2.default.createElement(
																																					'th',
																																					{ width: '20%' },
																																					'获批额度($)',
																																					_react2.default.createElement('i', { className: 'iconfont icon-desc' })
																																	),
																																	_react2.default.createElement(
																																					'th',
																																					{ width: '25%' },
																																					'近期进展',
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
																									{ className: 'mt-table mt-table-center table-border-b wtyh-table' },
																									_react2.default.createElement(
																													'tbody',
																													null,
																													this.state.list.map(function (item, index) {
																																	{
																																					var num = index + 1;
																																					if (index % 2) {
																																									return _react2.default.createElement(
																																													'tr',
																																													{ className: 'even' },
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '10%', className: 'talign-center' },
																																																	num
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '25%' },
																																																	_react2.default.createElement(
																																																					_reactRouter.Link,
																																																					{ to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
																																																					item.companyName
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	_react2.default.createElement(
																																																					'span',
																																																					{ className: 'word-limit-5', 'data-tip': item.shareholders },
																																																					item.shareholders
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	item.quatas,
																																																	'亿'
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '25%' },
																																																	item.progress
																																													)
																																									);
																																					} else {
																																									return _react2.default.createElement(
																																													'tr',
																																													{ className: 'odd' },
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '10%', className: 'talign-center' },
																																																	num
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '25%' },
																																																	_react2.default.createElement(
																																																					_reactRouter.Link,
																																																					{ to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
																																																					item.companyName
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	_react2.default.createElement(
																																																					'span',
																																																					{ className: 'word-limit-5', 'data-tip': item.shareholders },
																																																					item.shareholders
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	item.quatas,
																																																	'亿'
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '25%' },
																																																	item.progress
																																													)
																																									);
																																					}
																																	}
																													})
																									)
																					)
																	)
													)
									);
					}
	});

	module.exports = CompanyProgress;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyProgress.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 796:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(794);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _PieChart = __webpack_require__(783);

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
	            console.log("测试");
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
	                                            item.totleNum
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', 'data-tip': item.companyList },
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

/***/ 797:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(794);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var QDLPQuality = _react2.default.createClass({
	    displayName: 'QDLPQuality',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getQDLPQualityRequest = this.props.getQDLPQualityRequest;

	        var jsonData = {};
	        getQDLPQualityRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.QDLPQualityRequest, this.props.QDLPQualityResult);
	        if (!isEqual) {
	            var QDLPQualityRequest = nextProps.QDLPQualityRequest;
	            var QDLPQualityResult = nextProps.QDLPQualityResult;

	            if (QDLPQualityRequest == true) {
	                if (QDLPQualityResult.success) {
	                    this.setState({ listData: QDLPQualityResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                'QFLP试点企业最新进展'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-title' },
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
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '试点企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '总规模($)',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '美元部分($)',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '投资合计(￥)',
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
	                        { className: 'mt-table mt-table-center table-border-b wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = QDLPQuality;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "QDLPQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 798:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(794);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

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

/***/ 799:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(794);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _HorizontalBarChart = __webpack_require__(800);

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

/***/ 800:
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
	                backgroundColor: '#222',
	                borderColor: '#222',
	                borderWidth: 1,
	                trigger: 'item',
	                formatter: "{b}: {c}"
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

/***/ 821:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(822);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	var _P2PIndexAction = __webpack_require__(824);

	var P2PIndexActionCreaters = _interopRequireWildcard(_P2PIndexAction);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(742);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _devTrend = __webpack_require__(825);

	var _devTrend2 = _interopRequireDefault(_devTrend);

	var _volume = __webpack_require__(828);

	var _volume2 = _interopRequireDefault(_volume);

	var _map = __webpack_require__(829);

	var _map2 = _interopRequireDefault(_map);

	var _areaRanking = __webpack_require__(830);

	var _areaRanking2 = _interopRequireDefault(_areaRanking);

	var _problemScale = __webpack_require__(831);

	var _problemScale2 = _interopRequireDefault(_problemScale);

	var _IndustrySentiment = __webpack_require__(832);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _netCreditContrast = __webpack_require__(833);

	var _netCreditContrast2 = _interopRequireDefault(_netCreditContrast);

	var _netCredit = __webpack_require__(834);

	var _netCredit2 = _interopRequireDefault(_netCredit);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//网贷平台数据展示

	//行业人气
	//上海区域发展指数排名
	//成交量和综合利率
	var Immutable = __webpack_require__(718);
	//p2p行业监测
	//网贷对比
	//问题平台比例
	//地图
	//新增平台发展趋势
	var P2PIndex = _react2.default.createClass({
	    displayName: 'P2PIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getp2pindexRequest = this.props.getp2pindexRequest;

	        var jsonData = {};
	        getp2pindexRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.indexChartRequest, this.props.indexChartResult);
	        if (!isEqual) {
	            var indexChartRequest = nextProps.indexChartRequest;
	            var indexChartResult = nextProps.indexChartResult;

	            if (indexChartRequest == true) {
	                if (indexChartResult.success) {
	                    this.setState({ listData: indexChartResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleFunction: function handleFunction(searchVal) {
	        this.props.history.push('/Portrait?platName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        var parm = this.state.listData;
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', isHotWorld: 'false', searchFun: this.handleFunction, placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-index-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-top clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-l' },
	                        _react2.default.createElement(_devTrend2.default, { deveTrendData: this.state.listData }),
	                        _react2.default.createElement(_volume2.default, { volumeData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_map2.default, { mapData: this.state.listData }),
	                    _react2.default.createElement(_areaRanking2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-bom clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bom-l' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'bom-l-t' },
	                            _react2.default.createElement(_problemScale2.default, { problemScaleData: this.state.listData }),
	                            _react2.default.createElement(_IndustrySentiment2.default, { industrySentimentData: this.state.listData })
	                        ),
	                        _react2.default.createElement(_netCreditContrast2.default, { netCreditContrastData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_netCredit2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        indexChartRequest: state.IndexChartAll.request,
	        indexChartResult: state.IndexChartAll.result,

	        areaRankingRequest: state.AreaRanking.request,
	        areaRankingResult: state.AreaRanking.result,

	        netCreditRequest: state.NetCredit.request,
	        netCreditResult: state.NetCredit.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 829:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _MapChart = __webpack_require__(782);

	var _MapChart2 = _interopRequireDefault(_MapChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.mapData, this.props.mapData);
	        if (!isEqual) {
	            var mapData = nextProps.mapData;

	            var optionParm = {
	                "visualMapRight": "50", //值茷位置
	                "visualMapBottom": "30",
	                "visualMapText": ["公司数量"],
	                "series": mapData.hotMap.data
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_MapChart2.default, { option: this.state.chartOption, style: { height: '649px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-c radius4' },
	            chartBox
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "map.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 830:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var AareaRanking = _react2.default.createClass({
	    displayName: 'AareaRanking',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getAreaRankRequest = this.props.getAreaRankRequest;

	        var jsonData = {};
	        getAreaRankRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.areaRankingRequest, this.props.areaRankingResult);
	        if (!isEqual) {
	            var areaRankingRequest = nextProps.areaRankingRequest;
	            var areaRankingResult = nextProps.areaRankingResult;

	            if (areaRankingRequest == true) {
	                console.log("redux测试成功=================areaRankingRequest");
	                if (areaRankingResult.success) {
	                    this.setState({ listData: areaRankingResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海区域发展指数'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'list-items' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'p2p-table  table-8 mt-table wtyh-table' },
	                    _react2.default.createElement(
	                        'tHead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '省份'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '生态环境'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '规模'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '人气'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '安全'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '资本认可'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '综合竞争'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'title' },
	                                    '上半年排名'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'nume' },
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tbody',
	                        null,
	                        this.state.listData.map(function (item, index) {
	                            {
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.area
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.ecosystem
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.scale
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.popularity
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.safety
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.recognition
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.competitiveness
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.rank
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd-line' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.area
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.ecosystem
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.scale
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.popularity
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.safety
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.recognition
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.competitiveness
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.rank
	                                        )
	                                    );
	                                }
	                            }
	                        })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = AareaRanking;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "areaRanking.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 831:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(759);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.problemScaleData, this.props.problemScaleData);
	        if (!isEqual) {
	            var problemScaleData = nextProps.problemScaleData;

	            var optionParm = {
	                color: ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	                title: "贷款余额",
	                titleX: "left",
	                boxId: "chartMap",
	                legendIsShow: true,
	                yFlag: "%",
	                legendRight: "10",
	                legendTop: "-10",
	                symbolSize: 5,
	                yAxisName: "",
	                legend: ["上海问题平台比例", "全国问题平台比例"],
	                xAxis: problemScaleData.problem.xAxis,
	                series: problemScaleData.problem.series
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineChart2.default, { option: this.state.chartOption, style: { height: '205px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-l-t-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '问题平台比例'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "problemScale.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 832:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(759);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var IndustrySentiment = _react2.default.createClass({
	    displayName: 'IndustrySentiment',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.industrySentimentData, this.props.industrySentimentData);
	        if (!isEqual) {
	            var industrySentimentData = nextProps.industrySentimentData;

	            var optionParm = {
	                color: ["#00b7ee", "#f8b551"],
	                title: "行业人气",
	                titleX: "left", //
	                boxId: "chartMap",
	                symbolSize: 5,
	                legendIsShow: true,
	                yFlag: "万人", //
	                yAxisName: "",
	                legendRight: "10%",
	                legendTop: "-10",
	                legend: ["投资人", "借款人"],
	                xAxis: industrySentimentData.popularity.xAxis,
	                series: industrySentimentData.popularity.series
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineChart2.default, { option: this.state.chartOption, style: { height: '205px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: ' mod bom-l-t-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '行业人气'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = IndustrySentiment;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndustrySentiment.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 833:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(800);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var NetCreditContrast = _react2.default.createClass({
	    displayName: 'NetCreditContrast',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.netCreditContrastData, this.props.netCreditContrastData);
	        if (!isEqual) {
	            var netCreditContrastData = nextProps.netCreditContrastData;

	            var optionParm = {
	                color: ["#e14340", "#00b7ee"],
	                barWidth: 20,
	                legendRight: "20",
	                gridLeft: '5%',
	                gridRight: '5%',
	                gridBottom: '0%',
	                gridTop: '12%',
	                label: {
	                    normal: {
	                        show: true,
	                        position: 'right',
	                        textStyle: {
	                            color: "#fff",
	                            fontSize: 12,
	                            fontWeight: "normal",
	                            fontFamily: 'Microsoft Yahei'
	                        }
	                    }
	                },
	                titleName: "网贷数据对比(上海VS全国)",
	                legend: ["全国(亿元)", "上海(亿元)"],
	                yAxis: ["成交量", "贷款余额"],
	                xAxisLabel: true,
	                xAxis: netCreditContrastData.compare.xAxis,
	                series: netCreditContrastData.compare.series
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_HorizontalBarChart2.default, { option: this.state.chartOption, style: { height: '180px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-l-b radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '网贷数据对比(上海VS全国)'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = NetCreditContrast;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCreditContrast.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 834:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(826);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var NetCredit = _react2.default.createClass({
	    displayName: 'NetCredit',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getNetCreditRequest = this.props.getNetCreditRequest;

	        var jsonData = {};
	        getNetCreditRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.netCreditRequest, this.props.netCreditResult);
	        if (!isEqual) {
	            var netCreditRequest = nextProps.netCreditRequest;
	            var netCreditResult = nextProps.netCreditResult;

	            if (netCreditRequest == true) {
	                // console.log("redux测试成功=================netCreditRequest")
	                if (netCreditResult.success) {
	                    this.setState({ listData: netCreditResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海网贷平台数据展示'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'list-items' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'table-6 mt-table wtyh-table' },
	                    _react2.default.createElement(
	                        'tHead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '排名',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '平台名称'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '成交量',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '平均利率',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '平均借款期限',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '累计待还金额',
	                                _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'tbody',
	                        null,
	                        this.state.listData.map(function (item, index) {
	                            {
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        null,
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.rank
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/Portrait', query: { platName: item.plat_name } } },
	                                                item.plat_name
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.amount,
	                                            '亿'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.income_rate,
	                                            '%'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.loan_period,
	                                            '月'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.stay_still_of_total,
	                                            '亿元'
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { className: 'odd-line' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.rank
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/Portrait', query: { platName: item.plat_name } } },
	                                                item.plat_name
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.amount,
	                                            '亿'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.income_rate,
	                                            '%'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.loan_period,
	                                            '月'
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.stay_still_of_total,
	                                            '亿元'
	                                        )
	                                    );
	                                }
	                            }
	                        })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = NetCredit;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "netCredit.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 835:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(822);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(742);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _baseMsg = __webpack_require__(836);

	var _baseMsg2 = _interopRequireDefault(_baseMsg);

	var _companyMsg = __webpack_require__(839);

	var _companyMsg2 = _interopRequireDefault(_companyMsg);

	var _coreData = __webpack_require__(840);

	var _coreData2 = _interopRequireDefault(_coreData);

	var _litigation = __webpack_require__(842);

	var _litigation2 = _interopRequireDefault(_litigation);

	var _publicOpinion = __webpack_require__(843);

	var _publicOpinion2 = _interopRequireDefault(_publicOpinion);

	var _rankPic = __webpack_require__(844);

	var _rankPic2 = _interopRequireDefault(_rankPic);

	var _scoreLeida = __webpack_require__(845);

	var _scoreLeida2 = _interopRequireDefault(_scoreLeida);

	var _P2PPortraitAction = __webpack_require__(847);

	var P2PPortraitCreaters = _interopRequireWildcard(_P2PPortraitAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//p2p平台画像
	//动态图谱
	//诉讼信息
	//公司基本信息
	var P2PPortrait = _react2.default.createClass({
	    displayName: 'P2PPortrait',

	    mixins: [_setHeight2.default],
	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    handleFunction: function handleFunction(searchVal) {
	        this.setState({ companyVal: searchVal }, function () {
	            var _props = this.props;
	            var getbaseMsgRequest = _props.getbaseMsgRequest;
	            var getcompanyMsgRequest = _props.getcompanyMsgRequest;
	            var getcoreDataRequest = _props.getcoreDataRequest;
	            var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	            var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	            var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;
	            var getlitigationRequest = _props.getlitigationRequest;
	            var getpublicOpinionRequest = _props.getpublicOpinionRequest;
	            var getrankPicRequest = _props.getrankPicRequest;
	            var getscoreLeidaRequest = _props.getscoreLeidaRequest;


	            getbaseMsgRequest({ "platName": this.state.companyVal });
	            getcompanyMsgRequest({ "platName": this.state.companyVal });
	            getcoreDataRequest({ "platName": this.state.companyVal });
	            getCoreBarDataRequest({ "platName": this.state.companyVal });
	            getCoreTrendDataRequest({ "platName": this.state.companyVal });
	            getCoreBalanceDataRequest({ "platName": this.state.companyVal });

	            getlitigationRequest({ "platName": this.state.companyVal });
	            getpublicOpinionRequest({ "platName": this.state.companyVal });

	            getrankPicRequest({ "platName": this.state.companyVal });
	            getscoreLeidaRequest({ "platName": this.state.companyVal });
	        });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-portrait', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', isHotWorld: 'false', searchFun: this.handleFunction, placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-portrait-content' },
	                '',
	                _react2.default.createElement(
	                    'div',
	                    { className: 'clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-left' },
	                        _react2.default.createElement(_companyMsg2.default, this.props),
	                        _react2.default.createElement(_baseMsg2.default, this.props),
	                        _react2.default.createElement(_rankPic2.default, this.props)
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-right' },
	                        _react2.default.createElement(_scoreLeida2.default, this.props),
	                        _react2.default.createElement(_coreData2.default, this.props)
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'portrait-bottom  clearfix' },
	                    _react2.default.createElement(_litigation2.default, this.props),
	                    _react2.default.createElement(_publicOpinion2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PPortrait;

	//将 request  result 绑定到props的request result
	//评分雷达图
	//平台舆情
	//核心数据
	//基本信息
	function mapStateToProps(state) {
	    return {
	        baseMsgRequest: state.BaseMsg.request,
	        baseMsgResult: state.BaseMsg.result,

	        companyMsgRequest: state.CompanyMsg.request,
	        companyMsgResult: state.CompanyMsg.result,

	        coreDataRequest: state.CoreData.request,
	        coreDataResult: state.CoreData.result,

	        coreBarRequest: state.CoreBar.request,
	        coreBarResult: state.CoreBar.result,

	        coreTrendRequest: state.CoreTrend.request,
	        coreTrendResult: state.CoreTrend.result,

	        coreBalanceRequest: state.CoreBalance.request,
	        coreBalanceResult: state.CoreBalance.result,

	        litigationRequest: state.Litigation.request,
	        litigationResult: state.Litigation.result,

	        publicOpinionRequest: state.PublicOpinion.request,
	        publicOpinionResult: state.PublicOpinion.result,

	        rankPicRequest: state.RankPic.request,
	        rankPicResult: state.RankPic.result,

	        scoreLeidaRequest: state.ScoreLeida.request,
	        scoreLeidaResult: state.ScoreLeida.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PPortraitCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PPortrait);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Portrait.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 836:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var BaseMsg = _react2.default.createClass({
	    displayName: 'BaseMsg',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getbaseMsgRequest = this.props.getbaseMsgRequest;

	        getbaseMsgRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.baseMsgRequest, this.props.baseMsgResult);
	        if (!isEqual) {
	            var baseMsgRequest = nextProps.baseMsgRequest;
	            var baseMsgResult = nextProps.baseMsgResult;

	            if (baseMsgRequest == true) {
	                if (baseMsgResult.success) {
	                    var _setParm = [baseMsgResult.content];
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-m radius4 mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '基本信息'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'list-items' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'mt-table wtyh-table' },
	                    this.state.listData.map(function (item, index) {
	                        {

	                            return _react2.default.createElement(
	                                'tbody',
	                                null,
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '平台名称'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.platName
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '公司名称：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': item.companyName },
	                                            item.companyName
	                                        )
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '法人代表：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.legalPeople
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '注册资本：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.capital
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '注册地址'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': item.address },
	                                            item.address
	                                        ),
	                                        ' '
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '开业日期：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.openedTime
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '核准日期：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.verifiedTime
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '登记机关：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.registerOffice
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '组织机构代码：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.companyCode
	                                    )
	                                ),
	                                ' '
	                            );
	                        }
	                    })
	                )
	            )
	        );
	    }
	});

	module.exports = BaseMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 839:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyMsg = _react2.default.createClass({
	    displayName: 'CompanyMsg',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getcompanyMsgRequest = this.props.getcompanyMsgRequest;

	        getcompanyMsgRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyMsgRequest, this.props.companyMsgResult);
	        if (!isEqual) {
	            var companyMsgRequest = nextProps.companyMsgRequest;
	            var companyMsgResult = nextProps.companyMsgResult;

	            if (companyMsgRequest == true) {
	                if (companyMsgResult.success) {
	                    var _setParm = [companyMsgResult.content];
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-t radius4 mod' },
	            this.state.listData.map(function (item, index) {
	                {

	                    return _react2.default.createElement(
	                        'ul',
	                        null,
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement('img', { src: '/images/no-logo.png' })
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'score orange' },
	                                item.score
	                            ),
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'score-title' },
	                                '评分'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'state' },
	                                item.status
	                            )
	                        )
	                    );
	                }
	            })
	        );
	    }
	});

	module.exports = CompanyMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 840:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(841);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	var _LineChart = __webpack_require__(759);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CoreData = _react2.default.createClass({
	    displayName: 'CoreData',


	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            listData: [],
	            coreBarData: null,
	            coreTrendData: null,
	            coreBalanceData: null,
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var _props = this.props;
	        var getcoreDataRequest = _props.getcoreDataRequest;
	        var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	        var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	        var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

	        getcoreDataRequest({ "platName": this.state.companyVal });
	        getCoreBarDataRequest({ "platName": this.state.companyVal });
	        getCoreTrendDataRequest({ "platName": this.state.companyVal });
	        getCoreBalanceDataRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.coreDataRequest, this.props.coreDataResult);
	        if (!isEqual) {
	            var coreDataRequest = nextProps.coreDataRequest;
	            var coreDataResult = nextProps.coreDataResult;

	            if (coreDataRequest == true) {
	                if (coreDataResult.success) {
	                    var _setParm = [];
	                    for (var item in coreDataResult.content) {
	                        var items = {
	                            name: item,
	                            value: coreDataResult.content[item]
	                        };
	                        _setParm.push(items);
	                    }
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualBar = Immutable.is(nextProps.coreBarRequest, this.props.coreBarResult);
	        if (!isEqualBar) {
	            var coreBarRequest = nextProps.coreBarRequest;
	            var coreBarResult = nextProps.coreBarResult;

	            if (coreBarRequest == true) {
	                if (coreBarResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        barWidth: 15,
	                        yAxisName: "万元",
	                        yFlag: "", //y轴单位
	                        gridBottom: '0',
	                        gridTop: '15%',
	                        legend: ["成交量"],
	                        legendShow: false,
	                        xAxis: coreBarResult.content.xAxis,
	                        series: [coreBarResult.content.series]
	                    };
	                    this.setState({ coreBarData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreTrendRequest, this.props.coreTrendResult);
	        if (!isEqualBar) {
	            var coreTrendRequest = nextProps.coreTrendRequest;
	            var coreTrendResult = nextProps.coreTrendResult;

	            if (coreTrendRequest == true) {
	                if (coreTrendResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        barWidth: 15,
	                        yAxisName: "万元",
	                        yFlag: "", //y轴单位
	                        gridBottom: '0',
	                        gridTop: '15%',
	                        legend: ["成交量"],
	                        legendShow: false,
	                        xAxis: coreTrendResult.content.xAxis,
	                        series: [coreTrendResult.content.series]
	                    };
	                    this.setState({ coreTrendData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreBalanceRequest, this.props.coreBalanceResult);
	        if (!isEqualBar) {
	            var coreBalanceRequest = nextProps.coreBalanceRequest;
	            var coreBalanceResult = nextProps.coreBalanceResult;

	            if (coreBalanceRequest == true) {
	                if (coreBalanceResult.success) {
	                    var option = {
	                        color: ["#00b7ee", "#f8b551"],
	                        title: "贷款余额",
	                        titleShow: true,
	                        titleX: "center",
	                        boxId: "chartMap",
	                        symbolSize: 5,
	                        legendIsShow: false,
	                        yFlag: "",
	                        yAxisName: "金额(亿元)",
	                        legendRight: "30",
	                        legend: ["投资人", "借款人"],
	                        xAxis: coreBalanceResult.content.xAxis,
	                        series: [coreBalanceResult.content.series]
	                    };
	                    this.setState({ coreBalanceData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBoxBar = "",
	            chartBoxTrend = "",
	            chartBalance = "";
	        if (this.state.coreBarData) {
	            chartBoxBar = _react2.default.createElement(_BarChart2.default, { option: this.state.coreBarData, style: { height: '270px', width: '100%' } });
	        }
	        if (this.state.coreTrendData) {
	            chartBoxTrend = _react2.default.createElement(_LineChart2.default, { option: this.state.coreTrendData, style: { height: '320px', width: '100%' } });
	        }
	        if (this.state.coreBalanceData) {
	            chartBalance = _react2.default.createElement(_LineChart2.default, { option: this.state.coreBalanceData, style: { height: '320px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-b radius4 mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '核心数据'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-top' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-list' },
	                        _react2.default.createElement(
	                            'table',
	                            { className: 'mt-table wtyh-table' },
	                            _react2.default.createElement(
	                                'tbody',
	                                null,
	                                this.state.listData.map(function (item, index) {
	                                    {
	                                        if (index % 2) {
	                                            return _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.name
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.value,
	                                                    '亿元'
	                                                )
	                                            );
	                                        } else {
	                                            return _react2.default.createElement(
	                                                'tr',
	                                                { className: 'odd-blackbg-line' },
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.name
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.value,
	                                                    '亿元'
	                                                )
	                                            );
	                                        }
	                                    }
	                                })
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-bar' },
	                        chartBoxBar
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-bottom' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-left' },
	                        chartBoxTrend
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-right' },
	                        chartBalance
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CoreData;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "coreData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 841:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BarChart = _react2.default.createClass({
	    displayName: "BarChart",

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
	                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                        offset: 0,
	                        color: parm.gradient[0]
	                    }, {
	                        offset: 1,
	                        color: parm.gradient[1]
	                    }])
	                }
	            };
	        }
	        var seriesBarData = [];
	        for (var i = 0; i < parm.series.length; i++) {
	            var seriesBarItem = {
	                "type": "bar",
	                "barWidth": parm.barWidth,
	                "itemStyle": itemStyle,
	                "label": parm.label == undefined ? {} : parm.label,
	                "name": parm.legend[i],
	                "data": parm.series[i]
	            };
	            seriesBarData.push(seriesBarItem);
	        }
	        var option = {
	            title: {
	                text: parm.title,
	                x: parm.titleX,
	                show: parm.titleShow == undefined ? false : parm.titleShow,
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            color: parm.color,
	            tooltip: {
	                trigger: 'axis',
	                formatter: function formatter(data) {
	                    // if(parm.formatter=="raise"){//
	                    return data[0].name + ' ：&nbsp' + data[0].value;
	                    // }else{
	                    //   // return data.value[2] + ' commits in ' + ' of ' + param.xAxis[data.value[1]];
	                    // }
	                },
	                axisPointer: { // 坐标轴指示器，坐标轴触发有效
	                    type: 'none' // 默认为直线，可选为：'line' | 'shadow'
	                }
	            },
	            legend: {
	                data: parm.legend,
	                show: parm.legendShow == undefined ? true : parm.legendShow,
	                right: 30,
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 12,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: {
	                left: parm.gridLeft == undefined ? "auto" : parm.gridLeft,
	                right: parm.gridRight == undefined ? "auto" : parm.gridRight,
	                bottom: parm.gridBottom == undefined ? "auto" : parm.gridBottom,
	                top: parm.gridTop == undefined ? "auto" : parm.gridTop,
	                containLabel: true
	            },
	            xAxis: [{
	                type: 'category',
	                data: parm.xAxis,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: parm.XTextColor || "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisTick: {
	                    show: false
	                }
	            }],
	            yAxis: [{
	                type: 'value',
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName,
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: parm.splitLineShow == undefined ? true : parm.splitLineShow,
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    formatter: '{value}' + parm.yFlag,
	                    textStyle: {
	                        color: parm.YTextColor || "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }],
	            series: seriesBarData
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
	exports.default = BarChart;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BarChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 842:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Litigation = _react2.default.createClass({
		displayName: 'Litigation',

		getInitialState: function getInitialState() {
			var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
			return {
				listData: [],
				companyVal: _selectVal
			};
		},
		componentDidMount: function componentDidMount() {
			var getlitigationRequest = this.props.getlitigationRequest;

			getlitigationRequest({ "platName": this.state.companyVal });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.litigationRequest, this.props.litigationResult);
			if (!isEqual) {
				var litigationRequest = nextProps.litigationRequest;
				var litigationResult = nextProps.litigationResult;

				if (litigationRequest == true) {
					if (litigationResult.success) {
						var _setParm = [litigationResult.content];

						this.setState({ listData: _setParm });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'bottom-l radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'诉讼信息'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						null,
						_react2.default.createElement(
							'li',
							null,
							_react2.default.createElement('span', { className: 'iconfont icon-susong skublue' })
						),
						_react2.default.createElement(
							'li',
							null,
							_react2.default.createElement(
								'span',
								{ className: 'ssong-title' },
								'诉讼信息'
							)
						),
						this.state.listData.map(function (item, index) {
							{

								return _react2.default.createElement(
									'li',
									null,
									_react2.default.createElement(
										'span',
										{ className: 'ssong-num' },
										_react2.default.createElement(
											_reactRouter.Link,
											{ to: { pathname: '/SearchResultDetail', query: { formpage: 'Portrait' } }, className: 'orange' },
											item.total
										)
									)
								);
							}
						})
					)
				)
			);
		}
	});

	module.exports = Litigation;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "litigation.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 843:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var PublicOpinion = _react2.default.createClass({
					displayName: 'PublicOpinion',

					getInitialState: function getInitialState() {
									var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
									return {
													listData: [],
													companyVal: _selectVal
									};
					},
					componentDidMount: function componentDidMount() {
									var getpublicOpinionRequest = this.props.getpublicOpinionRequest;

									getpublicOpinionRequest({ "platName": this.state.companyVal });
					},
					componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
									var isEqual = Immutable.is(nextProps.publicOpinionRequest, this.props.publicOpinionResult);
									if (!isEqual) {
													var publicOpinionRequest = nextProps.publicOpinionRequest;
													var publicOpinionResult = nextProps.publicOpinionResult;

													if (publicOpinionRequest == true) {
																	if (publicOpinionResult.success) {
																					var _setData = [];
																					for (var item in publicOpinionResult.content.warning) {
																									var items = {
																													"info": publicOpinionResult.content.warning[item].info,
																													"name": publicOpinionResult.content.plat_name
																									};
																									_setData.push(items);
																					}

																					console.log(_setData, "================publicOpinionResult==");
																					this.setState({ listData: _setData });
																	} else {
																					//错误后提示
																	}
													}
									}
					},
					render: function render() {
									return _react2.default.createElement(
													'div',
													{ className: 'bottom-r radius4 mod' },
													_react2.default.createElement(
																	'div',
																	{ className: 'header-gray' },
																	_react2.default.createElement(
																					'span',
																					{ className: 'title' },
																					'平台舆情'
																	)
													),
													_react2.default.createElement(
																	'div',
																	{ className: 'content' },
																	this.state.listData.map(function (item, index) {
																					{
																									var num = index + 1;
																									return _react2.default.createElement(
																													'div',
																													{ className: 'list-item' },
																													_react2.default.createElement(
																																	'table',
																																	null,
																																	_react2.default.createElement(
																																					'tbody',
																																					null,
																																					_react2.default.createElement(
																																									'tr',
																																									null,
																																									_react2.default.createElement(
																																													'td',
																																													{ rowSpan: '3', className: 'v-aglign-t td2-l' },
																																													_react2.default.createElement(
																																																	'span',
																																																	{ className: 'serial-num' },
																																																	num
																																													)
																																									),
																																									_react2.default.createElement(
																																													'td',
																																													{ className: 'td2-r' },
																																													_react2.default.createElement(
																																																	'a',
																																																	{ href: 'javascript:void(null)' },
																																																	item.name
																																													)
																																									)
																																					),
																																					_react2.default.createElement(
																																									'tr',
																																									null,
																																									_react2.default.createElement(
																																													'td',
																																													null,
																																													_react2.default.createElement(
																																																	'p',
																																																	{ className: 'item-mark' },
																																																	item.info
																																													)
																																									)
																																					)
																																	)
																													)
																									);
																					}
																	})
													)
									);
					}
	});

	module.exports = PublicOpinion;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "publicOpinion.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 844:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RankPic = _react2.default.createClass({
	    displayName: 'RankPic',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            searchVal: '',
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/guanliantu.js");
	        var getrankPicRequest = this.props.getrankPicRequest;

	        getrankPicRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.rankPicRequest, this.props.rankPicResult);
	        if (!isEqual) {
	            var rankPicRequest = nextProps.rankPicRequest;
	            var rankPicResult = nextProps.rankPicResult;

	            if (rankPicRequest == true) {
	                if (rankPicResult.success) {
	                    console.log("===================================图谱数据测试成功~！============================");
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-rel-graph mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '企业关联方图谱'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right search-enlarge' },
	                    _react2.default.createElement('i', { className: 'iconfont icon-fullscreen' })
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-legend' },
	                    _react2.default.createElement(
	                        'table',
	                        null,
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '目标公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/xuxianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '投资人'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange-two' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '子公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/shixianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '企业高管'
	                                    )
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'condition', style: { display: "none" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'lable' },
	                            '请选择以下筛选条件'
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btns' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-modal' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'company-title' },
	                        '成都中建明城投资有限公司'
	                    ),
	                    _react2.default.createElement(
	                        'table',
	                        null,
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '注册资本'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '500万'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '登记状态'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '在营开业企业'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方法人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '386'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方自然人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '289'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '自然人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '21'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '法人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '8'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '子股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '0'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'a',
	                        { href: '', className: 'see-detail' },
	                        '查看详情'
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box' },
	                    _react2.default.createElement('input', { type: 'hidden', id: 'GLOBAL', 'data-url': '', 'data-sidenav': '3', 'data-taoxi': 'S', 'data-isopen': '1' }),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'main', style: { "height": "100%" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'show-company-info', id: 'show-company-info', style: { "display": "none" } },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            ),
	                            _react2.default.createElement(
	                                'h1',
	                                { id: 'companyName-info' },
	                                'loading...'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'des', id: 'companyName-des-info' },
	                                '...'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'correlation-tips' },
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '隐藏文字', id: 'cavHideText' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-3.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '放大', id: 'cavToMax' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-4.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'mtui-tips-info', 'data-info': '缩小', id: 'cavToMin' },
	                                _react2.default.createElement('img', { src: '/assets/images/k-5.jpg', alt: '' })
	                            ),
	                            _react2.default.createElement(
	                                'a',
	                                { className: 'pic-tips', href: 'javascript:;' },
	                                '图例说明 ',
	                                _react2.default.createElement('i', { className: 'iconfont icon-xia' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 't-img' },
	                                    _react2.default.createElement(
	                                        'ul',
	                                        null,
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop1' },
	                                            '当前目标'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '被投资公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '股东'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '董监高'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他公司'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop2' },
	                                            '其他自然人'
	                                        ),
	                                        _react2.default.createElement(
	                                            'li',
	                                            { className: 'mtop3' },
	                                            '投资关系'
	                                        )
	                                    ),
	                                    _react2.default.createElement('img', { className: '', src: '/assets/images/tips.gif', alt: '' })
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'time-line' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'date' },
	                                _react2.default.createElement('ul', { className: 'dateul' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'canvas selectNull', id: 'canvas-box' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'drag-box' },
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover-nodes', id: 'cav-hover-nodes' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-hover', id: 'cav-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-main-hover', id: 'cav-main-hover' }),
	                                ' ',
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes', id: 'cav-nodes' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-nodes-text', id: 'cav-nodes-text' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links-hover', id: 'cav-links-hover' }),
	                                _react2.default.createElement('div', { className: 'cav-main cav-links', id: 'cav-links' })
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebar' },
	                            _react2.default.createElement('a', { href: 'javascript:;', className: 'sidebtn' })
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'sidebox', style: { display: "none" } },
	                            _react2.default.createElement(
	                                'ul',
	                                { className: 'select-nav clearfix' },
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '1' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '1度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '2' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '2度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '3' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '3度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'levels', 'data-level': '4' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '4度'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'all' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '全部'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'shareholder', 'langs-title': '股东投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '股东投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'direct', 'langs-title': '直接投资' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '直接投资'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'li',
	                                    { className: 'tz', 'data-type': 'leader', 'langs-title': '董监高' },
	                                    _react2.default.createElement(
	                                        'a',
	                                        { href: 'javascript:;' },
	                                        '董监高'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'search-company' },
	                                _react2.default.createElement('input', { type: 'text', className: 'name', id: 'searchCompanyLocal', placeholder: '搜索关联方列表' }),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'index-search-content' },
	                                    ' ...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'allCompany' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'gdCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'zjCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'all-company', id: 'djgCompany', style: { "display": "none" } },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-loading' },
	                                    'loading...'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'down-btn' },
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-blue down-excel' },
	                                    '下载Excel'
	                                ),
	                                _react2.default.createElement(
	                                    'a',
	                                    { href: 'javascript:;', className: 'mt-btn-grey reset-old' },
	                                    '恢复默认'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'loadingBox' },
	                        _react2.default.createElement(
	                            'p',
	                            null,
	                            '数据加载中...'
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'click-detail-show', id: 'click-detail-show' },
	                        _react2.default.createElement(
	                            'h1',
	                            null,
	                            '基本资料 ',
	                            _react2.default.createElement(
	                                'a',
	                                { href: 'javascript:;', className: 'close' },
	                                _react2.default.createElement('i', { className: 'iconfont icon-icon13' })
	                            )
	                        ),
	                        _react2.default.createElement('div', { className: 'detail-content' })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = RankPic;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "rankPic.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 845:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(837);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _RadarChart = __webpack_require__(846);

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
		componentDidMount: function componentDidMount() {
			var getscoreLeidaRequest = this.props.getscoreLeidaRequest;

			getscoreLeidaRequest({ "platName": this.state.companyVal });
		},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			var isEqual = Immutable.is(nextProps.scoreLeidaRequest, this.props.scoreLeidaResult);
			if (!isEqual) {
				var scoreLeidaRequest = nextProps.scoreLeidaRequest;
				var scoreLeidaResult = nextProps.scoreLeidaResult;

				if (scoreLeidaRequest == true) {
					if (scoreLeidaResult.success) {
						var socreNum = $(this.refs.scoreNum).html(scoreLeidaResult.content.score);
						var _setindicator = [];
						for (var item in scoreLeidaResult.content.indicator) {
							var items = {
								"name": "运营能力",
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
								'评分：'
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

/***/ 850:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".raise-index .radius4 {\r\n\tborder-radius: 5px;\t/*background: #2b323c;*/\r\n}\r\n\r\n.raise-index .header {\r\n\theight: 70px;\r\n\tline-height: 70px;\r\n\tfont-size: 24px;\r\n\tcolor: #fff;\r\n\tbackground: #1a2029;\r\n\ttext-align: center;\r\n}\r\n\r\n.raise-index .raise-index-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.raise-index .raise-index-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n}\r\n\r\n.raise-index .raise-index-right {\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.raise-index  .content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.raise-index a {\r\n\tcolor: #e14340\r\n}", ""]);

	// exports


/***/ },

/***/ 851:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var BusinessTypes = _react2.default.createClass({
	    displayName: 'BusinessTypes',


	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getbusinessRequest = this.props.getbusinessRequest;

	        var jsonData = {};
	        getbusinessRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.businessTypesRequest, this.props.businessTypesResult);
	        if (!isEqual) {
	            var businessTypesRequest = nextProps.businessTypesRequest;
	            var businessTypesResult = nextProps.businessTypesResult;

	            if (businessTypesRequest == true) {
	                if (businessTypesResult.success) {
	                    var option = {
	                        "color": ["#deab61", "#e14340", "#91c7ae", "#efd79b"],
	                        "title": "",
	                        "xtitle": "",
	                        "legend": businessTypesResult.content.legend,
	                        "legendShow": true,
	                        "legendOrient": "vertical",
	                        "legendLeft": "",
	                        "legendTop": "middle",
	                        "legendRight": "20%",
	                        "seriesName": "企业数",
	                        "radius": "70%",
	                        "lable": {
	                            normal: { show: false },
	                            emphasis: { show: false }
	                        },
	                        "center": ['40%', '50%'],
	                        "series": businessTypesResult.content.series
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartData) {
	            console.log("测试");
	            chartBox = _react2.default.createElement(_BasePie2.default, { option: this.state.chartData, style: { height: '400px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod left-top radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '业务类型分布'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = BusinessTypes;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessTypes.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 853:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".raise-index .left-top {\r\n\theight: 500px;\r\n}\r\n\r\n.raise-index .left-middle,\r\n.raise-index .right-middle {\r\n\tmargin: 1% 0px;\r\n\theight: 570px\r\n}\r\n\r\n.raise-index .right-top {\r\n\theight: 500px\r\n}\r\n\r\n.raise-index .left-bottom .mod-content,\r\n.raise-index .right-bottom .mod-content {\r\n\theight: 700px;\r\n\tpadding: 30px 20px 50px 20px;\r\n}\r\n\r\n.raise-index .left-bottom .mod-content .table-content,\r\n.raise-index .right-bottom .mod-content .table-content {\r\n\theight: 570px;\r\n\toverflow: auto;\r\n}\r\n\r\n.raise-index .left-bottom .mod-content table,\r\n.raise-index .right-bottom .mod-content table {\r\n\r\n\t/*height: 100%;*/\r\n}\r\n\r\n.raise-index .left-bottom  .mt-table,\r\n.raise-index .right-bottom  .mt-table {\r\n\tmargin: 0px;\r\n}\r\n\r\n.raise-index .left-bottom .wtyh-table thead th,\r\n.raise-index .right-bottom .wtyh-table thead th {\r\n\r\n\t/*\ttext-align: left !important;*/\r\n\tpadding: 16px 8px;\r\n}\r\n\r\n.raise-index .left-bottom .mt-table-center th,\r\n.raise-index .right-bottom .mt-table-center th {\r\n\ttext-align: left\r\n}\r\n\r\n.raise-index .left-bottom .wtyh-table tbody td,\r\n.raise-index .right-bottom .wtyh-table tbody td {\r\n\ttext-align: left;\r\n\tpadding: 16px 8px;\r\n}\r\n\r\n.raise-index .left-bottom .wtyh-table tbody tr,\r\n.raise-index .right-bottom .wtyh-table tbody tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}", ""]);

	// exports


/***/ },

/***/ 854:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(841);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var InvestPeople = _react2.default.createClass({
	    displayName: 'InvestPeople',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getinvestPeopleRequest = this.props.getinvestPeopleRequest;

	        var jsonData = {};
	        getinvestPeopleRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.investPeopleRequest, this.props.investPeopleResult);
	        if (!isEqual) {
	            var investPeopleRequest = nextProps.investPeopleRequest;
	            var investPeopleResult = nextProps.investPeopleResult;

	            if (investPeopleRequest == true) {
	                if (investPeopleResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        barWidth: 30,
	                        yAxisName: "万人次",
	                        gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
	                        yFlag: "", //y轴单位
	                        splitLineShow: false,
	                        legendShow: false,
	                        legend: ["投资人/次"],
	                        formatter: "raise",
	                        gridTop: "10%",
	                        gridBottom: "5%",
	                        label: {
	                            normal: {
	                                show: true,
	                                position: 'top',
	                                textStyle: {
	                                    color: "#fff",
	                                    fontSize: 12,
	                                    fontWeight: "normal",
	                                    fontFamily: 'Microsoft Yahei'
	                                }
	                            }
	                        },
	                        xAxis: investPeopleResult.content.xAxis,
	                        series: [investPeopleResult.content.series]
	                    };
	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartData) {
	            console.log("测试");
	            chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '500px', width: '80%', margin: '0px auto' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod left-middle radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上月上海各类众筹平台新增项目的投资人次'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = InvestPeople;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InvestPeople.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 855:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(841);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var NewProject = _react2.default.createClass({
	    displayName: 'NewProject',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getnewProjectRequest = this.props.getnewProjectRequest;

	        var jsonData = {};
	        getnewProjectRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.newProjectRequest, this.props.newProjectResult);
	        if (!isEqual) {
	            var newProjectRequest = nextProps.newProjectRequest;
	            var newProjectResult = nextProps.newProjectResult;

	            if (newProjectRequest == true) {
	                if (newProjectResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        barWidth: 30,
	                        yAxisName: "",
	                        gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
	                        yFlag: "", //y轴单位
	                        splitLineShow: false,
	                        gridShow: false,
	                        legendShow: false,
	                        gridTop: "10%",
	                        label: {
	                            normal: {
	                                show: true,
	                                position: 'top',
	                                textStyle: {
	                                    color: "#fff",
	                                    fontSize: 12,
	                                    fontWeight: "normal",
	                                    fontFamily: 'Microsoft Yahei'
	                                }
	                            }
	                        },
	                        legendBottom: "5%",
	                        legend: ["投资人/次"],
	                        xAxis: newProjectResult.content.xAxis,
	                        series: [newProjectResult.content.series]
	                    };
	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartData) {
	            chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '450px', width: '80%', margin: '0px auto' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-top radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上月上海各类众筹平台新增项目数'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = NewProject;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "NewProject.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 856:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(841);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RaiseMount = _react2.default.createClass({
	    displayName: 'RaiseMount',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getraiseMountRunRequest = this.props.getraiseMountRunRequest;

	        var jsonData = {};
	        getraiseMountRunRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.raiseMountRunRequest, this.props.raiseMountResult);
	        if (!isEqual) {
	            var raiseMountRunRequest = nextProps.raiseMountRunRequest;
	            var raiseMountResult = nextProps.raiseMountResult;

	            if (raiseMountRunRequest == true) {
	                if (raiseMountResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        barWidth: 30,
	                        yAxisName: "亿元",
	                        yFlag: "", //y轴单位
	                        gradient: ['rgb(251, 99, 96)', 'rgb(193, 42, 39)'],
	                        splitLineShow: false,
	                        legendShow: false,
	                        gridTop: "10%",
	                        gridBottom: "5%",
	                        label: {
	                            normal: {
	                                show: true,
	                                position: 'top',
	                                textStyle: {
	                                    color: "#fff",
	                                    fontSize: 12,
	                                    fontWeight: "normal",
	                                    fontFamily: 'Microsoft Yahei'
	                                }
	                            }
	                        },
	                        legend: ["投资人/次"],
	                        xAxis: raiseMountResult.content.xAxis,
	                        series: [raiseMountResult.content.series]
	                    };
	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartData) {
	            chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.chartData, style: { height: '500px', width: '80%', margin: '0px auto' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-middle radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上月上海各类众筹平台新增项目数的成功筹资金额'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = RaiseMount;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RaiseMount.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 857:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var PlatformRun = _react2.default.createClass({
	    displayName: 'PlatformRun',

	    getInitialState: function getInitialState() {
	        return {
	            option: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var isEqual = Immutable.is(nextProps.platFormRunBaseData, this.props.platFormRunBaseData);
	        if (!isEqual) {
	            var platFormRunBaseData = nextProps.platFormRunBaseData;

	            this.setState({ option: platFormRunBaseData.content });
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '平台运营情况'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%', className: 'talign-center' },
	                                    '众筹平台'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '公司名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%' },
	                                    '业务类型',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '成功项目数',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '已筹基金(万元)',
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.option.map(function (item, index) {
	                                {
	                                    if (item.fundingBusinessTypeCN == "0") {
	                                        item.fundingBusinessTypeCN = "权益型";
	                                    }
	                                    if (!item.successNumber) {
	                                        item.successNumber = "/";
	                                    }
	                                    if (!item.fundedAmout) {
	                                        item.fundedAmout = "/";
	                                    }
	                                    if (index % 2) {

	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%', className: 'talign-center' },
	                                                item.platformName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.fundingBusinessTypeCN
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.successNumber
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                item.fundedAmout
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%', className: 'talign-center' },
	                                                item.platformName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.fundingBusinessTypeCN
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.successNumber
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                item.fundedAmout
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = PlatformRun;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PlatformRun.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 858:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(852);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var PlatformBase = _react2.default.createClass({
	    displayName: 'PlatformBase',

	    getInitialState: function getInitialState() {
	        return {
	            option: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.platFormBaseData, this.props.platFormBaseData);
	        if (!isEqual) {
	            var platFormBaseData = nextProps.platFormBaseData;

	            this.setState({ option: platFormBaseData.content });
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod left-bottom radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '平台基本情况'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%' },
	                                    '平台名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '公司名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%' },
	                                    '注册地',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '运营地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%' },
	                                    '网址'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.option.map(function (item, index) {
	                                {
	                                    if (!item.areaName) {
	                                        item.areaName = "/";
	                                    }
	                                    var _areaName = item.areaName == null ? "/" : item.areaName;
	                                    var _address = item.address == null ? "/" : item.address;
	                                    var _num = index + 1;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                _num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.platformName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%', className: 'talign-left' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformBase', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                _areaName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _react2.default.createElement(
	                                                    'a',
	                                                    { href: item.websiteUrl },
	                                                    '查看'
	                                                )
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                _num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.platformName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%', className: 'talign-left' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformBase', company: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                _areaName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                _react2.default.createElement(
	                                                    'a',
	                                                    { href: item.websiteUrl },
	                                                    '查看'
	                                                )
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = PlatformBase;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "PlatformBase.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 860:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(742);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyNum = __webpack_require__(863);

	var _CompanyNum2 = _interopRequireDefault(_CompanyNum);

	var _CapitalAmount = __webpack_require__(866);

	var _CapitalAmount2 = _interopRequireDefault(_CapitalAmount);

	var _BusinessNum = __webpack_require__(867);

	var _BusinessNum2 = _interopRequireDefault(_BusinessNum);

	var _Income = __webpack_require__(868);

	var _Income2 = _interopRequireDefault(_Income);

	var _CompanyDirectory = __webpack_require__(869);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _PawnMonitoringAction = __webpack_require__(870);

	var PawnMonitoringActionCreaters = _interopRequireWildcard(_PawnMonitoringAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//典当总收入

	//注册资本总额


	var Immutable = __webpack_require__(718);
	//众筹监测
	//上海市企业典当目录
	//业务笔数
	//典当法人企业数
	var PawnMonitoring = _react2.default.createClass({
	    displayName: 'PawnMonitoring',

	    getInitialState: function getInitialState() {
	        return {
	            lineData: [],
	            doubleBarData: [],
	            scatterData: [],
	            barData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getChartAllRequest = this.props.getChartAllRequest;

	        var jsonData = {};
	        getChartAllRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.chartAllRequest, this.props.chartAllResult);
	        if (!isEqual) {
	            var chartAllRequest = nextProps.chartAllRequest;
	            var chartAllResult = nextProps.chartAllResult;

	            if (chartAllRequest == true) {
	                if (chartAllResult.success) {

	                    /*"year": 2015,
	                     "companyNumber": 256,
	                     "balance": 645711,//典当余额（万元
	                     "registerCapital": 637096,//注册资本（万元）
	                     "totalIncome": 103078,//总费收入（万元）
	                     "totalAmout": 4664405,//典当金额（万元）
	                     "number": 351148//典当笔数*/

	                    var _xAxisData = [],
	                        _companyNumber = [],
	                        _balance = [],
	                        _registerCapital = [],
	                        _totalIncome = [],
	                        _totalAmout = [],
	                        _number = [];
	                    for (var item in chartAllResult.content) {
	                        _xAxisData.push(chartAllResult.content[item].year); //年份
	                        _companyNumber.push(chartAllResult.content[item].companyNumber);

	                        _balance.push(chartAllResult.content[item].balance);
	                        _registerCapital.push(chartAllResult.content[item].registerCapital);
	                        _totalIncome.push(chartAllResult.content[item].totalIncome);
	                        _totalAmout.push(chartAllResult.content[item].totalAmout);
	                        _number.push(chartAllResult.content[item].number);
	                    }
	                    var _setLineData = {
	                        "xAxisData": _xAxisData,
	                        "data": _companyNumber
	                    };

	                    var _doubleBarData = {
	                        "xAxisData": _xAxisData,
	                        "data": [_balance, _registerCapital]
	                    };

	                    var _scatterData = {
	                        "xAxisData": _xAxisData,
	                        "yAxisData": _totalAmout,
	                        "data": _number
	                    };

	                    var _barData = {
	                        "xAxisData": _xAxisData,
	                        "data": _totalIncome
	                    };
	                    this.setState({ lineData: _setLineData });
	                    this.setState({ doubleBarData: _doubleBarData });
	                    this.setState({ scatterData: _scatterData });
	                    this.setState({ barData: _barData });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleFunction: function handleFunction(searchVal) {
	        this.props.history.push('/SearchResultDetail?platName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'pawnMonitoring-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '典当行业监测', searchFun: this.handleFunction, companyType: '12', placeholder: '请输入企业名称关键字' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-top clearfix' },
	                    _react2.default.createElement(_CompanyNum2.default, { Data: this.state.lineData }),
	                    _react2.default.createElement(_CapitalAmount2.default, { Data: this.state.doubleBarData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-Middle clearfix' },
	                    _react2.default.createElement(_BusinessNum2.default, { Data: this.state.scatterData }),
	                    _react2.default.createElement(_Income2.default, { Data: this.state.barData })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pawnM-bottom' },
	                    _react2.default.createElement(_CompanyDirectory2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = PawnMonitoring;
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        chartAllRequest: state.PawnMChartAll.request,
	        chartAllResult: state.PawnMChartAll.result,

	        companyDirRequest: state.CompanyDirectory.request,
	        companyDirResult: state.CompanyDirectory.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(PawnMonitoringActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(PawnMonitoring);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 867:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(864);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _ScatterChart = __webpack_require__(740);

	var _ScatterChart2 = _interopRequireDefault(_ScatterChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var BusinessNum = _react2.default.createClass({
	    displayName: 'BusinessNum',


	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.Data, this.props.Data);
	        if (!isEqual) {
	            var Data = nextProps.Data;


	            var _setData = [];
	            for (var i = 0; i < Data.data.length; i++) {
	                var item = [];
	                item.push(i, i, Data.data[i], Data.yAxisData[i]);
	                _setData.push(item);
	            }

	            var optionParm = {
	                id: 'loan-balance-chart', //必传
	                height: '465px', //必传 带上单位
	                title: ' ',
	                yAxisName: "笔数",
	                legend: [],
	                formatter: "BusinessNum",
	                xAxis: Data.xAxisData,
	                yAxis: Data.yAxisData,
	                data: _setData,
	                series: [[{
	                    color: '#e14340'
	                }]]
	            };
	            this.setState({ option: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_ScatterChart2.default, { param: this.state.option });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-left radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '典当总额及业务笔数'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = BusinessNum;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessNum.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 868:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(864);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(841);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Income = _react2.default.createClass({
	    displayName: 'Income',


	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.Data, this.props.Data);
	        if (!isEqual) {
	            var Data = nextProps.Data;

	            var optionParm = {
	                title: "平台交易量走势",
	                titleX: "center",
	                color: ["#12b5b0"],
	                barWidth: 20,
	                yAxisName: "单位：亿元",
	                yFlag: "", //y轴单位
	                splitLineShow: false,
	                gridBottom: '5%',
	                gridTop: '15%',
	                gridLeft: '5%',
	                gridRight: '5%',
	                legend: ["平台交易量走势"],
	                xAxis: Data.xAxisData,
	                series: [Data.data]
	            };
	            this.setState({ option: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.option, style: { height: '465px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-right radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '典当总费收入'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = Income;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Income.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 869:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(864);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',


	    getInitialState: function getInitialState() {
	        return {
	            listData: [],
	            orderZB: "desc", //排序方式
	            orderName: "" //排序字段
	        };
	    },
	    countyChange: function countyChange(orderType, orderName) {
	        var getcompanyDirRequest = this.props.getcompanyDirRequest;

	        var jsonData = {
	            descAsc: orderType, //desc:降序 asc:升序
	            orderByField: orderName //列表排序
	        };
	        getcompanyDirRequest(jsonData);
	    },
	    handleClick: function handleClick(name, type) {
	        var _dom = $(this.refs[name]);
	        var _domAttr = _dom.attr("data-order");
	        if (_domAttr == "desc") {
	            _dom.attr("data-order", "asc");
	        } else {
	            _dom.attr("data-order", "desc");
	        }
	        var _getAttr = _dom.attr("data-order");
	        this.setState({ orderName: type }, function () {
	            this.countyChange(this.state.orderZB, this.state.orderName);
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ orderName: "" });
	        this.setState({ orderZB: "desc" });
	        this.countyChange(this.state.orderZB, this.state.orderName);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyDirRequest, this.props.companyDirResult);
	        if (!isEqual) {
	            var companyDirRequest = nextProps.companyDirRequest;
	            var companyDirResult = nextProps.companyDirResult;

	            if (companyDirRequest == true) {
	                if (companyDirResult.success) {
	                    $(this.refs.totleCount).html(companyDirResult.content.length);
	                    this.setState({ listData: companyDirResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市典当企业目录'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'totle-num' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'orange', ref: 'totleCount' },
	                        '  '
	                    ),
	                    '家企业'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '5%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '典当行名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%' },
	                                    '法人代表'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%' },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { 'data-order': this.state.orderZB, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital", "1"), className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%' },
	                                    '注册时间',
	                                    _react2.default.createElement('i', { 'data-order': this.state.orderZB, ref: 'registeredDate', onClick: this.handleClick.bind(this, "registeredDate", "2"), className: 'iconfont icon-desc' })
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _danwei = item.registeredCapitalType == 1 ? "人民币" : "美元";
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '5%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                item.companyName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                item.legalPerson
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                item.address
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                item.registeredCapital,
	                                                _danwei
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.registeredTime
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '5%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                item.companyName
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                item.legalPerson
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                item.address
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%' },
	                                                item.registeredCapital,
	                                                _danwei
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '15%' },
	                                                item.registeredTime
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CompanyDirectory;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDirectory.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 873:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".tradingPlaces-index .tradingP-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.tradingPlaces-index .tradingP-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.tradingPlaces-index .content {\r\n\tpadding: 30px 20px 30px 20px;\r\n}\r\n\r\n.tradingPlaces-index  a {\r\n\tcolor: #e14340\r\n}", ""]);

	// exports


/***/ },

/***/ 874:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(875);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RegionalDis = _react2.default.createClass({
	    displayName: 'RegionalDis',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getRegionalDisRequest = this.props.getRegionalDisRequest;

	        var jsonData = {};
	        getRegionalDisRequest(jsonData);
	    },
	    onChartClick: function onChartClick(param, echart) {
	        var setPieCounty = this.props.setPieCounty;

	        var jsonData = { areaName: param.data.name };
	        setPieCounty(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.regionalDisRequest, this.props.regionalDisResult);
	        if (!isEqual) {
	            var regionalDisRequest = nextProps.regionalDisRequest;
	            var regionalDisResult = nextProps.regionalDisResult;


	            if (regionalDisRequest == true) {
	                if (regionalDisResult.success) {
	                    var _setData = [];
	                    for (var i = 0; i < regionalDisResult.content.yAxis.length; i++) {
	                        var item = {
	                            "name": regionalDisResult.content.yAxis[i],
	                            "value": regionalDisResult.content.series[i]
	                        };
	                        _setData.push(item);
	                    }
	                    var setParm = {
	                        "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	                        "title": "",
	                        "xtitle": "",
	                        "legend": [""],
	                        "legendShow": false,
	                        "legendOrient": "vertical",
	                        "legendLeft": "",
	                        "legendTop": "middle",
	                        "legendRight": "20%",
	                        "seriesName": "企业数",
	                        "radius": "70%",
	                        "lable": {
	                            normal: {
	                                show: true,
	                                formatter: function formatter(val) {
	                                    return val.name + ":" + val.value;
	                                }
	                            },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '50%'],
	                        "series": _setData
	                    };

	                    this.setState({ option: setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        var onEvents = {
	            'click': this.onChartClick
	        };
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_BasePie2.default, { option: this.state.option, onEvents: onEvents, style: { height: '530px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-top' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '交易场所区域分布'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = RegionalDis;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RegionalDis.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 877:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(875);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _HorizontalBarChart = __webpack_require__(800);

	var _HorizontalBarChart2 = _interopRequireDefault(_HorizontalBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Classification = _react2.default.createClass({
	    displayName: 'Classification',

	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getClassificationAllRequest = this.props.getClassificationAllRequest;

	        var jsonData = {};
	        getClassificationAllRequest(jsonData);
	    },
	    onChartClick: function onChartClick(param, echart) {
	        var setBarName = this.props.setBarName;

	        var jsonData = { statusName: param.name };
	        setBarName(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.classificationRequest, this.props.classificationResult);
	        if (!isEqual) {
	            var classificationRequest = nextProps.classificationRequest;
	            var classificationResult = nextProps.classificationResult;


	            if (classificationRequest == true) {
	                if (classificationResult.success) {

	                    var _yAxis = [],
	                        _series = [];
	                    for (var i = 0; i < classificationResult.content.length; i++) {
	                        for (var item in classificationResult.content[i]) {
	                            _yAxis.push(item);
	                            _series.push(classificationResult.content[i][item]);
	                        }
	                    }
	                    var setParm = {
	                        color: ["#e14340"],
	                        "barWidth": 30,
	                        legendRight: "20",
	                        xAxisLine: true,
	                        xAxisLabel: true,
	                        titleName: "",
	                        legend: [""],
	                        label: {
	                            normal: {
	                                show: true,
	                                position: 'right',
	                                textStyle: {
	                                    color: "#fff",
	                                    fontSize: 12,
	                                    fontWeight: "normal",
	                                    fontFamily: 'Microsoft Yahei'
	                                }
	                            }
	                        },
	                        gridRight: "10%",
	                        gridLeft: "5%",
	                        gridBottom: "5%",
	                        gridTop: "5%",
	                        xAxisName: "企业数",
	                        yAxis: _yAxis,
	                        series: [_series]
	                    };
	                    this.setState({ option: setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        var onEvents = {
	            'click': this.onChartClick
	        };
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_HorizontalBarChart2.default, { onEvents: onEvents, option: this.state.option, style: { height: '530px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-top' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '交易场所清理整顿分类'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = Classification;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Classification.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 878:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(875);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var HPQList = _react2.default.createClass({
	    displayName: 'HPQList',

	    getInitialState: function getInitialState() {
	        return {
	            list: [],
	            orderZB: "DESC",
	            areaName: "",
	            orderName: ""
	        };
	    },
	    countyChange: function countyChange(county, listType, orderType) {
	        var getHPQListRequest = this.props.getHPQListRequest;

	        var jsonData = {
	            areaName: county, //地区
	            orderName: listType, //列表排序
	            orderType: orderType //desc  //asc
	        };
	        getHPQListRequest(jsonData);
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ areaName: "" });
	        this.setState({ orderZB: "DESC" });
	        this.countyChange(this.state.areaName, "", this.state.orderZB);
	    },
	    handleClick: function handleClick(name) {
	        var _dom = $(this.refs[name]);
	        var _domAttr = _dom.attr("data-order");
	        if (_domAttr == "DESC") {
	            _dom.attr("data-order", "ASC");
	        } else {
	            _dom.attr("data-order", "DESC");
	        }
	        var _getAttr = _dom.attr("data-order");
	        this.setState({ orderName: name });
	        this.countyChange(this.state.areaName, name, _getAttr);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqualCounty = Immutable.is(nextProps.pieCounty.areaName, this.props.pieCounty.areaName);
	        if (!isEqualCounty) {
	            this.setState({ areaName: nextProps.pieCounty.areaName });
	            this.countyChange(nextProps.pieCounty.areaName, "", "");
	        }

	        var isEqual = Immutable.is(nextProps.HPQListRequest, this.props.HPQListResult);
	        if (!isEqual) {
	            var HPQListRequest = nextProps.HPQListRequest;
	            var HPQListResult = nextProps.HPQListResult;


	            if (HPQListRequest == true) {
	                if (HPQListResult.success) {
	                    this.setState({ list: HPQListResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-bottom' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '黄浦区交易场所列表'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '交易所'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { 'data-order': this.state.orderZB, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital"), className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '注册时间',
	                                    _react2.default.createElement('i', { 'data-order': this.state.orderZB, ref: 'registeredDate', onClick: this.handleClick.bind(this, "registeredDate"), className: 'iconfont icon-desc' })
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
	                        { className: 'mt-table mt-table-center wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.list.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _address = item.address == null ? "/" : item.address;
	                                    var _registeredCapital = item.registeredCapital == null ? "/" : item.registeredCapital + "万元";
	                                    var _registeredDate = item.registeredDate == null ? "/" : item.registeredDate;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'HPQList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredCapital
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredDate
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'HPQList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _address },
	                                                    _address
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredCapital
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _registeredDate
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = HPQList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "HPQList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 879:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(875);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DetailList = _react2.default.createClass({
	    displayName: 'DetailList',

	    getInitialState: function getInitialState() {
	        return {
	            statusName: "",
	            listData: []
	        };
	    },
	    countyChange: function countyChange(county) {
	        var getDetailListRequest = this.props.getDetailListRequest;

	        var jsonData = {
	            statusName: county
	        };
	        getDetailListRequest(jsonData);
	    },
	    componentDidMount: function componentDidMount() {
	        this.setState({ statusName: "" });
	        this.countyChange(this.statusName);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	        var isEqualName = Immutable.is(nextProps.barName.statusName, this.props.barName.statusName);
	        if (!isEqualName) {
	            this.setState({ statusName: nextProps.barName.statusName });
	            this.countyChange(nextProps.barName.statusName);
	        }

	        var isEqual = Immutable.is(nextProps.detailListRequest, this.props.detailListResult);
	        if (!isEqual) {
	            var detailListRequest = nextProps.detailListRequest;
	            var detailListResult = nextProps.detailListResult;


	            if (detailListRequest == true) {
	                if (detailListResult.success) {
	                    this.setState({ listData: detailListResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-bottom' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '取得合规意见或经过会商的交易场所详情列表'
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
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '交易所'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '审批部门'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '监管部门'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '法定代表人'
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
	                        { className: 'mt-table mt-table-center wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    var _legaPerson = item.legalPerson == null ? "/" : item.legalPerson;
	                                    var _approveDepartment = item.approveDepartment == null ? "/" : item.approveDepartment;
	                                    var _superviseDepartment = item.superviseDepartment == null ? "/" : item.superviseDepartment;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'DetailList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _approveDepartment
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _superviseDepartment },
	                                                    _superviseDepartment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _legaPerson
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'DetailList', company: item.name } }, className: 'word-limit-5', 'data-tip': item.name },
	                                                    item.name
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '25%' },
	                                                _approveDepartment
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'word-limit-5', 'data-tip': _superviseDepartment },
	                                                    _superviseDepartment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                _legaPerson
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = DetailList;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "DetailList.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 884:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getLeasenumRequest = getLeasenumRequest;
	exports.getContrastLeftnumRequest = getContrastLeftnumRequest;
	exports.getContrastRightnumRequest = getContrastRightnumRequest;
	exports.getContrastCatalognumRequest = getContrastCatalognumRequest;
	/*
	  融资租赁action
	*/

	/*典当法人企业数begin*/
	var COMPANY_LEASE_SUCCESS = exports.COMPANY_LEASE_SUCCESS = 'COMPANY_LEASE_SUCCESS';
	var COMPANY_LEASE_FAIL = exports.COMPANY_LEASE_FAIL = 'COMPANY_LEASE_FAIL';

	function companyLeaseSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_LEASE_SUCCESS,
	    result: result
	  };
	}
	function companyLeaseFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_LEASE_FAIL,
	    result: result
	  };
	}

	function getLeasenumRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "financeLease/leaseCompanyStatistic.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyLeaseSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyLeaseFail(result));
	      }
	    });
	  };
	}
	/*典当法人企业数end*/

	/*对比左图begin*/
	var COMPANY_CONTRASTLEFT_SUCCESS = exports.COMPANY_CONTRASTLEFT_SUCCESS = 'COMPANY_CONTRASTLEFT_SUCCESS';
	var COMPANY_CONTRASTLEFT_FAIL = exports.COMPANY_CONTRASTLEFT_FAIL = 'COMPANY_CONTRASTLEFT_FAIL';

	function companyContrastLeftSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_CONTRASTLEFT_SUCCESS,
	    result: result
	  };
	}
	function companyContrastLeftFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_CONTRASTLEFT_FAIL,
	    result: result
	  };
	}

	function getContrastLeftnumRequest(json) {
	  return function (dispatch) {
	    //console.log("jifgei",json)
	    $.ajax({
	      url: "financeLease/leaseCompanyCategory.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyContrastLeftSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyContrastLeftFail(result));
	      }
	    });
	  };
	}
	/*对比end*/

	/*对比右图begin*/
	var COMPANY_CONTRASTRIGHT_SUCCESS = exports.COMPANY_CONTRASTRIGHT_SUCCESS = 'COMPANY_CONTRASTRIGHT_SUCCESS';
	var COMPANY_CONTRASTRIGHT_FAIL = exports.COMPANY_CONTRASTRIGHT_FAIL = 'COMPANY_CONTRASTRIGHT_FAIL';

	function companyContrastRightSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_CONTRASTRIGHT_SUCCESS,
	    result: result
	  };
	}
	function companyContrastRightFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_CONTRASTRIGHT_FAIL,
	    result: result
	  };
	}

	function getContrastRightnumRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "financeLease/leaseCompanyCategory.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyContrastRightSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyContrastRightFail(result));
	      }
	    });
	  };
	}
	/*对比end*/

	/*列表begin*/
	var COMPANY_CATALOG_SUCCESS = exports.COMPANY_CATALOG_SUCCESS = 'COMPANY_CATALOG_SUCCESS';
	var COMPANY_CATALOG_FAIL = exports.COMPANY_CATALOG_FAIL = 'COMPANY_CATALOG_FAIL';

	function companyContrastCatalogSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANY_CATALOG_SUCCESS,
	    result: result
	  };
	}
	function companyContrastCatalogFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANY_CATALOG_FAIL,
	    result: result
	  };
	}

	function getContrastCatalognumRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "financeLease/leaseCompanyList.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyContrastCatalogSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyContrastCatalogFail(result));
	      }
	    });
	  };
	}
	/*列表end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "financeLeaseAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 885:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(886);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(802);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市典当法人企业数
	var Immutable = __webpack_require__(718);
	var Lease = _react2.default.createClass({
	    displayName: 'Lease',

	    getInitialState: function getInitialState() {
	        return {
	            paramLease: null,
	            LeaseData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getLeasenumRequest = this.props.getLeasenumRequest;

	        var jsonData = {};
	        getLeasenumRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.LeaseNumChartRequest, this.props.LeaseNumChartResult);
	        if (!isEqual) {
	            var LeaseNumChartRequest = nextProps.LeaseNumChartRequest;
	            var LeaseNumChartResult = nextProps.LeaseNumChartResult;

	            if (LeaseNumChartRequest == true) {
	                if (LeaseNumChartResult.success) {
	                    var options = {
	                        "titleShow": true,
	                        "color": ["#e24441", "#12b5b0", "#fec252"],
	                        "legend": ["企业数量", "注册资本总额(人民币)", "注册资本注册资本总额(美元)"],
	                        "legendShow": true,
	                        "legendRight": "25%",
	                        "legendTop": "1",
	                        "legendWidth": 600,
	                        "barName": ["注册资本总额(人民币)", "注册资本注册资本总额(美元)"],
	                        "lineName": ["企业数量"],
	                        // "YnameRoutate":0,
	                        // "YnameLocation":"top",
	                        "gridLeft": "2%",
	                        "gridRight": "2%",
	                        "gridBottom": "20%",
	                        "yAxisName": ["亿人民币元", "亿美元"],
	                        "yFlag": "",
	                        "xAxis": LeaseNumChartResult.content.xAxis,
	                        "barWidth": 30,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": LeaseNumChartResult.content.series.bar,
	                            "line": [LeaseNumChartResult.content.series.line]
	                        }
	                    };
	                    this.setState({ paramLease: options });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    render: function render() {
	        var LeaseAmountBox = "";
	        if (this.state.paramLease) {
	            LeaseAmountBox = _react2.default.createElement(_LineBarChart2.default, {
	                param: this.state.paramLease,
	                style: { height: '550px', width: '100%', margin: '0px auto' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'Lease mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市典当法人企业数'
	                )
	            ),
	            LeaseAmountBox
	        );
	    }
	});
	module.exports = Lease;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Lease.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 889:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(886);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市自贸区融资租赁企业占比对比
	var Immutable = __webpack_require__(718);
	var ContrastLeft = _react2.default.createClass({
	    displayName: 'ContrastLeft',

	    getInitialState: function getInitialState() {
	        return {
	            paramContrastLeft: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getContrastLeftnumRequest = this.props.getContrastLeftnumRequest;

	        var jsonData = { 'year': 2013 };
	        getContrastLeftnumRequest(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.ContrastLeftNumChartRequest, this.props.ContrastLeftNumChartResult);
	        if (!isEqual) {
	            var ContrastLeftNumChartRequest = nextProps.ContrastLeftNumChartRequest;
	            var ContrastLeftNumChartResult = nextProps.ContrastLeftNumChartResult;

	            if (ContrastLeftNumChartRequest == true) {
	                if (ContrastLeftNumChartResult.success) {
	                    var optionThe = {
	                        "color": ["#facd89", "#e14340"],
	                        //"title":"私募基金总分类",
	                        "xtitle": "",
	                        "titleLeft": "19%",
	                        "titleTop": "60%",
	                        //"legend": ["自贸区", "非自贸区"],
	                        "legendShow": true,
	                        // "roseType":"radius",//是否玫瑰型
	                        "radius": [80, 110],
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "",
	                        "lable": { normal: { show: true },
	                            emphasis: { show: false }
	                        },
	                        "center": ['50%', '46%'],
	                        "series": [{ value: ContrastLeftNumChartResult.content.outRate, value: ContrastLeftNumChartResult.content.inAreaNumber, name: '自贸区' }, { value: ContrastLeftNumChartResult.content.inRate, value: ContrastLeftNumChartResult.content.outAreaNumber, name: '非自贸区' }]
	                    };
	                    this.setState({ paramContrastLeft: optionThe });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    selectValue: function selectValue(data) {
	        var yearData = { 'year': data };
	        var getContrastLeftnumRequest = this.props.getContrastLeftnumRequest;

	        getContrastLeftnumRequest(yearData);
	    },

	    render: function render() {
	        //下拉选择         
	        var selectProp = {
	            width: '95px',
	            className: 'index-selected',
	            value: 2013,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: 2013, label: '2013年' }, { value: 2014, label: '2014年' }, { value: 2015, label: '2015年' }, { value: 2016, label: '2016年' }, { value: 2017, label: '2017年' }, { value: 2018, label: '2018年' }],
	            onChange: function (value) {
	                // console.log('当前值为：', value);
	                this.selectValue(value);
	            }.bind(this)
	        };

	        var ContrastLeftAmountBox = "";
	        if (this.state.paramContrastLeft) {
	            ContrastLeftAmountBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.paramContrastLeft,
	                style: { height: '550px', width: '100%', margin: '0px auto' } });
	        }

	        return _react2.default.createElement(
	            'div',
	            { className: 'ContrastLeft mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市自贸区融资租赁企业占比对比'
	                )
	            ),
	            ContrastLeftAmountBox,
	            _react2.default.createElement(
	                'div',
	                { className: 'select' },
	                _react2.default.createElement(_index.Selected, selectProp)
	            )
	        );
	    }
	});
	module.exports = ContrastLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContrastLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 890:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(886);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(758);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市自贸区融资租赁企业占比对比
	var Immutable = __webpack_require__(718);
	var ContrastRight = _react2.default.createClass({
	    displayName: 'ContrastRight',

	    getInitialState: function getInitialState() {
	        return {
	            paramContrastRight: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getContrastRightnumRequest = this.props.getContrastRightnumRequest;

	        var jsonData = { 'year': 2015 };
	        getContrastRightnumRequest(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.ContrastRightNumChartRequest, this.props.ContrastRightNumChartResult);
	        if (!isEqual) {
	            var ContrastRightNumChartRequest = nextProps.ContrastRightNumChartRequest;
	            var ContrastRightNumChartResult = nextProps.ContrastRightNumChartResult;

	            if (ContrastRightNumChartRequest == true) {
	                if (ContrastRightNumChartResult.success) {
	                    var optionThes = {
	                        "color": ["#facd89", "#e14340"],
	                        //"title":"私募基金总分类",
	                        "xtitle": "",
	                        "titleLeft": "19%",
	                        "titleTop": "60%",
	                        //"legend": ["自贸区", "非自贸区"],
	                        "legendShow": true,
	                        // "roseType":"radius",//是否玫瑰型
	                        "radius": [80, 110],
	                        "legendOrient": "horizontal",
	                        "legendLeft": "20%",
	                        "legendTop": "65%",
	                        "seriesName": "",
	                        "lable": { normal: { show: true },
	                            emphasis: { show: false }
	                        },
	                        "center": ['55%', '54%'],
	                        "series": [{ value: ContrastRightNumChartResult.content.outRate, value: ContrastRightNumChartResult.content.inAreaNumber, name: '自贸区' }, { value: ContrastRightNumChartResult.content.inRate, value: ContrastRightNumChartResult.content.outAreaNumber, name: '非自贸区' }]
	                    };
	                    this.setState({ paramContrastRight: optionThes });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    selectValue: function selectValue(data) {
	        var yearData = { 'year': data };
	        var getContrastRightnumRequest = this.props.getContrastRightnumRequest;

	        getContrastRightnumRequest(yearData);
	    },

	    render: function render() {
	        //下拉选择         
	        var selectProp = {
	            width: '95px',
	            className: 'index-selected',
	            value: 2015,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: 2013, label: '2013年' }, { value: 2014, label: '2014年' }, { value: 2015, label: '2015年' }, { value: 2016, label: '2016年' }, { value: 2017, label: '2017年' }, { value: 2018, label: '2018年' }],
	            onChange: function (value) {
	                //console.log('当前值为：', value);           
	                this.selectValue(value);
	            }.bind(this)
	        };

	        var ContrastRightAmountBox = "";
	        if (this.state.paramContrastRight) {
	            ContrastRightAmountBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.paramContrastRight,
	                style: { height: '550px', width: '100%', margin: '0px auto' } });
	        }

	        return _react2.default.createElement(
	            'div',
	            { className: 'ContrastRight ContrastLeft' },
	            ContrastRightAmountBox,
	            _react2.default.createElement(
	                'div',
	                { className: 'select' },
	                _react2.default.createElement(_index.Selected, selectProp)
	            )
	        );
	    }
	});
	module.exports = ContrastRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContrastRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 892:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(886);

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
	            selected: 1,
	            CatalogDirectoryData: []
	        };
	    },

	    componentDidMount: function componentDidMount() {
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        var jsonData = { 'areaName': '黄浦区' };
	        getContrastCatalognumRequest(jsonData);
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        console.log("222222222", nextProps);
	        var isEqual = Immutable.is(nextProps.ContrastCatalogNumChartRequest, this.props.ContrastCatalogNumChartResult);
	        if (!isEqual) {
	            var ContrastCatalogNumChartRequest = nextProps.ContrastCatalogNumChartRequest;
	            var ContrastCatalogNumChartResult = nextProps.ContrastCatalogNumChartResult;

	            if (ContrastCatalogNumChartRequest == true) {
	                if (ContrastCatalogNumChartResult.success) {
	                    // $(this.refs.totleCount).html(ContrastCatalogNumChartResult.content.length)
	                    //this.dataFomat({CatalogCentent:ContrastCatalogNumChartResult})
	                    //this.dataFomat(ContrastCatalogNumChartResult);
	                    //风险状态
	                    for (var i = 0; i < ContrastCatalogNumChartResult.content.length; i++) {
	                        if (ContrastCatalogNumChartResult.content[i].status == "正常") innerdata.push(ContrastCatalogNumChartResult.content[i]);else outerdata.push(ContrastCatalogNumChartResult.content[i]);
	                    }
	                    this.setState({
	                        CompanyDirectoryData: ContrastCatalogNumChartResult.content,
	                        CatalogCentent: ContrastCatalogNumChartResult.content
	                    });
	                    //失联
	                    for (var i = 0; i < ContrastCatalogNumChartResult.content.length; i++) {
	                        if (ContrastCatalogNumChartResult.content[i].riskA == "是") innerdata.push(ContrastCatalogNumChartResult.content[i]);else outerdata.push(ContrastCatalogNumChartResult.content[i]);
	                    }
	                    this.setState({
	                        CatalogDirectoryData: ContrastCatalogNumChartResult.content,
	                        CatalogCentent: ContrastCatalogNumChartResult.content
	                    });
	                    //未参加自查
	                    for (var i = 0; i < ContrastCatalogNumChartResult.content.length; i++) {
	                        if (ContrastCatalogNumChartResult.content[i].riskB == "是") innerdata.push(ContrastCatalogNumChartResult.content[i]);else outerdata.push(ContrastCatalogNumChartResult.content[i]);
	                    }
	                    this.setState({
	                        CatalogDirectoryData: ContrastCatalogNumChartResult.content,
	                        CatalogCentent: ContrastCatalogNumChartResult.content
	                    });
	                    //一年以上零认缴
	                    for (var i = 0; i < ContrastCatalogNumChartResult.content.length; i++) {
	                        if (ContrastCatalogNumChartResult.content[i].riskC == "是") innerdata.push(ContrastCatalogNumChartResult.content[i]);else outerdata.push(ContrastCatalogNumChartResult.content[i]);
	                    }
	                    this.setState({
	                        CatalogDirectoryData: ContrastCatalogNumChartResult.content,
	                        CatalogCentent: ContrastCatalogNumChartResult.content
	                    });
	                    //一年以上未经营
	                    for (var i = 0; i < ContrastCatalogNumChartResult.content.length; i++) {
	                        if (ContrastCatalogNumChartResult.content[i].riskD == "是") innerdata.push(ContrastCatalogNumChartResult.content[i]);else outerdata.push(ContrastCatalogNumChartResult.content[i]);
	                    }
	                    this.setState({
	                        CatalogDirectoryData: ContrastCatalogNumChartResult.content,
	                        CatalogCentent: ContrastCatalogNumChartResult.content
	                    });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    // dataFomat:function(data){
	    //     var content=data.content;
	    //     this.setState({CatalogCentent:content});
	    // },

	    quarterChoice: function quarterChoice(value) {
	        var CompanyDirectoryDatas = this.state.CompanyDirectoryData;
	        switch (value) {
	            case 2:
	                //正常
	                this.setState({
	                    CatalogCentent: innerdata
	                });
	                break;
	            case 3:
	                //潜在
	                this.setState({
	                    CatalogCentent: outerdata
	                });
	                break;
	            default:
	                this.setState({
	                    CatalogCentent: CompanyDirectoryDatas
	                });
	                break;
	        }
	    },

	    CatalogChoice: function CatalogChoice(value) {
	        var CatalogDirectoryDatas = this.state.CatalogDirectoryData;
	        switch (value) {
	            case 1:
	                //全部
	                this.setState({
	                    CatalogCentent: innerdata
	                });
	                break;
	            case 2:
	                //是
	                this.setState({
	                    CatalogCentent: outerdata
	                });
	                break;
	            default:
	                this.setState({
	                    CatalogCentent: CatalogDirectoryDatas
	                });
	                break;
	        }
	    },

	    //地区
	    selectDataVal: function selectDataVal(data) {
	        var areaNameData = { 'areaName': data };
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        getContrastCatalognumRequest(areaNameData);
	    },
	    render: function render() {
	        //下拉选择表头         
	        var selectProp = {
	            width: '110px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: 1, label: '黄埔区' }],
	            onChange: function (value) {
	                this.selectDataVal(value);
	            }.bind(this)
	        };
	        //下拉选择风险状态
	        var selectPropL = {
	            width: '55px',
	            className: 'index-selected',
	            value: "1",
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '正常' }, { value: '3', label: '潜在' }],
	            onChange: function (value, label) {
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        //下拉选择全部
	        var selectProps = {
	            width: '55px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '高级选项',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '是' }],
	            onChange: function (value, label) {
	                this.CatalogChoice(value);
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
	                    _react2.default.createElement(_index.Selected, selectProp)
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
	                                _react2.default.createElement(_index.Selected, selectPropL)
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
	                                _react2.default.createElement(_index.Selected, selectProps)
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '未参加自查',
	                                _react2.default.createElement(_index.Selected, selectProps)
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上零认缴',
	                                _react2.default.createElement(_index.Selected, selectProps)
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上未经营',
	                                _react2.default.createElement(_index.Selected, selectProps)
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.CatalogCentent.map(function (item, index) {
	                                var Green = '';
	                                item.status == "正常" ? Green = 'Green' : Green = 'Yellow';
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
	                                                    { className: 'leftD' },
	                                                    item.company
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.status
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskD
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
	                                                    { className: 'leftD' },
	                                                    item.company
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'Yellow' },
	                                                item.status
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            item.riskD
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

/***/ 896:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getCompanynumRequest = getCompanynumRequest;
	exports.getBusinessnumRequest = getBusinessnumRequest;
	exports.getBalanceRequest = getBalanceRequest;
	exports.getCompanyDirectoryRequest = getCompanyDirectoryRequest;
	/*
	 商业保理平台监测
	*/

	/*在沪商业保理企业数量图表begin*/
	var COMMERCIAL_COMPANYNUM_SUCCESS = exports.COMMERCIAL_COMPANYNUM_SUCCESS = 'COMMERCIAL_COMPANYNUM_SUCCESS';
	var COMMERCIAL_COMPANYNUM_FAIL = exports.COMMERCIAL_COMPANYNUM_FAIL = 'COMMERCIAL_COMPANYNUM_FAIL';

	function companynumRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_COMPANYNUM_SUCCESS,
	    result: result
	  };
	}
	function companynumRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_COMPANYNUM_FAIL,
	    result: result
	  };
	}

	function getCompanynumRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/factoring/countCapitalBySeason.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companynumRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companynumRequestFail(result));
	      }
	    });
	  };
	}
	/*在沪商业保理企业数量图表end*/

	/*  企业类型分布图表begin*/
	var COMMERCIAL_BUSINESSNUM_SUCCESS = exports.COMMERCIAL_BUSINESSNUM_SUCCESS = 'COMMERCIAL_BUSINESSNUM_SUCCESS';
	var COMMERCIAL_BUSINESSNUM_FAIL = exports.COMMERCIAL_BUSINESSNUM_FAIL = 'COMMERCIAL_BUSINESSNUM_FAIL';

	function businessnumRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_BUSINESSNUM_SUCCESS,
	    result: result
	  };
	}
	function businessnumRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_BUSINESSNUM_FAIL,
	    result: result
	  };
	}

	function getBusinessnumRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/factoring/distribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(businessnumRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(businessnumRequestFail(result));
	      }
	    });
	  };
	}
	/* 企业类型分布图表end */

	/* 商业保理地域分布图表begin */
	var COMMERCIAL_BALANCE_SUCCESS = exports.COMMERCIAL_BALANCE_SUCCESS = 'COMMERCIAL_BALANCE_SUCCESS';
	var COMMERCIAL_BALANCE_FAIL = exports.COMMERCIAL_BALANCE_FAIL = 'COMMERCIAL_BALANCE_FAIL';

	function balanceRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_BALANCE_SUCCESS,
	    result: result
	  };
	}
	function balanceRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_BALANCE_FAIL,
	    result: result
	  };
	}

	function getBalanceRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/factoring/geogDistribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(balanceRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(balanceRequestFail(result));
	      }
	    });
	  };
	}
	/*商业保理地域分布图表end */

	/* 商业保理企业名单begin */
	var COMMERCIAL_COMPANYDIRECTORY_SUCCESS = exports.COMMERCIAL_COMPANYDIRECTORY_SUCCESS = 'COMMERCIAL_COMPANYDIRECTORY_SUCCESS';
	var COMMERCIAL_COMPANYDIRECTORY_FAIL = exports.COMMERCIAL_COMPANYDIRECTORY_FAIL = 'COMMERCIAL_COMPANYDIRECTORY_FAIL';

	function CompanyDirectoryRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMMERCIAL_COMPANYDIRECTORY_SUCCESS,
	    result: result
	  };
	}
	function CompanyDirectoryRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMMERCIAL_COMPANYDIRECTORY_FAIL,
	    result: result
	  };
	}

	function getCompanyDirectoryRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/factoring/queryCompanys.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(CompanyDirectoryRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(CompanyDirectoryRequestFail(result));
	      }
	    });
	  };
	}
	/*商业保理企业名单end */

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "commercialSecretIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 932:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(933);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(722);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _InfoSearchAction = __webpack_require__(1350);

	var infoSearchActionCreaters = _interopRequireWildcard(_InfoSearchAction);

	var _Search = __webpack_require__(935);

	var _Search2 = _interopRequireDefault(_Search);

	var _SearchList = __webpack_require__(938);

	var _SearchList2 = _interopRequireDefault(_SearchList);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//企业全息信息查询平台首页

	//子模块引入
	var Immutable = __webpack_require__(718);
	var InfoSearchIndex = _react2.default.createClass({
	  displayName: 'InfoSearchIndex',

	  //mixins: [setHeight],
	  render: function render() {

	    return _react2.default.createElement(
	      'div',
	      { className: 'info-search-index' },
	      _react2.default.createElement(_Search2.default, this.props),
	      _react2.default.createElement(_SearchList2.default, this.props)
	    );
	  }
	});
	//module.exports = InfoSearchIndex;

	//将 request  result 绑定到props的request result
	function searchDataStateToProps(state) {
	  return {

	    searchDataRequest: state.infoSearch.request,
	    searchDataResult: state.infoSearch.result

	  };
	}

	//将action的所有方法绑定到props上
	function searchDataDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(infoSearchActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(searchDataStateToProps, searchDataDispatchToProps)(InfoSearchIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	var Search = _react2.default.createClass({
	  displayName: 'Search',
	  componentDidMount: function componentDidMount() {},

	  clickSearch: function clickSearch() {
	    if (this.refs.inp.value) {
	      var getSearchDataRequest = this.props.getSearchDataRequest;

	      var companyData = {
	        "company": this.refs.inp.value,
	        "page_no": 1,
	        "page_size": 4
	      };
	      getSearchDataRequest(companyData);
	      // $("#show").show()
	    }
	  },
	  keySearch: function keySearch(event) {
	    if (event.which == "13") this.clickSearch();
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Search' },
	      _react2.default.createElement(
	        'div',
	        { className: 'SearchBox' },
	        _react2.default.createElement(
	          'h1',
	          null,
	          '企业全息信息查询平台'
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'SearchInp' },
	          _react2.default.createElement('input', { placeholder: '', type: 'text', ref: 'inp', id: 'inp', onKeyUp: this.keySearch }),
	          _react2.default.createElement(
	            'a',
	            { id: 'href', href: 'javascript:void(0);', onClick: this.clickSearch },
	            _react2.default.createElement('i', { className: 'iconfont icon-search' })
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = Search;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Search.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 937:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*@parkMonitor jifei  搜索框\r\n---------------------------------------------------------*/\r\n.Search{\r\n\twidth: 100%;\r\n\theight: 285px;\r\n\tborder: 1px solid transparent;\r\n}\r\n.SearchBox{\r\n\twidth: 800px;\r\n\theight: 110px;\r\n\tmargin: 85px auto;\r\n}\r\n.SearchBox h1{\r\n\ttext-align: center;\r\n}\r\n.SearchInp{\r\n\twidth: 800px;\r\n\theight: 50px;\r\n\tmargin-top: 32px;\r\n\tposition: relative;\r\n}\r\n.SearchInp input{\r\n\twidth: 800px;\r\n\theight: 50px;\r\n\tborder: none;\r\n\tpadding: 10px;\r\n\tcolor: #626262;\r\n}\r\n.SearchInp a .icon-search{\r\n    position: absolute;\r\n    right: 0;\r\n    top: 6px;\r\n    font-size: 36px;\r\n    color: #e14340;\r\n}\r\n/*@parkMonitor jifei  搜索列表\r\n---------------------------------------------------------*/\r\n.SearchList{\r\n\twidth: 85%;\r\n\theight: 620px;\r\n\tmargin: 0 auto;\r\n}\r\n.SearchList .ulBox{\r\n\twidth: 100%;\r\n\theight: 620px;\t\r\n}\r\n.SearchList .ulBox .liList{\r\n\twidth: 100%;\r\n\theight: 130px;\r\n}\r\n.SearchList .ulBox .liList ul{\r\n    margin: 0 80px;\r\n}\r\n.SearchList .ulBox .liList:nth-child(even){\r\n\tbackground: #2b323c;\r\n\tborder-bottom: 1px solid #3a414b;\r\n\tborder-top: 1px solid #3a414b;\r\n}\r\n.SearchList .ulBox .liList ul h2{\r\n\tpadding-bottom: 25px;\r\n\tpadding-top: 15px;\r\n\tcolor: #07b5e7;\r\n\tfont-weight: bold;\r\n}\r\n.SearchList .ulBox .liList ul li{\r\n\twidth: 33%;\r\n\theight: 25px;\r\n\tdisplay: inline-block;\r\n\t//line-height: 25px;\r\n\tfont-size: 12px;\r\n\tcolor: #d7dbde;\r\n\tvertical-align: top;\r\n}\r\n/*@parkMonitor jifei  分页\r\n---------------------------------------------------------*/\r\n.SearchList .page{\r\n\twidth: 100%;\r\n\theight: 50px;\r\n\tmargin-top: 20px;\r\n}\r\n.SearchList .page .total{\r\n\tline-height: 50px;\r\n\tfont-size: 14px;\r\n\tcolor: #d7dbde;\r\n}\r\n.SearchList .page .total em{\r\n\tcolor: #e43e62;\r\n}\r\n.SearchList .page .mt-pagelist .mt-pagelist-left{\r\n\tdisplay: none;\r\n}\r\n.SearchList .page .mt-pagelist .mt-pagelist-right{\r\n\tmargin-top: -50px;\r\n}\r\n.SearchList .page .mt-pagelist .mt-pagelist-prev, \r\n.mt-pagelist .mt-pagelist-next, .mt-pagelist\r\n.mt-pagelist-btn, .mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-first{\r\n    background: #37414d !important;\r\n}\r\n.SearchList .page  .mt-pagelist .mt-pagelist-page li{\r\n\tbackground: #37414d !important;\r\n\theight: 26px;\r\n}\r\n.SearchList .page  .mt-pagelist .mt-pagelist-input .mt-input{\r\n\tbackground: #37414d !important;\r\n}\r\n.noResult{\r\n\ttext-align: center;\r\n}", ""]);

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
	      nowpage: 1
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
	    this.setState({ nowpage: nowpage });
	    var searchName = "";
	    $("#inp").val() ? searchName = $("#inp").val() : searchName = this.props.location.query.searchInfo;
	    var jsonData = {
	      "company": searchName,
	      "page_no": nowpage,
	      "page_size": 4
	    };
	    if ($("#inp").val() || this.props.location.query.searchInfo) this.getLargeLoan(jsonData);
	  },
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      var jsonData = {
	        "company": this.props.location.query.searchInfo,
	        "page_no": 1,
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
	        '家企业'
	      );
	    }
	    if (this.state.DataList) {
	      return _react2.default.createElement(
	        'div',
	        { className: 'SearchList' },
	        _react2.default.createElement(
	          'ul',
	          { className: 'ulBox', id: 'show' },
	          this.state.DataList.map(function (ele, index) {
	            return _react2.default.createElement(
	              'li',
	              { className: 'liList', key: index },
	              _react2.default.createElement(
	                'ul',
	                null,
	                _react2.default.createElement(
	                  _reactRouter.Link,
	                  { to: '/SearchResultDetail' },
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
	                  '注册资本：500亿'
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '成立日期：2015年06月21日'
	                ),
	                _react2.default.createElement(
	                  'li',
	                  null,
	                  '注册地址：上海浦东上海浦东上海浦东上海浦东上海浦东上海浦东上海浦东'
	                )
	              )
	            );
	          }),
	          _react2.default.createElement(
	            'div',
	            { className: 'page' },
	            textBox,
	            _react2.default.createElement(_index.PageList, { id: 'pageList1', count: this.state.count, showPage: '7', callback: this.setCallBack })
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

/***/ 974:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _companyInfoTitRuducer = __webpack_require__(1344);

	var _companyInfoTitRuducer2 = _interopRequireDefault(_companyInfoTitRuducer);

	var _companyInfoNewsRuducer = __webpack_require__(1346);

	var _companyInfoNewsRuducer2 = _interopRequireDefault(_companyInfoNewsRuducer);

	var _companyInfoARuducer = __webpack_require__(1347);

	var _companyInfoARuducer2 = _interopRequireDefault(_companyInfoARuducer);

	var _companyInfoBRuducer = __webpack_require__(1348);

	var _companyInfoBRuducer2 = _interopRequireDefault(_companyInfoBRuducer);

	var _Common = __webpack_require__(1351);

	var _Common2 = _interopRequireDefault(_Common);

	var _SmallLoanMap = __webpack_require__(975);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(976);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(977);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(978);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(979);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(980);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(981);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(982);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(983);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(984);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(985);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(986);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(987);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(988);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(989);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(990);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(991);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(992);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(993);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(994);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(995);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(996);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(997);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyProgress = __webpack_require__(998);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(999);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1000);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1001);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1002);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1003);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1004);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1005);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1006);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1007);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1008);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1009);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1010);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1011);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1012);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1013);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1014);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1015);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1016);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1017);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1018);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1019);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1020);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1021);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1022);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _realtimeTableRuducer = __webpack_require__(1023);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1024);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1025);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1026);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1027);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _MenuParkSelectVal = __webpack_require__(1028);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1029);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1030);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1031);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1032);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1033);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ChartAll3 = __webpack_require__(1034);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1035);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1036);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1037);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1038);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1039);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1040);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1041);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1042);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1343);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1352);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1353);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1354);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _industryTypeChart = __webpack_require__(1043);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1044);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1355);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1356);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/

	/*线下理财监测 end*/

	/*预付卡 begin*/

	//企业占比对比

	//企业目录列表

	/*实时监测 begin*/

	/*=================================交易场所监测=================================*/

	/*=================================融资租赁=================================*/
	//典当法人企业数

	//交易场所清理整顿分类

	/*=================================典当行业监测=================================*/

	/*=================================交易场所监测=================================*/
	//黄浦区交易场所列表

	/*=================================众筹监测=================================*/

	/*=================================典当行业监测=================================*/
	//所有图标

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	//私募股权基本情况

	//私募证券基本情况

	//QFLP试点企业最新进展

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名

	//小额贷款
	var rootReducer = (0, _redux.combineReducers)({

	  /*企业全息*/
	  CompanyInfoTit: _companyInfoTitRuducer2.default,
	  CompanyInfoNews: _companyInfoNewsRuducer2.default,
	  CompanyInfoA: _companyInfoARuducer2.default,
	  CompanyInfoB: _companyInfoBRuducer2.default,

	  /*搜索部分*/
	  Common: _Common2.default,
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

	  //典当行业监测
	  PawnMChartAll: _ChartAll2.default,
	  CompanyDirectory: _CompanyDirectory2.default,

	  //私募基金
	  CompanyProgress: _CompanyProgress2.default,
	  QDLPQuality: _QDLPQuality2.default,
	  FundClass: _FundClass2.default,
	  FundCase: _FundCase2.default, FundCaseTop: _FundCaseTop2.default,
	  EquityL: _EquityL2.default,
	  EquityM: _EquityM2.default,
	  EquityR: _EquityR2.default,

	  //交易场所监测
	  HPQList: _HPQList2.default,
	  RegionalDis: _RegionalDis2.default,
	  Classification: _Classification2.default,
	  DetailList: _DetailList2.default,
	  PieCounty: _PieCounty2.default,
	  BarName: _BarName2.default,

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //园区
	  MenuParkSelectVal: _MenuParkSelectVal2.default,
	  MenuParkSelectList: _MenuParkSelectList2.default,

	  //园区首页
	  ParkCamp: _ParkCamp2.default,
	  ParkFinance: _ParkFinance2.default,
	  ParkIndustry: _ParkIndustry2.default,
	  ParkNews: _ParkNews2.default,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,
	  RealTimeNews: _realtimeNewsReducer2.default,
	  RealTimeMap: _realtimeMapReducer2.default,
	  RealTimeMapSh: _realtimeMapShReducer2.default,

	  //商业保理监测
	  ChartAll: _ChartAll4.default,
	  businessnumChart: _businessnumChart2.default,
	  balanceChart: _balanceChart2.default,
	  CompanyDirectoryChart: _CompanyDirectoryChart2.default,

	  //预付卡
	  industryTypeChart: _industryTypeChart2.default,
	  TotleMoney: _TotleMoney2.default,

	  //融资租赁
	  Lease: _Lease2.default,
	  ContrastLeft: _ContrastLeft2.default,
	  ContrastRight: _ContrastRight2.default,
	  Catalog: _Catalog2.default,

	  //线下理财
	  //线下理财首页
	  LineFinanceRiskDistri: _LineFinanceRiskDistri2.default,
	  LineFinanceList: _LineFinanceList2.default,
	  CheckVal: _CheckVal2.default,

	  DynamicPic: _DynamicPic2.default,
	  SearchResult: _SearchResultList2.default,
	  StaticRisk: _StaticRisk2.default,
	  Statistics: _Statistics2.default,
	  RiskData: _RiskData2.default,
	  CompanyNews: _CompanyNews2.default,

	  //首页
	  homeThree: _homeThree2.default,

	  //企业全息信息查询平台
	  infoSearch: _infoSearch2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*首页 end*/

	/*企业全息信息查询平台 begin*/

	/*商业保理监测 end*/

	/*线下理财监测 start*/
	//线下理财首页


	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//园区首页

	/*实时监测 end*/

	//园区

	//取得合规意见或经过会商的交易场所详情列表

	//交易场所清理整顿分类

	//上海市典当企业目录

	//列表

	//6月上海各类众筹平台新增项目数

	/*====================================私募基金===============================*/

	/*=================================众筹监测=================================*/
	//业务类型

	//私募基金分类


	/*====================================p2p画像平台============================*/

	/*====================================私募基金===============================*/
	//QDLP试点企业最新进展

	//动态图谱

	//诉讼信息

	//核心数据

	/*====================================P2P平台监测============================*/

	/*====================================p2p画像平台============================*/
	//基本信息

	//网贷平台数据展示


	//融资担保


	/*企业全息查询*/

	/*行业监测模块*/
	/* 公共搜索 */


	/*企业全息查询*/

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1349:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.gethomethreeRequest = gethomethreeRequest;
	exports.getSearchResult = getSearchResult;
	/* 首页数字滚动 start*/
	var INDEX_HOMETHREE_SUCCESS = exports.INDEX_HOMETHREE_SUCCESS = 'INDEX_HOMETHREE_SUCCESS';
	var INDEX_HOMETHREE_FAIL = exports.INDEX_HOMETHREE_FAIL = 'INDEX_HOMETHREE_FAIL';

	function homethreeRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INDEX_HOMETHREE_SUCCESS,
	    result: result
	  };
	}
	function homethreeRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: INDEX_HOMETHREE_FAIL,
	    result: result
	  };
	}

	function gethomethreeRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/getSysAnalyze.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(homethreeRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(homethreeRequestFail(result));
	      }
	    });
	  };
	}
	/* 首页数字滚动 end*/

	//列表
	var SEARCH_RESULT_SUCCESS = exports.SEARCH_RESULT_SUCCESS = 'SEARCH_RESULT_SUCCESS';
	var SEARCH_RESULT_FAIL = exports.SEARCH_RESULT_FAIL = 'SEARCH_RESULT_FAIL';

	function searchResultSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: SEARCH_RESULT_SUCCESS,
	    result: result
	  };
	}
	function searchResultFail(result) {
	  //请求失败调用方法
	  return {
	    type: SEARCH_RESULT_FAIL,
	    result: result
	  };
	}

	function getSearchResult(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/risk/doSearch.do",
	      dataType: "json",
	      data: json,
	      type: "POST",
	      success: function success(result) {
	        return dispatch(searchResultSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(searchResultFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "IndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1350:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getSearchDataRequest = getSearchDataRequest;


	/* 搜索列表 start*/
	var INFOSEARCH_SUCCESS = exports.INFOSEARCH_SUCCESS = 'INFOSEARCH_SUCCESS';
	var INFOSEARCH_FAIL = exports.INFOSEARCH_FAIL = 'INFOSEARCH_FAIL';

	function infoSearchRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INFOSEARCH_SUCCESS,
	    result: result
	  };
	}
	function infoSearchRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: INFOSEARCH_FAIL,
	    result: result
	  };
	}

	function getSearchDataRequest(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/hologram/search.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(infoSearchRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(infoSearchRequestFail(result));
	      }
	    });
	  };
	}
	/* 搜索列表 end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InfoSearchAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1351:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = searchResult;

	var _IndexAction = __webpack_require__(1349);

	console.log(_IndexAction.SEARCH_RESULT_SUCCESS);
	function searchResult() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _IndexAction.SEARCH_RESULT_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _IndexAction.SEARCH_RESULT_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Common.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1352:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = statistics;

	var _LineFinanceStaticRiskAction = __webpack_require__(760);

	function statistics() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceStaticRiskAction.STATISTICS_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceStaticRiskAction.STATISTICS_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Statistics.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1353:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = riskData;

	var _LineFinanceStaticRiskAction = __webpack_require__(760);

	//关联图谱DynamicPic
	function riskData() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceStaticRiskAction.RISK_DATA_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceStaticRiskAction.RISK_DATA_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RiskData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1354:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = statistics;

	var _LineFinanceStaticRiskAction = __webpack_require__(760);

	function statistics() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? {
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _LineFinanceStaticRiskAction.COMPANY_NEWS_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _LineFinanceStaticRiskAction.COMPANY_NEWS_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyNews.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1355:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = homeThree;

	var _IndexAction = __webpack_require__(1349);

	function homeThree() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _IndexAction.INDEX_HOMETHREE_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _IndexAction.INDEX_HOMETHREE_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "homeThree.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1356:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = SearchData;

	var _InfoSearchAction = __webpack_require__(1350);

	function SearchData() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        request: false,
	        result: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _InfoSearchAction.INFOSEARCH_SUCCESS:
	            //请求成功！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        case _InfoSearchAction.INFOSEARCH_FAIL:
	            //请求失败！
	            return Object.assign({}, state, {
	                request: true,
	                result: action.result
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "infoSearch.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})