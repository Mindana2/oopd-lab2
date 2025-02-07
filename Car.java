import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Car implements Movable {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName;

    private double xPos;
    private double yPos;

    private final List<String> dirs = Arrays.asList("up", "right", "down", "left");

    private int dirsIndex;

    public Car(int nrDoors, Color color, Double enginePower, String modelName, Double xPos, Double yPos) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.dirsIndex = 0;

        stopEngine();
    }

    public String getModelName() {
        return this.modelName;
    }


    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
    }

    public String getDirection() {
       return dirs.get((((this.dirsIndex % 4) + 4) % 4));
    }

    public double getxPos() {
        return this.xPos;
    }

    public double getyPos() {
        return this.yPos;
    }


    public void move() {

        String direction = this.getDirection();

        if (Objects.equals(direction, "up")) {
            //if direction == "up"
            this.yPos += this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "right")) {
            this.xPos += this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "down")) {
            this.yPos -= this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "left")) {
            this.xPos -= this.getCurrentSpeed();
        }


    }


    public void turnLeft() {
        this.dirsIndex -= 1;
    }

    public void turnRight() {
        this.dirsIndex += 1;
    }

}



