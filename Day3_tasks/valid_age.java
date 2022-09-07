import java.util.Scanner;

public class valid_age
{
    
    public static void main(String[] args) {
        final int MIN_AGE = 16;
        Scanner scan = new Scanner(System.in);
        System.out.println("Driving license valid age check(2 wheeler)");
        System.out.print("Enter your age:");
        int age = scan.nextInt();

        if(age>0)
        {
            
            if(age>=MIN_AGE)
                System.out.println("[OK] you can apply for license");
            else
                System.out.println("[NO] you can\'t apply license for ["+(MIN_AGE-age)+"] year(s)");
        }
        else
        {
            System.out.println("[ERROR] wrong input");
        }
        scan.close();
    }
   
}