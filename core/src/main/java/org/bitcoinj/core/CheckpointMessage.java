package org.bitcoinj.core;

/**
 * Created by hashengineering on 7/27/18.
 */
public class CheckpointMessage extends EmptyMessage {
    CheckpointMessage(NetworkParameters params) {
        super(params);
        length = 0;
    }
}
