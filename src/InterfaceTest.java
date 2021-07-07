import sun.java2d.pipe.SpanIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @data 2021-01-19 23:29
 */
public class InterfaceTest {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        ArrayList<Long> longs = new ArrayList<>();
//        list.trimto
        longs.trimToSize();
        System.out.println(list.getClass());
        System.out.println(longs.getClass());

    }
}
