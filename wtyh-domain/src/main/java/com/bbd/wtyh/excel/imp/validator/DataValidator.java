package com.bbd.wtyh.excel.imp.validator;

import com.bbd.wtyh.excel.imp.entity.ValidateCell;

/**
 * 数据验证器
 *
 * @author Created by LiYao on 2017-05-16 10:55.
 */
public interface DataValidator {

	boolean validate(ValidateCell cell) throws Exception;

}
