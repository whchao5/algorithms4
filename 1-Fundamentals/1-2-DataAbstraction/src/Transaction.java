import edu.princeton.cs.algs4.StdOut;

/**
 * Created by HJKLI on 2016/11/29.
 */
public class Transaction {

    private final String who;
    private final Date date;
    private final double amount;

    public Transaction(String who, Date when, double amount) {

        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");

        this.who = who;
        this.date = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] files = transaction.split("\\s+");
        this.who = files[0];
        this.date = new Date(files[1]);
        this.amount = Double.parseDouble(files[2]);
    }

    public String who() {
        return this.who;
    }

    public Date when() {
        return this.date;
    }

    public double amount() {
        return this.amount;
    }

    public String toString() {
        return String.format("%-10s %10s %8.2f", who, date, amount);
    }

    public boolean equals(Object other) {
        if (this == other)                          return true;
        if (other == null)                          return false;
        if (this.getClass() != other.getClass())    return false;

        Transaction that = (Transaction) other;
//        if (this.amount != that.amount)            return false;
//        if (!(this.date.equals(that.date)))            return false;
//        if (!(this.who.equals(that.who) ))                  return false;
//        return true;

        // 简写
        return (this.amount == that.amount)
                && (this.date.equals(that.date))
                && (this.who.equals(that.who));
    }

    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + who.hashCode();
        hash = 31 * hash + date.hashCode();
        hash = 31 * hash + ((Double) amount).hashCode();

        return hash;
    }

    public int compareTo(Transaction that) {
        return Double.compare(this.amount, that.amount);
    }

    // 测试数据
    public static void main(String[] args) {
        Transaction[] a = new Transaction[4];
        a[0] = new Transaction("Turing   6/17/1990  644.08");
        a[1] = new Transaction("Tarjan   3/26/2002 4121.85");
        a[2] = new Transaction("Knuth    6/14/1999  288.34");
        a[3] = new Transaction("Dijkstra 8/22/2007 2678.40");

        Transaction that = new Transaction("Turing   6/17/1990  644.08");

        StdOut.println("Unsorted");
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
        StdOut.println();

        StdOut.println(a[0].equals(that));

        StdOut.println(that.hashCode());

    }
}
