webpackHotUpdate(0,{

/***/ 805:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	__webpack_require__(806);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	//企业评级
	var CompanyGrade = _react2.default.createClass({
	    displayName: 'CompanyGrade',

	    componentDidMount: function componentDidMount() {
	        console.log(this.props, 3333);
	        var getCompanyGrade = this.props.getCompanyGrade;

	        var jsonData = {};
	        getCompanyGrade(jsonData);
	    },
	    componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	        var isEqual = Immutable.is(nextProps.companyGradeRequest, this.props.companyGradeResult); //判断数据是否变化
	        if (!isEqual) {
	            var companyGradeRequest = nextProps.companyGradeRequest;
	            var companyGradeResult = nextProps.companyGradeResult;

	            if (companyGradeRequest == true) {
	                if (companyGradeResult.code == 200) {
	                    console.log('成功了');
	                    //这里可以开始渲染数据
	                } else {
	                        console.log(404);
	                    }
	            }
	        }
	    },
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'company-grade mod' },
	            _react2.default.createElement(
	                'div',
	                { className: 'mod-title' },
	                _react2.default.createElement(
	                    'h3',
	                    null,
	                    '企业评级'
	                )
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
	                                    { width: '25%', className: 'talign-left' },
	                                    '企业名称'
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '外部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '内部评级',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                ),
	                                _react2.default.createElement(
	                                    'th',
	                                    { width: '25%' },
	                                    '现场检查',
	                                    _react2.default.createElement('i', { className: 'iconfont icon-desc' })
	                                )
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'table-content' },
	                    _react2.default.createElement(
	                        'table',
	                        { className: 'mt-table mt-table-center wtyh-table' },
	                        _react2.default.createElement(
	                            'tbody',
	                            null,
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'odd' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            ),
	                            _react2.default.createElement(
	                                'tr',
	                                { className: 'even' },
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%', className: 'talign-left' },
	                                    _react2.default.createElement(
	                                        'span',
	                                        { className: 'word-limit-5', 'data-tip': '嘉定大众小贷' },
	                                        '嘉定大众小贷'
	                                    )
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                ),
	                                _react2.default.createElement(
	                                    'td',
	                                    { width: '25%' },
	                                    'B'
	                                )
	                            )
	                        )
	                    )
	                )
	            )
	        );
	    }
	});
	module.exports = CompanyGrade;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "CompanyGrade.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})