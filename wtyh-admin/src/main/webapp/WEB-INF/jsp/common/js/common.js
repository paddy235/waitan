$(function() {
	$(".dateinput").datetimepicker({
		language: 'zh-CN',
		format: 'yyyy-mm',
		startView: 'year',
		minView: 'year',
		autoclose: true
	}).on('hide', function(ev) {

	});

	var SELCTBOSS = {

	};

	/**
	 * 获取所有省市
	 * @return {[type]} [description]
	 */
	SELCTBOSS.provinceList = function() {
		$.ajax({
			type: 'get',
			dataType: 'json',
			url: '/json/null', //http://localhost:8080/province/provinceList
			success: function(res) {
				res = {
					"message": "success",
					"data": [{
						"id": "5732d895d4c6844b2b026335",
						"createAt": 1462950037,
						"updateAt": 1462950193,
						"status": "active",
						"name": "重庆市",
						"courtCount": 0,
						"judgeCount": 0,
						"lawyerCount": 0
					}, {
						"id": "5732d887d4c6844b2b02622d",
						"createAt": 1462950023,
						"updateAt": 1462950195,
						"status": "active",
						"name": "四川省",
						"courtCount": 0,
						"judgeCount": 0,
						"lawyerCount": 0
					}],
					"code": 200
				};

				if (res.code == 200) {
					$(".province-selct").html("");
					var info = '<option value="">请选择地域</option>';
					for (var i = 0; i < res.data.length; i++) {
						info += '<option value=' + res.data[i].name + ' >' + res.data[i].name + '</option>';
					}
					$(".province-selct").append(info);
				}
			}
		});
	}

	/**
	 * 获取省市的城市
	 * @return {[type]} [description]
	 */
	SELCTBOSS.citySearchByProvince = function(parm) {
		$.ajax({
			type: 'get',
			dataType: 'json',
			url: '/json/null', //localhost:8080/json/city/citySearchByProvince
			data: {
				province: parm
			},
			success: function(res) {
				res = {
					"message": "success",
					"data": [{
						"id": "5732d887d4c6844b2b02622e",
						"createAt": 1462950023,
						"updateAt": 1462950195,
						"status": "active",
						"name": "成都",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d88ed4c6844b2b0262ad",
						"createAt": 1462950030,
						"updateAt": 1462950030,
						"status": "active",
						"name": "广安",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d890d4c6844b2b0262dd",
						"createAt": 1462950032,
						"updateAt": 1462950032,
						"status": "active",
						"name": "宜宾",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8a5d4c6844b2b026436",
						"createAt": 1462950053,
						"updateAt": 1462950053,
						"status": "active",
						"name": "南充",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8bcd4c6844b2b02659d",
						"createAt": 1462950076,
						"updateAt": 1462950076,
						"status": "active",
						"name": "德阳",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8f3d4c6844b2b0268a1",
						"createAt": 1462950131,
						"updateAt": 1462950164,
						"status": "active",
						"name": "乐山",
						"province": "四川省",
						"totalCause": 0
					}],
					"code": 200
				};

				if (res.code == 200) {
					var info = '<option value="">请选择</option>';
					for (var i = 0; i < res.data.length; i++) {
						info += '<option value=' + res.data[i].name + ' >' + res.data[i].name + '</option>';
					}
					$(".tity-selct").append(info);
				}
			}
		});
	}


	/**
	 * 获取省市下面的法官
	 * @return {[type]} [description]
	 */
	SELCTBOSS.courtProvince = function(parm) {
		$.ajax({
			type: 'get',
			dataType: 'json',
			url: '/json/null', //localhost:8080/json/city/citySearchByProvince
			data: {
				province: parm
			},
			success: function(res) {
				res = {
					"message": "success",
					"data": [{
						"id": "5732d887d4c6844b2b02622e",
						"createAt": 1462950023,
						"updateAt": 1462950195,
						"status": "active",
						"name": "成都",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d88ed4c6844b2b0262ad",
						"createAt": 1462950030,
						"updateAt": 1462950030,
						"status": "active",
						"name": "广安",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d890d4c6844b2b0262dd",
						"createAt": 1462950032,
						"updateAt": 1462950032,
						"status": "active",
						"name": "宜宾",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8a5d4c6844b2b026436",
						"createAt": 1462950053,
						"updateAt": 1462950053,
						"status": "active",
						"name": "南充",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8bcd4c6844b2b02659d",
						"createAt": 1462950076,
						"updateAt": 1462950076,
						"status": "active",
						"name": "德阳",
						"province": "四川省",
						"totalCause": 0
					}, {
						"id": "5732d8f3d4c6844b2b0268a1",
						"createAt": 1462950131,
						"updateAt": 1462950164,
						"status": "active",
						"name": "乐山",
						"province": "四川省",
						"totalCause": 0
					}],
					"code": 200
				};

				if (res.code == 200) {
					var info = '<option value="">请选择</option>';
					for (var i = 0; i < res.data.length; i++) {
						info += '<option value=' + res.data[i].name + ' >' + res.data[i].name + '</option>';
					}
					$(".court-selct").append(info);
				}
			}
		});
	}



	SELCTBOSS.provinceList();


})