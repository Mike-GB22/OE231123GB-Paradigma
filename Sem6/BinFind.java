import java.util.Arrays;

//2023/12/21
public class BinFind {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,99,88,77,66,55,44,33,22,11,0};

        SortedArrayWithElementNumber<Integer> arrClass = new SortedArrayWithElementNumber<Integer>(arr);
        System.out.println(arrClass);

        arrClass.findElementAndPrint(1);
        arrClass.findElementAndPrint(2);
        arrClass.findElementAndPrint(3);
        arrClass.findElementAndPrint(99);
        arrClass.findElementAndPrint(88);
        arrClass.findElementAndPrint(77);
        arrClass.findElementAndPrint(66);
        arrClass.findElementAndPrint(55);
        arrClass.findElementAndPrint(44);
        arrClass.findElementAndPrint(33);
        arrClass.findElementAndPrint(22);
        arrClass.findElementAndPrint(11);
        arrClass.findElementAndPrint(0);
        arrClass.findElementAndPrint(-1);
        arrClass.findElementAndPrint(100);

      }
}

class SortedArrayWithElementNumber<T extends Number & Comparable>{
    T[] arrOrigin;
    T[] arrSorted;
    int[] oldNumberOfElement;
    int sizeOfArray;

    SortedArrayWithElementNumber (T[] arr){
        this.arrOrigin = arr;
        this.initialisation();
        this.sortArray();
    }

    private void initialisation(){
        sizeOfArray = arrOrigin.length;
        Object[] tmpArrSort = new Number[sizeOfArray];
        arrSorted = (T[]) tmpArrSort;
        oldNumberOfElement = new int[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++){
            oldNumberOfElement[i] = i;
            arrSorted[i] = arrOrigin[i];
        }
    }
    private void sortArray(){
        for(int i = 0; i < sizeOfArray; i++){
            for(int j = 0; j < sizeOfArray - i - 1; j++){

                if(arrSorted[j].compareTo(arrSorted[j+1]) > 0){
                    T tmp = arrSorted[j];
                    arrSorted[j] = arrSorted[j+1];
                    arrSorted[j+1] = tmp;

                    int tmpIndex = oldNumberOfElement[j];
                    oldNumberOfElement[j] = oldNumberOfElement[j+1];
                    oldNumberOfElement[j+1] = tmpIndex;
                }
            }
        }
    }

    public void findElementAndPrint(T element){
        String resultString;
        int result = findElement(element);
        if (result < 0) resultString = "not found";
            else resultString = "index: [" + result + "]";
        System.out.println(" - We are looking for: [" + element.toString() + "] is " + resultString);
    }
    public int findElement(T element){
        int result = findElementInSortedArray(element);
        if(result < 0) return  result;
        return oldNumberOfElement[result];

    }

    private int findElementInSortedArray(T element){
        return findElementInSortedArray(element, 0, sizeOfArray - 1);
    }

    private int findElementInSortedArray(T element, int begin, int end){
        if (begin > end) begin = end;
        int size = end - begin;
        int half = (size + 1)/ 2 + begin;
        //System.out.printf("\n -- begin: %d, end: %d => half: %d", begin, end, half);
        //System.out.print(". We have: " + this.arrSorted[half].toString() + ", we are looking for: " + element.toString());


        if (size == 0) {
            if(this.arrSorted[begin].equals(element)) return begin;
            return -1;
        }
        else if(this.arrSorted[half].equals(element)){
            return half;
        }
        else if(this.arrSorted[half].compareTo(element) < 0)
            return findElementInSortedArray(element, half + 1, end);
        else return findElementInSortedArray(element, begin, half - 1);
    }

    @Override
    public String toString() {
        StringBuilder stringToReturn = new StringBuilder();
        stringToReturn.append("Original Array: ");
            stringToReturn.append(Arrays.toString(arrOrigin));
        stringToReturn.append("\nSorted   Array: ");
            stringToReturn.append(Arrays.toString(arrSorted));
        stringToReturn.append("\nIndex in Array: ");
            stringToReturn.append(Arrays.toString(oldNumberOfElement));
        stringToReturn.append("\nSize  of Array: ");
            stringToReturn.append(sizeOfArray);
        return stringToReturn.toString();
    }


}