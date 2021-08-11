package com.drbretto.drb;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BoomStick extends MiningToolItem {
    protected BoomStick(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }



    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {

        TntEntity tntEntity = EntityType.TNT.create(world);
        tntEntity.setFuse(0);
        tntEntity.setPos(pos.getX(), pos.getY(), pos.getZ());

        world.spawnEntity(tntEntity);

        return super.canMine(state, world, pos, miner);
    }
}
