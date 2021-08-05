package com.LockOriginalMods.refinedforage.init;

import com.LockOriginalMods.refinedforage.recipe.AlloyRecipe;
import com.LockOriginalMods.refinedforage.recipe.AlloyRecipeSerializer;
import com.LockOriginalMods.refinedforage.recipe.IAlloyRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.refinedforage.RefinedForage.MOD_ID;

public class RecipeSerializerInit {

    public static final IRecipeSerializer<AlloyRecipe> ALLOY_RECIPE_SERIALIZER = new AlloyRecipeSerializer();
    public static final IRecipeType<IAlloyRecipe> ALLOY_TYPE = registerType(IAlloyRecipe.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
            ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> ALLOY_SERIALIZER = RECIPE_SERIALIZERS.register("alloy",
            () -> ALLOY_RECIPE_SERIALIZER);

    private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
    }
}