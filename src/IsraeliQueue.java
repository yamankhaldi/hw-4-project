import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.reflect.InvocationTargetException;


public class IsraeliQueue<E> implements Iterable<E>, Cloneable {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public IsraeliQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(E element, E friend) throws InvalidInputException {
        if (element == null ) {
            throw new InvalidInputException();
        }

        Node<E> newNode = new Node<>(element);

        if (head == null) {
            head = tail = newNode;
        } else {
            Node<E> friendNode = head.isContained(friend);
            if (friendNode != null) {
                addAfterFriend(friendNode, newNode);
            } else {
                tail.setNext(newNode);
                tail = newNode;
            }
        }

        size++;
    }

    private void addAfterFriend(Node<E> friendNode, Node<E> newNode) {

        newNode.setNext(friendNode.getNext());
        friendNode.setNext(newNode);

        if (friendNode == tail) {
            tail = newNode;
        }
    }

    public void add(E element) throws InvalidInputException {
        add(element , null);
    }

    public E remove() throws EmptyQueueException {
        if (head == null) {
            throw new EmptyQueueException("The queue is empty");
        }

        E value = head.getValue();
        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        size--;

        return value;
    }

    public E peek() throws EmptyQueueException {
        if (head == null) {
            throw new EmptyQueueException("The queue is empty");
        }
        return head.getValue();
    }

    public int returnSize() {
        return size;
    }

    @Override
    public IsraeliQueue<E> clone() {
        IsraeliQueue<E> cloneQueue = new IsraeliQueue<>();
        try {
            Node<E> current = head;
            while (current != null) {
                E clonedElement = cloneElement(current.getValue());
                cloneQueue.add(clonedElement);
                current = current.getNext();
            }
        } catch (CloneNotSupportedException e) {
            // Handle cloning failure
            System.out.println("Cloning failed: " + e.getMessage());
            return null;
        }
        return cloneQueue;
    }

    private E cloneElement(E element) throws CloneNotSupportedException {
        if (element instanceof Cloneable) {
            try {
                java.lang.reflect.Method cloneMethod = element.getClass().getMethod("clone");
                return (E) cloneMethod.invoke(element);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new CloneNotSupportedException("Clone method threw an exception: " + e.getCause());
            }
        } else {
            throw new CloneNotSupportedException("Element is not cloneable");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.getValue();
            current = current.getNext();
            return value;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> isContained(E value) {
            Node<E> current = this;
            while (current != null) {
                if (current.getValue().equals(value)) {
                    return current;
                }
                current = current.getNext();
            }
            return null;
        }
    }
}
