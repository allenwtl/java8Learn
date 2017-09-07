package com.allen.learn.java8Learn.dataStructure;


/**
 * 单向链表
 */
public class MyLink<E> {


    transient Node<E> head ;

    public boolean addNode(Node<E> node){
        if ( node == null ){
            return false ;
        }

        if ( isEmpty() ){
            head = node;
            return true;
        }

        Node<E> curNode = head;
        Node<E> nextNode = head.next;
        while ( nextNode != null ){
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        curNode.next = node;
        size();
        return true;
    }

    /**
     * 数组中的第几个，并非下标。
     * @param index
     * @return
     */
    public boolean deleteByIndex(int index){
        if ( index <= 0 || index > size() ) {
            return false;
        }

        if ( head == null ){
            return false;
        }

        if ( index == 1){
            head = head.next;
            return true ;
        }

        Node<E> preNode = head;
        Node<E> curNode = head.next ;
        int n = 1; //数组的顺序
        while ( preNode != null ){
            n++;
            if ( n == index){
                //删除
                preNode.next = curNode.next ;
                return true ;
            }
            preNode = curNode ;
            curNode = curNode.next;
        }
        return false;
    }


    /**
     * 链表反转
     */
    public  Node<E> reverseIteratively(){
        if(head == null){
            return null ;
        }
        Node<E> newHead = null; //头部的引用
        Node<E> preNode = null ; //前一个Node
        Node<E> curNode = head;  //当前的Node
        while ( curNode != null ){
            Node<E> nextNode = curNode.next;
            curNode.next = preNode ;
            if ( nextNode != null){
                preNode = curNode ;
                curNode = nextNode ;
            } else {
                newHead = curNode ;
                this.head = newHead ;
                return newHead;
            }
        }
        return null;
    }

    /**
     * 移除某个特定的节点
     * @param node
     * @return
     */
    public boolean removeNode(Node<E> node){
        Node<E> curNode = head ;
        if ( head == null || node == null ){
            return false ;
        }
        while (curNode!= null ){

            if ( curNode.item.equals(node.item) ){
                curNode.item = curNode.next.item;
                curNode.next = curNode.next.next;
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    /**
     * 从尾输出到头部
     * 递归输入数据
     */
    public void printListReversely (Node<E> curNode){
        if ( curNode != null ){
            printListReversely( curNode.next );
            System.out.println("printListReversely :data:"+curNode.item);
        }
    }



    public static void main(String[] args) {

        MyLink<String> myLink = new MyLink<>();

        for ( int i=0;i<4;i++ ){
            String NodeName = "Node-"+i ;
            Node<String> node = new Node<>(NodeName);
            myLink.addNode(node);

        }

        Node<String> removeNode = new Node<>("Node-1");
//        boolean result = myLink.removeNode(removeNode);
//        System.out.println(result);

//        myLink.printListReversely(myLink.head);
//
//        Node<String> newNode = myLink.reverseIteratively();
//
//        myLink.printListReversely(myLink.head);
//
//        System.out.println(myLink.size());

        myLink.deleteByIndex(2);
        System.out.println(myLink);
    }



    private boolean isEmpty(){
        return head == null ;
    }


    private int size(){
        int n = 0;
        Node<E> next = head ;
        while( next != null  ) {
            n++;
            next = next.next ;
        }
        return  n ;
    }

    private static class Node<E>{
        E item;  //自己本身的数据
        Node<E> next;   //下一个节点的引用

        public Node(E item) {
            this.item = item;
        }

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }


}
