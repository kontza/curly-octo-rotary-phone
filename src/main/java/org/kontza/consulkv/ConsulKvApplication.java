package org.kontza.consulkv;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsulKvApplication implements ApplicationRunner {

    private static final int ITERATION_LIMIT = 60;

    public static void main(String[] args) {
        SpringApplication.run(ConsulKvApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (String nonOptionArg : args.getNonOptionArgs()) {
            switch (nonOptionArg.substring(0, 1)) {
                case "e":
                    new ConsulEraser().doit();
                    break;
                case "w":
                    new ConsulWriter().doit();
                    break;
                default:
                    var client = new ConsulReader();
                    var counter = 0;
                    while (counter++ < ITERATION_LIMIT) {
                        client.doit();
                        Thread.sleep(1000);
                    }
                    break;
            }
        }
    }
}
