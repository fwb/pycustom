package net.malrix.mc.pycustom;

import java.util.logging.Logger;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = "pycustom", name = "pycustom", version = "0.0.1" )
@NetworkMod( clientSideRequired = true, serverSideRequired = true )
public class mod_pycustom {
	public static Logger pyLog = Logger.getLogger( "pycustom" );
	@PreInit
	public void PreInit( FMLPreInitializationEvent event ) {
		pyLog.setParent( FMLLog.getLogger( ) );
	}
	
	@PostInit
	public void Load( FMLPostInitializationEvent event ) {
		pyLog.info( "pycustom registering recipes" );
		
		try {
			ItemStack bronzeIngot = OreDictionary.getOres( "ingotBronze" ).get( 0 );
			bronzeIngot.stackSize = 4;
			ShapedOreRecipe recipe = new ShapedOreRecipe( 
					bronzeIngot,
					true,
					new Object[] {
							"CC", "CT", 'C', "ingotCopper", 'T', "ingotTin"
					}
					);
		
			CraftingManager.getInstance( ).getRecipeList( ).add( recipe );
		} catch( Exception e ) {
			pyLog.info( "Unable to register Bronze Ingot recipe" );
		}
	}
}
