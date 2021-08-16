package com.drbretto.drb;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class BoomStick extends Item {


    public BoomStick(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {

        //TntEntity tntEntity = EntityType.TNT.create(world);
        //tntEntity.setFuse(0);
        //tntEntity.setPos(pos.getX(), pos.getY(), pos.getZ());

        //world.spawnEntity(tntEntity);
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.0F, Explosion.DestructionType.BREAK);


        return super.canMine(state, world, pos, miner);
    }
}
