package com.drbretto.drb;

import com.drbretto.drb.armor.ModArmorMaterials;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DRBMod implements ModInitializer {

	public static final String MOD_ID = "drb";

	public static final Enchantment BOOM_BOOM = new BoomBoomEnchantment(
			Enchantment.Rarity.RARE,
			EnchantmentTarget.WEAPON,
			new EquipmentSlot[] {
					EquipmentSlot.MAINHAND
			});

	public static final ItemGroup GROUP = FabricItemGroupBuilder.build(new Identifier("drb", "group"), () -> new ItemStack(DRBMod.CREEPER_HEART));

	public static final Item CREEPER_HEART = new CreeperHeartItem(new Item.Settings().group(GROUP).maxCount(32));
	//public static final Item BOOM_STICK = new BoomStick(12f, 12f, 2, );

	public static final Block GUNPOWDER_BLOCK = new GunpowderBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).luminance(15));
	public static final Item GUNPOWDER_BLOCK_ITEM = new BlockItem(GUNPOWDER_BLOCK, new Item.Settings().group(GROUP));

	public static final Item GUNPOWDER_HELMET = new ArmorItem(ModArmorMaterials.GUNPOWDER, EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
	public static final Item GUNPOWDER_CHESTPLATE = new ArmorItem(ModArmorMaterials.GUNPOWDER, EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
	public static final Item GUNPOWDER_LEGGINGS = new ArmorItem(ModArmorMaterials.GUNPOWDER, EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
	public static final Item GUNPOWDER_BOOTS = new ArmorItem(ModArmorMaterials.GUNPOWDER, EquipmentSlot.FEET, new Item.Settings().group(GROUP));



	@Override
	public void onInitialize() {

		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "creeper_heart"), CREEPER_HEART);

		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "gunpowder_block"), GUNPOWDER_BLOCK_ITEM);

		Registry.register( Registry.BLOCK, new Identifier(MOD_ID, "gunpowder_block"), GUNPOWDER_BLOCK);

		Registry.register( Registry.ENCHANTMENT, new Identifier(MOD_ID, "boom_boom"), BOOM_BOOM);

		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "gunpowder_helmet"), GUNPOWDER_HELMET);
		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "gunpowder_chestplate"), GUNPOWDER_CHESTPLATE);
		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "gunpowder_leggings"), GUNPOWDER_LEGGINGS);
		Registry.register( Registry.ITEM, new Identifier(MOD_ID, "gunpowder_boots"), GUNPOWDER_BOOTS);

		System.out.println("Hello Fabric world!");

	}
}
