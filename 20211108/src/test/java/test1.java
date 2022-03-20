import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class test1 {
    @Test
    public void test1() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    @Test
    public void dateTest() {
        //now()获取当前时间的日期，时间，日期加时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(localDateTime);
        //of()设置指定的日期时间
        LocalDate localDate = LocalDate.of(2002, 10, 1);
        int dayOfMonth = localDate.getDayOfMonth();
        LocalDate localDate1 = localDate.withDayOfMonth(21);
        System.out.println(localDate1);
        System.out.println(dayOfMonth);
        System.out.println(localDate);
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = dfs(n);
        System.out.println(res);
    }

    static int dfs(int n) {
        if (n <= 2) return 1;
        return dfs(n - 2) + dfs(n - 3);
    }
}
