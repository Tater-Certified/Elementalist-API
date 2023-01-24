package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.particle.BasicParticle;
import com.github.tatercertified.elementalistapi.spell.BasicRapidFireSpell;

import java.util.ArrayList;

public class Spell3 extends BasicRapidFireSpell {

    public Spell3(int level, int cooldown, String name, double distance, float speed, int count, int fire_delay, ArrayList<BasicParticle> particleEffects) {
        super(level, cooldown, name, distance, speed, count, fire_delay, particleEffects);
    }
}
