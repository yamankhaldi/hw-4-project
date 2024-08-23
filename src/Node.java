import java.lang.reflect.InvocationTargetException;

public class Node<E> implements Cloneable{
    private E value;
    private Node<E> next;
    public Node(E value, Node<E> next) {
        this.value= value;this.next= next;
    }
    public Node(E value) {
        this(value, null);
    }

    public E getValue() {
        return value;
    }

    public Node<E> getNext() {

        return next;
    }

    public void setValue(E value) {
        this.value= value;
    }

    public void setNext(Node<E> next) {
        this.next= next;
    }

 public Node<E> isContained(E other){
        if (this.value.equals(other))
            return this;
        if (this.next == null)
            return null;
        return next.isContained(other);
    }

    public int returnCountFriends(Node<E> personNode) {
        if (personNode != null && personNode.getValue() instanceof Person) {
            Person person = (Person) personNode.getValue();
            return person.getFriendCounter();

        }
        return 0;
    }

    public void incrementFriendCounterInPerson(Node<E> personNode) {
        if (personNode != null && personNode.getValue() instanceof Person) {
            Person person = (Person) personNode.getValue();
            person.incraementCounter();
        }
    }
    @Override
    public Node<E> clone() {
        try {
            Node<E> clonedNode = (Node<E>) super.clone();
            if (this.next != null) {
                clonedNode.next = this.next.clone();
            }
            if (this.value instanceof Cloneable) {
                java.lang.reflect.Method cloneMethod = this.value.getClass().getMethod("clone");
                clonedNode.value = (E) cloneMethod.invoke(this.value);
            } else {
                clonedNode.value = this.value;
            }
            return clonedNode;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}


