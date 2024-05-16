package com.sashafiesta.machinebuffers;

import com.sashafiesta.machinebuffers.block.ModBlocks;
import com.sashafiesta.machinebuffers.block.entity.MachineBufferBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	public static final String MOD_ID = "machinebuffers";

	private static final Identifier MACHINE_BUFFER_ID = new Identifier(MOD_ID, "machine_buffer");
	public static final BlockEntityType<MachineBufferBlockEntity> MACHINE_BUFFER_BLOCK_ENTITY_TYPE = createMachineBufferBlockEntityType();

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		Registry.register(Registries.BLOCK_ENTITY_TYPE, MACHINE_BUFFER_ID, MACHINE_BUFFER_BLOCK_ENTITY_TYPE);
	}

	private static BlockEntityType<MachineBufferBlockEntity> createMachineBufferBlockEntityType() {
		FabricBlockEntityTypeBuilder<MachineBufferBlockEntity> builder = FabricBlockEntityTypeBuilder.create(MachineBufferBlockEntity::new);

		for (ModBlocks modBlock : ModBlocks.values()) {
			builder.addBlock(modBlock.getBlock());
		}

		return builder.build();
	}
}