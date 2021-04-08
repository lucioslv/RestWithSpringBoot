package br.com.project.restwithspringboot.utils;

import br.com.project.restwithspringboot.data.models.Book;
import br.com.project.restwithspringboot.data.vos.v1.BookVO;
import br.com.project.restwithspringboot.utils.mocks.MockBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

public class DozerConverterBookTest {

    MockBook inputObject;

    @Before
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerConverter.parseObject(inputObject.mockEntity(), BookVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Michael C. Feathers0", output.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), output.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), output.getPrice());
        Assert.assertEquals("Working effectively with legacy code0", output.getTitle());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Michael C. Feathers0", outputZero.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputZero.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputZero.getPrice());
        Assert.assertEquals("Working effectively with legacy code0", outputZero.getTitle());

        BookVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Michael C. Feathers7", outputSeven.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputSeven.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputSeven.getPrice());
        Assert.assertEquals("Working effectively with legacy code7", outputSeven.getTitle());

        BookVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Michael C. Feathers12", outputTwelve.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputTwelve.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputTwelve.getPrice());
        Assert.assertEquals("Working effectively with legacy code12", outputTwelve.getTitle());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerConverter.parseObject(inputObject.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Michael C. Feathers0", output.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), output.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), output.getPrice());
        Assert.assertEquals("Working effectively with legacy code0", output.getTitle());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Michael C. Feathers0", outputZero.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputZero.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputZero.getPrice());
        Assert.assertEquals("Working effectively with legacy code0", outputZero.getTitle());

        Book outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Michael C. Feathers7", outputSeven.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputSeven.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputSeven.getPrice());
        Assert.assertEquals("Working effectively with legacy code7", outputSeven.getTitle());

        Book outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Michael C. Feathers12", outputTwelve.getAuthor());
        Assert.assertEquals(new GregorianCalendar(2020, 01, 01).getTime(), outputTwelve.getLaunchDate());
        Assert.assertEquals(new BigDecimal("49.00"), outputTwelve.getPrice());
        Assert.assertEquals("Working effectively with legacy code12", outputTwelve.getTitle());
    }
}
