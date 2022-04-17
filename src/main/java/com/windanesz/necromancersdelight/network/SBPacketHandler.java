package com.windanesz.necromancersdelight.network;

import com.windanesz.necromancersdelight.NecromancersDelight;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class SBPacketHandler {

	public static SimpleNetworkWrapper net;
	private static int nextPacketId = 0;

	public static void initPackets() {
		net = NetworkRegistry.INSTANCE.newSimpleChannel(NecromancersDelight.MODID.toUpperCase());
	}

	private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
			Class<? extends IMessageHandler<REQ, REPLY>> packet, Class<REQ> message) {
		net.registerMessage(packet, message, nextPacketId, Side.CLIENT);
		net.registerMessage(packet, message, nextPacketId, Side.SERVER);
		nextPacketId++;
	}

}
