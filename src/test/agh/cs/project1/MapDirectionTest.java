package agh.cs.project1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {

    @Test
    public void testNext(){
        assertEquals(MapDirection.NORTH.next(), MapDirection.NORTH_EAST);
        assertEquals(MapDirection.NORTH_EAST.next(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.next(), MapDirection.SOUTH_EAST);
        assertEquals(MapDirection.SOUTH_EAST.next(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(), MapDirection.SOUTH_WEST);
        assertEquals(MapDirection.SOUTH_WEST.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(), MapDirection.NORTH_WEST);
        assertEquals(MapDirection.NORTH_WEST.next(), MapDirection.NORTH);
    }

    @Test
    public void testPrevious(){
        assertEquals(MapDirection.NORTH.next(), MapDirection.NORTH_WEST);
        assertEquals(MapDirection.NORTH_WEST.next(), MapDirection.WEST);
        assertEquals(MapDirection.WEST.previous(), MapDirection.SOUTH_WEST);
        assertEquals(MapDirection.SOUTH_WEST.previous(), MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.previous(), MapDirection.SOUTH_EAST);
        assertEquals(MapDirection.SOUTH_EAST.previous(), MapDirection.EAST);
        assertEquals(MapDirection.EAST.previous(), MapDirection.NORTH_EAST);
        assertEquals(MapDirection.NORTH_EAST.previous(), MapDirection.NORTH);
    }
}
