import java.util.ArrayList;
import java.util.Collection;

public class ObjectBox {
    protected Collection<Object> objectCollection;

    public ObjectBox(){
        objectCollection = new ArrayList<>();
    }

    public ObjectBox(Collection<Object> objects){
        objectCollection = new ArrayList<>(objects);
    }

    public void addObject(Object obj){
        this.objectCollection.add(obj);
    }

    public void deleteObject(Object obj){
        if (!findObject(obj))
            throw new IllegalArgumentException("Object is not found");
        this.objectCollection.remove(obj);
    }

    private boolean findObject(Object obj){
        return this.objectCollection.contains(obj);
    }

    public String dump(){
        return this.toString();
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "objectCollection=" + objectCollection +
                '}';
    }
}
