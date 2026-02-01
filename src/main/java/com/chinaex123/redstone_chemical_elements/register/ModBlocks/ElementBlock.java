package com.chinaex123.redstone_chemical_elements.register.ModBlocks;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import com.chinaex123.redstone_chemical_elements.register.ModItems.ElementItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ElementBlock {
    // 创建方块注册器实例
    public static final DeferredRegister.Blocks BLOCK_REGISTER =
            DeferredRegister.createBlocks(RedstonechanChemicalElements.MOD_ID);

    // 存储所有注册的方块
    public static final Map<String, DeferredBlock<Block>> BLOCKS = new HashMap<>();
    private static final Map<String, DeferredBlock<Block>> RAW_BLOCKS = new HashMap<>();
    private static final Map<String, DeferredBlock<Block>> ORES = new HashMap<>();
    private static final Map<String, DeferredBlock<Block>> DEEPSLATE_ORES = new HashMap<>();
    private static final Map<String, DeferredBlock<Block>> NETHER_ORES = new HashMap<>();
    private static final Map<String, DeferredBlock<Block>> END_ORES = new HashMap<>();

    // 元素方块数据 [元素名称, 硬度, 抗性]
    public static final Object[][] ELEMENT_BLOCKS = {
            {"hydrogen", 2.4F, 6.0F},
            {"helium", 2.4F, 6.0F},
            {"lithium", 2.4F, 6.0F},
            {"beryllium", 2.4F, 6.0F},
            {"boron", 2.4F, 6.0F},
            {"carbon", 2.4F, 6.0F},
            {"nitrogen", 2.4F, 6.0F},
            {"oxygen", 2.4F, 6.0F},
            {"fluorine", 2.4F, 6.0F},
            {"neon", 2.4F, 6.0F},
            {"sodium", 2.4F, 6.0F},
            {"magnesium", 2.4F, 6.0F},
            {"aluminum", 2.4F, 6.0F},
            {"silicon", 2.4F, 6.0F},
            {"phosphorus", 2.4F, 6.0F},
            {"sulfur", 2.4F, 6.0F},
            {"chlorine", 2.4F, 6.0F},
            {"argon", 2.4F, 6.0F},
            {"potassium", 2.4F, 6.0F},
            {"calcium", 2.4F, 6.0F},
            {"scandium", 2.4F, 6.0F},
            {"titanium", 2.4F, 6.0F},
            {"vanadium", 2.4F, 6.0F},
            {"chromium", 2.4F, 6.0F},
            {"manganese", 2.4F, 6.0F},
            {"iron", 2.4F, 6.0F},
            {"cobalt", 2.4F, 6.0F},
            {"nickel", 2.4F, 6.0F},
            {"copper", 2.4F, 6.0F},
            {"zinc", 2.4F, 6.0F},
            {"gallium", 2.4F, 6.0F},
            {"germanium", 2.4F, 6.0F},
            {"arsenic", 2.4F, 6.0F},
            {"selenium", 2.4F, 6.0F},
            {"bromine", 2.4F, 6.0F},
            {"krypton", 2.4F, 6.0F},
            {"rubidium", 2.4F, 6.0F},
            {"strontium", 2.4F, 6.0F},
            {"yttrium", 2.4F, 6.0F},
            {"zirconium", 2.4F, 6.0F},
            {"niobium", 2.4F, 6.0F},
            {"molybdenum", 2.4F, 6.0F},
            {"technetium", 2.4F, 6.0F},
            {"ruthenium", 2.4F, 6.0F},
            {"rhodium", 2.4F, 6.0F},
            {"palladium", 2.4F, 6.0F},
            {"silver", 2.4F, 6.0F},
            {"cadmium", 2.4F, 6.0F},
            {"indium", 2.4F, 6.0F},
            {"tin", 2.4F, 6.0F},
            {"antimony", 2.4F, 6.0F},
            {"tellurium", 2.4F, 6.0F},
            {"iodine", 2.4F, 6.0F},
            {"xenon", 2.4F, 6.0F},
            {"cesium", 2.4F, 6.0F},
            {"barium", 2.4F, 6.0F},
            {"lanthanum", 2.4F, 6.0F},
            {"cerium", 2.4F, 6.0F},
            {"praseodymium", 2.4F, 6.0F},
            {"neodymium", 2.4F, 6.0F},
            {"promethium", 2.4F, 6.0F},
            {"samarium", 2.4F, 6.0F},
            {"europium", 2.4F, 6.0F},
            {"gadolinium", 2.4F, 6.0F},
            {"terbium", 2.4F, 6.0F},
            {"dysprosium", 2.4F, 6.0F},
            {"holmium", 2.4F, 6.0F},
            {"erbium", 2.4F, 6.0F},
            {"thulium", 2.4F, 6.0F},
            {"ytterbium", 2.4F, 6.0F},
            {"lutetium", 2.4F, 6.0F},
            {"hafnium", 2.4F, 6.0F},
            {"tantalum", 2.4F, 6.0F},
            {"tungsten", 2.4F, 6.0F},
            {"rhenium", 2.4F, 6.0F},
            {"osmium", 2.4F, 6.0F},
            {"iridium", 2.4F, 6.0F},
            {"platinum", 2.4F, 6.0F},
            {"gold", 2.4F, 6.0F},
            {"hydrargyrum", 2.4F, 6.0F},
            {"thallium", 2.4F, 6.0F},
            {"lead", 2.4F, 6.0F},
            {"bismuth", 2.4F, 6.0F},
            {"polonium", 2.4F, 6.0F},
            {"astatine", 2.4F, 6.0F},
            {"radon", 2.4F, 6.0F},
            {"francium", 2.4F, 6.0F},
            {"radium", 2.4F, 6.0F},
            {"actinium", 2.4F, 6.0F},
            {"thorium", 2.4F, 6.0F},
            {"protactinium", 2.4F, 6.0F},
            {"uranium", 2.4F, 6.0F},
            {"neptunium", 2.4F, 6.0F},
            {"plutonium", 2.4F, 6.0F},
            {"americium", 2.4F, 6.0F},
            {"curium", 2.4F, 6.0F},
            {"berkelium", 2.4F, 6.0F},
            {"californium", 2.4F, 6.0F},
            {"einsteinium", 2.4F, 6.0F},
            {"fermium", 2.4F, 6.0F},
            {"mendelevium", 2.4F, 6.0F},
            {"nobelium", 2.4F, 6.0F},
            {"lawrencium", 2.4F, 6.0F},
            {"rutherfordium", 2.4F, 6.0F},
            {"dubnium", 2.4F, 6.0F},
            {"seaborgium", 2.4F, 6.0F},
            {"bohrium", 2.4F, 6.0F},
            {"hassium", 2.4F, 6.0F},
            {"meitnerium", 2.4F, 6.0F},
            {"darmstadtium", 2.4F, 6.0F},
            {"roentgenium", 2.4F, 6.0F},
            {"copernicium", 2.4F, 6.0F},
            {"nihonium", 2.4F, 6.0F},
            {"flerovium", 2.4F, 6.0F},
            {"moscovium", 2.4F, 6.0F},
            {"livermorium", 2.4F, 6.0F},
            {"tennessine", 2.4F, 6.0F},
            {"oganesson", 2.4F, 6.0F},
            {"longium", 2.4F, 6.0F},
            {"mysterium", 2.4F, 6.0F}
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

    // 注册方块并返回引用
    private static DeferredBlock<Block> registerBlockItem(String name, Supplier<Block> blockSupplier) {
        DeferredBlock<Block> block = BLOCK_REGISTER.register(name, blockSupplier);
        // 注册对应的方块物品
        ElementItem.ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // 辅助方法：通过元素名获取方块
    // 矿块
    public static DeferredBlock<Block> getBlock(String elementName) {
        return BLOCKS.get(elementName.toLowerCase());
    }

    // 粗矿块
    public static DeferredBlock<Block> getRawBlock(String elementName) {
        return RAW_BLOCKS.get(elementName.toLowerCase());
    }

    // 矿石
    public static DeferredBlock<Block> getOre(String elementName) {
        return ORES.get(elementName.toLowerCase());
    }

    // 深层矿石
    public static DeferredBlock<Block> getDeepslateOre(String elementName) {
        return DEEPSLATE_ORES.get(elementName.toLowerCase());
    }

    // 下界矿石
    public static DeferredBlock<Block> getNetherOre(String elementName) {
        return NETHER_ORES.get(elementName.toLowerCase());
    }

    // 末地矿石
    public static DeferredBlock<Block> getEndOre(String elementName) {
        return END_ORES.get(elementName.toLowerCase());
    }

    // 注册到游戏
    public static void register(IEventBus eventBus) {
        BLOCK_REGISTER.register(eventBus);
    }

    /*public static final DeferredBlock<Block> ACTINIUM_BLOCK =
            registerBlocks("actinium_block", () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5F, 6.0F)
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()));*/
}
