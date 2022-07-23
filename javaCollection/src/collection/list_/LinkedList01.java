package collection.list_;

public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node qzq = new Node("qzq");

        //连接三个节点形成双向链表
        jack.next = tom;
        tom.next = qzq;
        qzq.pre = tom;
        tom.pre = jack;

        Node first = jack;
        Node last = qzq;

        //从头到尾遍历
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first.toString());
            first = first.next;
        }
        System.out.println("=================");
        //从尾到头遍历
        while (true){
            if (last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        //在tom和qzq之间插入一个zf
        Node zf = new Node("zf");
        tom.next = zf;
        zf.next = qzq;
        qzq.pre = zf;
        zf.pre = tom;

        System.out.println("=================");
        first = jack;
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first.toString());
            first = first.next;
        }
    }
}
//定义一个Node类，表示我们双向链表的节点 Node对象
class Node{
    public Object item;
    public Node next;
    public Node pre;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "item=" + item;
    }
}

