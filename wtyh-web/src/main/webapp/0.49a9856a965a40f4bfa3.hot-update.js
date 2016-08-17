webpackHotUpdate(0,{

/***/ 951:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	var _reactRouter = __webpack_require__(243);

	__webpack_require__(949);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	var Immutable = __webpack_require__(776);

	var tableDate = {}; //假设第一次把所有的数据都拿回来
	var TopLeft = _react2.default.createClass({
	  displayName: 'TopLeft',
	  getInitialState: function getInitialState() {
	    return {
	      table: null
	    };
	  },
	  componentDidMount: function componentDidMount() {
	    var getRealTimeTable = this.props.getRealTimeTable; // 取到props里面的getRealTimeTable方法。也可以说是请求action

	    var jsonData = {}; //ajax传递给后台的data键值对
	    getRealTimeTable(jsonData);
	  },

	  componentWillReceiveProps: function componentWillReceiveProps(nextProps) {
	    var _this = this;
	    var isEqual = Immutable.is(nextProps.realTimeTableRequest, this.props.realTimeTableResult); //判断数据是否变化
	    if (!isEqual) {
	      var realTimeTableRequest = nextProps.realTimeTableRequest;
	      var realTimeTableResult = nextProps.realTimeTableResult;

	      if (realTimeTableRequest == true) {
	        if (realTimeTableRequest == true) {
	          alert('云哥成功了');
	          console.log(realTimeTableResult, "云哥返回的数据");
	          //这里可以开始渲染数据
	          tableDate = realTimeTableResult; //赋值给全局变量
	          console.log(tableDate.content[0], "云哥的测试");
	          _this.setState({
	            table: _react2.default.createElement(
	              'div',
	              { className: 'table-wrap' },
	              _react2.default.createElement(
	                'table',
	                null,
	                _react2.default.createElement(
	                  'thead',
	                  null,
	                  _react2.default.createElement(
	                    'tr',
	                    null,
	                    _react2.default.createElement(
	                      'th',
	                      null,
	                      '序号'
	                    ),
	                    _react2.default.createElement(
	                      'th',
	                      null,
	                      '公司名字'
	                    ),
	                    _react2.default.createElement(
	                      'th',
	                      null,
	                      '风险暴露日期'
	                    )
	                  )
	                ),
	                _react2.default.createElement(
	                  'tbody',
	                  null,
	                  tableDate.content[0].map(function (elem, index) {
	                    return _react2.default.createElement(
	                      'tr',
	                      null,
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        index + 1
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        elem.name
	                      ),
	                      _react2.default.createElement(
	                        'td',
	                        null,
	                        elem.registered_capital
	                      )
	                    );
	                  })
	                )
	              )
	            )

	          });
	        } else {
	          alert(404);
	        }
	      }
	    }
	  },
	  titleRange: function titleRange(e) {
	    //如果上海地图没有出来，用setOption可能会报错
	    var range = $(e.target).data("range");
	    this.props.getRange(range);
	    var threeContent = range == 1 ? "2014/3/3" : parseInt(Math.random() * 5000);
	    var threeTitle = range == 1 ? "风险暴露日期" : "注册资本";

	    var whichDate = null;
	    // switch(range){
	    //   case:1;
	    //   whichDate = ;
	    //   case:2;
	    //   whichDate= ;
	    //   case:3;
	    //   whichDate= ;
	    //   case:4;
	    //   whichDate= ;
	    // }
	    console.log(tableDate.content[0], "tableDate");
	    console.log(tableDate.content[1], "tableDate");
	    console.log(tableDate.content[2], "tableDate");
	    console.log(tableDate.content[3], "tableDate");
	    // this.setState({
	    //   table:(
	    //         <div className="table-wrap">
	    //               <table>
	    //                 <thead>
	    //                   <tr>
	    //                     <th>序号</th>
	    //                     <th>公司名字</th>
	    //                     <th>{threeTitle}</th>
	    //                   </tr>
	    //                 </thead>
	    //                 <tbody>
	    //                 {
	    //                   tableDate[range-1].map(function(elem,index){
	    //                     return (
	    //                           <tr>
	    //                             <td>{index+1}</td>
	    //                             <td>{elem.name||""}</td>
	    //                             <td>{elem.num||""}</td>
	    //                           </tr>
	    //                       )
	    //                   })
	    //                 }
	    //                 </tbody>
	    //               </table>
	    //         </div>
	    //         )         

	    // })
	  },
	  render: function render() {
	    return _react2.default.createElement(
	      'div',
	      { className: 'realtime-top-left' },
	      _react2.default.createElement(
	        'h4',
	        null,
	        '光谱分析结果'
	      ),
	      _react2.default.createElement(
	        'ul',
	        { className: 'title', onClick: this.titleRange },
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '4' },
	          '重点关注'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '3' },
	          '一般关注'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '2' },
	          '正常'
	        ),
	        _react2.default.createElement(
	          'li',
	          { 'data-range': '1' },
	          '已出风险'
	        )
	      ),
	      this.state.table,
	      _react2.default.createElement(
	        'div',
	        { className: 'color' },
	        _react2.default.createElement('img', { src: './images/bar.png', alt: '' })
	      )
	    );
	  }
	});

	//将state植入 到 props
	exports.default = TopLeft;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "topLeft.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})