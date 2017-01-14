package ru.ege.curve;

import ru.ege.engine.EGEJFrame;
import ru.ege.engine.Vector2D;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MyJFrame extends EGEJFrame implements MouseListener {
    ArrayList<Vector2D> mc = new ArrayList<>();

    @Override
    public void mouseClicked(MouseEvent e) {
        //if (SwingUtilities.isRightMouseButton(e)) {
        Vector2D a = new Vector2D(e.getX(), e.getY());
        mc.add(a);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void drawAndUpdate(Graphics2D graphics, int dt) {
        for (int i = 1; i < mc.size() - 2; i++) {
            //Кривая Безье 3 рода
            Vector2D u = mc.get(i - 1);
            Vector2D v = mc.get(i);
            Vector2D w = mc.get(i + 1);
            Vector2D z = mc.get(i + 2);
            Vector2D u1, v1, w1, z1;
            Vector2D w3, w4, w2;
            w4 = u;
            for (double x = 0; x < 1; x += 0.01) {
                u1 = u.add((v.sub(u).scale(x)));
                v1 = v.add((w.sub(v).scale(x)));
                w1 = w.add((z.sub(w)).scale(x));
                w2 = u1.add((v1.sub(u1)).scale(x));
                z1 = v1.add((w1.sub(v1)).scale(x));
                w3 = w2.add((z1.sub(w2)).scale(x));
                graphics.drawLine(w4.getXInt(), w4.getYInt(), w3.getXInt(), w3.getYInt());
                w4 = w3;
            }
            /*
            //Кривая Безье 2 рода
            Vector2D a = mc.get(i - 1);
            Vector2D b = mc.get(i);
            Vector2D c = mc.get(i + 1);
            Vector2D a2, b2, c2, c3;
            c2 = a;
            for (double x = 0; x < 1; x += 0.01) {
                a2 = a.add((b.sub(a).scale(x)));
                b2 = b.add((c.sub(b).scale(x)));
                c3 = a2.add((b2.sub(a2).scale(x)));
                graphics.drawLine(c2.getXInt(), c2.getYInt(), c3.getXInt(), c3.getYInt());
                c2 = c3;
            }
            */
            //Кривая Безье 1 рода
            graphics.drawLine(mc.get(i - 1).getXInt(), mc.get(i - 1).getYInt(), mc.get(i).getXInt(), mc.get(i).getYInt());
            graphics.drawLine(mc.get(i).getXInt(), mc.get(i).getYInt(), mc.get(i + 1).getXInt(), mc.get(i + 1).getYInt());
            graphics.drawLine(mc.get(i + 1).getXInt(), mc.get(i + 1).getYInt(), mc.get(i + 2).getXInt(), mc.get(i + 2).getYInt());
        }
    }
}
