import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = new Integer[]{10, 8, 9, 7, 6, 5, 3, 4, 1, 2};
        //list = Collections.addAll(Arrays.asList(array));
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        System.out.println("Original  : " + list);
        System.out.println("Imperativ : " + task1.sortListImperativ(list));
        System.out.println("Declarotiv: " + task2.softListDeclarative(list));
    }
}
