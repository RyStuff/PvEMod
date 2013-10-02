/**
 * PvE-Mod
 * 
 * RenderHerobrine
 * 
 * @author Ry_dog101
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
package me.thegeekyguy101.PvEMod.client.renderer.entity;

import me.thegeekyguy101.PvEMod.entity.monster.EntityHerobrine;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHerobrine extends RenderLiving {

	protected ModelBiped model;
	
	public RenderHerobrine(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelBiped)mainModel);
	}
	
	public void renderHerobrine(EntityHerobrine entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderHerobrine((EntityHerobrine)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderHerobrine((EntityHerobrine)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("pvemod:textures/mobs/herobrine.png");
	}

}

