package ambow.jiahao.service;

import ambow.jiahao.dao.TenancyListDao206;
import ambow.jiahao.pojo.TenancyList206;

/**
 * 出借的书管理类实现
 */
public class TenancyListService {
    TenancyListDao206 tenancyListDao206 = new TenancyListDao206();

    /**
     * 添加1一条数据（tenancyList206）
     * @param tenancyList206
     */
    public void add (TenancyList206 tenancyList206) {
        tenancyListDao206.add206(tenancyList206);
    }

    /**
     * 跟新一条数据
     * @param tenancyList206
     */
    public void update(TenancyList206 tenancyList206) {
        tenancyListDao206.update(tenancyList206);
    }

    public boolean getTenancyListByBookID(int boolID) {
        return false;
    }
}
