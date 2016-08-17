webpackHotUpdate(0,{

/***/ 959:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getRealTimeTable = getRealTimeTable;
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
	/*企业评级end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "RealTimeTableAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})