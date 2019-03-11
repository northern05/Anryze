import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<E> implements Collection<E> {
    private class Node {
        private Node next;
        private E data;

        public Node(Node next, E data) {
            this.next = next;
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int numberElements;

    public MyList() {
        first = null;
        last = null;
        numberElements = 0;
    }



    @Override
    public boolean add (E data){
        boolean result;
        int previousNumberElements = numberElements;
        if (data == null) {throw new NullPointerException("Data is null");}
        if (!isEmpty()){
            Node previous = last;
            last = new Node (null, data);
            previous.next =last;
        }
        else {
            last = new Node(null, data);
            first = last;
        }
        numberElements++;
        if (previousNumberElements < numberElements){
            result = true;
        }
        else result = false;
        return result;
    }

    @Override
    public int size() {
        return numberElements;
    }

    @Override
    public boolean isEmpty() {
        return numberElements == 0;
    }



    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    @Override
    public boolean remove(Object data) {
        if (isEmpty()){throw new IllegalStateException("Can`t delete from empty list");}
        boolean result = false;
        Node previous = first;
        Node current = last;
        while (current.next != null || current == last){
            if (current.data.equals(data)){
                if (numberElements == 1) {
                    first = null;
                    last =null;
                }
                else if (current.equals(first)) {
                    first = first.next;

                }
                else if (current.equals(last)) {
                    last = previous;
                    last.next = null;
                }
                else {
                    previous.next = current.next;
                }
                numberElements--;
                result = true;
                break;
            }
            previous = current;
            current = previous.next;
        }
        return result;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        numberElements = 0;
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private class MyListIterator implements Iterator<E> {
        private Node current = first;

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }

        public boolean hasNext() {
            return current != null;
        }
    }

    @Override
    public String toString() {
        return "MyList{" +
                "first=" + first +
                ", last=" + last +
                ", numberElements=" + numberElements +
                '}';
    }
}
