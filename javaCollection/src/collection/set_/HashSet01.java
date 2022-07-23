package collection.set_;

import java.util.HashSet;

public class HashSet01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        //1.在执行add方法后会返回一个boolean值
        //2.成功返回true，否则返回false
        //3.可以通过remove制定删除对象
        System.out.println(hashSet.add("john"));//t
        System.out.println(hashSet.add("lucy"));//t
        System.out.println(hashSet.add("john"));//f
        System.out.println(hashSet.add("jack"));//t
        System.out.println(hashSet.add("Rose"));//t
        hashSet.remove("john");
        System.out.println(hashSet);

        //4.HashSet不能添加相同的元素/数据？
        hashSet = new HashSet();
        hashSet.add("lucy");//t
        hashSet.add("lucy");//f
        hashSet.add(new Dog("tom"));//t
        hashSet.add(new Dog("tom"));//t
        System.out.println(hashSet);

        //5.加深之经典面试题
        //看源码
        hashSet.add(new String("qzq"));//t
        hashSet.add(new String("qzq"));//false！！！
        System.out.println(hashSet);
    }
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
