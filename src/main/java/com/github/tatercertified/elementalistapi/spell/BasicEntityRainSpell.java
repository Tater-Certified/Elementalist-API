package com.github.tatercertified.elementalistapi.spell;

import com.github.tatercertified.elementalistapi.spell.raining_entities.BasicRainingEntity;
import com.github.tatercertified.elementalistapi.util.PlayerUtils;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Objects;

public class BasicEntityRainSpell extends BasicStaticSpell {
    /**
     * Basic spell for stationary entity raining Spells
     *
     * @param level    level of spell
     * @param cooldown cooldown in ticks
     * @param name     name of the spell
     * @param item     item represented
     * @param distance how far to send entity
     */
    private final Item item;
    private final double distance;
    public BasicEntityRainSpell(int level, int cooldown, String name, Item item, double distance) {
        super(level, cooldown, name);
        this.item = item;
        this.distance = distance;
    }

    @Override
    public void onCast(ServerPlayerEntity user, World world) {
        super.onCast(user, world);
        BasicRainingEntity basic_raining_entity = new BasicRainingEntity(item.getDefaultStack(), PlayerUtils.vec3dToBlockPos(Objects.requireNonNull(PlayerUtils.getTargetBlockPos(user, distance))), 200, world);
        world.spawnEntity(basic_raining_entity.asEntity());
        basic_raining_entity.asEntity().setPos(this.pos.x, this.pos.y, this.pos.z);
    }
}
