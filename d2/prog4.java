package d2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class prog4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String result = sc.nextLine();
        if (result.trim().isEmpty()){
            sc.close();
            throw new InputMismatchException("Пустые строки вводить нельзя");
        }
        sc.close();
        System.out.println(result);
    }    
}
