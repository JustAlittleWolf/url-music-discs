package urlmusicdiscs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class URLMusicDiscsClient implements ClientModInitializer {
    public static final String MOD_ID = "urlmusicdiscs";
    public static final Identifier CUSTOM_RECORD_PACKET_ID = new Identifier(MOD_ID, "play_sound");
    public static final Identifier CUSTOM_RECORD_GUI = new Identifier(MOD_ID, "record_gui");
    public static final Identifier CUSTOM_RECORD_SET_URL = new Identifier(MOD_ID, "record_set_url");
    public static final Identifier PLACEHOLDER_SOUND_IDENTIFIER = new Identifier(MOD_ID, "placeholder_sound");
    public static final SoundEvent PLACEHOLDER_SOUND = Registry.register(
            Registries.SOUND_EVENT,
            PLACEHOLDER_SOUND_IDENTIFIER,
            SoundEvent.of(PLACEHOLDER_SOUND_IDENTIFIER)
    );
    public static final Item CUSTOM_RECORD = Registry.register(
            Registries.ITEM,
            new Identifier(MOD_ID, "custom_record"),
            new URLDiscItem(17, null, new FabricItemSettings().maxCount(1), 1)
    );

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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content) -> {
            content.add(CUSTOM_RECORD);
        });
    }
}