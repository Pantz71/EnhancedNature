package pantz.enhanced_nature.core;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;
import org.apache.commons.lang3.tuple.Pair;

public class ENConfig {
    public static class Common {
        public static final ModConfigSpec COMMON_SPEC;
        public static final Common COMMON;

        static {
            Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
            COMMON_SPEC = commonSpecPair.getRight();
            COMMON = commonSpecPair.getLeft();
        }

        Common(Builder builder) {

        }
    }
}
