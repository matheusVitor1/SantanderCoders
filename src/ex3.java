import java.util.Arrays;

public class ex3 {
    public static int[] sortAscending(int[] numbers) {
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Troca os números de posição
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return numbers;
    }

    public static int[] sortDescending(int[] numbers) {

        int n = numbers.length;
        int[] sortedNumbers = new int[n];        
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            sortedNumbers[index] = numbers[i];
            index++;
        }

        return sortedNumbers;
    }
    

    public static void main(String[] args) {
        int[] numbers = {5, 4, 1, 2, 3};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(sortAscending(numbers)));
        System.out.println(Arrays.toString(sortDescending(sortAscending(numbers))));
    }
}
