webpackHotUpdate(0,{

/***/ 754:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(755);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _index = __webpack_require__(692);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	//风险指数关联图
	var LineFinanceRelationGraph = _react2.default.createClass({
	    displayName: 'LineFinanceRelationGraph',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: '',
	            companyName: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        this.queryDynamicPic(1, companyName);
	    },
	    queryDynamicPic: function queryDynamicPic(param, companyName, ev) {
	        $(".btns .btn").removeClass('active');
	        $(".btns .btn").eq(param - 1).addClass('active');
	        var queryDynamicPic = this.props.queryDynamicPic;

	        queryDynamicPic({
	            "companyName": companyName,
	            "dataVersion": "20160530",
	            "degree": param
	        });
	    },

	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.dynamicPicResult, this.props.dynamicPicResult);
	        if (!isEqual) {
	            (function () {
	                var dynamicPicRequest = nextProps.dynamicPicRequest;
	                var dynamicPicResult = nextProps.dynamicPicResult;

	                if (dynamicPicRequest == true) {
	                    seajs.use("/relativeGraph/assets/script/main/dynamic.js", function (main) {
	                        var pointList = dynamicPicResult.content.pointList;
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
	                        var lineList = dynamicPicResult.content.lineList;
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
	                        console.log(dynamicPicResult, "dynamicPicResult=============================");
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
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '关联方图谱'
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'mod-title-right search-enlarge' },
	                    _react2.default.createElement('i', { className: 'iconfont icon-fullscreen' })
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
	                        { className: 'condition' },
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
	                                { className: 'btn active', onClick: this.queryDynamicPic.bind(this, 1, this.state.companyName) },
	                                '一度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 2, this.state.companyName) },
	                                '二度'
	                            ),
	                            _react2.default.createElement(
	                                'div',
	                                { className: 'btn', onClick: this.queryDynamicPic.bind(this, 3, this.state.companyName) },
	                                '三度'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'relation-modal' },
	                    _react2.default.createElement(
	                        'div',
	                        { className: 'company-title' },
	                        '成都中建明城投资有限公司'
	                    ),
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
	                                    '注册资本'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '500万'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '登记状态'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '在营开业企业'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方法人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '386'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '关联方自然人节点数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '289'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '自然人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '21'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '法人股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '8'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '子股东数'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    null,
	                                    '0'
	                                )
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'a',
	                        { href: '', className: 'see-detail' },
	                        '查看详情'
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
	module.exports = LineFinanceRelationGraph;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "LineFinanceRelationGraph.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 756:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, "/*关联图模块 begin*/\r\n.linefin-rel-graph {\r\n\theight: 1300px;\r\n}\r\n\r\n.linefin-rel-graph .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-rel-graph .mod-title h3 {\r\n}\r\n\r\n.linefin-rel-graph .mod-title .mod-title-right {\r\n\tmargin-top: 5px;\r\n\tdisplay: inline-block;\r\n\tfloat: right;\r\n}\r\n\r\n.linefin-rel-graph .mod-title-right i.icon-fullscreen {\r\n\tmargin-left: 20px;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 6px;\r\n\tfloat: right;\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-rel-graph .mod-content {\r\n\tposition: relative;\r\n}\r\n.linefin-rel-graph .mod-content .pic_rank{\r\n\tposition: absolute;\r\n    right: 17px;\r\n    top: 62px;\r\n}\r\n.linefin-rel-graph .mod-content .pic_rank span{\r\n\tborder: 1px solid #3A4450;\r\n    display: inline-block;\r\n    width: 22px;\r\n    height: 22px;\r\n    background: #19202A;\r\n    text-align: center;\r\n    line-height: 18px;\r\n    color: #E14340;\r\n    cursor:pointer;\r\n    margin-left:8px;\r\n}\r\n\r\n.linefin-rel-graph .mod-content .relation-graph-box {\r\n\theight: 1200px;\r\n}\r\n\r\n/*关联图模块 end*/\r\n\r\n/*公司舆情 begin*/\r\n.linefin-cocompose {\r\n\tmargin-top: 1%;\r\n}\r\n\r\n.linefin-cocompose .mod-title {\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-cocompose .mod-content {\r\n\theight: 550px;\r\n}\r\n\r\n.linefin-cocompose .content-box {\r\n\theight: 534px;\r\n\toverflow: auto;\r\n\tmargin: 20px 20px 0px 20px;\r\n\tbackground-color: #212831;\r\n\tpadding: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box {\r\n\toverflow: hidden;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 a {\r\n\tcolor: #ffffff;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box h4 em {\r\n\tdisplay: inline-block;\r\n\ttext-align: center;\r\n\twidth: 24px;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\tborder-radius: 2px;\r\n\tbackground-color: #1a2029;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box p {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tmargin-left: 45px;\r\n\ttext-indent: 28px;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source {\r\n\tfont-size: 14px;\r\n\tmargin-top: 5px;\r\n\tfloat: right;\r\n\tcolor: #e14340;\r\n}\r\n\r\n.linefin-cocompose .content-box .list-box .source .name {\r\n\tmargin-right: 40px;\r\n}\r\n\r\n/**公司舆情 end*/\r\n\r\n/*静态风险指数构成 begin*/\r\n.linefin-index-constitute .mod-title {\r\n\tbackground-color: #394351;\r\n}\r\n\r\n.linefin-index-constitute .mt-select {\r\n\tmargin-top: 5px;\r\n\tmargin-right: 5px;\r\n\tcolor: #c9c9ca;\r\n}\r\n\r\n.linefin-index-constitute .con-box {\r\n\tbackground-color: #2b323c;\r\n\tpadding: 0 20px;\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-info {\r\n\tmin-height: 1362px;\r\n\t\r\n}\r\n\r\n.linefin-index-constitute .con-box .index-con-pie {\r\n\theight: 520px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item {\r\n\tcursor: pointer;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-head {\r\n\tbackground-color: #1a2029;\r\n\tborder-bottom: solid 1px #2b323c;\r\n\theight: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span {\r\n\tdisplay: block;\r\n\tfloat: left;\r\n\tfont-size: 14px;\r\n\theight: 20px;\r\n\tline-height: 20px;\r\n\tmargin-top: 10px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.name {\r\n\tcolor: #e5e5e5;\r\n\twidth: 40%;\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info  .item-head span.num {\r\n\twidth: 60%;\r\n\ttext-indent: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head {\r\n\theight: 60px;\r\n\tbackground-color: #e14340;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span {\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.name {\r\n\tfont-size: 18px;\r\n\tborder-color: #ed8e8c;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-first .item-head span.num em {\r\n\tfont-size: 36px;\r\n\tcolor: #ffffff;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item-other .item-head span.num i {\r\n\tfloat: right;\r\n\tmargin-right: 20px;\r\n\tmargin-top: 3px;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table {\r\n\twidth: 100%;\r\n\tbackground-color: #36404d;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table {\r\n\twidth: 100%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td {\r\n\tborder-bottom: solid 1px #2b323c;\r\n\tpadding: 10px 0;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-left {\r\n\tborder-right: solid 2px #2b323c;\r\n\tpadding-left: 20px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-table table td.t-right {\r\n\tpadding-left: 10%;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart {\r\n\theight: 330px;\r\n\tbackground-color: #212831;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart h4 {\r\n\tbackground-color: #1a2029;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tpadding: 0 20px;\r\n\tfont-size: 16px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-chart .chart-b {\r\n\theight: 290px;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-head span.name {\r\n\tfont-size: 16px;\r\n\tborder-color: #d0d8df;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item .item-con {\r\n\tdisplay: none;\r\n}\r\n\r\n.linefin-index-constitute .index-con-info .item.active .item-con {\r\n\tdisplay: block;\r\n}\r\n\r\n/*关联图 图例 begin*/\r\n.relation-legend {\r\n\tmargin: 25px 0 15px 10px;\r\n\twidth: 99%;\r\n\theight: 56px;\r\n}\r\n\r\n.relation-legend table {\r\n\tbackground: #1a2029;\r\n\twidth: 80%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n}\r\n\r\n.relation-legend table tr {\r\n\theight: 50%;\r\n\twidth: 10%;\r\n}\r\n\r\n.relation-legend table tr td {\r\n\tpadding: 8px 0 0 14px;\r\n\tposition: relative;\r\n\twidth: 19.8%;\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.relation-legend table tr span {\r\n\tdisplay: inline-block;\r\n}\r\n\r\n.relation-legend table tr .item-lable {\r\n\tfont-size: 12px;\r\n\tcolor: #b2b2b2;\r\n\tposition: absolute;\r\n}\r\n\r\n.relation-legend table tr img {\r\n\tmargin: -5px 20px 0 0;\r\n}\r\n\r\n.relation-legend table tr .square {\r\n\twidth: 17px;\r\n\theight: 17px;\r\n\tmargin-right: 20px;\r\n}\r\n\r\n.relation-legend table tr .round {\r\n\twidth: 17px;\r\n\theight: 17px;\r\n\tmargin-right: 20px;\r\n\tborder-radius: 100px;\r\n}\r\n\r\n.relation-legend table tr .orange {\r\n\tbackground: #f44603;\r\n}\r\n\r\n.relation-legend table tr .orange-two {\r\n\tbackground: #f98d2b;\r\n}\r\n\r\n.relation-legend table tr .blue {\r\n\tbackground: #046adb;\r\n}\r\n\r\n.relation-legend table tr .yellow {\r\n\tbackground: #ffdb03;\r\n}\r\n\r\n.relation-legend table tr .green {\r\n\tbackground: #73d528;\r\n}\r\n\r\n.relation-legend .condition {\r\n\twidth: 19.6%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n\tmargin-left: 2px;\r\n\tbackground: #212831;\r\n}\r\n\r\n.relation-legend .condition .lable {\r\n\tfont-size: 12px;\r\n\tcolor: #fff;\r\n\twidth: 100%;\r\n\theight: 50%;\r\n\tpadding-top: 8px;\r\n\tline-height: 100%;\r\n\ttext-align: center;\r\n}\r\n\r\n.relation-legend .condition .btns {\r\n\twidth: 100%;\r\n\theight: 50%;\r\n}\r\n\r\n.relation-legend .condition .btns .btn {\r\n\tbackground: #474f5c;\r\n\tfloat: left;\r\n\twidth: 32.5%;\r\n\theight: 100%;\r\n\tmargin-left: 1px;\r\n\ttext-align: center;\r\n\tpadding-top: 5px;\r\n\tcursor: pointer;\r\n}\r\n\r\n.relation-legend .condition .btns .btn.active {\r\n\tbackground-color: #00b8ee;\r\n}\r\n\r\n.relation-modal {\r\n\tposition: absolute;\r\n\tleft: 10px;\r\n\ttop: 100px;\r\n\twidth: 270px;\r\n\tpadding-bottom: 5px;\r\n\tborder-radius: 5px;\r\n\tbackground: #222931;\r\n\tz-index: 99999;\r\n\t-webkit-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n\t-moz-box-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n\tbox-shadow: 3px 3px 10px rgba(0, 0, 0, 0.5);\r\n}\r\n\r\n.relation-modal .company-title {\r\n\twidth: 100%;\r\n\theight: 30px;\r\n\tline-height: 30px;\r\n\tpadding-left: 5%;\r\n\tbackground: #4B5668;\r\n\tborder-top-left-radius: 5px;\r\n\tborder-top-right-radius: 5px;\r\n}\r\n\r\n.relation-modal table {\r\n\twidth: 100%;\r\n}\r\n\r\n.relation-modal table tr {\r\n\twidth: 100%;\r\n}\r\n\r\n.relation-modal table tr td {\r\n\theight: 27px;\r\n\tline-height: 27px;\r\n\tfont-size: 12px;\r\n}\r\n\r\n.relation-modal table tr td:first-child {\r\n\twidth: 60%;\r\n\tcolor: #878E96;\r\n\tpadding-left: 5%;\r\n}\r\n\r\n.relation-modal table tr td:last-child {\r\n\twidth: 40%;\r\n}\r\n\r\n.relation-modal .see-detail {\r\n\tfont-size: 12px;\r\n\theight: 24px;\r\n\tline-height: 24px;\r\n\tcolor: #ffffff;\r\n\ttext-align: center;\r\n\tdisplay: block;\r\n\tborder-radius: 5px;\r\n\tbackground-color: #e14340;\r\n\tmargin-top: 10px;\r\n\tmargin-bottom: 10px;\r\n\tmargin-left: 10px;\r\n\tmargin-right: 10px;\r\n}\r\n\r\n/*关联图 图例 end*/\r\n\r\n/*关联图 侧边栏begin*/\r\n.sidebox {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation-tips {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .sidebar {\r\n\tdisplay: none;\r\n}\r\n\r\n.correlation .canvas {\r\n\tmargin-right: auto !important;\r\n}\r\n\r\n.correlation .time-line {\r\n\tdisplay: none;\r\n}\r\n\r\n/*关联图 end*/\r\n\r\n/*静态风险指数构成 end*/", ""]);

	// exports


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
	            allDate: "",
	            companyName: "",
	            pieOption: ""
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var companyName = this.props.location.query.companyName;
	        this.setState({ companyName: companyName });

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
	            this.setParm(nextProps.riskDataResult.content);
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
	            this.queryRiskData(_allDate[0].label); //首次获取时间请求列表
	        }

	        var statisticsIsEqual = Immutable.is(nextProps.statisticsRequest, this.props.statisticsRequest);
	        if (!statisticsIsEqual) {
	            this.setState({
	                lineOption: nextProps.statisticsResult
	            });
	        }
	    },
	    queryRiskData: function queryRiskData(currentDate) {
	        //获取列表数据
	        var jsonData = { companyName: this.state.companyName, currentDate: currentDate };
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
	            //关闭
	            if (!isFirstItem) {
	                //不是第一项
	                $itemParent.removeClass('active');
	                $(this.refs.itemFirst).addClass('active');
	                $itemParent.find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            } else {
	                $('.item-other').removeClass('active');
	                $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
	            }
	        } else {
	            //@yq 修改bug5630 
	            $(".item-other").removeClass('active');
	            $('.item-other').find('.item-head .num i').removeClass('icon-xup').addClass('icon-xdown');
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
	    setParm: function setParm(itemTable) {
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
	            placeholder: this.state.allDate ? this.state.allDate[0].label : '',
	            name: 'testselect',
	            id: 'indexSelected',
	            data: this.state.allDate,
	            onChange: function onChange(val) {
	                self.state.allDate.map(function (item) {
	                    if (item.value == val) {
	                        var queryRiskData = self.props.queryRiskData;

	                        queryRiskData({ companyName: self.state.companyName, currentDate: item.label });
	                    }
	                });
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
	                    this.state.allDate ? _react2.default.createElement(_index.Selected, selectProp) : ''
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
	                        { className: 'index-con-info clear' },
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

/***/ 791:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var BBDMap = _react2.default.createClass({
	    displayName: 'BBDMap',

	    propTypes: {
	        option: _react2.default.PropTypes.object.isRequired,
	        style: _react2.default.PropTypes.object,
	        className: _react2.default.PropTypes.string,
	        theme: _react2.default.PropTypes.string,
	        onChartReady: _react2.default.PropTypes.func,
	        showLoading: _react2.default.PropTypes.bool,
	        onEvents: _react2.default.PropTypes.object
	    },
	    setOption: function setOption(parm) {
	        //值阀最大值
	        var maxData = parm.series[0].value;
	        for (var i = 0; i < parm.series.length; i++) {
	            if (Number(parm.series[i].value) > maxData) {
	                maxData = Number(parm.series[i].value);
	            }
	        }
	        var option = {
	            tooltip: {
	                trigger: 'item',
	                backgroundColor: 'rgba(0,0,0,0.7)',
	                padding: [10, 10, 10, 10],
	                formatter: function formatter(v) {
	                    var _until = "";
	                    if (parm.unit == undefined) {
	                        _until = "";
	                    } else {
	                        _until = parm.unit;
	                    }
	                    if (!isNaN(v.value)) {
	                        return v.name + "<br/>" + v.seriesName + ":<span style='color:#00b7f0'>" + v.value + _until + "</span>";
	                    } else {
	                        return v.name;
	                    }
	                }
	            },
	            visualMap: {
	                min: 0,
	                max: maxData,
	                itemWidth: "15",
	                textGap: 30,
	                right: parm.visualMapRight == undefined ? "auto" : parm.visualMapRight,
	                bottom: parm.visualMapBottom == undefined ? "auto" : parm.visualMapBottom,
	                padding: [0, 0, 20, 50],
	                text: parm.visualMapText,
	                realtime: false,
	                calculable: true,
	                textStyle: {
	                    color: '#fff'
	                },
	                inRange: {
	                    color: ['rgba(4, 184, 245, 1)', 'rgba(14, 155, 200, 1)', 'rgba(34, 114, 139, 1)']
	                }
	            },
	            series: [{
	                type: 'map',
	                name: parm.seriesName == undefined ? "P2P公司数" : parm.seriesName,
	                map: 'shanghai',
	                animationDurationUpdate: 1000,
	                animationEasingUpdate: 'quinticInOut',
	                itemStyle: {
	                    normal: {
	                        label: {
	                            show: false
	                        },
	                        borderColor: '#a7d1df',
	                        areaColor: '#fff'
	                    },
	                    emphasis: {
	                        label: {
	                            show: false
	                        },
	                        areaColor: '#a7d1df',
	                        borderWidth: 0
	                    }
	                },
	                data: parm.series
	            }]
	        };
	        return option;
	    },
	    componentDidMount: function componentDidMount() {
	        var echartObj = this.renderEchartDom();
	        var onEvents = this.props.onEvents || [];

	        var _loop = function _loop(eventName) {
	            if (typeof eventName === 'string' && typeof onEvents[eventName] === 'function') {
	                echartObj.on(eventName, function (param) {
	                    onEvents[eventName](param, echartObj);
	                });
	            }
	        };

	        for (var eventName in onEvents) {
	            _loop(eventName);
	        }
	        // if (typeof this.props.onChartReady === 'function') this.props.onChartReady(echartObj);
	        // elementResizeEvent(this.refs.echartsDom, function() {
	        // 	echartObj.resize();
	        // });
	        //
	        $(window).resize(function () {
	            echartObj.resize();
	        });
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        this.renderEchartDom();
	    },
	    componentWillUnmount: function componentWillUnmount() {
	        echarts.dispose(this.refs.chart);
	    },
	    renderEchartDom: function renderEchartDom() {
	        var echartObj = this.getEchartsInstance();
	        echartObj.setOption(this.setOption(this.props.option));

	        if (this.props.showLoading) {
	            echartObj.showLoading();
	        } else {
	            echartObj.hideLoading();
	        }
	        return echartObj;
	    },
	    getEchartsInstance: function getEchartsInstance() {
	        return echarts.getInstanceByDom(this.refs.echartsDom) || echarts.init(this.refs.echartsDom, this.props.theme);
	    },
	    render: function render() {
	        var style = this.props.style || {
	            height: '300px'
	        };
	        return _react2.default.createElement('div', { ref: 'echartsDom', style: style });
	    }
	});
	exports.default = BBDMap;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "MapChart.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 801:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(688)();
	// imports


	// module
	exports.push([module.id, ".privateFund-index .content {\r\n\tpadding: 20px 20px 50px 20px\r\n}\r\n\r\n.privateFund-index .privateF-m {\r\n\tmargin: 0.5% 0px;\r\n}\r\n\r\n.privateFund-index .privateF-m {\r\n}\r\n\r\n.privateFund-index .privateF-m .middle-l {\r\n\twidth: 45%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-m .middle-r {\r\n\twidth: 54.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l {\r\n\twidth: 60%;\r\n\tfloat: left;\r\n\theight: 612px;\r\n\toverflow: hidden;\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l .top-left-l {\r\n\twidth: 60%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-l .top-left-r {\r\n\twidth: 39.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left\r\n}\r\n\r\n.privateFund-index .privateF-t .top-r {\r\n\twidth: 39.5%;\r\n\tmargin-left: 0.5%;\r\n\tfloat: left;\r\n\theight: 612px;\r\n}\r\n\r\n.privateFund-index .privateF-b {\r\n}\r\n\r\n.privateFund-index .privateF-b .bottom-l,\r\n.privateFund-index .privateF-b .bottom-m,\r\n.privateFund-index .privateF-b .bottom-r {\r\n\twidth: 33.3%;\r\n\tfloat: left;\r\n}\r\n\r\n.privateFund-index a {\r\n\tcolor: #e14340 !important\r\n}", ""]);

	// exports


/***/ },

/***/ 806:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(803);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var QDLPQuality = _react2.default.createClass({
	    displayName: 'QDLPQuality',

	    getInitialState: function getInitialState() {
	        return {
	            listData: [],
	            orderType: "desc", //默认降序
	            orderField: "" //需要排序的字段
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        var getQDLPQualityRequest = this.props.getQDLPQualityRequest;

	        var jsonData = {};
	        getQDLPQualityRequest(jsonData);
	        $('#qdlpQuality-scroll').perfectScrollbar();
	    },
	    handleClick: function handleClick(field) {
	        var _dom = $(this.refs[field]),
	            _domAttr = _dom.attr("data-order"),
	            _domIco = _dom.find("em"),
	            _domIcoIs = _dom.find("em").hasClass('icon-desc');
	        _domIcoIs == true ? _domIco.removeClass('icon-desc').addClass('icon-asc') : _domIco.removeClass('icon-asc').addClass('icon-desc');
	        _domAttr == "desc" ? _dom.attr("data-order", "asc") : _dom.attr("data-order", "desc");
	        this.setState({ orderType: _dom.attr("data-order"), orderField: field }, function () {
	            var _basedata = BOSS.sort(this.state.listData, field, this.state.orderType);
	            this.setState({ listData: _basedata });
	        });
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.QDLPQualityRequest, this.props.QDLPQualityResult);
	        if (!isEqual) {
	            var QDLPQualityRequest = nextProps.QDLPQualityRequest;
	            var QDLPQualityResult = nextProps.QDLPQualityResult;

	            if (QDLPQualityRequest == true) {
	                if (QDLPQualityResult.success) {
	                    this.setState({ listData: QDLPQualityResult.content });
	                } else {
	                    //错误后提示
	                }
	            }
	        }
	    },
	    componentDidUpdate: function componentDidUpdate() {
	        $('#qdlpQuality-scroll').perfectScrollbar('update');
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod top-r radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'list-header' },
	                'QFLP试点企业最新进展'
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-content' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-title' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'thead',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                null,
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '10%', className: 'talign-center' },
	                                    '序号'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '30%' },
	                                    '试点企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'total', onClick: this.handleClick.bind(this, "total") },
	                                    '总规模($)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'dollarPart', onClick: this.handleClick.bind(this, "dollarPart") },
	                                    '美元部分($)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '20%', className: 'cur-pointer', 'data-order': this.state.orderType, ref: 'rmbTotal', onClick: this.handleClick.bind(this, "rmbTotal") },
	                                    '投资合计(￥)',
	                                    _react2.default.createElement('em', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content', id: 'qdlpQuality-scroll' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center table-border-b wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            this.state.listData.map(function (item, index) {
	                                {
	                                    var num = index + 1;
	                                    if (index % 2) {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'even' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal,
	                                                '亿'
	                                            )
	                                        );
	                                    } else {
	                                        return _react2.default.createElement(
	                                            'tr',
	                                            { className: 'odd' },
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '10%', className: 'talign-center' },
	                                                num
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '30%' },
	                                                _react2.default.createElement(
	                                                    _reactRouter.Link,
	                                                    { to: { pathname: '/SearchResultDetail', query: { formpage: 'QDLPQuality', companyName: item.companyName } }, className: 'word-limit-5', 'data-tip': item.companyName, title: item.companyName },
	                                                    item.companyName
	                                                )
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.total,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.dollarPart,
	                                                '亿'
	                                            ),
	                                            _react2.default.createElement(
	                                                'td',
	                                                { width: '20%' },
	                                                item.rmbTotal,
	                                                '亿'
	                                            )
	                                        );
	                                    }
	                                }
	                            })
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	module.exports = QDLPQuality;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "QDLPQuality.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ },

/***/ 877:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(873);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	var _reactRedux = __webpack_require__(317);

	var _BarChart = __webpack_require__(850);

	var _BarChart2 = _interopRequireDefault(_BarChart);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(718);
	var Income = _react2.default.createClass({
	    displayName: 'Income',


	    getInitialState: function getInitialState() {
	        return {
	            option: null
	        };
	    },
	    componentDidMount: function componentDidMount() {},
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.Data, this.props.Data);
	        if (!isEqual) {
	            var Data = nextProps.Data;

	            var optionParm = {
	                title: "平台交易量走势",
	                titleX: "center",
	                color: ["#12b5b0"],
	                barWidth: 20,
	                yAxisName: "亿元",
	                yFlag: "", //y轴单位
	                splitLineShow: false,
	                gridBottom: '5%',
	                gridTop: '15%',
	                gridLeft: '5%',
	                gridRight: '5%',
	                unit: ["亿元"],
	                legend: ["平台交易量走势"],
	                legendShow: false,
	                xAxis: Data.xAxisData,
	                series: [Data.data]
	            };
	            this.setState({ option: optionParm });
	        }
	    },
	    render: function render() {
	        var chartBox = "";
	        if (this.state.option) {
	            chartBox = _react2.default.createElement(_BarChart2.default, { option: this.state.option, style: { height: '465px', width: '100%' } });
	        }
	        return _react2.default.createElement(
	            'div',
	            { className: 'mod middle-right radius4' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '典当总费收入'
	                )
	            ),
	            chartBox
	        );
	    }
	});

	module.exports = Income;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "Income.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})