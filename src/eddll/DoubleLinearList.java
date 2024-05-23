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

    public Node getPosNode(int pos) {
        Node serv = this.top;
        if (empty() || pos > this.size) {
            return null;
        }
        for (int indx = 1; indx < pos; indx++) {
            serv = serv.getNext();
        }
        return serv;
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
            serv.setPrev(this.top);
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
        if (this.empty()) {
            return null;
        }
        Node serv = this.bottom;
        this.bottom = serv.getPrev();
        if(this.bottom != null){
            Node newBottom = this.bottom;
            newBottom.setNext(null);
            serv.setPrev(null);
        } else{
            this.top = this.bottom;
        }
        this.size--;
        return serv;
    }

    public Node remove() {
        if (this.empty()) {
            return null;
        }
        Node serv = this.top;
        this.top = serv.getNext();
        if (this.top != null) {
            Node newTop = this.top;
            newTop.setPrev(null);
            serv.setNext(null);
        } else {
            this.bottom = this.top;
        }
        this.size--;
        return serv;
    }

    public Node delete(int num) {
        Node serv = null;
        Node servPos = null;
        if (this.empty() || num > size) {
            return null;
        }
        if (num == 1) {
            return this.remove();
        }
        if (this.size == num) {
            return this.pop();
        }
        if (this.size > 1) {
            serv = getPosNode(num - 1);
            servPos = serv.getNext();
            serv.setNext(servPos.getNext());
            servPos.getNext().setPrev(serv);
            servPos.setPrev(null);
            servPos.setNext(null);
            this.size--;
        }
        return servPos;
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
        Node serv = this.top;
        while (serv != null) {
            System.out.println("-->" + serv.getValue());
            serv = serv.getNext();
        }
    }
}
