abstract class Car {
    private int mCarId;
    private int mYear;
    private float mPrice;
    private String mModel;

    abstract float computeResale(final float takeprice);
    abstract void showCar();
    abstract Car addCar();

    public void setCar(final int CAR_ID, final int YEAR, final float PRICE, final String MODEL) {
        mCarId=CAR_ID;
        mYear=YEAR;
        mPrice=PRICE;
        mModel=MODEL;
    }
    void getCar() {
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
