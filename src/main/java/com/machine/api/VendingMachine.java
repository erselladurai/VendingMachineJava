package com.machine.api;

import com.machine.entity.Bucket;
import com.machine.entity.Coin;
import com.machine.entity.Item;

import java.util.List;

/**
 * Decleare public API for Vending Machine * @author Selladurai Rajan
 */
public interface VendingMachine {
    public long selectItemAndGetPrice(String item);

    public void insertCoin(String coin);

    public List<Coin> refund();

    public Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();

    public long getTotal(List<Coin> change);

    public List<Coin> collectChange();

    public Inventory<Item> getItemInventory();

    public Item getCurrentItem();

    public long getCurrentBalance();

    public Inventory<Coin> getCashInventory();

    public long getTotalSales();

    public void printStats();
}
