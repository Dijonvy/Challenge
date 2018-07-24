package com.questions.datastructures;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.NoSuchElementException;

public class SinglyLinkedList implements Parcelable {
    public Node head;

    public SinglyLinkedList() {
        head = null;
    }

    protected SinglyLinkedList(Parcel in) {
        head = in.readParcelable(Node.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(head, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SinglyLinkedList> CREATOR = new Creator<SinglyLinkedList>() {
        @Override
        public SinglyLinkedList createFromParcel(Parcel in) {
            return new SinglyLinkedList(in);
        }

        @Override
        public SinglyLinkedList[] newArray(int size) {
            return new SinglyLinkedList[size];
        }
    };

    public boolean isEmpty() {
        return (head == null);
    }

    public void addFirst(Node node) {
        if(isEmpty()) head = node;
        else {
            Node tmp = head;
            head = node;
            head.next = tmp;
        }
    }

    public void addLast(Node node) {
        if(isEmpty()) head = node;
        else {
            Node tmp = head;
            while(tmp.next != null) tmp = tmp.next;

            tmp.next = node;
        }
    }

    public Node removeNext(Node node) {
        if(isEmpty()) throw new NoSuchElementException();
        else if (node.next == null) {
            node = node.next;
            return node;
        }else {
            Node tmp = node.next;
            node.next = node.next.next;
            return tmp;
        }
    }

    public Node removeLast() {
        if(isEmpty()) throw new NoSuchElementException();
        else if (head.next == null) {
            head = null;
            return head;
        }
        else {
            Node tmp = head;
            while(tmp.next.next != null) tmp = tmp.next;

            Node result = tmp.next;
            tmp.next = null;
            return result;
        }
    }
}