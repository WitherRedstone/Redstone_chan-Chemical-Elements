package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import com.chinaex123.redstone_chemical_elements.register.ElementBlock;
import com.chinaex123.redstone_chemical_elements.register.ElementItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    // 修复1: 添加lookupProvider参数以兼容1.20.1
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;

    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output);
        this.lookupProvider = lookupProvider;
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        // 遍历所有元素，为每个元素生成配方
        for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
            String elementName = ((String) element[0]).toLowerCase();

            // 修复2: 将writer作为RecipeOutput传递，而不是不存在的recipeOutput变量
            generateElementRecipes(elementName, writer);
        }
    }

    /**
     * 生成一个元素的所有配方
     */
    private void generateElementRecipes(String elementName, Consumer<FinishedRecipe> writer) {
        // 获取该元素的所有物品和方块
        Item ingot = ElementItem.getIngot(elementName).get();
        Item nugget = ElementItem.getNugget(elementName).get();
        Item block = ElementBlock.getBlock(elementName).get().asItem();
        Item rawBlock = ElementBlock.getRawBlock(elementName).get().asItem();
        Item rawItem = ElementItem.getRaw(elementName).get();
        Item ore = ElementBlock.getOre(elementName).get().asItem();
        Item deepslateOre = ElementBlock.getDeepslateOre(elementName).get().asItem();
        Item netherOre = ElementBlock.getNetherOre(elementName).get().asItem();
        Item endOre = ElementBlock.getEndOre(elementName).get().asItem();

        // 具体的元素标签
        TagKey<Item> ingotTag = createCommonItemTag("ingots/" + elementName);
        TagKey<Item> nuggetTag = createCommonItemTag("nuggets/" + elementName);
        TagKey<Item> rawMaterialTag = createCommonItemTag("raw_materials/" + elementName);
        TagKey<Item> oreTag = createCommonItemTag("ores/" + elementName);

        // 9个粒合成1个锭
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', nuggetTag)
                .unlockedBy("has_" + elementName + "_nugget", has(nuggetTag))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_nuggets");

        // 9个锭合成1个块
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ingotTag)
                .unlockedBy("has_" + elementName + "_ingot", has(ingotTag))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_block_from_ingots");

        // 1个块分解成9个锭
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(block)
                .unlockedBy("has_" + elementName + "_block", has(block))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingots_from_block");

        // 1个锭分解成9个粒
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
                .requires(ingot)
                .unlockedBy("has_" + elementName + "_ingot", has(ingot))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_nuggets_from_ingot");

        // 9个粗矿合成1个粗矿块
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, rawBlock)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', rawMaterialTag)
                .unlockedBy("has_raw_" + elementName, has(rawMaterialTag))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/raw_" + elementName + "_block_from_items");

        // 1个粗矿块分解成9个粗矿
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, rawItem, 9)
                .requires(rawBlock)
                .unlockedBy("has_raw_" + elementName + "_block", has(rawBlock))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/raw_" + elementName + "_from_block");

        // 烧炼配方 - 粗矿烧炼成锭
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(rawMaterialTag),
                        RecipeCategory.MISC, ingot, 0.5f, 200)
                .unlockedBy("has_raw_" + elementName, has(rawMaterialTag))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_smelting_raw_" + elementName);

        // 高炉烧炼 - 粗矿烧炼成锭
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(rawMaterialTag),
                        RecipeCategory.MISC, ingot, 1.0f, 100)
                .unlockedBy("has_raw_" + elementName, has(rawMaterialTag))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_blasting_raw_" + elementName);

        // 添加使用具体矿石物品的配方
        addSpecificOreSmeltingRecipes(elementName, ingot, ore, deepslateOre, netherOre, endOre, writer);
    }

    /**
     * 为具体矿石添加烧炼配方
     */
    private void addSpecificOreSmeltingRecipes(String elementName, Item ingot, Item ore, Item deepslateOre, Item netherOre, Item endOre, Consumer<FinishedRecipe> writer) {
        Item block = ElementBlock.getBlock(elementName).get().asItem();
        // ========== 熔炉烧炼配方 ==========
        // 普通矿石熔炉烧炼
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ore),
                        RecipeCategory.MISC, ingot, 0.5f, 200)
                .unlockedBy("has_" + elementName + "_ore", has(ore))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_smelting_specific_ore");

        // 深层矿石熔炉烧炼
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(deepslateOre),
                        RecipeCategory.MISC, ingot, 0.5f, 200)
                .unlockedBy("has_deepslate_" + elementName + "_ore", has(deepslateOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_smelting_specific_deepslate_ore");

        // 下界矿石熔炉烧炼
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(netherOre),
                        RecipeCategory.MISC, ingot, 0.5f, 200)
                .unlockedBy("has_nether_" + elementName + "_ore", has(netherOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_smelting_specific_nether_ore");

        // 末地矿石熔炉烧炼
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(endOre),
                        RecipeCategory.MISC, ingot, 0.5f, 200)
                .unlockedBy("has_end_" + elementName + "_ore", has(endOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_smelting_specific_end_ore");

        // 粗矿快熔炉烧炼
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ElementBlock.getRawBlock(elementName).get().asItem()),
                        RecipeCategory.MISC, block, 4.0f, 1800)
                .unlockedBy("has_raw_" + elementName + "_block", has(ElementBlock.getRawBlock(elementName).get()))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_block_from_smelting_raw_block_" + elementName);


        // ========== 高炉烧炼配方 ==========
        // 普通矿石高炉烧炼
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ore),
                        RecipeCategory.MISC, ingot, 1.0f, 100)
                .unlockedBy("has_" + elementName + "_ore", has(ore))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_blasting_specific_ore");

        // 深层矿石高炉烧炼
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(deepslateOre),
                        RecipeCategory.MISC, ingot, 1.0f, 100)
                .unlockedBy("has_deepslate_" + elementName + "_ore", has(deepslateOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_blasting_specific_deepslate_ore");

        // 下界矿石高炉烧炼
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(netherOre),
                        RecipeCategory.MISC, ingot, 1.0f, 100)
                .unlockedBy("has_nether_" + elementName + "_ore", has(netherOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_blasting_specific_nether_ore");

        // 末地矿石高炉烧炼
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(endOre),
                        RecipeCategory.MISC, ingot, 1.0f, 100)
                .unlockedBy("has_end_" + elementName + "_ore", has(endOre))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_ingot_from_blasting_specific_end_ore");

        // 粗矿快高炉烧炼
        SimpleCookingRecipeBuilder.blasting(
                        Ingredient.of(ElementBlock.getRawBlock(elementName).get().asItem()),
                        RecipeCategory.MISC, block, 8.0f, 900)
                .unlockedBy("has_raw_" + elementName + "_block", has(ElementBlock.getRawBlock(elementName).get()))
                .save(writer,
                        RedstonechanChemicalElements.MOD_ID + ":" + elementName + "/" + elementName + "_block_from_blasting_raw_block_" + elementName);
    }

    /**
     * 创建Common Tags物品标签
     */
    private TagKey<Item> createCommonItemTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", path));
    }
}
