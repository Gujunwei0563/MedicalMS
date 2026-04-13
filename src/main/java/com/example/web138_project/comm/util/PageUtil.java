package com.example.web138_project.comm.util;

public class PageUtil {
    //当前页
    private int currentPage;
    private int pageNum;
    private int totalCount;
    private int pageSize = 2;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        if(this.currentPage<1){
            this.currentPage=1;
        }
        if (this.currentPage>=pageNum){
            this.currentPage=this.pageNum;
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum() {
        this.pageNum = this.totalCount%pageSize==0?this.totalCount/pageSize:this.totalCount/pageSize+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
