webpackHotUpdate(0,{

/***/ 950:
/***/ function(module, exports, __webpack_require__) {

	/* WEBPACK VAR INJECTION */(function(module) {/* REACT HOT LOADER */ if (true) { (function () { var ReactHotAPI = __webpack_require__(76), RootInstanceProvider = __webpack_require__(84), ReactMount = __webpack_require__(86), React = __webpack_require__(138); module.makeHot = module.hot.data ? module.hot.data.makeHot : ReactHotAPI(function () { return RootInstanceProvider.getRootInstances(ReactMount); }, React); })(); } try { (function () {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});

	__webpack_require__(944);

	var _react = __webpack_require__(138);

	var _react2 = _interopRequireDefault(_react);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	/**
	 * �ɶ��߹�
	 */

	var Immutable = __webpack_require__(718);

	var data = "";
	var ShareholderExe = _react2.default.createClass({
		displayName: 'ShareholderExe',
		getInitialState: function getInitialState() {
			return {
				pageNum: 1
			};
		},
		switchPage: function switchPage(param, ev) {
			$(".title-item").removeClass('title-active');
			$(ev.target).addClass('title-active');
			var _pageNum;
			switch (param) {
				case 'share-info':
					_pageNum = 1;
					break;
				case 'exe-info':
					_pageNum = 2;
					break;
			}
			this.setState({
				pageNum: _pageNum
			});
		},

		// componentWillReceiveProps(nextProps) {
		//   var _this = this;
		//   var isEqual=Immutable.is(nextProps.CompanyInfoARequest, this.props.CompanyInfoAResult)//�ж������Ƿ��仯
		//   if(!isEqual){
		//    const {CompanyInfoARequest,CompanyInfoAResult}=nextProps;
		//    debugger;
		//       if(CompanyInfoARequest==true){
		//           data = CompanyInfoAResult.content;
		//           console.log(data,"companyInfoNEWS");
		//           _this.setState({
		// 	      	  person:data.����������,
		// 	          money:data.ע���ʱ�,
		// 	          state:data.״̬,
		// 	          buildTime:data.ע��ʱ��,
		// 	          type:data.��ҵ,
		// 	          num:data.����ע����,
		// 	          companyType:data.��ҵ����,
		// 	          buildNum:data.��֯��������,
		// 	          until:data.Ӫҵ����,
		// 	          whoPass:data.�Ǽǻ���,
		// 	          passTime:data.��׼����,
		// 	          creditNum:data.ͳһ���ô���,
		// 	          businessScope:data.��Ӫ��Χ
		//           })
		//       }else{
		//           // alert(404)
		//       }
		// }

		// },
		// componentDidMount() {
		// 	const {getCompanyInfoA}=this.props;
		// 	var jsonData={
		// 		company:"��֦���н�ͨ���ο����������ι�˾"
		// 	};
		// 	getCompanyInfoA(jsonData);
		// },
		render: function render() {
			return _react2.default.createElement(
				'div',
				{ className: 'shareholder-exe clear-fix' },
				_react2.default.createElement(
					'div',
					{ className: 'shareholder-title' },
					_react2.default.createElement(
						'div',
						{ className: 'title-item title-active', onClick: this.switchPage.bind(this, 'share-info') },
						'�ɶ���Ϣ'
					),
					_react2.default.createElement(
						'div',
						{ className: 'title-item', onClick: this.switchPage.bind(this, 'exe-info') },
						'�߹���Ϣ'
					)
				),
				this.state.pageNum == 1 ? _react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'content-title' },
						_react2.default.createElement(
							'div',
							null,
							'�ɶ�'
						),
						_react2.default.createElement(
							'div',
							null,
							'�ɶ�����'
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'content-content' },
						_react2.default.createElement(
							'div',
							null,
							'����Ժ'
						),
						_react2.default.createElement(
							'div',
							null,
							'���ط���'
						),
						'//ajax'
					)
				) : _react2.default.createElement(
					'div',
					{ className: 'content' },
					_react2.default.createElement(
						'div',
						{ className: 'content-title' },
						_react2.default.createElement(
							'div',
							null,
							'����'
						),
						_react2.default.createElement(
							'div',
							null,
							'ְ��'
						)
					),
					_react2.default.createElement(
						'div',
						{ className: 'content-content' },
						_react2.default.createElement(
							'div',
							null,
							'ϰ����'
						),
						_react2.default.createElement(
							'div',
							null,
							'���ط���'
						),
						'//ajax'
					)
				)
			);
		}
	});
	exports.default = ShareholderExe;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "ShareholderExe.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})