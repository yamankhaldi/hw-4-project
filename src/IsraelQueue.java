import java.util.Iterator;
import java.util.NoSuchElementException;
public class IsraeliQueue<E>  implements Iterable<E>
{
    private Node<E> head;
    private Node<E> tail ;
    private int  size;

    public IsraeliQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;


    }

    public void add(E element, E friend) {
        try {
            if (element == null) {
                throw new InvalidInputException("Element cannot be null");
            }

            if (head == null) {
                Node<E> newNode = new Node<E>(element);
                head = tail = newNode;
            } else {
                Node<E> current = head;
                while (current != null) {
                    if (current.getValue().equals(friend)) {
                        addAfterFriend(current, element);
                        break;
                    }
                    current = current.getNext();
                }

                size++;
            }
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    public int returnSize(){
        return size;
    }
}

