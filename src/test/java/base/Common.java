package base;

import com.machine.entity.Bucket;
import com.machine.entity.Coin;
import com.machine.entity.Item;
import com.machine.exception.NotFullPaidException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Common extends Base {

    public void validateSelectItemAndPrice(String product){
        long price = vm.selectItemAndGetPrice(product);
        assertEquals(Item.valueOf(product).getPrice(), price);
    }

    public void insertCoins(String coinsList){
        Arrays.stream(coinsList.split(":")).forEach(a -> vm.insertCoin(a));
    }

    public Bucket<Item, List<Coin>> collectAndValidateItem(Item product){
        Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        Item item = bucket.getFirst();
        List<Coin> change = bucket.getSecond();

        //should be Coke
        assertEquals(product, item);

        return bucket;
    }

    public void validateChangeisNotEmpty(List<Coin> change){
        assertFalse(change.isEmpty());
    }

    public void validateChangeisEmpty(List<Coin> change){
        assertTrue(change.isEmpty());
    }

    public void validateChange(List<Coin> change, Item product, String coinsList){
        int total = Arrays.stream(coinsList.split(":")).map(c -> Coin.valueOf(c).getDenomination()).mapToInt(Integer::intValue).sum();

        //comparing change
        assertEquals(total - product.getPrice(), vm.getTotal(change));
    }

    public void validateNotFullPaidError(){
        Throwable exception = assertThrows(NotFullPaidException.class, () -> {
            Bucket<Item, List<Coin>> bucket = vm.collectItemAndChange();
        });
        assertEquals(exception.getClass(), NotFullPaidException.class);
    }

    public void validateBuyItemMorePrice(String product, String coinsList){
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        Bucket<Item, List<Coin>> bucket = collectAndValidateItem(Item.valueOf(product));
        validateChangeisNotEmpty(bucket.getSecond());
        validateChange(bucket.getSecond(),Item.valueOf(product),coinsList);
    }

    public void validateBuyItemExactPrice(String product, String coinsList){
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        Bucket<Item, List<Coin>> bucket = collectAndValidateItem(Item.valueOf(product));
        validateChangeisEmpty(bucket.getSecond());
    }

    public void validateBuyItemLessPrice(String product, String coinsList){
        validateSelectItemAndPrice(product);
        insertCoins(coinsList);
        validateNotFullPaidError();
    }

    public void validateCancelRequest(String coinsList){
        int total = Arrays.stream(coinsList.split(":")).map(c -> Coin.valueOf(c).getDenomination()).mapToInt(Integer::intValue).sum();
        assertEquals(total, vm.getTotal(vm.refund()));
    }

    public void ValidateReset(){
        assertEquals(0, vm.getTotalSales(), "Total sales is not 0");
        assertEquals(0, vm.getCurrentBalance(), "Current balance is not 0");
        assertNull(vm.getCurrentItem(), "Current Item is not cleared");
        assertEquals(0, vm.getItemInventory().getItemTotal(), "Item Inventory is not cleared");
        assertEquals(0, vm.getCashInventory().getItemTotal(), "Cash Inventory is not cleared");
    }
}
