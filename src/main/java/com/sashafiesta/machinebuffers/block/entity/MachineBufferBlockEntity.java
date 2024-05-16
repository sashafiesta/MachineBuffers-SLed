package com.sashafiesta.machinebuffers.block.entity;

import com.sashafiesta.machinebuffers.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class MachineBufferBlockEntity extends HopperBlockEntity {
	public MachineBufferBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}

	@Override
	public Text getContainerName() {
		return Text.translatable("container.machine_buffer");
	}

	@Override
	public BlockEntityType<?> getType() {
		return Main.MACHINE_BUFFER_BLOCK_ENTITY_TYPE;
	}
}