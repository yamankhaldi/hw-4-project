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
        if (element == null) {
            throw new InvalidInputException();
        }

        Node<E> newNode = new Node<>(element);

        if (head == null) {
            head = tail = newNode;
        } else {
            Node<E> friendNode = head.isContained(friend);
            if (friendNode != null) {
                friendNode.incrementFriendCounterInPerson(friendNode);
                int friendCount = friendNode.returnCountFriends(friendNode);
                Node<E> current = friendNode;
                for (int i = 1; i < friendCount; i++) {
                    if (current.getNext() != null ) {
                        current = current.getNext();
                    }
                }
                addAfterFriend(current, newNode);
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
            throw new EmptyQueueException();
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
            throw new EmptyQueueException();
        }
        return head.getValue();
    }

    public int returnSize() {
        return size;
    }

    @Override
    public IsraeliQueue<E> clone() {
        IsraeliQueue<E> clonedQueue = new IsraeliQueue<>();
        try {
            Node<E> current = head;
            while (current != null) {
                E element = current.getValue();
                if (!(element instanceof Cloneable)) {
                    return null;
                }
                E clonedElement = cloneElement(element);
                if (clonedElement == null) {
                    return null;
                }

                clonedQueue.add(clonedElement);
                current = current.getNext();
            }
        } catch (Exception e) {
            return null;
        }
        return clonedQueue;
    }

    private E cloneElement(E element) {
        try {
            return (E) element.getClass().getMethod("clone").invoke(element);
        } catch (Exception e) {
            return null;
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
}