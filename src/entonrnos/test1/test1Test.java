package entonrnos.test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class test1Test {

    @Test
    public void esPrimo() {
        test1 tp = new test1();
        assertTrue(tp.EsPrimo(7));
    }
    @Test
    public void esPrimo2() {
        test1 tp = new test1();
        assertFalse(tp.EsPrimo(8));
    }


}