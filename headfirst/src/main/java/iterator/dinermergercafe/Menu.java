package iterator.dinermergercafe;

import java.util.Iterator;

/**
 * @author wy
 * @date 2020/11/11
 */
public interface Menu {

    Iterator<MenuItem> createIterator();
}
