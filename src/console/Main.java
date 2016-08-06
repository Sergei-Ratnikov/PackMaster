package console;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import logic.interfaces.IPacker;
import logic.interfaces.IPrinter;
import logic.models.Box;
import logic.packers.PackerFcnr;
import logic.printers.PrinterConsole;

/**
 * Created by Coder on 11.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Box[] boxes = new Box[5];
        boxes[0] = new Box(2, 3);
        boxes[1] = new Box(2, 2);
        boxes[2] = new Box(3, 1);
        boxes[3] = new Box(1, 1);
        boxes[4] = new Box(2, 1);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width of the container: ");
        int containerWidth = Integer.parseInt( sc.nextLine() );

        IPacker packer = new PackerFcnr(containerWidth);
        packer.pack(boxes);

        System.out.println("Width of the container: " + containerWidth);
        for (int i = 0; i < boxes.length; i++ ) {
            System.out.println("Height x Width = " + boxes[i].getHeight() + " x " + boxes[i].getWidth() + " xOrigin / yOrigin = "
                    + boxes[i].getOriginX() + " / " + boxes[i].getOriginY());
        }

        IPrinter p = new PrinterConsole(boxes, containerWidth);
        p.printer();

    }
}
