import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static String[] dateFormats = {"MM/dd/yyyy","dd-M-yyyy","dd/MM/yyyy"};
    static String pattern ;

    static void dateFormatType(Scanner sc){
        System.out.println("choso");
        for (int i=0;i<dateFormats.length;i++){
            System.out.println((i+1)+"- "+dateFormats[i]);
        }

        int choose  = sc.nextInt();
        switch (choose){
            case 1:
                pattern = dateFormats[0];
                break;
            case 2:
                pattern = dateFormats[1];
                break;
            case 3:
                pattern = dateFormats[2];
                break;
            default:
                System.out.println("we dont have that pattern");
        }
    }
    static void askingSomeDate(Scanner sc) throws ParseException {

        System.out.println(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.now();
        String formattedString = localDate.format(formatter);
        System.out.println("Current date is = "+formattedString);

        System.out.println("enter date like this pattern "+pattern);
        String userDateString = sc.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date userDate = dateFormat.parse(userDateString);
        String strDate = dateFormat.format(userDate);
        System.out.println("user date = "+strDate);

        Date local = dateFormat.parse(formattedString);

        dateDifference(userDate,local);

    }
    static void dateDifference(Date first, Date second){
        long diffInMillies = Math.abs(second.getTime() - first.getTime());
        System.out.println("days between them is = "+diffInMillies/ (1000*60*60*24));
    }


    public static void main(String[]args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        //1.Write a program which asks user’s age and types the year of birth
        System.out.println("please enter your age");
        int userAge = sc.nextInt();
        LocalDate date = LocalDate.now();
        System.out.println("your born date is "+(date.getYear()-userAge));
        //////////////////////////////////////////////////////////////////////

        // 2. Write a program to get the dates next and previous Friday.
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
        String formattedString = localDate.format(formatter);
        System.out.println("Current date is = "+formattedString);
        String formattedNextFriday;
        for (int i =0;i<7;i++){
            formattedNextFriday = localDate.plusDays(i).format(formatter);
            if(formattedNextFriday.contains("Fri")){
                System.out.println("Next Friday date is = "+formattedNextFriday);
            }
        }
        String formattedPreviousFriday;
        for (int i =7;i>0;i--){
            formattedPreviousFriday = localDate.minusDays(i).format(formatter);
            if(formattedPreviousFriday.contains("Fri")){
                System.out.println("Previous Friday date is = "+formattedPreviousFriday);
            }
        }
        ///////////////////////////////////////////////////////////////

        //3.Write a program which asks for year and prints is the year leap or no.
        System.out.print("Enter any year:");
        int year = sc.nextInt();
        if(year % 400 == 0 || year % 100 == 0 || year % 4 == 0){
            System.out.println(year+" is a Leap Year");
        }else{
            System.out.println(year+" is not a Leap Year");
        }

        //Write a program which
        //asks a format of date
        //validates that the format is acceptable
        //asks for some date (which has the same format)
        //prints difference between now and that date
        dateFormatType(sc);
        askingSomeDate(sc);

    }
}
