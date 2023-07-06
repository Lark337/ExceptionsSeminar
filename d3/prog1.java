package d3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prog1 {
    public static void main(String[] args) {
        String firstName = " ";
        String lastName = " ";
        String middleName = " ";
        String number = " ";
        String dateOfBirth = " ";
        String gender = " ";
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите данные через пробел: Фамилия, Имя, Отчество, Дата рождения, Номер телефона, пол");
    String note = sc.nextLine();
    sc.close();
    ArrayList<String> list1 = new ArrayList<>(Arrays.asList(note.split(" ")));
    if (list1.size() != 6){
        System.out.println("Введенно неверное колличество данных");
        throw new IllegalArgumentException();
    }    

    Pattern pat1 = Pattern.compile("(^[mf]$)"); // пол
    Pattern pat2 = Pattern.compile("(\\D{2,})"); // ФИО
    Pattern pat3 = Pattern.compile("(0[1-9]|[1-9]|1[0-9]|2[0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(\\d{4,4})"); // Дата рождения
    Pattern pat4 = Pattern.compile("\\d{11}"); // телефон
    Integer count = 0;
    Matcher m = null;
    for (String cur : list1) {
        m = pat2.matcher(cur);
        
        if(m.matches()){
            if (count == 0){
                lastName = cur;
            }
            if(count == 1){
                firstName = cur;
            }
            if(count == 2){
                middleName = cur;
            }
            count++;
        };
    }
    

    if (count < 3){
        System.out.println("Введенны неверные данные: ФИО");
        throw new IllegalArgumentException();
    }


    number = findArg(pat4, list1);

    if (number == " "){
        System.out.println("Введенны неверные данные: Телефон");
        throw new IllegalArgumentException();
    }

    dateOfBirth = findArg(pat3, list1);

    System.out.println("Дата рождения:" + dateOfBirth);

    if (dateOfBirth == " "){                                                                             // исправить
        System.out.println("Введенны неверные данные: Дата рождения\nФормат должен быть таким:dd:mm:yyyy");
        throw new IllegalArgumentException();
    }

    gender = findArg(pat1, list1);

    if (gender == " "){
        System.out.println("Введенны неверные данные: Пол");
        throw new IllegalArgumentException();
    }

    String path = String.format("d3/Files/%s.txt", lastName);

    if(!new File(path).exists()){
            try{File file = new File(path);
                file.createNewFile();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        

    try (BufferedWriter fWr = new BufferedWriter(new FileWriter(path, true))) {
        fWr.append(String.format("<%s><%s><%s><%s><%s><%s>\n", lastName, firstName, middleName, dateOfBirth, number, gender));
        
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("mid" + middleName);

    }

    public static String findArg(Pattern pat, ArrayList<String> t){
        for (String cur : t){   
            Matcher m = pat.matcher(cur);
            if(m.matches()){
                return cur;
            } 
        }
        return " ";
    }

    

}


