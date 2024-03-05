package com.github.tatercertified.elementalistapi.summoner;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.util.texture.ModelledPolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SingleSpellSummoner extends ModelledPolymerItem implements SummonerInterface {
    private final BasicSpell spell;

    public SingleSpellSummoner(Settings settings, PolymerModelData customModelData, BasicSpell spell) {
        super(settings, customModelData);
        this.spell = spell;
    }

    @Override
    public String getSpellType() {
        return this.spell.getSpellName();
    }

    @Override
    public String getSummonerName() {
        return null;
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.STICK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
      if (this.spell.active_cooldown == this.spell.getCooldown()) {
            //Fire onCast event
            this.spell.onCast((ServerPlayerEntity) user, world);
        }
        return super.use(world, user, hand);
    }
}
