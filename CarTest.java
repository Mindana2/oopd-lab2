import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class CarTest {

    Car carTest = new Car(8, Color.green, 150.0, "carTest", 0d, 0d);
    Saab95 saab95 = new Saab95(false);
    @Test
    void getNrDoors() {
        assertEquals(8, carTest.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(150.0, carTest.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        carTest.startEngine();
        carTest.stopEngine();
        assertEquals(0, carTest.getCurrentSpeed());

    }

    @Test
    void getColor() {assertSame(Color.green, carTest.getColor());}

    @Test
    void setColor() {
        carTest.setColor(Color.red);
        assertSame(Color.red, carTest.getColor());
    }

    @Test
    void startEngine() {
        carTest.startEngine();
        assertEquals(0.1d, carTest.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        carTest.startEngine();
        carTest.stopEngine();
        assertEquals(0, carTest.getCurrentSpeed());
    }

    @Test
    void getDirection() {
        assertEquals("up", carTest.getDirection());
        carTest.turnLeft();
        assertEquals("left", carTest.getDirection());
    }


    @Test
    void getxPos() {
        assertEquals(0.0d, carTest.getxPos());
    }

    @Test
    void getyPos() {
        assertEquals(0.0d, carTest.getyPos());
    }

    @Test
    void move() {
        carTest.move();
        assertEquals(0.0d, carTest.getyPos());
        carTest.startEngine();
        carTest.move();
        assertEquals(0.1d, carTest.getyPos());
    }

    @Test
    void turnLeft() {
        assertEquals("up", carTest.getDirection());
        carTest.turnLeft();
        assertEquals("left", carTest.getDirection());
    }

    @Test
    void turnRight() {
        assertEquals("up", carTest.getDirection());
        carTest.turnRight();
        assertEquals("right", carTest.getDirection());
    }

    @Test
    void gasInRange() {
        saab95.gas(0);
        saab95.gas(1);
        saab95.gas(2);
        saab95.gas(-1);

    }
    @Test
    void currentSpeedInRange() {
        saab95.incrementSpeed(200);
        assertEquals(saab95.getEnginePower(), saab95.getCurrentSpeed());
        saab95.decrementSpeed(300);
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    void gasMakesBigger() {
        double before = saab95.getCurrentSpeed();
        saab95.gas(1);
        double after = saab95.getCurrentSpeed();
        assertTrue(before < after);
    }

    @Test
    void breakMakesSmaller() {
        saab95.gas(1);
        double before = saab95.getCurrentSpeed();
        saab95.brake(1);
        double after = saab95.getCurrentSpeed();
        assertTrue(before > after);
    }

}