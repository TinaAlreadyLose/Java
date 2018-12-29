package ambow.jiahao.service;

import ambow.jiahao.dao.BooksDao206;
import ambow.jiahao.dao.BooksTypeDao206;
import ambow.jiahao.pojo.Book206;
import ambow.jiahao.pojo.BookType206;
import ambow.jiahao.util.IPrint206;

import java.util.List;

/**
 * 书的详细类型类实现
 */
public class BookTypeService implements IPrint206 {
    private final float LEASE_MONEY = 0.5f;
    private final int LEASE_DAY = 3;
    private final String LEASE_NAME = "新书";
    BooksTypeDao206 booksTypeDao206 = new BooksTypeDao206();
    BooksDao206 booksDao206 = new BooksDao206();

    /**
     * @return 获取所有的图书类型
     */
    public List<BookType206> getAllTypes() {
        return booksTypeDao206.getALL206();

    }

    /**
     * 安装打印规范打印所有数据
     */
    @Override
    public void print206(Object object206) {
        List<BookType206> bookType206s = getAllTypes();
        for (BookType206 bookType206 : bookType206s) {
            System.out.println("类型编号：" + bookType206.getTypeID206() + "类型名称" + bookType206.getTypeName206());
        }
    }

    /**
     * 通过typeid 来查询信息
     * * @param typeId
     *
     * @return
     */
    public BookType206 getTypeByID(int typeId) {
        return booksTypeDao206.getTypeNameByID206(typeId);
    }

    /**
     * 结算方法，并找零
     *
     * @param typeID user
     * @param day    how long
     * @return 还剩多少钱
     */
    public float getCharge(int typeID, int day) {
//        查到一条信息
        BookType206 bookType206 = booksTypeDao206.getTypeNameByID206(typeID);
//        新书可借阅
        if (bookType206.getTypeName206().equals(this.LEASE_NAME)) {
//           不超期，一共付多少钱
            if (day <= this.LEASE_DAY)
                return bookType206.getTypeID206() * day;
//                     超期每天多花多少钱
            else return bookType206.getPriceOfDay206() * day + (day - this.LEASE_DAY) * this.LEASE_MONEY;
        } else return bookType206.getPriceOfDay206() * day;
    }

    /**
     * 给图书添加一种数据类型
     * @param type206
     * @return
     */
    public int add(BookType206 type206) {
        return booksTypeDao206.add206(type206);
    }

    /**
     * 跟新数据库
     * @param type206
     * @return
     */
    public int update(BookType206 type206) {
        return booksTypeDao206.update(type206);
    }

    public int delete(int typeId) {
        List<Book206> book206s = booksDao206.getBooksByTypeID206(typeId);
        if (book206s.size() >0) {
            System.out.println("该类别下有书籍信息，不能删除");
            return 0;
        } else return booksTypeDao206.delete(typeId);

    }
}
