package stack.stack_using_linkedlist;

public class LinkedList {

    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;

        head = node;
        tail = node;

        size = 1;
        return head;
    }

    // Insert Method SinglyLinkedList
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            // inserting at the 'beginning' of the linkedlist
            node.next = head;
            head = node;
        } else if (location >= size) {
            // at the 'end' of the linked list
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            // inserting in the 'middle' of the linkedlist
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;

        }
        size++;
    }

    // SinglyLinkedList Traversal
    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("SLL doesn't exist");
        } else {
            Node tempNode = head;
            int start = 0;
            while (start < size) {
                System.out.print(tempNode.value);
                if (start != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
                start++;
            }
        }
        System.out.println();
    }

    // Searching for a node in a linked list
    public boolean searchNode(int nodeValue) {
        if (head != null) { // making sure that linked-list exists
            Node tempNode = head;
            int start = 0;
            while (start < size) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location " + (start + 1));
                    return true;
                }
                start++;
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found!");
        return false;
    }

    // deleting a node from a singly linked list
    public void deletionOfNode(int location) {
        if (head == null) { // checking if linkedlist exists or not
            System.out.println("The SLL doesn't exist");
            return;
        } else if (location == 0) { // deleting from the 'beginning'  // // 0 if '0' index based deletion
            // again there could be 2 cases, a). 1 node b). more than 1 node

            head = head.next;
            size--;
            if (size == 1) { // taking care of 1 node scenario
                tail = null;
            }
        } else if (location >= size) { // Deleting from the 'end'
            // again there could be 2 cases, a). 1 node b). more than 1 node

            Node tempNode = head;
            int start = 0; // 0 if '0' index based deletion
            while (start < size - 1) { // going a node before the last-node
                tempNode = tempNode.next;
                start++;
            }
            if (tempNode == head) { // means only 1 node i.e. it never entered the loop. Thus, tempNode == head
                tail = null;
                head = null;
                size--;
                return; // as there is only 1 node, so, we don't have to do anything further.
            }
            // for nodes > 1
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { // DELETING middle node
            Node tempNode = head;
            int start = 0; // 0 if '0' index based deletion
            while (start < location - 1) {
                tempNode = tempNode.next;
                start++;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // deleting ENTIRE linkedlist
    public void deleteSLL() {
        head = null;
        tail = null;
        System.out.println("The SLL deleted successfully");
    }
}
