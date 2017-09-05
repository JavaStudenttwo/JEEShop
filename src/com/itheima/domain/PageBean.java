package com.itheima.domain;

import java.util.List;

/**
 * Created by 13718 on 2017/9/5.
 */
public class PageBean<T> {
    private int pageNumber;
    private int pageSize;
    private int totalRecord;
    private int totalPage;
    private int startIndex;
    private List<T> data;

    public PageBean(int pageNumber,int pageSize,int totalRecord){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        this.totalPage = (this.totalRecord + this.pageNumber-1)/this.pageSize;
        this.startIndex = (this.pageNumber-1)*pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
