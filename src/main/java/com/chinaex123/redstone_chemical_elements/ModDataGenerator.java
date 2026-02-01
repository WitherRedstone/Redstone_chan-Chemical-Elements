package com.chinaex123.redstone_chemical_elements;

import com.chinaex123.redstone_chemical_elements.dataGen.ModBlockLootTablesProvider;
import com.chinaex123.redstone_chemical_elements.dataGen.ModBlockTagsProvider_OLD;
import com.chinaex123.redstone_chemical_elements.dataGen.ModCommonTags;
import com.chinaex123.redstone_chemical_elements.dataGen.ModRecipesProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = RedstonechanChemicalElements.MOD_ID)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();


        // 创建方块标签提供器
        var blockTags = new ModCommonTags.BlockTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);

        // 生成物品标签
        generator.addProvider(event.includeServer(),
                new ModCommonTags.ItemTags(packOutput, lookupProvider,
                        blockTags.contentsGetter(), existingFileHelper));

        // 注册配方生成器
        generator.addProvider(event.includeServer(), new ModRecipesProvider(packOutput, lookupProvider));

        // 注册战利品表生成器
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(
                        ModBlockLootTablesProvider::new,  // 你的战利品表生成器
                        LootContextParamSets.BLOCK        // 方块战利品表
                )), lookupProvider));

    }
}