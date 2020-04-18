package java8action.chapter5.trans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@AllArgsConstructor
public class Trader {

    private final String name;

    private final String city;
}
