package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {

    //test metody getX i getY
    @Test
    public void testCoordinatesCreation(){
        Coordinates coordinates = new Coordinates(50, 70);
        Assertions.assertEquals(50, coordinates.getX());
        Assertions.assertEquals(70, coordinates.getY());
    }

    @Test
    public void testNegativePosition(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinates(-10, 50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinates(50, -10));
    }

    @Test
    public void testPositionAboveLimit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinates(110, 50));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinates(50, 110));
    }

    @Test
    public void testCopyCoordinates(){
        Coordinates coordinates1 = new Coordinates(50, 70);
        Coordinates coordinates2 = Coordinates.copy(coordinates1, 10, 20);
        Assertions.assertEquals(60, coordinates2.getX());
        Assertions.assertEquals(90, coordinates2.getY());
    }

    @Test
    public void testEqualsAndHashCode(){
        Coordinates coordinates1 = new Coordinates(50, 70);
        Coordinates coordinates2 = new Coordinates(50, 70);
        Coordinates coordinates3 = new Coordinates(60, 70);

        Assertions.assertEquals(coordinates1, coordinates2);
        Assertions.assertNotEquals(coordinates1, coordinates3);
        Assertions.assertEquals(coordinates1.hashCode(), coordinates2.hashCode());
        Assertions.assertNotEquals(coordinates1.hashCode(), coordinates3.hashCode());
    }
}
