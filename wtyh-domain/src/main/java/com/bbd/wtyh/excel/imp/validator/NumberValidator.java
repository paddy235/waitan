package com.bbd.wtyh.excel.imp.validator;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import com.bbd.wtyh.excel.imp.entity.Cell;

/**
 * 数值验证器
 *
 * @author Created by LiYao on 2017-05-16 14:02.
 */
public class NumberValidator extends AbstractValidator {

	protected String format;
	private DecimalFormat numberFormat;

	public NumberValidator(Cell cell) {
		super(cell);
		this.format = cell.getFormat();
		if (StringUtils.isBlank(format)) {
			format = "0";
		}
		this.numberFormat = new DecimalFormat(format);
	}

	@Override
	protected boolean validateFormat() {
		if (this.valueIsBlank) {
			return true;
		}
		try {
			Number num = numberFormat.parse(this.value);
			if (this.value.contains(".")) {
				this.result = num.doubleValue() + "";
			} else {
				this.result = num.longValue() + "";
			}
		} catch (ParseException e) {
			e.printStackTrace();
			// this.addError(this.name + " 数字格式不符合预期");
			return false;
		}
		return true;
	}

	@Override
	protected String formatName() {
		return "数值";
	}
}
