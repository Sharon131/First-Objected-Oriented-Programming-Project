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
        switch (number){
            case 0:
                return FORWARD;
            case 1:
                return FORWARD_RIGHT;
            case 2:
                return RIGHT;
            case 3:
                return BACKWARD_RIGHT;
            case 4:
                return BACKWARD;
            case 5:
                return BACKWARD_LEFT;
            case 6:
                return LEFT;
            case 7:
                return FORWARD_LEFT;
            default:
                return NOT_KNOWN;
        }
    }
}
