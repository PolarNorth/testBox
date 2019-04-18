import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ObjectBox {
    private List<Object> objectList;

    public ObjectBox(){
        objectList = new ArrayList<>();
    }

    public ObjectBox(Collection<Object> objects){
        objectList = new ArrayList<>(objects);
    }

    public void addObject(Object obj){
        this.objectList.add(obj);
    }

    public void deleteObject(Object obj){
        if (!findObject(obj))
            throw new IllegalArgumentException("Object is not found");
        this.objectList.remove(obj);
    }

    private boolean findObject(Object obj){
        return this.objectList.contains(obj);
    }
}
