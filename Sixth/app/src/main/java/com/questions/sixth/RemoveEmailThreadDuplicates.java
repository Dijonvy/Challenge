package com.questions.sixth;


import com.questions.datastructures.Node;
import com.questions.datastructures.SinglyLinkedList;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class RemoveEmailThreadDuplicates {

    public RemoveEmailThreadDuplicates() { }

    public void removeDuplicateMessages(SinglyLinkedList currentEmailThread) {
        if (currentEmailThread.head == null) throw new NoSuchElementException();
        Set<String> alreadyOnThread = new HashSet<>();
        alreadyOnThread.add(currentEmailThread.head.data);
        for (Node node = currentEmailThread.head; node != null; node = node.next) {
            if (node.next != null) {
                if (alreadyOnThread.contains(node.next.data)) {
                    currentEmailThread.removeNext(node);
                } else {
                    alreadyOnThread.add(node.next.data);
                }
            } else {
                if (alreadyOnThread.contains(node.data)) {
                    currentEmailThread.removeLast();
                } else {
                    alreadyOnThread.add(node.data);
                }
            }
        }
    }
}