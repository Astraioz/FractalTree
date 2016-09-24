package fractal;

import static fractal.Settings.*;
import static fractal.SettingsTree.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JFrame;

public class TreeFractal extends Fractal {

    private ArrayList<ArrayList<FractalCall>> calls;
    private JFrame jf;
    private double step = 0;
    private int frameCount = 0;

    public TreeFractal() {
        super();

        calls = new ArrayList<>();
        double length = LENGTH_0_MIN + Math.random() * (LENGTH_0_MAX - LENGTH_0_MIN);
        double stroke = (float) (STROKE_0_MIN + Math.random() * (STROKE_0_MAX - STROKE_0_MIN));
        run(0, true, SCREEN_WIDTH / 2, SCREEN_HEIGHT, 90, length, stroke);
        System.out.println("Done creating tree");
        repaint();

    }

    public void run(int level, boolean first, double x, double y, double angle, double length, double stroke) {

        double x1 = x + length * Math.cos(angle * Math.PI / 180);
        double y1 = y - length * Math.sin(angle * Math.PI / 180);

        if (level > RECURSION_LIMIT) {
            return;
        }

        double angle1, ratio, length1;
        float stroke1;
        int num = (int) (BRANCH_MIN + Math.random() * (BRANCH_MAX + 1 - BRANCH_MIN));
        double angleRange = (double) 180 / num;

        if (first) {
            calls.add(new ArrayList());
        }

        for (int i = 0; i < num; i++) {
            angle1 = angle + i * angleRange - 90 + (Math.random() * angleRange);
            length1 = (LENGTH_RATIO_MIN + Math.random() * (LENGTH_RATIO_MAX - LENGTH_RATIO_MIN)) * length;
            stroke1 = (float) ((STROKE_RATIO_MIN + Math.random() * (STROKE_RATIO_MAX - STROKE_RATIO_MIN)) * stroke);
            calls.get(level).add(new FractalCall(level + 1, x, y, x1, y1, angle1, length1, stroke1));
            run(level + 1, first && i == 0, x1, y1, angle1, length1, stroke1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        boolean isCurrentLevel;
        double x1, x2, y1, y2;
        for (int i = 0; i <= getStep() && i < calls.size(); i++) {
            isCurrentLevel = i == getStep();
            for (FractalCall call : calls.get(i)) {

                Color col = Color.getHSBColor(EDGE_COLOR_H_MIN + (EDGE_COLOR_H_MAX - ((float) i / RECURSION_LIMIT)/* * (EDGE_COLOR_H_MAX - EDGE_COLOR_H_MIN)*/), EDGE_COLOR_S, EDGE_COLOR_B);
                g2.setStroke(new BasicStroke(call.getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
                g2.setColor(col);
                x1 = call.getX1();
                y1 = call.getY1();
                x2 = call.getX2();
                y2 = call.getY2();
                if (isCurrentLevel) {
                    double t = step - getStep();
                    x2 = x1 + t * (x2 - x1);
                    y2 = y1 + t * (y2 - y1);
                }
                g2.draw(new Line2D.Double(x1, y1, x2, y2));
            }

        }

    }

    @Override
    public void nextStep() {
        if (step < calls.size() - 1) {
            frameCount++;
            if (frameCount % (FRAMES_0 / FRAMES(getStep())) == 0) {
                repaint();
            }
            step += 1D / FRAMES_0;
        }
    }

    public int getStep() {
        return (int) step;
    }

    @Override
    public boolean isDone() {
        return getStep() >= RECURSION_LIMIT;
    }

}
