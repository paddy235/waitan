package com.bbd.wtyh.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ExportExcelUtil
 *
 * @author Created by LiYao on 2017-04-13 13:10.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

	/** 导出名称 */
	String exportName();

	/** 时间格式化 */
	String dateFormat() default "yyyy-MM-dd HH:mm:ss";

}
