class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        if (previous == null) return;
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;
        while (count < elementNumber && current != null) {
            current = current.next;
            count++;
        }
        return current;
    }

    // ✅ Método que sigue EXACTAMENTE el pseudocódigo de la imagen
    public Node LinkedListDelete(Node head, int index) {
        // ① Lista vacía
        if (head == null) {
            return null;
        }

        // ② Caso: eliminar la cabeza
        if (index == 0) {
            Node newHead = head.next;
            head.next = null;
            return newHead;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        // ③ Recorrer hasta índice
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }

        // ④ Si encontramos el nodo
        if (current != null) {
            // ⑤ Enlazar anterior con el siguiente
            previous.next = current.next;
            // ⑥ Desconectar nodo eliminado
            current.next = null;
        } else {
            // ELSE → índice inválido
            System.out.println("Error: índice inválido " + index);
        }

        // ⑦ Retornar la cabeza original
        return head;
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/\n");
    }

    public Node getHead() {
        return head;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10); // 10->20->30->40->50->/

        Node head = list.getHead();

        System.out.print("Lista original: ");
        list.printList(head);

        // Eliminar nodo índice 3 (que es 40)
        head = list.LinkedListDelete(head, 3);
        System.out.print("Después de eliminar índice 3: ");
        list.printList(head);

        // Eliminar cabeza (índice 0 → valor 10)
        head = list.LinkedListDelete(head, 0);
        System.out.print("Después de eliminar índice 0: ");
        list.printList(head);

        // Intentar índice inválido
        head = list.LinkedListDelete(head, 10);
        System.out.print("Después de intentar eliminar índice inválido: ");
        list.printList(head);
    }
}