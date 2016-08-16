webpackHotUpdate(0,{

/***/ 819:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getDevTrendRequest = getDevTrendRequest;
	exports.getvolumeRequest = getvolumeRequest;
	exports.getMapRequest = getMapRequest;
	exports.getAreaRankRequest = getAreaRankRequest;
	exports.getNetCreditRequest = getNetCreditRequest;
	exports.getProblemScaleRequest = getProblemScaleRequest;
	exports.getIndustrySRequest = getIndustrySRequest;
	exports.getNetCreditConCRequest = getNetCreditConCRequest;
	/*
	 P2P平台监测
	*/

	/*上海新增平台发展趋势begin*/
	var DEVTREND_REQUEST_SUCCESS = exports.DEVTREND_REQUEST_SUCCESS = 'DEVTREND_REQUEST_SUCCESS';
	var DEVTREND_REQUEST_FAIL = exports.DEVTREND_REQUEST_FAIL = 'DEVTREND_REQUEST_FAIL';

	function devTrendRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DEVTREND_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function devTrendRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: DEVTREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getDevTrendRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(devTrendRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(devTrendRequestFail(result));
	      }
	    });
	  };
	}
	/*上海新增平台发展趋势end*/

	/*成交量和综合利率begin*/
	var VOLUME_REQUEST_SUCCESS = exports.VOLUME_REQUEST_SUCCESS = 'VOLUME_REQUEST_SUCCESS';
	var VOLUME_REQUEST_FAIL = exports.VOLUME_REQUEST_FAIL = 'VOLUME_REQUEST_FAIL';

	function volumeRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: VOLUME_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function volumeRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: DEVTREND_REQUEST_FAIL,
	    result: result
	  };
	}

	function getvolumeRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(volumeRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(volumeRequestFail(result));
	      }
	    });
	  };
	}
	/*成交量和综合利率end*/

	/*地图begin*/
	var MAP_REQUEST_SUCCESS = exports.MAP_REQUEST_SUCCESS = 'MAP_REQUEST_SUCCESS';
	var MAP_REQUEST_FAIL = exports.MAP_REQUEST_FAIL = 'MAP_REQUEST_FAIL';

	function mapRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: MAP_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function mapRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: MAP_REQUEST_FAIL,
	    result: result
	  };
	}

	function getMapRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(mapRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(mapRequestFail(result));
	      }
	    });
	  };
	}
	/*地图end*/

	/*  上海区域发展指数排名begin*/
	var AREARANK_REQUEST_SUCCESS = exports.AREARANK_REQUEST_SUCCESS = 'AREARANK_REQUEST_SUCCESS';
	var AREARANK_REQUEST_FAIL = exports.AREARANK_REQUEST_FAIL = 'AREARANK_REQUEST_FAIL';

	function areaRankRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: AREARANK_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function areaRankRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: AREARANK_REQUEST_FAIL,
	    result: result
	  };
	}

	function getAreaRankRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/areaIndex.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(areaRankRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(areaRankRequestFail(result));
	      }
	    });
	  };
	}
	/*上海区域发展指数排名end


	/*  网贷平台数据展示begin*/
	var NETCREDIT_REQUEST_SUCCESS = exports.NETCREDIT_REQUEST_SUCCESS = 'NETCREDIT_REQUEST_SUCCESS';
	var NETCREDIT_REQUEST_FAIL = exports.NETCREDIT_REQUEST_FAIL = 'NETCREDIT_REQUEST_FAIL';

	function netCreditRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NETCREDIT_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function netCreditRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NETCREDIT_REQUEST_FAIL,
	    result: result
	  };
	}

	function getNetCreditRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/PToPMonitor/platRankData.do",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(netCreditRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(netCreditRequestFail(result));
	      }
	    });
	  };
	}
	/*网贷平台数据展示end*/

	/*  问题平台比例begin*/
	var PROBLEMSCALE_REQUEST_SUCCESS = exports.PROBLEMSCALE_REQUEST_SUCCESS = 'PROBLEMSCALE_REQUEST_SUCCESS';
	var PROBLEMSCALE_REQUEST_FAIL = exports.PROBLEMSCALE_REQUEST_FAIL = 'PROBLEMSCALE_REQUEST_FAIL';

	function problemScaleRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: PROBLEMSCALE_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function problemScaleRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: PROBLEMSCALE_REQUEST_FAIL,
	    result: result
	  };
	}

	function getProblemScaleRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(problemScaleRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(problemScaleRequestFail(result));
	      }
	    });
	  };
	}
	/*问题平台比例end*/

	/*行业人气 begin*/
	var INDUSTRYS_REQUEST_SUCCESS = exports.INDUSTRYS_REQUEST_SUCCESS = 'INDUSTRYS_REQUEST_SUCCESS';
	var INDUSTRYS_REQUEST_FAIL = exports.INDUSTRYS_REQUEST_FAIL = 'INDUSTRYS_REQUEST_FAIL';

	function industrySRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: INDUSTRYS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function industrySRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: INDUSTRYS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getIndustrySRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(industrySRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(industrySRequestFail(result));
	      }
	    });
	  };
	}
	/*行业人气 end*/

	/*网贷对比 begin*/
	var NETCREDITCON_REQUEST_SUCCESS = exports.NETCREDITCON_REQUEST_SUCCESS = 'NETCREDITCON_REQUEST_SUCCESS';
	var NETCREDITCON_REQUEST_FAIL = exports.NETCREDITCON_REQUEST_FAIL = 'NETCREDITCON_REQUEST_FAIL';

	function netCreditConRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: NETCREDITCON_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function netCreditConRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: NETCREDITCON_REQUEST_FAIL,
	    result: result
	  };
	}

	function getNetCreditConCRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/data/industryMonitor/p2p/index/devTrend.json",
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(netCreditConRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(netCreditConRequestFail(result));
	      }
	    });
	  };
	}
	/*网贷对比 end*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "P2PIndexAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})