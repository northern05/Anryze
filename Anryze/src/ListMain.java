import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {
        Collection<Integer> integers = new MyList<>();

        integers.add(1);
        integers.add(2);
        integers.add(7);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
