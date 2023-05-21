package com.github.tatercertified.elementalistapi.events.impact;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.entity.LivingEntity;

public class Freeze extends BasicSpellEvent {
    private final int time;
    private final LivingEntity hit;
    /**
     * Freezes the hit LivingEntity
     * @param time Time in ticks to freeze
     * @param hit LivingEntity that is freezing
     */
    public Freeze(int time, LivingEntity hit) {
        this.time = time;
        this.hit = hit;
    }

    @Override
    public void event() {
        super.event();
        hit.setFrozenTicks(time);
    }
}
