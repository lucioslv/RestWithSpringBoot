package br.com.project.restwithspringboot.utils.mocks;

import br.com.project.restwithspringboot.data.models.Book;
import br.com.project.restwithspringboot.data.vos.v1.BookVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class MockBook {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookVO mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    private Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setAuthor("Michael C. Feathers" + number);
        book.setLaunchDate(new GregorianCalendar(2020, 01, 01).getTime());
        book.setPrice(new BigDecimal("49.00"));
        book.setTitle("Working effectively with legacy code" + number);
        return book;
    }

    private BookVO mockVO(Integer number) {
        BookVO book = new BookVO();
        book.setKey(number.longValue());
        book.setAuthor("Michael C. Feathers" + number);
        book.setLaunchDate(new GregorianCalendar(2020, 01, 01).getTime());
        book.setPrice(new BigDecimal("49.00"));
        book.setTitle("Working effectively with legacy code" + number);
        return book;
    }
}
