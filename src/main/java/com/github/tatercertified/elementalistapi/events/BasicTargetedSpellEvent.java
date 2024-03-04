package com.github.tatercertified.elementalistapi.events;

import com.github.tatercertified.elementalistapi.spell.target.TargetEntity;

public class BasicTargetedSpellEvent extends BasicSpellEvent {
    public TargetEntity target;

    /**
     * Sets the TargetEntity for the SpellEvent
     * @param target TargetEntity
     */
    public void setTarget(TargetEntity target) {
        this.target = target;
    }
}
