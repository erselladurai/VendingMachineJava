package vending.machine.test;

import base.Common;
import com.machine.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class PurchaseAfterCancelRequestTest extends Common {
    @Test
    @DisplayName("Validation of purchase coke item with more price")
    public void testPurchaseAfterCancelCokeItemWithMorePrice() {
        String product = "COKE";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with more price")
    public void testPurchaseAfterCancelPepsiItemWithMorePrice() {
        String product = "PEPSI";
        String coinsList = "PENNY:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with more price")
    public void testPurchaseAfterCancelSodaItemWithMorePrice() {
        String product = "SODA";
        String coinsList = "QUARTER:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with exact price")
    public void testBuySodaItemWithExactPrice() {
        String product = "SODA";
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with exact price")
    public void testPurchaseAfterCancelPepsiItemWithExactPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase coke item with exact price")
    public void testPurchaseAfterCancelCokeItemWithExactPrice() {
        String product = "COKE";
        String coinsList = "QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase coke item with less price")
    public void testPurchaseAfterCancelCokeItemWithLessPrice() {
        String product = "COKE";
        String coinsList = "DIME:PENNY:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase pepsi item with less price")
    public void testPurchaseAfterCancelPepsiItemWithLessPrice() {
        String product = "PEPSI";
        String coinsList = "DIME:PENNY:PENNY";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    @DisplayName("Validation of purchase soda item with less price")
    public void testPurchaseAfterCancelSodaItemWithLessPrice() {
        String product = "SODA";
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }
}