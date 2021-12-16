import java.util.ArrayList;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */
public class SimulationModel {
    private ScreenRenderer view;
    private int width;
    private int height;
    private int scale;
    private int startingNestSize = 6;
    private int currentNestID = 1;
    private int totalNests = 10;
    String[][] cellGridArray;
    String[][] cellGridArrayTemporary;
    ArrayList<nest> nests;

    public SimulationModel(int w, int h, int s) {
        this.width = w;
        this.height = h;
        this.scale = s;
        this.cellGridArray = new String[width/scale][height/scale];
        this.cellGridArrayTemporary = new String[width/scale][height/scale];
        this.nests = new ArrayList<>();
    }


    public String randomFood() {
        String output;
        int randomInt = (int) Math.floor(Math.random() * 40);
        if (randomInt == 1) {output = "food";}
        else output = "empty";
        return output;
    }

    public void randomizeCellGrid() {
        System.out.println("Randomizing cells...");
        for (int z = 0; z < (height/scale) - 1; z++) {
            for (int i = 0; i < (width / scale) - 1; i++) {
                cellGridArray[i][z] = randomFood();
                //System.out.println("x=" + i + " y=" + z + " " + cellGridArray[i][z]);
            }
        }
    }

    public void renderNest(int x, int y) {
        // Clear surrounding area //
        for (int i = y-2; i < (y+startingNestSize+2) - 1; i++) {
            for (int z = x-2; z < (x+startingNestSize+2) - 1; z++) {
                cellGridArray[z][i] = "empty";
            }
        }
        // Render the nest //
        for (int i = y; i < (y+startingNestSize) - 1; i++) {
            for (int z = x; z < (x+startingNestSize) - 1; z++) {
                cellGridArray[z][i] = "nest" + currentNestID;

            }
        }
    }

    public void createNests(int nestAmmount) {
        int id = this.currentNestID;

        for (int i = 0; i < nestAmmount; i++) {
            int x = (int) Math.floor(Math.random() * (width/scale-20)) + 5;
            int y = (int) Math.floor(Math.random() * (height/scale-20)) + 5;
            nests.add(new nest(x, y, id));
            this.renderNest(x,y);
            System.out.println("x= "+x+" y="+y+" "+cellGridArray[x][y]);
            this.currentNestID++;
        }
    }

    public void update() {
        //Check if to spawn or kill next update
        for (int y = 1; y < (height / scale) - 1; y++) {
            for (int x = 1; x < (width / scale) - 1; x++) {
                //
            }
        }


    }
    public String[][] getCellGridArray() {
        return cellGridArray;
    }
}
