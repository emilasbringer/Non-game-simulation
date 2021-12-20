public class nest {
    int x;
    int y;
    int id;
    int width;
    int height;
    int totalFish;
    int attackers;
    int defenders;
    int fooders;
    float aggression;
    float cowardice;
    float gluttony;

    private SimulationModel model;

    public nest(int x, int y, int id, int startingNestSize) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.totalFish = startingNestSize;
        this.width = startingNestSize / 10;
        this.height = startingNestSize / 10;
    }


}
