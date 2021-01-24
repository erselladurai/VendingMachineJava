package vending.machine.test;

import base.Common;
import com.machine.exception.InvalidCoinException;
import com.machine.exception.InvalidItemException;
import com.machine.exception.SoldOutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PropertyUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidCoinTest extends Common {

    @Test
    @DisplayName("Validation of Invalid Coin Exception")
    public void testInvalidCoinTest(){
        Throwable exception = assertThrows(InvalidCoinException.class, () ->{
            String product = "COKE";
            String coinsList = "INVALID:DIME:QUARTER:NICKLE";
            validateBuyItemExactPrice(product, coinsList);
        });
        assertEquals(exception.getClass(), InvalidCoinException.class);
    }
}
