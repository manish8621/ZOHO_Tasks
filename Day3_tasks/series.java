import java.math.BigInteger;

public class series {
    public static void main(String[] args) {
        BigInteger start = new BigInteger("5");
        int end = 100;
        System.out.println((start.multiply((new BigInteger("2")).pow(end)))); //40
    }
}
