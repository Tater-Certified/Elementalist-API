package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.events.movement.Follow;

public class BasicFollowSpell extends BasicStaticSpell{
    /**
     * Basic spell for following Spells
     *
     * @param level      level of spell
     * @param cooldown   cooldown in ticks
     * @param name       name of the spell
     */
    public BasicFollowSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new Follow(0, Integer.MAX_VALUE));
    }
}
