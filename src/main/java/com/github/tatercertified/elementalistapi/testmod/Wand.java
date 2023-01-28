package com.github.tatercertified.elementalistapi.testmod;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;
import com.github.tatercertified.elementalistapi.summoner.Summoner;

import java.util.ArrayList;

public class Wand extends Summoner {

    public static ArrayList<BasicSpell> spells = new ArrayList<>();
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public ArrayList<BasicSpell> addSpells() {
        spells.add(new ProjectileTrailTest(1, 150, "Projectile Trail Test", 100, 0.6F));
        spells.add(new RapidPTrailTest(2, 200, "Rapid-Fire Trails Test", 100, 0.6F, 10, 5));
        return spells;
    }
}
