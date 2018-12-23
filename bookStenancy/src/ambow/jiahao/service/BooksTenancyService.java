package ambow.jiahao.service;

import ambow.jiahao.dao.BooksTenancyDao206;
import ambow.jiahao.dao.TenancyListDao206;
import ambow.jiahao.pojo.BooksTenancy206;
import ambow.jiahao.pojo.TenancyList206;

import java.util.ArrayList;
import java.util.List;

/**
 * 借书类逻辑实现类
 */
public class BooksTenancyService {
    private BooksTenancyDao206 booksTenancyDao206 = new BooksTenancyDao206();
    private  TenancyListDao206 tenancyListDao206 = new TenancyListDao206();

    public  int getNextBookTenancyNum() {
        List<BooksTenancy206> booksTenancy206s = booksTenancyDao206.getALL206();
//        没有借书的
        if (booksTenancy206s.size() <= 0) {
            return 1;
        }
        return booksTenancy206s.get(booksTenancy206s.size() - 1).getBtNum206() + 1;
    }

    /**
     * 借出一本书
     * @param booksTenancy206
     */
    public void add(BooksTenancy206 booksTenancy206) {
        booksTenancyDao206.add206(booksTenancy206);
        List<TenancyList206> tenancyList206list = booksTenancy206.getTenancyList206s();
//         添加借书信息
        for (TenancyList206 tenancyList206 : tenancyList206list) {
            tenancyListDao206.add206(tenancyList206);
        }
    }

    /**
     * 获取所有的可借阅信息
     * @return
     */
    public List<BooksTenancy206> getALLBooksTenancy() {
        List<BooksTenancy206> booksTenancy206s = booksTenancyDao206.getALL206();
        for (BooksTenancy206 booksTenancy206 : booksTenancy206s) {
            booksTenancy206.setTenancyList206s(tenancyListDao206.getAllByBtID(booksTenancy206.getBtNum206(), true, 0));
        }
        return booksTenancy206s;
    }

    /**
     * 通过用户名来获取借阅的图书
     * @param userName
     * @return
     */
    public List<BooksTenancy206> getBookTenancyByUserName(String userName) {
        List<BooksTenancy206> booksTenancy206s0= booksTenancyDao206.getALL206();
        List<BooksTenancy206> booksTenancy206s1 = new ArrayList<BooksTenancy206>();
        for (BooksTenancy206 booksTenancy206 : booksTenancy206s0) {
            if (booksTenancy206.getUserName206().equals((userName))) {
                booksTenancy206.setTenancyList206s(tenancyListDao206.getAllByBtID(booksTenancy206.getBtNum206(), false, 0));
                booksTenancy206s1.add(booksTenancy206);
            }
        }
        return booksTenancy206s1;
    }
}
