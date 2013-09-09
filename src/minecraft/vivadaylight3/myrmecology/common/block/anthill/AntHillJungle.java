package vivadaylight3.myrmecology.common.block.anthill;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import vivadaylight3.myrmecology.api.AntDamageSource;
import vivadaylight3.myrmecology.api.BlockAntHill;
import vivadaylight3.myrmecology.api.ItemAnt;
import vivadaylight3.myrmecology.common.Reference;
import vivadaylight3.myrmecology.common.Register;

public class AntHillJungle extends BlockAntHill {

    public AntHillJungle(int par1) {
	super(par1, Material.ground);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
	    int par4, Entity par5Entity) {

	par5Entity.attackEntityFrom(AntDamageSource.antBite, 1.0F);

    }

    @Override
    public ItemAnt getAnt() {
	return Register.antJungle;
    }

    @Override
    public String getHillName() {
	// TODO Auto-generated method stub
	return "Jungle Ant Hill";
    }

    @Override
    public String getHillSubName() {
	return "antHillJungle";
    }

    @Override
    public BiomeGenBase[] getHillBiomes() {

	BiomeGenBase[] biomes = new BiomeGenBase[] { BiomeGenBase.jungle,
		BiomeGenBase.jungleHills };

	return biomes;

    }

    @Override
    public boolean usesNativeGeneration() {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    public int[] getRequiredTouchingBlocks() {

	//int[] blocks = new int[] { Block.grass.blockID };

	return null;
    }

    @Override
    public int getDropQuantity() {
	// TODO Auto-generated method stub
	return 2;
    }

}
