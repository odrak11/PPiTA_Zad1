package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit test")
class UnitTest {

    private Unit unit;
    private Coordinates startCoordinates;
    private Cargo cargo;

    @BeforeEach
    void setUp() {
        startCoordinates = new Coordinates(0, 0);
        int maxFuel = 10;
        int maxCargoWeight = 20;
        unit = new Unit(startCoordinates, maxFuel, maxCargoWeight);
        cargo = new Cargo("test", 5);
    }

    @Test
    @DisplayName("Should move unit")
    void shouldMoveUnit() {
        Coordinates newCoordinates = unit.move(5, 5);

        Assertions.assertEquals(5, newCoordinates.getX());
        Assertions.assertEquals(5, newCoordinates.getY());
        Assertions.assertEquals(0, unit.getFuel());
    }

    @Test
    @DisplayName("Should not move unit")
    void shouldNotMoveUnit() {
        Assertions.assertThrows(IllegalStateException.class, () -> unit.move(11, 11));
    }

    @Test
    @DisplayName("Should tank up unit")
    void shouldTankUpUnit() {
        unit.move(1, 1);
        unit.tankUp();

        Assertions.assertTrue(unit.getFuel() > 0 && unit.getFuel() <= 10);
    }

    //test metody LoadAllCargo
    @Test
    @DisplayName("Should load and unload cargo")
    void shouldLoadAndUnloadCargo() {
        unit.loadCargo(cargo);

        Assertions.assertEquals(5, unit.getLoad());
        Assertions.assertEquals(10, unit.getFuel());

        unit.unloadCargo(cargo);

        Assertions.assertEquals(0, unit.getLoad());
    }

    //test metody UnloadAllCargo
    @Test
    @DisplayName("Should unload all cargo")
    void shouldUnloadAllCargo() {
        unit.loadCargo(cargo);
        unit.unloadAllCargo();

        Assertions.assertEquals(0, unit.getLoad());
    }
}
