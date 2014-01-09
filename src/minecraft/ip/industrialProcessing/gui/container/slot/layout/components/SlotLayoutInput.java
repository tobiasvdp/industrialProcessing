package ip.industrialProcessing.gui.container.slot.layout.components;

import net.minecraft.inventory.IInventory;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;

public class SlotLayoutInput extends SlotLayout{
	public SlotLayoutInput(SlotLayoutType layout, int amount, int startIndex, int offsetX,int offsetY) {
		this.sizeX = 54;
		this.sizeY = 54;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.layout = layout;
		slots = new SlotBase[amount];
		amount = amount - 1;

		int count = 0;
		switch (layout) {
		case circular:
			//don't use.
			double angle = (2*Math.PI/(amount+1));
			for(int i = 0;i<amount+1;i++){
				System.out.println(angle);
				slots[count++] = new SlotBase(null, startIndex++, ((int)(27+(Math.cos(angle)*18-9))), ((int)(27+(Math.sin(angle)*18-9))));
				angle += angle;
			}
			break;
		case horizontal:
			int xHor = amount % 3 + 1;
			int yHor = (amount) / 3 + 1;
			if (yHor > 1) {
				for (int i = 0; i < (yHor - 1); i++) {
					for (int j = 0; j < 3; j++)
						slots[count++] = new SlotBase(null, startIndex++, 18 * j, 27 - yHor * 9 + i * 18);
				}
				for (int i = 0; i < xHor; i++) {
					slots[count++] = new SlotBase(null, startIndex++, 27 - xHor * 9 + i * 18, 27 - yHor * 9 + (yHor - 1) * 18);
				}
			} else {
				int spacing = (54 - 18 * xHor) / (xHor + 1);
				for (int i = 0; i < xHor; i++) {
					slots[count++] = new SlotBase(null, startIndex++, spacing * (i + 1) + i * 18, 18);
				}
			}
			break;
		case rectangle:
			if(amount == 0){
				slots[count++] = new SlotBase(null, startIndex++, 18,18);
			}else if(amount == 3){
				slots[count++] = new SlotBase(null, startIndex++, 9,9);
				slots[count++] = new SlotBase(null, startIndex++, 27,9);
				slots[count++] = new SlotBase(null, startIndex++, 9,27);
				slots[count++] = new SlotBase(null, startIndex++, 27,27);
			}else if(amount == 8){
				for(int i =0;i<3;i++){
					for(int j = 0;j<3;j++){
						slots[count++] = new SlotBase(null, startIndex++, j*18,i*18);
					}
				}
			}
			break;
		case vertical:
			int yVer = amount % 3 + 1;
			int xVer = (amount) / 3 + 1;
			if (xVer > 1) {
				for (int i = 0; i < (xVer - 1); i++) {
					for (int j = 0; j < 3; j++)
						slots[count++] = new SlotBase(null, startIndex++, 27 - xVer * 9 + i * 18, 18 * j);
				}
				for (int i = 0; i < yVer; i++) {
					slots[count++] = new SlotBase(null, startIndex++, 27 - xVer * 9 + (xVer - 1) * 18, 27 - yVer * 9 + i * 18);
				}
			} else {
				int spacing = (54 - 18 * yVer) / (yVer + 1);
				for (int i = 0; i < yVer; i++) {
					slots[count++] = new SlotBase(null, startIndex++, 18,spacing * (i + 1) + i * 18);
				}
			}
			break;
		}
		for (int i = 0; i < amount + 1; i++) {
			System.out.println("x:" + slots[i].xDisplayPosition + " y:" + slots[i].yDisplayPosition);
		}
	}
}
