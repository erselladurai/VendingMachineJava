package base;

import com.machine.api.VendingMachine;
import com.machine.implementation.VendingMachineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base  {
    public VendingMachine vm;

    @BeforeEach
    public void setUp() {
        vm = VendingMachineFactory.createVendingMachine();
    }

    @BeforeEach
    public void tearDown() {
        vm = null;
    }
}
