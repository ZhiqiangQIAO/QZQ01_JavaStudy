package collection.set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println(hashSet);

        //HashSet源码解读
        /*
        1。先执行构造器
        * public HashSet() {
            map = new HashMap<>();
          }
        2。执行add方法
        public boolean add(E e) { // e = "java"
            return map.put(e, PRESENT)==null;//PRESENT来自于HashSet中
            //private static final Object PRESENT = new Object();//静态final占位空对象
        }
        3。执行put方法
        public V put(K key, V value) {//key="java",value=PRESENT共享
            return putVal(hash(key), key, value, false, true);
        }
        4。执行hash方法
        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);//无符号的位移16位，
            计算key对应的hash值 按位异或 h算术右移16位

        }
        5。执行putVal方法 核心代码！
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;//定义辅助变量
            //table是hashmap的一个属性数组，类型就是一个Node数组
            //if语句表示如果当前tabel是null,或者大小位0进行第一次扩容，到16个空间，记录负载因子*大小作为下次扩容的缓冲0。75*16=12
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            //（1）根据key得倒的hash值，去计算该key应该存放到tabel表的哪个索引位置，
            //并且把这个位置的对象赋值给辅助变量p;
            //（2）判断p，是否为null
            //（2。1）如果p为null，表示还没有存放过元素，那么就创建一个Node（Key="java" Value="PRESENT"）
            //（2。2）就放在该位置tab[i] = newNode(hash, key, value, null),
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                //辅助变量（局部变量）在需要的时候再创建
                Node<K,V> e; K k;
                //如果当前索引对应位置对应的链表的第一个元素和准备添加的key的hash值相同，
                //并且满足准备加入的key和p指向的Node节点的key是同一个对象，或者不是同一个对象但内容相同
                if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                //再判断p是不是一颗红黑树
                //如果是一颗红黑树就调用putTreeVal方法添加
                else if (p instanceof TreeNode)
                    e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                //如果tabel对应的索引位置是一个链表，就依次for循环比较
                //（1）依次和该链表的每一个元素比较后都不想同，就挂载在后面
                //    注意，把元素添加到链表后立即判断该链表是否有8个节点 如果达到了8个节点，调用红黑树对我们当前的链表进行树化
                //    进行树化时，还进行一个判断，如果数组的长度小于64，就先扩容
                //（2）依次比较过程中，如果有相同的情况，直接break
                    for (int binCount = 0; ; ++binCount) {//死循环
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            //afterNodeInsertion是hashmap留给它的子类去实现一些方法，如有序链表等等，这里返回空
            afterNodeInsertion(evict);
            return null;
        }
        * */


    }
}
