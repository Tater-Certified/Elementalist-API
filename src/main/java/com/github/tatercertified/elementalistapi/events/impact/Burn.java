package com.github.tatercertified.elementalistapi.events.impact;

import net.minecraft.entity.LivingEntity;

public class Burn {
    /**
     * Sets the hit LivingEntity on fire
     * @param time Time in ticks that the player is on fire
     * @param hit LivingEntity that is on fire
     */
    public Burn(int time, LivingEntity hit) {
        hit.setFireTicks(time);
    }
}
