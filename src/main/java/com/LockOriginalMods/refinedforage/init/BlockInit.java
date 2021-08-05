package com.LockOriginalMods.refinedforage.init;

import com.LockOriginalMods.refinedforage.bloсks.AlloySmelter;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.refinedforage.RefinedForage.MOD_ID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
       MOD_ID);

    public static final RegistryObject<Block> ALLOY_SMELTER = BLOCKS.register("alloy_smelter",
            () -> new AlloySmelter(Block.Properties.from(Blocks.FURNACE)));
}
