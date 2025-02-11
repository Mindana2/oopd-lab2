import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.black, 100.0, "Volvo240", 0d, 0d);
        stopEngine();

    }


    private double speedFactor() {
        return this.getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
        if (currentSpeed > this.getEnginePower()) {
            currentSpeed = this.getEnginePower();
        }
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
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
}
