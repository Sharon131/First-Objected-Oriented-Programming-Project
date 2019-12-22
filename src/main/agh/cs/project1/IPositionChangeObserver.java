package agh.cs.project1;

public interface IPositionChangeObserver {
    public void positionChanged(Vector2d oldPosition, Animal animal);
}
