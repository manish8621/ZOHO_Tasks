import java.util.Arrays;

public class rearrange {
    public static void main(String[] args) {
        int arr[] = {1,2,1,4,5,6,8,8};
        int res[] = new int[arr.length];
        int mid = (arr.length/2);

        //sort by default
        Arrays.sort(arr);
        //if odd length ed array
        mid = (arr.length%2 == 0)? mid-1:mid;
        //assign starting element
        res[0] = arr[mid];
        for (int i = 1,index=1; mid+i <arr.length; i++) {
            res[index++] = arr[mid+i];
            if(mid-i>=0)
                res[index++] = arr[mid-i];
        } 
        System.out.println(Arrays.toString(res));

    }
}
