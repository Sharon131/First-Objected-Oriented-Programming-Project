package agh.cs.project1;

public enum MoveDirection {
    FORWARD,
    FORWARD_RIGHT,
    RIGHT,
    BACKWARD_RIGHT,
    BACKWARD,
    BACKWARD_LEFT,
    LEFT,
    FORWARD_LEFT,
    NOT_KNOWN;

    public static MoveDirection intToMove(int number){
        MoveDirection[] values = MoveDirection.values();
        if (number >= values.length){
            throw new IllegalArgumentException("Arg is out of range.");
        }

        return values[number];
    }
}
