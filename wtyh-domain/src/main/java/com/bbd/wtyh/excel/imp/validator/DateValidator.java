package com.bbd.wtyh.excel.imp.validator;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.bbd.wtyh.excel.imp.entity.Cell;

/**
 * 日期校验器
 *
 * @author Created by LiYao on 2017-05-16 14:23.
 */
public class DateValidator extends AbstractValidator {

	protected String format;

	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	// private static final long MIN_TIME = -28800000L;

	public DateValidator(Cell cell) {
		super(cell);
		this.format = cell.getFormat();
	}

	@Override
	protected boolean validateFormat() {
		if (this.valueIsBlank) {
			return false;
		}
		try {
			Date tmpDate = DateUtils.parseDate(this.value, DEFAULT_DATE_FORMAT);
			this.value = DateFormatUtils.format(tmpDate, format);
			this.result = this.value;
		} catch (ParseException e) {
			// e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	protected String formatName() {
		return "日期";
	}
}
