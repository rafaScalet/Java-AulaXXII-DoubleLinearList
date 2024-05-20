package eddll;

public class DoubleLinearList {
    private Node top;
    private Node bottom;
    private long size;

    public DoubleLinearList() {
        this.top = null;
        this.bottom = null;
        this.size = 0;
    }

    private boolean empty() {
        return (this.top == null && this.bottom == null);
    }

    public void add(Node node) {
        if (this.empty()) {
            this.top = this.bottom = node;
        } else {
            Node serv = this.top;
            node.setNext(serv);
            this.top = node;
            serv.setPrev(node);
        }
        this.size++;
    }

    public void append(Node node) {
        if (this.empty()) {
            this.top = this.bottom = node;
        } else {
            Node serv = this.bottom;
            node.setPrev(serv);
            this.bottom = node;
            serv.setNext(this.bottom);
        }
        this.size++;
    }

    public Node pop() {
        Node retNode = null;
        Node serv = null;
        if (this.empty()) {
            return null;
        }
        if (this.size == 1) {
            this.top = this.bottom = null;
        } else {
            retNode = this.bottom;
            serv = retNode.getPrev();
            retNode.setPrev(null);
            this.bottom = serv;
        }
        this.size--;

        return retNode;
    }

    public Node remove() {
        Node retNode = null;
        Node serv = null;
        if (this.empty()) {
            return null;
        }
        if (this.size == 1) {
            this.top = this.bottom = null;
        } else {
            retNode = this.top;
            serv = retNode.getNext();
            retNode.setNext(null);
            this.top = serv;
        }
        this.size--;

        return retNode;
    }

    public void clear() {
        while (!this.empty()) {
            this.remove();
        }
    }

    public Node search(String id) {
        Node retNode = this.top;
        if (this.empty()) {
            return null;
        } else {
            while (retNode != null && !retNode.getId().equals(id)) {
                retNode = retNode.getNext();
            }
        }

        return retNode;
    }

    public void show() {
        Node serv = this.bottom;
        while (serv != this.top) {
            System.out.println("-->" + serv.getValue());
            serv = serv.getPrev();
        }
        System.out.println("-->" + serv.getValue());
    }
}
