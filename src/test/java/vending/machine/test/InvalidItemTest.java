package vending.machine.test;

import base.Common;
import com.machine.exception.InvalidItemException;
import com.machine.exception.SoldOutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PropertyUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InvalidItemTest extends Common {

    @Test
    @DisplayName("Validation of Invalid Item Exception")
    public void testInvalidItemTest(){
        Throwable exception = assertThrows(InvalidItemException.class, () ->{
            String product = "INVALID";
            String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
            validateBuyItemExactPrice(product, coinsList);
        });
        assertEquals(exception.getClass(), InvalidItemException.class);
    }
}
