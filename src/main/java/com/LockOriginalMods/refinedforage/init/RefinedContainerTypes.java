package com.LockOriginalMods.refinedforage.init;

import com.LockOriginalMods.refinedforage.bloсks.AlloySmelterContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.refinedforage.RefinedForage.MOD_ID;

public class RefinedContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
            ForgeRegistries.CONTAINERS, MOD_ID);


    public static final RegistryObject<ContainerType<AlloySmelterContainer>> ALLOY_SMELTER = CONTAINER_TYPES
            .register("alloy_smelter", () -> IForgeContainerType.create(AlloySmelterContainer::new));
}
