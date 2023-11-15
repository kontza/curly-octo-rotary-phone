package org.kontza.consulkv;

import com.ecwid.consul.v1.ConsulClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsulEraser implements Consulaattori {
    @Override
    public void doit() {
        var client = new ConsulClient("localhost");
        client.deleteKVValue(CKEY);
        log.info("Deleted KV {}", CKEY);
    }
}
