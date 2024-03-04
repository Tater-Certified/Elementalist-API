package com.github.tatercertified.elementalistapi;

import com.github.tatercertified.elementalistapi.testmod.Wand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ElementalistApi implements ModInitializer {

    @Override
    public void onInitialize() {
        //Test mod
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            Registry.register(Registries.ITEM, new Identifier("elementalist-testmod", "wand"), new Wand(new FabricItemSettings()));
        }
    }
}
