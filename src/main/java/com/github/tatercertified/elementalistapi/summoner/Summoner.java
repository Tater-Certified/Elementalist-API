package com.github.tatercertified.elementalistapi.summoner;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Summoner extends Item implements PolymerItem {

    private final ArrayList<BasicSpell> supported_spells;
    public BasicSpell current_spell;
    public Summoner(Settings settings) {
        super(settings);
        this.supported_spells = addSpells();
        this.current_spell = supported_spells.get(0);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.STICK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            cycleSpells();
        } else if (current_spell.active_cooldown == current_spell.getCooldown()) {
            //Fire onCast event
            current_spell.onCast((ServerPlayerEntity) user, world);
        }
        return super.use(world, user, hand);
    }

    /**
     * Cycles through all supported spells
     */
    public void cycleSpells() {
        int index = supported_spells.indexOf(current_spell);
        Iterator<BasicSpell> cycler = supported_spells.listIterator(index);
        cycler.next();
        if (cycler.hasNext()) {
            current_spell = supported_spells.get(index + 1);
        } else {
            current_spell = supported_spells.get(0);
        }
    }

    /**
     * Cycles in reverse through all supported spells
     */
    public void cycleSpellsReverse() {
        int index = supported_spells.indexOf(current_spell);
        ListIterator<BasicSpell> cycler = supported_spells.listIterator(index);
        if (cycler.hasPrevious()) {
            current_spell = supported_spells.get(index - 1);
        } else {
            current_spell = supported_spells.get(supported_spells.size() - 1);
        }
    }

    /**
     * Add spells to an arraylist for the summoner item
     * @return An arraylist with your spells
     */
    public ArrayList<BasicSpell> addSpells() {
        return new ArrayList<>();
    }
}
