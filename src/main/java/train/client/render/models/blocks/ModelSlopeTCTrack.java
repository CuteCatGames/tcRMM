package train.client.render.models.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import tmt.Tessellator;
import train.common.library.Info;
import train.common.tile.TileTCRail;

@SideOnly(Side.CLIENT)
public class ModelSlopeTCTrack extends ModelBase {
	
	private static IModelCustom modeltrack = AdvancedModelLoader.loadModel(new ResourceLocation(Info.modelPrefix + "track_slope.obj"));
	private static IModelCustom modelSlopeWood = AdvancedModelLoader.loadModel(new ResourceLocation(Info.modelPrefix + "supports_wood.obj"));
	private static IModelCustom modelSlopeBallast = AdvancedModelLoader.loadModel(new ResourceLocation(Info.modelPrefix + "supports_ballast.obj"));
	
	public ModelSlopeTCTrack() {
	}
	
	public void render(String type) {
		if (type.equals("wood")) {
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, Info.modelTexPrefix + "track_slope.png"));
			modelSlopeWood.renderAll();
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, Info.modelTexPrefix + "track_normal.png"));
			modeltrack.renderAll();
		}
		if (type.equals("gravel")) {
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, "textures/blocks/gravel.png"));
			modelSlopeBallast.renderAll();
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, Info.modelTexPrefix + "track_normal.png"));
			modeltrack.renderAll();
		}
		if (type.equals("ballast")) {
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, "textures/blocks/ballast_test.png"));
			modelSlopeBallast.renderAll();
			Tessellator.bindTexture(new ResourceLocation(Info.resourceLocation, Info.modelTexPrefix + "track_normal.png"));
			modeltrack.renderAll();
		}
	}
	
	public void render(String type, TileTCRail tcRail, double x, double y, double z) {

		GL11.glColor4f(1, 1, 1, 1);
		// GL11.glScalef(0.5f, 0.5f, 0.5f);

		switch (tcRail.getFacing()){
			case 0:{GL11.glRotatef(180, 0, 1, 0);break;}
			case 1:{GL11.glRotatef(90, 0, 1, 0);break;}
			case 3:{GL11.glRotatef(-90, 0, 1, 0);break;}
		}
		// GL11.glTranslatef(0.0f, 0.0f, -1.0f);
		render(type);
	}
}