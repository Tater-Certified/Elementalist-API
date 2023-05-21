package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicEntityRainSpell;
import net.minecraft.item.Item;

public class EntityRainTest extends BasicEntityRainSpell {
    public EntityRainTest(int level, int cooldown, String name, Item item, double distance) {
        super(level, cooldown, name, item, distance);
    }
}
