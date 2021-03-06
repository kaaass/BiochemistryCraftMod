package cn.BiochemistryCraft.Register;

import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Block.BlockHerbsCorps;
import cn.BiochemistryCraft.Item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class BCCRegisterItem {
	
	public static Item emptyneedle;
	public static Item biobrain;
	public static Item acidwand;
	
	public static Item cowblood;
	public static Item pigblood;
	public static Item chickenblood;
	public static Item wolfblood;
	public static Item playerblood;
	public static Item batblood;
	public static Item horseblood;
	public static Item mushroomblood;
	public static Item ocelotblood;
	public static Item sheepblood;
	public static Item squidblood;
	public static Item cavespiderblood;
	public static Item creeperblood;
	public static Item endermanblood;
	public static Item ghostblood;
	public static Item magmacubeblood;
	public static Item pigzombieblood;
	public static Item silverfishblood;
	public static Item slimeblood;
	public static Item spiderblood;
	public static Item witchblood;
	public static Item zombieblood;
	
	public static Item cowbloodessence;
	public static Item pigbloodessence;
	public static Item chickenbloodessence;
	public static Item wolfbloodessence;
	public static Item playerbloodessence;
	public static Item batbloodessence;
	public static Item horsebloodessence;
	public static Item mushroombloodessence;
	public static Item ocelotbloodessence;
	public static Item sheepbloodessence;
	public static Item squidbloodessence;
	public static Item cavespiderbloodessence;
	public static Item creeperbloodessence;
	public static Item endermanbloodessence;
	public static Item ghostbloodessence;
	public static Item magmacubebloodessence;
	public static Item pigzombiebloodessence;
	public static Item silverfishbloodessence;
	public static Item slimebloodessence;
	public static Item spiderbloodessence;
	public static Item witchbloodessence;
	public static Item zombiebloodessence;
	
	public static ItemHerbs fireGrass;
	public static ItemHerbs coolGrass;
	
	public static Item[] bloodgr = {cowblood, pigblood, chickenblood, wolfblood, playerblood, batblood, horseblood, mushroomblood, ocelotblood, sheepblood, squidblood,
		cavespiderblood, creeperblood, endermanblood, ghostblood, magmacubeblood, pigzombieblood, silverfishblood, slimeblood, spiderblood, witchblood, zombieblood};
	public static Item[] bloodes = {cowbloodessence, pigbloodessence, chickenbloodessence, wolfbloodessence, playerbloodessence,
		batbloodessence, horsebloodessence, mushroombloodessence, ocelotbloodessence, sheepbloodessence, squidbloodessence,
		cavespiderbloodessence, creeperbloodessence, endermanbloodessence, ghostbloodessence, magmacubebloodessence,
		pigzombiebloodessence, silverfishbloodessence, slimebloodessence, spiderbloodessence, witchbloodessence, zombiebloodessence};
	
	public static ItemHerbs[] herbsArray = {fireGrass, coolGrass};
	
	public BCCRegisterItem()
	{
		for (int i=0;i<22;i++)
		{
			bloodgr[i]=new ItemBs(i);
			bloodgr[i].setUnlocalizedName(ItemBs.getxzsmean(i)+"Needle");
			if(i<11)
				bloodgr[i].setTextureName("biomod:AnimalNeedle");
			else
				bloodgr[i].setTextureName("biomod:MonsterNeedle");
			
			bloodes[i]=new ItemBloodEssence(i);
			bloodes[i].setUnlocalizedName(ItemBloodEssence.getxzsmean(i));
			if(i<11)
				bloodes[i].setTextureName("biomod:AnimalEssence");
			else
				bloodes[i].setTextureName("biomod:MonsterEssence");
		}
		for(int i = 0; i <= 1; i++){
			herbsArray[i] = new ItemHerbs(1, 0.4F, BCCRegisterBlock.herbsCorpArray[i], BCCRegisterBlock.biodirt, i);
			herbsArray[i].setCreativeTab(BiochemistryCraft.biocreativetab);
			herbsArray[i].setUnlocalizedName(ItemHerbs.herbsArray[i]);
			herbsArray[i].setTextureName(BiochemistryCraft.MODID+":"+ItemHerbs.herbsArray[i]);
		}	
		emptyneedle = new ItemTnc();
		biobrain = new ItemBioBrain();
		acidwand = new ItemAcidWand();
	}
	
	public void ItemRegisterInit(){
		
		
		GameRegistry.registerItem(emptyneedle, "EmptyNeedle");
		GameRegistry.registerItem(biobrain, "BioBrain");
		GameRegistry.registerItem(acidwand, "AcidWand");
		
		for(int i=0;i<22;i++)
		{
			GameRegistry.registerItem(bloodgr[i], ItemBs.getxzsmean(i)+"Needle");
			GameRegistry.registerItem(bloodes[i], ItemBloodEssence.getxzsmean(i));
		}
		
		for(int i = 0; i <= 1; i++){
			GameRegistry.registerItem(herbsArray[i], ItemHerbs.getName(i));
		}
	}
		
	}


