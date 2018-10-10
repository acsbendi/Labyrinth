class Thing {
    private LabyrinthCell location;

    Thing(LabyrinthCell originalLocation){
        this.location = originalLocation;
    }

    void onPickedUp(){
        location = null;
    }

    int getDistanceFrom(LabyrinthCell cellToCompare, Labyrinth labyrinth){
        if(location == null)
            return Integer.MAX_VALUE;

        return labyrinth.getDistanceBetween(location, cellToCompare);
    }

    LabyrinthCell getLocation(){
        return location;
    }
}
