package agh.cs.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Animal implements IMapElement{
    private Random rand = new Random();
    public Vector2d position;
    public MapDirection orientation = MapDirection.getRandomDirection(new Random());       //init is random actually
    private AbstractWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
    private int energyLevel;
    private int daysTilAdult = 0;
    private AnimalGenes genes = new AnimalGenes();

    public String toString(){
        String stringOrientation;
        switch (this.orientation) {
            case NORTH:
                stringOrientation = "^";
                break;
            case NORTH_EAST:
                stringOrientation = "NE";
                break;
            case EAST:
                stringOrientation = ">";
                break;
            case SOUTH_EAST:
                stringOrientation = "SE";
                break;
            case SOUTH:
                stringOrientation = "v";
                break;
            case SOUTH_WEST:
                stringOrientation = "SW";
                break;
            case WEST:
                stringOrientation = "<";
                break;
            case NORTH_WEST:
                stringOrientation = "NW";
                break;
            default:
                stringOrientation = ".";
                break;
        }
        return stringOrientation;
    }

    public Animal(AbstractWorldMap map) {       //will not be needed
        this.map = map;
        position = new Vector2d(2,2);
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) { //will not be needed
        this.map = map;
        position = initialPosition;
    }

    // bound zadane na wejściu, zatem lepiej będzie generować pozycję w wrappedMap
    /* public Animal(AbstractWorldMap map, int startEnergy){
        this.map = map;
        this.position = new Vector2d(rand.nextInt(8), rand.nextInt(8));     //bound zadane na wejściu
        this.energyLevel = startEnergy;
    } */

    public Animal(AbstractWorldMap map, Vector2d initialPos, int startEnergy){
        this.map = map;
        this.position = initialPos;
        this.energyLevel = startEnergy;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void moveTo(MoveDirection direction){
        Vector2d oldPosition = this.position;

        if (MoveDirection.BACKWARD.compareTo(direction) == -1){
            for (int i = 0; i < (8 - direction.ordinal()); i++){    //turn left x times, another func??
                this.orientation = this.orientation.previous();
            }
        } else {
            for (int i = 0; i < direction.ordinal(); i++){          //turn right x times
                this.orientation = this.orientation.next();
            }
        }

        Vector2d newPosition = position.add(this.orientation.toUnitVector());
        if(map.canMoveTo(newPosition)) {
            this.position = newPosition;
            this.positionChanged(oldPosition, this.position);
        }
    }

    public void makeAMove(){
        int movement = genes.getNextMove();
        this.moveTo(MoveDirection.intToMove(movement));
        daysTilAdult -= 1;
    }

    public boolean isAdult(){
        return daysTilAdult <= 0;
    }

    public void addObserver(IPositionChangeObserver observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public Animal procreateWith(Animal other){

        return new Animal(map);
    }

    public void eatGrass(Grass grass){
        //energyLevel += grass.energyLevel; //its private
    }
}
