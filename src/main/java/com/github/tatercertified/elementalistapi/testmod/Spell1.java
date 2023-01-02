package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class Spell1 extends BasicSpell {

    public Spell1(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
    }
}
