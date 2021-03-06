package vending.machine.test;

import com.machine.implementation.VendingMachineStateManager;
import com.machine.vo.Event;
import com.machine.vo.State;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineStateManagerTest {

    @Test
    public void test_new_VendingStateManager_READY_state() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        assertEquals(vsm.getCurrentState(),State.READY);
    }

    @Test
    public void test_READY_state_COIN_INSERTED_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ACCEPTING_COINS_state_COIN_INSERTED_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.COIN_INSERTED);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ACCEPTING_COINS_state_REFUND_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.REFUND_SELECTED);
        assertEquals(vsm.getCurrentState(), State.REFUND);
    }

    @Test
    public void test_ITEM_SELECTED_state_INSUFFICIENT_MONEY_INSERTED_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.ITEM_SELECTED);
        assertEquals(vsm.getCurrentState(), State.ITEM_SELECTED);
        vsm.onEvent(Event.INSUFFICIENT_MONEY_INSERTED);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ITEM_SELECTED_state_INSUFFICIENT_CHANGE_IN_MACHINE_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.ITEM_SELECTED);
        assertEquals(vsm.getCurrentState(), State.ITEM_SELECTED);
        vsm.onEvent(Event.INSUFFICIENT_MONEY_INSERTED);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ITEM_SELECTED_state_INVALID_ITEM_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.ITEM_SELECTED);
        assertEquals(vsm.getCurrentState(), State.ITEM_SELECTED);
        vsm.onEvent(Event.INVALID_ITEM);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ITEM_SELECTED_state_OUT_OF_STOCK_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.ITEM_SELECTED);
        assertEquals(vsm.getCurrentState(), State.ITEM_SELECTED);
        vsm.onEvent(Event.OUT_OF_STOCK);
        assertEquals(vsm.getCurrentState(), State.ACCEPTING_COINS);
    }

    @Test
    public void test_ITEM_SELECTED_state_DISPENSE_event() {
        VendingMachineStateManager vsm = new VendingMachineStateManager();
        vsm.onEvent(Event.COIN_INSERTED);
        vsm.onEvent(Event.ITEM_SELECTED);
        assertEquals(vsm.getCurrentState(),State.ITEM_SELECTED);
        vsm.onEvent(Event.DISPENSE);
        assertEquals(vsm.getCurrentState(), State.READY);
    }
}