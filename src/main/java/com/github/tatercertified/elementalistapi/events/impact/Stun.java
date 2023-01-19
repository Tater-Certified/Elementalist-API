package com.github.tatercertified.elementalistapi.events.impact;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Stun {
    /**
     * Freezes the hit LivingEntity
     * @param time Amount of ticks to freeze
     * @param hit LivingEntity that will be frozen
     */
    public Stun(int time, LivingEntity hit) {
        hit.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, time, 50, false, false));
        hit.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, time, 50, false, false));
    }
}
