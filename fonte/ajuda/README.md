## ALGUNS ARQUIVOS INTERESSANTES
* ~/.bash_history      - Lista de comandos executados
* ~/.vimrc             - Configuracoes do VIM
* ~/.profile           - Configuracoes do seu Usuario

## PRINCIPAIS COMANDOS NO VIM
* i                             - Abre o modo de insercao
* ESC                           - Fecha o modo de insercao
* :w                            - Salvar
* :q                            - Sair
* :q!                           - Forcar saida
* :wq!                          - Salvar e forcar a saida
* ? PALAVRA                     - Procurar as ocorrencias de PALAVRA
* :%s/STRING_OLD/STRING_NEW/gc  - Substrituir a STRING_OLD pela STRING_NEW
* yy                            - Copiar linha
* NUMEROyy                      - Copiar NUMERO linhas
* dd                            - Excluir linha
* NUMEROdd                      - Excluir NUMERO linhas
* dw                            - Excluir palavra
* NUMEROdw                      - Excluir NUMERO palavras
* p                             - Colar
* :sp ARQUIVO                   - Abre o arquivo ARQUIVO 
* ww                            - Alternar entre os arquivos abertos
* CTRL+V                        - Abre o modo de visualizacao

## ALGUNS COMANDOS PARA O MODO SHELL DO LINUX
* man
* exit
* cd
* ls
* ls -l -t -h
* rm
* cp
* mkdir
* clear
* grep
* grep "PALAVRA" ARQUIVO
* diff
* diff ARQUIVO1 ARQUIVO2
* ssh
* sftp
* wget
* chmod
* javac
* java
* tar -zcvf arquivo.tar.gz pasta
* tar -zxvf arquivo.tar.gz

## COMPILAR E EXECUTAR PROGRAMA JAVA EM LINHA DE COMANDO

1) Compilar: 
>      javac Programa.java

2) Executar: 
>      java Programa

3) Executar alterando entrada padrao: 
>      java Programa < entrada.in

4) Executar alterando saida padrao: 
>      java Programa > saida.in

5) Executar alterando entrada/saida padrao: 
>      java Programa < entrada.in > saida.in

## COMPILAR E EXECUTAR PROGRAMA C++ EM LINHA DE COMANDO

1) Compilar: 
>      g++ fonte.cc -o objeto

2) Executar: 
>       ./objeto
      
3) Executar alterando entrada padrao: 
>      ./objeto < entrada.in

4) Executar alterando saida padrao: 
>      ./objeto > saida.in

5) Executar alterando entrada/saida padrao: 
>      ./objeto < entrada.in > saida.in

## GDB
1) Chamar o gdb
>     gdb objeto

2) Executar no gdb
>      run

3) Acessar a pilha de chamadas
>      bt
