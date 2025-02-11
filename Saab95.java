import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(boolean turboOn) {
        super(2, Color.red, 125.0, "Saab95", 0d, 0d);
        this.turboOn = turboOn;
        stopEngine();
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount) {

        if (this.getCurrentSpeed() + speedFactor() * amount >= this.getEnginePower()) {
            this.currentSpeed = this.getEnginePower();
        } else {
            this.currentSpeed = this.getCurrentSpeed() + speedFactor() * amount;
        }

    }

    public void decrementSpeed(double amount){

            this.currentSpeed = this.getCurrentSpeed() - speedFactor() * amount;
            if (this.currentSpeed < 0) {
                this.currentSpeed = 0;
            }
        }

    public void gas (double amount){

        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        } else {
            System.out.println("Gas amount has to be between 0.0 and 1.0");
        }
    }

    public void brake (double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        } else {
            System.out.println("Break amount has to be between 0.0 and 1.0");
        }
    }
}

