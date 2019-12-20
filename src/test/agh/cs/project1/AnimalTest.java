package agh.cs.project1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    private AbstractWorldMap map = new RectangularMap(4, 4);
    private Animal someAnimal = new Animal(map);

    @Test
    public void testToString(){
        assertEquals("^", someAnimal.toString());
    }

    @Test
    public void testOrientation(){
        someAnimal.moveTo(MoveDirection.RIGHT);
        assertEquals(someAnimal.orientation, MapDirection.EAST);
        someAnimal.moveTo(MoveDirection.LEFT);
        assertEquals(someAnimal.orientation, MapDirection.NORTH);
    }

    @Test
    public void testPosition(){
        someAnimal.moveTo(MoveDirection.FORWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 3));

        someAnimal.moveTo(MoveDirection.BACKWARD);
        assertEquals(someAnimal.position, new Vector2d(2, 2));
    }

    @Test
    public void testMove(){
        Vector2d oldPos = someAnimal.position;
        someAnimal.moveTo(MoveDirection.FORWARD_LEFT);
        assertEquals(someAnimal.position, oldPos.add(someAnimal.orientation.toUnitVector()));
    }
}
