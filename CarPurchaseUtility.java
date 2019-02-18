import java.util.ArrayList;
import java.util.Scanner;


class CarPurchaseUtility extends Admin {
    //Make constant variable for password pre-defined.
    static protected final int mPASSWORD=12345;
    //main method
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        //A check is made to make the admin login only if he knows the password.
        System.out.println("Enter the password to login:");
        int password=1;
        int holdpassword=1;
        boolean isNumber;
        do {
            if(sc.hasNextInt()) {

                holdpassword=sc.nextInt();
                if(holdpassword==12345)
                    isNumber=true;
                else {
                    isNumber=false;
                    System.out.println("Wrong Password, try again.");
                }
            } else {
                  System.out.println("Wrong Password, try again.");
                  isNumber=false;
                  sc.next();
            }
        }while(!isNumber);

        password=holdpassword;

        if(password==mPASSWORD) {
            System.out.println("You are logged in as ADMIN");
            Admin adminCreated=new Admin();
            //To Create different Admins with differential commands.
            adminCreated.createAdminPowers();
        }

}

}
