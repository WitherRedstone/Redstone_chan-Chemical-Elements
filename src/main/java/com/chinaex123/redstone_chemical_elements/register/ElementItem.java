package com.chinaex123.redstone_chemical_elements.register;

import com.chinaex123.redstone_chemical_elements.RedstonechanChemicalElements;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;

public class ElementItem {
    public static final DeferredRegister.Items ITEMS_REGISTER =
            DeferredRegister.createItems(RedstonechanChemicalElements.MOD_ID);

    // 存储所有物品的映射
    public static final Map<String, DeferredItem<Item>> INGOTS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> NUGGETS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> DUSTS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> PLATES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> RODS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> WIRES = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> GEARS = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> CRUSHED_RAW = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> RAW = new HashMap<>();
    public static final Map<String, DeferredItem<Item>> CYLINDERS = new HashMap<>();

    // 化学元素物品数组 [名称, 稀有度]
    public static final String[][] ELEMENTS = {
            {"hydrogen", "epic"},         // 氢
            {"helium", "epic"},           // 氦
            {"lithium", "epic"},          // 锂
            {"beryllium", "epic"},        // 铍
            {"boron", "epic"},            // 硼
            {"carbon", "epic"},           // 碳
            {"nitrogen", "epic"},         // 氮
            {"oxygen", "epic"},           // 氧
            {"fluorine", "epic"},         // 氟
            {"neon", "epic"},             // 氖
            {"sodium", "epic"},           // 钠
            {"magnesium", "epic"},        // 镁
            {"aluminum", "epic"},         // 铝
            {"silicon", "epic"},          // 硅
            {"phosphorus", "epic"},       // 磷
            {"sulfur", "epic"},           // 硫
            {"chlorine", "epic"},         // 氯
            {"argon", "epic"},            // 氩
            {"potassium", "epic"},        // 钾
            {"calcium", "epic"},          // 钙
            {"scandium", "epic"},         // 钪
            {"titanium", "epic"},         // 钛
            {"vanadium", "epic"},         // 钒
            {"chromium", "epic"},         // 铬
            {"manganese", "epic"},        // 锰
            {"iron", "epic"},             // 铁
            {"cobalt", "epic"},           // 钴
            {"nickel", "epic"},           // 镍
            {"copper", "epic"},           // 铜
            {"zinc", "epic"},             // 锌
            {"gallium", "epic"},          // 镓
            {"germanium", "epic"},        // 锗
            {"arsenic", "epic"},          // 砷
            {"selenium", "epic"},         // 硒
            {"bromine", "epic"},          // 溴
            {"krypton", "epic"},          // 氪
            {"rubidium", "epic"},         // 铷
            {"strontium", "epic"},        // 锶
            {"yttrium", "epic"},          // 钇
            {"zirconium", "epic"},        // 锆
            {"niobium", "epic"},          // 铌
            {"molybdenum", "epic"},       // 钼
            {"technetium", "epic"},       // 锝
            {"ruthenium", "epic"},        // 钌
            {"rhodium", "epic"},          // 铑
            {"palladium", "epic"},        // 钯
            {"silver", "epic"},           // 银
            {"cadmium", "epic"},          // 镉
            {"indium", "epic"},           // 铟
            {"tin", "epic"},              // 锡
            {"antimony", "epic"},         // 锑
            {"tellurium", "epic"},        // 碲
            {"iodine", "epic"},           // 碘
            {"xenon", "epic"},            // 氙
            {"cesium", "epic"},           // 铯
            {"barium", "epic"},           // 钡
            {"lanthanum", "epic"},        // 镧
            {"cerium", "epic"},           // 铈
            {"praseodymium", "epic"},     // 镨
            {"neodymium", "epic"},        // 钕
            {"promethium", "epic"},       // 钷
            {"samarium", "epic"},         // 钐
            {"europium", "epic"},         // 铕
            {"gadolinium", "epic"},       // 钆
            {"terbium", "epic"},          // 铽
            {"dysprosium", "epic"},       // 镝
            {"holmium", "epic"},          // 钬
            {"erbium", "epic"},           // 铒
            {"thulium", "epic"},          // 铥
            {"ytterbium", "epic"},        // 镱
            {"lutetium", "epic"},         // 镥
            {"hafnium", "epic"},          // 铪
            {"tantalum", "epic"},         // 钽
            {"tungsten", "epic"},         // 钨
            {"rhenium", "epic"},          // 铼
            {"osmium", "epic"},           // 锇
            {"iridium", "epic"},          // 铱
            {"platinum", "epic"},         // 铂
            {"gold", "epic"},             // 金
            {"hydrargyrum", "epic"},      // 汞
            {"thallium", "epic"},         // 铊
            {"lead", "epic"},             // 铅
            {"bismuth", "epic"},          // 铋
            {"polonium", "epic"},         // 钋
            {"astatine", "epic"},         // 砹
            {"radon", "epic"},            // 氡
            {"francium", "epic"},         // 钫
            {"radium", "epic"},           // 镭
            {"actinium", "epic"},         // 锕
            {"thorium", "epic"},          // 钍
            {"protactinium", "epic"},     // 镤
            {"uranium", "epic"},          // 铀
            {"neptunium", "epic"},        // 镎
            {"plutonium", "epic"},        // 钚
            {"americium", "epic"},        // 镅
            {"curium", "epic"},           // 锔
            {"berkelium", "epic"},        // 锫
            {"californium", "epic"},      // 锎
            {"einsteinium", "epic"},      // 锿
            {"fermium", "epic"},          // 镄
            {"mendelevium", "epic"},      // 钔
            {"nobelium", "epic"},         // 锘
            {"lawrencium", "epic"},       // 铹
            {"rutherfordium", "epic"},    // 𬬻
            {"dubnium", "epic"},          // 𬭊
            {"seaborgium", "epic"},       // 𬭳
            {"bohrium", "epic"},          // 𬭛
            {"hassium", "epic"},          // 𬭶
            {"meitnerium", "epic"},       // 鿏
            {"darmstadtium", "epic"},     // 𫟼
            {"roentgenium", "epic"},      // 𬬭
            {"copernicium", "epic"},      // 鿔
            {"nihonium", "epic"},         // 鉨
            {"flerovium", "epic"},        // 鈇
            {"moscovium", "epic"},        // 镆
            {"livermorium", "epic"},      // 鉝
            {"tennessine", "epic"},       // 鿬
            {"oganesson", "epic"},        // 鿫
            {"longium", "epic"},          // 鑨
            {"mysterium", "epic"}         // 镾
    };

    // 气体元素数组 - 只有这些气体元素会注册气瓶
    public static final String[][] GAS_ELEMENTS = {
            {"hydrogen", "epic"},     // 氢气瓶
            {"helium", "epic"},       // 氦气瓶
            {"nitrogen", "epic"},     // 氮气瓶
            {"oxygen", "epic"},       // 氧气瓶
            {"fluorine", "epic"},     // 氟气瓶
            {"neon", "epic"},         // 氖气瓶
            {"chlorine", "epic"},     // 氯气瓶
            {"argon", "epic"},        // 氩气瓶
            {"krypton", "epic"},      // 氪气瓶
            {"xenon", "epic"},        // 氙气瓶
            {"radon", "epic"},        // 氡气瓶
            {"oganesson", "epic"},    // 鿫气瓶
    };

    // 批量注册化学元素物品
    static {
        // 注册所有元素的通用物品
        for (String[] element : ELEMENTS) {
            String name = element[0];
            Rarity rarity = getRarity(element[1]);

            // 修改注册名
            INGOTS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_ingot",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            NUGGETS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_nugget",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            DUSTS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_dust",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            PLATES.put(name, ITEMS_REGISTER.register(name + "/" + name + "_plate",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            RODS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_rod",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            WIRES.put(name, ITEMS_REGISTER.register(name + "/" + name + "_wire",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            GEARS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_gear",
                    () -> new Item(new Item.Properties().rarity(rarity))));

            CRUSHED_RAW.put(name, ITEMS_REGISTER.register(name + "/crushed_raw_" + name,
                    () -> new Item(new Item.Properties().rarity(rarity))));

            RAW.put(name, ITEMS_REGISTER.register(name + "/raw_" + name,
                    () -> new Item(new Item.Properties().rarity(rarity))));
        }

        // 单独注册气瓶（只有气体元素才有气瓶）
        for (String[] gasElement : GAS_ELEMENTS) {
            String name = gasElement[0];
            Rarity rarity = getRarity(gasElement[1]);

            CYLINDERS.put(name, ITEMS_REGISTER.register(name + "/" + name + "_cylinder",
                    () -> new Item(new Item.Properties().rarity(rarity))));
        }
    }

    // 辅助方法：通过元素名获取物品
    // 锭
    public static DeferredItem<Item> getIngot(String elementName) {
        return INGOTS.get(elementName.toLowerCase());
    }
    // 粒
    public static DeferredItem<Item> getNugget(String elementName) {
        return NUGGETS.get(elementName.toLowerCase());
    }
    // 粉
    public static DeferredItem<Item> getDust(String elementName) {
        return DUSTS.get(elementName.toLowerCase());
    }
    // 板
    public static DeferredItem<Item> getPlate(String elementName) {
        return PLATES.get(elementName.toLowerCase());
    }
    // 棍
    public static DeferredItem<Item> getRod(String elementName) {
        return RODS.get(elementName.toLowerCase());
    }
    // 线
    public static DeferredItem<Item> getWire(String elementName) {
        return WIRES.get(elementName.toLowerCase());
    }
    // 齿轮
    public static DeferredItem<Item> getGear(String elementName) {
        return GEARS.get(elementName.toLowerCase());
    }
    // 粗矿
    public static DeferredItem<Item> getRaw(String elementName) {
        return RAW.get(elementName.toLowerCase());
    }
    // 粉碎粗矿
    public static DeferredItem<Item> getCrushedRaw(String elementName) {
        return CRUSHED_RAW.get(elementName.toLowerCase());
    }
    // 气体瓶
    public static DeferredItem<Item> getCylinder(String elementName) {
        return CYLINDERS.get(elementName.toLowerCase());
    }

    // 稀有度转换
    private static Rarity getRarity(String rarity) {
        return switch (rarity.toLowerCase()) {
            case "rare" -> Rarity.RARE;
            case "epic" -> Rarity.EPIC;
            default -> Rarity.EPIC; // 默认使用 EPIC
        };
    }

    // 气瓶
    public static final DeferredItem<Item> GAS_CYLINDER =
            ITEMS_REGISTER.register("gas_cylinder",() -> new Item(new Item.Properties()));

    // 注册到游戏
    public static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }
}