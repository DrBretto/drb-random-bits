package com.drbretto.drb.mixin;

import com.drbretto.drb.DRBMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)


public abstract class LivingEntityMixin extends Entity {

    @Shadow
    @Final
    private DefaultedList<ItemStack> equippedArmor;

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo ci) {

        if (isOnFire()) {
            ItemStack helmetStack = equippedArmor.get(3);
            ItemStack chestplateStack = equippedArmor.get(2);
            ItemStack leggingsStack = equippedArmor.get(1);
            ItemStack bootsStack = equippedArmor.get(0);

            int explosionCount = 0;

            if (helmetStack.getItem().equals(DRBMod.GUNPOWDER_HELMET)) {
                explosionCount++;
            }
            if (chestplateStack.getItem().equals(DRBMod.GUNPOWDER_CHESTPLATE)) {
                explosionCount++;
            }
            if (leggingsStack.getItem().equals(DRBMod.GUNPOWDER_LEGGINGS)) {
                explosionCount++;
            }
            if (bootsStack.getItem().equals(DRBMod.GUNPOWDER_BOOTS)) {
                explosionCount++;
            }

            System.out.println("on fire" + explosionCount + helmetStack + chestplateStack + leggingsStack + bootsStack);

            if (explosionCount > 0) {


                for (int i = 0; i < explosionCount; i++) {
                    world.createExplosion(null, this.prevX, this.prevY, this.prevZ, 4.0F, Explosion.DestructionType.BREAK);

                }
            }
        }

    }
}
