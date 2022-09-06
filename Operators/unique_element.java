public class unique_element {
    public static void main(String[] args) {
        int[] a ={1,2,9,6,7,6,4,1,4,2,9}; 
        int c=0;
        for (int item : a) 
            c ^= item; //every pair's xor will be 0
        System.out.println(c);
    }
}
