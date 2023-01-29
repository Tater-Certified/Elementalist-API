package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.time.KillTargetEntity;
import com.github.tatercertified.elementalistapi.spell.BasicStaticSpell;

public class StaticSpellTest extends BasicStaticSpell {

    public StaticSpellTest(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new KillTargetEntity(400, 0));
    }
}
