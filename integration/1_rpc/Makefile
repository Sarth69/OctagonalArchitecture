
.PHONY: all clean

PROGS = random_server random_client

GENERATED_SRC = random_client.c random_clnt.c random_server.c random_svc.c random_xdr.c

OBJS = $(GENERATED_SRC:%.c=%.o)

CPPFLAGS += -DDEBUG -I/usr/include/tirpc
LDFLAGS += -ltirpc

all: $(PROGS)

random_server: random_server.o random_svc.o random_xdr.o
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

random_client: random_client.o random_clnt.o random_xdr.o
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^

$(GENERATED_SRC): random.x
	rpcgen -a -C random.x
	(echo '#include <stdlib.h>' && cat random_client.c) >tmp.txt && mv tmp.txt random_client.c
	(echo '#include <stdio.h>' && cat random_client.c) >tmp.txt && mv tmp.txt random_client.c

%.o: %.c
	$(CC) -c $(CFLAGS) $(CPPFLAGS) -o $@ $<

clean:
	rm -f $(PROGS) $(OBJS) $(GENERATED_SRC) random.h
