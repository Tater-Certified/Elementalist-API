package com.github.tatercertified.elementalistapi.mixin;

import com.github.tatercertified.elementalistapi.summoner.MultiSpellSummoner;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.listener.TickablePacketListener;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.EntityTrackingListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class ServerPlayNetworkHandlerMixin implements EntityTrackingListener, TickablePacketListener, ServerPlayPacketListener {

    @Shadow public ServerPlayerEntity player;

    @Inject(method = "onHandSwing", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;swingHand(Lnet/minecraft/util/Hand;)V"))
    public void onHandSwing(HandSwingC2SPacket packet, CallbackInfo ci) {
        if (player.isSneaking() && player.getMainHandStack().getItem() instanceof MultiSpellSummoner) {
            Item summoner = player.getMainHandStack().getItem();
            ((MultiSpellSummoner)summoner).cycleSpellsReverse();
        }
    }
}
