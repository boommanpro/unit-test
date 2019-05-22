package cn.boommanpro.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author BoomManPro
 */
@Data
public class PageDto<T> {
    private int pageSize;
    private long totalNum;
    private int pageNo;
    private int pages;
    private List<T> data;

    public PageDto(Page<T> tPage) {
        this.pageSize = tPage.getSize();
        this.totalNum = tPage.getTotalElements();
        this.pageNo = tPage.getNumber();
        this.pages = tPage.getTotalPages();
        this.data = tPage.getContent();
    }

    public PageDto(Page page, List<T> data) {
        this.pageSize = page.getSize();
        this.totalNum = page.getTotalElements();
        this.pageNo = page.getNumber();
        this.pages = page.getTotalPages();
        this.data = data;
    }
}
