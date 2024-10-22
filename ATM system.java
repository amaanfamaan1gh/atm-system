import java.util.Scanner;

public class AtmSystem
{
    static int pin = 3214;
    static double accountBalnace = 10000;
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("plesse enter your pin");
        if (sc.hasNextInt())
        {
            int userPin =sc.nextInt();
            if (userPin == pin)
            {
                System.out.println("you entered a valid pin");
                System.out.println("please enter you amount to witdraw");
                if (sc.hasNextInt()) 
                {
                    int amount = sc.nextInt();
                    if (amount <= accountBalnace)
                    {
                        double remainingBalance =accountBalnace - amount;
                        System.out.println("please collect your money");
                        System.out.println("remaining balance ="+remainingBalance);

                    }
                } 
                else
                {
                    System.out.println("plese enter a vaid amount");
                }          

            }
            else
            {
                System.out.println("your pin is not matched");
            
            }
        }
        
    }
}