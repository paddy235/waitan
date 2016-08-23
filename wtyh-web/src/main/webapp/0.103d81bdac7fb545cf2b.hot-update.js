webpackHotUpdate(0,{

/***/ 954:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	    value: true
	});

	__webpack_require__(955);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/*
	 *关联方图谱
	 */

	var Immutable = __webpack_require__(718);
	var AssociationGraph = _react2.default.createClass({
	    displayName: 'AssociationGraph',

	    getInitialState: function getInitialState() {
	        return {
	            searchVal: ''
	        };
	    },
	    componentDidMount: function componentDidMount() {
	        seajs.use("/relativeGraph/assets/script/main/dynamic");
	        var companyPicRequest = this.props.companyPicRequest;

	        companyPicRequest({
	            "platName": this.state.companyVal,
	            "companyName": this.props.location.query.companyName,
	            "dataVersion": "20160530",
	            "degree": 1
	        });
	        // require('/relativeGraph/assets/script/dynamic.js').reDrawCanvas();
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.CompanyPicRequest, this.props.CompanyPicResult);
	        if (!isEqual) {
	            (function () {
	                var CompanyPicRequest = nextProps.CompanyPicRequest;
	                var CompanyPicResult = nextProps.CompanyPicResult;

	                if (CompanyPicRequest == true) {
	                    // if (rankPicResult.success) {
	                    seajs.use("/relativeGraph/assets/script/main/dynamic.js", function (main) {
	                        var pointList = CompanyPicResult.pointList;
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
	                        var lineList = CompanyPicResult.lineList;
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
	            { className: 'linefin-rel-graph relation-map mod-space-l mod-space-t' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '关联方图'
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
	exports.default = AssociationGraph;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "AssociationGraph.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})