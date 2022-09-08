import java.util.Arrays;

public class left_right_rot {
    static final int RIGHT=0,LEFT=1;
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        rotate(LEFT,a,2);
        System.out.println(Arrays.toString(a));
        rotate(RIGHT,a,2);
        System.out.println(Arrays.toString(a));
    }
    private static void rotate(int rotateMode, int[] a,int d) {
        if(rotateMode == LEFT)
        {
            for (int repeat = 1; repeat <= d; repeat++) {
                int first = a[0];
                for (int i = 0; i < a.length-1; i++) 
                    a[i] = a[i+1];
                a[a.length-1] = first;
            }
        }
        else
        {
            for (int repeat = 1; repeat <= d; repeat++) {
                int last = a[a.length-1];
                for (int i = a.length-1; i > 0; i--) 
                    a[i] = a[i-1];
                a[0] = last;
            }
        }
    }

}
