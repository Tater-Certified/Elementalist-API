package com.github.tatercertified.elementalistapi.events;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class BasicSpellEvent {

    protected ServerPlayerEntity reference;
    protected int start_tick;
    public int end_tick;
    public TargetEntity target;
    private int tick = 0;

    /**
     * Basic Event that all other events should extend for ServerPlayerEntity
     * @param start_tick first tick to activate the event
     * @param duration duration of the event in ticks; 1 for instant
     * @param reference reference for ServerPlayerEntity
     */
    public BasicSpellEvent(int start_tick, int duration, ServerPlayerEntity reference) {
        this.start_tick = start_tick;
        end_tick = start_tick + duration;
        this.reference = reference;
    }

    /**
     * Basic Event that all other events should extend for TargetEntity
     * @param start_tick first tick to activate the event
     * @param duration duration of the event in ticks; 1 for instant
     */
    public BasicSpellEvent(int start_tick, int duration) {
        this.start_tick = start_tick;
        end_tick = start_tick + duration;
    }

    /**
     * Main ticking function for all Events
     * @return If the Event has completed
     */
    public boolean tick() {
        if(target != null && target.isRemoved()) {
            return true;
        }
        if(tick > end_tick) {
           return true;
        }
        if(tick >= start_tick) {
            event();
        }
        tick++;
        return false;
    }

    /**
     * Main Event to fire when conditions are met
     */
    public void event() {
        //Main Event
    }

    /**
     * Sets the TargetEntity
     * @param target TargetEntity
     */
    public void addTarget(TargetEntity target) {
        this.target = target;
    }
}
