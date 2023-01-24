package com.github.tatercertified.elementalistapi.events.impact;

import net.minecraft.entity.LivingEntity;

public class Freeze {
    /**
     * Freezes the hit LivingEntity
     * @param time Time in ticks to freeze
     * @param hit LivingEntity that is freezing
     */
    public Freeze(int time, LivingEntity hit) {
        hit.setFrozenTicks(time);
    }

}
