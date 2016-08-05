package com.bbd.wtyh.web;

import java.util.List;

/**
 * 分页对象
 *
 * @author tracy zhou
 */
public class Page<T> {

    public static final int DEFAULT_PAGE_SIZE = 20;

    private Long totalCount;

    private Long totalPageCount;

    private Integer pageSize;

    private Integer currentPage;

    private Integer offset;

    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public Page() {
        this.totalCount = 0L;
        this.totalPageCount = 0L;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.currentPage = 1;
        this.offset = DEFAULT_PAGE_SIZE;

    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getOffset() {
        return (this.offset = (getCurrentPage() - 1) * DEFAULT_PAGE_SIZE);
    }

    public void setOffset(Integer offset) {
        if (offset <= 0) {
            return;
        }
        this.offset = offset;
    }

    public Long getPrevPage() {
        Long pre = getCurrentPage() - 1L;
        pre = pre < 1 ? 1 : pre;
        pre = pre < totalPageCount ? pre : totalPageCount;
        return pre;
    }

    public Long getNextPage() {
        Long next = getCurrentPage() + 1L;
        next = next > 1 ? next : 1;
        next = next < totalPageCount ? next : totalPageCount;
        return next;
    }

    public Integer getCurrentPage() {
        if (currentPage == null || currentPage <= 0) {
            return 1;
        }
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage > 0 ? currentPage : 1;
    }

    public int getPageSize() {
        return this.pageSize > 0 ? this.pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public Long getTotalCount() {
        return this.totalCount > 0 ? this.totalCount : 0;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        calTotalPageCount();
    }

    public Long getTotalPageCount() {
        this.calTotalPageCount();
        return totalPageCount;
    }

    private void calTotalPageCount() {
        if (this.totalCount > 0) {
            this.totalPageCount = getTotalCount() / getPageSize();
            if (getTotalCount() % getPageSize() > 0) {
                this.totalPageCount++;
            }
            this.totalPageCount = this.totalPageCount > 100 ? 100 : this.totalPageCount;
        } else {
            this.totalCount = 0L;
            this.totalPageCount = 0L;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("totalCount:" + totalCount);
        sb.append(" totalPageCount:" + totalPageCount);
        sb.append(" pageSize:" + pageSize);
        sb.append(" currentPage:" + getCurrentPage());
        return sb.toString();
    }

}
