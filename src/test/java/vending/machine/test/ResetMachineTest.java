package vending.machine.test;

import base.Base;
import base.Common;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class ResetMachineTest extends Common {

    @Test
    @Tag("Reset")
    @DisplayName("Validation of the vending machine resetting")
    public void validateResetMachine(){
        vm.reset();
        ValidateReset();
    }
}
