public class LinkedList<T> {
    private Node<T> tail;
    private Node<T> head;
    private int length;

    LinkedList() {
        length = 0;
    }

    LinkedList(T newValue) {
        Node<T> temp = new Node<T>(newValue, null);
        tail = temp;
        length = 1;
    }

    int length() {
        return length;
    }

    Node<T> getTail() {
        return tail;
    }

    Node<T> getHead() {
        return head;
    }

    @SuppressWarnings("unchecked")
    LinkedList<T> addFront(T... values) {
        for (T newValue : values) {
            if (this.contains(newValue)) {
                continue;
            }
            Node<T> temp = new Node<T>(newValue, tail);
            tail.setPrevious(temp);
            tail = temp;
        }
        return this;
    }

    LinkedList<T> clear() {
        this.tail = null;
        this.head = null;
        length = 0;
        return this;
    }

    @SuppressWarnings("unchecked")
    LinkedList<T> add(T... values) {
        Node<T> temp = new Node<T>(values[0], null);
        if (length == 0) {
            tail = temp;
            head = temp;
            length++;
            return this;
        }
        Node<T> current = tail;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        for (T newValue : values) {
            if (this.contains(newValue)) {
                continue;
            }
            temp = new Node<T>(newValue, null);
            temp.setPrevious(current);
            current.setNext(temp);
            head = current.getNext();
            current = current.getNext();
            length++;
        }
        return this;
    }

    T pop() {
        T temp = head.getPrevious().getValue();
        head.getPrevious().setNext(null);
        return temp;
    }

    T get(int index) {
        Node<T> temp = tail;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    boolean contains(T value) {
        Node<T> temp = tail;
        while (temp.getNext() != null) {
            if (value.equals(temp.getValue())) {
                return true;
            }
            temp = temp.getNext();
        }
        if (value.equals(temp.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    LinkedList<T> remove(T... values) {
        for (T value : values) {
            Node<T> temp = tail;
            if (temp.getValue().equals(value)) {
                tail = temp.getNext();
            }
            while ((temp = temp.getNext()) != null) {
                if (temp.getValue().equals(value)) {
                    temp.getPrevious().setNext(temp.getNext());
                    temp.getNext().setPrevious(temp.getPrevious());
                }
            }
        }
        return this;
    }

    @Override
    public String toString() {
        if (tail == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Node<T> temp = tail;
        while (temp.getNext() != null) {
            sb.append(temp.getValue() + " -> ");
            temp = temp.getNext();
        }
        return sb.append(temp.getValue() + " -> null").toString();
    }

    String toStringBackwards() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp.getPrevious() != null) {
            sb.append(temp.getValue() + " -> ");
            temp = temp.getPrevious();
        }
        return sb.append(temp.getValue() + " -> null").toString();
    }

    @SuppressWarnings("unchecked")
    LinkedList<T> reverse() {
        LinkedList<T> newList = new LinkedList<>();
        Node<T> temp = head;
        while (temp.getPrevious() != null) {
            newList.add(temp.getValue());
            temp = temp.getPrevious();
        }
        return newList.add(temp.getValue());
    }

    @SuppressWarnings("unchecked")
    LinkedList<T> sort() {
        LinkedList<T> newList = new LinkedList<T>().add(tail.getValue());
        Node<T> temp = tail.getNext();
        while (temp.getNext() != null) {
            if (newList.getTail().getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
                newList.addFront(temp.getValue());
            } else if (newList.getHead().getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
                Node<T> second_temp = newList.getTail().getNext();
                while (second_temp != null) {
                    if (second_temp.getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
                        Node<T> third_temp = new Node<T>(temp.getValue(), temp.getNext(), temp.getPrevious());
                        third_temp.setPrevious(second_temp.getPrevious());
                        third_temp.setNext(second_temp);
                        second_temp.getPrevious().setNext(third_temp);
                        second_temp.setPrevious(third_temp);
                        if (second_temp.getNext() == null) {
                            head = third_temp;
                        }
                        break;
                    }
                    second_temp = second_temp.getNext();
                }
            } else if (newList.getHead().getValue().toString().compareTo(temp.getValue().toString()) <= -1) {
                newList.add(temp.getValue());
            }
            temp = temp.getNext();
        }
        if (newList.getTail().getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
            newList.addFront(temp.getValue());
        } else if (newList.getHead().getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
            Node<T> second_temp = newList.getTail().getNext();
            while (second_temp != null) {
                if (second_temp.getValue().toString().compareTo(temp.getValue().toString()) >= 1) {
                    Node<T> third_temp = new Node<T>(temp.getValue(), temp.getNext(), temp.getPrevious());
                    third_temp.setPrevious(second_temp.getPrevious());
                    third_temp.setNext(second_temp);
                    second_temp.getPrevious().setNext(third_temp);
                    second_temp.setPrevious(third_temp);
                    if (second_temp.getNext() == null) {
                        head = third_temp;
                    }
                    break;
                }
                second_temp = second_temp.getNext();
            }
        } else if (newList.getHead().getValue().toString().compareTo(temp.getValue().toString()) <= -1) {
            newList.add(temp.getValue());
        }
        return newList;
    }

    boolean isSorted(Node<T> node) {
        if (node.getNext() == null) {
            return true;
        }
        if (node.getValue().toString().compareTo(node.getNext().getValue().toString()) < 0) {
            return isSorted(node.getNext());
        } else {
            return false;
        }
    }
}