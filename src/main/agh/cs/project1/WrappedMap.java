package agh.cs.project1;

import java.util.*;

public class WrappedMap extends AbstractWorldMap {
    private Random rand = new Random();
    private Map<Vector2d, Grass> grassByPosition = new HashMap<>();
    protected Map<Vector2d, MapField> fields = new HashMap<>();
    private MapBoundary jungle = new MapBoundary();

    public  WrappedMap(){
        //width and height of map as input
        //start energy of animal
        //move energy
        //plantEnergy
        //jungleRatio
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object1 = animalsByPositions.get(position);
        if(object1 != null)      return object1;

        return grassByPosition.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        //eat grass, when it's on the same place (add overriding func in grassfield and add super)
        //also copulate if there's animal at the same place;
        MapField field = fields.get(newPosition);

        if (field.containsAnimal()){
            //map.copulateAtPos(newPosition);
        }
        if (field.containsGrass()){
            //map.removeGrass(position);
        }

    }

    public void nextDay(){
        growGrass();
        moveAnimals();
        removeDeadAnimals();
    }

    public void moveAnimals(){
        ;
    }

    public void growGrass(){
        ;
    }

    public void removeDeadAnimals(){
        ;
    }


}
