package collection.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    public static void main(String[] args) {
        //看源码
        //1。构造器
        /*public HashSet() {
            map = new HashMap<>();
          }*/
        Set hashSet = new HashSet();
        //2。HashSet可以存放null值，但是只能有一个空
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet);
        //3。不保证存放数据的顺序和取出数据一致


    }
}
