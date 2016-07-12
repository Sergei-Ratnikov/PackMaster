package logic.interfaces;
import logic.models.Box;

/**
 * Created by Coder on 06.07.2016.
 */

public interface IPacker {
    void pack(Box[] boxes);
    int getContainerWidth();
}