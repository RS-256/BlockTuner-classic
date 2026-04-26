/*
 *     Copyright (c) 2022, xwjcool.
 *     Copyright (c) 2025, Lumine1909.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.rs256.blocktuner;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class BlockTunerConfig {

    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("blocktuner.properties");
    private static final Properties properties = new Properties();

    // configurable
    private static final String PLAY_MODE = "play-mode";
    private static final String KEY_TO_PIANO = "key-to-piano";
    private static final String MIDI_DEVICE = "midi-device";
    private static final String KEY_SIGNATURE = "key-signature";
    private static final String REQUIRE_CTRL_TO_OPEN_GUI = "require-ctrl-to-open-gui";
    private static final String REQUIRE_CTRL_TO_COPY_PITCH = "require-ctrl-to-copy-pitch";
    public static int keySignature = 0;
    public static boolean onBlockTunerServer = false;
    private static String midiDeviceName = "";
    private static boolean keyToPiano = false;
    private static boolean playMode = false;
    private static boolean requireCtrlToOpenGui = true;
    private static boolean requireCtrlToCopyPitch = true;

    public static void save() {

        if (!Files.exists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try (OutputStream outputStream = Files.newOutputStream(CONFIG_PATH)) {
            properties.store(outputStream, "BlockTuner Configuration File");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
        }
        try (InputStream inputStream = Files.newInputStream(CONFIG_PATH)) {
            properties.load(inputStream);
            playMode = Boolean.parseBoolean(properties.getProperty(PLAY_MODE));
            keyToPiano = Boolean.parseBoolean(properties.getProperty(KEY_TO_PIANO));
            midiDeviceName = properties.getProperty(MIDI_DEVICE, "");
            requireCtrlToOpenGui = Boolean.parseBoolean(properties.getProperty(REQUIRE_CTRL_TO_OPEN_GUI, "true"));
            requireCtrlToCopyPitch = Boolean.parseBoolean(properties.getProperty(REQUIRE_CTRL_TO_COPY_PITCH, "true"));
            try {
                keySignature = Integer.parseInt(properties.getProperty(KEY_SIGNATURE, "0"));
            } catch (NumberFormatException e) {
                keySignature = 0;
                properties.setProperty(KEY_SIGNATURE, String.valueOf(keySignature));
                save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMidiDeviceName() {
        return midiDeviceName;
    }

    public static void setMidiDeviceName(String midiDeviceName) {
        BlockTunerConfig.midiDeviceName = midiDeviceName;
        properties.setProperty(MIDI_DEVICE, midiDeviceName);
    }

    public static boolean isPlayMode() {
        return playMode;
    }

    public static void setPlayMode(boolean playMode) {
        BlockTunerConfig.playMode = playMode;
        properties.setProperty(PLAY_MODE, String.valueOf(playMode));
    }

    public static void togglePlayMode() {
        setPlayMode(!playMode);
    }

    public static boolean isKeyToPiano() {
        return keyToPiano;
    }

    public static void setKeyToPiano(boolean keyToPiano) {
        BlockTunerConfig.keyToPiano = keyToPiano;
        properties.setProperty(KEY_TO_PIANO, String.valueOf(keyToPiano));
    }

    public static void toggleKeyToPiano() {
        setKeyToPiano(!keyToPiano);
    }

    public static int getKeySignature() {
        return keySignature;
    }

    public static boolean isRequireCtrlToOpenGui() {
        return requireCtrlToOpenGui;
    }

    public static void setRequireCtrlToOpenGui(boolean requireCtrlToOpenGui) {
        BlockTunerConfig.requireCtrlToOpenGui = requireCtrlToOpenGui;
        properties.setProperty(REQUIRE_CTRL_TO_OPEN_GUI, String.valueOf(requireCtrlToOpenGui));
    }

    public static boolean isRequireCtrlToCopyPitch() {
        return requireCtrlToCopyPitch;
    }

    public static void setRequireCtrlToCopyPitch(boolean requireCtrlToCopyPitch) {
        BlockTunerConfig.requireCtrlToCopyPitch = requireCtrlToCopyPitch;
        properties.setProperty(REQUIRE_CTRL_TO_COPY_PITCH, String.valueOf(requireCtrlToCopyPitch));
    }

    public static void setKeySignature(int keySignature) {
        if (keySignature >= -7 && keySignature <= 7) {
            BlockTunerConfig.keySignature = keySignature;
        } else {
            BlockTunerConfig.keySignature = 0;
        }
        properties.setProperty(KEY_SIGNATURE, String.valueOf(BlockTunerConfig.keySignature));
    }

    public static void keyAddSharp() {
        if (keySignature < 7) {
            keySignature += 1;
        } else {
            keySignature = -7;
        }
        properties.setProperty(KEY_SIGNATURE, String.valueOf(keySignature));
    }

    public static void keyAddFlat() {
        if (keySignature > -7) {
            keySignature -= 1;
        } else {
            keySignature = 7;
        }
        properties.setProperty(KEY_SIGNATURE, String.valueOf(keySignature));
    }
}
