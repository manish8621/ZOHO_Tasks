import java.math.BigInteger;
import java.util.ArrayList;

public class chess {
    public static void main(String[] args) {
        BigInteger start = new BigInteger("1");
        int end =63;
        BigInteger bi = new BigInteger("0");
        for (int i = 0; i <= end; i++) 
            bi = bi.add(start.multiply((new BigInteger("2")).pow(i)));
        System.out.println(bi); //18446744073709551615

        ArrayList<Integer> a = new ArrayList<>();
        method(a);
        System.out.println(a);

    }
    static void  method(ArrayList<Integer> l)
    {
        l.add(1);
    }
}
