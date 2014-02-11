package mod.industrialProcessing.items;

import java.util.List;

import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import mod.industrialProcessing.utils.handlers.wireless.IReceiver;
import mod.industrialProcessing.utils.handlers.wireless.IRemote;
import mod.industrialProcessing.utils.handlers.wireless.ISender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemRemote extends ItemIP implements IRemote {

	public ItemRemote() {
		super();
		setMaxStackSize(1);
	}

	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		par1ItemStack.stackTagCompound = new NBTTagCompound();
		par1ItemStack.stackTagCompound.setIntArray("te", new int[] {});
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par1ItemStack.stackTagCompound == null) {
			par1ItemStack.stackTagCompound = new NBTTagCompound();
		}
		TileEntity tileEntity = par3World.getTileEntity(par4, par5, par6);
		if (tileEntity != null) {
			if (tileEntity instanceof ISender) {
				ISender sender = (ISender) tileEntity;
				if (sender.sendTileEntity(this, par1ItemStack) && par3World.isRemote)
					par2EntityPlayer.addChatMessage(new ChatComponentText("Pairing data for TileEntity received."));
			}
			if (tileEntity instanceof IReceiver) {
				IReceiver receiver = (IReceiver) tileEntity;
				if (receiver.receiveTileEntity(this, par1ItemStack) && par3World.isRemote)
					par2EntityPlayer.addChatMessage(new ChatComponentText("Pairing data for TileEntity send."));
			}
		}
		return true;
	}
	
	@Override
	public boolean canItemEditBlocks() {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if (par3EntityPlayer.isSneaking()) {
			par1ItemStack.stackTagCompound.setIntArray("te", new int[] {});
		}
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}

	@Override
	public void setTileEntity(ISender sender, ItemStack itemStack, int teX, int teY, int teZ) {
		itemStack.stackTagCompound.setIntArray("te", new int[] { teX, teY, teZ });
	}

	@Override
	public int[] getTileEntity(IReceiver receiver, ItemStack itemStack) {
		return itemStack.stackTagCompound.getIntArray("te");
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		super.addInformation(itemStack, player, list, par4);
		if (itemStack.stackTagCompound != null) {
			int[] te = itemStack.stackTagCompound.getIntArray("te");
			if (te.length == 3) {
				list.add(EnumChatFormatting.YELLOW + "te X:" + te[0] + " Y:" + te[1] + " Z:" + te[2]);
			} else {
				list.add(EnumChatFormatting.RED + "te");
			}
		}
	}

}
