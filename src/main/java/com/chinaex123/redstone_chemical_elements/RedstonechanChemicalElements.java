package com.chinaex123.redstone_chemical_elements;

//import com.chinaex123.redstone_chemical_elements.dataGen.ModDataGenerator;
import com.chinaex123.redstone_chemical_elements.register.ElementBlock;
import com.chinaex123.redstone_chemical_elements.register.ModCreativeTabs;
import com.chinaex123.redstone_chemical_elements.register.ElementItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

// 这里的值应与 META-INF/mods.toml 文件中的条目对应
@Mod(RedstonechanChemicalElements.MOD_ID)
public class RedstonechanChemicalElements {
    // 在公共位置定义模组ID，供所有地方引用
    public static final String MOD_ID = "redstone_chemical_elements";
    // 直接引用 slf4j 日志记录器
    public static final Logger LOGGER = LogUtils.getLogger();

    // 模组类的构造函数是模组加载时运行的第一段代码
    // FML 会自动识别某些参数类型（如 IEventBus 或 ModContainer）并传入
    public RedstonechanChemicalElements(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // 为模组加载注册 commonSetup 方法
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // 将物品注册到游戏
        ModCreativeTabs.register(modEventBus); // 创造模式物品栏

        ElementBlock.register(modEventBus); // 方块 - 所有类型的元素方块
        ElementItem.register(modEventBus); // 物品 - 所有类型的元素物品及其衍生物品

        // 在构造完成后注册数据生成器
        modEventBus.addListener(this::onConstructMod);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // 通用设置逻辑
    }

    private void onConstructMod(final FMLConstructModEvent event) {
        // 在模组构造完成后注册数据生成器
    }

    // 可以使用 @SubscribeEvent 并让事件总线自动发现要调用的方法
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // 服务器启动时执行某些操作
        LOGGER.info("HELLO from server starting");
    }
}
