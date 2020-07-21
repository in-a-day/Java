package cc.margay.java;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T1 {
    private enum P {
        A("hh", "A"), B("zz", "B"), C("11", "C");

        private String str1;
        private String str2;
        private P(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }
    }
    private static Calendar getAnyTime(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar;
    }
    private static String tt() {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1111");
            return "1111";
        }
        System.out.println("hh");
        return "hh";
    }

    public static void main(String[] args) {
        Sin s = Sin.getInstance();
        Map<String, Function> a = new HashMap<>();
        a.put("1", x -> x);
        a.get("1").apply("2");
        System.out.println(P.valueOf("A"));
        Stream.of(1, 2, 3, 4).collect(Collectors.toList()).forEach(a1 -> {
            if (a1 == 1 || a1 == 3) return;
            System.out.println(a1);
        });
        Integer a2 = 1;
        System.out.println(a2.equals(1));
        System.out.println(a2.equals(1234235));
        Pattern p = Pattern.compile("\\d+");
        String hhh = "2fhdsafja3252352";
        Matcher matcher = p.matcher(hhh);
        List<String> lst = new ArrayList<>();
        while (matcher.find()) {
            lst.add(matcher.group());
        }
        System.out.println(lst);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date now = new Date();
        System.out.println(sf.format(now));
        Calendar anyTime = getAnyTime(now, -2);
        System.out.println(sf.format(anyTime.getTime()));
        long a1 = 1;
        int a11 = 1;
        System.out.println(a1 == a2);
        System.out.println(Integer.valueOf("001"));
        List aaa = Arrays.asList(1, 2, 3);
        System.out.println(aaa.toString());

        tt();
        String zzz = "abcd";
        System.out.println(zzz.substring(0, 3));
        String z2 = null;
        System.out.println(Optional.ofNullable(z2).orElseGet(() -> "hh"));
        System.out.println("hh" + true);
        System.out.println();

        Date nowDate = new Date();
        System.out.println(DateUtil.hoursBetweenTwoDate(nowDate, DateUtil.addDateDays(nowDate, 2)));
        long hh = 24;
        int h = 24;
        System.out.println(hh > h);

        System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1.00")));

    }
}

class Sin {
    private static final Sin instance = new Sin();
    private String name;
    private Sin(){};
    public static Sin getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



