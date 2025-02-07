import java.awt.*;


    public Volvo240() {
        stopEngine();

    }


    }

    public void incrementSpeed(double amount) {
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount){
            incrementSpeed(amount);
        }

    public void brake(double amount) {
            decrementSpeed(amount);
    }
}
