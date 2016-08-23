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
	        //数字滚动插件
	        var numRunA = $(".homeScrollA").numberAnimate({ num: data.dataCount, speed: 2000, symbol: "," });
	        var numRunB = $(".homeScrollB").numberAnimate({ num: data.companyCount, speed: 2000, symbol: "," });
	        var numRunC = $(".homeScrollC").numberAnimate({ num: data.bugCount, speed: 2000, symbol: "," });
	        var nums = data.dataCount;
	        var numJ = data.companyCount;
	        var numF = data.bugCount;
	        setInterval(function () {
	            nums += Math.round(Math.random() * 60) + 260;
	            // numJ+= Math.round(Math.random() * 60)+260;
	            numF += Math.round(Math.random() * 60) + 260;
	            numRunA.resetData(nums);
	            // numRunB.resetData(numJ);
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

/***/ },

/***/ 732:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//线下理财首页
	var LineFinanceSearch = _react2.default.createClass({
	    displayName: 'LineFinanceSearch',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: ''
	        };
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    searchClick: function searchClick() {
	        var searchVal = this.state.searchVal;
	        this.props.history.push('/lineFinanceSearchResult?keyWord=' + searchVal + '');
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'line-finace-search' },
	            _react2.default.createElement(
	                'h3',
	                null,
	                '线下理财监测'
	            ),
	            _react2.default.createElement(_index.Input, { placeholder: '请输入企业名称检索', value: this.state.searchVal, icon: 'icon-search', iconplace: 'right', type: 'text', onChange: this.handleChange, searchClick: this.searchClick })
	        );
	    }
	});
	module.exports = LineFinanceSearch;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceSearch.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 735:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//搜索条件
	var SearchCondition = _react2.default.createClass({
	  displayName: 'SearchCondition',

	  getInitialState: function getInitialState() {
	    return {};
	  },
	  componentWillMount: function componentWillMount() {},
	  getCheckVal: function getCheckVal(label, nowVal) {
	    var getCheckVal = this.props.getCheckVal;

	    var data = {
	      label: label,
	      nowVal: nowVal
	    };
	    getCheckVal(data);
	  },
	  checkClick: function checkClick(e) {

	    var $this = $(e.target);
	    var label = $this.attr('label');
	    var nowVal = $this.text();
	    var isActive = $this.hasClass('active');
	    if (isActive) {
	      $this.parent('ul').find('li').removeClass('active');
	      nowVal = "";
	    } else {
	      $this.parent('ul').find('li').removeClass('active');
	      $this.addClass('active');
	    }
	    this.getCheckVal(label, nowVal);
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'search-conditon ' + this.props.className },
	      _react2.default.createElement(
	        'label',
	        null,
	        this.props.label,
	        '：'
	      ),
	      _react2.default.createElement(
	        'ul',
	        { className: 'conditon' },
	        this.props.conList.map(function (elem, index) {
	          return _react2.default.createElement(
	            'li',
	            { className: '', label: this.props.label, onClick: this.checkClick },
	            elem
	          );
	        }.bind(this))
	      )
	    );
	  }
	});
	module.exports = SearchCondition;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "SearchCondition.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 736:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(733);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _ScatterBubbleChart = __webpack_require__(737);

	var _ScatterBubbleChart2 = _interopRequireDefault(_ScatterBubbleChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);


	//线下理财风险分布
	var LineFinanceRiskDistr = _react2.default.createClass({
	    displayName: 'LineFinanceRiskDistr',

	    getInitialState: function getInitialState() {
	        return {
	            option: null,
	            companyInfo: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        this.getLinFinRiskDistr();
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isCheckValEqual = Immutable.is(nextProps.parm, this.props.parm);
	        if (!isCheckValEqual) {
	            var parm = nextProps.parm;

	            var jsonData = parm;
	            this.getLinFinRiskDistr(jsonData);
	        }

	        var isEqual = Immutable.is(nextProps.lineFinaceRiskDistriRequest, this.props.lineFinaceRiskDistriResult);
	        if (!isEqual) {
	            var lineFinaceRiskDistriRequest = nextProps.lineFinaceRiskDistriRequest;
	            var lineFinaceRiskDistriResult = nextProps.lineFinaceRiskDistriResult;

	            if (lineFinaceRiskDistriRequest == true) {
	                if (lineFinaceRiskDistriResult.success == true) {
	                    this.dataFomat(lineFinaceRiskDistriResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },

	    getLinFinRiskDistr: function getLinFinRiskDistr(jsonData) {
	        var getLinFinRiskDistr = this.props.getLinFinRiskDistr;

	        getLinFinRiskDistr(jsonData);
	    },
	    dataFomat: function dataFomat(data) {
	        var companyInfo = [];
	        var seriesData = [];

	        var content = data.content;
	        var len = content.length;
	        for (var i = 0; i < len; i++) {
	            companyInfo.push({
	                name: content[i].companyName,
	                regCapital: content[i].regCapital,
	                corporate: content[i].legalRpt,
	                companyType: content[i].companyType,
	                foundDate: content[i].regDateStr
	            });
	            seriesData.push([content[i].staticRiskIndex, content[i].dynamicRiskIndex]);
	        }
	        var option = {
	            color: ["#a40000"],
	            title: "",
	            companyInfo: companyInfo,
	            yAxisName: "动态风险指数",
	            xAxisName: "静态风险指数",
	            series: [{
	                name: '风险指数',
	                type: 'scatter',
	                data: seriesData
	            }]
	        };
	        console.log(seriesData, 333333333333);
	        this.setState({ option: option, companyInfo: companyInfo });
	    },
	    onChartClick: function onChartClick(e) {
	        var companyInfo = this.state.companyInfo;
	        var dataIndex = e.dataIndex;
	        var companyName = companyInfo[dataIndex];
	        this.props.history.push("/SearchResultDetail?companyName=" + companyName + "");
	    },
	    render: function render() {
	        var onEvents = {
	            'click': this.onChartClick
	        };
	        var bbdScatterBubble = "";
	        if (this.state.option) {
	            bbdScatterBubble = _react2.default.createElement(_ScatterBubbleChart2.default, { onEvents: onEvents, option: this.state.option });
	        }

	        return _react2.default.createElement(
	            'div',
	            { className: 'line-finace-risk-distrib' },
	            _react2.default.createElement(
	                'h4',
	                null,
	                '线下理财分布'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'chart-box' },
	                bbdScatterBubble
	            )
	        );
	    }
	});
	module.exports = LineFinanceRiskDistr;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceRiskDistr.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 757:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//公司舆情
	var LineFinanceCoCompose = _react2.default.createClass({
	    displayName: 'LineFinanceCoCompose',

	    getInitialState: function getInitialState() {
	        return {
	            listData: "",
	            companyName: ""
	        };
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var companyNewsIsEqual = Immutable.is(nextProps.companyNewsRequest, this.props.companyNewsRequest);
	        if (!companyNewsIsEqual) {
	            var dataList = nextProps.companyNewsResult.content ? eval("(" + nextProps.companyNewsResult.content + ")") : "";
	            this.setState({
	                listData: dataList.results
	            });
	        }
	    },

	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });
	        this.requestCompanyNews(this.state.companyName);
	    },
	    requestCompanyNews: function requestCompanyNews(companyName) {
	        //请求公司舆情
	        var companyNews = this.props.companyNews;

	        companyNews({ companyName: companyName });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-cocompose mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '公司舆情'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'content-box' },
	                    _react2.default.createElement(
	                        'ul',
	                        null,
	                        this.state.listData ? this.state.listData.map(function (item, index) {
	                            return _react2.default.createElement(
	                                'li',
	                                { key: index },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'list-box' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        { className: 'title' },
	                                        _react2.default.createElement(
	                                            'a',
	                                            { href: item.bbd_source },
	                                            _react2.default.createElement(
	                                                'em',
	                                                null,
	                                                index + 1
	                                            ),
	                                            item.news_title
	                                        )
	                                    ),
	                                    _react2.default.createElement(
	                                        'p',
	                                        { className: 'abstract' },
	                                        item.search_key
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'source' },
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'name' },
	                                            item.news_site
	                                        ),
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'date' },
	                                            item.pubdate
	                                        )
	                                    )
	                                )
	                            );
	                        }) : ""
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceCoCompose;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceCoCompose.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 758:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//静态风险指数构成
	var LineFinanceIndexConstitute = _react2.default.createClass({
	    displayName: 'LineFinanceIndexConstitute',

	    getInitialState: function getInitialState() {
	        return {
	            statisticsDate: [],
	            riskIndex: [],
	            avgRiskIndex: [],
	            riskList: "",
	            allDate: [],
	            companyName: "",
	            pieOption: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });

	        //请求列表数据
	        var jsonData = { companyName: companyName, currentDate: '2016-05-30', areaCode: "长宁区" };
	        this.queryRiskData(jsonData);

	        //请求时间列表
	        var jsonDataDate = { companyName: companyName };
	        this.queryDateVersion(jsonDataDate);

	        //请求右面折线图      
	        var jsonDataLine = { companyName: companyName, areaCode: "金山区" };
	        this.staticRiskIndex(jsonDataLine);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.riskDataResult, this.props.riskDataResult);
	        if (!isEqual) {
	            //右边饼图数据
	            this.setState({
	                riskList: nextProps.riskDataResult.content
	            });
	            this.setParm(this.state.riskList);
	        }
	        var _allDate = [];
	        var queryDateVersionIsEqual = Immutable.is(nextProps.queryDateVersionRequest, this.props.queryDateVersionRequest);
	        if (!queryDateVersionIsEqual) {
	            //右边时间列表
	            nextProps.queryDateVersionResult.content.map(function (item, index) {
	                _allDate.push({
	                    value: index + 1,
	                    label: item
	                });
	            });
	            this.setState({
	                allDate: _allDate
	            });
	        }
	        var statisticsIsEqual = Immutable.is(nextProps.statisticsRequest, this.props.statisticsRequest);
	        if (!statisticsIsEqual) {
	            this.setState({
	                lineOption: nextProps.statisticsResult
	            });
	        }
	    },
	    queryRiskData: function queryRiskData(jsonData) {
	        //获取列表数据
	        var queryRiskData = this.props.queryRiskData;

	        queryRiskData(jsonData);
	    },
	    queryDateVersion: function queryDateVersion(jsonData) {
	        //获取日期
	        var queryDateVersion = this.props.queryDateVersion;

	        queryDateVersion(jsonData);
	    },
	    staticRiskIndex: function staticRiskIndex(jsonDataLine) {
	        //请求右面折线图         
	        var queryStatistics = this.props.queryStatistics;var self = this;
	        queryStatistics(jsonDataLine);
	    },

	    itemClick: function itemClick(e) {
	        var $this = $(e.target).parents('.item-head');
	        var $itemCon = $this.siblings('.item-con');
	        var $itemParent = $itemCon.parent('.item');
	        var isTrue = $itemParent.hasClass('active');
	        var isFirstItem = $itemParent.hasClass('item-first');
	        if (isTrue) {
	            if (!isFirstItem) {
	                $itemParent.removeClass('active');
	                $(this.refs.itemFirst).addClass('active');
	                $itemParent.find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	        } else {
	            if (!isFirstItem) {
	                $itemParent.find('.item-head .num i').removeClass('icon-xdown').addClass('icon-xup');
	                $(this.refs.itemFirst).removeClass('active');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	            $itemParent.addClass('active');
	        }
	    },
	    setParm: function setParm() {
	        var itemTable = arguments.length <= 0 || arguments[0] === undefined ? '' : arguments[0];
	        //渲染右边饼图
	        var option = {
	            "color": ["#dfab62", "#e85d1a", "#0e6d41", "#959595", "#f6b750", "#01b9ef", "#e24340", "#facd89", "#ff9b93", "#d58165", "#91c7af", "#6b9f88"],
	            "title": "",
	            "xtitle": "",
	            "legend": [""],
	            "legendShow": false,
	            "legendOrient": "vertical",
	            "legendLeft": "",
	            "legendTop": "middle",
	            "legendRight": "20%",
	            "seriesName": "静态风险指数构成",
	            "radius": "40%",
	            "lable": { normal: { show: true },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '50%'],
	            "series": [{
	                "name": "非法融资违规风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "人才结构风险",
	                "value": itemTable && itemTable.perStructRisk
	            }, {
	                "name": "实际控制人风险",
	                "value": itemTable && itemTable.realConRisk
	            }, {
	                "name": "公司扩张路径风险",
	                "value": itemTable && itemTable.comExpRisk
	            }, {
	                "name": "关联方中心集聚化风险",
	                "value": itemTable && itemTable.relInRisk
	            }, {
	                "name": "非法融资衍生风险",
	                "value": itemTable && itemTable.illFinRisk
	            }, {
	                "name": "短期逐利风险",
	                "value": itemTable && itemTable.comExpRisk
	            }]
	        };
	        this.setState({ pieOption: option });
	    },
	    setLineParm: function setLineParm(param) {
	        var _xAxisArr = [],
	            _riskIndexArr = [],
	            _avgRiskIndexArr = [];
	        this.state.lineOption[param].map(function (item) {
	            _xAxisArr.push(item.date);
	        });
	        this.state.lineOption[param].map(function (item) {
	            _riskIndexArr.push(item.riskIndex);
	            _avgRiskIndexArr.push(item.avgRiskIndex);
	        });
	        var option = {
	            color: ["#00b7ee", "#f8b551"],
	            bgColor: "",
	            title: "实际控制人风险趋势",
	            titleX: "left", //
	            boxId: "chartMap",
	            symbolSize: 10,
	            legendIsShow: true,
	            yFlag: "",
	            yAxisName: "",
	            legendRight: "30",
	            legend: ["公司", "行业平均"],
	            xAxis: _xAxisArr,
	            series: [_riskIndexArr, _avgRiskIndexArr]
	        };
	        return option;
	    },
	    render: function render() {
	        var self = this;
	        var selectProp = { //渲染右边时间选择        
	            width: '85px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: this.state.allDate[0],
	            name: 'testselect',
	            id: 'indexSelected',
	            data: this.state.allDate,
	            onChange: function onChange(value) {
	                var queryRiskData = self.props.queryRiskData;

	                queryRiskData({ companyName: self.companyName, currentDate: value, areaCode: "长宁区" });
	            }
	        };
	        var itemTable = this.state.riskList || '';
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-index-constitute mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '静态风险指数构成'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right sd' },
	                    _react2.default.createElement(_index.Selected, selectProp)
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'con-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-pie' },
	                        this.state.pieOption ? _react2.default.createElement(_BasePie2.default, { option: this.state.pieOption, style: { height: '520px', width: '100%' } }) : ''
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'index-con-info' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-first active', ref: 'itemFirst' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', 'data-index': '1', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '静态风险指数'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        null,
	                                        '51.2'
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xiangshang' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '静态风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex0'), style: { height: '290px', width: '100%' } }) : ""
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '实际控制人风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.realConRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '单个一度关联自然人最大控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.maxComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '平均每位一度关联自然人控制企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.avgPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心一度关联自然人'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneLvlPer
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '实际控制人风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex1'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '公司扩张风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.comExpRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司自然人股东数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldComConPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司企业法人数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.cldCtlNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreCldCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '公司扩张风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex2'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '关联方中心积聚化风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.relInRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.ctlCldComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '一度关联企业数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.oneComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '控股子公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.conCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '关联方中心积聚化风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex3'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融盗衍生风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illFinRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '三度关联自然人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.thrPerNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '二度关联企业法人节点数'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.twoComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '核心二度关联公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.coreTwoCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融盗衍生风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex4'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '短期逐利风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.shortRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月~1年以内新成立公司数量'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewComNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '6个月以内新成立的公司'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.sixMonNewCom
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '短期逐利风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex5'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '非法融资违规风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.illMoneyFinRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '投资类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.investment
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '咨询类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '贸易类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.advisory
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '租赁类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.lease
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '保理类'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.factoring
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '公司名单'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.companyList
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '非法融资违规风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex6'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'item item-other' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-head', onClick: this.itemClick },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'name' },
	                                    '人才结构风险'
	                                ),
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'num' },
	                                    _react2.default.createElement(
	                                        'em',
	                                        { className: 'c-red' },
	                                        itemTable && itemTable.perStructRisk
	                                    ),
	                                    _react2.default.createElement('i', { className: 'iconfont icon-xdown' })
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'item-con' },
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-table' },
	                                    _react2.default.createElement(
	                                        'table',
	                                        null,
	                                        _react2.default.createElement(
	                                            'tbody',
	                                            null,
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.underNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '硕士以上人次（包括硕士）'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'tr',
	                                                null,
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '40%', className: 't-left' },
	                                                    '本科以下人次'
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    { width: '60%', className: 't-right' },
	                                                    itemTable && itemTable.upperUnderNum
	                                                )
	                                            )
	                                        )
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'div',
	                                    { className: 'item-chart' },
	                                    _react2.default.createElement(
	                                        'h4',
	                                        null,
	                                        '人才结构风险趋势'
	                                    ),
	                                    _react2.default.createElement(
	                                        'div',
	                                        { className: 'chart-b' },
	                                        this.state.lineOption ? _react2.default.createElement(_LineChart2.default, { option: this.setLineParm('tabIndex7'), style: { height: '290px', width: '510px' } }) : ''
	                                    )
	                                )
	                            )
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = LineFinanceIndexConstitute;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceIndexConstitute.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 810:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var EquityL = _react2.default.createClass({
	    displayName: 'EquityL',


	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getEquityLRequest = this.props.getEquityLRequest;

	        var jsonData = {};
	        getEquityLRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.equityLRequest, this.props.equityLResult);
	        if (!isEqual) {
	            var equityLRequest = nextProps.equityLRequest;
	            var equityLResult = nextProps.equityLResult;

	            if (equityLRequest == true) {
	                if (equityLResult.success) {

	                    var _chartData1 = [],
	                        _chartData2 = [],
	                        chartxAxis = [];
	                    for (var item in equityLResult.content) {
	                        chartxAxis.push(equityLResult.content[item].typeName);
	                        _chartData1.push(equityLResult.content[item].managedCapitalAmount);
	                        _chartData2.push(equityLResult.content[item].publishCompanyNumber);
	                    }
	                    var option = {
	                        "title": "截至2015年底上海市股权投资机构管理资本量",
	                        "color": ["#f5b94b", "#01b6ed"],
	                        "titleShow": "show",
	                        "titleX": "center",
	                        "legend": ["私募机构数量", "管理资本金额"],
	                        "legendShow": true,
	                        "legendLeft": "10%",
	                        "legendBottom": "20",
	                        "gridBottom": "20%",
	                        "barName": ["私募机构数量", "管理资本金额"],
	                        "xAxis": chartxAxis,
	                        "unit": ["", "亿元"],
	                        "yAxisName": ["亿元", "个数"],
	                        "barWidth": 20,
	                        "symbolSize": 10,
	                        "series": {
	                            "bar": [_chartData1, _chartData2]
	                        }
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var barbox = "";
	        if (this.state.chartData) {
	            barbox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartData, style: { height: '330px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bottom-r radius4' },
	            barbox
	        );
	    }
	});

	module.exports = EquityL;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityL.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 813:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineBarChart = __webpack_require__(811);

	var _LineBarChart2 = _interopRequireDefault(_LineBarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var EquityR = _react2.default.createClass({
	    displayName: 'EquityR',

	    getInitialState: function getInitialState() {
	        return {
	            chartData: null
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getEquityRRequest = this.props.getEquityRRequest;

	        var jsonData = {};
	        getEquityRRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.equityRRequest, this.props.equityRResult);
	        if (!isEqual) {
	            var equityRRequest = nextProps.equityRRequest;
	            var equityRResult = nextProps.equityRResult;

	            if (equityRRequest == true) {
	                if (equityRResult.success) {
	                    var _lineData = [],
	                        _barData = [],
	                        chartxAxis = [];
	                    for (var item in equityRResult.content) {
	                        chartxAxis.push(equityRResult.content[item].year);
	                        // _lineData.push(equityRResult.content[item].quitNumber);
	                        _barData.push(equityRResult.content[item].publishNumber);
	                        _lineData.push(equityRResult.content[item].investmentAmount);
	                    }
	                    var option = {
	                        "title": "2013-2015上海市股权投资市场投资金额情况",
	                        "color": ["#efd79b", "#e14340"],
	                        "titleShow": "show",
	                        "titleX": "center",
	                        "legend": ["投资金额", "披露数量"],
	                        "legendShow": true,
	                        "legendLeft": "10%",
	                        "legendBottom": "20",
	                        "gridBottom": "20%",
	                        "barName": ["投资金额"],
	                        "lineName": ["披露数量"],
	                        "xAxis": chartxAxis,
	                        "yAxisName": ["亿元", "数量"],
	                        "unit": ["亿元", ""],
	                        "barWidth": 30,
	                        "symbolSize": 5,
	                        "series": {
	                            "bar": [_lineData],
	                            "line": [_barData]
	                        }
	                    };

	                    this.setState({ chartData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var barbox = "";
	        if (this.state.chartData) {
	            barbox = _react2.default.createElement(_LineBarChart2.default, { param: this.state.chartData, style: { height: '330px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bottom-r radius4' },
	            barbox
	        );
	    }
	});

	module.exports = EquityR;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "EquityR.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 815:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	__webpack_require__(816);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _SmallLoanIndexAction = __webpack_require__(818);

	var SmallLoanActionCreaters = _interopRequireWildcard(_SmallLoanIndexAction);

	var _index = __webpack_require__(692);

	var _setMinHeight = __webpack_require__(731);

	var _setMinHeight2 = _interopRequireDefault(_setMinHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _CompanyGrade = __webpack_require__(819);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _BalanceRatio = __webpack_require__(822);

	var _BalanceRatio2 = _interopRequireDefault(_BalanceRatio);

	var _EachAverage = __webpack_require__(824);

	var _EachAverage2 = _interopRequireDefault(_EachAverage);

	var _SmallLoanMap = __webpack_require__(825);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _LoanBalance = __webpack_require__(826);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(827);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(829);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	//企业评级


	//余额占比

	//余额占比

	//地图


	//贷款余额


	//股东行业风险


	//大额借款公司信息列表


	//小额贷款首页
	var SmallLoanIndex = _react2.default.createClass({
	  displayName: 'SmallLoanIndex',

	  mixins: [_setMinHeight2.default],
	  getInitialState: function getInitialState() {
	    return {
	      loanBalanceData: {},
	      balanceRatioData: {},
	      eachAverageData: {}
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getLoanBalance = this.props.getLoanBalance;

	    var jsonData = {};
	    getLoanBalance(jsonData);
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var isEqual = Immutable.is(nextProps.loanBalanceRequest, this.props.loanBalanceResult);
	    if (!isEqual) {
	      var loanBalanceRequest = nextProps.loanBalanceRequest;
	      var loanBalanceResult = nextProps.loanBalanceResult;

	      if (loanBalanceRequest == true) {
	        if (loanBalanceResult.success == true) {
	          this.dataFomat(loanBalanceResult);
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  dataFomat: function dataFomat(data) {
	    console.log(data, '贷款余额');
	    var content = data.content;
	    //小额贷款数据
	    var loanBalanceData = { //贷款余额数据
	      xAxis: [],
	      yAxis: [],
	      data: [] ////[[0,0,30],[1,1,10],[2,2,20],[3,3,50],[4,4,60],[5,5,10],[6,6,80]],
	    };

	    var balanceArr = [];
	    //贷款笔均折线图
	    var eachAverageData = {
	      xAxis: [],
	      series: []
	    };

	    //三农小微企业图表数据
	    var balanceRatioData = [];

	    var conLength = content.length;
	    for (var i = 0; i < conLength; i++) {
	      var year = content[i].year;
	      var balance = content[i].amount; //贷款余额
	      var dataArr = [i, i, balance];
	      var amount = content[i].amount;
	      var number = content[i].number;

	      balanceArr.push(balance);
	      loanBalanceData.xAxis.push(year);
	      loanBalanceData.data.push(dataArr);

	      var eachAver = Number(amount / number).toFixed(2);
	      eachAverageData.xAxis.push(year);
	      eachAverageData.series.push(eachAver);

	      var agricultureBalance = content[i].agricultureBalance;
	      var smallCompanyBalance = content[i].smallCompanyBalance;
	      balanceRatioData.push({
	        year: year,
	        amount: amount,
	        agricultureBalance: agricultureBalance,
	        smallCompanyBalance: smallCompanyBalance,
	        amountScale: amount / amount * 0.7,
	        agrBalScale: agricultureBalance / amount * 0.7,
	        smlComBalScale: smallCompanyBalance / amount * 0.7
	      });
	    }

	    var balanceMax = Math.max.apply(null, balanceArr);
	    var eachYAxis = balanceMax / 5;
	    for (var j = 0; j < 5; j++) {
	      loanBalanceData.yAxis.push(eachYAxis * j);
	    }

	    this.setState({ loanBalanceData: loanBalanceData, eachAverageData: eachAverageData, balanceRatioData: balanceRatioData });
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'small-loan-index content-space-10', style: this.state.style },
	      _react2.default.createElement(
	        'div',
	        { className: 'search-box' },
	        _react2.default.createElement(_IndustrySearch2.default, { label: '小额贷款监测', className: 'small-loan-search', placeholder: '请输入企业名称检索' })
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'top' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(_CompanyGrade2.default, this.props)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'middle mod-space-l' },
	          _react2.default.createElement(_SmallLoanMap2.default, this.props)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right mod-space-l' },
	          _react2.default.createElement(_BalanceRatio2.default, { balanceRatioData: this.state.balanceRatioData }),
	          _react2.default.createElement(_EachAverage2.default, { eachAverageData: this.state.eachAverageData })
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'bottom mod-space-t' },
	        _react2.default.createElement(
	          'div',
	          { className: 'left' },
	          _react2.default.createElement(_LoanBalance2.default, { loanBalanceData: this.state.loanBalanceData })
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'middle mod-space-l' },
	          _react2.default.createElement(_IndustryRisk2.default, this.props)
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'right mod-space-l' },
	          _react2.default.createElement(_LargeLoan2.default, this.props)
	        )
	      )
	    );
	  }
	});
	//module.exports = SmallLoanIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	  return {

	    //企业评级
	    companyGradeRequest: state.CompanyGrade.request,
	    companyGradeResult: state.CompanyGrade.result,

	    //地图
	    smollLoanMapRequest: state.SmallLoanMap.request,
	    smollLoanMapResult: state.SmallLoanMap.result,

	    //贷款余额
	    loanBalanceRequest: state.LoanBalance.request,
	    loanBalanceResult: state.LoanBalance.result,

	    //股东行业风险
	    industryRiskRequest: state.IndustryRisk.request,
	    industryRiskResult: state.IndustryRisk.result,

	    //大额借款公司信息列表
	    largeLoanRequest: state.LargeLoan.request,
	    largeLoanResult: state.LargeLoan.result

	  };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	  return (0, _redux.bindActionCreators)(SmallLoanActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(SmallLoanIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 830:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(831);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _reactRouter = __webpack_require__(243);

	var _P2PIndexAction = __webpack_require__(833);

	var P2PIndexActionCreaters = _interopRequireWildcard(_P2PIndexAction);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _devTrend = __webpack_require__(834);

	var _devTrend2 = _interopRequireDefault(_devTrend);

	var _volume = __webpack_require__(837);

	var _volume2 = _interopRequireDefault(_volume);

	var _map = __webpack_require__(838);

	var _map2 = _interopRequireDefault(_map);

	var _areaRanking = __webpack_require__(839);

	var _areaRanking2 = _interopRequireDefault(_areaRanking);

	var _problemScale = __webpack_require__(840);

	var _problemScale2 = _interopRequireDefault(_problemScale);

	var _IndustrySentiment = __webpack_require__(841);

	var _IndustrySentiment2 = _interopRequireDefault(_IndustrySentiment);

	var _netCreditContrast = __webpack_require__(842);

	var _netCreditContrast2 = _interopRequireDefault(_netCreditContrast);

	var _netCredit = __webpack_require__(843);

	var _netCredit2 = _interopRequireDefault(_netCredit);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//网贷平台数据展示

	//行业人气
	//上海区域发展指数排名
	//成交量和综合利率
	var Immutable = __webpack_require__(718);
	//p2p行业监测
	//网贷对比
	//问题平台比例
	//地图
	//新增平台发展趋势
	var P2PIndex = _react2.default.createClass({
	    displayName: 'P2PIndex',

	    getInitialState: function getInitialState() {
	        return {
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getp2pindexRequest = this.props.getp2pindexRequest;

	        var jsonData = {};
	        getp2pindexRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.indexChartRequest, this.props.indexChartResult);
	        if (!isEqual) {
	            var indexChartRequest = nextProps.indexChartRequest;
	            var indexChartResult = nextProps.indexChartResult;

	            if (indexChartRequest == true) {
	                if (indexChartResult.success) {
	                    this.setState({ listData: indexChartResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    handleFunction: function handleFunction(searchVal) {
	        this.props.history.push('/Portrait?platName=' + searchVal);
	    },
	    mixins: [_setHeight2.default],
	    render: function render() {
	        var parm = this.state.listData;
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-index', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', isHotWorld: 'no', searchFun: this.handleFunction, placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-index-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-top clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-l' },
	                        _react2.default.createElement(_devTrend2.default, { deveTrendData: this.state.listData }),
	                        _react2.default.createElement(_volume2.default, { volumeData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_map2.default, { mapData: this.state.listData }),
	                    _react2.default.createElement(_areaRanking2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'p2p-index-bom clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bom-l' },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'bom-l-t' },
	                            _react2.default.createElement(_problemScale2.default, { problemScaleData: this.state.listData }),
	                            _react2.default.createElement(_IndustrySentiment2.default, { industrySentimentData: this.state.listData })
	                        ),
	                        _react2.default.createElement(_netCreditContrast2.default, { netCreditContrastData: this.state.listData })
	                    ),
	                    _react2.default.createElement(_netCredit2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PIndex;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        indexChartRequest: state.IndexChartAll.request,
	        indexChartResult: state.IndexChartAll.result,

	        areaRankingRequest: state.AreaRanking.request,
	        areaRankingResult: state.AreaRanking.result,

	        netCreditRequest: state.NetCredit.request,
	        netCreditResult: state.NetCredit.result

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PIndexActionCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PIndex);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 838:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(835);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _MapChart = __webpack_require__(791);

	var _MapChart2 = _interopRequireDefault(_MapChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.mapData, this.props.mapData);
	        if (!isEqual) {
	            var mapData = nextProps.mapData;

	            var optionParm = {
	                "visualMapRight": "50", //值茷位置
	                "visualMapBottom": "30",
	                "visualMapText": ["公司数量"],
	                "unit": "家",
	                "series": mapData.hotMap.data
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_MapChart2.default, { option: this.state.chartOption, style: { height: '649px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-c radius4' },
	            chartBox
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "map.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 840:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(835);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var DevTrend = _react2.default.createClass({
	    displayName: 'DevTrend',

	    getInitialState: function getInitialState() {
	        return {
	            chartOption: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.problemScaleData, this.props.problemScaleData);
	        if (!isEqual) {
	            var problemScaleData = nextProps.problemScaleData;

	            var optionParm = {
	                color: ["#ffab48", "#00b7f0"],
	                title: "贷款余额",
	                titleX: "left",
	                boxId: "chartMap",
	                legendIsShow: true,
	                yFlag: "%",
	                legendRight: "10",
	                legendTop: "-10",
	                symbolSize: 5,
	                unit: ["%", "%"],
	                yAxisName: "",
	                legend: ["上海问题平台比例", "全国问题平台比例"],
	                xAxis: problemScaleData.problem.xAxis,
	                series: problemScaleData.problem.series
	            };
	            this.setState({ chartOption: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.chartOption) {
	            chartBox = _react2.default.createElement(_LineChart2.default, { option: this.state.chartOption, style: { height: '205px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod bom-l-t-l radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '问题平台比例'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = DevTrend;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "problemScale.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 844:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; }; //基本信息
	//公司基本信息
	//核心数据
	//诉讼信息
	//平台舆情
	//动态图谱
	//评分雷达图


	__webpack_require__(831);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _baseMsg = __webpack_require__(845);

	var _baseMsg2 = _interopRequireDefault(_baseMsg);

	var _companyMsg = __webpack_require__(848);

	var _companyMsg2 = _interopRequireDefault(_companyMsg);

	var _coreData = __webpack_require__(849);

	var _coreData2 = _interopRequireDefault(_coreData);

	var _litigation = __webpack_require__(851);

	var _litigation2 = _interopRequireDefault(_litigation);

	var _publicOpinion = __webpack_require__(852);

	var _publicOpinion2 = _interopRequireDefault(_publicOpinion);

	var _rankPic = __webpack_require__(853);

	var _rankPic2 = _interopRequireDefault(_rankPic);

	var _scoreLeida = __webpack_require__(854);

	var _scoreLeida2 = _interopRequireDefault(_scoreLeida);

	var _P2PPortraitAction = __webpack_require__(856);

	var P2PPortraitCreaters = _interopRequireWildcard(_P2PPortraitAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//p2p平台画像
	var P2PPortrait = _react2.default.createClass({
	    displayName: 'P2PPortrait',

	    mixins: [_setHeight2.default],
	    getInitialState: function getInitialState() {
	        return {
	            getCompany: "",
	            companyName: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var setCompany = this.props.setCompany;

	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        this.setState({ getCompany: _selectVal }, function () {
	            $.ajax({
	                url: "/P2PImage/hasOrNotCompany.do",
	                dataType: "json",
	                data: {
	                    platName: this.state.getCompany
	                },
	                type: "GET",
	                success: function (result) {
	                    if (result.content) {

	                        this.setState({ companyName: result.content.name }, function () {
	                            setCompany({ getCompanyName: this.state.companyName });
	                        });
	                    } else {
	                        this.setState({ companyName: "" }, function () {
	                            setCompany({ getCompanyName: this.state.companyName });
	                        });
	                    }
	                }.bind(this)
	            });
	        });
	    },
	    handleFunction: function handleFunction(searchVal, searchValAttr) {
	        if (searchValAttr != "") {
	            this.setState({ companyVal: searchVal, companyName: searchValAttr }, function () {
	                var _props = this.props;
	                var getbaseMsgRequest = _props.getbaseMsgRequest;
	                var getcompanyMsgRequest = _props.getcompanyMsgRequest;
	                var getcoreDataRequest = _props.getcoreDataRequest;
	                var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	                var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	                var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;
	                var getlitigationRequest = _props.getlitigationRequest;
	                var getpublicOpinionRequest = _props.getpublicOpinionRequest;
	                var getrankPicRequest = _props.getrankPicRequest;
	                var getscoreLeidaRequest = _props.getscoreLeidaRequest;


	                getbaseMsgRequest({ "platName": this.state.companyVal });
	                getcompanyMsgRequest({ "platName": this.state.companyVal });
	                getcoreDataRequest({ "platName": this.state.companyVal });
	                getCoreBarDataRequest({ "platName": this.state.companyVal });
	                getCoreTrendDataRequest({ "platName": this.state.companyVal });
	                getCoreBalanceDataRequest({ "platName": this.state.companyVal });

	                getlitigationRequest({ "platName": this.state.companyVal });
	                getpublicOpinionRequest({ "platName": this.state.companyVal });

	                getrankPicRequest({
	                    "platName": this.state.companyVal,
	                    "companyName": searchValAttr,
	                    "dataVersion": "20160530",
	                    "degree": 3
	                }); //动态图谱

	                getscoreLeidaRequest({ "platName": this.state.companyVal });
	            });
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'p2p-portrait', style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: 'P2P平台监测', searchFun: this.handleFunction, isHotWorld: 'no', companyType: '1', placeholder: '请输入平台全称' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'p2p-portrait-content' },
	                '',
	                _react2.default.createElement(
	                    'div',
	                    { className: 'clearfix' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-left' },
	                        _react2.default.createElement(_companyMsg2.default, _extends({}, this.props, { companyData: this.state.companyName })),
	                        _react2.default.createElement(_baseMsg2.default, _extends({}, this.props, { companyData: this.state.companyName })),
	                        _react2.default.createElement(_rankPic2.default, _extends({}, this.props, { companyData: this.state.companyName }))
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'portrait-right' },
	                        _react2.default.createElement(_scoreLeida2.default, _extends({}, this.props, { companyData: this.state.companyName })),
	                        _react2.default.createElement(_coreData2.default, _extends({}, this.props, { companyData: this.state.companyName }))
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'portrait-bottom  clearfix' },
	                    _react2.default.createElement(_litigation2.default, _extends({}, this.props, { companyData: this.state.companyName })),
	                    _react2.default.createElement(_publicOpinion2.default, _extends({}, this.props, { companyData: this.state.companyName }))
	                )
	            )
	        );
	    }
	});
	// module.exports = P2PPortrait;

	//将 request  result 绑定到props的request result
	function mapStateToProps(state) {
	    return {
	        baseMsgRequest: state.BaseMsg.request,
	        baseMsgResult: state.BaseMsg.result,

	        companyMsgRequest: state.CompanyMsg.request,
	        companyMsgResult: state.CompanyMsg.result,

	        coreDataRequest: state.CoreData.request,
	        coreDataResult: state.CoreData.result,

	        coreBarRequest: state.CoreBar.request,
	        coreBarResult: state.CoreBar.result,

	        coreTrendRequest: state.CoreTrend.request,
	        coreTrendResult: state.CoreTrend.result,

	        coreBalanceRequest: state.CoreBalance.request,
	        coreBalanceResult: state.CoreBalance.result,

	        litigationRequest: state.Litigation.request,
	        litigationResult: state.Litigation.result,

	        publicOpinionRequest: state.PublicOpinion.request,
	        publicOpinionResult: state.PublicOpinion.result,

	        rankPicRequest: state.RankPic.request,
	        rankPicResult: state.RankPic.result,

	        scoreLeidaRequest: state.ScoreLeida.request,
	        scoreLeidaResult: state.ScoreLeida.result,

	        companyName: state.CompanyName.county

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(P2PPortraitCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(P2PPortrait);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Portrait.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 845:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var BaseMsg = _react2.default.createClass({
	    displayName: 'BaseMsg',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var getbaseMsgRequest = this.props.getbaseMsgRequest;

	            getbaseMsgRequest({ "platName": this.state.companyVal });
	        }
	        var isEqual = Immutable.is(nextProps.baseMsgResult, this.props.baseMsgResult);
	        if (!isEqual) {
	            var baseMsgRequest = nextProps.baseMsgRequest;
	            var baseMsgResult = nextProps.baseMsgResult;

	            if (baseMsgRequest == true) {
	                if (baseMsgResult.success) {
	                    var _setParm = [baseMsgResult.content];
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-m radius4 mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '基本信息'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'list-items' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'mt-table wtyh-table' },
	                    this.state.listData.map(function (item, index) {
	                        {

	                            return _react2.default.createElement(
	                                'tbody',
	                                null,
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '平台名称'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.platName
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '公司名称：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': item.companyName },
	                                            item.companyName
	                                        )
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '法人代表：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.legalPeople
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '注册资本：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.capital
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '注册地址'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        _react2.default.createElement(
	                                            'span',
	                                            { className: 'word-limit-5', 'data-tip': item.address },
	                                            item.address
	                                        ),
	                                        ' '
	                                    ),
	                                    _react2.default.createElement('td', null),
	                                    _react2.default.createElement('td', null)
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    { className: 'odd-blackbg-line' },
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '开业日期：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.openedTime
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '核准日期：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.verifiedTime
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'tr',
	                                    null,
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '登记机关：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.registerOffice
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        '组织机构代码：'
	                                    ),
	                                    _react2.default.createElement(
	                                        'td',
	                                        null,
	                                        item.companyCode
	                                    )
	                                ),
	                                ' '
	                            );
	                        }
	                    })
	                )
	            )
	        );
	    }
	});

	module.exports = BaseMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "baseMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 848:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CompanyMsg = _react2.default.createClass({
	    displayName: 'CompanyMsg',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            companyVal: _selectVal,
	            listData: []
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getcompanyMsgRequest = this.props.getcompanyMsgRequest;

	        getcompanyMsgRequest({ "platName": this.state.companyVal });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var getcompanyMsgRequest = this.props.getcompanyMsgRequest;

	            getcompanyMsgRequest({ "platName": this.state.companyVal });
	        }
	        var isEqual = Immutable.is(nextProps.companyMsgResult, this.props.companyMsgResult);
	        if (!isEqual) {
	            var companyMsgRequest = nextProps.companyMsgRequest;
	            var companyMsgResult = nextProps.companyMsgResult;

	            if (companyMsgRequest == true) {
	                if (companyMsgResult.success) {
	                    var _setParm = [companyMsgResult.content];
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        // }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'left-t radius4 mod' },
	            this.state.listData.map(function (item, index) {
	                {
	                    var _logo = "/images/no-logo.png";
	                    if (item.logo) {
	                        _logo = item.logo;
	                    }
	                    return _react2.default.createElement(
	                        'ul',
	                        null,
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement('img', { className: 'compangMsg-log', src: _logo })
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'score orange' },
	                                item.score
	                            ),
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'score-title' },
	                                '评分'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'state' },
	                                item.status
	                            )
	                        )
	                    );
	                }
	            })
	        );
	    }
	});

	module.exports = CompanyMsg;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "companyMsg.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 849:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	var _LineChart = __webpack_require__(760);

	var _LineChart2 = _interopRequireDefault(_LineChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var CoreData = _react2.default.createClass({
	    displayName: 'CoreData',


	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            listData: [],
	            coreBarData: null,
	            coreTrendData: null,
	            coreBalanceData: null,
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var _props = this.props;
	            var getcoreDataRequest = _props.getcoreDataRequest;
	            var getCoreBarDataRequest = _props.getCoreBarDataRequest;
	            var getCoreTrendDataRequest = _props.getCoreTrendDataRequest;
	            var getCoreBalanceDataRequest = _props.getCoreBalanceDataRequest;

	            getcoreDataRequest({ "platName": this.state.companyVal });
	            getCoreBarDataRequest({ "platName": this.state.companyVal });
	            getCoreTrendDataRequest({ "platName": this.state.companyVal });
	            getCoreBalanceDataRequest({ "platName": this.state.companyVal });
	        }

	        var isEqual = Immutable.is(nextProps.coreDataResult, this.props.coreDataResult);
	        if (!isEqual) {
	            var coreDataRequest = nextProps.coreDataRequest;
	            var coreDataResult = nextProps.coreDataResult;

	            if (coreDataRequest == true) {
	                if (coreDataResult.success) {
	                    var _setParm = [];
	                    for (var item in coreDataResult.content) {
	                        var items = {
	                            name: item,
	                            value: coreDataResult.content[item]
	                        };
	                        _setParm.push(items);
	                    }
	                    this.setState({ listData: _setParm });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualBar = Immutable.is(nextProps.coreBarRequest, this.props.coreBarResult);
	        if (!isEqualBar) {
	            var coreBarRequest = nextProps.coreBarRequest;
	            var coreBarResult = nextProps.coreBarResult;

	            if (coreBarRequest == true) {
	                if (coreBarResult.success) {
	                    var option = {
	                        title: "平台交易量走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        barWidth: 15,
	                        yAxisName: "万元",
	                        yFlag: "", //y轴单位
	                        gridBottom: '0',
	                        unit: ["万元"],
	                        gridTop: '15%',
	                        legend: ["成交量"],
	                        legendShow: false,
	                        xAxis: coreBarResult.content.xAxis,
	                        series: [coreBarResult.content.series]
	                    };
	                    this.setState({ coreBarData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreTrendRequest, this.props.coreTrendResult);
	        if (!isEqualBar) {
	            var coreTrendRequest = nextProps.coreTrendRequest;
	            var coreTrendResult = nextProps.coreTrendResult;

	            if (coreTrendRequest == true) {
	                if (coreTrendResult.success) {
	                    var option = {
	                        title: "平台利率走势",
	                        titleX: "center",
	                        color: ["#e14340"],
	                        titleShow: true,
	                        symbolSize: 5,
	                        yAxisName: "",
	                        yFlag: "%", //y轴单位
	                        gridBottom: '0',
	                        gridTop: '15%',
	                        legend: ["利率"],
	                        legendShow: false,
	                        xAxis: coreTrendResult.content.xAxis,
	                        series: [coreTrendResult.content.series]
	                    };
	                    this.setState({ coreTrendData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }

	        var isEqualTrend = Immutable.is(nextProps.coreBalanceRequest, this.props.coreBalanceResult);
	        if (!isEqualBar) {
	            var coreBalanceRequest = nextProps.coreBalanceRequest;
	            var coreBalanceResult = nextProps.coreBalanceResult;

	            if (coreBalanceRequest == true) {
	                if (coreBalanceResult.success) {
	                    var option = {
	                        color: ["#00b7ee", "#f8b551"],
	                        title: "贷款余额",
	                        titleShow: true,
	                        titleX: "center",
	                        boxId: "chartMap",
	                        symbolSize: 5,
	                        legendIsShow: false,
	                        yFlag: "",
	                        yAxisName: "金额(亿元)",
	                        legendRight: "30",
	                        legend: ["贷款余额"],
	                        xAxis: coreBalanceResult.content.xAxis,
	                        series: [coreBalanceResult.content.series]
	                    };
	                    this.setState({ coreBalanceData: option });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    render: function render() {
	        var chartBoxBar = "",
	            chartBoxTrend = "",
	            chartBalance = "";
	        if (this.state.coreBarData) {
	            chartBoxBar = _react2.default.createElement(_BarChart2.default, { option: this.state.coreBarData, style: { height: '270px', width: '100%' } });
	        }
	        if (this.state.coreTrendData) {
	            chartBoxTrend = _react2.default.createElement(_LineChart2.default, { option: this.state.coreTrendData, style: { height: '320px', width: '100%' } });
	        }
	        if (this.state.coreBalanceData) {
	            chartBalance = _react2.default.createElement(_LineChart2.default, { option: this.state.coreBalanceData, style: { height: '320px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'right-b radius4 mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '核心数据'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-top' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-list' },
	                        _react2.default.createElement(
	                            'table',
	                            { className: 'mt-table wtyh-table' },
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
	                                                    item.name
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.value,
	                                                    '亿元'
	                                                )
	                                            );
	                                        } else {
	                                            return _react2.default.createElement(
	                                                'tr',
	                                                { className: 'odd-blackbg-line' },
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.name
	                                                ),
	                                                _react2.default.createElement(
	                                                    'td',
	                                                    null,
	                                                    item.value,
	                                                    '亿元'
	                                                )
	                                            );
	                                        }
	                                    }
	                                })
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'top-bar' },
	                        chartBoxBar
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'core-bottom' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-left' },
	                        chartBoxTrend
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'bottom-line-right' },
	                        chartBalance
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = CoreData;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "coreData.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 851:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Litigation = _react2.default.createClass({
	  displayName: 'Litigation',

	  getInitialState: function getInitialState() {
	    var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	    return {
	      listData: [],
	      companyVal: _selectVal
	    };
	  },
	  componentDidMount: function componentDidMount() {},
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    if (nextProps.companyData == "") {
	      return;
	    }
	    var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	    if (!isEqualCompany) {
	      var getlitigationRequest = this.props.getlitigationRequest;

	      getlitigationRequest({ "platName": this.state.companyVal });
	    }
	    var isEqual = Immutable.is(nextProps.litigationResult, this.props.litigationResult);
	    if (!isEqual) {
	      var litigationRequest = nextProps.litigationRequest;
	      var litigationResult = nextProps.litigationResult;

	      if (litigationRequest == true) {
	        if (litigationResult.success) {
	          var _setParm = [litigationResult.content];

	          this.setState({ listData: _setParm });
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'bottom-l radius4 mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'header-gray' },
	        _react2.default.createElement(
	          'span',
	          { className: 'title' },
	          '诉讼信息'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'content' },
	        _react2.default.createElement(
	          'ul',
	          null,
	          _react2.default.createElement(
	            'li',
	            null,
	            _react2.default.createElement('span', { className: 'iconfont icon-susong skublue' })
	          ),
	          _react2.default.createElement(
	            'li',
	            null,
	            _react2.default.createElement(
	              'span',
	              { className: 'ssong-title' },
	              '诉讼信息'
	            )
	          ),
	          this.state.listData.map(function (item, index) {
	            {

	              return _react2.default.createElement(
	                'li',
	                null,
	                _react2.default.createElement(
	                  'span',
	                  { className: 'ssong-num' },
	                  _react2.default.createElement(
	                    _reactRouter.Link,
	                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'Portrait' } }, className: 'orange' },
	                    item.total
	                  )
	                )
	              );
	            }
	          })
	        )
	      )
	    );
	  }
	});

	module.exports = Litigation;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "litigation.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 852:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);

	var PublicOpinion = _react2.default.createClass({
	  displayName: 'PublicOpinion',

	  getInitialState: function getInitialState() {
	    var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	    return {
	      listData: [],
	      companyVal: _selectVal
	    };
	  },
	  componentDidMount: function componentDidMount() {

	    $('#publicOpinion-scroll').perfectScrollbar();
	  },
	  componentDidUpdate: function componentDidUpdate() {
	    $('#publicOpinion-scroll').perfectScrollbar('update');
	  },
	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    if (nextProps.companyData == "") {
	      return;
	    }
	    var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	    if (!isEqualCompany) {
	      var getpublicOpinionRequest = this.props.getpublicOpinionRequest;

	      getpublicOpinionRequest({ "platName": this.state.companyVal });
	    }
	    var isEqual = Immutable.is(nextProps.publicOpinionResult, this.props.publicOpinionResult);
	    if (!isEqual) {
	      var publicOpinionRequest = nextProps.publicOpinionRequest;
	      var publicOpinionResult = nextProps.publicOpinionResult;

	      if (publicOpinionRequest == true) {
	        if (publicOpinionResult.success) {
	          var _setData = [];
	          for (var item in publicOpinionResult.content.warning) {
	            var items = {
	              "info": publicOpinionResult.content.warning[item].info,
	              "name": publicOpinionResult.content.plat_name
	            };
	            _setData.push(items);
	          }

	          console.log(_setData, "================publicOpinionResult==");
	          this.setState({ listData: _setData });
	        } else {
	          //错误后提示
	        }
	      }
	    }
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'bottom-r radius4 mod' },
	      _react2.default.createElement(
	        'div',
	        { className: 'header-gray' },
	        _react2.default.createElement(
	          'span',
	          { className: 'title' },
	          '平台舆情'
	        )
	      ),
	      _react2.default.createElement(
	        'div',
	        { className: 'content', id: 'publicOpinion-scroll' },
	        this.state.listData.map(function (item, index) {
	          {
	            var num = index + 1;
	            return _react2.default.createElement(
	              'div',
	              { className: 'list-item' },
	              _react2.default.createElement(
	                'table',
	                null,
	                _react2.default.createElement(
	                  'tbody',
	                  null,
	                  _react2.default.createElement(
	                    'tr',
	                    null,
	                    _react2.default.createElement(
	                      'td',
	                      { rowSpan: '3', className: 'v-aglign-t td2-l' },
	                      _react2.default.createElement(
	                        'span',
	                        { className: 'serial-num' },
	                        num
	                      )
	                    ),
	                    _react2.default.createElement(
	                      'td',
	                      { className: 'td2-r' },
	                      _react2.default.createElement(
	                        'a',
	                        { href: 'javascript:void(null)' },
	                        item.name
	                      )
	                    )
	                  ),
	                  _react2.default.createElement(
	                    'tr',
	                    null,
	                    _react2.default.createElement(
	                      'td',
	                      null,
	                      _react2.default.createElement(
	                        'p',
	                        { className: 'item-mark' },
	                        item.info
	                      )
	                    )
	                  )
	                )
	              )
	            );
	          }
	        })
	      )
	    );
	  }
	});

	module.exports = PublicOpinion;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "publicOpinion.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 853:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var RankPic = _react2.default.createClass({
	    displayName: 'RankPic',

	    getInitialState: function getInitialState() {
	        var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
	        return {
	            searchVal: '',
	            companyVal: _selectVal
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        if (nextProps.companyData == "") {
	            return;
	        }
	        var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
	        if (!isEqualCompany) {
	            var getrankPicRequest = this.props.getrankPicRequest;

	            getrankPicRequest({
	                "platName": this.state.companyVal,
	                "companyName": nextProps.companyData,
	                "dataVersion": "20160530",
	                "degree": 3
	            });
	        }
	        var isEqual = Immutable.is(nextProps.rankPicResult, this.props.rankPicResult);
	        if (!isEqual) {
	            (function () {
	                var rankPicRequest = nextProps.rankPicRequest;
	                var rankPicResult = nextProps.rankPicResult;

	                if (rankPicRequest == true) {
	                    seajs.use("/relativeGraph/assets/script/main/dynamic.js", function (main) {
	                        var pointList = rankPicResult.pointList;
	                        if (pointList == null || pointList == "" || pointList == "undefined") {
	                            nodes = [];
	                        } else {
	                            nodes = [];
	                            for (var i = 0; i < pointList.length; i++) {
	                                var point = pointList[i];

	                                var symbol = "rect";
	                                if (point.isPerson == "1") {
	                                    symbol = "circle";
	                                }

	                                var color = "#FF0000";
	                                if (point.level == "1") {
	                                    color = "#0030AF";
	                                    if (point.isSonCom == "1") {
	                                        color = "#FFCA00";
	                                    }
	                                } else if (point.level == "2") {
	                                    color = "#36B3EB";
	                                } else if (point.level == "3") {
	                                    color = "#C1C1C1";
	                                } else {}

	                                nodes[i] = {
	                                    "addflag": "false",
	                                    "category": point.level,
	                                    "color": color,
	                                    "name": point.name,
	                                    "symbol": symbol
	                                };
	                            }
	                        }
	                        var lineList = rankPicResult.lineList;
	                        if (lineList == null || lineList == "" || lineList == "undefined") {
	                            links = [];
	                        } else {
	                            links = [];
	                            for (var i = 0; i < lineList.length; i++) {
	                                var line = lineList[i];
	                                var lineType = "line";
	                                if (line.isFullLine == "0") {
	                                    lineType = "dotted";
	                                }
	                                links[i] = {
	                                    "addflag": "false",
	                                    "guanlian": line.type,
	                                    "line": lineType,
	                                    "relatedParyName": line.relationship,
	                                    "source": line.orig,
	                                    "target": line.target
	                                };
	                            }
	                        }

	                        main.reDrawCanvas();
	                    });
	                }
	            })();
	        }
	    },
	    handleChange: function handleChange(e) {
	        var searchVal = e.target.value;
	        this.setState({ searchVal: searchVal });
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'linefin-rel-graph mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'header-gray' },
	                _react2.default.createElement(
	                    'span',
	                    { className: 'title' },
	                    '企业关联方图谱'
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'pic_rank' },
	                    _react2.default.createElement('span', { className: 'add iconfont icon-jia', id: 'btn_bigmore' }),
	                    _react2.default.createElement('span', { className: 'sub iconfont icon-jian', id: 'btn_smaller' })
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-legend' },
	                    _react2.default.createElement(
	                        'table',
	                        null,
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '目标公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/xuxianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '投资人'
	                                    )
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'square orange-two' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '子公司'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round blue' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '一度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round yellow' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '二度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('span', { className: 'round green' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '三度关联自然人'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    _react2.default.createElement('img', { src: '/images/shixianjiantou.png' }),
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'item-lable' },
	                                        '企业高管'
	                                    )
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'condition', style: { display: "none" } },
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'lable' },
	                            '请选择以下筛选条件'
	                        ),
	                        _react2.default.createElement(
	                            'div',
	                            { className: 'btns' },
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn' },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-graph-box' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'main correlation', id: 'dyMapMain' },
	                        _react2.default.createElement('div', { id: 'dyMap' })
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = RankPic;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "rankPic.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 854:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(846);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _RadarChart = __webpack_require__(855);

	var _RadarChart2 = _interopRequireDefault(_RadarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var ScoreLeida = _react2.default.createClass({
		displayName: 'ScoreLeida',

		getInitialState: function getInitialState() {
			var _selectVal = this.props.location.query.platName == undefined ? "" : this.props.location.query.platName;
			return {
				listData: [],
				leidaData: null,
				companyVal: _selectVal
			};
		},
		componentDidMount: function componentDidMount() {},
		componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
			if (nextProps.companyData == "") {
				return;
			}
			var isEqualCompany = Immutable.is(nextProps.companyData, this.props.companyData);
			if (!isEqualCompany) {
				var getscoreLeidaRequest = this.props.getscoreLeidaRequest;

				getscoreLeidaRequest({ "platName": this.state.companyVal });
			}
			var isEqual = Immutable.is(nextProps.scoreLeidaResult, this.props.scoreLeidaResult);
			if (!isEqual) {
				var scoreLeidaRequest = nextProps.scoreLeidaRequest;
				var scoreLeidaResult = nextProps.scoreLeidaResult;

				if (scoreLeidaRequest == true) {
					if (scoreLeidaResult.success) {
						var socreNum = $(this.refs.scoreNum).html(scoreLeidaResult.content.score);
						var _setindicator = [];
						for (var item in scoreLeidaResult.content.indicator) {
							var items = {
								"name": scoreLeidaResult.content.indicator[item].name,
								"max": scoreLeidaResult.content.indicator[item].max + 30
							};
							_setindicator.push(items);
						}
						var chartOption = {
							"color": ["#00b8ee"],
							"legend": ["评分"],
							"legendShow": false,
							"series": scoreLeidaResult.content.series,
							"radarRadius": 110,
							"indicator": _setindicator
						};
						this.setState({ listData: scoreLeidaResult.content.indicator });
						this.setState({ leidaData: chartOption });
					} else {
						//错误后提示
					}
				}
			}
		},
		render: function render() {
			var chartBoxBar = "";
			if (this.state.leidaData) {
				chartBoxBar = _react2.default.createElement(_RadarChart2.default, { option: this.state.leidaData, style: { height: '380px', width: '100%' } });
			}
			return _react2.default.createElement(
				'div',
				{ className: 'right-t radius4 mod' },
				_react2.default.createElement(
					'div',
					{ className: 'header-gray' },
					_react2.default.createElement(
						'span',
						{ className: 'title' },
						'评分雷达图'
					)
				),
				_react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'ul',
						{ className: 'content-ul' },
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-l' },
							_react2.default.createElement(
								'p',
								{ className: 'orange socre-title' },
								'评分：'
							),
							_react2.default.createElement('p', { className: 'orange score', ref: 'scoreNum' })
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-c' },
							_react2.default.createElement(
								'div',
								{ className: 'leida-c-pic' },
								chartBoxBar
							)
						),
						_react2.default.createElement(
							'li',
							{ className: 'score-leida-r' },
							_react2.default.createElement(
								'ul',
								{ className: 'score-leida-r-ul' },
								this.state.listData.map(function (item, index) {
									{

										return _react2.default.createElement(
											'li',
											null,
											_react2.default.createElement(
												'p',
												null,
												item.max
											),
											_react2.default.createElement(
												'span',
												null,
												item.name
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

	module.exports = ScoreLeida;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "scoreLeida.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 880:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(881);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _setHeight = __webpack_require__(723);

	var _setHeight2 = _interopRequireDefault(_setHeight);

	var _IndustrySearch = __webpack_require__(743);

	var _IndustrySearch2 = _interopRequireDefault(_IndustrySearch);

	var _RegionalDis = __webpack_require__(883);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(886);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _HPQList = __webpack_require__(887);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _DetailList = __webpack_require__(888);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _TradingPlacesAction = __webpack_require__(889);

	var TradingPlacesCreaters = _interopRequireWildcard(_TradingPlacesAction);

	function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } else { var newObj = {}; if (obj != null) { for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) newObj[key] = obj[key]; } } newObj.default = obj; return newObj; } }

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//黄浦区交易场所列表
	//交易场所区域分布

	var TradingPlaces = _react2.default.createClass({
	    displayName: 'TradingPlaces',

	    mixins: [_setHeight2.default],
	    handleFunction: function handleFunction(searchVal) {
	        console.log(searchVal, "================搜索词语============================");
	        this.props.history.push('/SearchResultDetail?platName=' + searchVal);
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'tradingPlaces-index', searchFun: this.handleFunction, style: this.state.style },
	            _react2.default.createElement(_IndustrySearch2.default, { label: '交易场所监测', companyType: '9', searchFun: this.handleFunction, placeholder: '请输入企业名称检索' }),
	            _react2.default.createElement(
	                'div',
	                { className: 'content clearfix' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tradingP-left mod radius4 clearfix' },
	                    _react2.default.createElement(_RegionalDis2.default, this.props),
	                    _react2.default.createElement(_HPQList2.default, this.props)
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'tradingP-right mod radius4 clearfix' },
	                    _react2.default.createElement(_Classification2.default, this.props),
	                    _react2.default.createElement(_DetailList2.default, this.props)
	                )
	            )
	        );
	    }
	});
	// module.exports = TradingPlaces;
	//将 request  result 绑定到props的request result
	//取得合规意见或经过商的交易场所详情列表
	//交易场所清理整顿分类
	function mapStateToProps(state) {
	    return {
	        HPQListRequest: state.HPQList.request,
	        HPQListResult: state.HPQList.result,

	        regionalDisRequest: state.RegionalDis.request,
	        regionalDisResult: state.RegionalDis.result,

	        classificationRequest: state.Classification.request,
	        classificationResult: state.Classification.result,

	        detailListRequest: state.DetailList.request,
	        detailListResult: state.DetailList.result,

	        pieCounty: state.PieCounty.county,

	        barName: state.BarName.county

	    };
	}

	//将action的所有方法绑定到props上
	function mapDispatchToProps(dispatch) {
	    return (0, _redux.bindActionCreators)(TradingPlacesCreaters, dispatch);
	}

	//通过react-redux提供的connect方法将我们需要的state中的数据和actions中的方法绑定到props上
	exports.default = (0, _reactRedux.connect)(mapStateToProps, mapDispatchToProps)(TradingPlaces);

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 889:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	exports.getRegionalDisRequest = getRegionalDisRequest;
	exports.getHPQListRequest = getHPQListRequest;
	exports.getClassificationAllRequest = getClassificationAllRequest;
	exports.getDetailListRequest = getDetailListRequest;
	exports.setPieCounty = setPieCounty;
	exports.setBarName = setBarName;
	/*
	 典当行业监测
	*/

	/*交易场所区域分布*/
	var REGIONlDIS_REQUEST_SUCCESS = exports.REGIONlDIS_REQUEST_SUCCESS = 'REGIONlDIS_REQUEST_SUCCESS';
	var REGIONlDIS_REQUEST_FAIL = exports.REGIONlDIS_REQUEST_FAIL = 'REGIONlDIS_REQUEST_FAIL';

	function regionalDisRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: REGIONlDIS_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function regionalDisRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: REGIONlDIS_REQUEST_FAIL,
	    result: result
	  };
	}

	function getRegionalDisRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/exchangeCompany/exchangeCompanyArea.do", //"/data/industryMonitor/p2p/index/indexChart.json",///exchangeCompany/exchangeCompanyArea.do
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(regionalDisRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(regionalDisRequestFail(result));
	      }
	    });
	  };
	}
	/*交易场所区域分布*/

	/*黄浦区交易场所列表*/
	var HPQLIST_REQUEST_SUCCESS = exports.HPQLIST_REQUEST_SUCCESS = 'HPQLIST_REQUEST_SUCCESS';
	var HPQLIST_REQUEST_FAIL = exports.HPQLIST_REQUEST_FAIL = 'HPQLIST_REQUEST_FAIL';

	function HPQListRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: HPQLIST_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function HPQListRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: HPQLIST_REQUEST_FAIL,
	    result: result
	  };
	}

	function getHPQListRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/exchangeCompany/exchangeCompanyListByAreaId.do", //"/data/industryMonitor/p2p/index/indexChart.json"
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(HPQListRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(HPQListRequestFail(result));
	      }
	    });
	  };
	}
	/*黄浦区交易场所列表*/

	/*交易场所清理整顿分类*/
	var CLASSIFICATION_REQUEST_SUCCESS = exports.CLASSIFICATION_REQUEST_SUCCESS = 'CLASSIFICATION_REQUEST_SUCCESS';
	var CLASSIFICATION_REQUEST_FAIL = exports.CLASSIFICATION_REQUEST_FAIL = 'CHARTALL_REQUEST_FAIL';

	function classificationRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: CLASSIFICATION_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function classificationRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: CLASSIFICATION_REQUEST_FAIL,
	    result: result
	  };
	}

	function getClassificationAllRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/exchangeCompany/exchangeCompanyCategory.do", ///exchangeCompany/exchangeCompanyCategory.do
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(classificationRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(classificationRequestFail(result));
	      }
	    });
	  };
	}
	/*交易场所清理整顿分类*/

	/*取得合规意见或经过商的交易场所详情列表*/
	var DETAILLIST_REQUEST_SUCCESS = exports.DETAILLIST_REQUEST_SUCCESS = 'DETAILLIST_REQUEST_SUCCESS';
	var DETAILLIST_REQUEST_FAIL = exports.DETAILLIST_REQUEST_FAIL = 'DETAILLIST_REQUEST_FAIL';

	function detailListRequestSuccess(result) {
	  //请求成功调用方法
	  return {
	    type: DETAILLIST_REQUEST_SUCCESS,
	    result: result
	  };
	}
	function detailListRequestFail(result) {
	  //请求失败调用方法
	  return {
	    type: DETAILLIST_REQUEST_FAIL,
	    result: result
	  };
	}

	function getDetailListRequest(json) {
	  return function (dispatch) {
	    console.log(json);
	    $.ajax({
	      url: "/exchangeCompany/exchangeCompanyByStatus.do", //exchangeCompany/exchangeCompanyByStatus.do
	      dataType: "json",
	      data: json,
	      type: "GET",
	      success: function success(result) {
	        return dispatch(detailListRequestSuccess(result));
	      },
	      error: function error(result) {
	        return dispatch(detailListRequestFail(result));
	      }
	    });
	  };
	}
	/*取得合规意见或经过商的交易场所详情列表*/

	var PIE_COUNTY = exports.PIE_COUNTY = 'PIE_COUNTY';

	function pieCounty(county) {
	  return {
	    type: PIE_COUNTY,
	    county: county
	  };
	}
	function setPieCounty(county) {
	  return function (dispatch) {
	    console.log(county);
	    return dispatch(pieCounty(county));
	  };
	}

	var BAR_NAME = exports.BAR_NAME = 'BAR_NAME';
	function barName(county) {
	  return {
	    type: BAR_NAME,
	    county: county
	  };
	}
	function setBarName(county) {
	  return function (dispatch) {
	    console.log(county);
	    return dispatch(barName(county));
	  };
	}
	/*点击区县新动能指数传递地图的选中区县begin*/

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "TradingPlacesAction.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 901:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	var _extends = Object.assign || function (target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i]; for (var key in source) { if (Object.prototype.hasOwnProperty.call(source, key)) { target[key] = source[key]; } } } return target; };

	__webpack_require__(895);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	var _index = __webpack_require__(692);

	var _reactRouter = __webpack_require__(243);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//融资租赁企业目录
	var Immutable = __webpack_require__(718);
	var innerdata = [];
	var outerdata = [];
	var Catalog = _react2.default.createClass({
	    displayName: 'Catalog',

	    getInitialState: function getInitialState() {
	        return {
	            CatalogCentent: [],
	            CompanyDirectoryData: [],
	            CatalogDirectoryData: [],
	            CatalogSelect: [],
	            CatalogAdd: []
	        };
	    },
	    //初始
	    componentDidMount: function componentDidMount() {
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        var jsonData = { 'areaName': '黄浦区' };
	        getContrastCatalognumRequest(jsonData);

	        var getSelectRequest = this.props.getSelectRequest;

	        var jsonData = { 'areaId': 104 };
	        getSelectRequest(jsonData);

	        $("#platformBase-scroll").perfectScrollbar();
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $("#platformBase-scroll").perfectScrollbar('update');
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        //下拉框
	        var isEqual = Immutable.is(nextProps.CatalogSelectNumChartRequest, this.props.CatalogSelectNumChartResult);
	        if (!isEqual) {
	            var CatalogSelectNumChartRequest = nextProps.CatalogSelectNumChartRequest;
	            var CatalogSelectNumChartResult = nextProps.CatalogSelectNumChartResult;

	            if (CatalogSelectNumChartRequest == true) {
	                if (CatalogSelectNumChartResult.success) {
	                    this.dataCatalogSelect(CatalogSelectNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	        //列表
	        var isEqual = Immutable.is(nextProps.ContrastCatalogNumChartRequest, this.props.ContrastCatalogNumChartResult);
	        if (!isEqual) {
	            var ContrastCatalogNumChartRequest = nextProps.ContrastCatalogNumChartRequest;
	            var ContrastCatalogNumChartResult = nextProps.ContrastCatalogNumChartResult;

	            if (ContrastCatalogNumChartRequest == true) {
	                if (ContrastCatalogNumChartResult.success) {
	                    // for(var i = 0;i < ContrastCatalogNumChartResult.content.length;i++){
	                    //   if(ContrastCatalogNumChartResult.content[i].riskStatus == "正常") innerdata.push(ContrastCatalogNumChartResult.content[i])
	                    //     else outerdata.push(ContrastCatalogNumChartResult.content[i])
	                    // }
	                    // this.setState({
	                    //     CompanyDirectoryData:ContrastCatalogNumChartResult.content,
	                    //     CatalogCentent:ContrastCatalogNumChartResult.content
	                    // })                    
	                    this.dataFomat(ContrastCatalogNumChartResult);
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    //列表
	    dataFomat: function dataFomat(data) {
	        var content = data.content;
	        this.setState({ CatalogCentent: content });
	    },
	    //下拉框
	    dataCatalogSelect: function dataCatalogSelect(data) {
	        var content = data.content;
	        var selectVar = [];
	        for (var j = 0; j < content.length; j++) {
	            selectVar.push({ value: j, label: content[j] });
	        }
	        //console.info("qqqqqqqqqqqqqqqqqqqqqq",selectVar)
	        this.setState({ CatalogSelect: selectVar });
	    },
	    //地区
	    selectDataVal: function selectDataVal(data) {
	        var areaNameData = { 'areaName': data };
	        var getContrastCatalognumRequest = this.props.getContrastCatalognumRequest;

	        getContrastCatalognumRequest(areaNameData);
	    },
	    //风险状态判断
	    quarterChoice: function quarterChoice(value) {
	        $("#indexSelected").find('.mt-select-title').text();
	        console.info('jifei-----', $("#indexSelected").find('.mt-select-title').text());
	        $("#indexSelectedFeng").attr('data-val');
	        $("#indexSelectedShi").attr('data-val');
	        $("#indexSelectedWei").attr('data-val');
	        $("#indexSelectedAdd").attr('data-val');
	        $("#indexSelectedBtt").attr('data-val');
	    },
	    render: function render() {
	        //下拉选择列表头         
	        var selectProp = {
	            width: '110px',
	            className: 'index-selected',
	            value: 1,
	            placeholder: '黄浦区',
	            name: 'testselect',
	            data: this.state.CatalogSelect,
	            onChange: function (value, label) {
	                this.selectDataVal(label);
	            }.bind(this)
	        };
	        //下拉选择风险状态
	        var selectPropL = {
	            width: '55px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: 2, label: '全部' }, { value: 0, label: '正常' }, { value: 1, label: '潜在' }],
	            onChange: function (value, label) {
	                //console.log('当前值为：', value);         
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        //下拉选择全部
	        var selectProps = {
	            width: '55px',
	            className: 'index-selected',
	            value: 2,
	            placeholder: '高级选项',
	            name: 'testselect',
	            data: [{ value: 2, label: '全部' }, { value: 0, label: '是' }],
	            onChange: function (value, label) {
	                console.log('当前值为：', value);
	                this.quarterChoice(value);
	            }.bind(this)
	        };
	        return _react2.default.createElement(
	            'div',
	            { className: 'Catalog mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '上海市融资租赁企业目录'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'total' },
	                    '共',
	                    _react2.default.createElement(
	                        'em',
	                        { ref: 'totleCount' },
	                        this.state.CatalogCentent.length
	                    ),
	                    '家企业'
	                ),
	                _react2.default.createElement(
	                    'span',
	                    { className: 'right' },
	                    _react2.default.createElement(
	                        'em',
	                        null,
	                        '地区筛选'
	                    ),
	                    _react2.default.createElement(_index.Selected, _extends({}, selectProp, { id: 'indexSelected' }))
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'tabs' },
	                _react2.default.createElement(
	                    'table',
	                    { className: 'wtyh-table table-border-b' },
	                    _react2.default.createElement(
	                        'thead',
	                        null,
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width1' },
	                                '序号'
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width2' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '公司名称'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width3' },
	                                _react2.default.createElement(
	                                    'span',
	                                    { className: 'leftD' },
	                                    '注册地址'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { rowSpan: '2', className: 'width4' },
	                                '风险状态',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectPropL, { id: 'indexSelectedFeng' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { colSpan: '4', className: 'width5' },
	                                '潜在风险'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'tr',
	                            null,
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '失联',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedShi' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '未参加自查',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedWei' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上零认缴',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedAdd' }))
	                            ),
	                            _react2.default.createElement(
	                                'th',
	                                { className: 'width6' },
	                                '一年以上未经营',
	                                _react2.default.createElement(_index.Selected, _extends({}, selectProps, { id: 'indexSelectedBtt' }))
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'box', id: 'platformBase-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'wtyh-table table-border-b' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.CatalogCentent.map(function (item, index) {
	                                var Green = '';
	                                item.riskStatus == "正常" ? Green = 'Green' : Green = 'Yellow';
	                                var riskStatusA = item.riskStatusA == null ? "—" : item.riskStatusA;
	                                var riskStatusB = item.riskStatusB == null ? "—" : item.riskStatusB;
	                                var riskStatusC = item.riskStatusC == null ? "—" : item.riskStatusC;
	                                var riskStatusD = item.riskStatusD == null ? "—" : item.riskStatusD;
	                                if (index % 2) {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD' },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
	                                        )
	                                    );
	                                } else {
	                                    return _react2.default.createElement(
	                                        'tr',
	                                        { key: index },
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            index + 1
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                _reactRouter.Link,
	                                                { to: { pathname: HOME_PATH + "/SearchResultDetail" } },
	                                                _react2.default.createElement(
	                                                    'span',
	                                                    { className: 'leftD' },
	                                                    item.companyName
	                                                )
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: 'leftD' },
	                                                item.address
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            _react2.default.createElement(
	                                                'span',
	                                                { className: Green },
	                                                item.riskStatus
	                                            )
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusA
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusB
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusC
	                                        ),
	                                        _react2.default.createElement(
	                                            'td',
	                                            null,
	                                            riskStatusD
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
	module.exports = Catalog;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Catalog.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 904:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".commercialS-index .content {\r\n\tpadding: 0px 10px 20px 10px;\r\n}\r\n\r\n.commercialS-index .pawnM-top {\r\n}\r\n\r\n.commercialS-index .pawnM-top .top-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.commercialS-index .pawnM-top .top-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.commercialS-index .pawnM-Middle {\r\n\tmargin: 0.5% 0px;\r\n}\r\n\r\n.commercialS-index .pawnM-Middle .middle-left {\r\n\twidth: 50%;\r\n\tfloat: left;\r\n}\r\n\r\n.commercialS-index .pawnM-Middle .middle-right {\r\n\twidth: 49.5%;\r\n\tfloat: left;\r\n\tmargin-left: 0.5%\r\n}\r\n\r\n.commercialS-index .pawnM-bottom {\r\n}\r\n\r\n.commercialS-index  a {\r\n\tcolor: #e14340\r\n}", ""]);

	// exports


/***/ },

/***/ 910:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(907);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BasePie = __webpack_require__(759);

	var _BasePie2 = _interopRequireDefault(_BasePie);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var BusinessNum = _react2.default.createClass({
	    displayName: 'BusinessNum',
	    getInitialState: function getInitialState() {
	        return {
	            BusinessNumoption: null
	        };
	    },

	    setParm: function setParm(data) {
	        var series = [];
	        for (var i = 0; i < data.legend.length; i++) {
	            series.push({ value: data.series[i], name: data.legend[i] });
	        }
	        var options = {
	            "color": ["#e14340", "#12b5b0", "#91c7ae", "#efd79b"],
	            "title": "",
	            "xtitle": "",
	            "titleLeft": "0",
	            "legend": data.legend,
	            "legendShow": true,
	            "legendOrient": "horizontal",
	            "legendLeft": "center",
	            "legendTop": "78%",
	            "seriesName": "基金类型",
	            "radius": "60%",
	            "lable": { normal: {
	                    show: true,
	                    position: 'inside',
	                    formatter: '{d}%',
	                    textStyle: {
	                        color: "#fff",
	                        fontSize: 12,
	                        fontWeight: "normal",
	                        fontFamily: 'Microsoft Yahei'
	                    }
	                },
	                emphasis: { show: false }
	            },
	            "center": ['50%', '40%'],
	            "series": series
	        };
	        this.setState({
	            BusinessNumoption: options
	        });
	    },
	    componentDidMount: function componentDidMount() {
	        var getBusinessnumRequest = this.props.getBusinessnumRequest;

	        var jsonData = {};
	        getBusinessnumRequest(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.BusinessNumChartRequest, this.props.BusinessNumChartResult);
	        if (!isEqual) {
	            var BusinessNumChartRequest = nextProps.BusinessNumChartRequest;
	            var BusinessNumChartResult = nextProps.BusinessNumChartResult;

	            if (BusinessNumChartRequest == true) {
	                if (BusinessNumChartResult.success == true) {
	                    this.setParm(BusinessNumChartResult.content);
	                } else {
	                    console.log(404);
	                }
	            }
	        }
	    },
	    render: function render() {
	        var BusinessNumBox = "";
	        if (this.state.BusinessNumoption) {
	            BusinessNumBox = _react2.default.createElement(_BasePie2.default, {
	                option: this.state.BusinessNumoption,
	                style: { height: '465px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-left radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业类型分布'
	                )
	            ),
	            BusinessNumBox
	        );
	    }
	});

	module.exports = BusinessNum;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "BusinessNum.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 919:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".prepaidC-index .right-bottom tbody td,\r\n.prepaidC-index .right-bottom thead th {\r\n\ttext-align: left;\r\n}\r\n\r\n.prepaidC-index  .mt-table {\r\n\tmargin: 0px;\r\n}\r\n\r\n.prepaidC-index  .mt-table tr td a {\r\n\tcolor: #fff;\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-content {\r\n\theight: 500px;\r\n\toverflow: hidden;\r\n\tposition: relative;\r\n}\r\n\r\n.prepaidC-index .right-bottom  .mod-content {\r\n\tpadding: 10px 20px 20px 20px;\r\n}\r\n\r\n/*.prepaidC-index .right-bottom .table-content  table {\r\n\theight: 100%\r\n}*/\r\n.prepaidC-index .right-bottom .table-content  table tr {\r\n\tborder-bottom: 1px #4b5058 solid;\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-title th {\r\n\theight: 50px\r\n}\r\n\r\n.prepaidC-index .right-bottom .table-content  .mt-table td {\r\n\tpadding: 15px 8px;\r\n}\r\n\r\n.prepaidC-index .right-bottom  .mod-title .totle-num {\r\n\tfont-size: 14px;\r\n\tcolor: #fff;\r\n\tfloat: right;\r\n\tdisplay: inline-block;\r\n\tmargin: 15px 20px 0px 0px;\r\n}\r\n\r\n.mt-select .company-dire {\r\n\tbackground: #393a48;\r\n\tborder: 1px #393a48 solid;\r\n\tmargin-left: 5px;\r\n}\r\n\r\n.prepaidC-index .orange {\r\n\tcolor: #3aec8e;\r\n}\r\n\r\n.prepaidC-index .yellows {\r\n\tcolor: #fcae03;\r\n}\r\n\r\n.prepaidC-index .reds {\r\n\tcolor: #e14340;\r\n}\r\n\r\n.prepaidC-index .statu-yellow {\r\n\tcolor: #feac00\r\n}\r\n\r\n.prepaidC-index .statu-green {\r\n\tcolor: #33da82\r\n}\r\n\r\n.prepaidC-index .BZ-num {\r\n\tfloat: right;\r\n\tmargin: 10px 20px 0px 0px;\r\n}\r\n\r\n.prepaidC-index .BZ-num .orange {\r\n\tfont-size: 16px;\r\n}", ""]);

	// exports


/***/ },

/***/ 946:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(947);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _redux = __webpack_require__(306);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Search = _react2.default.createClass({
	  displayName: 'Search',
	  componentDidMount: function componentDidMount() {
	    if (this.props.location.query.searchInfo) {
	      this.refs.inp.value = this.props.location.query.searchInfo;
	    }
	  },

	  clickSearch: function clickSearch() {
	    if (this.refs.inp.value) {
	      var getSearchDataRequest = this.props.getSearchDataRequest;

	      var companyData = {
	        "company": this.refs.inp.value,
	        "page_no": 0,
	        "page_size": 4
	      };
	      getSearchDataRequest(companyData);
	      // $("#show").show()
	    }
	  },
	  keySearch: function keySearch(event) {
	    if (event.which == "13") this.clickSearch();
	    var value = $(event.target).val();
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'Search' },
	      _react2.default.createElement(
	        'div',
	        { className: 'SearchBox' },
	        _react2.default.createElement(
	          'h1',
	          null,
	          '企业全息信息查询平台'
	        ),
	        _react2.default.createElement(
	          'div',
	          { className: 'SearchInp' },
	          _react2.default.createElement('input', { placeholder: '', type: 'text', ref: 'inp', id: 'inp', onKeyUp: this.keySearch, placeholder: '请输入企业名称检索' }),
	          _react2.default.createElement(
	            'a',
	            { id: 'href', href: 'javascript:void(0);', onClick: this.clickSearch },
	            _react2.default.createElement('i', { className: 'iconfont icon-search' })
	          )
	        )
	      )
	    );
	  }
	});
	module.exports = Search;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Search.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 986:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _redux = __webpack_require__(306);

	var _reactRouterRedux = __webpack_require__(300);

	var _companyInfoTitRuducer = __webpack_require__(987);

	var _companyInfoTitRuducer2 = _interopRequireDefault(_companyInfoTitRuducer);

	var _companyInfoNewsRuducer = __webpack_require__(988);

	var _companyInfoNewsRuducer2 = _interopRequireDefault(_companyInfoNewsRuducer);

	var _companyInfoARuducer = __webpack_require__(989);

	var _companyInfoARuducer2 = _interopRequireDefault(_companyInfoARuducer);

	var _companyInfoBRuducer = __webpack_require__(990);

	var _companyInfoBRuducer2 = _interopRequireDefault(_companyInfoBRuducer);

	var _companyPic = __webpack_require__(991);

	var _companyPic2 = _interopRequireDefault(_companyPic);

	var _companyInfoC1Ruducer = __webpack_require__(992);

	var _companyInfoC1Ruducer2 = _interopRequireDefault(_companyInfoC1Ruducer);

	var _companyInfoC2Ruducer = __webpack_require__(993);

	var _companyInfoC2Ruducer2 = _interopRequireDefault(_companyInfoC2Ruducer);

	var _companyInfoC3Ruducer = __webpack_require__(994);

	var _companyInfoC3Ruducer2 = _interopRequireDefault(_companyInfoC3Ruducer);

	var _companyInfoC4Ruducer = __webpack_require__(995);

	var _companyInfoC4Ruducer2 = _interopRequireDefault(_companyInfoC4Ruducer);

	var _companyInfoC5Ruducer = __webpack_require__(996);

	var _companyInfoC5Ruducer2 = _interopRequireDefault(_companyInfoC5Ruducer);

	var _companyInfoD1Ruducer = __webpack_require__(997);

	var _companyInfoD1Ruducer2 = _interopRequireDefault(_companyInfoD1Ruducer);

	var _companyInfoD2Ruducer = __webpack_require__(998);

	var _companyInfoD2Ruducer2 = _interopRequireDefault(_companyInfoD2Ruducer);

	var _companyInfoD3Ruducer = __webpack_require__(999);

	var _companyInfoD3Ruducer2 = _interopRequireDefault(_companyInfoD3Ruducer);

	var _Common = __webpack_require__(1000);

	var _Common2 = _interopRequireDefault(_Common);

	var _SmallLoanMap = __webpack_require__(1001);

	var _SmallLoanMap2 = _interopRequireDefault(_SmallLoanMap);

	var _CompanyGrade = __webpack_require__(1002);

	var _CompanyGrade2 = _interopRequireDefault(_CompanyGrade);

	var _LoanBalance = __webpack_require__(1003);

	var _LoanBalance2 = _interopRequireDefault(_LoanBalance);

	var _IndustryRisk = __webpack_require__(1004);

	var _IndustryRisk2 = _interopRequireDefault(_IndustryRisk);

	var _LargeLoan = __webpack_require__(1005);

	var _LargeLoan2 = _interopRequireDefault(_LargeLoan);

	var _FinGuaMap = __webpack_require__(1006);

	var _FinGuaMap2 = _interopRequireDefault(_FinGuaMap);

	var _FinGuaCompanyGrade = __webpack_require__(1007);

	var _FinGuaCompanyGrade2 = _interopRequireDefault(_FinGuaCompanyGrade);

	var _GuaraDutyBalance = __webpack_require__(1008);

	var _GuaraDutyBalance2 = _interopRequireDefault(_GuaraDutyBalance);

	var _FinGuaIndustryRisk = __webpack_require__(1009);

	var _FinGuaIndustryRisk2 = _interopRequireDefault(_FinGuaIndustryRisk);

	var _LargeGuara = __webpack_require__(1010);

	var _LargeGuara2 = _interopRequireDefault(_LargeGuara);

	var _AreaRanking = __webpack_require__(1011);

	var _AreaRanking2 = _interopRequireDefault(_AreaRanking);

	var _NetCredit = __webpack_require__(1012);

	var _NetCredit2 = _interopRequireDefault(_NetCredit);

	var _IndexChartAll = __webpack_require__(1013);

	var _IndexChartAll2 = _interopRequireDefault(_IndexChartAll);

	var _BaseMsg = __webpack_require__(1014);

	var _BaseMsg2 = _interopRequireDefault(_BaseMsg);

	var _CompanyMsg = __webpack_require__(1015);

	var _CompanyMsg2 = _interopRequireDefault(_CompanyMsg);

	var _CoreData = __webpack_require__(1016);

	var _CoreData2 = _interopRequireDefault(_CoreData);

	var _CoreBar = __webpack_require__(1017);

	var _CoreBar2 = _interopRequireDefault(_CoreBar);

	var _CoreTrend = __webpack_require__(1018);

	var _CoreTrend2 = _interopRequireDefault(_CoreTrend);

	var _CoreBalance = __webpack_require__(1019);

	var _CoreBalance2 = _interopRequireDefault(_CoreBalance);

	var _Litigation = __webpack_require__(1020);

	var _Litigation2 = _interopRequireDefault(_Litigation);

	var _PublicOpinion = __webpack_require__(1021);

	var _PublicOpinion2 = _interopRequireDefault(_PublicOpinion);

	var _RankPic = __webpack_require__(1022);

	var _RankPic2 = _interopRequireDefault(_RankPic);

	var _ScoreLeida = __webpack_require__(1023);

	var _ScoreLeida2 = _interopRequireDefault(_ScoreLeida);

	var _CompanyName = __webpack_require__(1394);

	var _CompanyName2 = _interopRequireDefault(_CompanyName);

	var _CompanyProgress = __webpack_require__(1024);

	var _CompanyProgress2 = _interopRequireDefault(_CompanyProgress);

	var _QDLPQuality = __webpack_require__(1025);

	var _QDLPQuality2 = _interopRequireDefault(_QDLPQuality);

	var _FundClass = __webpack_require__(1026);

	var _FundClass2 = _interopRequireDefault(_FundClass);

	var _FundCase = __webpack_require__(1027);

	var _FundCase2 = _interopRequireDefault(_FundCase);

	var _FundCaseTop = __webpack_require__(1028);

	var _FundCaseTop2 = _interopRequireDefault(_FundCaseTop);

	var _EquityL = __webpack_require__(1029);

	var _EquityL2 = _interopRequireDefault(_EquityL);

	var _EquityM = __webpack_require__(1030);

	var _EquityM2 = _interopRequireDefault(_EquityM);

	var _EquityR = __webpack_require__(1031);

	var _EquityR2 = _interopRequireDefault(_EquityR);

	var _BusinessTypes = __webpack_require__(1032);

	var _BusinessTypes2 = _interopRequireDefault(_BusinessTypes);

	var _InvestPeople = __webpack_require__(1033);

	var _InvestPeople2 = _interopRequireDefault(_InvestPeople);

	var _NewProject = __webpack_require__(1034);

	var _NewProject2 = _interopRequireDefault(_NewProject);

	var _RaiseMount = __webpack_require__(1035);

	var _RaiseMount2 = _interopRequireDefault(_RaiseMount);

	var _List = __webpack_require__(1036);

	var _List2 = _interopRequireDefault(_List);

	var _ChartAll = __webpack_require__(1037);

	var _ChartAll2 = _interopRequireDefault(_ChartAll);

	var _CompanyDirectory = __webpack_require__(1038);

	var _CompanyDirectory2 = _interopRequireDefault(_CompanyDirectory);

	var _HPQList = __webpack_require__(1039);

	var _HPQList2 = _interopRequireDefault(_HPQList);

	var _RegionalDis = __webpack_require__(1040);

	var _RegionalDis2 = _interopRequireDefault(_RegionalDis);

	var _Classification = __webpack_require__(1041);

	var _Classification2 = _interopRequireDefault(_Classification);

	var _DetailList = __webpack_require__(1042);

	var _DetailList2 = _interopRequireDefault(_DetailList);

	var _PieCounty = __webpack_require__(1043);

	var _PieCounty2 = _interopRequireDefault(_PieCounty);

	var _BarName = __webpack_require__(1044);

	var _BarName2 = _interopRequireDefault(_BarName);

	var _Lease = __webpack_require__(1045);

	var _Lease2 = _interopRequireDefault(_Lease);

	var _ContrastLeft = __webpack_require__(1046);

	var _ContrastLeft2 = _interopRequireDefault(_ContrastLeft);

	var _ContrastRight = __webpack_require__(1047);

	var _ContrastRight2 = _interopRequireDefault(_ContrastRight);

	var _Catalog = __webpack_require__(1048);

	var _Catalog2 = _interopRequireDefault(_Catalog);

	var _CatalogSelect = __webpack_require__(1049);

	var _CatalogSelect2 = _interopRequireDefault(_CatalogSelect);

	var _TimeSelect = __webpack_require__(1050);

	var _TimeSelect2 = _interopRequireDefault(_TimeSelect);

	var _realtimeTableRuducer = __webpack_require__(1051);

	var _realtimeTableRuducer2 = _interopRequireDefault(_realtimeTableRuducer);

	var _realtimeNineReducer = __webpack_require__(1052);

	var _realtimeNineReducer2 = _interopRequireDefault(_realtimeNineReducer);

	var _realtimeNewsReducer = __webpack_require__(1053);

	var _realtimeNewsReducer2 = _interopRequireDefault(_realtimeNewsReducer);

	var _realtimeMapReducer = __webpack_require__(1054);

	var _realtimeMapReducer2 = _interopRequireDefault(_realtimeMapReducer);

	var _realtimeMapShReducer = __webpack_require__(1055);

	var _realtimeMapShReducer2 = _interopRequireDefault(_realtimeMapShReducer);

	var _MenuParkSelectVal = __webpack_require__(1056);

	var _MenuParkSelectVal2 = _interopRequireDefault(_MenuParkSelectVal);

	var _MenuParkSelectList = __webpack_require__(1057);

	var _MenuParkSelectList2 = _interopRequireDefault(_MenuParkSelectList);

	var _ParkCamp = __webpack_require__(1058);

	var _ParkCamp2 = _interopRequireDefault(_ParkCamp);

	var _ParkFinance = __webpack_require__(1059);

	var _ParkFinance2 = _interopRequireDefault(_ParkFinance);

	var _ParkIndustry = __webpack_require__(1060);

	var _ParkIndustry2 = _interopRequireDefault(_ParkIndustry);

	var _ParkNews = __webpack_require__(1061);

	var _ParkNews2 = _interopRequireDefault(_ParkNews);

	var _ParkImg = __webpack_require__(1062);

	var _ParkImg2 = _interopRequireDefault(_ParkImg);

	var _BuildCompanyList = __webpack_require__(1063);

	var _BuildCompanyList2 = _interopRequireDefault(_BuildCompanyList);

	var _BuildIndDistri = __webpack_require__(1064);

	var _BuildIndDistri2 = _interopRequireDefault(_BuildIndDistri);

	var _CompanyBg = __webpack_require__(1065);

	var _CompanyBg2 = _interopRequireDefault(_CompanyBg);

	var _BuildList = __webpack_require__(1066);

	var _BuildList2 = _interopRequireDefault(_BuildList);

	var _BuildNews = __webpack_require__(1067);

	var _BuildNews2 = _interopRequireDefault(_BuildNews);

	var _BuildRisk = __webpack_require__(1068);

	var _BuildRisk2 = _interopRequireDefault(_BuildRisk);

	var _BuildSwitchVal = __webpack_require__(1069);

	var _BuildSwitchVal2 = _interopRequireDefault(_BuildSwitchVal);

	var _ChartAll3 = __webpack_require__(1070);

	var _ChartAll4 = _interopRequireDefault(_ChartAll3);

	var _businessnumChart = __webpack_require__(1071);

	var _businessnumChart2 = _interopRequireDefault(_businessnumChart);

	var _balanceChart = __webpack_require__(1072);

	var _balanceChart2 = _interopRequireDefault(_balanceChart);

	var _CompanyDirectoryChart = __webpack_require__(1073);

	var _CompanyDirectoryChart2 = _interopRequireDefault(_CompanyDirectoryChart);

	var _LineFinanceRiskDistri = __webpack_require__(1074);

	var _LineFinanceRiskDistri2 = _interopRequireDefault(_LineFinanceRiskDistri);

	var _LineFinanceList = __webpack_require__(1075);

	var _LineFinanceList2 = _interopRequireDefault(_LineFinanceList);

	var _CheckVal = __webpack_require__(1076);

	var _CheckVal2 = _interopRequireDefault(_CheckVal);

	var _SearchResultList = __webpack_require__(1077);

	var _SearchResultList2 = _interopRequireDefault(_SearchResultList);

	var _DynamicPic = __webpack_require__(1079);

	var _DynamicPic2 = _interopRequireDefault(_DynamicPic);

	var _StaticRisk = __webpack_require__(1080);

	var _StaticRisk2 = _interopRequireDefault(_StaticRisk);

	var _Statistics = __webpack_require__(1081);

	var _Statistics2 = _interopRequireDefault(_Statistics);

	var _RiskData = __webpack_require__(1082);

	var _RiskData2 = _interopRequireDefault(_RiskData);

	var _CompanyNews = __webpack_require__(1083);

	var _CompanyNews2 = _interopRequireDefault(_CompanyNews);

	var _QueryDateVersion = __webpack_require__(1084);

	var _QueryDateVersion2 = _interopRequireDefault(_QueryDateVersion);

	var _DynamicRiskCompanyTag = __webpack_require__(1085);

	var _DynamicRiskCompanyTag2 = _interopRequireDefault(_DynamicRiskCompanyTag);

	var _DynamicRiskDate = __webpack_require__(1086);

	var _DynamicRiskDate2 = _interopRequireDefault(_DynamicRiskDate);

	var _DynamicRiskLeftImg = __webpack_require__(1087);

	var _DynamicRiskLeftImg2 = _interopRequireDefault(_DynamicRiskLeftImg);

	var _DynamicRiskRightImg = __webpack_require__(1088);

	var _DynamicRiskRightImg2 = _interopRequireDefault(_DynamicRiskRightImg);

	var _DynamicRiskIndexCmp = __webpack_require__(1089);

	var _DynamicRiskIndexCmp2 = _interopRequireDefault(_DynamicRiskIndexCmp);

	var _SelectDate = __webpack_require__(1393);

	var _SelectDate2 = _interopRequireDefault(_SelectDate);

	var _RiskSearch = __webpack_require__(1090);

	var _RiskSearch2 = _interopRequireDefault(_RiskSearch);

	var _industryTypeChart = __webpack_require__(1091);

	var _industryTypeChart2 = _interopRequireDefault(_industryTypeChart);

	var _TotleMoney = __webpack_require__(1092);

	var _TotleMoney2 = _interopRequireDefault(_TotleMoney);

	var _homeThree = __webpack_require__(1093);

	var _homeThree2 = _interopRequireDefault(_homeThree);

	var _infoSearch = __webpack_require__(1094);

	var _infoSearch2 = _interopRequireDefault(_infoSearch);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*企业全息信息查询平台 end*/

	/*预付卡 end*/

	/*首页 begin*/


	/*线下理财监测 end*/

	/*预付卡 begin*/


	//楼宇详情页

	//企业占比对比

	//企业目录列表

	/*实时监测 begin*/

	/*=================================交易场所监测=================================*/

	/*=================================融资租赁=================================*/
	//典当法人企业数

	//交易场所清理整顿分类

	/*=================================典当行业监测=================================*/

	/*=================================交易场所监测=================================*/
	//黄浦区交易场所列表

	/*=================================众筹监测=================================*/

	/*=================================典当行业监测=================================*/
	//所有图标

	//6月上海各类众筹平台新增项目数的成功筹资金额

	//6月上海各类众筹平台新增项目的投资人次

	//私募股权基本情况

	//私募证券基本情况

	//QFLP试点企业最新进展

	//动态图谱

	//诉讼信息

	//核心数据

	/*====================================P2P平台监测============================*/

	/*====================================p2p画像平台============================*/
	//基本信息

	//网贷平台数据展示


	//融资担保


	/*企业全息查询*/

	/*行业监测模块*/
	/* 公共搜索 */

	//诉讼记录的五个接口
	var rootReducer = (0, _redux.combineReducers)({

	  /*企业全息*/
	  CompanyInfoTit: _companyInfoTitRuducer2.default,
	  CompanyInfoNews: _companyInfoNewsRuducer2.default,
	  CompanyInfoA: _companyInfoARuducer2.default,
	  CompanyInfoB: _companyInfoBRuducer2.default,
	  CompanyInfoC1: _companyInfoC1Ruducer2.default,
	  CompanyInfoC2: _companyInfoC2Ruducer2.default,
	  CompanyInfoC3: _companyInfoC3Ruducer2.default,
	  CompanyInfoC4: _companyInfoC4Ruducer2.default,
	  CompanyInfoC5: _companyInfoC5Ruducer2.default,
	  CompanyInfoD1: _companyInfoD1Ruducer2.default,
	  CompanyInfoD2: _companyInfoD2Ruducer2.default,
	  CompanyInfoD3: _companyInfoD3Ruducer2.default,
	  CompanyPic: _companyPic2.default,

	  /*搜索部分*/
	  Common: _Common2.default,
	  /*行业监测模块*/

	  //P2P平台监测

	  AreaRanking: _AreaRanking2.default,
	  NetCredit: _NetCredit2.default,
	  IndexChartAll: _IndexChartAll2.default,

	  //平台画像
	  BaseMsg: _BaseMsg2.default,
	  CompanyMsg: _CompanyMsg2.default,
	  CoreData: _CoreData2.default, CoreBar: _CoreBar2.default, CoreTrend: _CoreTrend2.default, CoreBalance: _CoreBalance2.default,
	  Litigation: _Litigation2.default,
	  PublicOpinion: _PublicOpinion2.default,
	  RankPic: _RankPic2.default,
	  ScoreLeida: _ScoreLeida2.default,
	  CompanyName: _CompanyName2.default,

	  //众筹
	  BusinessTypes: _BusinessTypes2.default,
	  InvestPeople: _InvestPeople2.default,
	  NewProject: _NewProject2.default,
	  RaiseMount: _RaiseMount2.default,
	  List: _List2.default,

	  //典当行业监测
	  PawnMChartAll: _ChartAll2.default,
	  CompanyDirectory: _CompanyDirectory2.default,

	  //私募基金
	  CompanyProgress: _CompanyProgress2.default,
	  QDLPQuality: _QDLPQuality2.default,
	  FundClass: _FundClass2.default,
	  FundCase: _FundCase2.default, FundCaseTop: _FundCaseTop2.default,
	  EquityL: _EquityL2.default,
	  EquityM: _EquityM2.default,
	  EquityR: _EquityR2.default,

	  //交易场所监测
	  HPQList: _HPQList2.default,
	  RegionalDis: _RegionalDis2.default,
	  Classification: _Classification2.default,
	  DetailList: _DetailList2.default,
	  PieCounty: _PieCounty2.default,
	  BarName: _BarName2.default,

	  //小额贷款
	  SmallLoanMap: _SmallLoanMap2.default,
	  CompanyGrade: _CompanyGrade2.default,
	  LoanBalance: _LoanBalance2.default,
	  IndustryRisk: _IndustryRisk2.default,
	  LargeLoan: _LargeLoan2.default,

	  //园区
	  MenuParkSelectVal: _MenuParkSelectVal2.default,
	  MenuParkSelectList: _MenuParkSelectList2.default,

	  //园区首页
	  ParkCamp: _ParkCamp2.default,
	  ParkFinance: _ParkFinance2.default,
	  ParkIndustry: _ParkIndustry2.default,
	  ParkNews: _ParkNews2.default,

	  //园区详情
	  BuildCompanyList: _BuildCompanyList2.default,
	  BuildIndDistri: _BuildIndDistri2.default,
	  CompanyBg: _CompanyBg2.default,
	  BuildList: _BuildList2.default,
	  BuildNews: _BuildNews2.default,
	  BuildRisk: _BuildRisk2.default,
	  BuildSwitchVal: _BuildSwitchVal2.default,
	  ParkImg: _ParkImg2.default,

	  //融资担保
	  FinGuaMap: _FinGuaMap2.default,
	  FinGuaCompanyGrade: _FinGuaCompanyGrade2.default,
	  GuaraDutyBalance: _GuaraDutyBalance2.default,
	  FinGuaIndustryRisk: _FinGuaIndustryRisk2.default,
	  LargeGuara: _LargeGuara2.default,

	  //实时监测
	  RealTimeTable: _realtimeTableRuducer2.default,
	  RealTimeNine: _realtimeNineReducer2.default,
	  RealTimeNews: _realtimeNewsReducer2.default,
	  RealTimeMap: _realtimeMapReducer2.default,
	  RealTimeMapSh: _realtimeMapShReducer2.default,

	  //商业保理监测
	  ChartAll: _ChartAll4.default,
	  businessnumChart: _businessnumChart2.default,
	  balanceChart: _balanceChart2.default,
	  CompanyDirectoryChart: _CompanyDirectoryChart2.default,

	  //预付卡
	  industryTypeChart: _industryTypeChart2.default,
	  TotleMoney: _TotleMoney2.default,

	  //融资租赁
	  Lease: _Lease2.default,
	  ContrastLeft: _ContrastLeft2.default,
	  ContrastRight: _ContrastRight2.default,
	  Catalog: _Catalog2.default,
	  CatalogSelect: _CatalogSelect2.default,
	  TimeSelect: _TimeSelect2.default,

	  //线下理财
	  //线下理财首页
	  LineFinanceRiskDistri: _LineFinanceRiskDistri2.default,
	  LineFinanceList: _LineFinanceList2.default,
	  CheckVal: _CheckVal2.default,

	  DynamicPic: _DynamicPic2.default,
	  SearchResult: _SearchResultList2.default,
	  StaticRisk: _StaticRisk2.default,
	  Statistics: _Statistics2.default,
	  RiskData: _RiskData2.default,
	  CompanyNews: _CompanyNews2.default,
	  QueryDateVersion: _QueryDateVersion2.default,
	  //动态风险
	  DynamicRiskCompanyTag: _DynamicRiskCompanyTag2.default,
	  DynamicRiskDate: _DynamicRiskDate2.default,
	  DynamicRiskLeftImg: _DynamicRiskLeftImg2.default,
	  DynamicRiskRightImg: _DynamicRiskRightImg2.default,
	  DynamicRiskIndexCmp: _DynamicRiskIndexCmp2.default,
	  SelectDate: _SelectDate2.default,
	  //头部搜索传值
	  RiskSearch: _RiskSearch2.default,

	  //首页
	  homeThree: _homeThree2.default,

	  //企业全息信息查询平台
	  infoSearch: _infoSearch2.default,

	  routing: _reactRouterRedux.routerReducer //整合路由
	});
	/*首页 end*/

	/*企业全息信息查询平台 begin*/


	//头部搜索值传递


	//动态风险模块 begein

	/*商业保理监测 end*/

	/*线下理财监测 start*/
	//线下理财首页


	/*众筹监测 end*/

	/*商业保理监测 begin*/


	//园区首页

	/*实时监测 end*/

	//园区

	//取得合规意见或经过会商的交易场所详情列表

	//交易场所清理整顿分类

	//上海市典当企业目录

	//列表

	//6月上海各类众筹平台新增项目数

	/*====================================私募基金===============================*/

	/*=================================众筹监测=================================*/
	//业务类型

	//私募基金分类


	/*====================================p2p画像平台============================*/

	/*====================================私募基金===============================*/
	//QDLP试点企业最新进展

	//评分雷达图

	//平台舆情

	//公司基本信息

	//p2p图表


	/*====================================P2P平台监测============================*/
	//上海区域发展指数排名

	//小额贷款

	//三个echarts图的接口


	/*企业全息查询*/

	exports.default = rootReducer;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "index.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 1394:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});
	exports.default = CompanyName;

	var _P2PPortraitAction = __webpack_require__(856);

	function CompanyName() {
	    var state = arguments.length <= 0 || arguments[0] === undefined ? {
	        county: {}
	    } : arguments[0];
	    var action = arguments[1];

	    switch (action.type) {
	        case _P2PPortraitAction.COMPANY_NAME:
	            return Object.assign({}, state, {
	                county: action.county
	            });
	        default:
	            return state;
	    }
	}

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyName.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})