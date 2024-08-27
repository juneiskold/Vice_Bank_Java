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


}
