
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class MySliderUI extends BasicSliderUI {

    private static float[] fracs = {0.0f, 0.5f, 1.0f};
    private LinearGradientPaint p;

    public MySliderUI(JSlider slider) {
        super(slider);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle t = trackRect;
        Point2D start = new Point2D.Float(t.x, t.y);
        Point2D end = new Point2D.Float(t.width, t.height);
        Color[] colors = {Color.red, Color.yellow, Color.green};
        p = new LinearGradientPaint(start, end, fracs, colors);
        g2d.setPaint(p);
        g2d.fillRect(t.x, t.y, t.width, t.height);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle t = thumbRect;
        g2d.setColor(Color.black);
        int tw2 = t.width / 2;
        g2d.drawLine(t.x, t.y, t.x + t.width - 1, t.y);
        g2d.drawLine(t.x, t.y, t.x + tw2, t.y + t.height);
        g2d.drawLine(t.x + t.width - 1, t.y, t.x + tw2, t.y + t.height);
    }
}