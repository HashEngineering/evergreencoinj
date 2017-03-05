/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewmitchell.peercoinj.params;

import com.matthewmitchell.peercoinj.core.NetworkParameters;
import com.matthewmitchell.peercoinj.core.Sha256Hash;
import com.matthewmitchell.peercoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends NetworkParameters {
    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1e0fffffL);
        dumpedPrivateKeyHeader = 128+33;
        addressHeader = 33;
        p2shHeader = 85;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 5757;
        packetMagic= 0x21246247L;
        genesisBlock.setDifficultyTarget(0x1e0fffffL);
        genesisBlock.setTime(1448956800L);
        genesisBlock.setNonce(4891360L);
        id = ID_MAINNET;
        spendableCoinbaseDepth = 500;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("00000a02cefbc063ba09034a6fbc123f7062b7ee0e4eed9128a1cadc7533e388"), genesisHash);


        checkpoints.put( 10000, new Sha256Hash("000000004d6c24e275990d09778c28d36aa4c77e7243bb7daa6ea867a7129d7b"));
        checkpoints.put( 20000, new Sha256Hash("000000004e12e6e5a03c3923845a4a198f137ca94a314cf068cff44b04197aa5"));
        checkpoints.put( 30000, new Sha256Hash("0000000026100d9b37836e21c0dcec409ca55dd04882bbed9a796272f1e851f9"));
        checkpoints.put( 40000, new Sha256Hash("00000000042b21154e929d7510d35f4ffcd2c02c6b68da7a5ff3d816b62a65c4"));
        checkpoints.put( 50004, new Sha256Hash("000000000004d1d4032e811c0fc67b01c014492f5f19153b14a0e0d464754561"));
        checkpoints.put( 60000, new Sha256Hash("0000000006f508e1b5f9ca1c97778a546e1866ca30d6c58f3d380fd2b76ea7eb"));
        checkpoints.put( 75002, new Sha256Hash("00000000046abee379b15f4fabbcf47b8f2560012e9d75aa5ecae5351bd15e36"));
        checkpoints.put(100000, new Sha256Hash("000000000bcaadbdc933e448f4b572a3395bc05ba5471b4596fc56ce5806971b"));
        checkpoints.put(125000, new Sha256Hash("000000000797e4891dfec75012ea9937aa910f4cd59f867e64606d04cb303ea9"));
        checkpoints.put(200002, new Sha256Hash("000000004aff3938ebe8e6a0c7a4afc0dc54d20639b06e22c362b5337da5a3b7"));
        checkpoints.put(300001, new Sha256Hash("000000000d059badb1d58cd9a644ddc16c7173395270e5d4460ad376b3b42097"));
        checkpoints.put(400000, new Sha256Hash("000000000d780cb4a5e9d67746e7856bd1b06a8c4d2dd3eea3d6510602685f76"));
        checkpoints.put(431000, new Sha256Hash("0000000000e9c020b6abbfb10d116f6bdf5cd11dd1457bdaa900beb58c1f3f2e"));
        checkpoints.put(446023, new Sha256Hash("00000000245cd1d12f16893305bc4c21357a598916dc7bb54b3873643b42d3d5"));
        checkpoints.put(487135, new Sha256Hash("000000008691d6c33c3e400f369d13f8d59afc527492b7e3255bf539bde7f00d"));
        checkpoints.put(732854, new Sha256Hash("58a6ef4c386b6664875f409da489ac56dcde750bb39f1b88f73f10fe54087faa"));
        checkpoints.put(804006, new Sha256Hash("137146a8e2a4c60eee3ce806aa1b4ab20a9f6118ffd9f7c6b7064ba854e57a5c"));

        dnsSeeds = new String[] {
                "seed.evergreencoin.org",
                "seed2.evergreencoin.org",
                "cwi-seed01.evergreencoin.org",
                "cwi-seed02.evergreencoin.org",
                "cwi-seed03.evergreencoin.org",
                "cwi-seed04.evergreencoin.org",
                "cwi-seed05.evergreencoin.org",
                "cwi-seed06.evergreencoin.org",
                "cwi-seed07.evergreencoin.org",
                "cwi-seed08.evergreencoin.org",
                "cwi-seed09.evergreencoin.org",
                "cwi-seed10.evergreencoin.org",
                "cwi-seed11.evergreencoin.org",
                "cwi-seed12.evergreencoin.org",
                "cwi-seed13.evergreencoin.org",
                "cwi-seed14.evergreencoin.org",
                "cwi-seed15.evergreencoin.org",
                "cwi-seed16.evergreencoin.org",
                "cwi-seed17.evergreencoin.org",
                "cwi-seed18.evergreencoin.org",
                "cwi-seed19.evergreencoin.org",
                "cwi-seed20.evergreencoin.org",
                "cwi-seed21.evergreencoin.org",
                "cwi-seed22.evergreencoin.org",
                "cwi-seed23.evergreencoin.org",
                "cwi-seed25.evergreencoin.org"
        };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }

    @Override
    public String toString() {
        return "EverGreenCoin";
    }

}
