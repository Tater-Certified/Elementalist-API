package com.github.tatercertified.elementalistapi.util;

import com.github.tatercertified.elementalistapi.spell.BasicSpell;

import java.util.ArrayList;

public interface ServerPlayerEntityAccessor {
    ArrayList<BasicSpell> used_spells();
}
