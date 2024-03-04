package com.github.tatercertified.elementalistapi.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.Vec3d;

public class BasicSpellEvent implements Cloneable {
    public Vec3d position;
    public Entity reference;
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
     * Sets the Position where the Event will occur
     * @param position Vec3D of Position
     */
    public void setPosition(Vec3d position) {
        this.position = position;
    }

    /**
     * Sets the reference Entity of the spell.
     * This entity is usually the user of the Summoner item
     * @param entity reference Entity
     */
    public void setReference(Entity entity) {
        this.reference = entity;
    }

    /**
     * Sets the DamageSource of the Event
     * @param source DamageSource
     */
    public void setSource(DamageSource source) {
        this.source = source;
    }
}
