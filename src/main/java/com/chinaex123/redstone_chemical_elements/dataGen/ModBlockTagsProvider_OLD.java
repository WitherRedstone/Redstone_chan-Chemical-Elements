package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import com.chinaex123.redstone_chemical_elements.register.ModBlocks.ElementBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider_OLD extends BlockTagsProvider {
    // 普通世界矿石是石头等级的元素
    private static final Set<String> STONE_TOOL_ELEMENTS = new HashSet<>(Arrays.asList(
            "iron", "copper"
    ));

    // 所有矿石都是铁等级的元素（包括铁和铜的下界/末地矿石）
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

    public ModBlockTagsProvider_OLD(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RedstonechanChemicalElements.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        // 创建所有需要的标签
        var pickaxeTag = tag(BlockTags.MINEABLE_WITH_PICKAXE);
        var stoneToolTag = tag(BlockTags.NEEDS_STONE_TOOL);
        var ironToolTag = tag(BlockTags.NEEDS_IRON_TOOL);
        var diamondToolTag = tag(BlockTags.NEEDS_DIAMOND_TOOL);

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

            // 判断元素类型
            if (STONE_TOOL_ELEMENTS.contains(elementName)) {
                // 对于铁和铜：
                // 1. 普通世界矿石、方块和粗矿方块：石头等级
                stoneToolTag.add(block, rawBlock, ore, deepslateOre);
                // 2. 下界矿石和末地矿石：铁等级
                ironToolTag.add(netherOre, endOre);
            } else if (IRON_TOOL_ELEMENTS.contains(elementName)) {
                // 对于铁等级元素：所有方块都需要铁等级
                ironToolTag.add(block, rawBlock, ore, deepslateOre, netherOre, endOre);
            } else {
                // 其他所有元素：钻石等级
                diamondToolTag.add(block, rawBlock, ore, deepslateOre, netherOre, endOre);
            }
        }
    }
}