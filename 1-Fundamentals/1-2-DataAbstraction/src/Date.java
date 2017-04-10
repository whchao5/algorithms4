import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/8/30.
 * 时间实现
 */
public class Date {
    private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int month;   // month (between 1 and 12)
    private final int day;     // day   (between 1 and DAYS[month]
    private final int year;    // year

    public Date(int month, int day, int year) {
        if (!isValid(month, day, year))
            throw new IllegalArgumentException("Invalid date");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // 一个Date
    public Date(String date) {
        String[] files = date.split("/");
        if(files.length != 3) {
            throw new IllegalAccessError("Invalid date");
        }

        this.month = Integer.parseInt(files[0]);
        this.day = Integer.parseInt(files[1]);
        this.year = Integer.parseInt(files[2]);
        if (!isValid(month, day, year))
            throw new IllegalArgumentException("Invalid date");
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    //验证
    private static boolean isValid(int month, int day, int year) {

        if (month < 1 || month > 12) return false;
        if (day < 1 || day > DAYS[month]) return false;
        if (month == 2 && day == 29 && !isLeapYear(year)) return false;
        return true;
    }

    // 判断是否是润年
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Date that = (Date) other;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true;
    }

    // 加day
    public Date next() {
        if (isValid(month, day + 1, year))
            return new Date(month, day+1, year);
        else if(isValid(month+1, 1, year))
            return new Date(month+1, 1, year);
        else
            return new Date(1, 1, year+1);
    }

    public boolean isAfter(Date that) {

        return compareTo(that) > 0;
    }

    public boolean isBefore(Date that) {

        return compareTo(that) < 0;
    }

    public int compareTo(Date that) {

        if (this.year > that.year) return +1;
        if (this.year < that.year) return -1;
        if (this.month > that.month) return  +1;
        if (this.month < that.month) return -1;
        if (this.day > that.day) return +1;
        if (this.day < that.day) return -1;

        return  0;
    }

    public int hashCode() {

        int hash = 17;
        hash = 31 * hash + month;
        hash = 31 * hash + day;
        hash = 31 * hash + year;

        return hash;
    }

    // 测试用例
    public static void main(String[] args) {
        Date today = new Date(2, 25, 2004);
        StdOut.println(today);

        for (int i = 0; i < 10; i++) {
            today = today.next();
            StdOut.println(today);
        }

        StdOut.println(today.isAfter(today.next()));
        StdOut.println(today.isAfter(today));
        StdOut.println(today.next().isAfter(today));

        Date otherToday = new Date(2, 25, 2004);
        StdOut.println(today.equals(otherToday));


        Date newToday = new Date("4/21/2016");

        StdOut.println(newToday);

        StdOut.println(today.hashCode());
    }
}
