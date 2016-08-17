package com.bbd.wtyh.common.recruit;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 在没有HttpRequest的情况下，提供当前请求的Locale信息。
 * 基于ThreadLocal实现，所以如果在自己创建的线程里，是不能正确获取Locale信息的。
 * Created by zhaoyuan
 * 2016/2/16.
 */
@Component
public class BbdLocaleProvider {

    @Resource(name = "messageSource")
    private MessageSource messageSource;

    ThreadLocal<Locale> currentLocale = new ThreadLocal<Locale>() {
        @Override
        protected Locale initialValue() {
            try {
                throw new Exception("Can't get locale information in customized thread!");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    /**
     * 根据key，返回对应的语言结果
     *
     * @param key
     * @return
     */
    public String i18n(String key, Object... args) {
        return messageSource.getMessage(key, args, currentLocale.get());
    }

    public String i18n(String key, Locale locale, Object... args) {
        return messageSource.getMessage(key, args, locale);
    }

    public void setLocale(Locale locale) {
        currentLocale.set(locale);
    }

    public Locale getLocale() {
        return currentLocale.get();
    }

}
