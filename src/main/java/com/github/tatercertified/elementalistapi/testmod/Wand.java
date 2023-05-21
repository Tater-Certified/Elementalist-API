package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.summoner.Summoner;
import net.minecraft.item.Items;

import java.util.ArrayList;

public class Wand extends Summoner {

    public ArrayList<BasicSpell> spells;
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<BasicSpell> addSpells() {
        spells = new ArrayList<>();
        spells.add(new ProjectileTrailTest(1, 150, "Projectile Trail Test", 100, 0.01F));
        spells.add(new RapidPTrailTest(2, 200, "Rapid-Fire Trails Test", 100, 0.6F, 10, 5));
        spells.add(new StaticSpellTest(1, 400, "Static Spell Test"));
        spells.add(new FollowTestSpell(1, 400, "Follow Test Spell"));
        spells.add(new CTDTestSpell(3, 600, "Connect The Dots Test Spell"));
        spells.add(new LungeSpellTest(1, 200, "Lunge Test Spell"));
        spells.add(new FlyingTestSpell(3, 400, "Flight Test Spell"));
        spells.add(new EntityRainTest(3, 400, "Entity Rain Test Spell", Items.GOLDEN_SWORD, 40));
        spells.add(new LaserTestSpell(3, 600, "Laser Test Spell"));
        return spells;
    }
}
