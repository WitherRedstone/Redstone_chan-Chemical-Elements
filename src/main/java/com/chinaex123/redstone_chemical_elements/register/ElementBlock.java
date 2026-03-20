package com.chinaex123.redstone_chemical_elements.register;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ElementBlock {
    // 创建方块注册器实例
    public static final DeferredRegister<Block> BLOCK_REGISTER =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RedstonechanChemicalElements.MOD_ID);

    // 存储所有注册的方块
    public static final Map<String, RegistryObject<Block>> BLOCKS = new HashMap<>();
    private static final Map<String, RegistryObject<Block>> RAW_BLOCKS = new HashMap<>();
    private static final Map<String, RegistryObject<Block>> ORES = new HashMap<>();
    private static final Map<String, RegistryObject<Block>> DEEPSLATE_ORES = new HashMap<>();
    private static final Map<String, RegistryObject<Block>> NETHER_ORES = new HashMap<>();
    private static final Map<String, RegistryObject<Block>> END_ORES = new HashMap<>();

    // 元素方块数据 [元素名称, 硬度, 抗性]
    public static final Object[][] ELEMENT_BLOCKS = {
            {"hydrogen", 2.4F, 6.0F}, // 氢
            {"helium", 2.4F, 6.0F}, // 氦
            {"lithium", 2.4F, 6.0F}, // 锂
            {"beryllium", 2.4F, 6.0F}, // 铍
            {"boron", 2.4F, 6.0F}, // 硼
            {"carbon", 2.4F, 6.0F}, // 碳
            {"nitrogen", 2.4F, 6.0F}, // 氮
            {"oxygen", 2.4F, 6.0F}, // 氧
            {"fluorine", 2.4F, 6.0F}, // 氟
            {"neon", 2.4F, 6.0F}, // 氖
            {"sodium", 2.4F, 6.0F}, // 钠
            {"magnesium", 2.4F, 6.0F}, // 镁
            {"aluminum", 2.4F, 6.0F}, // 铝
            {"silicon", 2.4F, 6.0F}, // 硅
            {"phosphorus", 2.4F, 6.0F}, // 磷
            {"sulfur", 2.4F, 6.0F}, // 硫
            {"chlorine", 2.4F, 6.0F}, // 氯
            {"argon", 2.4F, 6.0F}, // 氩
            {"potassium", 2.4F, 6.0F}, // 钾
            {"calcium", 2.4F, 6.0F}, // 钙
            {"scandium", 2.4F, 6.0F}, // 钪
            {"titanium", 2.4F, 6.0F}, // 钛
            {"vanadium", 2.4F, 6.0F}, // 钒
            {"chromium", 2.4F, 6.0F}, // 铬
            {"manganese", 2.4F, 6.0F}, // 锰
            {"iron", 2.4F, 6.0F}, // 铁
            {"cobalt", 2.4F, 6.0F}, // 钴
            {"nickel", 2.4F, 6.0F}, // 镍
            {"copper", 2.4F, 6.0F}, // 铜
            {"zinc", 2.4F, 6.0F}, // 锌
            {"gallium", 2.4F, 6.0F}, // 镓
            {"germanium", 2.4F, 6.0F}, // 锗
            {"arsenic", 2.4F, 6.0F}, // 砷
            {"selenium", 2.4F, 6.0F}, // 硒
            {"bromine", 2.4F, 6.0F}, // 溴
            {"krypton", 2.4F, 6.0F}, // 氪
            {"rubidium", 2.4F, 6.0F}, // 铷
            {"strontium", 2.4F, 6.0F}, // 锶
            {"yttrium", 2.4F, 6.0F}, // 钇
            {"zirconium", 2.4F, 6.0F}, // 锆
            {"niobium", 2.4F, 6.0F}, // 铌
            {"molybdenum", 2.4F, 6.0F}, // 钼
            {"technetium", 2.4F, 6.0F}, // 锝
            {"ruthenium", 2.4F, 6.0F}, // 钌
            {"rhodium", 2.4F, 6.0F}, // 铑
            {"palladium", 2.4F, 6.0F}, // 钯
            {"silver", 2.4F, 6.0F}, // 银
            {"cadmium", 2.4F, 6.0F}, // 镉
            {"indium", 2.4F, 6.0F}, // 铟
            {"tin", 2.4F, 6.0F}, // 锡
            {"antimony", 2.4F, 6.0F}, // 锑
            {"tellurium", 2.4F, 6.0F}, // 碲
            {"iodine", 2.4F, 6.0F}, // 碘
            {"xenon", 2.4F, 6.0F}, // 氙
            {"cesium", 2.4F, 6.0F}, // 铯
            {"barium", 2.4F, 6.0F}, // 钡
            {"lanthanum", 2.4F, 6.0F}, // 镧
            {"cerium", 2.4F, 6.0F}, // 铈
            {"praseodymium", 2.4F, 6.0F}, // 镨
            {"neodymium", 2.4F, 6.0F}, // 钕
            {"promethium", 2.4F, 6.0F}, // 钷
            {"samarium", 2.4F, 6.0F}, // 钐
            {"europium", 2.4F, 6.0F}, // 铕
            {"gadolinium", 2.4F, 6.0F}, // 钆
            {"terbium", 2.4F, 6.0F}, // 铽
            {"dysprosium", 2.4F, 6.0F}, // 镝
            {"holmium", 2.4F, 6.0F}, // 钬
            {"erbium", 2.4F, 6.0F}, // 铒
            {"thulium", 2.4F, 6.0F}, // 铥
            {"ytterbium", 2.4F, 6.0F}, // 镱
            {"lutetium", 2.4F, 6.0F}, // 镥
            {"hafnium", 2.4F, 6.0F}, // 铪
            {"tantalum", 2.4F, 6.0F}, // 钽
            {"tungsten", 2.4F, 6.0F}, // 钨
            {"rhenium", 2.4F, 6.0F}, // 铼
            {"osmium", 2.4F, 6.0F}, // 锇
            {"iridium", 2.4F, 6.0F}, // 铱
            {"platinum", 2.4F, 6.0F}, // 铂
            {"gold", 2.4F, 6.0F}, // 金
            {"hydrargyrum", 2.4F, 6.0F}, // 汞
            {"thallium", 2.4F, 6.0F}, // 铊
            {"lead", 2.4F, 6.0F}, // 铅
            {"bismuth", 2.4F, 6.0F}, // 铋
            {"polonium", 2.4F, 6.0F}, // 钋
            {"astatine", 2.4F, 6.0F}, // 砹
            {"radon", 2.4F, 6.0F}, // 氡
            {"francium", 2.4F, 6.0F}, // 钫
            {"radium", 2.4F, 6.0F}, // 镭
            {"actinium", 2.4F, 6.0F}, // 锕
            {"thorium", 2.4F, 6.0F}, // 钍
            {"protactinium", 2.4F, 6.0F}, // 镤
            {"uranium", 2.4F, 6.0F}, // 铀
            {"neptunium", 2.4F, 6.0F}, // 镎
            {"plutonium", 2.4F, 6.0F}, // 钚
            {"americium", 2.4F, 6.0F}, // 镅
            {"curium", 2.4F, 6.0F}, // 锔
            {"berkelium", 2.4F, 6.0F}, // 锫
            {"californium", 2.4F, 6.0F}, // 锎
            {"einsteinium", 2.4F, 6.0F}, // 锿
            {"fermium", 2.4F, 6.0F}, // 镄
            {"mendelevium", 2.4F, 6.0F}, // 钔
            {"nobelium", 2.4F, 6.0F}, // 锘
            {"lawrencium", 2.4F, 6.0F}, // 铹
            {"rutherfordium", 2.4F, 6.0F}, // 𬬻
            {"dubnium", 2.4F, 6.0F}, // 𬭊
            {"seaborgium", 2.4F, 6.0F}, // 𬭳
            {"bohrium", 2.4F, 6.0F}, // 𬭛
            {"hassium", 2.4F, 6.0F}, // 𬭶
            {"meitnerium", 2.4F, 6.0F}, // 鿏
            {"darmstadtium", 2.4F, 6.0F}, // 𬭊
            {"roentgenium", 2.4F, 6.0F}, // 𬬭
            {"copernicium", 2.4F, 6.0F}, // 鎶
            {"nihonium", 2.4F, 6.0F}, // 鿭
            {"flerovium", 2.4F, 6.0F}, // 𫓧
            {"moscovium", 2.4F, 6.0F}, // 镆
            {"livermorium", 2.4F, 6.0F}, // 𫟷
            {"tennessine", 2.4F, 6.0F}, // 鿬
            {"oganesson", 2.4F, 6.0F}, // 鿫
            {"longium", 2.4F, 6.0F}, // 鑨
            {"mysterium", 2.4F, 6.0F} // 镾
    };

    // 批量注册所有方块
    static {
        for (Object[] element : ELEMENT_BLOCKS) {
            String name = (String) element[0];
            float hardness = (Float) element[1];
            float resistance = (Float) element[2];

            // 注册元素的所有方块类型
            registerElementBlocks(name, hardness, resistance);
        }
    }

    // 注册单个元素的所有方块类型
    private static void registerElementBlocks(String element, float hardness, float resistance) {
        String elementName = element.toLowerCase();

        // 矿块
        BLOCKS.put(elementName, registerBlockItem(element + "/" + element + "_block",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.METAL)
                        .requiresCorrectToolForDrops())));

        // 粗矿块
        RAW_BLOCKS.put(elementName, registerBlockItem(element + "/raw_" + element + "_block",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 矿石
        ORES.put(elementName, registerBlockItem(element + "/" + element + "_ore",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 深层矿石
        DEEPSLATE_ORES.put(elementName, registerBlockItem(element + "/deepslate_" + element + "_ore",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 下界矿石
        NETHER_ORES.put(elementName, registerBlockItem(element + "/nether_" + element + "_ore",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 末地矿石
        END_ORES.put(elementName, registerBlockItem(element + "/end_" + element + "_ore",
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));
    }


    // 特定方块的矿石数据 [元素名称, 硬度, 抗性]
    public static final Object[][] ELEMENT_ORES = {
            {"lepidolite", 2.4F, 6.0F}, // 锂云母
            {"beryl", 2.4F, 6.0F}, // 绿柱石
            {"borax", 2.4F, 6.0F}, // 硼砂
            {"magnesite", 2.4F, 6.0F}, // 菱镁矿
            {"nitre", 2.4F, 6.0F}, // 硝石
            {"apatite", 2.4F, 6.0F}, // 磷灰石
            {"monazite", 2.4F, 6.0F}, // 独居石
            {"cinnabar", 2.4F, 6.0F}, // 朱砂
            {"sylvite", 2.4F, 6.0F}, // 钾石盐
            {"thortveitite", 2.4F, 6.0F}, // 钪钇石
            {"tilmenite", 2.4F, 6.0F}, // 钛铁矿
            {"patronite", 2.4F, 6.0F}, // 绿硫钒矿
            {"chromite", 2.4F, 6.0F}, // 铬铁矿
            {"pyrolusite", 2.4F, 6.0F}, // 软锰矿
            {"argyrodite", 2.4F, 6.0F}, // 硫锗矿
            {"arsenopyrite", 2.4F, 6.0F}, // 毒砂
            {"carnallite", 2.4F, 6.0F}, // 光卤石
            {"celestine", 2.4F, 6.0F}, // 天青石
            {"cobaltite", 2.4F, 6.0F}, // 辉钴矿
            {"zircon", 2.4F, 6.0F}, // 锆英砂
            {"niobite", 2.4F, 6.0F}, // 铌铁矿
            {"molybdenite", 2.4F, 6.0F}, // 辉钼矿
            {"stibnite", 2.4F, 6.0F}, // 辉锑矿
            {"pollucite", 2.4F, 6.0F}, // 铯沸石
            {"barite", 2.4F, 6.0F}, // 重晶石
            {"pyrite", 2.4F, 6.0F} // 黄铁矿
    };

    static {
        for (Object[] element : ELEMENT_ORES) {
            String name = (String) element[0];
            float hardness = (Float) element[1];
            float resistance = (Float) element[2];

            // 注册元素的所有方块类型
            registerElementOres(name, hardness, resistance);
        }
    }

    private static void registerElementOres(String element, float hardness, float resistance) {
        String elementName = element.toLowerCase();

        // 矿石
        ORES.put(elementName, registerBlockItem(element + "/" + element,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 深层矿石
        DEEPSLATE_ORES.put(elementName, registerBlockItem(element + "/deepslate_" + element,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 下界矿石
        NETHER_ORES.put(elementName, registerBlockItem(element + "/nether_" + element,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));

        // 末地矿石
        END_ORES.put(elementName, registerBlockItem(element + "/end_" + element,
                () -> new Block(BlockBehaviour.Properties.of()
                        .strength(hardness, resistance)
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .requiresCorrectToolForDrops())));
    }

    // 注册方块并返回引用
    private static RegistryObject<Block> registerBlockItem(String name, Supplier<Block> blockSupplier) {
        RegistryObject<Block> block = BLOCK_REGISTER.register(name, blockSupplier);
        // 注册对应的方块物品
        ElementItem.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // 辅助方法：通过元素名获取方块
    // 矿块
    public static RegistryObject<Block> getBlock(String elementName) {
        return BLOCKS.get(elementName.toLowerCase());
    }

    // 粗矿块
    public static RegistryObject<Block> getRawBlock(String elementName) {
        return RAW_BLOCKS.get(elementName.toLowerCase());
    }

    // 矿石
    public static RegistryObject<Block> getOre(String elementName) {
        return ORES.get(elementName.toLowerCase());
    }

    // 深层矿石
    public static RegistryObject<Block> getDeepslateOre(String elementName) {
        return DEEPSLATE_ORES.get(elementName.toLowerCase());
    }

    // 下界矿石
    public static RegistryObject<Block> getNetherOre(String elementName) {
        return NETHER_ORES.get(elementName.toLowerCase());
    }

    // 末地矿石
    public static RegistryObject<Block> getEndOre(String elementName) {
        return END_ORES.get(elementName.toLowerCase());
    }

    // 注册到游戏
    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }
}
