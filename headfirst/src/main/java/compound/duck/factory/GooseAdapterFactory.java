package compound.duck.factory;

import compound.duck.Quackable;
import compound.duck.adapter.Goose;
import compound.duck.adapter.GooseAdapter;

/**
 * @author wy
 * @date 2020/11/19
 */
public class GooseAdapterFactory {

    private Quackable createGooseAdapter(){
        return new GooseAdapter(new Goose());
    }
}
