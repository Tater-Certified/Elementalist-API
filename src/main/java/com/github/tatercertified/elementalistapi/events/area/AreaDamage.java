package com.github.tatercertified.elementalistapi.events.area;

import com.github.tatercertified.elementalistapi.events.impact.Damage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.List;

public class AreaDamage {
    /**
     * Does damage to multiple LivingEntities in a List
     * @param hits List of LivingEntities
     * @param damage Damage dealt to LivingEntities
     * @param user ServerPlayerEntity doing the damage
     */
    public AreaDamage(List<LivingEntity> hits, float damage, ServerPlayerEntity user) {
        for (LivingEntity hit : hits) {
            new Damage(damage, hit, user);
        }
    }

}
