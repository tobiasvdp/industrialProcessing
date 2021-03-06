package ip.industrialProcessing.subMod.logic.old.network.display;

import ip.industrialProcessing.gui.container.syncing.info.IExpirable;
import ip.industrialProcessing.gui.container.syncing.info.InfoMachine;
import ip.industrialProcessing.gui.container.syncing.info.InfoSlot;
import ip.industrialProcessing.gui.container.syncing.info.InfoTank;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.StatusType;
import ip.industrialProcessing.subMod.logic.old.network.TileEntityLogicNetworkNode;
import ip.industrialProcessing.subMod.logic.old.transport.ICommunicationNode;
import ip.industrialProcessing.subMod.logic.old.utils.UTBuffer;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariable;
import ip.industrialProcessing.subMod.logic.old.utils.UTVariableType;
import ip.industrialProcessing.subMod.logic.old.utils.UTlogicNodeContainer;
import ip.industrialProcessing.utils.working.IWorker;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidTankInfo;

public class TileEntityLogicDisplay extends TileEntityLogicNetworkNode {
    boolean tick = true;
    int suspendCount = 0;

    @Override
    public UTVariable[] getData(UTVariableType type) {
        return null;
    }

    @Override
    public String getName() {
        return "Display";
    }

    @Override
    public ForgeDirection[] setConnectableInputSides() {
        return new ForgeDirection[] { ForgeDirection.NORTH };
    }

    @Override
    public ForgeDirection[] setConnectableOutputSides() {
        return new ForgeDirection[] { ForgeDirection.NORTH };
    }

    @Override
    public void setData(UTVariable[] data, ICommunicationNode node) {
        for (ForgeDirection dir : this.getConnectableInputSides()) {
            UTlogicNodeContainer container = this.getConnectionsOnSide(this.getExternalForgeDirection(dir));
            int index = container.getIndex(node);
            if (index != -1) {
                UTBuffer buffer = this.getBuffer(dir);
                for (UTVariable var : data) {
                    System.out.println("got data " + var.ID);
                    if (var.ID == UTVariableType.power) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            IPowerStorage storage = (IPowerStorage) data[0].value;
                            machine.power.powerCapacity = (int) storage.getPowerCapacity();
                            machine.power.storedPower = (int) storage.getStoredPower();
                            machine.power.ttl = 10;
                        }
                    } else if (var.ID == UTVariableType.status) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            machine.status = (StatusType) data[0].value;
                            machine.ttl = 40;
                        }
                    } else if (var.ID == UTVariableType.interfaceTypes) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            machine.interfaceTypes = (InterfaceType[]) data[0].value;
                        }
                    } else if (var.ID == UTVariableType.coord) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            machine.x = (Integer) data[0].value;
                            machine.y = (Integer) data[1].value;
                            machine.z = (Integer) data[2].value;
                        }
                    } else if (var.ID == UTVariableType.name) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            machine.name = (String) data[0].value;
                        }
                    } else if (var.ID == UTVariableType.work) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            IWorker worker = (IWorker) data[0].value;
                            machine.worker.totalWork = worker.getTotalWork();
                            machine.worker.workDone = worker.getWorkDone();
                            machine.worker.ttl = 10;
                        }
                    } else if (var.ID == UTVariableType.tank) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            for (int i = 0; i < data.length; i++) {
                                FluidTankInfo info = (FluidTankInfo) data[i].value;
                                InfoTank tank = machine.getOrSetTank(i);
                                if (info.fluid != null) {
                                    tank.amount = info.fluid.amount;
                                    tank.fluidId = info.fluid.fluidID;
                                } else {
                                    tank.amount = 0;
                                    tank.fluidId = 0;
                                }
                                tank.capacity = info.capacity;
                                tank.ttl = 20;
                            }
                        }
                    } else if (var.ID == UTVariableType.slot) {
                        if (buffer.get(index).ID == UTVariableType.machine) {
                            InfoMachine machine = (InfoMachine) buffer.get(index).value;
                            for (int i = 0; i < data.length; i++) {
                                MachineItemStack info = (MachineItemStack) data[i].value;
                                InfoSlot slot = machine.getOrSetSlot(i);
                                if (info != null && info.stack != null) {
                                    slot.amount = info.stack.stackSize;
                                    slot.damage = info.stack.getItemDamage();
                                    slot.id = info.stack.itemID;
                                    if (info.input) {
                                        slot.input = true;
                                    }
                                    if (info.output) {
                                        slot.output = true;
                                    }

                                } else {
                                    slot.amount = 0;
                                    slot.damage = 0;
                                    slot.id = 0;
                                    slot.input = false;
                                    slot.output = false;
                                }
                                slot.ttl = 20;
                            }
                        }
                    }
                }
            }
        }
        this.tick = true;
    }

    @Override
    public void transition() {

    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (!this.worldObj.isRemote) {
            if (this.tick) {
                boolean tick = false;
                for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
                    UTBuffer buffer = this.getBuffer(dir);
                    for (int i = 0; i < buffer.size(); i++) {
                        UTVariable var = buffer.get(i);
                        if (var.tick()) {
                            tick = true;
                        }
                        if (var.value != null && var.value instanceof IExpirable) {
                            if (((IExpirable) var.value).tick()) {
                                tick = true;
                            }
                        }
                    }
                }
                if (!tick) {
                    this.suspendCount++;
                    if (this.suspendCount == 100) {
                        this.suspendCount = 0;
                        this.tick = false;
                        System.out.println("suspended");
                    }

                }
                System.out.println("Ticked");
            }
        }
    }
}
