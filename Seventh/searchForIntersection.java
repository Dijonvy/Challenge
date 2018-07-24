public Node searchForIntersection(SinglyLinkedList first, SinglyLinkedList second) {
    if(first.head == null || second.head == null) return null;

    Stack<Node> firstListStack = new Stack<>();
    Stack<Node> secondListStack = new Stack<>();

    for(Node node = first.head; node != null; node = node.next) {
        firstListStack.push(node);
    }

    for(Node node = second.head; node != null; node = node.next) {
        secondListStack.push(node);
    }

    Node topNodeFirst = firstListStack.peek();
    Node topNodeSecond = secondListStack.peek();

    Node intersectionNode = null;
    while((topNodeFirst != null && topNodeSecond != null) && (topNodeFirst == topNodeSecond)) {
        intersectionNode = topNodeFirst;
        if(!firstListStack.empty() && !secondListStack.empty()) {
            topNodeFirst = firstListStack.pop();
            topNodeSecond = secondListStack.pop();
        }else {
            topNodeFirst = null;
            topNodeSecond = null;
        }
    }

    return intersectionNode;
}