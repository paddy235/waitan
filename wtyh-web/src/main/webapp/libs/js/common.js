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
	}

}