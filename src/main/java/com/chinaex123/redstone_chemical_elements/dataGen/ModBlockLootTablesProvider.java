package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.register.ModBlocks.ElementBlock;
import com.chinaex123.redstone_chemical_elements.register.ModItems.ElementItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // 遍历所有元素
        for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
            String elementName = ((String) element[0]).toLowerCase();

            // 直接生成所有方块战利品表
            generateAllBlockLoots(elementName);
        }
    }

    private void generateAllBlockLoots(String elementName) {
        // 矿块和粗矿块直接掉落自身
        this.dropSelf(ElementBlock.getBlock(elementName).get());
        this.dropSelf(ElementBlock.getRawBlock(elementName).get());

        // 所有矿石都使用相同的掉落逻辑
        generateOreLoot(ElementBlock.getOre(elementName), elementName);
        generateOreLoot(ElementBlock.getDeepslateOre(elementName), elementName);
        generateOreLoot(ElementBlock.getNetherOre(elementName), elementName);
        generateOreLoot(ElementBlock.getEndOre(elementName), elementName);
    }

    private void generateOreLoot(DeferredBlock<Block> oreBlock, String elementName) {
        Block block = oreBlock.get();
        Item rawItem = ElementItem.getRaw(elementName).get();

        // 使用 createOreDrop 自动处理精准采集和时运
        this.add(block, createOreDrop(block, rawItem));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        Set<Block> allBlocks = new HashSet<>();

        for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
            String elementName = ((String) element[0]).toLowerCase();

            // 收集所有方块
            allBlocks.add(ElementBlock.getBlock(elementName).get());
            allBlocks.add(ElementBlock.getRawBlock(elementName).get());
            allBlocks.add(ElementBlock.getOre(elementName).get());
            allBlocks.add(ElementBlock.getDeepslateOre(elementName).get());
            allBlocks.add(ElementBlock.getNetherOre(elementName).get());
            allBlocks.add(ElementBlock.getEndOre(elementName).get());
        }

        return allBlocks;
    }
}