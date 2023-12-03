//2023/12/03
import java.util.ArrayList;
import java.util.Comparator;

public class task2 {
    public static <T extends Number> ArrayList<T> softListDeclarative(ArrayList<T> array){
        ArrayList<T> returnArray = new ArrayList<>(array);
        Comparator<? super T> comparator = new ComparatorT();
        returnArray.sort(comparator);
        return returnArray;
    }
}

class ComparatorT implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        if(o1.equals(o2)) return 0;
        if((Integer) o1 < (Integer) o2) return -1;
        return 1;
    }
}
