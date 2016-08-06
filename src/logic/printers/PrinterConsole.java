package logic.printers;

import logic.interfaces.IPrinter;
import logic.models.*;
import logic.models.Box;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Coder on 06.08.2016.
 */

public class PrinterConsole implements IPrinter {

    private final int containerWidth;
    private Box[] boxes;

    public PrinterConsole(Box[] boxes, int containerWidth) {
        this.containerWidth = containerWidth;
        this.boxes = boxes;
    }

    //public void printer(Box[] boxes, int containerWidth) {
    public void printer() {

    JFrame frame=new JFrame("FCNR Packer");

    int containerHeight;
    containerHeight = boxes[boxes.length - 1].getOriginY() + boxes[boxes.length - 1].getHeight();
    int size = 100; // coefficient of grafic resize

    frame.setBounds(100, 100, containerWidth * size + 40, containerHeight * size + 60);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    JPanel contentPane = new JPanel(){
        Graphics2D g2;

        protected void paintComponent(Graphics g){
            int x, y;
            super.paintComponent(g);
            g2 = (Graphics2D)g;
            g2.setColor(Color.RED);

            g2.drawRect(10, 10, containerWidth * size, (boxes[boxes.length - 1].getOriginY() +
                    boxes[boxes.length - 1].getHeight()) * size );
            // drawRect(x start, y start (left high angle), width, height)

            g2.setColor(Color.GREEN);

            for (int i = 0; i < boxes.length; i++ ) {
                //System.out.println("Height x Width = " + boxes[i].getHeight() + " x " + boxes[i].getWidth() + " xOrigin / yOrigin = "
                //        + boxes[i].getOriginX() + " / " + boxes[i].getOriginY());

                x = 10 + boxes[i].getOriginX() * size;
                y = 10 + (containerHeight - boxes[i].getOriginY() - boxes[i].getHeight())  * size;
                g2.fillRect(x, y, boxes[i].getWidth() * size, boxes[i].getHeight() * size );

            }
        }
    };
    frame.setContentPane(contentPane);

    }
}
