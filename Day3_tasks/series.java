import java.math.BigInteger;

public class series {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("start:");
        BigInteger start = new BigInteger(Sting.valueOf(scan.nextInt()));
        System.out.print("end:");
        int end = scan.nextInt();
        System.out.println((start.multiply((new BigInteger("2")).pow(end)))); // start ->5  end->3  ans->40
    }
}
