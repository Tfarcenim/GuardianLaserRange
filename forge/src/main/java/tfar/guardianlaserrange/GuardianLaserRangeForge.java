package tfar.guardianlaserrange;

import net.minecraftforge.fml.common.Mod;

@Mod(GuardianLaserRange.MOD_ID)
public class GuardianLaserRangeForge {
    
    public GuardianLaserRangeForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        GuardianLaserRange.LOG.info("Hello Forge world!");
        GuardianLaserRange.init();
        
    }
}