import processing.core.PApplet;
import processing.core.PMatrix3D;
import processing.opengl.PGraphics3D;

import java.util.Arrays;

public class Landscape extends PApplet{

    public float[][] grid = new float[200][200];

    public static void main(String[] args) {

        PApplet.main("Landscape", args);
    }

    public void settings() {
        size(808,808, P3D);
    }

    public void setup() {
        frameRate(1.0f);
        float noiseFactor = 0.05f;

        for(int x = 0; x < 200; x++)
            for(int y = 0; y < 199; y++)
                grid[x][y] = noise(x*noiseFactor, y*noiseFactor);
    }

    public void draw() {
        noStroke();

        rotateX(PI / 4);
        scale(0.4f);
        translate(600, 1000);

        for(int x = 0; x < 79; x++) {
            beginShape(TRIANGLE_STRIP);
            for(int y = 1; y < 80; y++) {
                fill( grid[x][y] * 300);

                if(190 < grid[x][y] * 300) {
                    fill(235, 235, 235);
                    stroke(255, 255, 255);
                } else if (170 < grid[x][y] * 300) {
                    fill(100, 100, 100);
                    stroke(80, 80, 80);
                } else if (120 < grid[x][y] * 300) {
                    fill(34,139,34);
                    stroke(14, 119, 14);
                } else if (100 < grid[x][y] * 300) {
                    fill(240,230,140);
                    stroke(220, 210, 120);
                } else {
                    fill(0, 100, 255);
                    stroke(0, 80, 235);
                }

                vertex(4 + 10*(x+0), 4 + 10*(y+0), grid[x][y] * 310);
                vertex(4 + 10*(x+1), 4 + 10*(y), grid[x+1][y] * 310);
            }
            endShape(CLOSE);
        }

//        beginShape(TRIANGLE_STRIP);
//
//        //  x: 0    y: 0
//        vertex(10 + 0, 10 + 0);
//        vertex(10 + 0, 10 + 8);
//
//        //  x: 0    y: 0
//        vertex(10 + 8, 10 + 0);
//        vertex(10 + 8, 10 + 8);
//
//        //  x: 0    y: 0
//        vertex(10 + 16, 10 + 0);
//        vertex(10 + 16, 10 + 8);
//        endShape();

    }
}
