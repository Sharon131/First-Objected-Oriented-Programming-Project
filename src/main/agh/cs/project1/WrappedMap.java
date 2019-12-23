package agh.cs.project1;

import java.util.*;

public class WrappedMap extends AbstractWorldMap {
    private Random rand = new Random();
    private Map<Vector2d, Grass> grassByPosition = new HashMap<>();
    protected Map<Vector2d, MapField> fields = new HashMap<>();
    private MapBoundary jungle = new MapBoundary();

    public  WrappedMap(){
        ;
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
    public void positionChanged(Vector2d oldPosition, Animal animal){
        super.positionChanged(oldPosition, animal);

        MapField field = fields.get(animal.getPosition());

        if (field.containsAnimal()){
            //map.procreateAt(animal.getPosition());
        }
        if (field.containsGrass()){
            //Grass grass = field.getGrass();
            //field.removeMapElement(grass);
        }

        fields.get(oldPosition).removeMapElement(animal);
        field.addMapElement(animal);
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
