import java.awt.*;



        stopEngine();
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

        double turbo = 1;
        if (turboOn) turbo = 1.3;
    }

    public void incrementSpeed(double amount) {
    }

    public void decrementSpeed(double amount){
        }

    public void gas (double amount){
            incrementSpeed(amount);
    }

    public void brake (double amount){
            decrementSpeed(amount);
        }
    }
