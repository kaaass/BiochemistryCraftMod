package cn.BiochemistryCraft.Block;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.BiochemistryCraft.BiochemistryCraft;
import cn.BiochemistryCraft.Register.BCCRegisterItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockHerbsCorps extends BlockCrops{
	public static final String[] herbsArray = new String[] {"fireGrassCorp","coolGrassCorp"};
	
	@SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
	
	public BlockHerbsCorps(int id){
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        setTickRandomly(true);
        setBlockTextureName(BiochemistryCraft.MODID+":"+herbsArray[id]);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
		if(metadata < 0 || metadata > 1){
			metadata = 1;
		}
		return iconArray[metadata];
	}
	
	public int getRenderType(){
		return 6;
	}
	
	private Item getSeedItem(){
        return BCCRegisterItem.fireGrass;
    }
	
	private Item getCropItem(){
        return getSeedItem();
    }
	
	public Item getItemDropped(int arg0, Random arg1, int arg2){
	    return getSeedItem();
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune){
		ArrayList<ItemStack> ret = new ArrayList();
		ret.add(new ItemStack(getSeedItem(), 1, 0));//give seed
		if (metadata >= 1) {
	    	for (int i = 0; i < 3 + fortune; i++) {
	    		if (world.rand.nextInt(5) <= metadata) {
	    			ret.add(new ItemStack(getSeedItem(), 1, 0));
	    		}
	    	}
	    }
	    return ret;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getItem(World arg0, int arg1, int arg2, int arg3){
	    return getSeedItem();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister arg0){
	    this.iconArray = new IIcon[2];
	    for (int i = 0; i < this.iconArray.length; i++){
	      this.iconArray[i] = arg0.registerIcon(getTextureName() + "_stage_" + i);
	    }
	}
	
	public void updateTick (World world, int x, int y, int z, Random random) {
        if (world.getBlockMetadata(x, y, z) == 1) {
            return;
        }
        if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
            return;
        }
        world.setBlockMetadataWithNotify(x, y, z, 1, 2);
    }
	
	public static String getName(int id){
		return herbsArray[id].substring(0,1).toUpperCase()+herbsArray[id].substring(1,herbsArray[id].length());
	}
}
