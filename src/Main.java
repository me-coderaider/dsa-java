import singlylinkedlist.SinglyLinkedList;

class Main {

    public static void main(String[] args) {
        // Singly LL
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.createSinglyLinkedList(11);

        // System.out.println(sLL.head.value);
        sLL.insertInLinkedList(6, 1);
        sLL.insertInLinkedList(7, 3);
        sLL.insertInLinkedList(8, 4);
        sLL.insertInLinkedList(9, 5);
        sLL.insertInLinkedList(10, 2);
        sLL.traverseSinglyLinkedList();
    }
}