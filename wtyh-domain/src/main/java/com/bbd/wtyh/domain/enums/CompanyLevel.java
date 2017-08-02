package com.bbd.wtyh.domain.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/7 0007.
 */
public enum CompanyLevel {
	AAA_p("AAA+"),
	AAA("AAA"),
	AAA_m("AAA-"),
	AA_p("AA+"),
	AA("AA"),
	AA_m("AA-"),
	A_p("A+"),
	A("A"),
	A_m("A-"),
	BBB_p("BBB+"),
	BBB("BBB"),
	BBB_m("BBB-"),
	BB_p("BB+"),
	BB("BB"),
	BB_m("BB-"),
	B_p("B+"),
	B("B"),
	B_m("B-"),
	CCC_p("CCC+"),
	CCC("CCC"),
	CCC_m("CCC-"),
	CC_p("CC+"),
	CC("CC"),
	CC_m("CC-"),
	C_p("C+"),
	C("C"),
	C_m("C-"),
	D("D");

	private String value;

	CompanyLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static CompanyLevel getByValue(String value) {
		for (CompanyLevel companyLevel : CompanyLevel.values()) {
			if (companyLevel.getValue().equalsIgnoreCase(value)) {
				return companyLevel;
			}
		}
		return null;
	}

	public static CompanyLevel getByOrdinal(int ordinal) {
		for (CompanyLevel companyLevel : CompanyLevel.values()) {
			if (companyLevel.ordinal() == ordinal) {
				return companyLevel;
			}
		}
		return null;
	}

	public static Map<String, Integer> getMap() {
		Map<String, Integer> rst = new HashMap();
		for (CompanyLevel companyLevel : CompanyLevel.values()) {
			rst.put(companyLevel.getValue(), companyLevel.ordinal());
		}
		return rst;
	}

	public static String allValues() {
		List<String> list = new ArrayList<>();
		for (CompanyLevel companyLevel : CompanyLevel.values()) {
			list.add(companyLevel.getValue());
		}
		return StringUtils.join(list, ",");
	}

}
