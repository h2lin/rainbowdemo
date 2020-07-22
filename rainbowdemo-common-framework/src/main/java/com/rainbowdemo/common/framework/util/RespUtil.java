package com.rainbowdemo.common.framework.util;

import com.github.pagehelper.Page;
import com.rainbow.common.pojo.dto.Resp;
import com.rainbow.common.pojo.dto.RespPageBody;

/**
 * @Desc Resp常用工具
 * @Author wuzh
 * @Date 2020/7/22
 */
public class RespUtil {
    // 返回成功
    public static <E> Resp<E> success(E o) {
        return new Resp(o);
    }

    // pageHelper的返回结果转换为标准返回s报文
    public static <T> RespPageBody<T> tranPageData(Page<T> pageData) {
        RespPageBody<T> resp = new RespPageBody();
        resp.setDatas(pageData.getResult());
        resp.setPageCount(pageData.getPages());
        resp.setPageIndex(pageData.getPageNum());
        resp.setPageSize(pageData.getPageSize());
        resp.setTotalCount(pageData.getTotal());
        return resp;
    }
}
