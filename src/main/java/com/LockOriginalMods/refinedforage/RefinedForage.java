package com.LockOriginalMods.refinedforage;

import com.LockOriginalMods.refinedforage.init.BlockInit;
import com.LockOriginalMods.refinedforage.init.ModTileEntityTypes;
import com.LockOriginalMods.refinedforage.init.RefinedContainerTypes;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
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
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .filter(block ->  !(block instanceof FlowingFluidBlock)
                   )
                .forEach(block -> {
                    final Item.Properties properties = new Item.Properties().group(TutorialItemGroup.instance);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
                });

        LOGGER.debug("Registered BlockItems!");
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
