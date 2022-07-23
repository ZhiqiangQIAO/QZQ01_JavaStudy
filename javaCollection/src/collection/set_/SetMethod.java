package collection.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
    public static void main(String[] args) {
        //1、以Set接口的实现类、HashSet为例，描述Set常用方法
        //2、set接口的实现类的对象（Set接口对象）不能存放重复的元素
        //3、可以添加一个null，set存放数据是无序的（添加顺序和取出的顺序不一致）
        //4、取出顺序是一致的、固定的
        Set hashSet = new HashSet();
        hashSet.add("jack");
        hashSet.add("lucy");
        hashSet.add("qzq");
        hashSet.add("jack");//重复
        hashSet.add(null);
        hashSet.add(null);//重复
        for (int i = 0; i < 10; i++) {
            System.out.println(hashSet);
        }
        //遍历
        //1、迭代器
        System.out.println("=======迭代器遍历============");
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
        System.out.println("========增强for循环==========");
        //2、增强for循环
        for (Object o : hashSet) {
            System.out.println(o);
        }

        //3、set接口对象不能通过索引来获取



    }
}
