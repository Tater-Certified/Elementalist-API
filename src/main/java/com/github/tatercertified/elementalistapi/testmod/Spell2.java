package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.impact.Burn;
import com.github.tatercertified.elementalistapi.events.impact.Damage;
import com.github.tatercertified.elementalistapi.events.impact.Stun;
import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;
import net.minecraft.entity.LivingEntity;
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

    @Override
    public void onEntityCollision(ServerPlayerEntity user, LivingEntity damaged) {
        super.onEntityCollision(user, damaged);
        new Stun(100, damaged);
        new Damage(2.0F, damaged, user);
        new Burn(100, damaged);
    }
}
