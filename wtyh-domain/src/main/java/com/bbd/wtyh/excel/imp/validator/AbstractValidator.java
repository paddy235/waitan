package com.bbd.wtyh.excel.imp.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.bbd.wtyh.excel.imp.entity.Cell;
import com.bbd.wtyh.excel.imp.entity.ValidateCell;

/**
 * 抽象验证器
 *
 * @author Created by LiYao on 2017-05-16 10:35.
 */
public abstract class AbstractValidator implements DataValidator {

	protected String sheetName;
	protected String name;
	protected String code;
	protected int length;
	protected Pattern regex;
	protected String value;
	protected String result;
	protected boolean allowSkip;
	protected boolean required;
	protected boolean valueIsBlank;

	public AbstractValidator(Cell cell) {
		this.sheetName = cell.getSheet().getName();
		this.name = cell.getName();
		this.code = cell.getCode();
		this.value = cell.getValue();
		this.length = cell.getLength();
		this.allowSkip = cell.isAllowSkip();
		this.required = cell.isRequired();
		if (StringUtils.isNotBlank(cell.getRegex())) {
			this.regex = Pattern.compile(cell.getRegex());
		}
	}

	protected boolean validateRequired() {
		return !this.required || !this.valueIsBlank;

	}

	protected boolean validateLength() {
		return this.length == 0 || !this.valueIsBlank && this.value.length() <= this.length;
	}

	protected boolean validateRegex() {
		return this.regex == null || !this.valueIsBlank && this.regex.matcher(this.value).matches();
	}

	protected abstract boolean validateFormat();

	protected abstract String errorMsg();

	@Override
	public boolean validate(ValidateCell cell) throws Exception {
		this.result = null;
		String value = cell.getValue();
		// 允许忽略
		if (this.allowSkip) {
			return true;
		}

		this.value = value.trim();
		this.valueIsBlank = StringUtils.isBlank(this.value);

		if (!validateRequired()) {
			cell.addError(this.name + " 该值是必须的");
			return false;
		}

		boolean flag = true;
		if (!validateLength()) {
			flag = false;
			cell.addError(this.name + " 最大长度为：" + this.length);
		}
		if (!validateRegex()) {
			flag = false;
			cell.addError(this.name + " 格式错误（不能通过正则表达式）");
		}
		if (!validateFormat()) {
			flag = false;
			cell.addError(this.name + " " + errorMsg());
		}

		cell.setValue(this.result == null ? this.value : this.result);
		return flag;
	}
}
