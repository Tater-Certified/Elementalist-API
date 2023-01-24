package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class Spell1 extends BasicSpell {

    public Spell1(int level, int cooldown, String name, ArrayList<BasicParticle> particleEffects) {
        super(level, cooldown, name, particleEffects);
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
    }
}
