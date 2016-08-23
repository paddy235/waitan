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
					_react2.default.createElement(_AssociationGraph2.default, null),
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
			CompanyInfoTitResult: state.CompanyInfoTit.result,
			CompanyInfoTitRequest: state.CompanyInfoTit.request,

			CompanyInfoNewsResult: state.CompanyInfoNews.result,
			CompanyInfoNewsRequest: state.CompanyInfoNews.request,

			CompanyInfoAResult: state.CompanyInfoA.result,
			CompanyInfoARequest: state.CompanyInfoA.request,

			CompanyInfoBResult: state.CompanyInfoB.result,
			CompanyInfoBRequest: state.CompanyInfoB.request

			//诉讼记录5个ajax

			//三个echarts图的ajax

		};
	}

	//将action的所有方法绑定到props上
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

/***/ },

/***/ 954:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _Announcement = __webpack_require__(955);

	var _Announcement2 = _interopRequireDefault(_Announcement);

	var _RefereeDocuments = __webpack_require__(956);

	var _RefereeDocuments2 = _interopRequireDefault(_RefereeDocuments);

	var _Executor = __webpack_require__(957);

	var _Executor2 = _interopRequireDefault(_Executor);

	var _BrokenPromises = __webpack_require__(958);

	var _BrokenPromises2 = _interopRequireDefault(_BrokenPromises);

	var _CourtAnnouncement = __webpack_require__(959);

	var _CourtAnnouncement2 = _interopRequireDefault(_CourtAnnouncement);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var ControlRecord = _react2.default.createClass({
		displayName: 'ControlRecord',
		getInitialState: function getInitialState() {
			return {
				pageNum: 1
			};
		},
		switchPage: function switchPage(param, ev) {
			$(".title-item").removeClass('title-active');
			$(ev.target).addClass('title-active');
			var _pageNum;
			switch (param) {
				case 'announcement':
					_pageNum = 1;
					break;
				case 'referee-documents':
					_pageNum = 2;
					break;
				case 'executor':
					_pageNum = 3;
					break;
				case 'broken-promises':
					_pageNum = 4;
					break;
				case 'court-announcement':
					_pageNum = 5;
					break;
			}
			this.setState({
				pageNum: _pageNum
			});
		},
		render: function render() {
			var self = this;
			return _react2.default.createElement(
				'div',
				{ className: 'control-record' },
				_react2.default.createElement(
					'div',
					{ className: 'control-title' },
					_react2.default.createElement(
						'div',
						{ className: 'title-item title-active', onClick: this.switchPage.bind(this, 'announcement') },
						'开庭公告'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'referee-documents') },
						'裁判文书'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'executor') },
						'被执行人'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'broken-promises') },
						'失信被执行人'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'court-announcement') },
						'法院公告'
					)
				),
				function () {
					switch (self.state.pageNum) {
						case 1:
							return _react2.default.createElement(_Announcement2.default, this.props);
							break;
						case 2:
							return _react2.default.createElement(_RefereeDocuments2.default, this.props);
							break;
						case 3:
							return _react2.default.createElement(_Executor2.default, this.props);
							break;
						case 4:
							return _react2.default.createElement(_BrokenPromises2.default, this.props);
							break;
						case 5:
							return _react2.default.createElement(_CourtAnnouncement2.default, this.props);
							break;
					}
				}()
			);
		}
	}); /**
	     * 诉控记录
	     */

	exports.default = ControlRecord;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ControlRecord.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 964:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getCompanyInfoTit = getCompanyInfoTit;
	exports.getCompanyInfoNews = getCompanyInfoNews;
	exports.getCompanyInfoA = getCompanyInfoA;
	exports.getCompanyInfoB = getCompanyInfoB;
	exports.getCompanyInfoC1 = getCompanyInfoC1;
	exports.getCompanyInfoC2 = getCompanyInfoC2;
	exports.getCompanyInfoC3 = getCompanyInfoC3;
	exports.getCompanyInfoC4 = getCompanyInfoC4;
	exports.getCompanyInfoC5 = getCompanyInfoC5;
	/*
	  企业全息查询action
	*/

	//企业概要信息
	var COMPANYINFO_TIT_SUCCESS = exports.COMPANYINFO_TIT_SUCCESS = 'COMPANYINFO_TIT_SUCCESS';
	var COMPANYINFO_TIT_FAIL = exports.COMPANYINFO_TIT_FAIL = 'COMPANYINFO_TIT_FAIL';

	function companyInfoTitSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_TIT_SUCCESS,
	    result: result
	  };
	}

	function companyInfoTitFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_TIT_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoTit(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: " /hologram/outlineMsg.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoTitSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoTitFail(result));
	      }
	    });
	  };
	}

	//舆情
	var COMPANYINFO_NEWS_SUCCESS = exports.COMPANYINFO_NEWS_SUCCESS = 'COMPANYINFO_NEWS_SUCCESS';
	var COMPANYINFO_NEWS_FAIL = exports.COMPANYINFO_NEWS_FAIL = 'COMPANYINFO_NEWS_FAIL';

	function companyInfoNewsSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_NEWS_SUCCESS,
	    result: result
	  };
	}

	function companyInfoNewsFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_NEWS_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoNews(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: " /hologram/newsConsensus.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoNewsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoNewsFail(result));
	      }
	    });
	  };
	}

	//表格A
	var COMPANYINFO_A_SUCCESS = exports.COMPANYINFO_A_SUCCESS = 'COMPANYINFO_A_SUCCESS';
	var COMPANYINFO_A_FAIL = exports.COMPANYINFO_A_FAIL = 'COMPANYINFO_A_FAIL';

	function companyInfoASuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_A_SUCCESS,
	    result: result
	  };
	}

	function companyInfoAFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_A_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoA(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: " /hologram/businessInfo.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoASuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoAFail(result));
	      }
	    });
	  };
	}

	//表格B
	var COMPANYINFO_B_SUCCESS = exports.COMPANYINFO_B_SUCCESS = 'COMPANYINFO_B_SUCCESS';
	var COMPANYINFO_B_FAIL = exports.COMPANYINFO_B_FAIL = 'COMPANYINFO_B_FAIL';

	function companyInfoBSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_B_SUCCESS,
	    result: result
	  };
	}

	function companyInfoBFail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_B_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoB(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoBSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoFail(result));
	      }
	    });
	  };
	}

	/*===============================诉讼记录================================*/

	//开庭公告
	var COMPANYINFO_C1_SUCCESS = exports.COMPANYINFO_C1_SUCCESS = 'COMPANYINFO_C1_SUCCESS';
	var COMPANYINFO_C1_FAIL = exports.COMPANYINFO_C1_FAIL = 'COMPANYINFO_C1_FAIL';

	function companyInfoC1Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_C1_SUCCESS,
	    result: result
	  };
	}

	function companyInfoC1Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_C1_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoC1(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoC1Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoC1Fail(result));
	      }
	    });
	  };
	}

	//裁判文书
	var COMPANYINFO_C2_SUCCESS = exports.COMPANYINFO_C2_SUCCESS = 'COMPANYINFO_C2_SUCCESS';
	var COMPANYINFO_C2_FAIL = exports.COMPANYINFO_C2_FAIL = 'COMPANYINFO_C2_FAIL';

	function companyInfoC2Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_C2_SUCCESS,
	    result: result
	  };
	}

	function companyInfoC2Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_C2_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoC2(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoC2Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoC2Fail(result));
	      }
	    });
	  };
	}

	//被执行人
	var COMPANYINFO_C3_SUCCESS = exports.COMPANYINFO_C3_SUCCESS = 'COMPANYINFO_C3_SUCCESS';
	var COMPANYINFO_C3_FAIL = exports.COMPANYINFO_C3_FAIL = 'COMPANYINFO_C3_FAIL';

	function companyInfoC3Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_C3_SUCCESS,
	    result: result
	  };
	}

	function companyInfoC3Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_C3_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoC3(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoC3Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoC3Fail(result));
	      }
	    });
	  };
	}

	//失信执行人
	var COMPANYINFO_C4_SUCCESS = exports.COMPANYINFO_C4_SUCCESS = 'COMPANYINFO_C4_SUCCESS';
	var COMPANYINFO_C4_FAIL = exports.COMPANYINFO_C4_FAIL = 'COMPANYINFO_C4_FAIL';

	function companyInfoC4Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_C4_SUCCESS,
	    result: result
	  };
	}

	function companyInfoC4Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_C4_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoC4(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoC4Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoC4Fail(result));
	      }
	    });
	  };
	}

	//法院公告
	var COMPANYINFO_C5_SUCCESS = exports.COMPANYINFO_C5_SUCCESS = 'COMPANYINFO_C5_SUCCESS';
	var COMPANYINFO_C5_FAIL = exports.COMPANYINFO_C5_FAIL = 'COMPANYINFO_C5_FAIL';

	function companyInfoC5Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_C5_SUCCESS,
	    result: result
	  };
	}

	function companyInfoC5Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_C5_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoC5(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: " /hologram/shareholdersSenior.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoC5Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoC5Fail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InfoSearchAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})