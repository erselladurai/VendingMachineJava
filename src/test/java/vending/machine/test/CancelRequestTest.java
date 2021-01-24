package vending.machine.test;

import base.Common;
import com.machine.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class CancelRequestTest extends Common {

    @Test
    @DisplayName("Validation of cancel coke item with more price")
    public void testCancelCokeItemWithMorePrice() {
        String product = "COKE";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);;
    }

    @Test
    @DisplayName("Validation of cancel pepsi item with more price")
    public void testCancelPepsiItemWithMorePrice() {
        String product = "PEPSI";
        String coinsList = "PENNY:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel soda item with more price")
    public void testCancelSodaItemWithMorePrice() {
        String product = "SODA";
        String coinsList = "QUARTER:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel Soda item with exact price")
    public void testCancelBuySodaItemWithExactPrice() {
        String product = "SODA";
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel pepsi item with exact price")
    public void testCancelBuyPepsiItemWithExactPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel coke item with exact price")
    public void testCancelCokeItemWithExactPrice() {
        String product = "COKE";
        String coinsList = "QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel coke item with less price")
    public void testCancelCokeItemWithLessPrice() {
        String product = "COKE";
        String coinsList = "DIME:PENNY:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel pepsi item with less price")
    public void testCancelPepsiItemWithLessPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:PENNY:PENNY";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    @DisplayName("Validation of cancel soda item with less price")
    public void testCancelSodaItemWithLessPrice() {
        String product = "SODA";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }
}