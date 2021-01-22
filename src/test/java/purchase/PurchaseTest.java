package purchase;

import base.Common;
import com.machine.entity.Item;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class PurchaseTest extends Common {

    @Test
    public void testCokeItemWithMorePrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testPepsiItemWithMorePrice() {
        Item product = Item.PEPSI;
        String coinsList = "PENNY:DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testSodaItemWithMorePrice() {
        Item product = Item.SODA;
        String coinsList = "QUARTER:DIME:QUARTER";
        validateBuyItemMorePrice(product, coinsList);
    }

    @Test
    public void testBuySodaItemWithExactPrice() {
        Item product = Item.SODA;
        String coinsList = "NICKLE:DIME:QUARTER:NICKLE";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testBuyPepsiItemWithExactPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:QUARTER";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testBuyCokeItemWithExactPrice() {
        Item product = Item.COKE;
        String coinsList = "QUARTER";
        validateBuyItemExactPrice(product, coinsList);
    }

    @Test
    public void testBuyCokeItemWithLessPrice() {
        Item product = Item.COKE;
        String coinsList = "DIME:PENNY:NICKLE";
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    public void testBuyPepsiItemWithLessPrice() {
        Item product = Item.PEPSI;
        String coinsList = "DIME:PENNY:PENNY";
        validateBuyItemLessPrice(product, coinsList);
    }

    @Test
    public void testBuySodaItemWithLessPrice() {
        Item product = Item.SODA;
        String coinsList = "DIME:QUARTER";
        validateBuyItemLessPrice(product, coinsList);
    }
}
