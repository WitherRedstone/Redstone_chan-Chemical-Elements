package com.chinaex123.redstone_chemical_elements.dataGen;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Mod.EventBusSubscriber(modid = RedstonechanChemicalElements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // 创建方块标签提供器
        var blockTags = new ModBlockTagsProvider.BlockTags(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);

        // 生成物品标签
        generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider.ItemTags(packOutput, lookupProvider,
                        blockTags.contentsGetter(), existingFileHelper));

        // 注册配方生成器
        generator.addProvider(event.includeServer(), new ModRecipesProvider(packOutput, lookupProvider));

        // 注册战利品表生成器
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(
                        ModBlockLootTablesProvider::new,  // 战利品表生成器
                        LootContextParamSets.BLOCK        // 方块战利品表
                ))
        ));
    }
}
