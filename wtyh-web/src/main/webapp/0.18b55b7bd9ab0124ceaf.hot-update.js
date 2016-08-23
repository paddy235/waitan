webpackHotUpdate(0,{

/***/ 687:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "* {\r\n\tmargin: 0px;\r\n\tpadding: 0px;\r\n}\r\n\r\nul,\r\nli {\r\n\tlist-style: none;\r\n}\r\n\r\na {\r\n\ttext-decoration: none;\r\n}\r\n\r\nhtml {\r\n\t-webkit-text-size-adjust: none;\r\n}\r\n\r\nbody {\r\n\tbackground-color: #1a2029;\r\n\tcolor: #ffffff;\r\n\tfont-family: 'Microsoft Yahei';\r\n}\r\n\r\n.clear:after {\r\n\tcontent: \".\";\r\n\theight: 0;\r\n\tvisibility: hidden;\r\n\tdisplay: block;\r\n\tclear: both;\r\n}\r\n\r\n.cur-pointer {\r\n\tcursor: pointer;\r\n}\r\n\r\n/*头部导航 header begin*/\r\n.header {\r\n\twidth: 100%;\r\n\theight: 60px;\r\n\tbackground-color: #383e47;\r\n\toverflow: hidden;\r\n}\r\n\r\n.header .logo {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tline-height: 60px;\r\n\tcolor: #ffffff;\r\n\tfont-size: 20px;\r\n}\r\n\r\n.header .logo .img {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\twidth: 90px;\r\n\theight: 60px;\r\n\tbackground: url(/images/logo.png);\r\n}\r\n\r\n.header .right {\r\n\tfloat: right;\r\n\tmargin-top: 20px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.header .right .name {\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 30px;\r\n\tcursor: pointer;\r\n}\r\n\r\n.list-header {\r\n\tfont-size: 18px;\r\n\tcolor: #fff;\r\n\tpadding: 14px;\t/*text-indent: 30px;*/\r\n}\r\n\r\n.wrap {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\tposition: relative;\r\n\tz-index: 500;\r\n\toverflow: hidden;\r\n\tbackground: #1f253d;\r\n\tbackground-size: cover;\r\n}\r\n\r\n.header .right .name span {\r\n\tmargin-left: 10px;\r\n\tmargin-right: 8px;\r\n\tfont-weight: bold;\r\n}\r\n\r\n.header .right .quit {\r\n\tfont-size: 16px;\r\n\tcolor: #e24643;\r\n}\r\n\r\n/*头部导航 header end*/\r\n.radius4 {\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  begin*/\r\n.menu {\r\n\twidth: 100%;\r\n\theight: 50px;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.menu ul.nav {\r\n\theight: 50px;\r\n\tfloat: left;\r\n}\r\n\r\n.menu ul.nav  li {\r\n\tfloat: left;\r\n\tposition: relative;\r\n}\r\n\r\n.menu ul.nav  li a {\r\n\tcolor: #ffffff;\r\n\tpadding: 0px 30px;\r\n\tline-height: 50px;\r\n}\r\n\r\n.menu ul.nav li a.active:after {\r\n\tcontent: \"\";\r\n\tposition: absolute;\r\n\tleft: 0px;\r\n\tbottom: 0px;\r\n\twidth: 100%;\r\n\theight: 0.2rem;\r\n\tbackground: #e14340;\r\n\tz-index: 0;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav {\r\n\twidth: 96px;\r\n\theight: auto;\r\n\tbackground-color: #545e6d;\r\n\tposition: absolute;\r\n\tleft: 50%;\r\n\ttop: 40px;\r\n\tmargin-left: -50px;\r\n\tz-index: 10;\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.hide {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.show {\r\n\tdisplay: block;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li {\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tfloat: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a {\r\n\tdisplay: block;\r\n\twidth: 100%;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\ttext-align: center;\r\n\tpadding: 0 0;\r\n\tfont-size: 14px;\r\n\tcolor: #b7b7b7;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a.active:after {\r\n\tdisplay: none;\r\n}\r\n\r\n.menu ul.nav  li ul.sub-nav li a:hover {\r\n\tbackground-color: #42b8e2;\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.menu .right-park {\r\n\tfloat: right;\r\n\tmargin-top: 12px;\r\n\tmargin-right: 30px;\r\n}\r\n\r\n.menu .right-park .mt-select {\r\n\tmargin-right: 10px;\r\n}\r\n\r\n.menu .right-park .mt-select-title {\r\n\tbackground-color: #ffffff;\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park .mt-select-box {\r\n\tcolor: #333333;\r\n}\r\n\r\n.menu .right-park a {\r\n\tbackground-color: #e14340;\r\n\tcolor: #ffffff;\r\n\tpadding: 4px 10px;\r\n\tborder-radius: 5px;\r\n}\r\n\r\n/*主题页导航  end*/\r\n\r\n/*控制边距的类*/\r\n.content-space-10 {\r\n\tmargin: 10px;\r\n}\r\n\r\n.content-space-top-0 {\r\n\tmargin: 0px 10px 10px 10px;\r\n}\r\n\r\n.mod-space-l {\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.mod-space-t {\r\n\tmargin-top: 0.5%;\r\n}\r\n\r\n.mod-space-dl {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.mod-space-dt {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n/*模块公用样式 begin*/\r\n.mod {\r\n\theight: 100%;\r\n\tbackground-color: #2b323c;\r\n}\r\n\r\n.mod .mod-title h3 {\r\n\tdisplay: inline-block;\r\n\tvertical-align: middle;\r\n\tfont-weight: normal;\r\n\tfont-style: normal;\r\n\tfont-size: 16px;\r\n\tcolor: #ffffff;\r\n\tmargin-left: 10px;\r\n\tpadding: 8px 0;\r\n}\r\n\r\n.mod .mod-title .mod-title-right {\r\n\tfloat: right;\r\n}\r\n\r\n/*模块标题上的下拉选择框 begind*/\r\n.mod .mod-title .mod-title-right .mt-select {\r\n\tcolor: #e5e5e5;\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n\tpadding-left: 5px;\r\n\tpadding-right: 5px;\r\n}\r\n\r\n.mod .mod-title .mod-title-right .mt-select-box {\r\n\tbackground-color: #1a2029;\r\n\tborder: none;\r\n}\r\n\r\n/*模块标题上的下拉选择框 end*/\r\n.mt-select {\r\n\tborder: none !important;\r\n}\r\n\r\n/*模块公用样式 end*/\r\n*:focus {\r\n\toutline: none;\r\n}\r\n\r\n/*表格公用样式*/\r\ntable {\r\n\tborder-collapse: separate;\r\n}\r\n\r\n.wtyh-table thead th {\r\n\tborder-bottom: none;\r\n\tbackground-color: #1a2029;\r\n\tcolor: #dddddd;\r\n\tfont-size: 14px;\r\n\tfont-weight: normal;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.wtyh-table thead tr {\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.wtyh-table tbody td {\r\n\tborder-bottom: none;\r\n\tcolor: #ffffff;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.wtyh-table tbody tr.odd td {\r\n\tbackground: #2b323c;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-line td {\r\n\tbackground: #36404d;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.odd-blackbg-line td {\r\n\tbackground: #222932;\r\n\tborder-right: 1px #2b323c solid;\r\n}\r\n\r\n.wtyh-table tbody tr.even td {\r\n\tbackground-color: #1a2029;\r\n}\r\n\r\n.talign-left {\r\n\ttext-align: left !important;\r\n}\r\n\r\n.wtyh-table.table-border-b  tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.talign-right {\r\n\ttext-align: right !important;\r\n}\r\n\r\n.talign-center {\r\n\ttext-align: center !important;\r\n}\r\n\r\n.header-gray {\r\n\theight: 50px;\r\n\tline-height: 50px;\r\n\tbackground: #394351;\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.skublue {\r\n\tcolor: #00b8ee\r\n}\r\n\r\n.orange {\r\n\tcolor: #e14340\r\n}\r\n\r\n/*限制字数五个字*/\r\n.word-limit-5 {\r\n\toverflow: hidden; /*自动隐藏文字*/\r\n\ttext-overflow: ellipsis;/*文字隐藏后添加省略号*/\r\n\twhite-space: nowrap;/*强制不换行*/\r\n\tdisplay: inline-block;\r\n\twidth: 80px;\r\n}\r\n\r\n/*分页样式覆盖*/\r\n.mt-pagelist {\r\n\tmargin-top: 10px !important;\r\n}\r\n\r\n.mt-pagelist ul {\r\n\theight: 30px;\r\n}\r\n\r\n.mt-pagelist .mt-select,\r\n.mt-pagelist .mt-pagelist-first,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-runprev,\r\n.mt-pagelist .mt-pagelist-runnext {\r\n\tdisplay: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-prev,\r\n.mt-pagelist .mt-pagelist-next,\r\n.mt-pagelist .mt-pagelist-btn,\r\n.mt-pagelist .mt-pagelist-end,\r\n.mt-pagelist .mt-pagelist-first {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-input .mt-input {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li {\r\n\tbackground-color: #1a2029 !important;\r\n\tcolor: #ffffff !important;\r\n\tborder: none !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a {\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n\tline-height: 26px !important;\r\n\tborder-radius: 2px !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li a:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-page li.on a {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n.mt-pagelist .mt-pagelist-btn:hover,\r\n.mt-pagelist .mt-pagelist-prev:hover,\r\n.mt-pagelist .mt-pagelist-next:hover {\r\n\tbackground-color: #e14340 !important;\r\n\tborder: none !important;\r\n\tcolor: #ffffff !important;\r\n}\r\n\r\n/*搜索框*/\r\n.mt-input .mt-iconbtn,\r\n.mt-input-block .mt-iconbtn a {\r\n\tcursor: pointer !important;\r\n}\r\n\r\n/*颜色*/\r\n.c-red {\r\n\tcolor: #e14340;\r\n}\r\n\r\n/*联想词*/\r\n.ac_results {\r\n\tpadding: 0;\r\n\toverflow: auto;\r\n\tz-index: 99999;\r\n\tmax-height: 200px;\r\n\tbackground: rgba(17, 38, 67, 0.9);\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results ul {\r\n\twidth: 100%;\r\n\tlist-style: none;\r\n\tpadding: 0;\r\n\tmargin: 0;\r\n}\r\n\r\n.ac_results ul li:last-child {\r\n\tborder-bottom-left-radius: 4px;\r\n\tborder-bottom-right-radius: 4px;\r\n}\r\n\r\n.ac_results li {\r\n\tpadding: 5px 10px;\r\n\tdisplay: block;\r\n\tfont-size: 14px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.ac_results .group-item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.ac_results ul .group-item:hover {\r\n\tbackground: #063a5f;\r\n}\r\n\r\n.ac_results .group {\r\n\tcolor: #666;\r\n}\r\n\r\n.ac_results i {\r\n\tfont-size: 12px;\r\n\tcolor: #999;\r\n\tpadding-left: 1em;\r\n}\r\n\r\n.ac_results .strong {\r\n\tcolor: #13b7fe;\r\n}\r\n\r\n.ac-results ul li.group:hover {\r\n\tcursor: default;\r\n\tbackground-color: #172837;\r\n\tcolor: #666;\r\n}\r\n\r\n.iconfont.icon-desc {\r\n\tcursor: pointer;\r\n}\r\n\r\n", ""]);

	// exports


/***/ },

/***/ 696:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; }; /**
	                                                                                                                                                                                                                                                                  * 自定义内容的弹窗插件
	                                                                                                                                                                                                                                                                  * @author : Mantou
	                                                                                                                                                                                                                                                                  * @date : 2016-03-01
	                                                                                                                                                                                                                                                                  */


	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactDom = __webpack_require__(242);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//onChange , onFocus, onBlur
	var Input = _react2.default.createClass({
	    displayName: 'Input',
	    getInitialState: function getInitialState() {
	        return {
	            showValidate: false,
	            validateInfo: '',
	            inputVal: ""
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

	    handleChange: function handleChange(e) {
	        this.setState({ inputVal: e.target.value });
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
	            _react2.default.createElement('input', _extends({}, props, { value: this.state.inputVal, onChange: this.handleChange })),
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

/***/ 737:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(738);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*
	    散点图 气泡图

	    调用方式：
	    const option ={
	          color:["#a40000"],
	          title:"",
	          companyInfo:[
	          {
	            name:"海东泰金融投资有限公司",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司1",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司2",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司3",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          },
	           {
	            name:"海东泰金融投资有限公司4",//公司名称
	            regCapital:'50万元人名币',//注册资本
	            corporate:'周全',//法人代表
	            companyType:'国有出资',//公司类型
	            foundDate:'2014年3月12日'//成立日期
	          }
	          ],
	          yAxisName:"动态风险指数",
	          xAxisName:"静态风险指数",
	          series:[
	            {
	                name:'风险指数',
	                type:'scatter',
	                data: [
	                    [161.2, 51.6], 
	                    [167.5, 59.0], 
	                    [159.5, 49.2], 
	                    [157.0, 63.0], 
	                    [155.8, 53.6]
	                ]
	            }
	          ]
	      }
	*/
	var BBDscatterBuble = _react2.default.createClass({
	    displayName: 'BBDscatterBuble',

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
	        var seriesLineData = [];
	        var option = {
	            color: parm.color || ["green"],
	            textStyle: {
	                color: "#fff"
	            },
	            title: {
	                text: parm.title == undefined ? "" : parm.title,
	                padding: [10, 0, 0, 15],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: parm.grid == undefined ? { left: '3%', right: '10%', bottom: '3%', containLabel: true } : parm.grid,
	            visualMap: {
	                type: 'continuous',
	                min: 0,
	                max: 200,
	                right: '4%',
	                bottom: '8%',
	                inRange: {
	                    colorLightness: [1, 0.5]
	                },
	                controller: {
	                    inRange: {
	                        symbolSize: [10, 200],
	                        color: ['#e14341']
	                    }
	                },
	                text: ['高', '低'], // 文本，默认为数值文本
	                calculable: true
	            },
	            tooltip: {
	                position: 'top',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(data) {
	                    var dataIndex = data.dataIndex;
	                    var opr = '<div class="scatter-bubble-tip">' + '<h4>' + parm.companyInfo[dataIndex].name + '</h4>' + '<ul>' + '<li>注册资本：<span class="c-blue">' + parm.companyInfo[dataIndex].regCapital + '</span></li>' + '<li>法人代表：<span class="c-blue">' + parm.companyInfo[dataIndex].corporate + '</span></li>' + '<li>公司类型：<span class="c-blue">' + parm.companyInfo[dataIndex].companyType + '</span></li>' + '<li>成立时间：<span class="c-blue">' + parm.companyInfo[dataIndex].foundDate + '</span></li>' + '<li>静态风险指数：<span class="c-blue">' + data.value[0] + '</span></li>' + '<li>动态风险指数：<span class="c-blue">' + data.value[1] + '</span></li>' + '</ul>' + '</div>';
	                    return opr;
	                }
	            },
	            xAxis: [{
	                name: parm.xAxisName || "",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            yAxis: [{
	                name: parm.yAxisName || "",
	                type: 'value',
	                scale: true,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#565b63'
	                    }
	                },
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: true,
	                    lineStyle: {
	                        color: '#565b63',
	                        type: 'solid'
	                    }
	                }
	            }],
	            series: parm.series
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
	        //===============================================================================
	        echartObj.setOption(this.setOption(this.props.option));
	        //===============================================================================
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
	            height: '100%', width: "100%"
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDscatterBuble;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ScatterBubbleChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 739:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*散点图样式*/\r\n.scatter-bubble-tip h4{\r\n\tfont-weight: normal;\r\n\tfont-size: 16px !important;\r\n\tcolor: #ffffff;\r\n}\r\n.scatter-bubble-tip ul{\r\n\tmargin-top: 10px;\r\n}\r\n.scatter-bubble-tip ul li{\r\n\tfont-size: 14px;\r\n\tcolor: #dddddd;\r\n}\r\n.scatter-bubble-tip ul li .c-blue{\r\n\tcolor: #00b9ec;\r\n}\r\n", ""]);

	// exports


/***/ },

/***/ 741:
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
	                    console.log(data, '33333333333');
	                    if (param.formatter == "BusinessNum") {
	                        //典当总额业务笔数
	                        return data.name + ' 年<br/> 典当总额：&nbsp <span style="color:#00b7f0">' + data.data[3] + '亿元</span><br/>业务笔数：&nbsp  <span style="color:#00b7f0">' + data.data[2] + '</span>';
	                    } else {
	                        return data.name + ' 年<br/> ' + param.forMaterTitle + "：" + data.data[2] + '亿元<br/>' + param.forMaterTip + "：" + data.data[2] + "亿元";
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
	                    console.log(val[2], 'val');
	                    if (val[2] < 10000) {
	                        return val[2] / 500;
	                    } else if (10000 < val[2] && val[2] < 100000) {
	                        return val[2] / 5000;
	                    } else if (100000 < val[2] && val[2] < 1000000) {
	                        return val[2] / 10000;
	                    } else if (1000000 < val[2] && val[2] < 10000000) {
	                        return val[2] / 80000;
	                    } else {
	                        return val[2] / 1000000;
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

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(728);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _ResultMod = __webpack_require__(746);

	var _ResultMod2 = _interopRequireDefault(_ResultMod);

	var _IndexAction = __webpack_require__(722);

	var IndexAction = _interopRequireWildcard(_IndexAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//搜索结果页
	var LineFinanceSearchResult = _react2.default.createClass({
	  displayName: 'LineFinanceSearchResult',

	  getInitialState: function getInitialState() {
	    return {
	      count: 0,
	      pageNo: 1,
	      keyWord: ""
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var keyWord = this.props.location.query.keyWord;
	    var jsonData = { pageNo: this.state.pageNo, pageSize: 8, keyWord: keyWord };
	    this.getSearchList(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {

	    var isEqual = Immutable.is(nextProps.companyGradeResult, this.props.companyGradeResult); //判断数据是否变化
	    if (!isEqual) {
	      var companyGradeRequest = nextProps.companyGradeRequest;
	      var companyGradeResult = nextProps.companyGradeResult;

	      if (companyGradeRequest == true) {
	        if (companyGradeResult.success == true) {
	          this.dataFomat(companyGradeResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    var content = data.content;
	    this.setState({ companyGradeList: content });
	  },
	  getSearchList: function getSearchList(jsonData) {
	    var getSearchResult = this.props.getSearchResult;

	    getSearchResult(jsonData);
	  },
	  //分页回调 
	  setCallBack: function setCallBack(nowpage, eachPageCount) {
	    var keyWord = this.state.keyWord;
	    var jsonData = { pageNo: nowpage, pageSize: 8, keyWord: keyWord };
	    this.setState({ pageNo: nowpage });
	    this.getSearchList(jsonData);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'line-finace-result', style: this.state.style },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_IndustrySearch2.default, { companyType: '4', searchFun: this.getInputVal, label: '线下理财监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'search-content' },
	        _react2.default.createElement(
	          'ul',
	          { className: 'search-list' },
	          this.props.SearchResultRequest ? this.props.SearchResultResult.content.list.map(function (item, index) {
	            return _react2.default.createElement(
	              'li',
	              { key: index },
	              _react2.default.createElement(_ResultMod2.default, { dataItem: item })
	            );
	          }) : ''
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'search-count' },
	          '共搜索到',
	          _react2.default.createElement(
	            'span',
	            { className: 'c-red' },
	            this.props.SearchResultRequest ? this.props.SearchResultResult.content.count : ''
	          ),
	          '家相关企业'
	        ),
	        _react2.default.createElement(_index.PageList, { id: 'search-result-page', count: this.state.count, showPage: '10', callback: this.setCallBack })
	      )
	    );
	  }
	});
	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {

	    //搜索结果
	    SearchResultRequest: state.Common.request,
	    SearchResultResult: state.Common.result
	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(IndexAction, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(LineFinanceSearchResult);
	// module.exports = LineFinanceSearchResult;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchResult.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 743:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(744);

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
	          size: 5,
	          form: "base"
	        },
	        wrap: $('body'),
	        callback: function callback() {}
	      });
	    } else {
	      //p2p页面专用
	      $("#autocomplete").inputAutoComplete({
	        requestType: 'get',
	        requestUrl: '/P2PImage/hasOrNotCompany.do',
	        requestData: {
	          form: "p2p"
	        },
	        wrap: $('body'),
	        callback: function callback() {}
	      });
	    }
	  },
	  handleChange: function handleChange(e) {
	    var searchVal = $(e.target).parent().prev().val();
	    var searchValAttr = $(e.target).parent().prev()[0].getAttribute("company");
	    var isClick = $(e.target).parent().prev()[0].getAttribute("data_flag");
	    if (isClick == "hasWorld") {
	      this.setState({ searchVal: searchVal });
	      if (this.props.searchFun) {
	        this.props.searchFun(searchVal, searchValAttr);
	      }
	    }
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

/***/ 750:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(751);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineFinRiskSearchHeaderAction = __webpack_require__(753);

	var RiskSearchActionCreaters = _interopRequireWildcard(_LineFinRiskSearchHeaderAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险顶部公用头部
	var RiskSearchHeader = _react2.default.createClass({
	  displayName: 'RiskSearchHeader',

	  getInitialState: function getInitialState() {
	    return {
	      companyTag: [],
	      companyName: ""
	    };
	  },
	  componentWillMount: function componentWillMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.dynamicRiskCompanyTagResult, this.props.dynamicRiskCompanyTagResult); //判断数据是否变化
	    if (!isEqual) {
	      var dynamicRiskCompanyTagRequest = nextProps.dynamicRiskCompanyTagRequest;
	      var dynamicRiskCompanyTagResult = nextProps.dynamicRiskCompanyTagResult;

	      if (dynamicRiskCompanyTagRequest == true) {
	        if (dynamicRiskCompanyTagResult.success == true) {
	          this.dataFomat(dynamicRiskCompanyTagResult);
	        } else {
	          console.log(404);
	        }
	      }
	    }
	  },
	  getRiskSearchVal: function getRiskSearchVal(data) {
	    var _props = this.props;
	    var getRiskSearchVal = _props.getRiskSearchVal;
	    var getDynamicRiskCompanyTag = _props.getDynamicRiskCompanyTag;

	    getRiskSearchVal(data);
	    var json = { companyName: data };
	    getDynamicRiskCompanyTag(json);
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, '公司标签');
	  },
	  //重新载入搜索结果的页面
	  searchKey: function searchKey(data) {
	    this.getRiskSearchVal(data);
	  },
	  render: function render() {
	    //企业标签className
	    var classNameSet = ["bg-blue", "bg-yellow", "bg-red"];
	    return _react2.default.createElement(
	      'div',
	      { className: 'risk-search-header' },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_IndustrySearch2.default, { companyType: '4', searchFun: this.searchKey, label: '线下理财监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'search-bar' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(
	            'div',
	            { className: 'company-name' },
	            this.props.companyName
	          ),
	          _react2.default.createElement(
	            'div',
	            { className: 'company-info' },
	            this.state.companyTag.map(function (item, index) {
	              return _react2.default.createElement(
	                'span',
	                { className: classNameSet[index], key: 'span-' + index },
	                item
	              );
	            })
	          ),
	          _react2.default.createElement(
	            'a',
	            { href: 'javascript:;', className: 'export-report' },
	            _react2.default.createElement('i', { className: 'iconfont icon-export' }),
	            '导出报告'
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right' },
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: { pathname: '/lineFinanceStaticRisk', query: { companyName: this.state.companyName } } },
	            _react2.default.createElement('i', { className: 'iconfont icon-bar' }),
	            '静态风险指数'
	          ),
	          _react2.default.createElement(
	            _reactRouter.Link,
	            { activeClassName: 'active', to: { pathname: '/lineFinanceDynamicRisk', query: { companyName: this.state.companyName } } },
	            _react2.default.createElement('i', { className: 'iconfont icon-history' }),
	            '风险时序差异对比'
	          )
	        )
	      )
	    );
	  }
	});
	//module.exports = RiskSearchHeader;

	function mapStateToProps(state) {
	  return {};
	}
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(RiskSearchActionCreaters, dispatch);
	}

	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(RiskSearchHeader);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RiskSearchHeader.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
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
	          return v.name + "<br/>" + v.seriesName + " :&nbsp;<span style='color:#00b7f0'>" + v.value + _until + "(" + v.percent + "%)" + "</span>";
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

/***/ 760:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDLine = _react2.default.createClass({
	    displayName: "BBDLine",

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
	        var seriesLineData = [];

	        for (var i = 0; i < parm.series.length; i++) {
	            var barAreaStyle = {};
	            if (parm.barGradient) {
	                barAreaStyle = {
	                    normal: {
	                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                            offset: 0,
	                            color: parm.barGradient[i][0]
	                        }, {
	                            offset: 1,
	                            color: parm.barGradient[i][1]
	                        }])
	                    }
	                };
	            }
	            var seriesBarItem = {
	                "type": "line",
	                "name": parm.legend[i],
	                "label": parm.lineLable == undefined ? {} : parm.lineLable,
	                "areaStyle": barAreaStyle,
	                "symbolSize": parm.symbolSize,
	                "data": parm.series[i]
	            };
	            seriesLineData.push(seriesBarItem);
	        }
	        var option = {
	            color: parm.color,
	            title: {
	                show: parm.titleShow == undefined ? false : true,
	                text: parm.title,
	                x: parm.titleX,
	                padding: [10, 0, 0, 15],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 16,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            tooltip: {
	                trigger: 'axis',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    var info = v[0].name + "<br/>";
	                    for (var i = 0; i < v.length; i++) {
	                        var _until = "";
	                        if (parm.unit == undefined) {
	                            _until = "";
	                        } else {
	                            _until = parm.unit[i];
	                        }
	                        var _spanCorlor = '<span style=color:' + parm.color[i] + '>' + v[i].value + _until + '</span><br/>';
	                        info += v[i].seriesName + " :&nbsp;" + _spanCorlor;
	                    }
	                    return info;
	                },
	                axisPointer: {
	                    type: 'none'
	                }
	            },
	            grid: parm.grid == undefined ? { top: '15%', left: '5%', right: '5%', bottom: '5%', containLabel: true } : parm.grid,
	            legend: {
	                data: parm.legend,
	                itemWidth: 20,
	                itemHeight: 5,
	                show: parm.legendIsShow == undefined ? false : parm.legendIsShow,
	                right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	                bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	                top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	                padding: parm.legendPadding == undefined ? [15, 0, 0, 0] : parm.legendPadding,
	                textStyle: {
	                    color: "#99a3b7",
	                    fontSize: 12,
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            xAxis: {
	                type: 'category',
	                data: parm.xAxis,
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        width: 1,
	                        color: '#353b45' }
	                },
	                //'#8f949a'
	                axisTick: {
	                    show: false
	                }
	            },
	            yAxis: {
	                name: parm.yAxisName,
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                type: 'value',
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
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
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
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
	exports.default = BBDLine;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 761:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.queryDynamicPic = queryDynamicPic;
	exports.queryStatistics = queryStatistics;
	exports.queryRiskData = queryRiskData;
	exports.companyNews = companyNews;
	exports.queryDateVersion = queryDateVersion;
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
	      url: "/offlineFinance/queryDynamicPicData.do", //"/offlineFinance/queryDynamicPicData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(dynamicPicSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(dynamicPicFail(result));
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
	      url: "offlineFinance/queryStatisticsMultiple.do",
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
	//静态风险指数构成
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
	//请求时间列表/offlineFinance/queryDateVersion.do
	var QUERY_DATA_SUCCESS = exports.QUERY_DATA_SUCCESS = 'QUERY_DATA_SUCCESS';
	var QUERY_DATA_FAIL = exports.QUERY_DATA_FAIL = 'QUERY_DATA_FAIL';
	function queryDataSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: QUERY_DATA_SUCCESS,
	    result: result
	  };
	}
	function queryDataFail(result) {
	  //请求失败调用方法
	  return {
	    type: QUERY_DATA_FAIL,
	    result: result
	  };
	}
	function queryDateVersion(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/offlineFinance/queryDateVersion.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(queryDataSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(queryDataFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceStaticRiskAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 791:
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
	                    var _until = "";
	                    if (parm.unit == undefined) {
	                        _until = "";
	                    } else {
	                        _until = parm.unit;
	                    }
	                    if (!isNaN(v.value)) {
	                        return v.name + "<br/>" + v.seriesName + ":<span style='color:#00b7f0'>" + v.value + "(" + _until + ")</span>";
	                    } else {
	                        return v.name;
	                    }
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

/***/ 802:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

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
													list: [],
													orderType: "desc", //默认降序
													orderField: "" //需要排序的字段
									};
					},
					componentDidMount: function componentDidMount() {
									$('#companyProgress-scroll').perfectScrollbar();
					},
					handleClick: function handleClick(field) {
									var _dom = $(this.refs[field]),
									    _domAttr = _dom.attr("data-order"),
									    _domIco = _dom.find("em"),
									    _domIcoIs = _dom.find("em").hasClass('icon-desc');
									_domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
									_domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
									this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
													var _basedata = BOSS.sort(this.state.list, field, this.state.orderType);
													this.setState({ list: _basedata });
									});
					},
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
					componentDidUpdate: function componentDidUpdate() {
									$('#companyProgress-scroll').perfectScrollbar('update');
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
																																					{ width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'quatas', onClick: this.handleClick.bind(this, "quatas") },
																																					'获批额度($)',
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	),
																																	_react2.default.createElement(
																																					'th',
																																					{ width: '25%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'progress', onClick: this.handleClick.bind(this, "progress") },
																																					'近期进展',
																																					_react2.default.createElement('em', { className: 'iconfont icon-desc' })
																																	)
																													)
																									)
																					)
																	),
																	_react2.default.createElement(
																					'div',
																					{ className: 'table-content', id: 'companyProgress-scroll' },
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
																																																					{ to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
																																																					item.companyName
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	_react2.default.createElement(
																																																					'span',
																																																					{ className: 'word-limit-5', 'data-tip': item.shareholders, title: item.shareholders },
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
																																																					{ to: { pathname: '/SearchResultDetail', query: { formpage: 'CompanyProgress', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
																																																					item.companyName
																																																	)
																																													),
																																													_react2.default.createElement(
																																																	'td',
																																																	{ width: '20%' },
																																																	_react2.default.createElement(
																																																					'span',
																																																					{ className: 'word-limit-5', 'data-tip': item.shareholders, title: item.shareholders },
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

/***/ 804:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".privateFund-index .middle-l .content,\r\n.privateFund-index .middle-r .content {\r\n\theight: 570px;\r\n}\r\n\r\n.privateFund-index .middle-l .content .content-l {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .middle-l .content .content-r {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .middle-r .content .content-l {\r\n\twidth: 40%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index  .middle-r .content .content-r {\r\n\twidth: 60%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark {\r\n\tmargin-top: 50px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark table {\r\n\theight: 100px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark table {\r\n\twidth: 100%;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark tbody {\r\n\tbackground: #3a4352;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark .padding-l20 {\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark .word-limit-5 {\r\n\r\n\t/*width: 200px;*/\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.privateFund-index .top-left-r .pic-remark tbody tr {\r\n\tborder-bottom: 1px #555c6c solid;\r\n\ttext-align: left;\r\n}\r\n\r\n.privateFund-index .top-left-l .mod-content,\r\n.privateFund-index .top-r .mod-content {\r\n\tpadding: 10px 15px 50px 15px;\r\n}\r\n\r\n.privateFund-index .top-left-l .table-content,\r\n.privateFund-index .top-r .table-content {\r\n\theight: 460px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.privateFund-index .top-left-l .table-content table,\r\n.privateFund-index .top-r .table-content table {\r\n\tmargin-top: 0px !important;\t/*height: 100%*/\r\n}\r\n\r\n.privateFund-index  .mt-table {\r\n\tmargin: 0px 0px !important;\r\n}\r\n\r\n.privateFund-index .top-left-l  thead th,\r\n.privateFund-index .top-r  thead th {\r\n\ttext-align: left;\r\n\theight: 40px;\r\n\tpadding: 0px !important;\r\n}\r\n\r\n.privateFund-index .top-left-l tbody td,\r\n.privateFund-index .top-r tbody td {\r\n\ttext-align: left;\r\n\tpadding: 10px 0px !important;\r\n}\r\n\r\n.privateFund-index .top-left-l .mt-table th {\r\n\tpadding: 0px;\r\n}\r\n\r\n.padding-l20 {\r\n\tpadding-left: 20px !important;\r\n}", ""]);

	// exports


/***/ },

/***/ 806:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

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
	            listData: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getQDLPQualityRequest = this.props.getQDLPQualityRequest;

	        var jsonData = {};
	        getQDLPQualityRequest(jsonData);
	        $('#qdlpQuality-scroll').perfectScrollbar();
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.listData, field, this.state.orderType);
	            this.setState({ listData: _basedata });
	        });
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
	    componentDidUpdate: function componentDidUpdate() {
	        $('#qdlpQuality-scroll').perfectScrollbar('update');
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
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'total', onClick: this.handleClick.bind(this, "total") },
	                                    '总规模($)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'dollarPart', onClick: this.handleClick.bind(this, "dollarPart") },
	                                    '美元部分($)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'rmbTotal', onClick: this.handleClick.bind(this, "rmbTotal") },
	                                    '投资合计(￥)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'qdlpQuality-scroll' },
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
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
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
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
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
	                    return v.name + " :&nbsp;<span style='color:" + parm.color[0] + "'>" + v.value + "</span>";
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

/***/ 811:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDLineBar = _react2.default.createClass({
	    displayName: 'BBDLineBar',

	    // propTypes: {
	    //     param: React.PropTypes.object.isRequired,
	    //     style: React.PropTypes.object,
	    //     className: React.PropTypes.string,
	    //     theme: React.PropTypes.string,
	    //     onChartReady: React.PropTypes.func,
	    //     showLoading: React.PropTypes.bool,
	    //     onEvents: React.PropTypes.object
	    // },
	    setOption: function setOption(parm) {
	        var seriesBarData = [];
	        if (parm.series.bar) {
	            for (var i = 0; i < parm.series.bar.length; i++) {
	                var seriesBarItem = {
	                    name: parm.barName[i],
	                    type: 'bar',
	                    label: {
	                        normal: {
	                            show: parm.labelShow || false,
	                            position: parm.lablePosition || "top",
	                            textStyle: {
	                                color: "#fff"
	                            }
	                        }
	                    },
	                    stack: parm.stack == undefined ? "" : parm.stack,
	                    barWidth: parm.barWidth == undefined ? "auto" : parm.barWidth,
	                    data: parm.series.bar[i],
	                    itemStyle: parm.itemStyle || {
	                        normal: {},
	                        emphasis: {}
	                    }
	                };
	                seriesBarData.push(seriesBarItem);
	            }
	        }
	        var barAreaStyle = {};
	        if (parm.series.line) {
	            for (var j = 0; j < parm.series.line.length; j++) {
	                var seriesBarItem = {
	                    name: parm.lineName[j],
	                    type: 'line',
	                    yAxisIndex: 1,
	                    symbolSize: parm.symbolSize,
	                    data: parm.series.line[j]
	                };
	                seriesBarData.push(seriesBarItem);
	            }
	        }
	        console.log(seriesBarData, "csy");
	        var option = {
	            color: parm.color,
	            title: {
	                show: parm.titleShow == undefined ? false : parm.titleShow,
	                text: parm.title,
	                x: parm.titleX,
	                padding: [25, 0, 0, 5],
	                textStyle: {
	                    color: "#fff",
	                    fontSize: 14,
	                    fontWeight: "normal",
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            tooltip: {
	                trigger: 'axis',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    var info = v[0].name + "<br/>";
	                    for (var i = 0; i < v.length; i++) {
	                        var _until = "";
	                        if (parm.unit == undefined) {
	                            _until = "";
	                        } else {
	                            _until = parm.unit[i];
	                        }
	                        var _spanCorlor = '<span style=color:' + parm.color[i] + '>' + v[i].value + _until + '</span><br/>';
	                        info += v[i].seriesName + " :&nbsp;" + _spanCorlor;
	                    }
	                    return info;
	                },
	                axisPointer: {
	                    type: 'none'
	                }
	            },
	            legend: {
	                padding: [15, 0, 0, 0],
	                itemGap: 5,
	                itemWidth: 20,
	                itemHeight: 5,
	                width: parm.legendWidth || "auto",
	                show: parm.legendShow == undefined ? false : parm.legendShow,
	                left: parm.legendLeft == undefined ? "auto" : parm.legendLeft,
	                right: parm.legendRight == undefined ? "auto" : parm.legendRight,
	                bottom: parm.legendBottom == undefined ? "auto" : parm.legendBottom,
	                top: parm.legendTop == undefined ? "auto" : parm.legendTop,
	                data: parm.legend,
	                textStyle: {
	                    color: "#99a3b7",
	                    fontSize: 12,
	                    fontFamily: 'Microsoft Yahei'
	                }
	            },
	            grid: {
	                left: parm.gridLeft || '5%',
	                right: parm.gridRight || '5%',
	                bottom: parm.gridBottom == undefined ? "15%" : parm.gridBottom,
	                containLabel: true
	            },
	            xAxis: [{
	                type: parm.Xtype || 'category',
	                data: parm.xAxis || [],
	                axisLabel: {
	                    formatter: '{value}',
	                    textStyle: {
	                        color: "#99a3b7",
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
	                type: parm.Ytype || 'value',
	                data: parm.yAxis || [],
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[0],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                nameLocation: parm.YnameLocation || "end",
	                nameRotate: parm.YnameRoutate || 0,
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
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
	                    show: parm.axisLabelL == undefined ? true : parm.axisLabelL,
	                    formatter: parm.yFlag == undefined ? '{value}' : '{value}' + parm.yFlag,
	                    textStyle: {
	                        color: "#99a3b7",
	                        fontSize: 12,
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                }
	            }, {
	                type: parm.Ytype || 'value',
	                name: parm.yAxisName == undefined ? "" : parm.yAxisName[1],
	                nameTextStyle: {
	                    color: "#7f868e"
	                },
	                data: parm.yAxis || [],
	                nameLocation: parm.YnameLocation || "end",
	                nameGap: parm.YnameGap || 8,
	                axisTick: {
	                    show: false
	                },
	                splitLine: {
	                    show: false
	                },
	                axisLine: {
	                    show: parm.axisLineR == undefined ? true : parm.axisLineR,
	                    lineStyle: {
	                        color: '#353b45'
	                    }
	                },
	                axisLabel: {
	                    show: parm.axisLabelR == undefined ? true : parm.axisLabelR,
	                    formatter: parm.y2Flag == undefined ? '{value}' : '{value}' + parm.y2Flag,
	                    textStyle: {
	                        color: "#99a3b7",
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
	        //  echartObj.resize();
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
	        echartObj.setOption(this.setOption(this.props.param));
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
	exports.default = BBDLineBar;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineBarChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 837:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(835);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var volume = _react2.default.createClass({
	    displayName: 'volume',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.volumeData, this.props.volumeData);
	        if (!isEqual) {
	            var volumeData = nextProps.volumeData;

	            var optionParm = {
	                "color": ["#00b8ee", "#f7b650"],
	                "legend": ["成交量", "综合利率"],
	                "barName": ["成交量"],
	                "lineName": ["综合利率"],
	                "legendShow": true,
	                "legendRight": "30",
	                "yFlag": "",
	                "y2Flag": "%",
	                "yAxisName": ["亿元", "综合利率"],
	                "unit": ["亿元", "%"],
	                "barWidth": 20,
	                "symbolSize": 5,
	                "xAxis": volumeData.bargain.xAxis,
	                "series": {
	                    "bar": [volumeData.bargain.series.bar],
	                    "line": [volumeData.bargain.series.line]
	                }
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartOption, style: { height: '300px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-l-b radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '成交量和综合利率'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = volume;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "volume.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 843:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(835);

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
	                                '排名'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '平台名称'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '成交量'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                null,
	                                '平均利率'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '平均借款期限'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'diff-width' },
	                                '累计待还金额'
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
	                                            '亿'
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
	                                            '亿'
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

/***/ 847:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".p2p-portrait {\r\n}\r\n\r\n.p2p-portrait .portrait-left {\r\n\twidth: 45%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right {\r\n\twidth: 54.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom {\r\n\twidth: 100%;\r\n\tmargin-top: 0.5%\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t {\r\n\twidth: 100%;\r\n\theight: 180px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m {\r\n\twidth: 100%;\r\n\theight: 275px;\r\n\tmargin: 1.5% 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-b {\r\n\twidth: 100%;\r\n\theight: 815px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t {\r\n\twidth: 100%;\r\n\theight: 464px\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b {\r\n\twidth: 100%;\r\n\theight: 815px;\r\n\tmargin-top: 1.4%;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l {\r\n\twidth: 24%;\r\n\theight: 255px;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-r {\r\n\twidth: 75.5%;\r\n\theight: 255px;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%;\r\n}\r\n\r\n.p2p-portrait  .compangMsg-log {\r\n\twidth: 90px;\r\n\theight: 90px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\tdisplay: table;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul li {\r\n\tdisplay: table-cell;\r\n\tvertical-align: middle;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul span {\r\n\tdisplay: block;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .score {\r\n\tfont-size: 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .score-title {\r\n\tfont-size: 18px;\r\n\tcolor: #fff\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-t ul .state {\r\n\tfont-size: 24px;\r\n\tcolor: #fff\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table {\r\n\theight: 180px;\r\n\tcolor: #dddddd\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table td {\r\n\tcolor: #dddddd;\r\n\tpadding-left: 20px !important;\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .wtyh-table td .word-limit-5 {\r\n\twidth: 200px\r\n}\r\n\r\n.p2p-portrait .portrait-left .left-m .list-items {\r\n\tpadding: 10px 10px 0px 10px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content {\r\n\tpadding: 65px 43px 20px 43px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul {\r\n\tdisplay: table;\r\n\twidth: 100%;\r\n\tposition: relative;\r\n\tpadding-bottom: 20px;\r\n\ttext-align: center;\r\n\tborder-bottom: 1px #00b8ee solid;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul:before {\r\n\tcontent: \"\";\r\n\theight: 50%;\r\n\twidth: 1px;\r\n\tbackground: #00b8ee;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n\tleft: 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul:after {\r\n\tcontent: \"\";\r\n\theight: 50%;\r\n\twidth: 1px;\r\n\tbackground: #00b8ee;\r\n\tposition: absolute;\r\n\tbottom: 0px;\r\n\tright: 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .content ul li {\r\n\tdisplay: table-cell;\r\n\twidth: 33.3%;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .icon-susong {\r\n\tdisplay: inline-block;\r\n\tfont-size: 60px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .ssong-title {\r\n\tfont-size: 18px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom .bottom-l .ssong-num {\r\n\tfont-size: 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .content {\r\n\tmargin: 20px;\r\n\theight: 170px;\r\n\tbackground: #212831;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .serial-num {\r\n\twidth: 25px;\r\n\theight: 25px;\r\n\tline-height: 25px;\r\n\ttext-align: center;\r\n\tbackground: #1a2029;\r\n\tcolor: #fff;\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item a {\r\n\tcolor: #e14340\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item {\r\n\tcolor: #d9d9d9;\r\n\tpadding: 11px 30px 11px 30px;\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item table {\r\n\twidth: 100%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .item-mark {\r\n\ttext-indent: 30px;\r\n\tpadding: 10px 0px\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item  .td2-l {\r\n\twidth: 5%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item  .td2-r {\r\n\twidth: 95%\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .soure,\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .time {\r\n\tcolor: #999999\r\n}\r\n\r\n.p2p-portrait .portrait-bottom  .bottom-r .list-item .time {\r\n\tdisplay: inline-block;\r\n\tmargin-left: 20px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .content {\r\n\tpadding: 15px  50px 0px 50px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t ul.content-ul {\r\n\tdisplay: table;\r\n\twidth: 100%;\r\n\ttext-align: center;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t ul.content-ul>li {\r\n\tdisplay: table-cell;\r\n\tvertical-align: middle;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l {\r\n\twidth: 15%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-c {\r\n\twidth: 53%;\r\n\tmargin-right: 2%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r {\r\n\twidth: 30%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l .socre-title {\r\n\tfont-size: 30px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-l .score {\r\n\tfont-size: 52px;\r\n\tmargin-top: 40px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r table {\r\n\r\n\t/*text-align: center;*/\r\n\twidth: 100%;\r\n\theight: 380px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r  .score-leida-r-ul li {\r\n\twidth: 48%;\r\n\tfloat: left;\r\n\tpadding: 15px 0px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r p {\r\n\tfont-size: 32px;\r\n\tcolor: #fdba45\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t  .leida-c-pic {\r\n\theight: 382px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-t .score-leida-r span {\r\n\tfont-size: 16px;\r\n\tcolor: #dddddd\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .content {\r\n\tpadding: 40px 30px;\r\n\theight: 760px;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top {\r\n\theight: 50%;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top table {\r\n\twidth: 100%;\r\n\theight: 90%\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom .bottom-line-left {\r\n\twidth: 50%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom .bottom-line-right {\r\n\twidth: 50%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top table  td {\r\n\twidth: 50%;\r\n\tcolor: #dddddd;\r\n\tpadding-left: 30px !important;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top .top-list {\r\n\theight: 100%;\r\n\twidth: 40%;\r\n\tfloat: left;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-top .top-bar {\r\n\theight: 100%;\r\n\twidth: 55%;\r\n\tfloat: right;\r\n}\r\n\r\n.p2p-portrait .portrait-right .right-b .core-bottom {\r\n\theight: 50%\r\n}\r\n\r\n.p2p-portrait .relation-legend table {\r\n\twidth: 100%\r\n}\r\n\r\n.p2p-portrait .relation-modal {\r\n\tdisplay: none;\r\n}\r\n\r\n.p2p-portrait .linefin-rel-graph .mod-content .relation-graph-box {\r\n\theight: 640px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.p2p-portrait  .linefin-rel-graph {\r\n\theight: 815px\r\n}\r\n\r\n.p2p-portrait .relation-legend table tr td {\r\n\twidth: 19.8%;\r\n}\r\n\r\n.p2p-portrait .relation-legend {\r\n\tmargin: 35px 10px 15px 10px;\r\n\twidth: auto;\r\n}\r\n\r\n.p2p-portrait  .relation-legend table tr .square,\r\n.p2p-portrait   .relation-legend table tr .round {\r\n\tmargin-right: 5px;\r\n}\r\n\r\n.p2p-portrait  .relation-legend table tr .square {\r\n\twidth: 10px;\r\n\theight: 10px;\r\n}\r\n\r\n.p2p-portrait   .relation-legend table tr .round {\r\n\twidth: 10px;\r\n\theight: 10px;\r\n}\r\n\r\n.p2p-portrait .pic_rank {\r\n\tposition: absolute;\r\n\tz-index: 9999;\r\n\tright: 10px;\r\n\ttop: 74px;\r\n}\r\n\r\n.p2p-portrait .pic_rank span {\r\n\tcolor: #e14340;\r\n\tdisplay: inline-block;\r\n\twidth: 25px;\r\n\theight: 25px;\r\n\tline-height: 25px;\r\n\tbackground: #000;\r\n\tborder: 1px #3b424c solid;\r\n\tmargin-left: 10px;\r\n\tcursor: pointer;\r\n\ttext-align: center;\r\n\tfont-weight: bold;\r\n}\r\n\r\n#dyMapMain,\r\n#dyMap {\r\n\twidth: 100%;\r\n\theight: 100%;\r\n}", ""]);

	// exports


/***/ },

/***/ 850:
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
	                formatter: function formatter(v) {
	                    var info = "";
	                    for (var i = 0; i < v.length; i++) {
	                        var _until = "";
	                        if (parm.unit == undefined) {
	                            _until = "";
	                        } else {
	                            _until = parm.unit[i];
	                        }
	                        var _spanCorlor = v[i].name + ' :&nbsp;<span style=color:' + parm.color[i] + '>' + v[i].value + _until + '</span><br/>';
	                        info += _spanCorlor;
	                    }
	                    return info;
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

/***/ 856:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getbaseMsgRequest = getbaseMsgRequest;
	exports.getcompanyMsgRequest = getcompanyMsgRequest;
	exports.getcoreDataRequest = getcoreDataRequest;
	exports.getCoreBarDataRequest = getCoreBarDataRequest;
	exports.getCoreTrendDataRequest = getCoreTrendDataRequest;
	exports.getCoreBalanceDataRequest = getCoreBalanceDataRequest;
	exports.getlitigationRequest = getlitigationRequest;
	exports.getpublicOpinionRequest = getpublicOpinionRequest;
	exports.getrankPicRequest = getrankPicRequest;
	exports.getscoreLeidaRequest = getscoreLeidaRequest;
	exports.setCompany = setCompany;
	/*
	  平台画像
	*/

	/*基本信息*/
	var BASEMSG_REQUEST_SUCCESS = exports.BASEMSG_REQUEST_SUCCESS = 'BASEMSG_REQUEST_SUCCESS';
	var BASEMSG_REQUEST_FAIL = exports.BASEMSG_REQUEST_FAIL = 'BASEMSG_REQUEST_FAIL';

	function baseMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: BASEMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function baseMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: BASEMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getbaseMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/baseInfo.do", ///data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(baseMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(baseMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*基本信息*/

	/*公司基本信息*/
	var COMPANYMSG_REQUEST_SUCCESS = exports.COMPANYMSG_REQUEST_SUCCESS = 'COMPANYMSG_REQUEST_SUCCESS';
	var COMPANYMSG_REQUEST_FAIL = exports.COMPANYMSG_REQUEST_FAIL = 'COMPANYMSG_REQUEST_FAIL';

	function companyMsgRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYMSG_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function companyMsgRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYMSG_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcompanyMsgRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/platFormStatus.do", ///P2PImage/platFormStatus.do
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyMsgRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyMsgRequestFail(result));
	      }
	    });
	  };
	}
	/*公司基本信息	*/

	/*核心数据*/
	var COREDATA_REQUEST_SUCCESS = exports.COREDATA_REQUEST_SUCCESS = 'COREDATA_REQUEST_SUCCESS';
	var COREDATA_REQUEST_FAIL = exports.COREDATA_REQUEST_FAIL = 'COREDATA_REQUEST_FAIL';

	function coreDataRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREDATA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreDataRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREDATA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getcoreDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataInfo.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreDataRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreDataRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据平台交易量走势
	var COREBAR_REQUEST_SUCCESS = exports.COREBAR_REQUEST_SUCCESS = 'COREBAR_REQUEST_SUCCESS';
	var COREBAR_REQUEST_FAIL = exports.COREBAR_REQUEST_FAIL = 'COREBAR_REQUEST_FAIL';

	function coreBarRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREBAR_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreBarRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREBAR_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreBarDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataDealTrend.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreBarRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreBarRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据  平台利率走势
	var CORETREND_REQUEST_SUCCESS = exports.CORETREND_REQUEST_SUCCESS = 'CORETREND_REQUEST_SUCCESS';
	var CORETREND_REQUEST_FAIL = exports.CORETREND_REQUEST_FAIL = 'CORETREND_REQUEST_FAIL';

	function coreaTrendRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: CORETREND_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreaTrendRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: CORETREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreTrendDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataInterestRateTrend.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreaTrendRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreaTrendRequestFail(result));
	      }
	    });
	  };
	}

	//核心数据  贷款余额
	var COREBALANCE_REQUEST_SUCCESS = exports.COREBALANCE_REQUEST_SUCCESS = 'COREBALANCE_REQUEST_SUCCESS';
	var COREBALANCE_REQUEST_FAIL = exports.COREBALANCE_REQUEST_FAIL = 'COREBALANCE_REQUEST_FAIL';

	function coreBalanceRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COREBALANCE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function coreBalanceRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: COREBALANCE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getCoreBalanceDataRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/coreDataLoadOverage.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(coreBalanceRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(coreBalanceRequestFail(result));
	      }
	    });
	  };
	}

	/*核心数据*/

	/*诉讼信息*/
	var LITIGATION_REQUEST_SUCCESS = exports.LITIGATION_REQUEST_SUCCESS = 'LITIGATION_REQUEST_SUCCESS';
	var LITIGATION_REQUEST_FAIL = exports.LITIGATION_REQUEST_FAIL = 'LITIGATION_REQUEST_FAIL';

	function litigationRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: LITIGATION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function litigationRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: LITIGATION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getlitigationRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/lawsuitMsg.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(litigationRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(litigationRequestFail(result));
	      }
	    });
	  };
	}
	/*诉讼信息*/

	/*平台舆情*/
	var PUBLICOPINION_REQUEST_SUCCESS = exports.PUBLICOPINION_REQUEST_SUCCESS = 'PUBLICOPINION_REQUEST_SUCCESS';
	var PUBLICOPINION_REQUEST_FAIL = exports.PUBLICOPINION_REQUEST_FAIL = 'PUBLICOPINION_REQUEST_FAIL';

	function publicOpinionRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function publicOpinionRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: PUBLICOPINION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getpublicOpinionRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/platFormConsensus.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(publicOpinionRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(publicOpinionRequestFail(result));
	      }
	    });
	  };
	}
	/*平台舆情	*/

	/*动态图谱*/
	var RANKPIC_REQUEST_SUCCESS = exports.RANKPIC_REQUEST_SUCCESS = 'RANKPIC_REQUEST_SUCCESS';
	var RANKPIC_REQUEST_FAIL = exports.RANKPIC_REQUEST_FAIL = 'RANKPIC_REQUEST_FAIL';

	function rankPicRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: RANKPIC_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function rankPicRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: RANKPIC_REQUEST_FAIL,
	    result: result
	  };
	}

	function getrankPicRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/queryDynamicPicData.do", //"/relativeGraph/json/queryRelationship1.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(rankPicRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(rankPicRequestFail(result));
	      }
	    });
	  };
	}
	/*动态图谱*/

	/*评分雷达图*/
	var SCORELEIDA_REQUEST_SUCCESS = exports.SCORELEIDA_REQUEST_SUCCESS = 'SCORELEIDA_REQUEST_SUCCESS';
	var SCORELEIDA_REQUEST_FAIL = exports.SCORELEIDA_REQUEST_FAIL = 'SCORELEIDA_REQUEST_FAIL';

	function scoreLeidaRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: SCORELEIDA_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function scoreLeidaRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: SCORELEIDA_REQUEST_FAIL,
	    result: result
	  };
	}

	function getscoreLeidaRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/P2PImage/radarScore.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(scoreLeidaRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(scoreLeidaRequestFail(result));
	      }
	    });
	  };
	}
	/*评分雷达图*/

	var COMPANY_NAME = exports.COMPANY_NAME = 'COMPANY_NAME';
	function companyName(county) {
	  return {
	    type: COMPANY_NAME,
	    county: county
	  };
	}
	function setCompany(county) {
	  return function (dispatch) {
	    return dispatch(companyName(county));
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PPortraitAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 860:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

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
	        var isEqual = Immutable.is(nextProps.businessTypesResult, this.props.businessTypesResult);
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
	                        "unit": "家",
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

/***/ 866:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

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
	      option: [],
	      orderType: "desc", //默认降序
	      orderField: "" //需要排序的字段
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    $('#platformRun-scroll').perfectScrollbar();
	  },
	  componentDidUpdate: function componentDidUpdate() {
	    $('#platformRun-scroll').perfectScrollbar('update');
	  },
	  handleClick: function handleClick(field) {
	    var _dom = $(this.refs[field]),
	        _domAttr = _dom.attr("data-order"),
	        _domIco = _dom.find("em"),
	        _domIcoIs = _dom.find("em").hasClass('icon-desc');
	    _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	    _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	    this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	      var _basedata = BOSS.sort(this.state.option, field, this.state.orderType);
	      this.setState({ option: _basedata });
	    });
	  },
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
	                  { width: '15%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'fundingBusinessTypeCN', onClick: this.handleClick.bind(this, "fundingBusinessTypeCN") },
	                  '业务类型',
	                  _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'successNumber', onClick: this.handleClick.bind(this, "successNumber") },
	                  '成功项目数',
	                  _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                ),
	                _react2.default.createElement(
	                  'th',
	                  { width: '25%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'fundedAmout', onClick: this.handleClick.bind(this, "fundedAmout") },
	                  '已筹基金(万元)',
	                  _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                )
	              )
	            )
	          )
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'table-content', id: 'platformRun-scroll' },
	          _react2.default.createElement(
	            'table',
	            { className: 'mt-table mt-table-center wtyh-table' },
	            _react2.default.createElement(
	              'tbody',
	              null,
	              this.state.option.map(function (item, index) {
	                {

	                  var _successNumber = item.successNumber == undefined ? "/" : item.successNumber;
	                  var _fundedAmout = item.fundedAmout == undefined ? "/" : item.fundedAmout;
	                  var _fundingBusinessTypeCN = item.fundingBusinessTypeCN = undefined ? "/" : item.fundingBusinessTypeCN;
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
	                          { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        _fundingBusinessTypeCN
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        _successNumber
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%' },
	                        _fundedAmout
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
	                          { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                          item.companyName
	                        )
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '15%' },
	                        _fundingBusinessTypeCN
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '20%' },
	                        _successNumber
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        { width: '25%' },
	                        _fundedAmout
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

/***/ 867:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(861);

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
	            option: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        $('#platformBase-scroll').perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#platformBase-scroll').perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.platFormBaseData, this.props.platFormBaseData);
	        if (!isEqual) {
	            var platFormBaseData = nextProps.platFormBaseData;

	            this.setState({ option: platFormBaseData.content });
	        }
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.option, field, this.state.orderType);
	            this.setState({ option: _basedata });
	        });
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
	                                    { width: '15%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'areaName', onClick: this.handleClick.bind(this, "areaName") },
	                                    '注册地',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
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
	                    { className: 'table-content', id: 'platformBase-scroll' },
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
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformBase', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
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
	                                                    { className: 'word-limit-5', 'data-tip': _address, title: _address },
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
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformBase', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
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
	                                                    { className: 'word-limit-5', 'data-tip': _address, title: _address },
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

/***/ 875:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(873);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CapitalAmount = _react2.default.createClass({
		displayName: 'CapitalAmount',

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

				console.log(Data, "====================Data");
				var optionParm = {
					title: "平台交易量走势",
					titleX: "center",
					color: ["#e14340", "#12b5b0"],
					barWidth: 20,
					yAxisName: "亿元",
					unit: ["亿元", "亿元"],
					yFlag: "", //y轴单位
					splitLineShow: false,
					gridBottom: '5%',
					gridTop: '15%',
					gridLeft: '5%',
					gridRight: '5%',
					legend: ["年末典当余额", "注册资本总额"],
					xAxis: Data.xAxisData,
					series: Data.data
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
				{ className: 'mod top-right radius4' },
				_react2.default.createElement(
					'div',
					{ className: 'mod-title' },
					_react2.default.createElement(
						'h3',
						null,
						'上海市年末典当余额及注册资本总额'
					)
				),
				chartBox
			);
		}
	});

	module.exports = CapitalAmount;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CapitalAmount.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 894:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

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
	                        "unit": ["亿元", "亿美元", ""],
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
	                    '上海市融资租赁企业数及注册资本总额'
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

/***/ 898:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市自贸区融资租赁企业占比对比
	var Immutable = __webpack_require__(718);
	var ContrastLeft = _react2.default.createClass({
	    displayName: 'ContrastLeft',

	    getInitialState: function getInitialState() {
	        return {
	            paramContrastLeft: null,
	            TimeSelect: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getContrastLeftnumRequest = this.props.getContrastLeftnumRequest;

	        var jsonData = { 'year': 2016 };
	        getContrastLeftnumRequest(jsonData);

	        var getTimeSelectRequest = this.props.getTimeSelectRequest;

	        var jsonData = {};
	        getTimeSelectRequest(jsonData);
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
	                        "series": [{ value: ContrastLeftNumChartResult.content.inAreaNumber, name: '自贸区' }, { value: ContrastLeftNumChartResult.content.outAreaNumber, name: '非自贸区' }]
	                    };
	                    this.setState({ paramContrastLeft: optionThe });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        //下拉框
	        var isEqual = Immutable.is(nextProps.TimeSelectNumChartRequest, this.props.TimeSelectNumChartResult);
	        if (!isEqual) {
	            var TimeSelectNumChartRequest = nextProps.TimeSelectNumChartRequest;
	            var TimeSelectNumChartResult = nextProps.TimeSelectNumChartResult;

	            if (TimeSelectNumChartRequest == true) {
	                if (TimeSelectNumChartResult.success) {
	                    // $(this.refs.totleCount).html(ContrastCatalogNumChartResult.content.length)
	                    //this.dataFomat({CatalogCentent:ContrastCatalogNumChartResult}) 
	                    this.dataCatalogSelect(TimeSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        //console.log("jifei++++++++++",data.content)
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("123456789",selectVar)
	        this.setState({ TimeSelect: selectVar });
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
	            value: this.state.selectVar,
	            placeholder: '2016',
	            name: 'testselect',
	            data: this.state.TimeSelect,
	            onChange: function (value, label) {
	                // console.log('当前值为：', value);
	                this.selectValue(label);
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
	                _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelectedTime' }))
	            )
	        );
	    }
	});
	module.exports = ContrastLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContrastLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 899:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//上海市自贸区融资租赁企业占比对比
	var Immutable = __webpack_require__(718);
	var ContrastRight = _react2.default.createClass({
	    displayName: 'ContrastRight',

	    getInitialState: function getInitialState() {
	        return {
	            paramContrastRight: null,
	            TimeSelectVal: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getContrastRightnumRequest = this.props.getContrastRightnumRequest;

	        var jsonData = { 'year': 2016 };
	        getContrastRightnumRequest(jsonData);

	        var getTimeSelectRequest = this.props.getTimeSelectRequest;

	        var jsonData = {};
	        getTimeSelectRequest(jsonData);
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
	                        "series": [{ value: ContrastRightNumChartResult.content.inAreaNumber, name: '自贸区' }, { value: ContrastRightNumChartResult.content.outAreaNumber, name: '非自贸区' }]
	                    };
	                    this.setState({ paramContrastRight: optionThes });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        //下拉框
	        var isEqual = Immutable.is(nextProps.TimeSelectNumChartRequest, this.props.TimeSelectNumChartResult);
	        if (!isEqual) {
	            var TimeSelectNumChartRequest = nextProps.TimeSelectNumChartRequest;
	            var TimeSelectNumChartResult = nextProps.TimeSelectNumChartResult;

	            if (TimeSelectNumChartRequest == true) {
	                if (TimeSelectNumChartResult.success) {
	                    // $(this.refs.totleCount).html(ContrastCatalogNumChartResult.content.length)
	                    //this.dataFomat({CatalogCentent:ContrastCatalogNumChartResult}) 
	                    this.dataCatalogSelect(TimeSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        //console.log("jifei++++++++++",data.content)
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("qqqqqqqqqqqqqqqqqqqqqq",selectVar)
	        this.setState({ TimeSelectVal: selectVar });
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
	            value: this.state.selectVar,
	            placeholder: '2016',
	            name: 'testselect',
	            data: this.state.TimeSelectVal,
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);           
	                this.selectValue(label);
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
	                _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelectedTimes' }))
	            )
	        );
	    }
	});
	module.exports = ContrastRight;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ContrastRight.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 902:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(903);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _commercialSecretIndexAction = __webpack_require__(905);

	var CommercialSecretIndexActionCreaters = _interopRequireWildcard(_commercialSecretIndexAction);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyNum = __webpack_require__(906);

	var _CompanyNum2 = _interopRequireDefault(_CompanyNum);

	var _CompanyAmount = __webpack_require__(909);

	var _CompanyAmount2 = _interopRequireDefault(_CompanyAmount);

	var _BusinessNum = __webpack_require__(910);

	var _BusinessNum2 = _interopRequireDefault(_BusinessNum);

	var _Balance = __webpack_require__(911);

	var _Balance2 = _interopRequireDefault(_Balance);

	var _CompanyDirectory = __webpack_require__(912);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//商业保理企业名单

	//国内商业保理和国际商业保理业务额
	//在沪商业保理企业数量
	var Immutable = __webpack_require__(718);
	//商业保理
	//全市商业保理业务总额及融资余额
	//全市商业保理企业资产总额(注册资本)

	var CommercialSecret = _react2.default.createClass({
	  displayName: 'CommercialSecret',

	  mixins: [_setHeight2.default],
	  getInitialState: function getInitialState() {
	    return {
	      CompanyNumData: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getCompanynumRequest = this.props.getCompanynumRequest;

	    var jsonData = {};
	    getCompanynumRequest(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.CompanyNumChartRequest, this.props.CompanyNumChartResult);
	    if (!isEqual) {
	      var CompanyNumChartRequest = nextProps.CompanyNumChartRequest;
	      var CompanyNumChartResult = nextProps.CompanyNumChartResult;

	      if (CompanyNumChartRequest == true) {
	        if (CompanyNumChartResult.success) {
	          this.setState({ CompanyNumData: CompanyNumChartResult.content });
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  handleFunction: function handleFunction(searchVal) {
	    console.log(searchVal, "================搜索词语============================");
	    this.props.history.push('/SearchResultDetail?platName=' + searchVal);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'commercialS-index', style: this.state.style },
	      _react2.default.createElement(_IndustrySearch2.default, { label: '商业保理监测', searchFun: this.handleFunction, companyType: '10', placeholder: '请输入企业名称检索' }),
	      _react2.default.createElement(
	        'div',
	        { className: 'content clearfix' },
	        _react2.default.createElement(
	          'div',
	          { className: 'pawnM-top clearfix' },
	          _react2.default.createElement(_CompanyNum2.default, { CompanyNumData: this.state.CompanyNumData }),
	          _react2.default.createElement(_CompanyAmount2.default, { CompanyAmountData: this.state.CompanyNumData })
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'pawnM-Middle clearfix' },
	          _react2.default.createElement(_BusinessNum2.default, this.props),
	          _react2.default.createElement(_Balance2.default, this.props)
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
	// module.exports = CommercialSecret;

	//将 request  result 绑定到props的request result
	function CommercialSecretStateToProps(state) {
	  return {

	    CompanyNumChartRequest: state.ChartAll.request,
	    CompanyNumChartResult: state.ChartAll.result,
	    //企业类型分布
	    BusinessNumChartRequest: state.businessnumChart.request,
	    BusinessNumChartResult: state.businessnumChart.result,
	    //商业保理地域分布
	    balanceRequest: state.balanceChart.request,
	    balanceResult: state.balanceChart.result,
	    //商业保理企业名单
	    CompanyDirectoryRequest: state.CompanyDirectoryChart.request,
	    CompanyDirectoryResult: state.CompanyDirectoryChart.result
	  };
	}

	//将action的所有方法绑定到props上
	function CommercialSecretDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(CommercialSecretIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(CommercialSecretStateToProps, CommercialSecretDispatchToProps)(CommercialSecret);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 912:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(907);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var innerdata = [];
	var outerdata = [];
	var CompanyDirectory = _react2.default.createClass({
	    displayName: 'CompanyDirectory',
	    getInitialState: function getInitialState() {
	        return {
	            CompanyDirectoryData: [],
	            selected: 1,
	            selectedData: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },

	    //排序
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.selectedData, field, this.state.orderType);
	            this.setState({ selectedData: _basedata });
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getCompanyDirectoryRequest = this.props.getCompanyDirectoryRequest;

	        var jsonData = {};
	        getCompanyDirectoryRequest(jsonData);
	        //滚动条
	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    //滚动条
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.CompanyDirectoryRequest, this.props.CompanyDirectoryResult);
	        if (!isEqual) {
	            var CompanyDirectoryRequest = nextProps.CompanyDirectoryRequest;
	            var CompanyDirectoryResult = nextProps.CompanyDirectoryResult;

	            if (CompanyDirectoryRequest == true) {
	                if (CompanyDirectoryResult.success) {
	                    for (var i = 0; i < CompanyDirectoryResult.content.length; i++) {
	                        if (CompanyDirectoryResult.content[i].isForeign == "内资") innerdata.push(CompanyDirectoryResult.content[i]);else outerdata.push(CompanyDirectoryResult.content[i]);
	                    }
	                    this.setState({
	                        CompanyDirectoryData: CompanyDirectoryResult.content,
	                        selectedData: CompanyDirectoryResult.content
	                    });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    quarterChoice: function quarterChoice(value) {
	        var CompanyDirectoryDatas = this.state.CompanyDirectoryData;
	        switch (value) {
	            case 2:
	                //内资
	                this.setState({
	                    selectedData: innerdata
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	            case 3:
	                //外资
	                this.setState({
	                    selectedData: outerdata
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	            default:
	                this.setState({
	                    selectedData: CompanyDirectoryDatas
	                }, function () {
	                    $("#platformBase-scroll").scrollTop(0);
	                });
	                break;
	        }
	    },
	    render: function render() {
	        var selectQuarter = {
	            width: '75px',
	            className: 'company-dire',
	            name: 'testselect',
	            value: "1",
	            id: 'selectType',
	            data: [{ value: '1', label: '全部' }, { value: '2', label: '内资' }, { value: '3', label: '外资' }],
	            onChange: function (value, label) {
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod right-bottom radius4 modLong' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '商业保理企业名单'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'totle-num' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { className: 'orange' },
	                        ' ',
	                        this.state.selectedData.length,
	                        ' '
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
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%' },
	                                    '企业类型',
	                                    _react2.default.createElement(_index.Selected, selectQuarter)
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '注册地址'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '15%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'registeredCapital', onClick: this.handleClick.bind(this, "registeredCapital") },
	                                    '注册资本',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'platformBase-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.selectedData.map(function (item, index) {
	                                var _address = item.address == null ? "/" : item.address;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index, className: 'even' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '10%', className: 'talign-center' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            ' ',
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            item.isForeign
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '30%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5 long', 'data-tip': _address, title: _address },
	                                                _address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '15%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', title: '' },
	                                                item.registeredCapital,
	                                                '万元'
	                                            )
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index, className: 'odd' },
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '10%', className: 'talign-center' },
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '25%' },
	                                            ' ',
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: '/SearchResultDetail', query: { formpage: 'platformRun', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                item.companyName
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '20%' },
	                                            item.isForeign
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '30%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5 long', 'data-tip': _address, title: _address },
	                                                _address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            { width: '15%' },
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'word-limit-5', title: '' },
	                                                item.registeredCapital,
	                                                '万元'
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

	module.exports = CompanyDirectory;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyDirectory.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})