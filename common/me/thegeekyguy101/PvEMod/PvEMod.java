/**
 * PvE-Mod
 * 
 * PvEMod
 * 
 * @author Ry_dog101
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
package me.thegeekyguy101.PvEMod;

import me.thegeekyguy101.PvEMod.entity.monster.EntityHerobrine;
import me.thegeekyguy101.PvEMod.entity.monster.EntityNotch;
import me.thegeekyguy101.PvEMod.entity.monster.EntitySteve;
import me.thegeekyguy101.PvEMod.server.ServerProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "PvE_Mod", name = "PvE-Mod", version = "3.0" )
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class PvEMod {
	
	@SidedProxy(clientSide = "me.thegeekyguy101.PvEMod.client.ClientProxy", serverSide = "me.thegeekyguy101.PvEMod.server.ServerProxy")
	public static ServerProxy proxy;
	
	static int startEntityId = 300;
	
	@EventHandler
	public void Load(FMLPreInitializationEvent Event) {
		
		proxy.registerRenderThings();
		
		/*
		 * Mob Registry
		 */
		EntityRegistry.registerModEntity(EntitySteve.class, "Steve", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityNotch.class, "Notch", 2, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityHerobrine.class, "Herobrine", 3, this, 80, 3, true);
		
		/*
		 * Spawning
		 */
		EntityRegistry.addSpawn(EntitySteve.class, 10, 2, 4, EnumCreatureType.monster, 
				BiomeGenBase.beach,
				BiomeGenBase.desert,
				BiomeGenBase.desertHills,
				BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.forest,
				BiomeGenBase.forestHills,
				BiomeGenBase.hell,
				BiomeGenBase.jungle,
				BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains,
				BiomeGenBase.sky,
				BiomeGenBase.swampland,
				BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityNotch.class, 10, 1, 4, EnumCreatureType.monster, 
                BiomeGenBase.beach,
                BiomeGenBase.desert,
                BiomeGenBase.desertHills,
                BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge,
                BiomeGenBase.forest,
                BiomeGenBase.forestHills,
                BiomeGenBase.hell,
                BiomeGenBase.jungle,
                BiomeGenBase.jungleHills,
                BiomeGenBase.mushroomIsland,
                BiomeGenBase.mushroomIslandShore,
                BiomeGenBase.plains,
                BiomeGenBase.sky,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityHerobrine.class, 10, 1, 2, EnumCreatureType.monster, 
                BiomeGenBase.beach,
                BiomeGenBase.desert,
                BiomeGenBase.desertHills,
                BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge,
                BiomeGenBase.forest,
                BiomeGenBase.forestHills,
                BiomeGenBase.hell,
                BiomeGenBase.jungle,
                BiomeGenBase.jungleHills,
                BiomeGenBase.mushroomIsland,
                BiomeGenBase.mushroomIslandShore,
                BiomeGenBase.plains,
                BiomeGenBase.sky,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills);
		
		/*
		 * Language Fix
		 */
		LanguageRegistry.instance().addStringLocalization("entity.PvE_Mod.Steve.name", "Steve");
		LanguageRegistry.instance().addStringLocalization("entity.PvE_Mod.Notch.name", "Notch");
		LanguageRegistry.instance().addStringLocalization("entity.PvE_Mod.Herobrine.name", "Herobrine");
		
		/*
		 * Spawn egg and colour
		 */
		registerEntityEgg(EntitySteve.class, 0x523D89, 0x00AFAF);
		registerEntityEgg(EntityNotch.class, 0xEEB49F, 0x75472F);
		registerEntityEgg(EntityHerobrine.class, 0xFFFFFF, 0x00AFAF);
	}
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
		
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
