public class decimal_to_bin {
    public static void main(String[] args) {
        int n=10;
        System.out.println(toBinary(n));
        System.out.println(toDecimal("1010"));
    }
    static String toBinary(int n)
    {
        String bin = "";
        while (n!=0) {
            bin = n%2+bin;
            n/=2;
        }
        return bin;
    }
    static int toDecimal(String bin)
    {
        int n = 0;
        int len=bin.length()-1;
        for (int i = 0; i <= len; i++)
            n += Integer.parseInt((""+bin.charAt(i)))*Math.pow(2, len-i);
        return n;
    }
}
