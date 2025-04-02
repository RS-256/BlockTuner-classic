/*
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
package io.github.lumine1909.blocktuner.network;

import io.github.lumine1909.blocktuner.BlockTuner;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import static io.github.lumine1909.blocktuner.BlockTuner.id;

public record ServerBoundHelloPacket(int protocolVersion) implements CustomPacketPayload {

    public static final ResourceLocation ID = id("server_bound_hello");
    public static final CustomPacketPayload.Type<ServerBoundHelloPacket> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientBoundHelloPacket> CODEC = StreamCodec.composite(
        ByteBufCodecs.INT,
        ClientBoundHelloPacket::protocolVersion,
        ClientBoundHelloPacket::new
    );

    @Override
    public @NotNull CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void receive(ServerBoundHelloPacket payload, ServerPlayNetworking.Context context) {
        int clientProtocol = payload.protocolVersion();
        ServerPlayer player = context.player();
        if (BlockTuner.TUNING_PROTOCOL == clientProtocol) {
            ServerPlayNetworking.send(player, new ClientBoundHelloPacket(BlockTuner.TUNING_PROTOCOL));
        }
    }
}
