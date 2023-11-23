//2023/11/23 Таблица умножения
public class DZ_Multiplication {
    public static void main(String[] args) {
        for (int i = 1; i < 13; i++){
            System.out.println("Table for " + i);
            for (int j = 1; j < 13; j++){
                System.out.println(i + " x " + j + " = " + i*j);
            }
            System.out.println();
        }
    }
}
