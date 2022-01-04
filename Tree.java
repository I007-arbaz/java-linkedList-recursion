package dataStructure;
import java.util.Scanner;

class Node {
    int data;
    Node next = null;
    Node(int data) {
        this.data = data;
    }
}

public class Tree {
    static Node create_tree() {
        Scanner sc = new Scanner(System.in);
        Node root;
        System.out.println("enter a no. : ");
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new Node(data);
        root.next = create_tree();
        return root;
    }

    //insertion at end
    static void insert(Node head, int data) {
        if(head.next == null) {
            head.next = new Node(data);
        }else {
            insert(head.next, data);
        }
    }

    //insertion at index
    static void insert(Node head, int data, int pos) {
        if(head.next == null) System.out.println("position is over stacked");
        if(pos == 0) {
            Node newNode = new Node(data);
            newNode.next = head.next;
            head.next = newNode;
        }else {
            insert(head.next, data, pos-1);
        }
    }

    static void delete(Node head) {
        if(head == null) {
            System.out.println("root is null nothing to delete");
        }else if(head.next.next == null) {
            head.next = null;
        }else {
            delete(head.next);
        }
    }
    static void delete(Node head, int pos) {
        if (pos == 0) {
            head.next = head.next.next;
        }else {
            delete(head, pos-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = create_tree();
        System.out.println("enter number and position: ");
        int num = sc.nextInt();
        int pos = sc.nextInt();
        insert(root, num, pos);
        System.out.println("enter number: ");
        int data = sc.nextInt();
        insert(root, data);
        Node traverse_node = root;
        while(traverse_node != null) {
            System.out.print(traverse_node.data + "->");
            traverse_node = traverse_node.next;
        }
        delete(root);
        Node new_list = root;
        System.out.println("enter position to delete: ");
        int del_pos = sc.nextInt();
        delete(root, del_pos);
        while(new_list != null) {
            System.out.print(new_list.data + "->");
            new_list = new_list.next;
        }
    }
}
