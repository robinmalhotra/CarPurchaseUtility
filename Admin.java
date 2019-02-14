import java.util.Random;

class Admin {



int generatePrizes(final int custID1,final int custID2,final int custID3) {
    Random generateIds= new Random();
    int custIdKeeper[]={custId1,custId2,custID3};
    int luckyIdKeeper[]=new int[6];
    int custWonPrizes[];
    //To generate random ID numbers from existing IDs.
    for (int luckyIds=0;luckyIds<luckyIdKeeper.length();luckyIds++) {
        //need to write a code that checks if the random number is generated out of existing ID numbers.
        luckyIdKeeper[luckyIds]=generateIds.nextInt(10);
    }
    for(int luckyIdCount=0;luckyIdCount<luckyIdKeeper.length();luckyIdCount++) {
        for(int custIdCount=0;custIdCount<custIdKeeper.length(); custIdCount++) {
            if(luckyIdKeeper[luckyIdCount]=custIdKeeper[custIdCount])
                custWonPrizes[luckyIdCount]=luckyIdKeeper[luckyIdCount];
        }
    }
    return custWonPrizes;
}
public static void main(String[] args) {
    Customer ctest=new Customer();
    ctest.addCustomer();
}

}

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
