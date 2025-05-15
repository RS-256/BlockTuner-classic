package io.github.lumine1909.blocktuner.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.CommandSuggestions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(CommandSuggestions.SuggestionsList.class)
public class CommandSuggestionsMixin {

    @Final
    @Shadow
    CommandSuggestions field_21615;

    @Inject(
        method = "useSuggestion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/components/EditBox;setValue(Ljava/lang/String;)V"
        )
    )
    private void injected(CallbackInfo ci) {
        field_21615.keepSuggestions = false;
    }
}
