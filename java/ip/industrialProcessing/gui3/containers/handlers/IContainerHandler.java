package ip.industrialProcessing.gui3.containers.handlers;

public interface IContainerHandler {

    void readFromEntity();

    int getValueCount();

    boolean hasChanged(int i);

    int getValue(int i);

    void setValue(int i, int par2);

}
