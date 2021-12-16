public class nest {
    int totalFish;
    int attackers;
    int defenders;
    int fooders;
    int width;
    int height;
    int x;
    int y;
    int id;

    private SimulationModel model;

    public nest(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
}
