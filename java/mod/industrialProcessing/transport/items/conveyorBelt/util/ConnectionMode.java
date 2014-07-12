package mod.industrialProcessing.transport.items.conveyorBelt.util;

public enum ConnectionMode {
    INPUT, OUTPUT, DUAL, NONE, INVENTORYINPUT, INVENTORYOUTPUT, ANYINPUT, ANYOUTPUT;
    public boolean canConnect(ConnectionMode other) {
        if (this == INPUT || this == ANYINPUT) {
            return other == OUTPUT || other == DUAL || other == ANYOUTPUT;
        } else if (this == OUTPUT || this == ANYOUTPUT) {
            return other == INPUT || other == DUAL || other == ANYINPUT;
        }
        return false;
    }

    public boolean isOutput(boolean strict) {
        return this == ANYOUTPUT || (strict ? this == OUTPUT : (this == OUTPUT || this == DUAL));
    }

    public boolean isInventoryOutput() {
        return this == INVENTORYOUTPUT || this == ANYOUTPUT;
    }

    public boolean isInventoryInput() {
        return this == INVENTORYINPUT || this == ANYINPUT;
    }

    public boolean isInventory() {
        return isInventoryOutput() || isInventoryInput();
    }
}
