package com.rs256.blocktuner.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.input.MouseButtonInfo;
import org.lwjgl.glfw.GLFW;

public class InputUtil {

    public static final MouseButtonEvent DUMMY_EVENT = new MouseButtonEvent(0, 0, new MouseButtonInfo(0, 0));

    public static boolean hasControlDown() {
        return GLFW.glfwGetKey(Minecraft.getInstance().getWindow().handle(), GLFW.GLFW_KEY_LEFT_CONTROL) == GLFW.GLFW_PRESS ||
            GLFW.glfwGetKey(Minecraft.getInstance().getWindow().handle(), GLFW.GLFW_KEY_RIGHT_CONTROL) == GLFW.GLFW_PRESS;
    }

    public static boolean hasShiftDown() {
        return GLFW.glfwGetKey(Minecraft.getInstance().getWindow().handle(), GLFW.GLFW_KEY_LEFT_SHIFT) == GLFW.GLFW_PRESS ||
            GLFW.glfwGetKey(Minecraft.getInstance().getWindow().handle(), GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS;
    }
}
