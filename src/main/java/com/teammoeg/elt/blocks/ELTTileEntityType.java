package com.teammoeg.elt.blocks;

import com.google.common.collect.ImmutableSet;
import com.teammoeg.elt.ELT;
import com.teammoeg.elt.blocks.ResourceBlock.ResearchDesk;
import com.teammoeg.elt.blocks.ResourceBlock.TileEntityResearchDesk;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.function.Supplier;

public class ELTTileEntityType {
    public static final DeferredRegister<TileEntityType<?>> REGISTER =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ELT.MOD_ID);
    public static final RegistryObject<TileEntityType<TileEntityResearchDesk>> ResearchDesk = REGISTER.register(
            "researchdesk",makeType(TileEntityResearchDesk::new,() ->ELTbaseBlocks.ResearchDesk));
                private static <T extends TileEntity> Supplier<TileEntityType<T>> makeType(Supplier<T> create, Supplier<Block> valid)
                {
                    return makeTypeMultipleBlocks(create, () -> ImmutableSet.of(valid.get()));
                }

                private static <T extends TileEntity> Supplier<TileEntityType<T>> makeTypeMultipleBlocks(
                        Supplier<T> create,
                        Supplier<Collection<Block>> valid)
                {
                    return () -> new TileEntityType<>(create, ImmutableSet.copyOf(valid.get()), null);
                }
}
