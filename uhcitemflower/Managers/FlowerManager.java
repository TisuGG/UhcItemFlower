package tissuegg.uhcitemflower.Managers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlowerManager implements Listener {

    private final List<Material> obtainableItems = new ArrayList<>();

    @SuppressWarnings("deprecation")
	public FlowerManager() {
        for (Material material : Material.values()) {
            if (material.isItem() && !material.isLegacy()) {
                if (!isProhibitedMaterial(material)) {
                    obtainableItems.add(material);
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Material blockType = event.getBlock().getType();
        
        if (isFlower(blockType)) {
            event.setDropItems(false);
            
            Random random = new Random();
            Material randomDrop = obtainableItems.get(random.nextInt(obtainableItems.size()));
            
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(randomDrop, 1));
        }
    }

    private boolean isProhibitedMaterial(Material material) {
        return material == Material.BEDROCK ||
               material == Material.BARRIER ||
               material == Material.COMMAND_BLOCK ||
               material == Material.STRUCTURE_BLOCK ||
               material == Material.STRUCTURE_VOID ||
               material == Material.END_PORTAL_FRAME ||
               material == Material.NETHER_PORTAL ||
               material == Material.JIGSAW ||
               material == Material.SPAWNER ||
               material.name().contains("SPAWN_EGG") ||
               material.name().contains("COMMAND_BLOCK") ||
               material.name().contains("AIR");
    }

    private boolean isFlower(Material material) {
        return material.name().contains("FLOWER") ||
               material.name().contains("TULIP") ||
               material.name().contains("DANDELION") ||
               material.name().contains("ALLIUM") ||
               material.name().contains("BLUE_ORCHID") ||
               material.name().contains("OXEYE_DAISY") ||
               material.name().contains("CORNFLOWER") ||
               material.name().contains("POPPY") ||
               material.name().contains("AZURE_BLUET") ||
               material.name().contains("ROSE") ||
               material.name().contains("LILAC") ||
               material.name().contains("LILY_OF_THE_VALLEY");
    }
}
