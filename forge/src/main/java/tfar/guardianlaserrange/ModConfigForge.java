package tfar.guardianlaserrange;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigForge {
    public static class Server {
        public static ForgeConfigSpec.DoubleValue multiplier;

        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            multiplier = builder.defineInRange("multiplier", .5d, 0, 1);
            builder.pop();
        }
    }
}
