package d2;

import java.util.Scanner;

public class prog1 {
    public static void main(String[] args) {
        System.out.println("Введенное число: " + fn());
    }

    public static float fn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        String s = sc.nextLine();
        while (!isFloat(s)) {
            System.out.println("Введите значение типа float");
            s = sc.nextLine();
        }
        Float result = Float.parseFloat(s);
        sc.close();
        return result;

}

public static boolean isFloat(String s){
            try {
                Float.parseFloat(s);
                return true;
            } catch (NumberFormatException e) {
                System.out.println("kek");
                return false;
            }
        }
}


