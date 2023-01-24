package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.impact.Explode;
import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.ArrayList;

public class Spell4 extends BasicProjectileSpell {
    public Spell4(int level, int cooldown, String name, double distance, float speed, ArrayList<BasicParticle> particleEffects) {
        super(level, cooldown, name, distance, speed, particleEffects);
    }

    @Override
    public void onBlockCollision(ServerPlayerEntity user, Vec3d location) {
        super.onBlockCollision(user, location);
        new Explode(4.00F, location, user);
    }
}
