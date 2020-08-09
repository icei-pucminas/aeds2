## ALGUNS ARQUIVOS INTERESSANTES
* ~/.bash_history      - Lista de comandos executados
* ~/.vimrc             - Configuracoes do VIM
* ~/.profile           - Configuracoes do seu Usuario

## PRINCIPAIS COMANDOS NO VIM
<p>i                             - Abre o modo de insercao
<p>ESC                           - Fecha o modo de insercao
<p>:w                            - Salvar
<p>:q                            - Sair
<p>:q!                           - Forcar saida
<p>:wq!                          - Salvar e forcar a saida
<p>? PALAVRA                     - Procurar as ocorrencias de PALAVRA
<p>:%s/STRING_OLD/STRING_NEW/gc  - Substrituir a STRING_OLD pela STRING_NEW
<p>yy                            - Copiar linha
<p>NUMEROyy                      - Copiar NUMERO linhas
<p>dd                            - Excluir linha
<p>NUMEROdd                      - Excluir NUMERO linhas
<p>dw                            - Excluir palavra
<p>NUMEROdw                      - Excluir NUMERO palavras
<p>p                             - Colar
<p>:sp ARQUIVO                   - Abre o arquivo ARQUIVO 
<p>ww                            - Alternar entre os arquivos abertos
<p>CTRL+V                        - Abre o modo de visualizacao

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
<p>      ˋjavac Programa.javaˋ

2) Executar: 
<p>      ˋjava Programaˋ

3) Executar alterando entrada padrao: 
<p>      ˋjava Programa < entrada.inˋ

4) Executar alterando saida padrao: 
<p>      ˋjava Programa > saida.inˋ

5) Executar alterando entrada/saida padrao: 
<p>      ˋjava Programa < entrada.in > saida.inˋ

# COMPILAR E EXECUTAR PROGRAMA C++ EM LINHA DE COMANDO

1) Compilar: 
<p>      ˋg++ fonte.cc -o objeto`

2) Executar: 
<p>      ˋ./objeto`
      
3) Executar alterando entrada padrao: 
<p>      ˋ./objeto < entrada.in`

4) Executar alterando saida padrao: 
<p>      ˋ./objeto > saida.in`

5) Executar alterando entrada/saida padrao: 
<p>      ˋ./objeto < entrada.in > saida.in`

# GDB

1) Chamar o gdb
<p>      `gdb objeto`

2) Executar no gdb
<p>      ˋrun`

3) Acessar a pilha de chamadas
<p>      ˋbt`
