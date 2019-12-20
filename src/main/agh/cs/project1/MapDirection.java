package agh.cs.project1;

public enum MapDirection {
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST;

    @Override
    public String toString() {
        String toReturn = "";
        if (this==NORTH){
            toReturn = "Północ";
        }
        if(this==NORTH_EAST){
            toReturn = "Północny wschód";
        }
        if (this==EAST){
            toReturn = "Wschód";
        }
        if(this==SOUTH_EAST){
            toReturn = "Południowy wschód";
        }
        if (this==SOUTH) {
            toReturn = "Południe";
        }
        if(this==SOUTH_WEST){
            toReturn = "Południowy zachód";
        }
        if (this==WEST){
            toReturn = "Zachód";
        }
        if(this==NORTH_WEST){
            toReturn = "Północny zachód";
        }
        return toReturn;
    }

    public MapDirection next(){
        if(this==NORTH){
            return NORTH_EAST;
        }
        if(this==NORTH_EAST){
            return EAST;
        }
        if(this==EAST){
            return SOUTH_EAST;
        }
        if(this==SOUTH_EAST){
            return SOUTH;
        }
        if (this==SOUTH){
            return SOUTH_WEST;
        }
        if(this==SOUTH_WEST){
            return WEST;
        }
        if(this==WEST){
            return NORTH_WEST;
        }
        if(this==NORTH_WEST){
            ; //is at the end
        }
        return NORTH;
    }

    public MapDirection previous(){
        if(this==NORTH){
            return NORTH_WEST;
        }
        if(this==NORTH_WEST){
            return WEST;
        }
        if(this==WEST){
            return SOUTH_WEST;
        }
        if(this==SOUTH_WEST){
            return SOUTH;
        }
        if (this==SOUTH){
            return SOUTH_EAST;
        }
        if(this==SOUTH_EAST){
            return EAST;
        }
        if(this==EAST){
            return NORTH_EAST;
        }
        if(this==NORTH_EAST){
            ;
        }
        return NORTH;
    }

    public Vector2d toUnitVector(){
        if(this==NORTH){
            return new Vector2d(0, 1);
        }
        if(this==NORTH_EAST){
            return new Vector2d(1, 1);
        }
        if(this==EAST){
            return new Vector2d(1, 0);
        }
        if(this==SOUTH_EAST){
            return new Vector2d(1, -1);
        }
        if (this==SOUTH){
            return new Vector2d(0, -1);
        }
        if(this==SOUTH_WEST){
            return new Vector2d(-1, -1);
        }
        if(this==WEST){
            return new Vector2d(-1, 0);
        }
        if(this==NORTH_WEST){
            ; //is at the end
        }
        return new Vector2d(-1, 1);
    }

}
