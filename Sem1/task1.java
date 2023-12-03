//2023/12/03
import java.lang.reflect.Array;
import java.util.ArrayList;

public class task1{
    public static <T extends Number> ArrayList<T> sortListImperativ(ArrayList<T> array){
        ArrayList<T> returnArray = new ArrayList(array);
        if(returnArray.size() < 2) return returnArray;

        for(int i = 0; i < returnArray.size(); i++){
            for(int j = 0; j < returnArray.size() - 1 - i; j++){
                T first = returnArray.get(j);
                T second = returnArray.get(j + 1);
                if ((Integer) first > (Integer) second){
                    returnArray.set(j, second);
                    returnArray.set(j + 1, first);
                }
            }
        }
        return returnArray;
    }
   
}
