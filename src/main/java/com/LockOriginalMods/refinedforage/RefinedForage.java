package com.LockOriginalMods.refinedforage;

import com.LockOriginalMods.refinedforage.init.BlockInit;
import com.LockOriginalMods.refinedforage.init.ModTileEntityTypes;
import com.LockOriginalMods.refinedforage.init.RefinedContainerTypes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.LockOriginalMods.refinedforage.RefinedForage.MOD_ID;


@Mod("refinedforage")
@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RefinedForage
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "refinedforage";
    public static RefinedForage instance;

    public RefinedForage() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        RefinedContainerTypes.CONTAINER_TYPES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        instance = this;
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
    public static class TutorialItemGroup extends ItemGroup {
        public static final ItemGroup instance = new TutorialItemGroup(ItemGroup.GROUPS.length, "tutorialtab");

        private TutorialItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.ALLOY_SMELTER.get());
        }
    }
}
