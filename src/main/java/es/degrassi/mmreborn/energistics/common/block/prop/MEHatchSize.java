package es.degrassi.mmreborn.energistics.common.block.prop;

import es.degrassi.mmreborn.energistics.common.data.MMRConfig;
import lombok.Getter;
import net.minecraft.util.StringRepresentable;

import java.util.Locale;

public enum MEHatchSize implements StringRepresentable {
  ME_INPUT_BUS(9),
  ME_ADVANCED_INPUT_BUS(true, 9*4),
  ME_OUTPUT_BUS(9),
  ME_ADVANCED_OUTPUT_BUS(true, 9*2),
  ME_INPUT_HATCH(9),
  ME_ADVANCED_INPUT_HATCH(true, 9*4),
  ME_OUTPUT_HATCH(9),
  ME_ADVANCED_OUTPUT_HATCH(true, 9*2),
  ME_INPUT_CHEMICAL_HATCH(9),
  ME_ADVANCED_INPUT_CHEMICAL_HATCH(true, 9*4),
  ME_OUTPUT_CHEMICAL_HATCH(9),
  ME_ADVANCED_OUTPUT_CHEMICAL_HATCH(true, 9*2);

  @Getter
  private double idlePowerDrainOnConnected;
  @Getter
  private final boolean advanced;
  @Getter
  private final int slots;
  public final double defaultIdlePowerDrainOnConnected;

  MEHatchSize(boolean advanced, int slots) {
    this.defaultIdlePowerDrainOnConnected = advanced ? 3.0 : 1.0;
    this.advanced = advanced;
    this.slots = slots;
  }
  MEHatchSize(int slots) {
    this(false, slots);
  }

  public static void loadFromConfig() {
    for (MEHatchSize size : MEHatchSize.values()) {
      size.idlePowerDrainOnConnected = MMRConfig.get().idlePowerDrainOnConnected(size);
    }
  }

  public boolean isInput() {
    return this == ME_INPUT_HATCH || this == ME_ADVANCED_INPUT_HATCH || this == ME_INPUT_BUS || this == ME_ADVANCED_INPUT_BUS || this == ME_INPUT_CHEMICAL_HATCH || this == ME_ADVANCED_INPUT_CHEMICAL_HATCH;
  }

  @Override
  public String getSerializedName() {
    return name().toLowerCase(Locale.ROOT);
  }
}
