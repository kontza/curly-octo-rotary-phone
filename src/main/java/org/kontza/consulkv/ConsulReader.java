package org.kontza.consulkv;

import com.ecwid.consul.v1.ConsulClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsulReader implements Consulaattori {
    @Override
    public void doit() {
        var client = new ConsulClient("localhost");
        var keyValueResponse = client.getKVValue(CKEY);
        log.debug("Got response {}", keyValueResponse);
        if (keyValueResponse.getValue() != null) {
            log.info("{}: {}", CKEY, keyValueResponse.getValue().getDecodedValue());
        } else {
            log.info("{}: N/A", CKEY);
        }
    }
}
