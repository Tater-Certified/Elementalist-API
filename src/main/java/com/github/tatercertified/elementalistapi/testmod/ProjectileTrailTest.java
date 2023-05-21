package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.impact.Explode;
import com.github.tatercertified.elementalistapi.events.impact.Stun;
import com.github.tatercertified.elementalistapi.particle.functions.Sine;
import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class ProjectileTrailTest extends BasicProjectileSpell {

    public ProjectileTrailTest(int level, int cooldown, String name, double distance, float speed) {
        super(level, cooldown, name, distance, speed);
    }

    @Override
    public void onEntityCollision(ServerPlayerEntity user, LivingEntity damaged) {
        super.onEntityCollision(user, damaged);
        new Stun(100, damaged).event();
    }

    @Override
    public void onBlockCollision(ServerPlayerEntity user, Vec3d location) {
        super.onBlockCollision(user, location);
        new Explode(4.0F, location, user).event();
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new Sine(0, 10000, 0.5, 4, ParticleTypes.SOUL));
    }
}
