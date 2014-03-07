package mod.industrialProcessing.blockContainer.multiblock.utils;

public enum MultiblockState {
	DISCONNECTED, CONNECTED, COMPLETED;
	public static MultiblockState fromInt(int state){
		for(MultiblockState st: MultiblockState.values()){
			if (st.ordinal() == state)
				return st;
		}
		return null;
	}
}
