import java.math.BigInteger;

public class chess {
    public static void main(String[] args) {
        BigInteger start = new BigInteger("1"),bi = new BigInteger("0");
        int end =63;
        for (int i = 0; i <= end; i++) 
            bi = bi.add(start.multiply((new BigInteger("2")).pow(i)));
        System.out.println(bi); //18446744073709551615
    }
}
