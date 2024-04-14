package tfar.guardianlaserrange;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Guardian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfar.guardianlaserrange.platform.Services;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class GuardianLaserRange {

    public static final String MOD_ID = "guardianlaserrange";
    public static final String MOD_NAME = "GuardianLaserRange";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static void init() {
    }

    public static boolean checkRange(Guardian guardian, LivingEntity target) {
        double range = guardian.getAttributeValue(Attributes.FOLLOW_RANGE);
        double reducedRange = range * Services.PLATFORM.getMultiplier();
        return !(guardian.distanceToSqr(target) > reducedRange * reducedRange);
    }
}