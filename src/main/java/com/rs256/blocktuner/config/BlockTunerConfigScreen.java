package com.rs256.blocktuner.config;

import com.rs256.blocktuner.BlockTunerConfig;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class BlockTunerConfigScreen {

    private BlockTunerConfigScreen() {
    }

    public static Screen create(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("yacl.blocktuner.title"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("yacl.blocktuner.category.general"))
                .group(OptionGroup.createBuilder()
                    .name(Component.translatable("yacl.blocktuner.group.general"))
                    .description(OptionDescription.of(Component.translatable("yacl.blocktuner.group.general.description")))
                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("yacl.blocktuner.option.play_mode"))
                        .description(OptionDescription.of(Component.translatable("yacl.blocktuner.option.play_mode.description")))
                        .binding(false, BlockTunerConfig::isPlayMode, BlockTunerConfig::setPlayMode)
                        .controller(TickBoxControllerBuilder::create)
                        .build())
                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("yacl.blocktuner.option.key_to_piano"))
                        .description(OptionDescription.of(Component.translatable("yacl.blocktuner.option.key_to_piano.description")))
                        .binding(false, BlockTunerConfig::isKeyToPiano, BlockTunerConfig::setKeyToPiano)
                        .controller(TickBoxControllerBuilder::create)
                        .build())
                    .option(Option.<Integer>createBuilder()
                        .name(Component.translatable("yacl.blocktuner.option.key_signature"))
                        .description(OptionDescription.of(Component.translatable("yacl.blocktuner.option.key_signature.description")))
                        .binding(0, BlockTunerConfig::getKeySignature, BlockTunerConfig::setKeySignature)
                        .controller(option -> IntegerSliderControllerBuilder.create(option).range(-7, 7).step(1))
                        .build())
                    .option(Option.<Boolean>createBuilder()
                        .name(Component.translatable("yacl.blocktuner.option.require_ctrl_to_open_gui"))
                        .description(OptionDescription.of(Component.translatable("yacl.blocktuner.option.require_ctrl_to_open_gui.description")))
                        .binding(true, BlockTunerConfig::isRequireCtrlToOpenGui, BlockTunerConfig::setRequireCtrlToOpenGui)
                        .controller(TickBoxControllerBuilder::create)
                        .build())
                    .build())
                .build())
            .save(BlockTunerConfig::save)
            .build()
            .generateScreen(parent);
    }
}
