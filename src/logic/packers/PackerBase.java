package logic.packers;

/**
 * Created by Coder on 06.07.2016.
 */
public class PackerBase {
    private final int containerWidth;
    public PackerBase(int containerWidth) {
        this.containerWidth = containerWidth;
    }
    public int getContainerWidth() {return containerWidth; }
}
