package collection.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        //模拟一个HashSet的底层 （hashmap的底层）

        //1。创建一个数组，数组的类型是Node
        //2。有些人把Node数组称为表table
        Node[] table = new Node[16];
        System.out.println(table);
        //3。创建节点
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;//将jack节点挂载在john
        Node rose = new Node("rose", null);
        jack.next = rose;
        Node lucy = new Node("lucy", null);
        table[3] = lucy;
        System.out.println("table=" + table);


    }
}

class Node{//代表节点，存储数据，可以指向下一个节点
    Object item;//存放数据

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    Node next;//可以指向下一个节点

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
