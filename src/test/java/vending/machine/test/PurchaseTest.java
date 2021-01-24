package vending.machine.test;

import base.Common;
import com.machine.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class PurchaseTest extends Common {

    @Test
    @DisplayName("Validation of purchase coke item with more price")
    public void testCokeItemWithMorePrice() {
        String product = "COKE";
        String coinsList = "DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with more price")
    public void testPepsiItemWithMorePrice() {
        String product = "PEPSI";
        String coinsList = "PENNY:DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with more price")
    public void testSodaItemWithMorePrice() {
        String product = "SODA";
        String coinsList = "QUARTER:DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with exact price")
    public void testBuySodaItemWithExactPrice() {
        String product = "SODA";
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with exact price")
    public void testBuyPepsiItemWithExactPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:QUARTER";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase coke item with exact price")
    public void testBuyCokeItemWithExactPrice() {
        String product = "COKE";
        String coinsList = "QUARTER";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase coke item with less price")
    public void testBuyCokeItemWithLessPrice() {
        String product = "COKE";
        String coinsList = "DIME:PENNY:NICKLE";
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with less price")
    public void testBuyPepsiItemWithLessPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:PENNY:PENNY";
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with less price")
    public void testBuySodaItemWithLessPrice() {
        String product = "SODA";
        String coinsList = "DIME:QUARTER";
        validateBuyItemLessPrice(product, coinsList);
    }
}
