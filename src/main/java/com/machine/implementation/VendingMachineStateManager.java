package com.machine.implementation;

import com.machine.exception.InvalidStateTransitionException;
import com.machine.vo.Event;
import com.machine.vo.State;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineStateManager {
    private final Map<State, Map<Event, State>> transitionMap = new HashMap<>();

    private State currentState;

    public VendingMachineStateManager() {
        Map<Event, State> readyTransitionMap = new HashMap<>();
        readyTransitionMap.put(Event.COIN_INSERTED, State.ACCEPTING_COINS);
        readyTransitionMap.put(Event.LOAD_ITEM, State.READY);
        readyTransitionMap.put(Event.WRONG_ITEM, State.READY);
        transitionMap.put(State.READY, readyTransitionMap);

        Map<Event, State> acceptingTransitionMap = new HashMap<>();
        acceptingTransitionMap.put(Event.ITEM_SELECTED, State.ITEM_SELECTED);
        acceptingTransitionMap.put(Event.REFUND_SELECTED, State.REFUND);
        acceptingTransitionMap.put(Event.INVALID_COIN, State.ACCEPTING_COINS);
        acceptingTransitionMap.put(Event.INVALID_ITEM, State.ACCEPTING_COINS);
        acceptingTransitionMap.put(Event.COIN_INSERTED, State.ACCEPTING_COINS);
        transitionMap.put(State.ACCEPTING_COINS, acceptingTransitionMap);

        Map<Event, State> itemTransitionMap = new HashMap<>();
        itemTransitionMap.put(Event.OUT_OF_STOCK, State.ACCEPTING_COINS);
        itemTransitionMap.put(Event.INSUFFICIENT_MONEY_INSERTED, State.ACCEPTING_COINS);
        itemTransitionMap.put(Event.DISPENSE, State.READY);
        itemTransitionMap.put(Event.INSUFFICIENT_CHANGE_IN_MACHINE, State.ACCEPTING_COINS);
        itemTransitionMap.put(Event.INVALID_ITEM, State.ACCEPTING_COINS);
        transitionMap.put(State.ITEM_SELECTED, itemTransitionMap);

        currentState = State.READY;
    }

    public State onEvent(Event input) {
        Map<Event, State> eventMap = transitionMap.get(currentState);
        State nextState = null;
        if (eventMap != null) {
            nextState = eventMap.get(input);
        }

        if (nextState == null) {
            throw new InvalidStateTransitionException(String.format("Invalid state on Input State %s Event %s", currentState, input));
        }
        currentState = nextState;
        return nextState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
