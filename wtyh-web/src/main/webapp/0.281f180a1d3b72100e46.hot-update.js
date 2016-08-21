webpackHotUpdate(0,{

/***/ 726:
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
	                    _react2.default.createElement('p', { className: 'homeScrollA iconfont icon-xiangshang' }),
	                    _react2.default.createElement(
	                        'p',
	                        null,
	                        '数据分析'
	                    )
	                ),
	                _react2.default.createElement(
	                    'li',
	                    { className: '' },
	                    _react2.default.createElement('p', { className: 'homeScrollB iconfont icon-xiangshang' }),
	                    _react2.default.createElement(
	                        'p',
	                        null,
	                        '企业数量'
	                    )
	                ),
	                _react2.default.createElement(
	                    'li',
	                    { className: '' },
	                    _react2.default.createElement('p', { className: 'homeScrollC iconfont icon-xiangshang' }),
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

/***/ }

})