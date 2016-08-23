webpackHotUpdate(0,{

/***/ 725:
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

	//

	var getRandomInScope = function getRandomInScope(min, max) {
	    return Math.floor(min + Math.random() * (max - min));
	};
	//上海点的经纬度
	var geoCoordMapShanghai = {
	    "黄浦区": [121.491193, 31.237373],
	    "浦东新区": [121.550543, 31.227391],
	    "徐汇区": [121.442885, 31.194911],
	    "长宁区": [121.430868, 31.426536],
	    "静安区": [121.453978, 31.234087],
	    "普陀区": [121.403, 31.2551],
	    "虹口区": [121.511735, 31.270146],
	    "杨浦区": [121.532291, 31.465779],
	    "闵行区": [121.388372, 31.118512],
	    "宝山区": [121.495971, 31.410956],
	    "嘉定区": [121.272804, 31.380475],
	    "金山区": [121.348902, 30.747995],
	    "松江区": [121.235472, 31.038175],
	    "青浦区": [121.130784, 31.155521],
	    "奉贤区": [121.480604, 30.923204],
	    "崇明区": [121.4038180000, 31.6286640000],
	    "上海": [121.4648, 31.2891]
	};
	var SHData = [[{ name: '黄浦区', value: 80 }, { name: '上海' }], [{ name: '浦东新区', value: 90 }, { name: '上海' }], [{ name: '徐汇区', value: 80 }, { name: '上海' }], //
	[{ name: '长宁区', value: 70 }, { name: '上海' }], //
	[{ name: '静安区', value: 60 }, { name: '上海' }], //
	[{ name: '普陀区', value: 50 }, { name: '上海' }], //
	[{ name: '虹口区', value: 40 }, { name: '上海' }], //
	[{ name: '杨浦区', value: 30 }, { name: '上海' }], //
	[{ name: '闵行区', value: 30 }, { name: '上海' }], //
	[{ name: '宝山区', value: 30 }, { name: '上海' }], //
	[{ name: '金山区', value: 30 }, { name: '上海' }], //
	[{ name: '松江区', value: 30 }, { name: '上海' }], //
	[{ name: '青浦区', value: 30 }, { name: '上海' }], //
	[{ name: '奉贤区', value: 30 }, { name: '上海' }], //
	[{ name: '崇明区', value: 30 }, { name: '上海' }] //
	];

	var convertData = function convertData(data) {
	    var res = [];
	    for (var i = 0; i < data.length; i++) {
	        var dataItem = data[i];
	        var fromCoord = geoCoordMapShanghai[dataItem[0].name];
	        var toCoord = geoCoordMapShanghai[dataItem[1].name];
	        if (fromCoord && toCoord) {
	            res.push({
	                fromName: dataItem[0].name,
	                toName: dataItem[1].name,
	                coords: [fromCoord, toCoord]
	            });
	        }
	    }
	    return res;
	};
	var color = ['#facd89', '#ffa022', '#46bee9'];
	var HomeTwo = _react2.default.createClass({
	    displayName: 'HomeTwo',

	    //首页地图
	    initMap: function initMap() {
	        echarts.registerMap('shanghai', { "type": "FeatureCollection", "features": [{ "id": "310101", "geometry": { "type": "Polygon", "coordinates": ["@@AE@GDEVSHMAGOYKKCCcGCDGBALCPIAAPIV@DV@BDCPEPLENFHCJHFB"], "encodeOffsets": [[124411, 31993]] }, "properties": { "cp": [121.490317, 31.222771], "name": "黄浦区", "childNum": 1 } }, { "id": "310104", "geometry": { "type": "Polygon", "coordinates": ["@@FOBOJBDOBKHADCOGCEAE@EFOBMAEUW@GBEHILMBE@KKSAMMAE@AFA@@BC@ABC@@BD@@BH@@BB@EHDDCBECADGEEAEBFNET]CMRELQjOEGRFBAHDBAHH@@B@BDA`H@F@BC@AB@FD@DD@@@CH@DDAFDD^LEPF@DFTDLHD@@A"], "encodeOffsets": [[124374, 31969]] }, "properties": { "cp": [121.43752, 31.179973], "name": "徐汇区", "childNum": 1 } }, { "id": "310105", "geometry": { "type": "Polygon", "coordinates": ["@@CEE@FO]KCCBECCG@@D@@CCmBSAcKG@EBAEGC@DC@QE@CA@@BEBMTNFAFDBA`D@BDA@AA@FFBBLD@@@IBDBABDB@@DBADB@CHA@@DC@C@@@BBABFDH@AHD@ACDA@FD@BCA@@CJCNWJ@BCHAFEF@XCV@DFH@VFBBCFLEFFFBB@@IDAJFBABIFK"], "encodeOffsets": [[124355, 31964]] }, "properties": { "cp": [121.4222, 31.218123], "name": "长宁区", "childNum": 1 } }, { "id": "310106", "geometry": { "type": "Polygon", "coordinates": ["@@DOACU@BGSGQCELAJABIECBBNFHJB\\PNKD@JHFM"], "encodeOffsets": [[124382, 31984]] }, "properties": { "cp": [121.448224, 31.229003], "name": "静安区", "childNum": 1 } }, { "id": "310107", "geometry": { "type": "Polygon", "coordinates": ["@@DB@DHBBCDBB@A@DF@@DFDDHGBDDALZIDA@ACQ@@DGBEFBB@FD@J@BFMBCCCDID@AODAEIDBDEBABBB@DC@AF@@AFGACBADBB@@NFADD@@BB@B@BAB@BBDA@HBB@AJ@@AD@@BB@AFHBDCJFHBGQAAJA@ALCBBF@@AB@@BD@@@JABDABD@@BHBBBNACEJA@ADAAA@B@ADAAAJBIQB@FCBBD@AGJ@@EJA@EHADDAB@BFANNDEVIPUAGD@@CA@@ECCBC@AGASKIAEGACA@EAEEA@EFC@DEAAUEG@CEU@WDE@EFGBADI@IP"], "encodeOffsets": [[124267, 31987]] }, "properties": { "cp": [121.392499, 31.241701], "name": "普陀区", "childNum": 1 } }, { "id": "310108", "geometry": { "type": "Polygon", "coordinates": ["@@ASG@BOCKCEBA@G@KBEDCLMVQ@EACDECABCDKECGDMEKFIGC@ONDF@FB@@DC@BHOVUJCFIGA@@RCJBNG@ABBDBB@DNBAJJ@@FB@@H@@@DF@ENB@BDD@BAT@BENDFDPB@AF@@G"], "encodeOffsets": [[124384, 32068]] }, "properties": { "cp": [121.465689, 31.25318], "name": "闸北区", "childNum": 1 } }, { "id": "310109", "geometry": { "type": "Polygon", "coordinates": ["@@VCNB@UHWVFBABIKK@MJCJGBKV[C@@I[AOEODCACCCLADDBCFBD@FURKNCDAF@L@HABDFDLAPH@BR"], "encodeOffsets": [[124384, 32068]] }, "properties": { "cp": [121.491832, 31.26097], "name": "虹口区", "childNum": 1 } }, { "id": "310110", "geometry": { "type": "Polygon", "coordinates": ["@@pSNGDCDGDM@cBGL[BKAGEGMOcY[GWA@JD@U\\ALIHID@NLLAJABUEGX@PVA@ZDDADGFX`ZKDHFA"], "encodeOffsets": [[124443, 32100]] }, "properties": { "cp": [121.522797, 31.270755], "name": "杨浦区", "childNum": 1 } }, { "id": "310112", "geometry": { "type": "Polygon", "coordinates": ["@@BAAA@@D@D@@CB@DGA@BCCA@@CABACAJA@@C@AKEA@EBBB@ACC@B_CABEMENSFA@AB@@DRFD@@CHDBFNA`JVDlA@EBAD@@A@E_GCB@A@AG@BGCABGEAHQPFRiFKNQ^DFSEMFAFBHFBCFDDACCFGA@@AG@@AC@@AD@BAD@@AB@BEF@F@B@FBBNDFLCDBCBFB@DFG@CBBABDB@CDBAFCB@DABD@B@DB@BD@@B@BB@B@@FJ@DKLFB@DMDBBABBCFDB@@HB@BBABBDCBGNBDAB@@BPDBAF@@AB@@AB@@CDB@BF@DGB@@CD@FDADF@BADDDCBBDCAAC@BCFEAAB@FECABC@ADBBEB@@EGCABAB@@CAA@CAIABAAA@@ECDGD@BCBBD@BBHBFALABAFBD@@CGA@BC@BCEAA@A@@AEA@@AAA@G@DCG@CCBAAA@ADBDAEAC@ACE@BCC@BG@ACBBAEAAA@B@CECDEAEBAB@BDB@DBD@BBD@FDBGBBFCAABCBDBCEC@UBACA@AAA@ABB@CCCE@AA@ADCD@@BF@@FB@@BDB@CDB@ED@DFB@ABB@HDAADCBE@CCACC@CACIABA@@@BD@@AD@DICABCECFA@AMEO@@CC@ABA@@ABA@GCACBADCDA@@BAAAB@BICADE@@BEAABC@GHC@E@@FD@@BA@CFC@@BC@AASEKG@ACAIZBFGDYCIAKGKAU@OCGAKIMIMCOEeCWOBWHG@CDBZHBPTBHJHABECM@ADBB@J@F@D@B@FBDAD@NBBBN@T@DBBADFCFDDGTDJFAFNB@DB@EFFBADD@@DFDDCDBCJGPAB@DELGAADMCEPHB@AB@@BHF@BABCAABA@AFFB@@CDCAEHB@EHBBCF@BADEJE@ADD@BDGFADA@@FCB@DCDAFA@ABGA@BE@ABHD@@BB@DABABEJAFCHEHABAFCD@BABCFCB@BED@BA@@BABADGFAAA@@CAAKGCAKAUTC@CDDBADIHDFCF@@CDBDCHDBAHGDBDCDABCAAB@BA@@DKACBDDABBF@@@BHBBDDBC@BDFFFBBDD@@AH@HB@EFC@ABC@FFCFBB@LCFBBAEGFEDABGJMJCL@XGNFH@PDBB@DDD"], "encodeOffsets": [[124251, 31988]] }, "properties": { "cp": [121.375972, 31.111658], "name": "闵行区", "childNum": 1 } }, { "id": "310113", "geometry": { "type": "Polygon", "coordinates": ['@@@FMAUD@JE@@BOAECMCAFS@ABC@ACA@FME@@C@@@GA@@EI@BIMA@CCA@CBAH@AMDI@OBACEEB@ABACCGB@FIB@FI@BHC@AAEDA@JRIABBCB@B@ABBCB@BIBDFMBAAGA@AC@BAACIB@@C@@AA@@BE@AAKD@BIBBBHRC@ICCCCDGABEA@@AC@@BI@@BAA@GCBAAA@ABBBCDAAEJFDB@P\\J@@FB@@DGA@FD@@DAAADCF@@ABBBCDDB@DF@CLCAEFEB@DG@@HD@DB@BB@@FHD@BADA@CFCFABDB@BED@BCDEFFBABB@ADG@GNCBFHAFA@@DCAIB@DB@@FBBEF^JBAH@AFD@A@@DA@@BFDABD@@JB@@BA@AD@DB@@FCJ@FA@C@ABAAABENDB@BCDCFG@ADDBEDDDABA@ADB@ADF@BD@BEACD@BCBJF@BABA@BBCFE@ABCLABBBAFEB@A@BCDEBADD@CBBBBAADBBD@B@BBADFADDDA@ED@ACB@FF@DFBBCB@@AC@@GF@B@AFD@@DB@@AD@@BD@\\P^GVGcBAEGBE\\Q`W|i\\UdSTQb[QQQY@QJONIVIEGEBCGYLW_HEBCCC@YUB'], "encodeOffsets": [[124402, 32064]] }, "properties": { "cp": [121.489934, 31.398896], "name": "宝山区", "childNum": 1 } }, { "id": "310114", "geometry": { "type": "Polygon", "coordinates": ["@@A@A@@AC@BCME@@AABCDAHBBE@@BED@@CAABAFAACJCBFPC@BJCDCDDNAAEI@C@@EAAFEHA@CR@BDB@JCKYCBACGHCCCE@@CEB@A@CAADGA@CCAADGB@DB@ADC@@ECBBDC@BGG@CCIC@EAAOCG@OEUHK@IDGJCLCBEFFHABEAKDA@EAED@EAD@BED@FGAG@@BC@@AC@@DA@@CCBEA@DGAKFOB@CG@@BAA@CGCBAEA@CA@@DEA@FCFB@ABAAABAC@AAACFGEBCABCCABCCABCAB@@CC@ADGDEEC@EDCA@BA@BDA@ACEFECABC@@BB@BDC@AJIJCAADC@CGEB@@AB@BDF@JDD@DHBABD@B@@BCHE@@BC@@DCA@DC@@DDBADA@EDFBIPCFIIBCMAE@AJ@B@FAB@DAJDB@DDB@FD@@BCBBBB@@DABAB@DCBBBAHBB@FMCKB@HF@EHIACBE@BFCBBLAH@DD@@CD@D@BFNBCDGBAFTHBEBB@DB@@AJD@ANFABBBD@ABD@@ANDBDCD@BABA@ABLDCFDBF@ABC@ABDB@BFDADJDDCCDBDCDAAABBB@BC@ABA@ABC@@HA@C@@DJ@@DFB@BD@HB@AD@ABBDFA@HA@@CA@BDABOBMFAFB@ADBDAB\\LDAHBBADBHAPFJFAFBFFD@BJHRD@FHFNHDACCLADBH@DDFABHCB@BHJF@AJ@@FAFDB@AEFE@CBIHB@AC@@AA@DEHD@BD@ADB@@BBBB@AKD@@DBA@@@AD@DBBDBBDBD@@FDDBA@CDAHDBBHDADB@FA@BD@DCD@BFFCJD@DA@FBBDFADC@A@BFABEAABADKBAF@DEAAB@BA@AIEDA@ADCFB@AACE@BCA@BCB@BACCFCCABCH@DEDC@ACAFMBABBBAD@B@@EDI@EA@@CBCB@@AA@@IC@BAEC@AB@@CB@C@BEG@AB]I@@DABCAA@EA@@CJADB@CB@BEEGDAHMH@BCA@BAEAFEDC@AFC@ACABALQGC@ECCE@@GH@@CFAFEDBDKE@@CCADCAABA@@DEBCBB@CC@@EHB@CA@@EI@GMEMICFIBBBABAA@"], "encodeOffsets": [[124249, 32046]] }, "properties": { "cp": [121.250333, 31.383524], "name": "嘉定区", "childNum": 1 } }, { "id": "310115", "geometry": { "type": "MultiPolygon", "coordinates": [["@@bM²WLCļÑNI^_ÈïsJQ¶±`e`Z¡LDCsEWOWs@GBI\\wsYg|QNUBģFqAZHZB@@JHBAJFRA@BB@HABB@@J@HBDBLAJC@@BD@ABA@B@AD@FB@@BA@@BA@G@@FC@AB@DA@ABCAC@@DEA@DD@BDEF@FQJE@CAGJA@ABCAEDBDGHADWR_TYJI@G@SD@AA@@AA@IDGB@A@BQBmAA@CBOAGFELC@AAaDACS@C@@AIAABKA@BEBFDADDBCJC@@BC@@A@@ABJBBD@DDDDB@DAFCDBBGCA@BAA@CEC@@FCA@DCA@AA@@EE@@AC@CD@BBBF@DD@DAA@BBB@BDBAB@VFDADACADBBEDAAAHECC@AAC@CAA@ACA@ABBFCFFD@D@ABBFBABDA@BAHD@ADF@BDD@FBCBCA@BBBABDDH@CDH@B@BB@@FB@BB@B@FBADD@@AHB@DC@EAABKBEBGAAAC@AAADC@CHFD@@BBABJBDBB@DB@@BABAHD@FA@AFCA@BADDBEFA@BBEFADD@BBCDAACDCCABE@BCECC@@DA@CHE@@ACA@DA@@BA@@BE@ABOC@AA@CBMAAHCDAAAB@AGA@@CADEAAABCACNA@KECLC@E@@EA@A@@A@AC@@AAAA@A@C@BA@CDABEAAADCABAAA@DEH@CEADACAKDHN@LAFKNGJAF@D@DBFNLHLANEP@FBFJJJDdHDDLLNVDHAHEJWXAF@FJFHDtDXHhZNPFHBHALK\\AH@dCNCHCDMHoTUJMJEJCF@RRZ", "@@PDNAvOFGBKCeEQGEI@IBMNafELAJ@J@H", "@@HRHJNBX@XCRGfEFGBM@eYuGIgCIAK@KDMPIREVCXAR"]], "encodeOffsets": [[[124438, 32149], [124808, 31991], [124870, 31965]]] }, "properties": { "cp": [121.567706, 31.245944], "name": "浦东新区", "childNum": 3 } }, { "id": "310116", "geometry": { "type": "MultiPolygon", "coordinates": [["@@DBBAGCBD", "@@HADA@AGCKHB@BB", "@@FACAAD", "@@DB@EB@@CB@@GEQ@IEKAM@ATE@EHADF@GDCFFPD^BBED@@BD@@DPBB@@CDB@BLC@ADB@BF@@CF@@DB@BDCDA@@DCACBC@AB@HDBRTHGBCHBDB@AF@B@NACQ@@@AC@@CC@CIEE@CFCFHDBHABDN@BED@BDNA@HAF@FCBADDLD@DAAC@AB@@ANC@ANC@TDBL@DGJC^BDBDBJ@^F\\VHGPB@CD@BAF@DKDBBCA@BAC@FK@E@BD@@BNABCF@@AFB@AD@BADB@GA@@AF@BCFBDKB@@BDBB@BEDBBDF@@CFB@HD@@F@@@HA@BBA@BDC@BJADBBLB@AA@@ED@DIHA@BB@BDDBBCBA@@@BF@@CB@ABFBBCFB@BD@FCF@DBBAD@BAD@BABBBAHDJ@ABDDABDBHCBDJIBOFE@IDKJAFCBAJELAAEBCBKAA@GD@AIBEAIDOK@@EDEAABA@A@BB@@@B@B@AAD@@ADA@EJ@@CB@H@BLDBFA@@B@@GEB@EB@@CB@DETAAADA@GH@BHLAPA@ABBD@JU@ABBFCB@£«ugWOCOCgBDaAE`@HCBBFCBAJA@AFDFAFFD@FDFCFBBA@BBAFBDA@CDAAA@STCBWLAAABBBCBAACB@AABBBIFAPCHCFBBCB@HA@CAABGPIBO@ICCEDMGAILADACCBCA@CECEAKCADCBADAAKAEC@HEBCAEDQBACEAAB@BGCYDEJCB@BBFN@B@@JDbHRJL@D@FA@@CCB@DABBDEFACSDA@AAA@DDBLFHAB@BABCAIDADABCEKCABC@CDABBBC@@B@BA@BBcO[@MGDCC@DK_KFMGBCFGADEA@AGCA@@DAD@AFB@BCB@DGOCCLKR]JADEAMMABBCA@CB@BABCAACB@CEAB@CAAGBDFGFHFGBBDFHF@BDB@ABBFDADFF@DHD@DFFADDGDDDADDABDA@DDCDFFBDEBFFDCDBCBDDEBBDB@@@CDCDI@GB@BBFAB]DAHCDDH@DDBHB@DHABDB@@FG@CABJBl@FEFCFBB@LB@J@@GPDA@DD@AD@D@@CCA@BCA@CB@A@@AF@BGFAADDB@A"]], "encodeOffsets": [[[124321, 31442], [124337, 31429], [124341, 31419], [123933, 31687]]] }, "properties": { "cp": [121.330736, 30.724697], "name": "金山区", "childNum": 4 } }, { "id": "310117", "geometry": { "type": "Polygon", "coordinates": ["@@@DLB@BFTHAFB@DABHFELFBBAH@DIHB@GB@@CB@BEDAB@LAPB@DFBADD@@BBBN@@DRB@BADALHABlH@@\\ABAFQPOLDBDBDCJBBJFA@FCJC@@DCAABDDBDKHB@CDBDEBCEINHDABFB@DDDD@F@@ABCAA@EB@@CH@B@BCBABD@DLBBCB@R@ADD@BAJ@BBBB@BA@@NG@AFELC@AB@@CBA@KJAAA@CAC@CLD@ABBBGJDBBDCFBBDCFDADBBDCABB@@BA@HHDBABFFDCBBDCB@BABB@AFEBBBED@FEDDBED@BALB@CD@DEHBBGDBBCB@BFB@@LC@@FJA@AJB@@B@@FB@@HH@@BJ@CJDDADDBB@B@BCJD@DB@AB@FC@@FC@@D@FDA@X\\ILF@CAA@ABBJ@DEXFPBI_CM@CF@NFF@BBB@BAADBLFBJABHKB@@L@BHXCAGBAF@@BB@@BCFBDDBD@BB^ENNEFEAEHCC@DBB@BB@AH@BFCD@B@ABDB@@FA@BBAD@BBHBDAB@BAHBADNFHDABB@B@FGFBF@@AHBFC@CDC@CDA@EB@BCFCBCAAA@@AFAFIBC@ADEAAFGA@FGDBDC@@EABEB@BADBBA@AGE@AA@@BGAFONDBCHBFK@CBAHODICACDEC@CC@BCEAFEA@@CMABEIESCCHECEDBCAA@WAMAA@MBCAC@E@A@C@E@IAABCN@FDBAIGAGOSGAA[DAD@J@XIJ@PDDI@ODK@UD@BCAAGADSG@CAA@AABAAAA@@BECBC@IFCBC@CIG@A@AGDCABACCBAA@@@G@GCCB@AABC@ABC@ABCAE@EDC@@AEAADEABAA@@DE@@A@@ABADCAACA@@AGBCJC@@FB@@BMCBCAID@ACB@AAB@@G@@@EC@@GEA@DE@ACCAAFA@CA@AA@CLEAADE@@BB@@HCAABC@@BEA@BE@ADMB@AC@@A@FELD@ABB@ADCACLE@ABC@@DOAGH[U]EI@CACA]AIDCHK@CA@SMD@BMD@BA@@BBDCBC@CKBCDA@EBE@GMBACC@AFM@ACGBCAEGED@DFFDJD@@DD@@B@@DRMBA@E@@BCAGAADGHQSCA@GBAD@DADB@CB@DCACA@@CE@@DE@@ACA@BKD@ACA@DA@OA@CC@@AC@AF]AOCEECD@HCEGB@FSF@BBNFL@JFR@HA@@DA@@FA@@A"], "encodeOffsets": [[123933, 31687]] }, "properties": { "cp": [121.223543, 31.03047], "name": "松江区", "childNum": 1 } }, { "id": "310118", "geometry": { "type": "Polygon", "coordinates": ["@@EAEHA@A@BAGCMEBCGAABA@CBGAAAC@AB@AEB@@CABAA@C@ED@ABGA@@AAA@CDDFGFBFEMM]FAAC@CAACDE@AA@@AE@ABBHWDAGK@@@LAAGIBEAAKBCABA@AAE@MEE@@DDNJ`OAWECFI@AA@BBB@DKE[J@WCB@E@CD@@ED@@EBAA@@CICADA@A@CABCCCDII@@AG@@GA@@EA@@@IA@BIB@ED@@KA@AEA@ADCAAHGACFC@@DKAABC@AFCCEFC@AFAAEF@BAAABA@CDAACDEEBACAGGB@@AA@BACDAABCECCDAADGAACAHIAABAC@@EDEB@HBBBLIB@DA@@BAD@FKBEH@@MB@@AAAAAI@ABC@BCQ@A@ADKA@CACABADA@G@@DA@@FBBAD@BE@C@CC@CEABAGCJMDFFAACDCA@LGACCCBADB@CD@DI@EEBAIIACDCACAPKROBEBA@[G@AkGBBKBC@AQA@CM@AA@AC@BCEA@COAKBA@CBAFA@@DA@@HGACJG@ABEAFKGEBA@CEAGBEUKA@CQE@BCABCEBAHE@@BB@A@@DDB@ADB@DC@C@@BCCB@OC@HM@AHC@AHF@CHBF@BC@@DB@ADBB@BNB@BB@@FDB@DC@A@CRA@CFBBAFGAADDB@HA@@DB@@D@@ADBBEJDBM@ADg@ABFFABGBCNGBC@CACBAADAAEFACK[AAAJK@AC@GBEDG@ACOFOEAD@JQ@@FBdCDEL@FCD@H@JHXBPHABDEJ@BEDCACHCFAHA@@EG@QB@BBDE@@DE@AAE@@CG@ABADA@ABCAEFBLD@DHNJDD@HDHHHJFdDPCTD\\JnEMPDvBJHADHBBD@BD@@EHBFCBEDB@AD@HREB@FHD@DHBBGD@H@ABDBL@@AB@@AD@@CF@AFFD@BBB@CB@@FHDADB@@DEAADJB@DCHEAABBB@BFBAFEFADJDABIAADFB@DAB@DDBABCB@BE@@DD@Kz@DD@@HD@BDE@ADA@A@AFFB@HBA@BAB@FC@@AIBDBDABD@NA@BBBBABBRA@@@dFFDDHEBBHDNFFABDBDADCB@@AB@BCFO@ABCHCD@BBC@@@FDPRF@FA@DB@@AHAACFCHA@DFAACD@BBDAAABAD@BBD@@CDALBFB@GCIBA@@FADHD@BCDBJIBID@ACA@@AD@BAFDFEBDB@ACB@@ADBFCD@FFHCBCD@@DA@DBBADDBADDBAADHFDEBB@BBDBABBBAA@DE@EFB@CB@@DFBABHD@DBB@AH@@DPALEHB@CFBDA@DB@@CD@AAEAEEACD@CAACGA@A@@AEBACCDALB@CB@@ABADBBADCACHCBGCADGACDC@@DECEJGBCCADCD@VSLBDBLHBB@DB@BBHEBCBA@AB@@AFC@ADADEBA@ADCBEBAHIDKFIBABA@CIE"], "encodeOffsets": [[124232, 31906]] }, "properties": { "cp": [121.113021, 31.151209], "name": "青浦区", "childNum": 1 } }, { "id": "310120", "geometry": { "type": "Polygon", "coordinates": ["@@LBBAJB@BD@T@BDbCBBD@FKHEPBDAB@nBRA@A@BHAJCB@@BB@@BTCH@J@ZI`SXQBCHGACFCDBBAB@HIDBF@NGDA@EFEACC@@CFB@CD@DBBAB@@CBAD@@EH@B@@AB@@AA@@EBCA@B@BAC@@AD@BIAKAC@G@IA@BA@GAAB@EQBIGA@IA@GYBYrĥDEU¡_[g¤A@EDAA@BIVC@AA@BOBKBAGG@@HCBBBSBCFA@@DA@@FFA@HA@@@EBCAAKG@A@@DI@@FCB@BC@BBA@A@@@A@@A@BABBBCF@FL@CPBJAFBJC@@HBBALADBFKBIFABEDIBCL@JEFAPKJHFBFADED@JADFD@AB@BBABBBB@DBH@CTHBBBADC@@VCL@PCJTfD^JNJLJHBPDV@LBLHJBZDHCAEJYDB@BLHTFDBB@@AD@DEB@@AC@@EF@D@HGD@BAFB@AF@BCJD@ABABB@AB@DCBCDADB@HAB@BB@BAD@@DP@@B"], "encodeOffsets": [[124489, 31743]] }, "properties": { "cp": [121.458472, 30.912345], "name": "奉贤区", "childNum": 1 } }, { "id": "310230", "geometry": { "type": "MultiPolygon", "coordinates": [['@@^ITIRCZAVEV@bWXCDAVEBERKD@\\U\\K\\GBCNCBJD@RE`MB@JCTDÔoĒmƂZñLcDgG_SY]O£kcIUABoH_H±jãYHNODQH½pÛ`gBUAQImwf±ŧŚEBoH~zh^rXbLpVbJjHP@LANE s`SjoLGJQKCV_JK', "@@ODMFYnMLaXŃÈ{^yv[RYLMLAF@HHHHBOJEL]FKPMDCjIÌknGXI`MdKhWPGJGNMT[DEBQFS@SC_GKECKC", "@@UDmXOLQPCF@FDBDBN@`ENEJEXQTSBEACACEA", "@@BBB@DBDCCAC@@ACB@B", "@@CNO\\@DBBTB^ANCNE\\A\\IjMFIPa@IAOAK_uCAS@GEG@YFGH[PSRQZC^"]], "encodeOffsets": [[[124346, 32532], [124702, 32062], [124547, 32200], [125176, 32174], [124726, 32110]]] }, "properties": { "cp": [121.397516, 31.626946], "name": "崇明县", "childNum": 5 } }], "UTF8Encoding": true });
	        var myChart = echarts.init(document.getElementById("homeMap"));
	        var option = {
	            backgroundColor: 'none',
	            tooltip: {
	                show: true,
	                trigger: 'item',
	                borderColor: "#fff",
	                borderWidth: 2,
	                formatter: function formatter(params) {
	                    return params.name;
	                }
	            },
	            legend: {
	                orient: 'vertical',
	                y: 'bottom',
	                x: 'right',
	                data: ['pm2.5'],
	                textStyle: {
	                    color: '#fff'
	                }
	            },
	            geo: {
	                map: 'shanghai',
	                roam: true,
	                label: {
	                    emphasis: {
	                        show: false
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        areaColor: 'none',
	                        borderColor: '#0cbaef',
	                        borderWidth: 2
	                    },
	                    emphasis: {
	                        areaColor: '#e6e6e6'
	                    }
	                }
	            },
	            series: [{ //线
	                name: "",
	                type: 'lines',
	                zlevel: 3,
	                effect: {
	                    show: true,
	                    period: 6,
	                    trailLength: 0.7,
	                    color: 'rgb(8,181,237)',
	                    symbolSize: 3
	                },
	                lineStyle: {
	                    normal: {
	                        color: "green",
	                        width: 3,
	                        curveness: 0.2
	                    }
	                },
	                data: convertData(SHData)
	            }, { //线上移动的图标
	                name: "",
	                type: 'lines',
	                zlevel: 3,
	                effect: {
	                    show: false,
	                    period: 6,
	                    trailLength: 0,
	                    symbol: "",
	                    symbolSize: 15
	                },
	                lineStyle: {
	                    normal: {
	                        color: "red",
	                        width: 1,
	                        opacity: 0.4,
	                        curveness: 0.2
	                    },
	                    emphasis: {
	                        show: false
	                    }
	                },
	                data: convertData(SHData)
	            }, { //圆点
	                name: "",
	                type: 'effectScatter',
	                coordinateSystem: 'geo',
	                zlevel: 3,
	                rippleEffect: {
	                    brushType: 'stroke'
	                },
	                label: {
	                    normal: {
	                        show: false,
	                        position: 'right',
	                        formatter: '{b}'
	                    },
	                    emphasis: {
	                        show: false
	                    }
	                },
	                symbolSize: function symbolSize(val) {
	                    return val[2] / 8 + 5;
	                },
	                itemStyle: {
	                    normal: {
	                        color: "#ddb926"
	                    }
	                },
	                data: SHData.map(function (dataItem) {
	                    return {
	                        name: dataItem[0].name,
	                        value: geoCoordMapShanghai[dataItem[0].name].concat([dataItem[0].value])
	                    };
	                })
	            }, { //圆点shanghai
	                name: "",
	                type: 'effectScatter',
	                coordinateSystem: 'geo',
	                zlevel: 10,
	                rippleEffect: {
	                    brushType: 'stroke'
	                },
	                label: {
	                    normal: {
	                        show: false,
	                        position: 'right',
	                        formatter: '{b}'
	                    },
	                    emphasis: {
	                        show: false
	                    }
	                },
	                symbolSize: function symbolSize(val) {
	                    return val[2] / 8 + 10;
	                },
	                itemStyle: {
	                    normal: {
	                        color: "red"
	                    }
	                },
	                data: [{
	                    name: "上海",
	                    value: [121.4648, 31.2891, 40]
	                }]
	            }, {
	                type: 'map',
	                name: '',
	                map: 'shanghai',
	                roam: true,
	                animationDurationUpdate: 1000,
	                animationEasingUpdate: 'quinticInOut',
	                label: {
	                    normal: {
	                        show: false,
	                        position: 'right',
	                        formatter: '{b}'
	                    },
	                    emphasis: {
	                        show: false
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        areaColor: 'none',
	                        borderColor: '#0cbaef',
	                        borderWidth: 2
	                    },
	                    emphasis: {
	                        areaColor: '#e6e6e6'
	                    }
	                },
	                data: [
	                    // {
	                    //     "name": "嘉定区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "青浦区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "松江区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "金山区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "崇明县",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "宝山区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "杨浦区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "徐汇区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "长宁区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "普陀区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "静安区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "黄浦区",
	                    //     "value": 500
	                    // },
	                    // {
	                    //     "name": "闸北区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "闵行区",
	                    //     "value": 1000
	                    // },
	                    // {
	                    //     "name": "虹口区",
	                    //     "value": 500
	                    // },
	                    // {
	                    //     "name": "浦东新区",
	                    //     "value": 500
	                    // },
	                    // {
	                    //     "name": "奉贤区",
	                    //     "value": 1000
	                    // }
	                ]
	            }]
	        };
	        myChart.setOption(option);
	        myChart.resize();
	    },
	    componentDidMount: function componentDidMount() {

	        this.initMap();

	        $(window).resize(function (event) {
	            this.initMap();
	        }.bind(this));

	        $(".list h2 img").hover(function () {
	            var src = $(this).attr("src");
	            $(this).attr("src", src.replace("blue", "white"));
	        }, function () {
	            var src = $(this).attr("src");
	            $(this).attr("src", src.replace("white", "blue"));
	        });

	        //这一段的代码，是点击空白关闭菜单。后期来做。记得噢~
	        // $(document).on("click",function(e){

	        //   var myClass = $(e.target).attr("class");
	        //   if(myClass!="one-tip"&&myClass!="list") {
	        //      $(".one-tip").slideUp('400')
	        //   }
	        // })
	    },
	    HomeTwoFirstPop: function HomeTwoFirstPop() {
	        $(".one-tip").slideToggle('400');
	    },

	    //数据渲染
	    render: function render() {
	        return _react2.default.createElement(
	            'div',
	            { className: 'HomeTwo' },
	            _react2.default.createElement(
	                'div',
	                { className: 'middleLeft' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'list top' },
	                    _react2.default.createElement(
	                        'a',
	                        { className: 'links', activeClassName: 'active', to: 'javascript:', id: 'HomeTwoFirst', onClick: this.HomeTwoFirstPop },
	                        _react2.default.createElement(
	                            'h2',
	                            null,
	                            _react2.default.createElement('img', { src: 'images/indexAblue.png', alt: '' }),
	                            _react2.default.createElement(
	                                'span',
	                                null,
	                                '行业监测平台'
	                            )
	                        )
	                    ),
	                    _react2.default.createElement(
	                        'ul',
	                        { className: 'one-tip' },
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/P2P" } },
	                                'P2P'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/lineFinance" } },
	                                '线下理财'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/smallLoan" } },
	                                '小额贷款'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/financeGuara" } },
	                                '融资担保'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/privateFund" } },
	                                '私募基金'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/TradingPlaces" } },
	                                '交易场所'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/RaiseIndex" } },
	                                '众筹'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/PawnMonitoring" } },
	                                '典当'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/financeLease" } },
	                                '融资租赁'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/commercialSecret" } },
	                                '商业保理'
	                            )
	                        ),
	                        _react2.default.createElement(
	                            'li',
	                            null,
	                            _react2.default.createElement(
	                                _reactRouter.Link,
	                                { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/prepaidCard" } },
	                                '预付卡'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'list' },
	                    _react2.default.createElement(
	                        _reactRouter.Link,
	                        { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/parkMonitor" } },
	                        _react2.default.createElement(
	                            'h2',
	                            null,
	                            _react2.default.createElement('img', { src: 'images/indexCblue.png', alt: '' }),
	                            _react2.default.createElement(
	                                'span',
	                                null,
	                                '园区监测平台'
	                            )
	                        )
	                    )
	                )
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'middleCenter' },
	                _react2.default.createElement('div', { id: 'homeMap' })
	            ),
	            _react2.default.createElement(
	                'div',
	                { className: 'middleRight middleLeft' },
	                _react2.default.createElement(
	                    'div',
	                    { className: 'list top' },
	                    _react2.default.createElement(
	                        _reactRouter.Link,
	                        { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/InfoSearchIndex" } },
	                        _react2.default.createElement(
	                            'h2',
	                            null,
	                            _react2.default.createElement('img', { src: 'images/indexBblue.png', alt: '' }),
	                            _react2.default.createElement(
	                                'span',
	                                { className: 'left' },
	                                '企业全息信息查询平台'
	                            )
	                        )
	                    )
	                ),
	                _react2.default.createElement(
	                    'div',
	                    { className: 'list' },
	                    _react2.default.createElement(
	                        _reactRouter.Link,
	                        { className: 'links', activeClassName: 'active', to: { pathname: HOME_PATH + "/realtimeMonitor" } },
	                        _react2.default.createElement(
	                            'h2',
	                            null,
	                            _react2.default.createElement('img', { src: 'images/indexDblue.png', alt: '' }),
	                            _react2.default.createElement(
	                                'span',
	                                null,
	                                '实时监测平台'
	                            )
	                        )
	                    )
	                )
	            )
	        );
	    }
	});

	//将state植入 到 props
	exports.default = HomeTwo;

	/* REACT HOT LOADER */ }).call(this); } finally { if (true) { (function () { var foundReactClasses = module.hot.data && module.hot.data.foundReactClasses || false; if (module.exports && module.makeHot) { var makeExportsHot = __webpack_require__(681); if (makeExportsHot(module, __webpack_require__(138))) { foundReactClasses = true; } var shouldAcceptModule = true && foundReactClasses; if (shouldAcceptModule) { module.hot.accept(function (err) { if (err) { console.error("Cannot not apply hot update to " + "homeTwo.jsx" + ": " + err.message); } }); } } module.hot.dispose(function (data) { data.makeHot = module.makeHot; data.foundReactClasses = foundReactClasses; }); })(); } }
	/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(4)(module)))

/***/ }

})