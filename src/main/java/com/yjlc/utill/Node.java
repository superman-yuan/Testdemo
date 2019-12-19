package com.yjlc.utill;

/**
 * Created by Liuziyuan on 2019/9/6.
 */
public class Node<T> {

    //节点的内容
    T data;
    //下个节点
    Node nextNode;

    public Node(T data){
        this.data=data;
    }

    //追加节点
    public Node append(Node node){
        //获取当前节点
        Node currentNode = this;
        while(true){
            Node nextNode = currentNode.nextNode;
            if(nextNode==null){
                break;
            }
            //赋当前节点
            currentNode = nextNode;
        }
        //追加节点并赋值
        currentNode.nextNode=node;
        return this;

    }

    public void remove(){
        Node newNode = nextNode.nextNode;
        this.nextNode=newNode;
    }



}
