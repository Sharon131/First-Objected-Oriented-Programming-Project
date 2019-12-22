package agh.cs.project1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private AbstractWorldMap map = new RectangularMap(4, 4);    //should be wrapped map
    private Vector2d initPos = new Vector2d(2, 2);
    /*@Test
    public void testToString(){
        assertEquals("^", someAnimal.toString());
    }*/

    @Test
    public void testOrientation(){
        Animal animal = new Animal(map, initPos, 10);
        MapDirection initOrientation = animal.orientation;

        animal.moveTo(MoveDirection.RIGHT);
        assertEquals(initOrientation.ordinal() + 2, animal.orientation.ordinal());

        animal.moveTo(MoveDirection.BACKWARD);
        assertEquals(initOrientation.ordinal() + 6, animal.orientation.ordinal());
    }

    @Test
    public void testPosition(){
        Animal someAnimal = new Animal(map, initPos, 10);

        someAnimal.moveTo(MoveDirection.FORWARD_RIGHT);
        Vector2d newPos = initPos.add(someAnimal.orientation.toUnitVector());
        assertEquals(newPos, someAnimal.position);

        someAnimal.moveTo(MoveDirection.BACKWARD_LEFT);
        assertEquals(newPos.add(someAnimal.orientation.toUnitVector()), someAnimal.position);
    }

    @Test
    public void testMove(){
        Animal someAnimal = new Animal(map, initPos, 10);

        someAnimal.moveTo(MoveDirection.FORWARD_LEFT);
        assertEquals(someAnimal.position, initPos.add(someAnimal.orientation.toUnitVector()));
    }
}
