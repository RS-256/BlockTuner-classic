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

package com.rs256.blocktuner.mixin;

import com.rs256.blocktuner.util.NoteNames;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.BlockItemStateProperties;
import net.minecraft.world.level.block.NoteBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class NoteNameMixin {

    @Unique
    private static final Style NOTE_STYLE = Style.EMPTY.withColor(ChatFormatting.AQUA).withItalic(false);

    @Inject(method = "getItemName", at = @At("HEAD"), cancellable = true)
    private void getNoteName(CallbackInfoReturnable<Component> cir) {
        ItemStack itemStack = (ItemStack) (Object) this;
        BlockItemStateProperties properties;
        if (itemStack.getItem() == Items.NOTE_BLOCK && (properties = itemStack.get(DataComponents.BLOCK_STATE)) != null) {
            int note = properties.get(NoteBlock.NOTE) == null ? -1 : properties.get(NoteBlock.NOTE);
            cir.setReturnValue(Component.translatable(itemStack.getItem().getDescriptionId()).append(Component.literal(" (" + NoteNames.get(note) + ", " + note + ")")).setStyle(NOTE_STYLE));
        }
    }
}