package com.hashengineering.crypto;

//import org.bitcoinj.core.Sha256Hash;

//import fr.cryptohash.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hash Engineering on 4/24/14 for the X15 algorithm
 */
public class X15 {

    private static final Logger log = LoggerFactory.getLogger(X15.class);
    private static boolean native_library_loaded = false;

    static {

        try {
            System.loadLibrary("x15");
            log.info("Load success:  x15 native library: ");
            native_library_loaded = true;
        }
        catch(UnsatisfiedLinkError x)
        {
            log.error("cannot load x15 native library: " + x.getMessage());
            native_library_loaded = false;
            try {
                System.load("/development/hashengineering/evergreencoin/new-version/bitcoinj/jni/libx15.so");
                native_library_loaded = true;
            } catch (UnsatisfiedLinkError x2)
            {
                native_library_loaded = false;
            }
        }
        catch(Exception e)
        {
            log.error("cannot load x15 native library: " + e.getMessage());
            native_library_loaded = false;
        }
    }

    public static byte[] x15Digest(byte[] input, int offset, int length)
    {
        return x15_native(input, offset, length);
    }

    public static byte[] x15Digest(byte[] input) {
        //long start = System.currentTimeMillis();
        try {
            return native_library_loaded ? x15_native(input, 0, input.length) : null;
        } catch (Exception e) {
            return null;
        }
        finally {
            //long time = System.currentTimeMillis()-start;
            //log.info("X15 Hash time: {} ms per block", time);
        }
    }

    static native byte [] x15_native(byte [] input, int offset, int length);



}
