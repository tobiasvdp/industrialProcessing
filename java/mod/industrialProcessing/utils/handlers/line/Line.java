package mod.industrialProcessing.utils.handlers.line;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraftforge.common.util.ForgeDirection;

public class Line implements ILine {
	
	int ID;
	int length = 0;
	ArrayList<ILineTileEntity> te;
	ArrayList<ILineTileEntity> teUtil;
	
	public Line(int id) {
		this.ID = id;
		te = new ArrayList<ILineTileEntity>();
		teUtil = new ArrayList<ILineTileEntity>();
	}

	@Override
	public int registerToLine(ILineTileEntity teLine) {
		te.add(teLine);
		setLength(getLength()+1);
		return 0;
	}

	@Override
	public boolean unregisterFromLine(ILineTileEntity teLine) {
		te.remove(teLine);
		setLength(getLength()-1);
		if(getLength() == 0)
			return true;
		return false;
	}

	@Override
	public void registerToLineFromNBT(ILineTileEntity teLine) {
		te.add(teLine);
		length = Math.max(length, teLine.getLineLength());
		System.out.println(this.ID + " line has " + length + " size");
	}

	@Override
	public int registerUtilityToLine(ILineTileEntity teLine) {
		teUtil.add(teLine);
		return 0;
	}

	@Override
	public boolean unregisterUtilityFromLine(ILineTileEntity teLine) {
		teUtil.remove(teLine);
		return false;
	}

	@Override
	public void registerUtilityToLineFromNBT(ILineTileEntity teLine) {
		teUtil.add(teLine);     
	}

	@Override
	public boolean mergeLine(ILine line) {
		//TODO load entire line
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
		it = teUtil.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			line.registerUtilityToLine(tile);
			if(tile instanceof ILineTileEntityMicroblock){
				//TODO
			}else{
				ILineTileEntitySolidBlock teSolid = (ILineTileEntitySolidBlock) tile;
				teSolid.setLineID(line.getID());
			}
		}
		teUtil.clear();
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
		
		it = teUtil.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			if(tile instanceof ILineTileEntityMicroblock){
				ILineTileEntityMicroblock micro = (ILineTileEntityMicroblock) tile;
			}else{
				ILineTileEntitySolidBlock teSolid = (ILineTileEntitySolidBlock) tile;
				teSolid.setLineID(-1);
			}
		}
		it = teUtil.iterator();
		while(it.hasNext()){
			ILineTileEntity tile = it.next();
			if(tile instanceof ILineTileEntityMicroblock){
				ILineTileEntityMicroblock micro = (ILineTileEntityMicroblock) tile;
			}else{
				ILineTileEntitySolidBlock teSolid = (ILineTileEntitySolidBlock) tile;
				teSolid.registerToLine();
			}
		}
		teUtil.clear();
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int i) {
		length = i;
		Iterator<ILineTileEntity> it = te.iterator();
		while(it.hasNext()){
			it.next().setLineLength(length);
		}
	}

}
