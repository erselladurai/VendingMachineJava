package purchase;

import base.Common;
import com.machine.entity.Item;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("VendingMachineTest")
public class CancelRequestTest extends Common {

    @Test
    public void testCancelCokeItemWithMorePrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);;
    }

    @Test
    public void testCancelPepsiItemWithMorePrice() {
        Item product = Item.PEPSI;
        String coinsList = "PENNY:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelSodaItemWithMorePrice() {
        Item product = Item.SODA;
        String coinsList = "QUARTER:DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelBuySodaItemWithExactPrice() {
        Item product = Item.SODA;
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelBuyPepsiItemWithExactPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelCokeItemWithExactPrice() {
        Item product = Item.COKE;
        String coinsList = "QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelCokeItemWithLessPrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:PENNY:NICKLE";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelPepsiItemWithLessPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:PENNY:PENNY";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }

    @Test
    public void testCancelSodaItemWithLessPrice() {
        Item product = Item.SODA;
        String coinsList = "DIME:QUARTER";
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateCancelRequest(coinsList);
    }
}