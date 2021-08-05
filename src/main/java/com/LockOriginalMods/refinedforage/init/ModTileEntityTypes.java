package com.LockOriginalMods.refinedforage.init;

import com.LockOriginalMods.refinedforage.bloсks.AlloySmelterTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.refinedforage.RefinedForage.MOD_ID;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
            ForgeRegistries.TILE_ENTITIES, MOD_ID);


    public static final RegistryObject<TileEntityType<AlloySmelterTileEntity>> ALLOY_SMELTER = TILE_ENTITY_TYPES
            .register("alloy_smelter", () -> TileEntityType.Builder
                    .create(AlloySmelterTileEntity::new, BlockInit.ALLOY_SMELTER.get()).build(null));
}
