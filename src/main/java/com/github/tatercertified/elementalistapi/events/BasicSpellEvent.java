package com.github.tatercertified.elementalistapi.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;

public class BasicSpellEvent implements Cloneable{
    public Vec3d position;
    public Entity entity;
    public DamageSource source;

    public BasicSpellEvent() {
    }

    @Override
    public BasicSpellEvent clone() {
        try {
            return (BasicSpellEvent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Main Event to fire when conditions are met
     */
    public void event() {
        // Do event here
    }

    /**
     * Common variables in SpellEvents
     */
    public void setPosition(Vec3d position) {
        this.position = position;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setSource(DamageSource source) {
        this.source = source;
    }
}
