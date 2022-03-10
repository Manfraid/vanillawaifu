package net.orandja.vw.mixin;

import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.orandja.vw.logic.InfinityBucket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin implements InfinityBucket {

    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemUsage;exchangeStack(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;"))
    public ItemStack interactMob(ItemStack inputStack, PlayerEntity player, ItemStack outputStack) {
        return Companion.handleEmptyInfinityBucket(inputStack, player, outputStack);
    }

}