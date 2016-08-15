// 所有模块都通过 define 来定义
define(function(require, exports, module) {
	var $cavNodes = $("#cav-nodes");
	var $cavLinks = $("#cav-links");
	var $cavHover = $("#cav-hover");
	var $cavMainHover = $("#cav-main-hover");
	var $cavHoverNodes = $("#cav-hover-nodes");
	var $allCompany = $("#allCompany");
	var $cavNodesText = $("#cav-nodes-text");

	module.exports = {
		$cavNodes: $cavNodes, //存放节点
		$cavLinks: $cavLinks, //存放关系线
		$cavHover: $cavHover, //鼠标放上去显示
		$cavMainHover: $cavMainHover, //鼠标放上去显示
		$cavHoverNodes: $cavHoverNodes, //DOM节点
		winWid: $cavNodes.width(),
		winHei: $cavNodes.height(),
		rect_width: 10, //默认正方形的宽度
		circle_radius: 5, //默认圆形的半径
		radius: 120, //默认各层之间的半径差（依赖于画布的高度，同时留了100px的空白。默认设置100，初始化的时候会做修改。）
		radiusInner: 30, //内环的宽度
		eachMargin: 40, //每隔50px 一个图标
		nowRadius: 0, //当前的圈半径
		linksData: {}, //存放关系数据
		linksDataStatic: {}, //存放关系数据
		thisNodes: [], //存放关系节点
		thisLinks: [], //存放关系节点
		zr_hover: null, //存放hover关系的图层
		zr_links: null, //存放关联线的图层
		zr_text: null, //存放关联节点文字
		zr: null, //存放节点的图层
		zlevel: 100,
		level: 3, //默认是2度
		allCompanyStr: [], //所有公司的列表
		$allCompany: $allCompany,
		centerCompanyName: '',
		//maxList : 500, //每次只渲染500个公司
		$cavNodesText: $cavNodesText,
		scaleText: 1,
		LEGAL_PERSON: "", //法人数
		NATURE_PERSON: "", //自然人数
		SUB_COMPANY: "", //子公司数
		taoxi: ''
	}
});