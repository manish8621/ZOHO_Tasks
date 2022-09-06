class odd_even
{
    public static void main(String[] args) {
        int n=8;
        if(oddOrEven(n))
        System.out.println("even");
        else
        System.out.println("odd");

    }

    private static boolean oddOrEven(int n) {
        return ((n&1)==0);
    }
}