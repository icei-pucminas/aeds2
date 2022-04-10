all: exec
 
exec: principal.o geracao.o bolha.o countingsort.o heapsort.o insercao.o mergesort.o quicksort.o selecao.o shellsort.o
	gcc -o exec principal.o geracao.o bolha.o countingsort.o heapsort.o insercao.o mergesort.o quicksort.o selecao.o shellsort.o
 
principal.o: principal.c 
	gcc -o principal.o principal.c -c -W -Wall -pedantic
 
bolha.o: bolha.c 
	gcc -o bolha.o bolha.c -c -W -Wall -pedantic

countingsort.o: countingsort.c 
	gcc -o countingsort.o countingsort.c -c -W -Wall -pedantic

geracao.o: geracao.c 
	gcc -o geracao.o geracao.c -c -W -Wall -pedantic

heapsort.o: heapsort.c 
	gcc -o heapsort.o heapsort.c -c -W -Wall -pedantic

insercao.o: insercao.c 
	gcc -o insercao.o insercao.c -c -W -Wall -pedantic

mergesort.o: mergesort.c 
	gcc -o mergesort.o mergesort.c -c -W -Wall -pedantic

quicksort.o: quicksort.c 
	gcc -o quicksort.o quicksort.c -c -W -Wall -pedantic

selecao.o: selecao.c 
	gcc -o selecao.o selecao.c -c -W -Wall -pedantic

shellsort.o: shellsort.c 
	gcc -o shellsort.o shellsort.c -c -W -Wall -pedantic

clean:
	rm -rf *.o *~ exec

limpa: 
	rm -rf *.o  
