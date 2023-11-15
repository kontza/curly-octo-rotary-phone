package org.kontza.consulkv;

import com.ecwid.consul.v1.ConsulClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsulWriter implements Consulaattori {
    @Override
    public void doit() {
        var client = new ConsulClient("localhost");
        var keyValueResponse = client.getKVValue(CKEY);
        log.info("Got response {}", keyValueResponse);
        var value = 0L;
        if (keyValueResponse.getValue() != null) {
            log.info("Updating existing value");
            var decoded = Long.parseLong(keyValueResponse.getValue().getDecodedValue());
            value = decoded + 1;
        }
        client.setKVValue(CKEY, String.format("%d", value));
    }
}
