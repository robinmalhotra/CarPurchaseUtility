import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private int mCustomerId;
    private String mCustomerFirstName;
    private String mCustomerLastName;
    private ArrayList<Car> mCustomerCarList;

    //Constructs a Customer with empty values.
    Customer () {
        mCustomerId=0;
        mCustomerFirstName="";
        mCustomerLastName="";
        ArrayList<Car> emptyCarList= new ArrayList<>();
        mCustomerCarList=emptyCarList;
    }
    //Constructs a Customer with Specified values with @params: First Name, Last Name, Cars of Customer.
    Customer(int mCustId, String mCustFirstName, String mCustLastName, ArrayList<Car> carsOfCustomer) {
        mCustomerId=mCustId;
        mCustomerFirstName=mCustFirstName;
        mCustomerLastName=mCustLastName;
        mCustomerCarList=carsOfCustomer;
    }
    //@returns: void type method to show the Cars of Customer that takes @params: Customer's Cars List.
    void showCarList(final ArrayList<Car> GET_CAR_LIST) {
        ArrayList<Car> holdCarList=GET_CAR_LIST;
        for(Car hisCars: holdCarList) {
            hisCars.showCar();
        }

    }
    //Manipulates the Car List by taking @params: Car List of the Customer and a Count of Cars to add.
    //Updates the Car List based on new Cars and @returns: updated Car List.
    ArrayList<Car> manipulateCarList(final ArrayList<Car> hisCarlist, final int carCount) {

        ArrayList<Car> holdList=hisCarlist;
        //If no Car is being added.
        if (carCount==0) {
            System.out.println("No Cars being added!");
            return holdList;
        }//if ends
        int count=0;
        //ArrayList<Car> holdList=new ArrayList<>();
        Scanner getCarsforList=new Scanner(System.in);
        do {
            System.out.println("Add Cars for this Customer: ");
            System.out.println("List of Cars available");
            System.out.println("'1' for Hyundai");
            //Hyundai newHyundai;
            System.out.println("'2' for Maruti");
            //Maruti newMaruti;
            System.out.println("'3' for Toyota");
            //Toyota newToyota;
            Car newCar;
            int carChoice=getCarsforList.nextInt();
            switch(carChoice) {
                //Add a Hyundai Car.
                case 1: Hyundai hyundaiCar= new Hyundai();
                        newCar=hyundaiCar.addCar();
                        //hyundaiCar=addCar;
                        holdList.add(newCar);
                        break;
                //Add a Maruti Car.
                case 2: Maruti marutiCar=new Maruti();
                        newCar=marutiCar.addCar();
                        holdList.add(newCar);
                        break;
                //Add a Toyota Car.
                case 3: Toyota toyotaCar=new Toyota();
                        newCar=toyotaCar.addCar();
                        holdList.add(newCar);
                        break;

                default:System.out.println("This option is not available");
            }// switch ends
            count++;
        }while(count<carCount);//do while ends.

        return holdList;
    }//manipulateCarList Method ends.


    //@returns the First name of Customer with type String.
    String giveFirstNameOfCustomer (Customer thisCustomer) {
        return thisCustomer.mCustomerFirstName;
    }
    //@returns: the Last name of Customer with type String.
    String giveLastNameOfCustomer (Customer thisCustomer) {
        return thisCustomer.mCustomerLastName;
    }
    //@returns: the ID of the customer with type Integer.
    int giveCustomerId (Customer thisCustomer) {
        return thisCustomer.mCustomerId;
    }
    //Based on @params: Customer, it @returns the Car List of the Customer.
    ArrayList<Car> giveCarsForCustomer(Customer thisCustomer) {
        ArrayList<Car> returnCarList=new ArrayList<>();
        Customer holdCustomer=thisCustomer;
        returnCarList=holdCustomer.mCustomerCarList;
        return returnCarList;
    }

    //Method to give Customer based on Customer ID by taking @params: Customer List and Customer ID.
    //@returns: Customer.
    Customer giveCustomerforCustomerId(final ArrayList<Customer> thisCustomerList, final int thisCustomerId) {
        ArrayList<Customer> holdCustomerList=thisCustomerList;

        int returnId;
        for(int i=0;i<holdCustomerList.size();i++) {
            if(thisCustomerId==giveCustomerId(holdCustomerList.get(i))) {
                return holdCustomerList.get(i);
            }//if ends.
        }//for ends
        //returns empty customer if no Customer is found.
        return new Customer();
    }
    //Function to add Customer. @return Customer.
    Customer addCustomer() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> carsOfCustomer=new ArrayList<>();
        System.out.println("Enter the ID of Customer(Must be a Unique ID between 1 to 10): ");
        int mCustId=sc.nextInt();
        System.out.println("Enter the First name of Customer: ");
        String mCustFirstName=sc.next();
        System.out.println("Enter the Last name of Customer: ");
        String mCustLastName=sc.next();
        System.out.println("How many cars do you want to add?: ");
        int carCount=sc.nextInt();
        //createCarList(carCount);
        carsOfCustomer=manipulateCarList(carsOfCustomer,carCount);
        Customer customerCreated=new Customer(mCustId,mCustFirstName,mCustLastName,carsOfCustomer);
        //  System.out.println("Customer Created");
        return customerCreated;
    }//addCustomer method ends.

}//Customer class ends




/* * This application is controlled by the admin who will manage customers along with their purchased cars.
* Customer will have an ID, name, and list of purchased Cars
* Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
/* * Add new Customer,
* Add new Car to an existing Customer,
* List all Customers with their cars sorted by name,
* List individual Customer based on ID,
* Generate prizes for the customer(Explained Below). */
