package vivadaylight3.myrmecology.common;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import vivadaylight3.myrmecology.api.BlockAntHill;
import vivadaylight3.myrmecology.api.Breeding;
import vivadaylight3.myrmecology.api.ItemAnt;
import vivadaylight3.myrmecology.common.block.BlockAntFarm;
import vivadaylight3.myrmecology.common.block.BlockFungi;
import vivadaylight3.myrmecology.common.block.BlockIncubator;
import vivadaylight3.myrmecology.common.block.anthill.AntHillDesert;
import vivadaylight3.myrmecology.common.block.anthill.AntHillForest;
import vivadaylight3.myrmecology.common.block.anthill.AntHillJungle;
import vivadaylight3.myrmecology.common.block.anthill.AntHillPlains;
import vivadaylight3.myrmecology.common.block.anthill.AntHillSnow;
import vivadaylight3.myrmecology.common.block.anthill.AntHillStone;
import vivadaylight3.myrmecology.common.block.anthill.AntHillSwamp;
import vivadaylight3.myrmecology.common.block.anthill.AntHillWater;
import vivadaylight3.myrmecology.common.handler.MyrmecologyWorldGen;
import vivadaylight3.myrmecology.common.item.ItemAntopedia;
import vivadaylight3.myrmecology.common.item.ToolExtractor;
import vivadaylight3.myrmecology.common.item.ant.AntBarbaric;
import vivadaylight3.myrmecology.common.item.ant.AntCarpenter;
import vivadaylight3.myrmecology.common.item.ant.AntCommon;
import vivadaylight3.myrmecology.common.item.ant.AntCultivator;
import vivadaylight3.myrmecology.common.item.ant.AntDesert;
import vivadaylight3.myrmecology.common.item.ant.AntDredger;
import vivadaylight3.myrmecology.common.item.ant.AntForest;
import vivadaylight3.myrmecology.common.item.ant.AntFungal;
import vivadaylight3.myrmecology.common.item.ant.AntHarvester;
import vivadaylight3.myrmecology.common.item.ant.AntHostile;
import vivadaylight3.myrmecology.common.item.ant.AntJungle;
import vivadaylight3.myrmecology.common.item.ant.AntMound;
import vivadaylight3.myrmecology.common.item.ant.AntOdourous;
import vivadaylight3.myrmecology.common.item.ant.AntPlains;
import vivadaylight3.myrmecology.common.item.ant.AntPlentiful;
import vivadaylight3.myrmecology.common.item.ant.AntScavenger;
import vivadaylight3.myrmecology.common.item.ant.AntSnow;
import vivadaylight3.myrmecology.common.item.ant.AntSprouter;
import vivadaylight3.myrmecology.common.item.ant.AntStone;
import vivadaylight3.myrmecology.common.item.ant.AntSwamp;
import vivadaylight3.myrmecology.common.item.ant.AntWater;
import vivadaylight3.myrmecology.common.tileentity.TileEntityAntFarm;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Register {

    private static Configuration config;

    public static CreativeTabs tabMyrmecology;

    private static ArrayList<ItemAnt> antList = new ArrayList<ItemAnt>();
    private static ArrayList<BlockAntHill> hillList = new ArrayList<BlockAntHill>();

    public static final int ID_BLOCK = 600;
    public static final int ID_ITEM = 3853;

    public static final int GUI_ID_ANTFARM = 1;
    public static final int GUI_ID_ANTOPEDIA = 2;
    public static final int GUI_ID_INCUBATOR = 3;

    public static int latestID = 0;

    public static Block blockAntFarm;

    public static Block blockAntHill;

    public static Block blockIncubator;

    public static Block blockFungi;

    public static Item itemExtractor;

    public static ItemAntopedia itemAntopedia;

    public static AntHillForest hillForest;
    public static AntHillJungle hillJungle;
    public static AntHillDesert hillDesert;
    public static AntHillPlains hillPlains;
    public static AntHillSnow hillSnow;
    public static AntHillStone hillStone;
    public static AntHillSwamp hillSwamp;
    public static AntHillWater hillWater;

    public static AntForest antForest;
    public static AntDesert antDesert;
    public static AntCommon antCommon;
    public static AntWater antWater;
    public static AntSwamp antSwamp;
    public static AntJungle antJungle;
    public static AntPlains antPlains;
    public static AntSnow antSnow;
    public static AntStone antStone;
    public static AntHarvester antHarvester;
    public static AntCarpenter antCarpenter;
    public static AntMound antMound;
    public static AntBarbaric antBarbaric;
    public static AntOdourous antOdourous;
    public static AntHostile antHostile;
    public static AntPlentiful antPlentiful;
    public static AntDredger antDredger;
    public static AntScavenger antScavenger;
    public static AntCultivator antCultivator;
    public static AntSprouter antSprouter;
    public static AntFungal antFungal;

    // TODO

    public static void setConfig(Configuration parConfig) {

	config = parConfig;

    }

    public static int getNewID() {

	latestID += 1;

	return latestID;

    }

    public static void registerBlocks() {

	config.load();

	blockAntFarm = new BlockAntFarm(config.get(
		Configuration.CATEGORY_BLOCK, Reference.BLOCK_ANTFARM_NAME, ID_BLOCK)
		.getInt(), Reference.BLOCK_ANTFARM_NAME);

	blockIncubator = new BlockIncubator(config.get(
		Configuration.CATEGORY_BLOCK, Reference.BLOCK_INCUBATOR_NAME,
		ID_BLOCK + 2).getInt(), Reference.BLOCK_INCUBATOR_NAME);

	/*blockFungi = new BlockFungi(config.get(Configuration.CATEGORY_BLOCK,
		Reference.BLOCK_FUNGI_NAME, ID_BLOCK + 3).getInt());
		*/

	hillForest = new AntHillForest(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_FOREST_NAME, ID_BLOCK + 4).getInt());

	hillDesert = new AntHillDesert(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_DESERT_NAME, ID_BLOCK + 5).getInt());

	hillJungle = new AntHillJungle(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_JUNGLE_NAME, ID_BLOCK + 6).getInt());

	hillPlains = new AntHillPlains(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_PLAINS_NAME, ID_BLOCK + 7).getInt(), Material.ground);

	hillSnow = new AntHillSnow(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_SNOW_NAME, ID_BLOCK + 8).getInt(), Material.ground);

	hillStone = new AntHillStone(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_STONE_NAME, ID_BLOCK + 9).getInt(), Material.ground);

	hillSwamp = new AntHillSwamp(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_SWAMP_NAME, ID_BLOCK + 10).getInt(), Material.ground);

	hillWater = new AntHillWater(config.get(Configuration.CATEGORY_BLOCK,
		Reference.HILL_WATER_NAME, ID_BLOCK + 11).getInt(), Material.ground);

	config.save();

	addBlock(blockIncubator, "Ant Incubator", Reference.BLOCK_INCUBATOR_NAME);
	addBlock(blockAntFarm, "Ant Farm", Reference.BLOCK_ANTFARM_NAME);
	addBlock(blockFungi, "Agaricus Fungi", Reference.BLOCK_FUNGI_NAME);
	addBlock(hillForest, hillForest.getHillName(),
		hillForest.getHillSubName());
	addBlock(hillDesert, hillDesert.getHillName(),
		hillDesert.getHillSubName());
	addBlock(hillJungle, hillJungle.getHillName(),
		hillJungle.getHillSubName());
	addBlock(hillPlains, hillPlains.getHillName(),
		hillPlains.getHillSubName());
	addBlock(hillSnow, hillSnow.getHillName(), hillSnow.getHillSubName());
	addBlock(hillStone, hillStone.getHillName(), hillStone.getHillSubName());
	addBlock(hillSwamp, hillSwamp.getHillName(), hillSwamp.getHillSubName());
	addBlock(hillWater, hillWater.getHillName(), hillWater.getHillSubName());

    }

    public static void registerItems() {

	config.load();

	itemExtractor = new ToolExtractor(config.get(
		Configuration.CATEGORY_ITEM, Reference.ITEM_EXTRACTOR_NAME, ID_ITEM)
		.getInt());

	itemAntopedia = new ItemAntopedia(config.get(
		Configuration.CATEGORY_ITEM, Reference.ITEM_EXTRACTOR_NAME, ID_ITEM + 1)
		.getInt());

	antForest = new AntForest(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_FOREST_NAME, ID_ITEM + getNewID()).getInt());

	antDesert = new AntDesert(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_DESERT_NAME, ID_ITEM + getNewID()).getInt());

	antCommon = new AntCommon(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_COMMON_NAME, ID_ITEM + getNewID()).getInt());

	antWater = new AntWater(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_WATER_NAME, ID_ITEM + getNewID()).getInt());

	antSwamp = new AntSwamp(config.get(Configuration.CATEGORY_ITEM,
		"antSwamp", ID_ITEM + getNewID()).getInt());

	antJungle = new AntJungle(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_JUNGLE_NAME, ID_ITEM + getNewID()).getInt());

	antPlains = new AntPlains(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_PLAINS_NAME, ID_ITEM + getNewID()).getInt());

	antSnow = new AntSnow(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_SNOW_NAME, ID_ITEM + getNewID()).getInt());

	antStone = new AntStone(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_STONE_NAME, ID_ITEM + getNewID()).getInt());

	antHarvester = new AntHarvester(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_HARVESTER_NAME, ID_ITEM + getNewID()).getInt());

	antCarpenter = new AntCarpenter(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_CARPENTER_NAME, ID_ITEM + getNewID()).getInt());

	antMound = new AntMound(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_MOUND_NAME, ID_ITEM + getNewID()).getInt());

	antBarbaric = new AntBarbaric(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_BARBARIC_NAME, ID_ITEM + getNewID()).getInt());

	antOdourous = new AntOdourous(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_ODOUROUS_NAME, ID_ITEM + getNewID()).getInt());

	antHostile = new AntHostile(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_HOSTILE_NAME, ID_ITEM + getNewID()).getInt());

	antPlentiful = new AntPlentiful(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_PLENTIFUL_NAME, ID_ITEM + getNewID()).getInt());

	antDredger = new AntDredger(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_DREDGER_NAME, ID_ITEM + getNewID()).getInt());

	antScavenger = new AntScavenger(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_SCAVENGER_NAME, ID_ITEM + getNewID()).getInt());

	antCultivator = new AntCultivator(config.get(
		Configuration.CATEGORY_ITEM, Reference.ANT_CULTIVATOR_NAME,
		ID_ITEM + getNewID()).getInt());

	antSprouter = new AntSprouter(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_SPROUTER_NAME, ID_ITEM + getNewID()).getInt());

	antFungal = new AntFungal(config.get(Configuration.CATEGORY_ITEM,
		Reference.ANT_FUNGAL_NAME, ID_ITEM + getNewID()).getInt());

	config.save();

	// TODO

	addItem(itemExtractor, "Ant Extractor", Reference.ITEM_EXTRACTOR_NAME);

	addItem(itemAntopedia, "Antopedia", Reference.ITEM_ANTOPEDIA_NAME);

	addItem(antForest, antForest.getNames(),
		Reference.MOD_ID + antForest.getSpeciesSubName());

	addItem(antDesert, antDesert.getNames(),
		Reference.MOD_ID + antDesert.getSpeciesSubName());

	addItem(antCommon, antCommon.getNames(),
		Reference.MOD_ID + antCommon.getSpeciesSubName());

	addItem(antWater, antWater.getNames(),
		Reference.MOD_ID + antWater.getSpeciesSubName());

	addItem(antSwamp, antSwamp.getNames(),
		Reference.MOD_ID + antSwamp.getSpeciesSubName());

	addItem(antJungle, antJungle.getNames(),
		Reference.MOD_ID + antJungle.getSpeciesSubName());

	addItem(antPlains, antPlains.getNames(),
		Reference.MOD_ID + antPlains.getSpeciesSubName());

	addItem(antSnow, antSnow.getNames(),
		Reference.MOD_ID + antSnow.getSpeciesSubName());

	addItem(antStone, antStone.getNames(),
		Reference.MOD_ID + antStone.getSpeciesSubName());

	addItem(antHarvester, antHarvester.getNames(), Reference.MOD_ID
		+ antHarvester.getSpeciesSubName());

	addItem(antCarpenter, antCarpenter.getNames(), Reference.MOD_ID
		+ antCarpenter.getSpeciesSubName());

	addItem(antMound, antMound.getNames(),
		Reference.MOD_ID + antMound.getSpeciesSubName());

	addItem(antBarbaric, antBarbaric.getNames(), Reference.MOD_ID
		+ antBarbaric.getSpeciesSubName());

	addItem(antOdourous, antOdourous.getNames(), Reference.MOD_ID
		+ antOdourous.getSpeciesSubName());

	addItem(antHostile, antHostile.getNames(), Reference.MOD_ID
		+ antHostile.getSpeciesSubName());

	addItem(antPlentiful, antPlentiful.getNames(), Reference.MOD_ID
		+ antPlentiful.getSpeciesSubName());

	addItem(antDredger, antDredger.getNames(), Reference.MOD_ID
		+ antDredger.getSpeciesSubName());

	addItem(antScavenger, antScavenger.getNames(), Reference.MOD_ID
		+ antScavenger.getSpeciesSubName());

	addItem(antCultivator, antCultivator.getNames(), Reference.MOD_ID
		+ antCultivator.getSpeciesSubName());

	addItem(antSprouter, antSprouter.getNames(), Reference.MOD_ID
		+ antSprouter.getSpeciesSubName());

	addItem(antFungal, antFungal.getNames(),
		Reference.MOD_ID + antFungal.getSpeciesSubName());

    }

    // TODO
    public static void registerBreeding() {

	Breeding breeding = new Breeding();

	breeding.addBreeding(antCommon, antForest, antHarvester);
	breeding.addBreeding(antCommon, antPlains, antHarvester);
	breeding.addBreeding(antHarvester, antForest, antCarpenter);
	breeding.addBreeding(antHarvester, antPlains, antMound);

	breeding.addBreeding(antCommon, antJungle, antBarbaric);
	breeding.addBreeding(antCommon, antDesert, antBarbaric);
	breeding.addBreeding(antBarbaric, antDesert, antOdourous);
	breeding.addBreeding(antBarbaric, antJungle, antHostile);

	breeding.addBreeding(antCommon, antSnow, antPlentiful);
	breeding.addBreeding(antCommon, antStone, antPlentiful);
	breeding.addBreeding(antPlentiful, antStone, antDredger);
	breeding.addBreeding(antPlentiful, antSnow, antScavenger);

	breeding.addBreeding(antCommon, antSwamp, antCultivator);
	breeding.addBreeding(antCommon, antWater, antCultivator);
	breeding.addBreeding(antCultivator, antSwamp, antFungal);
	breeding.addBreeding(antCultivator, antWater, antSprouter);

    }

    public static void registerCreativeTab() {

	tabMyrmecology = new CreativeTabs("tab" + Reference.MOD_ID);

	LanguageRegistry.instance().addStringLocalization(
		"itemGroup." + "tab" + Reference.MOD_ID, "en_US",
		Reference.MOD_NAME);

    }

    public static void registerRecipes() {

	GameRegistry.addRecipe(new ItemStack(blockIncubator, 1), "wgw", "g g",
		"wrw", 'w', new ItemStack(Block.woodSingleSlab), 'g',
		new ItemStack(Block.glass), 'r', new ItemStack(
			Block.redstoneLampIdle));

	GameRegistry.addRecipe(new ItemStack(blockAntFarm, 1), "wgw", "gsg",
		"wgw", 'w', new ItemStack(Block.woodSingleSlab), 'g',
		new ItemStack(Block.glass), 's', new ItemStack(Block.sand));

    }

    public static void registerTileEntities() {

	GameRegistry.registerTileEntity(TileEntityAntFarm.class,
		Reference.BLOCK_ANTFARM_NAME);

    }

    public static void registerWorldGen() {

	MyrmecologyWorldGen worldGen = new MyrmecologyWorldGen();

	GameRegistry.registerWorldGenerator(worldGen);

    }

    /**
     * Registers an item with the GameRegistry and LanguageRegistry
     * 
     * @param item
     * @param name
     * @param subName
     */
    public static void addItem(Item item, String name, String subName) {

	GameRegistry.registerItem(item, subName);
	LanguageRegistry.addName(item, name);

    }

    /**
     * Registers an item (with damage and multiple names) with the GameRegistry
     * and LanguageRegistry
     * 
     * @param item
     * @param names
     *            []
     * @param subName
     */
    public static void addItem(Item item, String[] names, String subName) {

	GameRegistry.registerItem(item, subName);

	for (int k = 0; k < names.length; k++) {

	    LanguageRegistry.addName(new ItemStack(item, 1, k), names[k]);

	}

    }

    /**
     * Registers a block with the GameRegistry and LanguageRegistry
     * 
     * @param item
     * @param name
     * @param subName
     */
    public static void addBlock(Block item, String name, String subName) {

	GameRegistry.registerBlock(item, subName);
	LanguageRegistry.addName(item, name);

    }

    /**
     * Registers an block (with damage and multiple names) with the GameRegistry
     * and LanguageRegistry
     * 
     * @param block
     * @param names
     * @param subName
     */
    public static void addBlock(Block block, String[] names, String subName) {

	GameRegistry.registerBlock(block, subName);

	for (int k = 0; k < names.length; k++) {

	    LanguageRegistry.addName(new ItemStack(block, 1, k), names[k]);

	}

    }

    public static ItemStack getCreativeTabIcon() {

	return new ItemStack(blockAntHill, 1, 0);

    }

    public static void addAnt(ItemAnt ant) {

	getAntList().add(ant);

    }

    public static void addHill(BlockAntHill hill) {

	getHillList().add(hill);

    }

    public static ArrayList<ItemAnt> getAntList() {

	return antList;

    }

    public static ArrayList<BlockAntHill> getHillList() {

	return hillList;

    }

}