package com.chinaex123.redstone_chemical_elements;

import com.chinaex123.redstone_chemical_elements.init.RCEBlocks;
import com.chinaex123.redstone_chemical_elements.init.RCEItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RedstonechanChemicalElements.MOD_ID)
public class RedstonechanChemicalElements {
    public static final String MOD_ID = "redstone_chemical_elements";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RedstonechanChemicalElements(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeTabs.register(modEventBus);
        RCEBlocks.register(modEventBus);
        RCEItems.register(modEventBus);
    }
}
