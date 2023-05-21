package com.github.tatercertified.elementalistapi.events;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class BasicDelayedSpellEvent extends BasicSpellEvent {

    protected ServerPlayerEntity reference;
    protected int start_tick;
    public int end_tick;
    public TargetEntity target;
    public int tick = 0;

    /**
     * Basic Event that all other events should extend for ServerPlayerEntity
     * @param start_tick first tick to activate the event
     * @param duration duration of the event in ticks; 1 for instant
     * @param reference reference for ServerPlayerEntity
     */
    public BasicDelayedSpellEvent(int start_tick, int duration, ServerPlayerEntity reference) {
        this.start_tick = start_tick;
        end_tick = start_tick + duration;
        this.reference = reference;
    }

    /**
     * Basic Event that all other events should extend for TargetEntity
     * @param start_tick first tick to activate the event
     * @param duration duration of the event in ticks; 1 for instant
     */
    public BasicDelayedSpellEvent(int start_tick, int duration) {
        this.start_tick = start_tick;
        end_tick = start_tick + duration;
    }

    /**
     * Main ticking function for all Events
     * @return If the Event has completed
     */
    public boolean tick() {
        if(target != null && target.isRemoved()) {
            finished();
            return true;
        }
        if(tick > end_tick) {
            finished();
           return true;
        }
        if(tick >= start_tick) {
            event();
        }
        tick++;
        return false;
    }

    /**
     * Fired when the Event is finished
     */
    public void finished() {
        //Removed Event
    }

    /**
     * Sets the TargetEntity
     * @param target TargetEntity
     */
    public void addTarget(TargetEntity target) {
        this.target = target;
    }
}
