package org.wxapi.common.codec;

import java.nio.charset.Charset;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Operations to simplify SHA-1 digest tasks. This class is immutable and
 * thread-safe.
 *
 * @author xgx
 * @since 1.7
 */
public final class SHA1 {

    /**
     * Calls {@link String#getBytes(Charset)}
     *
     * @param string
     *            The string to encode (if null, return null).
     * @param charset
     *            The {@link Charset} to encode the <code>String</code>
     * @return the encoded bytes
     */
    private static byte[] getBytes(final String string, final Charset charset) {
        if (string == null) {
            return null;
        }
        return string.getBytes(charset);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a
     * <code>byte[]</code>.
     *
     * @param data
     *            Data to digest
     * @return SHA-1 digest
     * @since 1.7
     */
    public final static byte[] sha1(final byte[] data) {
        return DigestUtils.sha1(data);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a
     * <code>byte[]</code>.
     *
     * @param data
     *            Data to digest
     * @param charset
     *            The {@link Charset} to encode the <code>String</code>
     * @return SHA-1 digest
     * @since 1.7
     */
    public final static byte[] sha1(final String data, final Charset charset) {
        byte[] byteData = getBytes(data, charset);
        if (byteData == null) {
            return null;
        }
        return sha1(byteData);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     *
     * @param data
     *            Data to digest
     * @return SHA-1 digest as a hex string
     * @since 1.7
     */
    public final static String sha1Hex(final byte[] data) {
        return DigestUtils.sha1Hex(data);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     *
     * @param data
     *            Data to digest
     * @param charset
     *            The {@link Charset} to encode the <code>String</code>
     * @return SHA-1 digest as a hex string
     * @since 1.7
     */
    public final static String sha1Hex(final String data, final Charset charset) {
        byte[] byteData = getBytes(data, charset);
        if (byteData == null) {
            return null;
        }
        return sha1Hex(byteData);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     *
     * @param data
     *            Data to digest, a UTF-8 encoded string
     * @return SHA-1 digest as a hex string
     * @since 1.7
     */
    public final static String sha1HexUTF8(final String data) {
        return DigestUtils.sha1Hex(data);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a
     * <code>byte[]</code>.
     *
     * @param data
     *            Data to digest, a UTF-8 encoded string
     * @return SHA-1 digest
     * @since 1.7
     */
    public final static byte[] sha1UTF8(final String data) {
        return DigestUtils.sha1(data);
    }
}
