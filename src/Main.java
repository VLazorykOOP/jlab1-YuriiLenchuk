import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.pow;

public class Main {
    static void task1(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter x, y: ");
        double x = console.nextDouble(), y = console.nextDouble();
        double rez = x*y + (pow(x+y, 3)/(pow(x, 2) + pow(y,2)))*(x-y);
        System.out.print("Результат");
        System.out.print(rez);
        console.close();
    }
    static void task2(){
        Scanner console = new Scanner(System.in);
        ArrayList<Double> A = new ArrayList<>();
        ArrayList<Double> B = new ArrayList<>();
        System.out.print("Enter А('e' stops entering): ");
        while (true){
            String input = console.next();
            if("e".equals(input)){
                break;
            }
            else A.add(Double.parseDouble(input));
        }
        for(int i = 1; i < A.size(); i++){
            double buff = 0;
            for (int j = 0; j < i; j++){
                buff += A.get(j);
            }
            B.add(buff/(i));
        }
        System.out.print("Array A: " + A + '\n');
        System.out.print("Array B: " + B);
        console.close();
    }
    static void task3(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter n(n <= 15): ");
        int n  = console.nextInt();
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];
        int[] X = new int[n];
        System.out.print("Enter А: " + '\n');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = console.nextDouble();
            }
        }
        System.out.print("Enter B: " + '\n');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = console.nextDouble();
            }
        }
        for (int i = 0; i < n; i++){
            boolean flag = true;
            for (int j = 0; j < n; j++){
                if(A[i][j] < B[i][j]) {
                    flag = false;
                    break;
                }
            }
            X[i] = (flag) ? 1 : 0;
        }
        System.out.print(Arrays.deepToString(A));
        System.out.print('\n');
        System.out.print(Arrays.deepToString(B));
        System.out.print('\n');
        System.out.print(Arrays.toString(X));
        console.close();
    }
    static void task4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String inputText = scanner.nextLine();
        String[] words = inputText.split("[\\s\\p{Punct}]+");
        for (int i = 0; i < words.length; i++) {
            words[i] = removePreviousOccurrences(words[i]);
        }
        String resultText = String.join(" ", words);
        System.out.println("Modified text: ");
        System.out.println(resultText);
        scanner.close();
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("1 task 1" +'\n');
        System.out.print("2 task 2" +'\n');
        System.out.print("3 task 3" +'\n');
        System.out.print("4 task 4" +'\n');
        System.out.print("5 exit" +'\n');
        int n = console.nextInt();
        switch (n) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            case 5 -> {
                return;
            }
        }
        System.out.print('\n');
    }
    private static String removePreviousOccurrences(String word) {
        if (word.length() <= 1) {
            return word;
        }
        char lastChar = word.charAt(word.length() - 1);
        String previousPart = word.substring(0, word.length() - 1);
        return previousPart.replaceAll(String.valueOf(lastChar), "") + lastChar;
    }
}