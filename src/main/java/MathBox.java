import java.util.*;

public class MathBox {
    private Set<Number> numberSet;
    private boolean isInteger = true;
    // We don't know whether Number is a floating point number or an integer
    // Probably, we should store either array of longs or doubles
    // (given that there will be no value bigger than theirs max values)

    // TODO : AtomicInteger, AtomicLong, BigDecimal, BigInteger, Byte, Double, DoubleAccumulator, DoubleAdder, Float, Integer, Long, LongAccumulator, LongAdder, Short

    public MathBox(Number[] inputNumbers) {
        // Initializing set
        numberSet = new HashSet<>();
        // Adding elements to the collection
        for (Number num : inputNumbers){
            if (numberSet.contains(num)){
                // If collection contains repeated elements, throw an exception
                numberSet = null;
                throw new IllegalArgumentException("Collection contains repeating elements");
            }
            numberSet.add(num);
            // Checking if this number is double or float
            if (!this.checkIfInteger(num)){
                isInteger = false;
            }
        }

    }

    public Number summator(){
        Number result = null;
        if (numberSet.size() == 0)
            return null;
        for (Number num : this.numberSet){
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
        if (numberSet.size() == 0)
            return;
        if (divisor.doubleValue() == 0){
            return;
        }
        Set<Number> newNumberSet = new HashSet<>();
        for (Number num : this.numberSet){
            Number result = null;
            if (isInteger){
                result = num.longValue() / divisor.longValue();
            } else {
                result = num.doubleValue() / divisor.longValue();
            }
            newNumberSet.add(result);
            System.out.println(result);
        }
        this.numberSet = newNumberSet;
    }

    private boolean checkIfInteger(Number num){
        if (num.longValue() == num.doubleValue())
            return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != MathBox.class){
            throw new IllegalArgumentException();
        }
        return numberSet.equals(((MathBox)obj).numberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numberSet, this.isInteger);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numberSet=" + numberSet +
                ", isInteger=" + isInteger +
                '}';
    }
}
