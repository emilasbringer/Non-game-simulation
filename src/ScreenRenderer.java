import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This is a class
 * Created 2021-10-18
 *
 * @author Magnus Silverdal
 */

/**
 * A system for drawing pixelgraphics to the screen using native Java.
 * Created 2021-03-31
 *
 * @author Magnus Silverdal
 */
public class ScreenRenderer extends Canvas {
    private int WIDTH;
    private int HEIGHT;
    private int scale;

    private Screen screen;
    private BufferedImage image;
    private SimulationModel model;

    public ScreenRenderer(int width, int height, int scale) {
        // Screen data
        this.WIDTH = width;
        this.HEIGHT = height;
        this.scale = scale;
        image = new BufferedImage(WIDTH/scale, HEIGHT/scale, BufferedImage.TYPE_INT_RGB);
        screen = new Screen(((DataBufferInt) image.getRaster().getDataBuffer()).getData(),image.getWidth(), image.getHeight());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        bs.show();
    }

    public void draw(String[][] array) {
        for (int y = 0; y < (HEIGHT/scale-1); y++) {
            for (int x = 0; x < (WIDTH/scale-1); x++) {
                if(array[x][y].equals("food"))      {screen.draw(x, y,0xFFFFFF);}
                if(array[x][y].equals("empty"))     {screen.draw(x, y,0x000000);}
                if(array[x][y].charAt(0) == ('n'))  {screen.draw(x, y,0x3232C8);}
                if(array[x][y].equals("red"))       {screen.draw(x, y,0xff0000);}
            }
        }
    }
}
