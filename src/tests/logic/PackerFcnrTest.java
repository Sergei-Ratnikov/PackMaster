package tests.logic;

import logic.interfaces.IPacker;
import logic.models.Box;
import logic.packers.PackerFcnr;

import static org.junit.Assert.*;

/**
 * Created by Coder on 06.07.2016.
 */
public class PackerFcnrTest {

    @org.junit.Test
    public void testPack() throws Exception {
        Box[] boxes = new Box[2];
        boxes[0] = new Box(1, 1);
        boxes[1] = new Box(2, 1);

        IPacker packer = new PackerFcnr(20);
        packer.pack(boxes);

        Box box = boxes[0];

        assertTrue(box.getOriginX() == 10);
    }
}