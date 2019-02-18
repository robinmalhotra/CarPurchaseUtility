import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

class Admin extends Customer {
    //Global ArrayList to hold all the current Customers.
    static public ArrayList<Customer> mCustomerList=new ArrayList<>();
    //Global integer that takes Admin's commands.
    static public int adminChoice;

    //Makes an object of type Admin with a Customer List.
    Admin(ArrayList<Customer> getCustomerList) {
        mCustomerList=getCustomerList;
    }
    //Makes an object of type Admin with empty Customer List.
    Admin() {
        mCustomerList=new ArrayList<>();
    }

    // Function to add a Customer to ArrayList that takes @params: Customer
    //.@returns: ArrayList of type Customer
    void addCustomerToList(final Customer thisCustomer) { //remove the previous/same customer if already there.
        Customer holdCustomer=thisCustomer;
        holdCustomer=addCustomer();
        mCustomerList.add(thisCustomer);
    }//addCustomerToList ends

    //Lists(Prints) Customer's Name and their Cars sorted by their name.
    void showCustomerAndCar (ArrayList<Customer> THIS_CUSTOMER_LIST) {
        //sort the Customer List based on their  First names.
        ArrayList<Customer> sortedCustomerList=THIS_CUSTOMER_LIST;//sortCustomerOnNames(THIS_CUSTOMER_LIST);
        Collections.sort(sortedCustomerList, new SortByFirstName());

        Car hisCar;
        for (Customer getCustomer: sortedCustomerList) {
            System.out.println("Name of Customer: "+giveFirstNameOfCustomer(getCustomer)
                    +" "+giveLastNameOfCustomer(getCustomer));
            //Container of type Car List to hold the Car ArrayList of a particular Customer.
            ArrayList<Car> hisCarsList=new ArrayList<>();
            hisCarsList=giveCarsForCustomer(getCustomer);

            for(int j=0;j<hisCarsList.size();j++) {
                hisCar=hisCarsList.get(j);
                    hisCar.showCar();
            } //j ends
        }//i ends
    }// showCustomerAndCar ends

    //Finds the Customer based on the @returns: Customer ID and Customer List's current state.
    void searchCustomerAndId (final ArrayList<Customer> thisCustomerList,final int thisCustomerId) {

        for (int i=0;i<thisCustomerList.size();i++) {

            if(thisCustomerId==giveCustomerId(thisCustomerList.get(i))) {

                System.out.println("Customer ID: "+giveCustomerId(thisCustomerList.get(i)));
                System.out.println("First Name of Customer: "+
                        giveFirstNameOfCustomer(thisCustomerList.get(i))+
                                "Last Name of Customer: "+giveLastNameOfCustomer(thisCustomerList.get(i)));

                }//if ends

        }//i ends

    }// showCustomerAndId ends.

    //returns: void Method that adds the Car to Customer's Car List by taking @params: Global Customer List.
    void addCarToCustomer(final ArrayList<Customer> THIS_CUSTOMER_LIST) {

        ArrayList<Customer> holdCustomerList=THIS_CUSTOMER_LIST;
        ArrayList<Car> hisCarList=new ArrayList<>();
        Customer holdCustomer=new Customer();
        Scanner sc=new Scanner(System.in);
        //Print the List of Customer Available.
        System.out.println("List of Customers available are: ");

        for (int i=0;i<holdCustomerList.size();i++) {
            //print Customer's IDs and their Names.
            System.out.println("Customer ID: "+
                    giveCustomerId(holdCustomerList.get(i))+
                            "Name of Customer: " +
                                    giveFirstNameOfCustomer(holdCustomerList.get(i))+
                                            " "+giveLastNameOfCustomer(holdCustomerList.get(i)));
        }//for loop ends.

        //Find the Customer with specified Customer ID to add the Car.
        System.out.println("Enter the Id of Customer for whom you want to add the car: ");
        int thisCustomerId=sc.nextInt();
        boolean isNumber=true;
        do {

            if(sc.hasNextInt()) {
                System.out.println("Enter your choice:");
                thisCustomerId=sc.nextInt();
                isNumber=true;
            } else {
                  System.out.println("Not a valid User Input, please try again: ");
                  isNumber=false;
                  sc.next();
            }
        }while(!isNumber);
        //find the Customer with the specified ID from the Customer ArrayList.
        for (Customer thisCustomer: holdCustomerList) {

            if(thisCustomerId==giveCustomerId(thisCustomer)) {
                //Hold this Customer's Car ArrayList to print his current Cars.
                System.out.println("Customer Name is: "+
                        giveFirstNameOfCustomer(thisCustomer)+
                                " "+giveLastNameOfCustomer(thisCustomer));
                hisCarList=giveCarsForCustomer(thisCustomer);
                //Hold the Customer to work in manupulating his Car list.
                holdCustomer=thisCustomer;
            }//if ends

        }//for loop ends.

        //Print Customer's Car List.
        showCarList(hisCarList);

        //Check to add more Cars to this Customer.
        System.out.print("How many cars do you want to add ");
        System.out.println("for Customer "+
                giveFirstNameOfCustomer(holdCustomer)+
                        " "+giveLastNameOfCustomer(holdCustomer)+"?: ");
        int carCount=sc.nextInt();
        //Update Customer's Car List.
        hisCarList=manipulateCarList(hisCarList,carCount);

    }//addCarToCustomer ends.

    //Generate Prizes based on 3 IDs that are injected as @params: ArrayList of type Integer.
    //@returns: ArrayList of type Integer that has the IDs of Winners.
    ArrayList<Integer> generatePrizes(final ArrayList<Integer> CUSTOMER_IDS) {

        ArrayList<Integer> customerIds=CUSTOMER_IDS;
        Random generateIds= new Random();
        //Create a new ArrayList to hold the IDs.
        ArrayList<Integer> custIdKeeper=new ArrayList<>();
        //Add the three IDs to the ArrayList custIdKeeper.
        custIdKeeper.add(customerIds.get(0));
        custIdKeeper.add(customerIds.get(1));
        custIdKeeper.add(customerIds.get(2));
        //Create an ArrayList to save the randomly generated IDs.
        ArrayList<Integer> luckyId= new ArrayList<>(10);
        //ArrayList to save the winners.
        ArrayList<Integer> custWonPrizes=new ArrayList<>();
        //To generate random ID numbers from existing IDs.
        for(int numberOfIds=0;numberOfIds<6;numberOfIds++) {
              luckyId.add((int)(1+Math.random()*10));
        }
        System.out.println("Winner List generated was: ");
        //Print the randomly generated Ids just to see.
        for(int numberOfIds=0;numberOfIds<6;numberOfIds++) {
                System.out.println(luckyId.get(numberOfIds));
        }//for ends
        //Find the match between the random IDs and the entered IDs.
        for(Integer idOnCust: custIdKeeper) {
            for(Integer idOnLuckId: luckyId) {
              if(idOnCust.equals(idOnLuckId))
                    custWonPrizes.add(idOnLuckId);
        }//for custIdCount ends
        }//for luckyIdCount ends

        return custWonPrizes;
    }//generate prize ends.

    //To Create different Admins with differential commands. @return: void.
    void createAdminPowers() {
        boolean condition=true;
        Scanner sc=new Scanner(System.in);
        System.out.println("Car Purchase Utility");
        System.out.println("****************You are in the Admin Panel***************");


        System.out.println("You can perform following tasks");
        System.out.print("1: Add new Customer\n2: Add new Car to an existing Customer\n");
        System.out.print("3: List all Customers with their cars sorted by name\n");
        System.out.print("4: List individual Customer based on ID\n");
        System.out.print("5: Generate prizes for the customer.\n");
        System.out.print("6: Print Admin Panel again.\n");
        System.out.print("7: Exit: \n");
        System.out.print("******************************************************** \n");
        System.out.println("Enter your choice:");

        boolean isNumber;
        do {
            if(sc.hasNextInt()) {

                adminChoice=sc.nextInt();
                isNumber=true;
            } else {
                  System.out.println("Not a valid User Input, please try again: ");
                  isNumber=false;
                  sc.next();
            }
        }while(!isNumber);

        //get this all to Dispatcher(switch).
        do {
            switch(adminChoice) {
            //To Add a Customer in an existing Customer ArrayList.
                case 1:
                System.out.println("How many Customers do you want to add? ");
                int customerCount=sc.nextInt();
                for(int i=0;i<customerCount;i++) {
                      Customer createCustomer;
                      createCustomer=addCustomer();
                      mCustomerList.add(createCustomer);
                }//for loop ends
                System.out.println(customerCount+" Customer created and added to the List.");
                System.out.println("Enter your choice from Admin Panel");
                break;

                //To add new Car to an Existing Customer.
                case 2:
                addCarToCustomer(mCustomerList);
                System.out.println("Enter your choice from Admin Panel");
                break;

                //To List all Customers with their Cars Sorted by Name.
                case 3:
                showCustomerAndCar(mCustomerList);
                System.out.println("Enter your choice from Admin Panel");
                break;

                case 4:
                System.out.println("Enter the Customer ID to check the name and availability: ");
                int custId=sc.nextInt();
                searchCustomerAndId(mCustomerList,custId);
                System.out.println("Enter your choice from Admin Panel");
                break;

                case 5:

                System.out.println("Enter any three Customer IDs from the available IDs");
                System.out.println("Available IDs are:");
                for (Customer thisCustomer: mCustomerList) {
                    System.out.println(giveCustomerId(thisCustomer));
                }
                System.out.println("Enter 3 IDs for prizes");
                System.out.println("Enter First ID:");
                int custIdChoice1=sc.nextInt();
                System.out.println("Enter Second ID:");
                int custIdChoice2=sc.nextInt();
                System.out.println("Enter Third ID:");
                int custIdChoice3=sc.nextInt();
                ArrayList<Integer> custIdChoice=new ArrayList<>();
                custIdChoice.add(custIdChoice1);
                custIdChoice.add(custIdChoice2);
                custIdChoice.add(custIdChoice3);
                ArrayList<Integer> luckyIds=generatePrizes(custIdChoice);
                System.out.println("Winners are:");
                for(Integer winners: luckyIds) {
                    System.out.println(winners);
                }
                System.out.println("Enter your choice from Admin Panel");
                break;

                case 6:
                System.out.println("You can perform following tasks");
                System.out.print("1: Add new Customer\n2: Add new Car to an existing Customer\n");
                System.out.print("3: List all Customers with their cars sorted by name\n");
                System.out.print("4: List individual Customer based on ID\n");
                System.out.print("5: Generate prizes for the customer.\n");
                System.out.print("6: Print Admin Panel again.\n");
                System.out.print("7: Exit: \n");
                System.out.print("************************* \n");
                System.out.println("Enter your choice:");
                break;

                case 7:
                condition=false;
                System.out.println("Press 7 again to exit.");
                break;

                default:
                System.out.println("Option not available");

            }//switch ends
            //take the choice of admin again to send in the next iteration of do while loop.
            do {
                if(sc.hasNextInt()) {
                    System.out.println("Enter your choice:");
                    adminChoice=sc.nextInt();
                    isNumber=true;
                } else {
                      System.out.println("Not a valid User Input, please try again: ");
                      isNumber=false;
                      sc.next();
                }
            }while(!isNumber);
        }while(condition);//while condition ends.

    }//createAdminPowers function ends.

    //Comparator class to sort the Array List based on the name of the Customer.
    class SortByFirstName implements Comparator<Customer> {
        public int compare(Customer a, Customer b) {
            return ((giveFirstNameOfCustomer(a)).compareTo(giveFirstNameOfCustomer(b)));
        }
    }//Comparator class ends.

}//class Admin ends



/* * Add new Customer,
* Add new Car to an existing Customer,
* List all Customers with their cars sorted by name,
* List individual Customer based on ID,
* Generate prizes for the customer(Explained Below).

Prizes :
Your application will generate 6 random but existing IDs of customers. Admin will enter 3 IDs.
The IDs matching with the randomly generate IDs, will get a prize. For example :
Lets say will have customers with following IDs - 2,5,1,7,8,9,10,12,15,13
Your system picks 6 IDs randomly say - 8,9,15,13,5,2
Admins enters 3 IDs 20,16,9
So only the customer with ID 9 will be eligible for the prize.

*/
