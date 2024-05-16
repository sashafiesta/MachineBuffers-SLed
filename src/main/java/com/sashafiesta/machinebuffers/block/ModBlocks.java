package com.sashafiesta.machinebuffers.block;

import com.sashafiesta.machinebuffers.Main;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.BlockSoundGroup;

public enum ModBlocks implements ItemConvertible {
	BASE_BUFFER("machine_buffer", Blocks.DIRT);

	private final Block base;
	private final Block block;
	private final BlockItem item;

	private ModBlocks(String path, Block base, Block block) {
		Identifier id = new Identifier(Main.MOD_ID, path);
		this.base = base;
		this.block = block;
		Registry.register(Registries.BLOCK, id, block);
		this.item = new BlockItem(block, new Item.Settings());
		Registry.register(Registries.ITEM, id, this.item);
	}

	private ModBlocks(String path, Block base) {
		this(path, base, new MachineBufferBlock(createBlockSettings(base)));
	}

	public Block getBase() {
		return this.base;
	}

	public Block getBlock() {
		return this.block;
	}

	@Override
	public Item asItem() {
		return this.item;
	}

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {entries.addAfter(Items.HOPPER, ModBlocks.values());});
	}

	private static Block.Settings createBlockSettings(Block base) {
		return FabricBlockSettings.copyOf(base).sounds(BlockSoundGroup.METAL).nonOpaque();
	}
}