package agh.cs.project1;

public class Grass implements IMapElement{
    public Vector2d position;
    private int energyLevel;

    public Grass(Vector2d position){
        this.energyLevel = 100; //?? plant energy as input??
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return "*";
    }
}
