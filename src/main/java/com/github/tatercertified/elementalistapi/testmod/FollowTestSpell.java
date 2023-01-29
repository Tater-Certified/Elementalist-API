package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.time.KillTargetEntity;
import com.github.tatercertified.elementalistapi.spell.BasicFollowSpell;

public class FollowTestSpell extends BasicFollowSpell {

    public FollowTestSpell(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void addEvents() {
        super.addEvents();
        events.add(new KillTargetEntity(400, 0));
    }
}
