import javax.swing.*;
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
    private JLabel textLabel;
    private String[][] cellGridArray;
    private String[][] cellGridArrayTemporary;
    private nest Nest;
    private Screen screen;
    private ArrayList<nest> nests;

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
                if (cellGridArray[z][i].charAt(0) == 'n') {
                    clearNestID( Integer.parseInt(String.valueOf(cellGridArray[z][i].charAt(4))) );
                }
                else cellGridArray[z][i] = "empty";
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
        int nextNestX = 2;
        int nextNestY = 2;

        for (int i = 0; i < nestAmmount; i++) {
            nests.add(new nest(nextNestX, nextNestY, id, startingNestSize));
            this.renderNest(nextNestX,nextNestY);
            if ((nextNestX + 16) > (width/scale - 10)) {
                nextNestX = 2;
                nextNestY += (10 + 4);
            }
            else {nextNestX += 16;}
            id++;
        }

    }

    public void clearNestID(int id) {
        //

    }

    public void update() {
      //

    }

    public String[][] getCellGridArray() {
        return cellGridArray;
    }
}
