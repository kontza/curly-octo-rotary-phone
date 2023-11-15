# TL;DR
1. Start Consul, or use an existing instance running on `localhost`:

    ```
    $ tmux new -d consul agent --dev
    ```
3. Start a reader instance:

    ```
    $ java -jar consul-kv-0.0.1-SNAPSHOT.jar read
    ```
3. In another terminal, update/erase value:

    ```
    $ java -jar consul-kv-0.0.1-SNAPSHOT.jar write
    $ java -jar consul-kv-0.0.1-SNAPSHOT.jar erase
    ```
