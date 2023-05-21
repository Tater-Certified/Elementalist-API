package com.github.tatercertified.elementalistapi.events.impact;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.server.network.ServerPlayerEntity;

public class Damage {
    /**
     * Damages the specified LivingEntity and counts as a player kill
     * @param dmg Amount of health points to remove
     * @param hit LivingEntity being hit
     * @param attacker Player that used the spell
     */
    public Damage(float dmg, LivingEntity hit, ServerPlayerEntity attacker) {
        hit.damage(hit.getDamageSources().playerAttack(attacker), dmg);
    }

    /**
     * Damages the specified LivingEntity
     * @param dmg Amount of health points to remove
     * @param hit LivingEntity being hit
     */
    public Damage(float dmg, LivingEntity hit) {
        hit.damage(hit.getDamageSources().magic(), dmg);
    }
}
