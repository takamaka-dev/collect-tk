/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package io.takamaka.app.collecttkg;

import io.takamaka.wallet.utils.FixedParameters;
import io.takamaka.wallet.utils.TkmSignUtils;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HexFormat;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Giovanni Antino giovanni.antino@takamaka.io
 */
@Slf4j
public class CollectTKG {

    public static final String target = "000000";
    public static final long challengeID = 4235445L;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static final String challengeString = "gatto rosa 12";

    public static void main(String[] args) {
        long maxRange = 2000000000L;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int threadScale = availableProcessors * availableProcessors * 2;
        System.out.println("Hello World!");
        log.info("hi");
        long curr = 0;
        ConcurrentSkipListSet<Boolean> killClausole = new ConcurrentSkipListSet<>();
        ConcurrentSkipListMap<Long, String> sol = new ConcurrentSkipListMap<>();
        final String post = "my_address" + challengeID + challengeString;
        do {
            LongStream.range(curr, curr + threadScale).parallel().forEach(i -> {
                try {
                    byte[] hash256Byte = TkmSignUtils.Hash256Byte((i + post).getBytes(), FixedParameters.HASH_256_ALGORITHM);
                    String fromBytesToHexString = fromBytesToHexString(hash256Byte);
                    if (fromBytesToHexString.startsWith(target)) {
                        killClausole.add(Boolean.TRUE);
                        sol.put(i, fromBytesToHexString);
                    }
//                log.info(fromBytesToHexString(hash256Byte));
                } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
                    log.error("ooooopz", ex);
                }
            });
            curr += threadScale;
        } while (curr < maxRange & !killClausole.contains(Boolean.TRUE));
        log.info(sol.firstEntry().getValue());
        log.info(sol.firstEntry().getKey() + "");
    }

    public static final String fromBytesToHexString(byte[] bytes) {
//        StringBuffer sb = new StringBuffer(target)
        int lnC = bytes.length;
        char[] cRes = new char[lnC * 2];
        IntStream.range(0, lnC).parallel().forEach(i -> {
//             cRes[i] = (char) bytes[i];
            int v = bytes[i] & 0xFF;
            cRes[i * 2] = HEX_ARRAY[v >>> 4];
            cRes[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
            //cRes[i] = String.format("", args);
        });
        return String.valueOf(cRes);
    }

}
