package vending.machine.test;

import base.Common;
import com.machine.entity.Bucket;
import com.machine.entity.Coin;
import com.machine.entity.Item;
import com.machine.exception.NotFullPaidException;
import com.machine.exception.SoldOutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.PropertyUtils;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("VendingMachineTest")
public class ItemOutofStockTest extends Common {
        @Test
        @DisplayName("Validation of Item out of stock")
        public void testItemOutOfstock(){
            int itemcount = Integer.parseInt(Objects.requireNonNull(PropertyUtils.getProperty("NumberOfItems")));
            Throwable exception = assertThrows(SoldOutException.class, () ->{
                for(int i=1; i<=itemcount + 1; i++){
                            String product = "SODA";
                            String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
                            validateBuyItemExactPrice(product, coinsList);
                        }
                    });
            assertEquals(exception.getClass(), SoldOutException.class);

        }
}