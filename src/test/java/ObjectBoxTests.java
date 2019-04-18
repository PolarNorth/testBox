import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ObjectBoxTests {

    @Test
    void testAddAndDelete(){
        ObjectBox objectBox;
        ObjectBox tempObjectBox = new ObjectBox();

        ArrayList <Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add("ABC");
        objects.add(tempObjectBox);

        objectBox = new ObjectBox(objects);

        // Adding element
        objectBox.addObject(3);
        // Deleting elements
        objectBox.deleteObject(2);
        objectBox.deleteObject(1);
        objectBox.deleteObject("ABC");
        objectBox.deleteObject(tempObjectBox);
        // Deleting not added object
        assertThrows(IllegalArgumentException.class, () -> {
            objectBox.deleteObject("DEF");
        });
    }
}
