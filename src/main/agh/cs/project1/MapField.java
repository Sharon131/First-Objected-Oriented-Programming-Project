package agh.cs.project1;

import java.util.ArrayList;
import java.util.List;

public class MapField {
    private Vector2d position;
    private List<Animal> animals = new ArrayList<>();
    private List<Grass> grasses = new ArrayList<>();

    public void addMapElement(IMapElement element){
        if (element instanceof Animal) {
            Animal animal = (Animal) element ;
            animals.add(animal);
            //animal.addObserver(this);     //needed???
        } else if (element instanceof Grass) {
            grasses.add((Grass)element);
        }
    }

    public void removeMapElement(IMapElement element) {
        if (element instanceof Animal) {
            animals.remove((Animal)element);
        } else if (element instanceof Grass) {
            grasses.remove((Grass)element);
        }
    }

    public boolean containsAnimal(){
        return !animals.isEmpty();
    }

    public boolean containsGrass(){
        return !grasses.isEmpty();
    }

    public boolean isEmpty(){
        return animals.isEmpty() && grasses.isEmpty();
    }

}
