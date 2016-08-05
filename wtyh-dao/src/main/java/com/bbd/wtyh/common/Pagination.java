package com.bbd.wtyh.common;

import java.util.ArrayList;
import java.util.List;

/**
 * leo on 2015/8/27.
 */
public class Pagination {

    private Integer pageNumber = 1;
    //分页数量标准
    private Integer pageSize = 10;
    //总数量
    private Integer count = 0;
    //前页数量
    private Integer after_range_num = 4;
    //后页数量
    private Integer before_range_num = 4;
    //当前页数据集合
    @SuppressWarnings("rawtypes")
	private List list;

    public List<Integer> getPageNumList() {
        List<Integer> pageNumList = new ArrayList<Integer>();
        int to = pageNumber + before_range_num > getLastPageNumber() ? getLastPageNumber() : pageNumber + before_range_num;
        if (pageNumber >= after_range_num) {
            for (int i = pageNumber - after_range_num > 0 ? pageNumber - after_range_num : 1; i <= to; i++) {
                pageNumList.add(i);
            }
        } else {
            for (int i = 1; i <= to; i++) {
                pageNumList.add(i);
            }
        }
        return pageNumList;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getBegin() {
        return (pageNumber - 1) * pageSize;
    }

    public Integer getEnd() {
        return pageNumber * pageSize >= count ? count : pageNumber * pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLastPageNumber() {
        return (count - 1) / pageSize + 1;
    }


    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = null == pageNumber || pageNumber <= 0 ? 1 : pageNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getNextPageNumber() {
        Integer nextPageNumber;
        if (pageNumber >= 1 && pageNumber < getLastPageNumber()) {
            nextPageNumber = pageNumber + 1;
        } else {
            nextPageNumber = getLastPageNumber();
        }
        return nextPageNumber;
    }

    public Integer getPreviousPageNumber() {
        Integer previousPageNumber;
        if (pageNumber > 1 && pageNumber <= getLastPageNumber()) {
            previousPageNumber = pageNumber - 1;
        } else {
            previousPageNumber = 1;
        }
        return previousPageNumber;
    }

    @SuppressWarnings("rawtypes")
	public List getList() {
        return list;
    }

    @SuppressWarnings("rawtypes")
	public void setList(List list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAfter_range_num() {
        return after_range_num;
    }

    public void setAfter_range_num(Integer after_range_num) {
        this.after_range_num = after_range_num;
    }

    public Integer getBefore_range_num() {
        return before_range_num;
    }

    public void setBefore_range_num(Integer before_range_num) {
        this.before_range_num = before_range_num;
    }


}
