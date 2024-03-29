package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.particle.shape.ShapeParticle;
import com.github.tatercertified.elementalistapi.spell.BasicOffensiveSpell;
import com.github.tatercertified.elementalistapi.util.shape_iterator.CircleIterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;

public class OffensiveTestSpell extends BasicOffensiveSpell {
    /**
     * Basic spell for giving effects to nearby Entities
     *
     * @param level        level of spell
     * @param cooldown     cooldown in ticks
     * @param name         name of the spell
     * @param searchRadius the radius in blocks that the game searches for entities
     * @param entityType   the type of entity to search for
     * @param effect       the type of effect to apply
     * @param affectUser   if the effect should apply to the user
     */
    public OffensiveTestSpell(int level, int cooldown, String name, int searchRadius, Class<? extends Entity> entityType, StatusEffectInstance effect, boolean affectUser) {
        super(level, cooldown, name, searchRadius, entityType, effect, affectUser);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new ShapeParticle(0, 400, ParticleTypes.NOTE, new CircleIterator(10, 400)));
    }
}
