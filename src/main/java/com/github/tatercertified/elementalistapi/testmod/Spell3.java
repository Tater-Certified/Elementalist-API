package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicRapidFireSpell;

public class Spell3 extends BasicRapidFireSpell {

    public Spell3(int level, int cooldown, String name, double distance, float speed, int count, int fire_delay) {
        super(level, cooldown, name, distance, speed, count, fire_delay);
    }
}
