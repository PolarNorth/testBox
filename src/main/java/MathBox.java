import java.util.*;

public class MathBox extends ObjectBox {
    private boolean isInteger = true;
    // We don't know whether Number is a floating point number or an integer
    // Probably, we should store either array of longs or doubles
    // (given that there will be no value bigger than theirs max values)

    // TODO : AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, DoubleAccumulator, DoubleAdder, Float, Integer, Long, LongAccumulator, LongAdder, Short

    public MathBox(Number[] inputNumbers) {
        // Initializing set
        this.objectCollection = new HashSet<>();
        // Adding elements to the collection
        for (Number num : inputNumbers){
            if (objectCollection.contains(num)){
                // If collection contains repeated elements, throw an exception
                objectCollection = null;
                throw new IllegalArgumentException("Collection contains repeating elements");
            }
            objectCollection.add(num);
            // Checking if this number is double or float
            if (!this.checkIfInteger(num)){
                isInteger = false;
            }
        }

    }

    public Number summator(){
        Number result = null;
        if (objectCollection.size() == 0)
            return null;
        for (java.lang.Object objNum : this.objectCollection){
            Number num = (Number)objNum;
            if (result == null){
                result = num;
                continue;
            }
            if (isInteger){
                long temp = result.longValue();
                result = temp + num.longValue();
            } else {
                double temp = result.doubleValue();
                result = temp + num.doubleValue();
            }
        }
        return result;
    }

    public void splitter(Number divisor){
        if (objectCollection.size() == 0)
            return;
        if (divisor.doubleValue() == 0){
            return;
        }
        Set<java.lang.Object> newNumberSet = new HashSet<>();
        for (java.lang.Object objNum : this.objectCollection){
            Number num = (Number)objNum;
            Number result = null;
            if (isInteger){
                result = num.longValue() / divisor.longValue();
            } else {
                result = num.doubleValue() / divisor.longValue();
            }
            newNumberSet.add(result);
        }
        this.objectCollection = newNumberSet;
    }

    private boolean checkIfInteger(Number num){
        if (num.longValue() == num.doubleValue())
            return true;
        return false;
    }

    public boolean equals(Object obj) {
        if (obj.getClass() != MathBox.class){
            throw new IllegalArgumentException();
        }
        return objectCollection.equals(((MathBox)obj).objectCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.objectCollection, this.isInteger);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "objectCollection=" + objectCollection +
                ", isInteger=" + isInteger +
                '}';
    }

    public void addObject(Object obj){
        throw new IllegalArgumentException("Can't add object to MathBox");
    }

    private boolean findObject(Object obj){
        Number num = (Number)obj;
        return this.objectCollection.contains(obj);
    }
}
