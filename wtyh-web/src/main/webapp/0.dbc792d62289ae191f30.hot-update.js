webpackHotUpdate(0,{

/***/ 945:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(943);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _AssociationGraph = __webpack_require__(946);

	var _AssociationGraph2 = _interopRequireDefault(_AssociationGraph);

	var _CompanyInfo = __webpack_require__(949);

	var _CompanyInfo2 = _interopRequireDefault(_CompanyInfo);

	var _CompanyNews = __webpack_require__(950);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _CompanyDetail = __webpack_require__(951);

	var _CompanyDetail2 = _interopRequireDefault(_CompanyDetail);

	var _InfoSearchAction = __webpack_require__(964);

	var InfoSearchAction = _interopRequireWildcard(_InfoSearchAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var SearchResultDetail = _react2.default.createClass({
	    displayName: 'SearchResultDetail',

	    pageScroll: function pageScroll() {
	        $('html, body').animate({ scrollTop: 0 }, 'slow');
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { id: 'search-result-detail' },
	            _react2.default.createElement(
	                'div',
	                { className: 'company-name' },
	                _react2.default.createElement(
	                    'span',
	                    null,
	                    '上海明成投资有限公司'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'btn' },
	                    '存续'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'right-content' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'search-group' },
	                        _react2.default.createElement('input', { type: 'text', placeholder: '请输入企业名称检索' }),
	                        _react2.default.createElement(
	                            'a',
	                            { href: '#', className: 'search' },
	                            _react2.default.createElement('i', { className: 'iconfont icon-search' })
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'back-btn' },
	                        _react2.default.createElement('i', { className: 'iconfont icon-fanhui fanhui' }),
	                        '返回'
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'company-detail clear-fix' },
	                _react2.default.createElement(_AssociationGraph2.default, this.props),
	                _react2.default.createElement(_CompanyInfo2.default, this.props),
	                _react2.default.createElement(_CompanyNews2.default, this.props),
	                _react2.default.createElement(_CompanyDetail2.default, this.props)
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'back-top', onClick: this.pageScroll },
	                _react2.default.createElement('i', { className: 'iconfont icon-top' })
	            )
	        );
	    }
	});

	//将 request  result 绑定到props的request result
	/*
	 *Create by yq
	 */
	function mapStateToProps(state) {
	    return {
	        //title
	        CompanyInfoTitResult: state.CompanyInfoTit.result,
	        CompanyInfoTitRequest: state.CompanyInfoTit.request,

	        //舆情
	        CompanyInfoNewsResult: state.CompanyInfoNews.result,
	        CompanyInfoNewsRequest: state.CompanyInfoNews.request,

	        //表格A
	        CompanyInfoAResult: state.CompanyInfoA.result,
	        CompanyInfoARequest: state.CompanyInfoA.request,

	        CompanyPicResult: state.CompanyPic.result,
	        CompanyPicRequest: state.CompanyPic.request,

	        //表格B
	        CompanyInfoBResult: state.CompanyInfoB.result,
	        CompanyInfoBRequest: state.CompanyInfoB.request,

	        //诉讼记录5个ajax
	        CompanyInfoC1Result: state.CompanyInfoC1.result,
	        CompanyInfoC1Request: state.CompanyInfoC1.request,

	        CompanyInfoC2Result: state.CompanyInfoC2.result,
	        CompanyInfoC2Request: state.CompanyInfoC2.request,

	        CompanyInfoC3Result: state.CompanyInfoC3.result,
	        CompanyInfoC3Request: state.CompanyInfoC3.request,

	        CompanyInfoC4Result: state.CompanyInfoC4.result,
	        CompanyInfoC4Request: state.CompanyInfoC4.request,

	        CompanyInfoC5Result: state.CompanyInfoC5.result,
	        CompanyInfoC5Request: state.CompanyInfoC5.request,

	        //三个echarts图的ajax
	        CompanyInfoD1Request: state.CompanyInfoD1.request,
	        CompanyInfoD1Result: state.CompanyInfoD1.result,

	        CompanyInfoD2Request: state.CompanyInfoD2.request,
	        CompanyInfoD2Result: state.CompanyInfoD2.result,

	        CompanyInfoD3Request: state.CompanyInfoD3.request,
	        CompanyInfoD3Result: state.CompanyInfoD3.result

	    };
	}

	//将action的所有方法绑定到props上ss
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(InfoSearchAction, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(SearchResultDetail);

	// (function(){
	// 	switch(self.state.pageNum){
	// 		case 1:
	// 			return (<Announcement {...this.props}></Announcement>)
	// 		break;
	// 		case 2:
	// 			return (<RefereeDocuments ...{this.props}></RefereeDocuments>)
	// 		break;
	// 		case 3:
	// 			return (<Executor {...this.props}></Executor>)
	// 		break;
	// 		case 4:
	// 			return (<BrokenPromises {...this.props}></BrokenPromises>)
	// 		break;
	// 		case 5:
	// 			return (<CourtAnnouncement {...this.props}></CourtAnnouncement>)
	// 		break;
	// 	}
	// })()

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchResultDetail.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})