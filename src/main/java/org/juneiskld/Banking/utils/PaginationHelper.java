package org.juneiskld.Banking.utils;

import java.util.List;

public class PaginationHelper<T> {
    private final List<T> items;
    private final int itemsPerPage;

    public PaginationHelper(List<T> items, int itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;
    }

    public int pageCount() {
        return (int) Math.ceil((double) items.size() / itemsPerPage);
    }

    public int itemCount() {
        return items.size();
    }

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            return -1;
        }
        return pageIndex < pageCount() - 1 ? itemsPerPage : items.size() % itemsPerPage;
    }

    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= items.size()) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }

    public List<T> getPage(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            throw new IllegalArgumentException("Invalid page index");
        }
        int start = pageIndex * itemsPerPage;
        int end = Math.min(start + itemsPerPage, items.size());
        return items.subList(start, end);
    }
}