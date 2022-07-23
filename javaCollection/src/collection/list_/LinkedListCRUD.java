package collection.list_;

import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        System.out.println("LinkedList=" + linkedList);

        //删除节点
        linkedList.remove();//默认删除首节点
        System.out.println(linkedList);
//        linkedList.remove(2);

        //修改节点
        linkedList.set(1,"4");
        System.out.println(linkedList);

        //得到某个节点对象
        Object o = linkedList.get(1);
        System.out.println(o);

        //linkedlist实现了list接口，所以遍历方式可以使用增强for循环或者迭代器。

        //源码阅读
        //1。LinkedList linkedList = new LinkedList();
        /*public LinkedList(){}
          2. 这时的linkedlist的属性first==null,last=null
        * 3. 执行添加
            public boolean add(E e) {
               linkLast(e);
                return true;
            }
          4。 将新的节点加入到双向链表的最后
            void linkLast(E e) {
                    final Node<E> l = last;
                    final Node<E> newNode = new Node<>(l, e, null);
                    last = newNode;
                    if (l == null)
                        first = newNode;
                    else
                        l.next = newNode;
                    size++;
                    modCount++;
                }
          5。 删除节点
              public E remove() {
                return removeFirst();
              }
              public E removeFirst() {
                final Node<E> f = first;
                if (f == null)
                    throw new NoSuchElementException();
                return unlinkFirst(f);
               }
               private E unlinkFirst(Node<E> f) {
                    // assert f == first && f != null;
                     final E element = f.item;
                    final Node<E> next = f.next;
                    f.item = null;
                    f.next = null; // help GC
                    first = next;
                    if (next == null)
                        last = null;
                    else
                        next.prev = null;
                    size--;
                    modCount++;
                    return element;
                }
        */

    }
}
