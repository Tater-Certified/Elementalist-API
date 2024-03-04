package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.impact.Explode;
import com.github.tatercertified.elementalistapi.particle.functions.Linear;
import com.github.tatercertified.elementalistapi.spell.BasicFollowSpell;
import net.minecraft.particle.ParticleTypes;

public class LaserTestSpell extends BasicFollowSpell {
    public LaserTestSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new Linear(0, 200, 0, 40, 0.1, ParticleTypes.ELECTRIC_SPARK, new Explode(2.0F, null), new Explode(2.0F, null), null));
    }
}
