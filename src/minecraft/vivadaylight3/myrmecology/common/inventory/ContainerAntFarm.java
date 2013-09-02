package vivadaylight3.myrmecology.common.inventory;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import vivadaylight3.myrmecology.common.tileentity.TileEntityAntFarm;

public class ContainerAntFarm extends Container {

    protected TileEntityAntFarm tileEntity;

    private static int numRows = 3;
    private static int numColumns = 5;

    public ContainerAntFarm(InventoryPlayer inventoryPlayer,
	    TileEntityAntFarm te) {

	tileEntity = te;

	int slotID = 0;
	// args: tileEntity, slotID, horisontal, vertical

	// Drone Slot
	addSlotToContainer(new Slot(tileEntity, slotID, 26, 17 + 2 * 18));

	// Queen Slot
	slotID++;
	addSlotToContainer(new Slot(tileEntity, slotID, 26, 17));

	/*
	 * Food Slot slotID++; addSlotToContainer(new Slot(tileEntity, slotID,
	 * 8, 17 + 18));
	 * 
	 * //Food Slot slotID++; addSlotToContainer(new Slot(tileEntity, slotID,
	 * 26 + 18, 17 + 18));
	 */

	for (int i = 0; i < numRows; i++) {
	    for (int j = 0; j < numColumns; j++) {

		slotID++;
		addSlotToContainer(new Slot(tileEntity, slotID, 62 + j * 18,
			17 + i * 18));

	    }
	}

	bindPlayerInventory(inventoryPlayer);
    }

    public static int getInventorySize() {

	int result = (numRows * numColumns) + 4;
	return result;

    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 9; j++) {
		addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
			8 + j * 18, 84 + i * 18));
	    }
	}

	for (int i = 0; i < 9; i++) {
	    addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
	}
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
	return tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {

	ItemStack stack = null;
	Slot slotObject = (Slot) inventorySlots.get(slot);

	// null checks and checks if the item can be stacked (maxStackSize > 1)
	if (slotObject != null && slotObject.getHasStack()) {
	    ItemStack stackInSlot = slotObject.getStack();
	    stack = stackInSlot.copy();

	    // merges the item into player inventory since its in the tileEntity
	    if (slot < 9) {
		if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
		    return null;
		}
	    }
	    // places it into the tileEntity is possible since its in the player
	    // inventory
	    else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
		return null;
	    }

	    if (stackInSlot.stackSize == 0) {
		slotObject.putStack(null);
	    } else {
		slotObject.onSlotChanged();
	    }

	    if (stackInSlot.stackSize == stack.stackSize) {
		return null;
	    }
	    slotObject.onPickupFromSlot(player, stackInSlot);
	}
	return stack;
    }

}