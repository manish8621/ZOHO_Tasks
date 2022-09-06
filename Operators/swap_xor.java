public class swap_xor {
    public static void main(String[] args) {
        int a=3,b=4;
        System.out.println("AFTER SWAP");
        System.out.println(a);
        System.out.println(b);      
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("AFTER SWAP");
        System.out.println(a);
        System.out.println(b);
        
    }

}
