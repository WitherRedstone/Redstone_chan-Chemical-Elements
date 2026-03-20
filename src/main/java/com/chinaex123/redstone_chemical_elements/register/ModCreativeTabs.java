package com.chinaex123.redstone_chemical_elements.register;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
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
                    .icon(() -> new ItemStack(ElementItem.getIngot("neodymium").get()))
                    .title(Component.translatable("itemGroup.element_item_tab"))
                    .displayItems((parameters, output) -> {
                        // 这是各种元素的物品及其衍生物品
                        for (String[] element : ElementItem.ELEMENTS) {
                            String elementName = element[0];

                            // 添加该元素的各种物品形式
                            output.accept(ElementItem.getIngot(elementName).get()); // 锭
                            output.accept(ElementItem.getNugget(elementName).get()); // 粒
                            output.accept(ElementItem.getDust(elementName).get()); // 粉
                            output.accept(ElementItem.getPlate(elementName).get()); // 板
                            output.accept(ElementItem.getRod(elementName).get()); // 棍
                            output.accept(ElementItem.getWire(elementName).get()); // 线
                            output.accept(ElementItem.getGear(elementName).get()); // 齿轮
                            output.accept(ElementItem.getRaw(elementName).get()); // 粗矿
                            output.accept(ElementItem.getCrushedRaw(elementName).get()); // 粉碎粗矿
                        }

                        // 这是各种元素的化学元素气瓶
                        for (String[] cylinder : ElementItem.GAS_ELEMENTS) {
                            String cylinderName = cylinder[0];

                            // 添加该元素的各种形式
                            output.accept(ElementItem.getCylinder(cylinderName).get()); // 元素气体瓶
                        }

                        output.accept(ElementItem.GAS_CYLINDER.get()); // 气瓶
                    })
                    .build());


    // 创造模式物品栏 - 红石酱的化学元素：元素方块
    public static final Supplier<CreativeModeTab> ELEMENT_BLOCK_TAB =
            CREATIVE_MODE_TAB.register("element_block_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ElementBlock.getBlock("neodymium").get()))
                    .title(Component.translatable("itemGroup.element_block_tab"))
                    .displayItems((parameters, output) -> {
                        // 这是各种元素的方块
                        for (Object[] element : ElementBlock.ELEMENT_BLOCKS) {
                            String elementName = (String) element[0];

                            // 添加该元素的各种方块形式
                            output.accept(ElementBlock.getBlock(elementName).get()); // 矿块
                            output.accept(ElementBlock.getRawBlock(elementName).get()); // 粗矿块
                            output.accept(ElementBlock.getOre(elementName).get()); // 矿石
                            output.accept(ElementBlock.getDeepslateOre(elementName).get()); // 深层矿石
                            output.accept(ElementBlock.getNetherOre(elementName).get()); // 下界矿石
                            output.accept(ElementBlock.getEndOre(elementName).get()); // 末地矿石
                        }

                        // 添加 ELEMENT_ORES 中的特殊矿石方块
                        for (Object[] ore : ElementBlock.ELEMENT_ORES) {
                            String oreName = (String) ore[0];

                            // 添加该矿石的各种形式
                            output.accept(ElementBlock.getOre(oreName).get()); // 矿石
                            output.accept(ElementBlock.getDeepslateOre(oreName).get()); // 深层矿石
                            output.accept(ElementBlock.getNetherOre(oreName).get()); // 下界矿石
                            output.accept(ElementBlock.getEndOre(oreName).get()); // 末地矿石
                        }
                    })
                    .build());

    // 注册到NeoForge事件总线里
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
