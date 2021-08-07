package com.drbretto.drb;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DRBMod implements ModInitializer {

	public static final String MOD_ID = "drb";

	public static final Item CREEPER_HEART = new CreeperHeartItem(new Item.Settings().group(ItemGroup.MATERIALS).maxCount(32));

	@Override
	public void onInitialize() {

		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "creeper_heart"), CREEPER_HEART);


		System.out.println("Hello Fabric world!");
	}
}
