package com.chinaex123.redstone_chemical_elements;

import com.chinaex123.redstone_chemical_elements.register.ModBlocks.ElementBlock;
import com.chinaex123.redstone_chemical_elements.register.ModCreativeTabs;
import com.chinaex123.redstone_chemical_elements.register.ModItems.ElementItem;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// 这里的值应与 META-INF/neoforge.mods.toml 文件中的条目对应
@Mod(RedstonechanChemicalElements.MOD_ID)
public class RedstonechanChemicalElements {
    // 在公共位置定义模组ID，供所有地方引用
    public static final String MOD_ID = "redstone_chemical_elements";
    // 直接引用 slf4j 日志记录器
    public static final Logger LOGGER = LogUtils.getLogger();

    // 模组类的构造函数是模组加载时运行的第一段代码
    // FML 会自动识别某些参数类型（如 IEventBus 或 ModContainer）并传入
    public RedstonechanChemicalElements(IEventBus modEventBus, ModContainer modContainer) {
        // 为模组加载注册 commonSetup 方法
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        // 将物品注册到游戏
        ModCreativeTabs.register(modEventBus); // 创造模式物品栏

        ElementBlock.register(modEventBus); // 方块 - 所有类型的元素方块
        ElementItem.register(modEventBus); // 物品 - 所有类型的元素物品及其衍生物品
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // 通用设置逻辑
    }

    // 可以使用 @SubscribeEvent 并让事件总线自动发现要调用的方法
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // 服务器启动时执行某些操作
        LOGGER.info("HELLO from server starting");
    }
}
