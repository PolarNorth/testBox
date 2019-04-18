import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;

public class MathBoxTests {

    @Test
    void testWithIntegers(){
        int[] intArray = new int[]{1, 2, 3};

        Number[] testArray = new Number[3];
        for (int i=0; i < 3; i++){
            testArray[i] = (Number)intArray[i];
        }
        MathBox mb = new MathBox(testArray);
        assertEquals(6, mb.summator().intValue());
        mb.splitter(2);
        // The case here, that if initial array contained integers, integer divion is applied
        assertEquals(1, mb.summator().intValue());
    }

    @Test
    void testWithDoubles(){
        double[] intArray = new double[]{1.0, 2.0, 3.0};

        Number[] testArray = new Number[3];
        for (int i=0; i < 3; i++){
            testArray[i] = (Number)intArray[i];
        }
        MathBox mb = new MathBox(testArray);
        assertEquals(6.0, mb.summator().doubleValue());
        mb.splitter(2);
        assertEquals(3.0, mb.summator().doubleValue());
    }

    @Test
    void testObjectMethods(){
        int[] intArray = new int[]{1, 2, 3};
        MathBox mb, mbEqual;

        Number[] testArray = new Number[3];
        for (int i=0; i < 3; i++){
            testArray[i] = (Number)intArray[i];
        }

        mb = new MathBox(testArray);

        int[] newIntArray = new int[]{1, 2, 3};
        testArray = new Number[3];
        for (int i=0; i < 3; i++){
            testArray[i] = (Number)intArray[i];
        }

        mbEqual = new MathBox(testArray);

        // Testing hashCode
        assertEquals(mb.hashCode(), mbEqual.hashCode());
        // Testing Equals
        assertEquals(mb, mbEqual);
        // Testint toString
        assertNotNull(mb.toString());
    }

}
