package com.itheima.domain;

import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-9-7
 * discription:为分页创建的持久化类
 * indetail:
 *
 */
public class PageBean<T> {
    /**当前页页码*/
    private int pageNumber;
    /**一页显示的记录数*/
    private int pageSize;
    /**总记录数*/
    private int totalRecord;
    /**总共有多少页*/
    private int totalPage;
    /**开始页*/
    private int startIndex;
    /**数据集合*/
    private List<T> data;

    /**含参构造方法*/
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
