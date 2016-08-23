webpackHotUpdate(0,{

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
	exports.getCompanyInfoD1 = getCompanyInfoD1;
	exports.getCompanyInfoD2 = getCompanyInfoD2;
	exports.getCompanyInfoD3 = getCompanyInfoD3;
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
	      url: "/hologram/openCourtAnnouncement.do",
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
	      url: "/hologram/judgeDoc.do",
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
	      url: " /hologram/debtor.do",
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
	      url: " /hologram/noCreditDebtor.do",
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
	      url: "/hologram/courtAnnouncement.do",
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
	//PersonIndexChart  PersonIndexPie  PayIndexBar

	//招聘人数指数
	var COMPANYINFO_D1_SUCCESS = exports.COMPANYINFO_D1_SUCCESS = 'COMPANYINFO_D1_SUCCESS';
	var COMPANYINFO_D1_FAIL = exports.COMPANYINFO_D1_FAIL = 'COMPANYINFO_D1_FAIL';

	function companyInfoD1Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_D1_SUCCESS,
	    result: result
	  };
	}

	function companyInfoD1Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_D1_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoD1(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/hologram/recruitPeopleNumber.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoD1Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoD1Fail(result));
	      }
	    });
	  };
	}

	//招聘人数 （分布）
	var COMPANYINFO_D2_SUCCESS = exports.COMPANYINFO_D2_SUCCESS = 'COMPANYINFO_D2_SUCCESS';
	var COMPANYINFO_D2_FAIL = exports.COMPANYINFO_D2_FAIL = 'COMPANYINFO_D2_FAIL';

	function companyInfoD2Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_D2_SUCCESS,
	    result: result
	  };
	}

	function companyInfoD2Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_D2_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoD2(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/hologram/recruitPeopleDistribute.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoD2Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoD2Fail(result));
	      }
	    });
	  };
	}

	//薪酬分布
	var COMPANYINFO_D3_SUCCESS = exports.COMPANYINFO_D3_SUCCESS = 'COMPANYINFO_D3_SUCCESS';
	var COMPANYINFO_D3_FAIL = exports.COMPANYINFO_D3_FAIL = 'COMPANYINFO_D3_FAIL';

	function companyInfoD3Success(result) {
	  //请求成功调用方法
	  return {
	    type: COMPANYINFO_D3_SUCCESS,
	    result: result
	  };
	}

	function companyInfoD3Fail(result) {
	  //请求失败调用方法
	  return {
	    type: COMPANYINFO_D3_FAIL,
	    result: result
	  };
	}

	function getCompanyInfoD3(json) {
	  return function (dispatch) {
	    $.ajax({
	      url: "/hologram/courtAnnouncement.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(companyInfoD3Success(result));
	      },
	      error: function error(result) {
	        return dispatch(companyInfoD3Fail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InfoSearchAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})