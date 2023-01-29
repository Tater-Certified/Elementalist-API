package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.impact.Stun;
import com.github.tatercertified.elementalistapi.particle.functions.Linear;
import com.github.tatercertified.elementalistapi.spell.BasicRapidFireSpell;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;

public class RapidPTrailTest extends BasicRapidFireSpell {
    public RapidPTrailTest(int level, int cooldown, String name, double distance, float speed, int count, int fire_delay) {
        super(level, cooldown, name, distance, speed, count, fire_delay);
    }

    @Override
    public void onEntityCollision(ServerPlayerEntity user, LivingEntity damaged) {
        super.onEntityCollision(user, damaged);
        new Stun(60, damaged);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new Linear(0, 10000, ParticleTypes.ELECTRIC_SPARK));
    }
}
