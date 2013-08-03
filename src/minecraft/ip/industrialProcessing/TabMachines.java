package ip.industrialProcessing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMachines extends CreativeTabs  {

	public TabMachines(int id, String name) {
		 super(id, name);
	}

		 @Override
		 @SideOnly(Side.CLIENT)
		 public ItemStack getIconItemStack(){
			 // Here you make the Icon of the creative Tab
			 return new ItemStack(IndustrialProcessing.blockCrusher,1,0);
		 }
		 public String getTranslatedTabLabel(){
			 // Here the Name
			 return "Industrial Processing";
		 }


}
