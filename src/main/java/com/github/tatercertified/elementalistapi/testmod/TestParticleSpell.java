package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.spell.BasicProjectileSpell;

import java.util.ArrayList;

public class TestParticleSpell extends BasicProjectileSpell {

    public TestParticleSpell(int level, int cooldown, String name, double distance, float speed, ArrayList<BasicParticle> particleEffects) {
        super(level, cooldown, name, distance, speed, particleEffects);
    }

}
