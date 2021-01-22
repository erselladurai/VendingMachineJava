package purchase;

import base.Common;

import com.machine.entity.Item;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("VendingMachineTest")
public class PurchaseAfterCancelRequest extends Common {
    @Test
    public void testPurchaseAfterCancelCokeItemWithMorePrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelPepsiItemWithMorePrice() {
        Item product = Item.PEPSI;
        String coinsList = "PENNY:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelSodaItemWithMorePrice() {
        Item product = Item.SODA;
        String coinsList = "QUARTER:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testBuySodaItemWithExactPrice() {
        Item product = Item.SODA;
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelPepsiItemWithExactPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelCokeItemWithExactPrice() {
        Item product = Item.COKE;
        String coinsList = "QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelCokeItemWithLessPrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:PENNY:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelPepsiItemWithLessPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:PENNY:PENNY";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    public void testPurchaseAfterCancelSodaItemWithLessPrice() {
        Item product = Item.SODA;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
        validateBuyItemLessPrice(product, coinsList);
    }
}