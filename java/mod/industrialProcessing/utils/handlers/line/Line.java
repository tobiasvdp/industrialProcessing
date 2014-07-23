package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraftforge.common.util.ForgeDirection;

public class Line implements ILine {
	
	int ID;
	ArrayList<ILineTileEntity> te;
	
	public Line(int id) {
		this.ID = id;
		te = new ArrayList<ILineTileEntity>();
	}

	@Override
	public int registerToLine(ILineTileEntity teLine) {
		te.add(teLine);
		return 0;
	}

	@Override
	public boolean unregisterFromLine(ILineTileEntity teLine) {
		te.remove(teLine);
		if(te.size() == 0)
			return true;
		return false;
	}

	@Override
	public void registerToLineFromNBT(ILineTileEntity teLine) {
		// TODO Auto-generated method stub

	}

	@Override
	public int registerUtilityToLine(ILineTileEntity teLine) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean unregisterUtilityFromLine(ILineTileEntity teLine) {
		return false;
	}

	@Override
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine) {
		// TODO Auto-generated method stub       
	}

	@Override
	public boolean mergeLine(ILine line) {
		Iterator<ILineTileEntity> it = te.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			line.registerToLine(tile);
			if(tile instanceof ILineTileEntityMicroblock){
				ILineTileEntityMicroblock micro = (ILineTileEntityMicroblock) tile;
				for(int i = 0;i<6;i++){
					if(micro.getLineID(i) == this.ID){
						micro.setLineID(i, line.getID());
					}
				}
			}else{
				//TODO
			}
		}
		te.clear();
		return true;
	}

	@Override
	public int getID() {
		return ID;
	}

	public void redoLine() {
		Iterator<ILineTileEntity> it = te.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			if(tile instanceof ILineTileEntityMicroblock){
				ILineTileEntityMicroblock micro = (ILineTileEntityMicroblock) tile;
				for(int i = 0;i<6;i++){
					if(micro.getLineID(i) == this.ID){
						micro.setLineID(i, -5);
					}
				}
			}else{
				//TODO
			}
		}
		it = te.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			if(tile instanceof ILineTileEntityMicroblock){
				ILineTileEntityMicroblock micro = (ILineTileEntityMicroblock) tile;
				for(int i = 0;i<6;i++){
					if(micro.getLineID(i) == -5){
						micro.registerToLine(ForgeDirection.values()[i]);
					}
				}
			}else{
				//TODO
			}
		}
		te.clear();
	}

}
