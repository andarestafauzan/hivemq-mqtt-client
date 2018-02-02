package org.mqttbee.api.mqtt5.message;

import org.mqttbee.annotations.NotNull;
import org.mqttbee.mqtt5.message.Mqtt5UTF8StringImpl;

import java.nio.ByteBuffer;

/**
 * UTF-8 encoded String according to the MQTT 5 specification.
 * <p>
 * A UTF-8 encoded String must not contain the null character U+0000 and UTF-16 surrogates.
 * <p>
 * A UTF-8 encoded String should not contain control characters and non-characters.
 *
 * @author Silvio Giebl
 */
public interface Mqtt5UTF8String {

    /**
     * Validates and creates a UTF-8 encoded String from the given string.
     *
     * @param string the UTF-16 encoded Java string.
     * @return the created UTF-8 encoded String.
     * @throws IllegalArgumentException if the string is not a valid UTF-8 encoded String.
     */
    @NotNull
    static Mqtt5UTF8String from(@NotNull final String string) {
        final Mqtt5UTF8String utf8String = Mqtt5UTF8StringImpl.from(string);
        if (utf8String == null) {
            throw new IllegalArgumentException("The string: [" + string + "] is not a valid UTF-8 encoded String.");
        }
        return utf8String;
    }

    /**
     * Checks whether this UTF-8 encoded String contains characters that it should not according to the MQTT 5
     * specification.
     * <p>
     * These characters are control characters and non-characters.
     *
     * @return whether this UTF-8 encoded String contains characters that it should not.
     */
    boolean containsShouldNotCharacters();

    /**
     * Returns the UTF-8 encoded representation as a read-only byte buffer.
     *
     * @return the UTF-8 encoded read-only byte buffer.
     */
    @NotNull
    ByteBuffer toByteBuffer();

}