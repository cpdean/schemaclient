# schemaclient

A beginner's framework for building their own client to [Schemaverse](http://www.schemaverse.com).



## Usage

First copy `sample-local-server.sh` to `local-server.sh` so that your personal deploy script is ignored by version control.

```shell
cp sample-local-server.sh local-server.sh
```

Now edit `local-server.sh` to have your Schemaverse credentials, get leiningen dependencies and deploy!

```shell
vim local-server.sh
lein deps
./local-server.sh
```

