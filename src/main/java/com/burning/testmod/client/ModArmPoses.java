package com.burning.testmod.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class ModArmPoses {
    public static final HumanoidModel.ArmPose HELD_HIGH = HumanoidModel.ArmPose.create("held_high", false, (model, entity, arm) -> {
        if (arm == HumanoidArm.RIGHT) {
            model.rightArm.xRot = model.rightArm.xRot -Mth.PI / 3F;
            model.rightArm.yRot = 0;
            model.rightArm.zRot = model.rightArm.zRot + Mth.sin(entity.tickCount * Mth.PI/180);
        }
    });
}
