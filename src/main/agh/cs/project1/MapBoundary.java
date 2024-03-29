package agh.cs.project1;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver {
    private TreeSet<Vector2d> positionsByX = new TreeSet<>(new Vector2dComparatorByX());
    private TreeSet<Vector2d> positionsByY = new TreeSet<>(new Vector2dComparatorByY());

    public void addNewAnimal(Animal animal){
        animal.addObserver(this);
        positionsByX.add(animal.position);
        positionsByY.add(animal.position);
    }

    public void addNewGrass(Grass grass){
        positionsByX.add(grass.position);
        positionsByY.add(grass.position);
    }

    public void removeAnimal(Animal animal){
        animal.removeObserver(this);
        positionsByX.remove(animal.position);
        positionsByY.remove(animal.position);
    }

    public void removeGrass(Grass grass){
        positionsByX.remove(grass.position);
        positionsByY.remove(grass.position);
    }

    public Vector2d getLowerLeftCornerOfMap(){
        return new Vector2d(getMinX(), getMinY());
    }

    public Vector2d getUpperRightCornerOfMap(){
        return new Vector2d(getMaxX(), getMaxY());
    }

    private int getMinX(){
        return positionsByX.first().x;
    }

    private int getMaxX(){
        return positionsByX.last().x;
    }

    private int getMinY(){
        return positionsByY.first().y;
    }

    private int getMaxY(){
        return positionsByY.last().y;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Animal animal) {
        Vector2d newPosition = animal.getPosition();
        if(oldPosition.x != newPosition.x){
            positionsByX.remove(oldPosition);
            positionsByX.add(newPosition);
        }

        if(oldPosition.y != newPosition.y){
            positionsByY.remove(oldPosition);
            positionsByY.add(newPosition);
        }
    }
}
