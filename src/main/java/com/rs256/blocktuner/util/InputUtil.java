package com.rs256.blocktuner.util;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.input.MouseButtonInfo;
import org.lwjgl.glfw.GLFW;

public class InputUtil {

    public static final MouseButtonEvent DUMMY_EVENT = new MouseButtonEvent(0, 0, new MouseButtonInfo(0, 0));

    public static boolean isKeyPressed(int glfwKey) {
        Window handle = Minecraft.getInstance().getWindow();
        return InputConstants.isKeyDown(handle, glfwKey);
    }

    // has two keys
    public static boolean isCtrlDown() {
        return isKeyPressed(GLFW.GLFW_KEY_LEFT_CONTROL)
                || isKeyPressed(GLFW.GLFW_KEY_RIGHT_CONTROL);
    }

    public static boolean isAltDown() {
        return isKeyPressed(GLFW.GLFW_KEY_LEFT_ALT)
                || isKeyPressed(GLFW.GLFW_KEY_RIGHT_ALT);
    }

    public static boolean isShiftDown() {
        return isKeyPressed(GLFW.GLFW_KEY_LEFT_SHIFT)
                || isKeyPressed(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }
}
