package com.pavlyshyn.battle;


public class CustomDeque<T>  {

    Node head, tail;
    int size;
    public CustomDeque() {
        int size = 0;
        head = tail = null;
    }
    public void addFirst(T t){
        if(head == tail && head == null){
            head = new Node(t);
            tail = head;
            return;
        }
        head.setLeftNode(new Node(t));
        Node temp = head;
        head = head.getLeftNode();
        head.setRightNode(temp);

    }

    public void addLast(T t){
        if(head == tail && tail == null){
            tail = new Node(t);
            head = tail;
            return;
        }
        tail.setRightNode(new Node(t));
        Node temp = tail;
        tail = tail.getRightNode();
        tail.setLeftNode(temp);

    }

    public T removeFirst(){
        T temp = head.getValue();
        if(head == tail){
            head = tail = null;
            return temp;
        }

        head = head.getRightNode();
        head.setLeftNode(null);
        return temp;
    }
    public T removeLast(){
        T temp = tail.getValue();
        if(tail == head){
            head= tail= null;
            return temp;
        }
        tail = tail.getLeftNode();
        tail.setRightNode(null);
        return temp;
    }
    boolean isEmpty(){
        return head==tail;
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node node = head;
        stringBuffer.append("[");
        while (node!=null){
            stringBuffer.append(node.getValue());
            if(node.getRightNode()!=null) {
                stringBuffer.append(", ");
            }
            node = node.getRightNode();
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    class Node{
        T value;
        Node leftNode, rightNode;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    public static void main(String[] args) {
        CustomDeque<Integer> i =  new CustomDeque<>();
        i.addFirst(12);
        i.addFirst(13);
        i.addLast(45);
        i.addLast(89);
        i.addFirst(46);
        i.addLast(79);
        i.addLast(90);
        i.addFirst(11);
        i.addLast(12);
        i.addLast(89);
        System.out.println(i);
        while (!i.isEmpty()){
            System.out.println("f " + i.removeFirst() + " l " + i.removeLast());
        }



    }
}
