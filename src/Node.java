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
@Override
    public Node<E> clone() {
        try {
            Node<E> clonedNode = (Node<E>) super.clone();
            if (this.next != null) {
                clonedNode.next = this.next.clone();
            }
            return clonedNode;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}

