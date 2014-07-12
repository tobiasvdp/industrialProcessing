package mod.industrialProcessing.utils.handlers.numbers;

public interface IStateConfig {
    int getStateValue(int index);
    void setStateValue(int index, int value);
    int getMaxStateValue(int index);
    int getMinStateValue(int index);
}
