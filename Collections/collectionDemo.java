package leetcode;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
public class collectionDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist1 = new LinkedList<>();
        linkedlist1.add(1);
        linkedlist1.add(2);
        linkedlist1.add(3);
        linkedlist1.add(4);
        linkedlist1.remove((Integer)2);
        System.out.println("LinkedList "+linkedlist1);

        Map<String ,String> map = new HashMap<>();
        map.put("1","foo");
        map.put("2","bar");
        map.put("3","bus");
        //check before putting key,value
        if(map.containsKey("3")){
            //put string as concatenated with old one
            String oldValue = map.get("3");
            map.put("3",oldValue +" "+"uio");
        }
        else
        map.put("3","uio");
        System.out.println(map);
        for (String val : map.values()) {
            //split with space
            String[] strArray = val.split(" ");
            for (String  items : strArray)
                System.out.println(items);
        }
    }
}