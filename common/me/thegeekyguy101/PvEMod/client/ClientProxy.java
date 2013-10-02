package me.thegeekyguy101.PvEMod.client;

import me.thegeekyguy101.PvEMod.client.renderer.entity.RenderHerobrine;
import me.thegeekyguy101.PvEMod.client.renderer.entity.RenderNotch;
import me.thegeekyguy101.PvEMod.client.renderer.entity.RenderSteve;
import me.thegeekyguy101.PvEMod.entity.monster.EntityHerobrine;
import me.thegeekyguy101.PvEMod.entity.monster.EntityNotch;
import me.thegeekyguy101.PvEMod.entity.monster.EntitySteve;
import me.thegeekyguy101.PvEMod.server.ServerProxy;
import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySteve.class, new RenderSteve(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNotch.class, new RenderNotch(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHerobrine.class, new RenderHerobrine(new ModelBiped(), 0.3F));
	}
}
