webpackHotUpdate(0,{

/***/ 1329:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	exports.default = realTimeMap;

	var _RealTimeAction = __webpack_require__(1291);

	//这个函数就是处理，action里面成功和失败的2个返回函数。
	//当ajax请求成功了，就可以调用这个两个返回函数进行操作。

	function realTimeMap() {
		var state = arguments.length <= 0 || arguments[0] === undefined ? { //这个名字无所谓，最后都是用index里面对外暴露的名字。
			request: false,
			result: {}
		} : arguments[0];
		var action = arguments[1];

		switch (action.type) {
			case _RealTimeAction.REALTIME_MAP_SUCCESS:
				//请求成功！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			case _RealTimeAction.REALTIME_MAP_FAIL:
				//请求失败！
				return Object.assign({}, state, {
					request: true,
					result: action.result
				});
			default:
				return state;
		}
	}

	//（默认的2个值，根据判断action返回的两个值）
	// 这个reducer就是从action里面抽离出来的数据的状态机

	// request、result

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "realtimeMapReducer.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})