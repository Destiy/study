package java8action.chapter5.trans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
@AllArgsConstructor
public class Transaction {

    private final Trader trader;

    private final int year;

    private final int value;
}
