package d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * prog1
 */
public class prog1 {

    public static void main(String[] args) {       
        //System.out.println(nArr(10));
        //System.out.println(sumN(nArr(4)));
        System.out.println(divideN(nArr(3)));    
    }
    public static Integer nArr(Integer n) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(10,20,30,40,null));
        System.out.println(arr1.toString());
        Integer res;
        try {
            res = arr1.get(n);
            return res;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс вне границ массива");
            throw e;
        }
        }
    public static Integer sumN(Integer n) {
        Integer sum;
        try {
            sum = n + 10;
            return sum;
        }
         catch (NullPointerException e) {
            System.out.println("Null значение");
            throw e;
        }
    }
    public static Integer divideN(Integer n1) {
        try {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Введите на какое число разделить");
            Integer n2 = sc1.nextInt();
            return n1/n2;
        } catch (ArithmeticException e) {
            System.out.println("Деление на 0");
            throw e;
        } catch(NullPointerException e){
            System.out.println("Null значение n");
            throw e;
        } catch (InputMismatchException e){
            System.out.println("Введенное значение не тип Integer");
            throw e;
        }
         
        
    }

}