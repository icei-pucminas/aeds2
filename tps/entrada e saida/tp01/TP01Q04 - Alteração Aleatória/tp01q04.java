/*
 * Alteração Aleatória - Crie um m ́etodo iterativo que recebe uma string, sorteia duas letras
min ́usculas aleat ́orias (c ́odigo ASCII ≥ ’a’ e ≤ ’z’), substitui todas as ocorrˆencias da primeira
letra na string pela segunda e retorna a string com as altera ̧c ̃oes efetuadas. Na sa ́ıda padr ̃ao,
para cada linha de entrada, execute o m ́etodo desenvolvido nesta quest ̃ao e mostre a string
retornada como uma linha de sa ́ıda. Abaixo, observamos um exemplo de entrada supondo que
para a primeira linha as letras sorteados foram o ’a’ e o ’q’. Para a segunda linha, foram o ’e’ e
o ’k’.
EXEMPLO DE ENTRADA: EXEMPLO DE SA ́IDA:
o rato roeu a roupa do rei de roma o rqto roeu q roupq do rei de romq
e qwe qwe qwe ewq ewq ewq k qwk qwk qwk kwq kwq kwq
FIM
A classe Random do Java gera n ́umeros (ou letras) aleat ́orios e o exemplo abaixo mostra uma
letra min ́uscula na tela. Em especial, destacamos que: i) seed  ́e a semente para gera ̧c ̃ao de
n ́umeros aleat ́orios; ii) nesta quest ̃ao, por causa da corre ̧c ̃ao autom ́atica, a seed ser ́a quatro; iii)
a disciplina de Estat ́ıstica e Probabilidade faz uma discuss ̃ao sobre “aleat ́orio”.
1 Random gerador = new Random ( ) ;
2 gerador . setSeed ( 4 ) ;
3 System . out . println ( ( char ) ( ’ a ’ + (Math. abs ( gerador . nextInt ( ) ) % 2 6 ) ) ) ;
 */