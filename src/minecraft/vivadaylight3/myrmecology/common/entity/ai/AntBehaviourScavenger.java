package vivadaylight3.myrmecology.common.entity.ai;

import java.util.ArrayList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vivadaylight3.myrmecology.api.EntityAIAntBehaviour;
import vivadaylight3.myrmecology.api.IEntityAnt;
import vivadaylight3.myrmecology.common.lib.Environment;
import vivadaylight3.myrmecology.common.tileentity.TileEntityAntChest;

public class AntBehaviourScavenger extends EntityAIAntBehaviour {

    public AntBehaviourScavenger(IEntityAnt parEntityAnt, World parWorld,
	    PathNavigate parPathFinder) {
	super(parEntityAnt, parWorld, parPathFinder);
    }

    @Override
    public void updateTask() {

	this.startExecuting();

    }

    @Override
    public void startExecuting() {

	System.out.println("scav start");

	ArrayList<EntityItem> list = Environment.getEntityItemsInRadius(world,
		getPosX(), getPosY(), getPosY(), 100);

	if (this.theAnt.getHasGoneTo()) {

	    System.out.println("scav hasGoneTo");

	    if (Environment.coordinateIsCloseTo(getPosX(), getPosY() - 1,
		    getPosZ(), (int) this.theAnt.getHomeX(),
		    (int) this.theAnt.getHomeY(), (int) this.theAnt.getHomeZ(),
		    1)) {

		System.out.println("scav isClose");

		TileEntity tile = world.getBlockTileEntity(
			(int) this.theAnt.getHomeX(),
			(int) this.theAnt.getHomeY() - 1,
			(int) this.theAnt.getHomeZ());

		if (tile != null && this.theAnt.inventory[0] != null) {

		    if (tile instanceof TileEntityAntChest) {

			Environment.addItemStackToInventory(
				this.theAnt.inventory[0],
				((TileEntityAntChest) tile).getContents(),
				((TileEntityAntChest) tile)
					.getInventoryStackLimit(), tile);

		    }

		}

	    }

	    if (list.size() > 0) {

		System.out.println("list size > 0");

		if (Environment.inventoryCanHold(list.get(0).getEntityItem(),
			this.theAnt.inventory, list.get(0).getEntityItem()
				.getMaxStackSize())) {

		    System.out.println("inventoryCanHold");

		    Environment.addItemStackToInventory(list.get(0)
			    .getEntityItem(), this.theAnt.inventory, list
			    .get(0).getEntityItem().getMaxStackSize(), null);
		    list.get(0).setDead();

		    this.theAnt.setShouldGoTo(true);
		    this.theAnt.setHasGoneTo(false);
		    this.theAnt.setGoToX((int) this.theAnt.getHomeX());
		    this.theAnt.setGoToY((int) this.theAnt.getHomeY());
		    this.theAnt.setGoToZ((int) this.theAnt.getHomeZ());

		}

	    }

	} else {

	    System.out.println("scav !hasGoneTO");

	    if (list != null) {

		System.out.println("list != null");

		if (list.size() > 0) {

		    list.get(0).setDead();

		    System.out.println("list > 0");

		    this.theAnt.setShouldGoTo(true);
		    this.theAnt.setHasGoneTo(false);
		    this.theAnt.setGoToX((int) list.get(0).posX);
		    this.theAnt.setGoToY((int) list.get(0).posY);
		    this.theAnt.setGoToZ((int) list.get(0).posZ);

		}

	    }

	}

    }

}
