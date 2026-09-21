package com.chinaex123.redstone_chemical_elements;

import com.chinaex123.redstone_chemical_elements.init.RCEBlocks;
import com.chinaex123.redstone_chemical_elements.init.RCEItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

// 模组创造模式标签页注册类
public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedstonechanChemicalElements.MOD_ID);

    // 创造模式物品栏 - 红石酱的化学元素：元素物品
    public static final Supplier<CreativeModeTab> ELEMENT_ITEM_TAB =
            CREATIVE_MODE_TAB.register("element_item_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RCEItems.getIngot("neodymium").get()))
                    .title(Component.translatable("itemGroup.element_item_tab"))
                    .displayItems((parameters, output) -> {
                        // 这是各种元素的物品及其衍生物品
                        for (String[] element : RCEItems.ELEMENTS) {
                            String elementName = element[0];

                            // 添加该元素的各种物品形式
                            output.accept(RCEItems.getIngot(elementName).get()); // 锭
                            output.accept(RCEItems.getNugget(elementName).get()); // 粒
                            output.accept(RCEItems.getDust(elementName).get()); // 粉
                            output.accept(RCEItems.getPlate(elementName).get()); // 板
                            output.accept(RCEItems.getRod(elementName).get()); // 棍
                            output.accept(RCEItems.getWire(elementName).get()); // 线
                            output.accept(RCEItems.getGear(elementName).get()); // 齿轮
                            output.accept(RCEItems.getRaw(elementName).get()); // 粗矿
                            output.accept(RCEItems.getCrushedRaw(elementName).get()); // 粉碎粗矿
                        }

                        // 这是各种元素的化学元素气瓶
                        for (String[] cylinder : RCEItems.GAS_ELEMENTS) {
                            String cylinderName = cylinder[0];

                            // 添加该元素的各种形式
                            output.accept(RCEItems.getCylinder(cylinderName).get()); // 元素气体瓶
                        }

                        output.accept(RCEItems.GAS_CYLINDER.get()); // 气瓶
                    })
                    .build());


    // 创造模式物品栏 - 红石酱的化学元素：元素方块
    public static final Supplier<CreativeModeTab> ELEMENT_BLOCK_TAB =
            CREATIVE_MODE_TAB.register("element_block_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(RCEBlocks.getBlock("neodymium").get()))
                    .title(Component.translatable("itemGroup.element_block_tab"))
                    .displayItems((parameters, output) -> {
                        // 这是各种元素的方块
                        for (Object[] element : RCEBlocks.ELEMENT_BLOCKS) {
                            String elementName = (String) element[0];

                            // 添加该元素的各种方块形式
                            output.accept(RCEBlocks.getBlock(elementName).get()); // 矿块
                            output.accept(RCEBlocks.getRawBlock(elementName).get()); // 粗矿块
                            output.accept(RCEBlocks.getOre(elementName).get()); // 矿石
                            output.accept(RCEBlocks.getDeepslateOre(elementName).get()); // 深层矿石
                            output.accept(RCEBlocks.getNetherOre(elementName).get()); // 下界矿石
                            output.accept(RCEBlocks.getEndOre(elementName).get()); // 末地矿石
                        }

                        // 添加 ELEMENT_ORES 中的特殊矿石方块
                        for (Object[] ore : RCEBlocks.ELEMENT_ORES) {
                            String oreName = (String) ore[0];

                            // 添加该矿石的各种形式
                            output.accept(RCEBlocks.getOre(oreName).get()); // 矿石
                            output.accept(RCEBlocks.getDeepslateOre(oreName).get()); // 深层矿石
                            output.accept(RCEBlocks.getNetherOre(oreName).get()); // 下界矿石
                            output.accept(RCEBlocks.getEndOre(oreName).get()); // 末地矿石
                        }
                    })
                    .build());

    // 注册到NeoForge事件总线里
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
