package com.bbd.wtyh.domain.vo;

/**
 * @Author:WLL
 * @Date:Create on 11:252017/12/12
 */
public class UserSearchVO {
    //序号
    private String numIndex;

    private String keyWord;

    private String countKeyWord;

    public String getNumIndex() {
        return numIndex;
    }

    public void setNumIndex(String numIndex) {
        this.numIndex = numIndex;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCountKeyWord() {
        return countKeyWord;
    }

    public void setCountKeyWord(String countKeyWord) {
        this.countKeyWord = countKeyWord;
    }
}
