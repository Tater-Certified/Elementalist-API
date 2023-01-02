package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class Spell2 extends BasicProjectileSpell {


    public Spell2(int level, int cooldown, String name, double distance, float speed) {
        super(level, cooldown, name, distance, speed);
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
    }
}
