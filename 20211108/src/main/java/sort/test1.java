package sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
    @Test
    public void test1(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
