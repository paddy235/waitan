webpackHotUpdate(0,{

/***/ 1345:
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
	      url: " /hologram/businessInfo.do",
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

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "InfoSearchAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})