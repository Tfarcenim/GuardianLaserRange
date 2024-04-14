package tfar.guardianlaserrange.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Guardian;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import tfar.guardianlaserrange.GuardianLaserRange;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.entity.monster.Guardian$GuardianAttackGoal")
public class GuardianMixin {

    @Shadow @Final private Guardian guardian;

    @Shadow @Final private boolean elder;

    @Inject(method = "canUse",at = @At("RETURN"),cancellable = true,locals = LocalCapture.CAPTURE_FAILHARD)
    private void rangeMulti(CallbackInfoReturnable<Boolean> cir, LivingEntity target) {
        boolean b = cir.getReturnValue();
        if (b && !elder) {
            boolean allow = GuardianLaserRange.checkRange(this.guardian,target);
            if (!allow) {
                cir.setReturnValue(false);
            }
        }
    }
}