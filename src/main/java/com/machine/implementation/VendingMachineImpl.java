package com.machine.implementation;

import com.machine.api.Inventory;
import com.machine.api.VendingMachine;
import com.machine.entity.Bucket;
import com.machine.entity.Coin;
import com.machine.entity.Item;
import com.machine.exception.*;
import utils.PropertyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Sample implementation of Vending Machine in Java
 *
 * @author Selladurai Rajan
 */
public class VendingMachineImpl implements VendingMachine {
    private final Inventory<Coin> cashInventory = new Inventory<Coin>();
    private final Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    private void initialize() {
        //initialize machine with coins of each denomination (Number of coins decided from config)
        //and each com.machine.entity.Item (Number of items from each category decided from config)
        for (Coin c : Coin.values()) {
            cashInventory.put(c, Integer.parseInt(Objects.requireNonNull(PropertyUtils.getProperty("NumberOfCoins"))));
        }

        for (Item i : Item.values()) {
            itemInventory.put(i, Integer.parseInt(Objects.requireNonNull(PropertyUtils.getProperty("NumberOfItems"))));
        }

    }

    @Override
    public long selectItemAndGetPrice(String item) {
        try{
            if (itemInventory.hasItem(Item.valueOf(item))) {
                currentItem = Item.valueOf(item);
                return currentItem.getPrice();
            }
            throw new SoldOutException("Sold Out, Please buy another item");
        }
        catch (IllegalArgumentException e)
        {
            throw new InvalidItemException("Invalid Item");
        }
    }

    @Override
    public long getTotal(List<Coin> change) {
        long total = 0;
        for (Coin c : change) {
            total = total + c.getDenomination();
        }
        return total;
    }

    @Override
    public void insertCoin(String coin) {
        try{
            currentBalance = currentBalance + Coin.valueOf(coin).getDenomination();
            cashInventory.add(Coin.valueOf(coin));
        }
        catch (IllegalArgumentException e){
         throw new InvalidCoinException("Invalid Coin");
        }
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();

        List<Coin> change = collectChange();

        return new Bucket<Item, List<Coin>>(item, change);
    }

    private Item collectItem() throws NotSufficientChangeException,
            NotFullPaidException {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in com.machine.api.Inventory");

        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ",
                remainingBalance);
    }

    @Override
    public List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    private boolean isFullPaid() {
        return currentBalance >= currentItem.getPrice();
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.EMPTY_LIST;
        if (amount > 0) {
            changes = new ArrayList<Coin>();
            long balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                } else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                } else if (balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();
                } else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                } else {
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }
        return changes;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    @Override
    public void printStats() {
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current com.machine.entity.Item com.machine.api.Inventory : " + itemInventory);
        System.out.println("Current Cash com.machine.api.Inventory : " + cashInventory);
    }

    @Override
    public Inventory<Item> getItemInventory() {
        return itemInventory;
    }

    @Override
    public Item getCurrentItem() {
        return currentItem;
    }

    @Override
    public long getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public Inventory<Coin> getCashInventory() {
        return cashInventory;
    }


    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }

        return hasChange;
    }

    private void updateCashInventory(List<Coin> change) {
        for (Coin c : change) {
            cashInventory.deduct(c);
        }
    }

    @Override
    public long getTotalSales() {
        return totalSales;
    }

}