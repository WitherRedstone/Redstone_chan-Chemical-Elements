package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.init.RCEBlocks;
import com.chinaex123.redstone_chemical_elements.init.RCEItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    // 修正构造函数参数，移除不需要的registries参数
    public ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // 遍历所有元素
        for (Object[] element : RCEBlocks.ELEMENT_BLOCKS) {
            String elementName = ((String) element[0]).toLowerCase();

            // 直接生成所有方块战利品表
            generateAllBlockLoots(elementName);
        }

        // 为 ELEMENT_ORES 数组的特殊矿石生成战利品表
        for (Object[] oreElement : RCEBlocks.ELEMENT_ORES) {
            String oreName = ((String) oreElement[0]).toLowerCase();

            // 特殊矿石直接掉落自身（不掉落粗矿）
            generateSpecialOreLoots(oreName);
        }
    }

    private void generateAllBlockLoots(String elementName) {
        // 矿块和粗矿块直接掉落自身
        this.dropSelf(RCEBlocks.getBlock(elementName).get());
        this.dropSelf(RCEBlocks.getRawBlock(elementName).get());

        // 所有矿石都使用相同的掉落逻辑
        generateOreLoot(RCEBlocks.getOre(elementName), elementName);
        generateOreLoot(RCEBlocks.getDeepslateOre(elementName), elementName);
        generateOreLoot(RCEBlocks.getNetherOre(elementName), elementName);
        generateOreLoot(RCEBlocks.getEndOre(elementName), elementName);
    }

    private void generateSpecialOreLoots(String oreName) {
        // 为特殊矿石生成战利品表 - 直接掉落自身方块
        // 普通矿石
        this.dropSelf(RCEBlocks.getOre(oreName).get());
        // 深层矿石
        this.dropSelf(RCEBlocks.getDeepslateOre(oreName).get());
        // 下界矿石
        this.dropSelf(RCEBlocks.getNetherOre(oreName).get());
        // 末地矿石
        this.dropSelf(RCEBlocks.getEndOre(oreName).get());
    }

    private void generateOreLoot(RegistryObject<Block> oreBlock, String elementName) {
        Block block = oreBlock.get();
        Item rawItem = RCEItems.getRaw(elementName).get();

        // 使用 createOreDrop 自动处理精准采集和时运
        this.add(block, createOreDrop(block, rawItem));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        Set<Block> allBlocks = new HashSet<>();

        for (Object[] element : RCEBlocks.ELEMENT_BLOCKS) {
            String elementName = ((String) element[0]).toLowerCase();

            // 收集所有方块
            allBlocks.add(RCEBlocks.getBlock(elementName).get());
            allBlocks.add(RCEBlocks.getRawBlock(elementName).get());
            allBlocks.add(RCEBlocks.getOre(elementName).get());
            allBlocks.add(RCEBlocks.getDeepslateOre(elementName).get());
            allBlocks.add(RCEBlocks.getNetherOre(elementName).get());
            allBlocks.add(RCEBlocks.getEndOre(elementName).get());
        }

        // ELEMENT_ORES 的特殊矿石方块
        for (Object[] oreElement : RCEBlocks.ELEMENT_ORES) {
            String oreName = ((String) oreElement[0]).toLowerCase();

            allBlocks.add(RCEBlocks.getOre(oreName).get());
            allBlocks.add(RCEBlocks.getDeepslateOre(oreName).get());
            allBlocks.add(RCEBlocks.getNetherOre(oreName).get());
            allBlocks.add(RCEBlocks.getEndOre(oreName).get());
        }

        return allBlocks;
    }
}
