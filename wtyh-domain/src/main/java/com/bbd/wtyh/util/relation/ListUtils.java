package com.bbd.wtyh.util.relation;

import java.util.List;

public class ListUtils {
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		if (null == list || list.size() == 0) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List list) {
		return !isEmpty(list);
	}

}
