webpackHotUpdate(0,{

/***/ 983:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getRealTimeTable = getRealTimeTable;
	exports.getRealTimeNine = getRealTimeNine;
	exports.getRealTimeNews = getRealTimeNews;
	exports.getRealTimeMap = getRealTimeMap;
	exports.getRealTimeMapSh = getRealTimeMapSh;
	exports.getRealTimeRisk = getRealTimeRisk;
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
	      url: "/realTimeMonitor/spectrumAnalysis.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
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
	      url: "/offlineFinance/businessChartShow.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeNineSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeNineFail(result));
	      }
	    });
	  };
	}

	/*
	  实时监测右下角的舆情模块
	*/
	var REALTIME_NEWS_SUCCESS = exports.REALTIME_NEWS_SUCCESS = 'REALTIME_NEWS_SUCCESS';
	var REALTIME_NEWS_FAIL = exports.REALTIME_NEWS_FAIL = 'REALTIME_NEWS_FAIL';

	function RealTimeNewsSuccess(result) {
	  //请求成功调用方法 保存成功的数据
	  return {
	    type: REALTIME_NEWS_SUCCESS,
	    result: result
	  };
	}
	function RealTimeNewsFail(result) {
	  //请求失败调用方法  保存了失败的数据
	  return {
	    type: REALTIME_NEWS_FAIL,
	    result: result
	  };
	}

	//最开始触发redux流程的导火线。
	function getRealTimeNews(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/companyNews/getCompanyNews.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeNewsSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeNewsFail(result));
	      }
	    });
	  };
	}

	/*
	  中国地图
	*/
	var REALTIME_MAP_SUCCESS = exports.REALTIME_MAP_SUCCESS = 'REALTIME_MAP_SUCCESS';
	var REALTIME_MAP_FAIL = exports.REALTIME_MAP_FAIL = 'REALTIME_MAP_FAIL';

	function RealTimeMapSuccess(result) {
	  //请求成功调用方法 保存成功的数据
	  return {
	    type: REALTIME_MAP_SUCCESS,
	    result: result
	  };
	}
	function RealTimeMapFail(result) {
	  //请求失败调用方法  保存了失败的数据
	  return {
	    type: REALTIME_MAP_FAIL,
	    result: result
	  };
	}

	//最开始触发redux流程的导火线。
	function getRealTimeMap(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/realTimeMonitor/ChinaMap.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeMapSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeMapFail(result));
	      }
	    });
	  };
	}

	/*
	  上海地图
	*/
	var REALTIME_MAPsh_SUCCESS = exports.REALTIME_MAPsh_SUCCESS = 'REALTIME_MAPsh_SUCCESS';
	var REALTIME_MAPsh_FAIL = exports.REALTIME_MAPsh_FAIL = 'REALTIME_MAPsh_FAIL';

	function RealTimeMapShSuccess(result) {
	  //请求成功调用方法 保存成功的数据
	  return {
	    type: REALTIME_MAPsh_SUCCESS,
	    result: result
	  };
	}
	function RealTimeMapShFail(result) {
	  //请求失败调用方法  保存了失败的数据
	  return {
	    type: REALTIME_MAPsh_FAIL,
	    result: result
	  };
	}

	//最开始触发redux流程的导火线。
	function getRealTimeMapSh(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/realTimeMonitor/shMap.do", //"/data/industryMonitor/smallLoan/index/companyGrade.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeMapShSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeMapShFail(result));
	      }
	    });
	  };
	}

	REALTIME_RISK_FAIL;
	RealTimeRiskSuccess;
	/* 
	  线下理财分布=
	*/
	var REALTIME_RISK_SUCCESS = exports.REALTIME_RISK_SUCCESS = 'REALTIME_RISK_SUCCESS';
	var REALTIME_RISK_FAIL = exports.REALTIME_RISK_FAIL = 'REALTIME_RISK_FAIL';

	function RealTimeRiskSuccess(result) {
	  //请求成功调用方法
	  console.log(result, 444444555555555);
	  return {
	    type: REALTIME_RISK_SUCCESS,
	    result: result
	  };
	}
	function RealTimeRiskFail(result) {
	  //请求失败调用方法
	  return {
	    type: REALTIME_RISK_FAIL,
	    result: result
	  };
	}

	function getRealTimeRisk(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/risk/getScanner.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(RealTimeRiskSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(RealTimeRiskFail(result));
	      }
	    });
	  };
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RealTimeAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})