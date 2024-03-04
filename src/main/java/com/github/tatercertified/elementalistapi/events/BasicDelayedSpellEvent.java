package com.github.tatercertified.elementalistapi.events;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class BasicDelayedSpellEvent extends BasicTargetedSpellEvent {

    protected int start_tick;
    public int end_tick;
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
     * Basic Event that all other events should extend for Vec3D
     * @param startTick first tick to activate the event
     * @param duration duration of the event in ticks; 1 for instant
     * @param position the position of the spell event
     */
    public BasicDelayedSpellEvent(int startTick, int duration, Vec3d position) {
        this.start_tick = startTick;
        end_tick = start_tick + duration;
        this.setPosition(position);
    }

    /**
     * Main ticking function for all Events
     * @return If the Event has completed
     */
    public boolean tick(Entity user) {
        if((this.reference != null && this.reference.isRemoved()) || (this.target != null && this.target.isRemoved()) ) {
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
     * Gets the position of the Spell
     * @return Vec3D of the position
     */
    public Vec3d getPosition() {
        return this.position;
    }

    /**
     * Gets the position of the reference Entity
     * @return Vec3D of the reference Entity
     */
    public Vec3d getReferencePosition() {
        return this.reference.getPos();
    }

    /**
     * Gets the position of the target Entity
     * @return Vec3D of the TargetEntity
     */
    public Vec3d getTargetPosition() {
        return this.target.getPos();
    }
}
