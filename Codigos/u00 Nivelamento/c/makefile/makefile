# My first makefile

all: printy

printy: main.o helloworld.o
	gcc -o printy main.o helloworld.o

main.o: main.c helloworld.h
	gcc -o main.o main.c -c -W -Wall -ansi -pedantic

helloworld.o: helloworld.c helloworld.h
	gcc -o helloworld.o helloworld.c -c -W -Wall -ansi -pedantic

clean:
	rm -rf *.o *~ printy
