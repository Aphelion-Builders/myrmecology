myrmecology
===========

The Myrmecology mod for Minecraft

Plans
==========================

This will hopefully explain where I'm going with the mod.

It's probably best to start from the very beginning. When a world is generated, a vareity of ant hills are generated in a vareity of biomes in the world (each hill has its own biome/s).
These ant hills can be broken with an ant extractor, this drops two ant larvae, the species depends on which ant hill was broken. These larvae can be placed in a redstone powered incubator, which will over time mature them into either drones, workers or queens. When their maturing time has passed, tehy will be removed from the incubator and either a queen, drone or worker will be added to the incubator in separate slots.
The drones and queens can be placed in an ant farm. If they drone and queen have a breeding result and can breed in the given conditions (biome, weather, time of day et.c) the drone will be instantly removed and the queen will be replaced with a queen of the species resulting from the breeding (hard to explain).
Here's an example of how the ant farm works:

Timmy has incubated a black ant larva into a black ant queen and a field ant larva into a field ant drone. He adds these to an ant farm, as they have a breeding result (the Common ant), the drone disappears and the black ant queen is replaced with a common ant queen (which will be shiny to symbolise that it has mated). After the common ant's lifetime has passed, it will disappear and several Common ant larvae will be added to the ant farm.

These larvae can then be incubated to produce more and more ants.

I haven't yet decided on how workers will be implemented, some ideas are the following:

* They will be placed inside a block called an ant nest, from here the workers will perform their species' behaviour.
* The player will place them on the ground, which will spawn a mob. The mob will then perform its species' behaviour. It will for example approach a tree and remve it block by block, then take the loot to a neaby chest or similar
* I'd love more ideas!


I would like to add some kind of ant companion system where you could have ants following and fighting for you, maybe you need to capture some ants from a different dimension for this?!


Textures
=========

To find what you'll need to call the textures that you create, look in the Reference class under: "myrmecology / src / minecraft / vivadaylight3 / myrmecology / common /".
There, each block, hill and ant is listed with their sub names.

The file names of ants should look like this: *ant's subname*_*ant type*.png

Example: antForest_Queen.png

If you look at the ANT_FOREST_NAME variable, its value is "antForest".

The same goes for hills, but they have no type name (e.g Queen), so they would be like this: *hill's subname*.png

Example: antHillForest.png

If you look at the HILL_FOREST variable, its value is "antHillForest".

The file names for GUIs should look like this: *item/block's subname*.png

Example: antFarm.png

If you look at the BLOCK_ANTFARM_NAME variable, its value is "antFarm".

All block textures should go in "myrmecology / resources / assets / myrmecology / textures / blocks /".

All GUI textures should go in "myrmecology / resources / assets / myrmecology / textures / gui /".

All item textures (except ants) should go in "myrmecology / resources / assets / myrmecology / textures / items /".

All ant textures should go in "myrmecology / resources / assets / myrmecology / textures / items / ant /".
