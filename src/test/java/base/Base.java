package base;

import com.machine.api.VendingMachine;
import com.machine.implementation.VendingMachineFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base {
    public VendingMachine vm;

    @BeforeAll
    public void setUp() {
        vm = VendingMachineFactory.createVendingMachine();
    }

    @AfterAll
    public void tearDown() {
        vm = null;
    }
}
