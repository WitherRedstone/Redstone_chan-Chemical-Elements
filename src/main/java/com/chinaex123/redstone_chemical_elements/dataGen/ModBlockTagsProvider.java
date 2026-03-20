package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import com.chinaex123.redstone_chemical_elements.register.ElementBlock;
import com.chinaex123.redstone_chemical_elements.register.ElementItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider {

    // 自定义标签键
    public static final TagKey<Item> WIRES = createCommonItemTag("wires");
    public static final TagKey<Item> GEARS = createCommonItemTag("gears");
    public static final TagKey<Item> RODS = createCommonItemTag("rods");
    public static final TagKey<Item> PLATES = createCommonItemTag("plates");
    public static final TagKey<Item> CRUSHED_RAW_MATERIALS = createCommonItemTag("crushed_raw_materials");

    // 添加更多的Common Tags
    public static final TagKey<Item> STORAGE_BLOCKS_INGOTS = createCommonItemTag("storage_blocks");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW = createCommonItemTag("storage_blocks/raw");

    private static TagKey<Item> createCommonItemTag(String path) {
        // 在1.20.1 Forge中使用forge命名空间而不是c
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", path));
    }

    private static TagKey<Block> createCommonBlockTag(String path) {
        // 在1.20.1 Forge中使用forge命名空间而不是c
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("forge", path));
    }

    // 方块标签 - 合并了挖掘标签和Common Tags
    public static class BlockTags extends BlockTagsProvider {
        // 普通世界矿石是石头等级的元素
        private static final Set<String> STONE_TOOL_ELEMENTS = new HashSet<>(Arrays.asList(
                "iron", "copper"
        ));

        // 所有矿石都是铁等级的元素
        private static final Set<String> IRON_TOOL_ELEMENTS = new HashSet<>(Arrays.asList(
                "gold",         // 金
                "aluminum",     // 铝
                "zinc",         // 锌
                "silver",       // 银
                "tin",          // 锡
                "osmium",       // 锇
                "platinum",     // 铂
                "lead",         // 铅
                "uranium",      // 铀
                "nickel"        // 镍
        ));

        public BlockTags(PackOutput output,
                         CompletableFuture<HolderLookup.Provider> lookupProvider,
                         @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, RedstonechanChemicalElements.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            // 创建所有需要的挖掘标签
            var pickaxeTag = tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE);
            var stoneToolTag = tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL);
            var ironToolTag = tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL);
            var diamondToolTag = tag(net.minecraft.tags.BlockTags.NEEDS_DIAMOND_TOOL);

            // 遍历所有元素
            for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
                String elementName = ((String) element[0]).toLowerCase();

                // 获取当前元素的所有方块
                Block block = ElementBlock.getBlock(elementName).get();
                Block rawBlock = ElementBlock.getRawBlock(elementName).get();
                Block ore = ElementBlock.getOre(elementName).get();
                Block deepslateOre = ElementBlock.getDeepslateOre(elementName).get();
                Block netherOre = ElementBlock.getNetherOre(elementName).get();
                Block endOre = ElementBlock.getEndOre(elementName).get();

                // 所有方块都可被镐挖掘
                pickaxeTag.add(block, rawBlock, ore, deepslateOre, netherOre, endOre);

                // 根据元素名称决定挖掘等级
                if (STONE_TOOL_ELEMENTS.contains(elementName)) {
                    // 对于铁和铜：
                    // 普通世界矿石、方块和粗矿方块：石头等级
                    stoneToolTag.add(block, rawBlock, ore, deepslateOre);
                    // 下界矿石和末地矿石：铁等级
                    ironToolTag.add(netherOre, endOre);
                } else if (IRON_TOOL_ELEMENTS.contains(elementName)) {
                    // 对于铁等级元素：所有方块都需要铁等级
                    ironToolTag.add(block, rawBlock, ore, deepslateOre, netherOre, endOre);
                } else {
                    // 其他所有元素：钻石等级
                    diamondToolTag.add(block, rawBlock, ore, deepslateOre, netherOre, endOre);
                }

                // 通用存储块标签 - forge:storage_blocks
                tag(Tags.Blocks.STORAGE_BLOCKS)
                        .add(block)
                        .add(rawBlock);

                // 具体元素的存储块标签 - forge:storage_blocks/iron
                tag(createCommonBlockTag("storage_blocks/" + elementName))
                        .add(block);

                // 具体元素的粗矿存储块标签 - forge:storage_blocks/raw_iron
                tag(createCommonBlockTag("storage_blocks/raw_" + elementName))
                        .add(rawBlock);

                // 粗矿存储块通用标签 - forge:storage_blocks/raw
                tag(createCommonBlockTag("storage_blocks/raw"))
                        .add(rawBlock);

                // 矿石通用标签 - forge:ores
                tag(Tags.Blocks.ORES)
                        .add(ore)
                        .add(deepslateOre)
                        .add(netherOre)
                        .add(endOre);

                // 具体元素的矿石标签 - forge:ores/iron
                tag(createCommonBlockTag("ores/" + elementName))
                        .add(ore)
                        .add(deepslateOre)
                        .add(netherOre)
                        .add(endOre);

                // 具体元素的普通矿石标签 - forge:ores_in_ground/stone
                tag(createCommonBlockTag("ores_in_ground/stone"))
                        .add(ore);

                // 具体元素的深层矿石标签
                tag(createCommonBlockTag("ores_in_ground/deepslate"))
                        .add(deepslateOre);

                // 具体元素的下界矿石标签
                tag(createCommonBlockTag("ores_in_ground/netherrack"))
                        .add(netherOre);

                // 具体元素的末地矿石标签
                tag(createCommonBlockTag("ores_in_ground/end_stone"))
                        .add(endOre);
            }

            // 为 ELEMENT_ORES 数组的特殊矿石添加标签
            for (Object[] oreElement : ElementBlock.ELEMENT_ORES) {
                String oreName = ((String) oreElement[0]).toLowerCase();

                // 普通矿石 - 名称就是 oreName 本身
                pickaxeTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/" + oreName));
                diamondToolTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/" + oreName));

                // 深层矿石 - deepslate_ 前缀
                pickaxeTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/deepslate_" + oreName));
                diamondToolTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/deepslate_" + oreName));

                // 下界矿石 - nether_ 前缀
                pickaxeTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/nether_" + oreName));
                diamondToolTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/nether_" + oreName));

                // 末地矿石 - end_ 前缀
                pickaxeTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/end_" + oreName));
                diamondToolTag.addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/end_" + oreName));

                // 矿石通用标签 - forge:ores
                tag(Tags.Blocks.ORES)
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/deepslate_" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/nether_" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/end_" + oreName));

                // 具体元素的矿石标签 - forge:ores/lepidolite
                tag(createCommonBlockTag("ores/" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/deepslate_" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/nether_" + oreName))
                        .addOptional(ResourceLocation.fromNamespaceAndPath(RedstonechanChemicalElements.MOD_ID, oreName + "/end_" + oreName));
            }
        }
    }

    // 物品标签 - 为所有衍生物添加 Common Tags
    public static class ItemTags extends ItemTagsProvider {

        public ItemTags(PackOutput output,
                        CompletableFuture<HolderLookup.Provider> lookupProvider,
                        CompletableFuture<TagsProvider.TagLookup<Block>> blockTags,
                        @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, blockTags,
                    RedstonechanChemicalElements.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider provider) {
            for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
                String elementName = ((String) element[0]).toLowerCase();

                // 1. 物品通用标签

                // 锭 -> forge:ingots/
                tag(Tags.Items.INGOTS)
                        .add(ElementItem.getIngot(elementName).get());

                // 具体元素的锭标签 -> forge:ingots/iron
                tag(createCommonItemTag("ingots/" + elementName))
                        .add(ElementItem.getIngot(elementName).get());

                // 粒 -> forge:nuggets/
                tag(Tags.Items.NUGGETS)
                        .add(ElementItem.getNugget(elementName).get());

                // 具体元素的粒标签 -> forge:nuggets/iron
                tag(createCommonItemTag("nuggets/" + elementName))
                        .add(ElementItem.getNugget(elementName).get());

                // 粉 -> forge:dusts/
                tag(Tags.Items.DUSTS)
                        .add(ElementItem.getDust(elementName).get());

                // 具体元素的粉标签 -> forge:dusts/iron
                tag(createCommonItemTag("dusts/" + elementName))
                        .add(ElementItem.getDust(elementName).get());

                // 线 -> forge:wires/
                tag(WIRES)
                        .add(ElementItem.getWire(elementName).get());

                // 具体元素的线标签 -> forge:wires/iron
                tag(createCommonItemTag("wires/" + elementName))
                        .add(ElementItem.getWire(elementName).get());

                // 齿轮 -> forge:gears/
                tag(GEARS)
                        .add(ElementItem.getGear(elementName).get());

                // 具体元素的齿轮标签 -> forge:gears/iron
                tag(createCommonItemTag("gears/" + elementName))
                        .add(ElementItem.getGear(elementName).get());

                // 棍 -> forge:rods/
                tag(RODS)
                        .add(ElementItem.getRod(elementName).get());

                // 具体元素的棍标签 -> forge:rods/iron
                tag(createCommonItemTag("rods/" + elementName))
                        .add(ElementItem.getRod(elementName).get());

                // 板 -> forge:plates/
                tag(PLATES)
                        .add(ElementItem.getPlate(elementName).get());

                // 具体元素的板标签 -> forge:plates/iron
                tag(createCommonItemTag("plates/" + elementName))
                        .add(ElementItem.getPlate(elementName).get());

                // 粗矿 -> forge:raw_materials/
                tag(Tags.Items.RAW_MATERIALS)
                        .add(ElementItem.getRaw(elementName).get());

                // 具体元素的粗矿标签 -> forge:raw_materials/iron
                tag(createCommonItemTag("raw_materials/" + elementName))
                        .add(ElementItem.getRaw(elementName).get());

                // 粉碎粗矿 -> forge:crushed_raw_materials/
                tag(CRUSHED_RAW_MATERIALS)
                        .add(ElementItem.getCrushedRaw(elementName).get());

                // 具体元素的粉碎粗矿标签 -> forge:crushed_raw_materials/iron
                tag(createCommonItemTag("crushed_raw_materials/" + elementName))
                        .add(ElementItem.getCrushedRaw(elementName).get());

                // 2. 存储块物品标签

                // 通用存储块标签 - forge:storage_blocks
                tag(STORAGE_BLOCKS_INGOTS)
                        .add(ElementBlock.getBlock(elementName).get().asItem());

                // 具体元素存储块标签 - forge:storage_blocks/iron
                tag(createCommonItemTag("storage_blocks/" + elementName))
                        .add(ElementBlock.getBlock(elementName).get().asItem());

                // 粗矿存储块通用标签 - forge:storage_blocks/raw
                tag(STORAGE_BLOCKS_RAW)
                        .add(ElementBlock.getRawBlock(elementName).get().asItem());

                // 具体元素粗矿存储块标签 - forge:storage_blocks/raw_iron
                tag(createCommonItemTag("storage_blocks/raw_" + elementName))
                        .add(ElementBlock.getRawBlock(elementName).get().asItem());
            }
        }
    }
}
