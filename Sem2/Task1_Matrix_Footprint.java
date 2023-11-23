public class Task1_Matrix_Footprint {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > i) sum += matrix[i][i];
        }

        System.out.println(sum);
    }
}
