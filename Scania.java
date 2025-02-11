import java.awt.*;

public class Scania extends Truck {

    private double tipperAngle;

    public Scania(double tipperAngle) {
        super(2, Color.red, 100.0, "Scania", 0d, 0d);
        stopEngine();
        this.tipperAngle = tipperAngle;
    }

    public double getTipperAngle() {
        return this.tipperAngle;
    }

    public void setTipperAngle(double angle){

        if (0.0 <= angle && angle <= 70.0 && this.getCurrentSpeed() == 0) {
            this.tipperAngle = angle;

        } else {
                System.out.println("Scania must be standing still to adjust tipper");
        }
        if (angle < 0) {
            this.tipperAngle = 0;
        }

        if (angle > 70) {
            this.tipperAngle = 70;
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
    public void move () {
        if (this.tipperAngle == 0) {
            super.move();
        }
        else {
            System.out.println("Tipper angle must be 0.0 before moving");
        }
        }
    }


