package ip.industrialProcessing.gui.container.slot.layout.components;

import java.awt.Rectangle;

import net.minecraft.inventory.IInventory;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayoutType;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;

public class SlotLayoutInput extends SlotLayout{
	public SlotLayoutInput(SlotLayoutType layout, int amount, int startIndex, Rectangle rect) {
		this.rect = rect;
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
			if(xHor == 1)
				this.rect.width = 18;
			if(xHor == 2)
				this.rect.width = 40;
			if(xHor == 3)
				this.rect.width = 52;
			if(yHor > 1)
				this.rect.width = 52;
			
			if (yHor > 1) {
				for (int i = 0; i < (yHor - 1); i++) {
					for (int j = 0; j < 3; j++)
						slots[count++] = new SlotBase(null, startIndex++, 18 * j, rect.height/2 - yHor * 9 + i * 18);
				}
				for (int i = 0; i < xHor; i++) {
					slots[count++] = new SlotBase(null, startIndex++, rect.width/2 - xHor * 9 + i * 18, rect.height/2 - yHor * 9 + (yHor - 1) * 18);
				}
			} else {
				int spacing = (rect.width - 18 * xHor) / (xHor + 1);
				for (int i = 0; i < xHor; i++) {
					slots[count++] = new SlotBase(null, startIndex++, spacing * (i + 1) + i * 18, 18);
				}
			}
			break;
		case rectangle:
			if(amount == 0){
				this.rect.width = 18;
				slots[count++] = new SlotOutput(null, startIndex++, 0,18);
			}else if(amount == 3){
				this.rect.width = 36;
				slots[count++] = new SlotOutput(null, startIndex++, 0,9);
				slots[count++] = new SlotOutput(null, startIndex++, 18,9);
				slots[count++] = new SlotOutput(null, startIndex++, 0,27);
				slots[count++] = new SlotOutput(null, startIndex++, 18,27);
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
			if(xVer == 1)
				this.rect.width = 18;
			if(xVer == 2)
				this.rect.width = 40;
			if(xVer == 3)
				this.rect.width = 52;
			
			if (xVer > 1) {
				for (int i = 0; i < (xVer - 1); i++) {
					for (int j = 0; j < 3; j++)
						slots[count++] = new SlotBase(null, startIndex++, rect.width/2 - xVer * 9 + i * 18, 18 * j);
				}
				for (int i = 0; i < yVer; i++) {
					slots[count++] = new SlotBase(null, startIndex++, rect.width/2 - xVer * 9 + (xVer - 1) * 18, rect.height/2 - yVer * 9 + i * 18);
				}
			} else {
				int spacing = (rect.height - 18 * yVer) / (yVer + 1);
				for (int i = 0; i < yVer; i++) {
					slots[count++] = new SlotBase(null, startIndex++, 0,spacing * (i + 1) + i * 18);
				}
			}
			break;
		}
	}
}
