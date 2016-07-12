package logic.packers;

import logic.interfaces.IPacker;
import logic.models.Box;
import java.util.*;

/**
 * Created by Coder on 06.07.2016.
 * Floor Сeiling No Rotation
 * Input: The number of rectangles to be packed n, the dimensions of the rectangles
 {w(Li); h(Li)} and the strip width W.
 Output: The height of a packing obtained in the strip.
 1: Sort the rectangles in order of non-increasing height such that h(L1) ≥ h(L2) ≥ ... ≥ h(Ln)
 2: for i = 1..n do
 3:   if Li is ceiling feasible then
 4:     pack Li on ceiling with minimum residual space
 5:   else [Li is not ceiling feasible]
 6:     if Li is floor feasible then
 7:       pack Li on the floor with minimum residual space
 8:     else [Li is not floor feasible]
 9:       level++;
 10:     end if
 11:   end if
 12: end for
 13: Output the height H of the strip, found by adding the height of each level
 */

public class PackerFcnr extends PackerBase implements IPacker {

    public PackerFcnr(int containerWidth){
        super(containerWidth);
    }

    public void pack(Box[] boxes) {

        /*  1: Sort the rectangles in order
            of non-increasing height such that h(L1) ≥ h(L2) ≥ ... ≥ h(Ln)
        */

        Arrays.sort(boxes);

        int level = 0; // текущий уровень
        int levelNumber = 0; // number of pack levels
        int[] levelHeight = new int[boxes.length]; // НЕПРАВИЛЬНО! Заменить массив на Array с возможностью добавлять элементы
        // массив levelHeight содержит высоты "этажей", номер элемента - номер этажа
        levelHeight[level] = 0;

        /*
        int i = 0;
        for ( Box box : boxes ) {
            box.setOriginX(i);
            box.setOriginY(i);
            i++;
        }
        */

        int i = 0;
        boxes[i].setOriginX(0);
        boxes[i].setOriginY(0);
        levelNumber++;
        levelHeight[levelNumber] = boxes[i].getHeight();

        int remWidth;      //  the width of the remainder
        for (i = 1; i < boxes.length; i++) {   // перебор всех прямоугольников
            for (level = 0; level <= levelNumber; level++) {

                // подсчет остатка ширины на текущем уровне
                remWidth = getContainerWidth();
                for (int j = 0; j < i; j++) {
                    if (boxes[j].getOriginY() == levelHeight[level]) {
                        remWidth = remWidth - boxes[j].getWidth();
                    }
                }

                if ( remWidth >= boxes[i].getWidth() ) {
                    boxes[i].setOriginY( levelHeight[level] );
                    boxes[i].setOriginX( (getContainerWidth() - remWidth));
                    break;
                }
                if (level == levelNumber && remWidth < boxes[i].getWidth() ){
                    levelNumber++;
                    levelHeight[levelNumber] = levelHeight[levelNumber - 1] + boxes[i].getHeight();
                    boxes[i].setOriginX( 0 );
                    boxes[i].setOriginY( levelHeight[levelNumber] );
                    break;
                }

            }
        }

    }
}
