/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractal;

/**
 *
 * @author cge
 */
public class FractalCall {

    private int level;
    private double x1, y1, x2, y2;
    private double angle;
    private double length;
    private float stroke;

    public FractalCall(int level, double x1, double y1, double x2, double y2, double angle, double length, float stroke) {
        this.level = level;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.angle = angle;
        this.length = length;
        this.stroke = stroke;
    }

    public int getLevel() {
        return level;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
    
    public double getAngle() {
        return angle;
    }

    public double getLength() {
        return length;
    }

    public float getStroke() {
        return stroke;
    }
}
