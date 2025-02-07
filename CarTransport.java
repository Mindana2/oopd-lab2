import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class CarTransport extends Car {

    private boolean rampDown;
    private Car[] slotList;
    private int numSlots;


    public CarTransport(boolean rampDown, int numSlots) {
        super(2, Color.black, 100.0, "Car Transport", 0d, 0d, false);
        stopEngine();
        this.rampDown = rampDown;
        this.slotList = new Car[numSlots];

    }

    public int getNumSlots(){
        return this.numSlots;
    }

    public Car[] getSlotList(){
        return this.slotList;
    }

    public void lowerRamp() {

        if (this.getCurrentSpeed() == 0) {
            this.rampDown = true;
        }

        else{
            System.out.println("Car Transport must be standing still to lower ramp");
        }

    }

    public void raiseRamp() {
        if (this.getCurrentSpeed() == 0) {
            this.rampDown = false;
        }
        else {
            System.out.println("Car Transport must be standing still to raise ramp");
        }
    }
    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + 10 * amount, this.getEnginePower());
        if (currentSpeed > this.getEnginePower()) {
            currentSpeed = this.getEnginePower();
        }
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() -10 * amount, 0);
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }


    public void gas(double amount){

        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }

        else {
            System.out.println("Gas amount has to be between 0.0 and 1.0");
        }
    }

    public void brake(double amount) {

        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            System.out.println("Break amount has to be between 0.0 and 1.0");
        }
    }

    public void move() {
        if (!this.rampDown) {
            super.move();

            for (int i = 0; i < this.slotList.length; i++) {
                if (this.slotList[i] != null) {
                    this.slotList[i].setxPos(this.getxPos());
                    this.slotList[i].setyPos(this.getyPos());
                }
            }
        }

        else {
            System.out.println("Ramp must be up before moving");
        }

    }


    public void loadCar(Car car){

        if (!car.isLoadable()){
            System.out.println(car.getModelName() + " is not Loadable");
        }

        if (Math.abs(car.getxPos() - this.getxPos()) >= 1 || Math.abs(car.getyPos() - this.getyPos()) >= 1){
            System.out.println("Car is too far");
        }

        if (this.rampDown && car.isLoadable() && Math.abs(car.getxPos() - this.getxPos()) < 1 && Math.abs(car.getyPos() - this.getyPos()) < 1){
            for (int i = 0; i < this.slotList.length; i++){
                if (this.slotList[i] == null){
                    this.slotList[i] = car;
                    System.out.println("loaded");
                    return;

                }

            }



        System.out.println("Car Transport is full");
        }

        if(!this.rampDown){
            System.out.println("Ramp must be down to load car");

        }
    }

    public void unloadCar(){
        if (this.rampDown){
            for (int i = this.slotList.length-1; i >= 0; i--){
                if (this.slotList[i] != null){
                    this.slotList[i].setxPos(this.slotList[i].getxPos()+i);
                    this.slotList[i] = null;

                    System.out.println("unloaded");
                    return;

                }
            }

            System.out.println("Car Transport is empty");
        }

        else {
            System.out.println("Ramp must be down to unload car");

        }


    }

}
