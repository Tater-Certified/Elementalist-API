package com.github.tatercertified.elementalistapi.events.time;

import com.github.tatercertified.elementalistapi.events.BasicDelayedSpellEvent;
import net.minecraft.entity.Entity;

public class KillTargetEntity extends BasicDelayedSpellEvent {
    /**
     * Kills the TargetEntity on start_tick
     * @param start_tick Which tick to kill the TargetEntity
     * @param duration Currently useless; set to any number
     */
    public KillTargetEntity(int start_tick, int duration) {
        super(start_tick, duration);
    }

    @Override
    public boolean tick() {
        if(tick > start_tick) {
            return true;
        }
        if(tick == start_tick) {
            event();
        }
        tick++;
        return false;
    }

    @Override
    public void event() {
        target.remove(Entity.RemovalReason.DISCARDED);
    }
}
