import processing.core.PApplet;
import processing.core.PMatrix3D;
import processing.opengl.PGraphics3D;

import java.util.Arrays;

public class Landscape extends PApplet{

    public float[][] grid = new float[1000][1000];
    public int[] translateAmount = {0, 0};
    public int vert = 0;
    public int horz = 0;


    public static void main(String[] args) {

        PApplet.main("Landscape", args);
    }

    public void settings() {
        size(808,808, P3D);
    }

    public void setup() {
        frameRate(60f);

    }

    public void draw() {

        translateAmount[0] -= vert;
        translateAmount[1] -= horz;
        noStroke();
        clear();

        rotateX(PI / 4);
        scale(0.5f);
        translate(600, 1000);

        float noiseFactor = 0.05f;

        for(int x = 0; x < 1000; x++)
            for(int y = 0; y < 1000; y++)
                grid[x][y] = noise(x*noiseFactor + translateAmount[0]*noiseFactor, y*noiseFactor + translateAmount[1]*noiseFactor);

        for (int x = 0; x < 100; x++) {
            beginShape(TRIANGLE_STRIP);
            for (int y = 1; y < 100; y++) {
                fill(grid[x][y] * 300);

                if (190 < grid[x][y] * 300) {
                    fill(235, 235, 235);
                    stroke(255, 255, 255);
                } else if (170 < grid[x][y] * 300) {
                    fill(100, 100, 100);
                    stroke(80, 80, 80);
                } else if (120 < grid[x][y] * 300) {
                    fill(34, 139, 34);
                    stroke(14, 119, 14);
                } else if (100 < grid[x][y] * 300) {
                    fill(240, 230, 140);
                    stroke(220, 210, 120);
                } else {
                    fill(0, 100, 255);
                    stroke(0, 80, 235);
                }

                vertex(4 + 10 * (x + 0) - 300, 4 + 10 * (y + 0) - 500, grid[x][y] * 310);
                vertex(4 + 10 * (x + 1) - 300, 4 + 10 * (y) - 500, grid[x + 1][y] * 310);
            }
            endShape(CLOSE);
        }
    }

    public void keyPressed() {
        if(keyCode == LEFT) {
            vert = 1;
            horz = 0;
        } else if(keyCode == RIGHT) {
            vert = -1;
            horz = 0;
        } else if(keyCode == UP) {
            horz = 1;
            vert = 0;
        } else if(keyCode == DOWN) {
            horz = -1;
            vert = 0;
        }
    }

    public void keyReleased() {
        if(keyCode == LEFT) {
            vert = 0;
            horz = 0;
        } else if(keyCode == RIGHT) {
            vert = 0;
            horz = 0;
        } else if(keyCode == UP) {
            vert = 0;
            horz = 0;
        } else if(keyCode == DOWN) {
            vert = 0;
            horz = 0;
        }
    }
}
