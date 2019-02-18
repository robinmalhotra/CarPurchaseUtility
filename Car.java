abstract class Car {
    private int mCarId;
    private int mYear;
    private float mPrice;
    private String mModel;

    //Computes the Resale value of a Car(Hyundai, Maruti, Toyota)
    abstract float computeResale(final float takeprice);
    //Show/Print the Car.
    abstract void showCar();
    //Adds the Car.
    abstract Car addCar();
    //Set method to make the instance of Car. @return type: giveCustomerId
    //@params: Car ID, Car Year, Car Price, Car Model.
    public void setCar(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
        mCarId=CAR_ID;
        mYear=YEAR;
        mPrice=PRICE;
        mModel=MODEL;
    }
    //Method to see the details of the car.
    public void getCar() {
        System.out.println("Car Id = " + mCarId);
        System.out.println("Year = " + mYear);
        System.out.println("Price = " + mPrice);
        System.out.println("Model = " + mModel);

    }

}

/*
 *Car will have an ID, model (Eg: I20 for Hyundai), price, resale value.
* Cars can be of three types ONLY - Toyota, Maruti, Hyundai.
* Resale values for different types of car will be different i.e 80% X price,60% X price, 40% X price resp.
*/
