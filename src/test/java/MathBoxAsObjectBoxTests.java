import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;

public class MathBoxAsObjectBoxTests {
    @Test
    void testWithIntegers(){
        int[] intArray = new int[]{1, 2, 3};

        Number[] testArray = new Number[3];
        for (int i=0; i < 3; i++){
            testArray[i] = (Number)intArray[i];
        }
        MathBox mb = new MathBox(testArray);

        ObjectBox ob = mb;
        ob.deleteObject(testArray[0]);
        ob.deleteObject(testArray[1]);
        ob.deleteObject(testArray[2]);

        assertThrows(IllegalArgumentException.class, ()->{
            ob.deleteObject("abc");
        });
    }
}
