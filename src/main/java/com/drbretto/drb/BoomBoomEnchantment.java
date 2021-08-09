package com.drbretto.drb;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.world.World;

public class BoomBoomEnchantment extends Enchantment {

    protected BoomBoomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }


    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {


    if (target instanceof LivingEntity){
        World world = user.world;

        TntEntity tntEntity = EntityType.TNT.create(world);
        tntEntity.setFuse(0);
        tntEntity.setPos(target.prevX, target.prevY, target.prevZ);

        world.spawnEntity(tntEntity);

    }
    }


}
