var BOSS = {
	/**
	 * ary 数据源
	 * field 要排序的属性
	 * type  排序方式 desc//降序 //asc升序
	 */
	/*
	 *var ary = [{ name : "上海某大街" ,value:2},{ name : "四川哈哈" ,value:6}];
	 *ary = BOSS.sort(ary,"name","asc");
	 *alert("name排序："+JSON.stringify(ary));
	 *ary = BOSS.sort(ary,"value","asc");
	 *alert("value排序："+JSON.stringify(ary));
	 */
	sort: function(ary, field, type) {
		for (var i = 0; i < ary.length - 1; i++) {
			for (var m = i + 1; m < ary.length; m++) {
				if (type == "desc") {
					if (ary[i][field] < ary[m][field]) {
						var min = ary[i];
						ary[i] = ary[m];
						ary[m] = min;
					}
				} else {
					if (ary[i][field] > ary[m][field]) {
						var min = ary[i];
						ary[i] = ary[m];
						ary[m] = min;
					}
				}
			}
		}
		return ary;
	},
	/**参数说明：
	 * 根据长度截取先使用字符串，超长部分追加…
	 * str 对象字符串
	 * len 目标字节长度
	 * 返回值： 处理结果字符串
	 */
	 cutString:function(str, len) {
		//length属性读出来的汉字长度为1
		if (str.length * 2 <= len) {
			return str;
		}
		var strlen = 0;
		var s = "";
		for (var i = 0; i < str.length; i++) {
			s = s + str.charAt(i);
			if (str.charCodeAt(i) > 128) {
				strlen = strlen + 2;
				if (strlen >= len) {
					return s.substring(0, s.length - 1) + "...";
				}
			} else {
				strlen = strlen + 1;
				if (strlen >= len) {
					return s.substring(0, s.length - 2) + "...";
				}
			}
		}
		return s;
	},
	getQueryString:function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }

}