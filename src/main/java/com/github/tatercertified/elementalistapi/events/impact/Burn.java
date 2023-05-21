package com.github.tatercertified.elementalistapi.events.impact;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.entity.LivingEntity;

public class Burn extends BasicSpellEvent {
    private final int time;
    private final LivingEntity hit;
    /**
     * Sets the hit LivingEntity on fire
     * @param time Time in ticks that the player is on fire
     * @param hit LivingEntity that is on fire
     */
    public Burn(int time, LivingEntity hit) {
        this.time = time;
        this.hit = hit;
    }

    @Override
    public void event() {
        super.event();
        hit.setFireTicks(time);
    }
}
