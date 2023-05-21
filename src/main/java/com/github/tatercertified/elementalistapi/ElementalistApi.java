package com.github.tatercertified.elementalistapi;

import com.github.tatercertified.elementalistapi.testmod.Wand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ElementalistApi implements ModInitializer {

    public final Item WAND = new Wand(new FabricItemSettings());

    @Override
    public void onInitialize() {

        //Test mod
        Registry.register(Registries.ITEM, new Identifier("elementalist-testmod", "wand"), WAND);
    }
}
