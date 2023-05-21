// TODO Actually make this do damage to an area rather than a List of LivingEntities
package com.github.tatercertified.elementalistapi.events.area;

import com.github.tatercertified.elementalistapi.events.BasicSpellEvent;
import com.github.tatercertified.elementalistapi.events.impact.Damage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import java.util.List;

public class AreaDamage extends BasicSpellEvent {
    private final List<LivingEntity> hits;
    private final float damage;
    private final DamageSource source;
    /**
     * Does damage to multiple LivingEntities in a List
     * @param hits List of LivingEntities
     * @param damage Damage dealt to LivingEntities
     * @param source DamageSource from the damage
     */
    public AreaDamage(List<LivingEntity> hits, float damage, DamageSource source) {
        this.hits = hits;
        this.damage = damage;
        this.source = source;
    }

    @Override
    public void event() {
        super.event();
        for (LivingEntity hit : hits) {
            new Damage(damage, hit, source);
        }
    }
}
