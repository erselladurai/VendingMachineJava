package reset;

import base.Base;
import base.Common;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("VendingMachineTest")
public class ResetMachine extends Common {

    @Test
    @Tag("Reset")
    public void validateResetMachine(){
        vm.reset();
        ValidateReset();
    }
}
