package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.events.movement.Lunge;
import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class LungeSpellTest extends BasicSpell {
    public LungeSpellTest(int level, int cooldown, String name) {
        super(level, cooldown, name);
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
        new Lunge(user, 5.0);
    }
}
