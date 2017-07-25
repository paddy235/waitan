package com.bbd.wtyh.excel.imp.validator;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

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

	private static final Pattern PATTERN = Pattern.compile("^0|-?([1-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)$");

	public NumberValidator(Cell cell) {
		super(cell);
		this.format = cell.getFormat();
		if (StringUtils.isBlank(format)) {
			format = "0.###############";
		}
		this.numberFormat = new DecimalFormat(format);
	}

	@Override
	protected boolean validateFormat() {
		if (this.valueIsBlank) {
			return true;
		}
		if (!isNumber(this.value)) {
			return false;
		}
		try {
			Number num = numberFormat.parse(this.value);
			this.result = numberFormat.format(num);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected String formatName() {
		return "数值";
	}

	private boolean isNumber(String str) {
		return PATTERN.matcher(str).matches();
	}

	public static void main(String[] args) throws ParseException {
		DecimalFormat numberFormat = new DecimalFormat("0.00");
		Number num = numberFormat.parse("0.");
		System.out.println(num);
		System.out.println();
	}
}
