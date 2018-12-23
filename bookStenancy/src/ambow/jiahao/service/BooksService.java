package ambow.jiahao.service;

import ambow.jiahao.dao.BooksDao206;
import ambow.jiahao.pojo.Book206;

import java.util.List;

public class BooksService {
    BooksDao206 booksDao206 = new BooksDao206();

    /**
     * 添加新书籍
     * @param book206
     * @return
     */
    public int add(Book206 book206) {
        return booksDao206.add206(book206);
    }

    /**
     * 跟新书籍
     * @param book206
     * @return
     */
    public int update(Book206 book206) {
        return booksDao206.update(book206);
    }

    /**
     * 删除书籍
     * @param bookID
     * @return 0为没有删除
     */
    public int delete(int bookID) {
//        看看有没有被借阅，有不能删除
        boolean flag = new TenancyListService().getTenancyListByBookID((bookID));
        int i=0;
        if (flag) {
            System.out.println("这本书有明细，不能删除");
        } else i = booksDao206.delete(bookID);
        return i;
    }

    /**
     * 获取所有的图书
     * @return
     */
    public List<Book206> getAllBooks() {
        return booksDao206.getALL206();
    }

    public Book206 getBookByID(int bookID) {
        return booksDao206.getb(bookID);
    }
}
