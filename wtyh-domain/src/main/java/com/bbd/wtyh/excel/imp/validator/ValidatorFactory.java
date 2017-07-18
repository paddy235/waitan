package com.bbd.wtyh.excel.imp.validator;

import com.bbd.wtyh.excel.imp.entity.Cell;

/**
 * 校验器工厂
 *
 * @author Created by LiYao on 2017-05-16 14:44.
 */
public class ValidatorFactory {

	public static final String TYPE_STRING = "string";
	public static final String TYPE_NUMBER = "number";
	public static final String TYPE_DATE = "date";

	public static DataValidator createValidator(Cell cell) {
		if (cell == null) {
			return null;
		}
		DataValidator v = null;
		if (TYPE_STRING.equals(cell.getDataType().trim())) {
			v = new StringValidator(cell);
		} else if (TYPE_DATE.equals(cell.getDataType().trim())) {
			v = new DateValidator(cell);
		} else if (TYPE_NUMBER.equals(cell.getDataType().trim())) {
			v = new NumberValidator(cell);
		}
		return v;
	}

}
