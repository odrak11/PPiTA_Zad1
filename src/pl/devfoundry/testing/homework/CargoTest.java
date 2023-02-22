package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CargoTest {

    //test metody getWeight
    @Test
    public void testCargoCreation(){
        Cargo cargo = new Cargo("Books", 20);

        Assertions.assertEquals(20, cargo.getWeight());
    }

    //test sprawdzenia równości
    @Test
    public void testCargoEquality(){
        Cargo cargo1 = new Cargo("Books", 20);
        Cargo cargo2 = new Cargo("Books", 20);
        Cargo cargo3 = new Cargo("Laptops", 20);

        Assertions.assertEquals(cargo1, cargo2);
        Assertions.assertNotEquals(cargo1, cargo3);
    }

    @Test
    public void testCargoHashCode(){
        Cargo cargo1 = new Cargo("Books", 20);
        Cargo cargo2 = new Cargo("Books", 20);

        Assertions.assertEquals(cargo1.hashCode(), cargo2.hashCode());
    }
}
