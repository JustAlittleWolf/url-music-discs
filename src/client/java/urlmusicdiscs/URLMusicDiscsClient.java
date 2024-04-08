package urlmusicdiscs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class URLMusicDiscsClient implements ClientModInitializer {
    public static final String MOD_ID = "urlmusicdiscs";
    public static final Identifier CUSTOM_RECORD_PACKET_ID = new Identifier(MOD_ID, "play_sound");
    public static final Identifier CUSTOM_RECORD_GUI = new Identifier(MOD_ID, "record_gui");

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(CUSTOM_RECORD_PACKET_ID, (client, handler, buf, responseSender) -> {
            client.execute(() -> {
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(CUSTOM_RECORD_GUI, (client, handler, buf, responseSender) -> {
            client.execute(() -> {
            });
        });
    }
}