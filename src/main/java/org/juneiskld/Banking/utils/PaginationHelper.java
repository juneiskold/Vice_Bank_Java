package org.juneiskld.Banking.utils;

import java.util.List;

public class PaginationHelper<T> {

    private final List<T> items;
    private final int pageSize;
    private int currentPage;

    public PaginationHelper(List<T> items, int pageSize) {
        this.items = items;
        this.pageSize = pageSize;
        this.currentPage = 1;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) items.size() / pageSize);
    }

    public int getPageStart() {
        return (currentPage - 1) * pageSize;
    }

    public int getPageEnd() {
        return Math.min(currentPage * pageSize, items.size());
    }

    public void setPage(int page) {
        if (page >= 1 && page <= getTotalPages()) {
            this.currentPage = page;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
