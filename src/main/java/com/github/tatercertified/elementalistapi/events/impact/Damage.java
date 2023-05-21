package com.github.tatercertified.elementalistapi.events.impact;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class Damage extends BasicSpellEvent {
    private final float damage;
    private final LivingEntity hit;
    private final DamageSource source;
    /**
     * Damages the specified LivingEntity and counts as a player kill
     * @param dmg Amount of health points to remove
     * @param hit LivingEntity being hit
     * @param source Who or what hit "hit"
     */
    public Damage(float dmg, LivingEntity hit, DamageSource source) {
        this.damage = dmg;
        this.hit = hit;
        this.source = source;
    }

    @Override
    public void event() {
        super.event();
        hit.damage(source, damage);
    }
}
