package purchase;

import base.Common;
import com.machine.entity.Bucket;
import com.machine.entity.Coin;
import com.machine.entity.Item;
import com.machine.exception.NotFullPaidException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("VendingMachineTest")
public class Purchase extends Common {

    @ParameterizedTest
    @CsvSource({
            "COKE, PENNY:NICKLE:DIME:QUARTER",
            "COKE, NICKLE:DIME:QUARTER",
            "COKE, DIME:QUARTER",
            "COKE, NICKLE:QUARTER"
    })
    public void testBuyItemWithMorePrice(Item product, String coinsList) {
       validateBuyItemMorePrice(product, coinsList);
    }

    @ParameterizedTest
    @CsvSource({
            "COKE, QUARTER",
            "COKE, NICKLE:DIME:DIME",
            "COKE, NICKLE:NICKLE:NICKLE:NICKLE:PENNY:PENNY:PENNY:PENNY:PENNY"
    })
    public void testBuyItemWithExactPrice(Item product, String coinsList) {
        validateBuyItemExactPrice(product, coinsList);
    }

    @ParameterizedTest
    @CsvSource({
            "COKE, PENNY:NICKLE:DIME"
    })
    public void testBuyItemWithLessPrice(Item product, String coinsList) {
        validateBuyItemLessPrice(product, coinsList);
    }
}
