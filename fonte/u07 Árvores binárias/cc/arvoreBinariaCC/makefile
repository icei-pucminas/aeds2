all: exec
 
exec: principal.o arvorebinaria.o no.o 
	g++ -o exec principal.o arvorebinaria.o no.o
 
principal.o: principal.cc arvorebinaria.h no.h
	g++ -o principal.o principal.cc -c -W -Wall -ansi -pedantic
 
arvorebinaria.o: arvorebinaria.cc arvorebinaria.h no.h
	g++ -o arvorebinaria.o arvorebinaria.cc -c -W -Wall -ansi -pedantic
 
no.o: no.cc no.h
	g++ -o no.o no.cc -c -W -Wall -ansi -pedantic

clean:
	rm -rf *.o *~ exec
