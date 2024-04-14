package tfar.guardianlaserrange;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod(GuardianLaserRange.MOD_ID)
public class GuardianLaserRangeForge {
    
    public GuardianLaserRangeForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
        GuardianLaserRange.init();
    }

    public static final ModConfigForge.Server SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<ModConfigForge.Server, ForgeConfigSpec> specPair2 = new ForgeConfigSpec.Builder().configure(ModConfigForge.Server::new);
        SERVER_SPEC = specPair2.getRight();
        SERVER = specPair2.getLeft();
    }
}