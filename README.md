# TRABALHO_PRATICO_OO
Trabalho Prático de Orientação a Objetos
UnB - Universidade de Brasilia
FGA - Faculdade do Gama
Prof. André Luiz Peron Martins Lanna

## Membros


| Nome | Matrícula |
| - | - |
| Leonardo Milomes Vitoriano | 20/1000379 |
| Gabriel do Nascimento de Carvalho | 13/0111147 |
| Matheus Phillipo Silverio Silva | 15/0154348 |
| Leonardo Michalski Miranda | 19/0046945 |
| Renan Rodrigues Lacerda | 19/0048191 |
| Vinícius Alves de Sousa | 19/0096373 |

# Funcionalidades do Projeto

## Uso da Interface Impressora

Na interface impressora foi encapsulada um metodo "escreveTxt()" para realizar as funcionalidades de criação e escrita dos arquivos que persistem os dados dos moradores e das despesas, as classes "CadastroDespesa" e "CadastroMorador" implementam esse método.

## CÁLCULO DAS CONTRIBUIÇÕES

Para o cálculo das contribuições das despesas, foi utilizado a classe “Contribuição”, e por meio da herança, mecanismo da Orientação a Objeto que permite criar novas classes a partir de classes já existentes, foram criadas as classes filhas, “Igualitária” e “Proporcional”. Na classe pai (Contribuição), declaramos o método “calcularContribuicao()” para realizar os cálculos da contribuição de cada morador, e o método “arredondar()” responsável pelo arredondamento dos valores de porcentagem e do valor a ser pago em reais por cada morador. Apenas o método “calcularContribuicao()” foi sobrescrito, mecanismo (polimorfismo) para realizar as formas diferentes de cálculo. 

Em “Igualitaria”, é apresentado o total das despesas, junto com o resultado dos cálculos da porcentagem referente o total de despesa do mês e do valor que todos devem pagar igualmente. Em “Proporcional”, calcula a divisão das dívidas considerando a capacidade de pagamento de cada morador conforme sua renda mensal, apresentando em porcentagem e em reais qual deve ser a sua participação com o pagamento das dívidas do mês. O cálculo da proporcionalidade foi feito usando o rendimento de cada morador diretamente proporcional ao total de despesas, para isso calcula-se a razão entre o total de despesas e o rendimento total dos moradores para encontrar a constante de proporcionalidade ‘k’ e assim multiplica-se pelo rendimento de cada morador, achando a parcela que cada um deve pagar das despesas.

## UI

A classe User Interface (UI), situada no pacote app, possuí associação única  e escopo estático com as classes, situadas no pacote Sistema de Gerenciamento de República (SGR),  CadastroMoradores,  CadastroDespesas, Igualitaria e Porporcional. Sendo assim, o objetivo principal da UI é tratar da interação com o usuário através de um menu de opções de um SGR e tudo isso ocorre a partir do método ApresentarMenu(). Em cada opção do menu será executado um conjunto de métodos de uma classe associada à UI e o método sendo excutado dentro da classe, praticando, então, o encapsulamento. 

## Registro de dados em arquivo

Todos os dados referentes à republica (registro de moradores e registro de despesas) foram persistidos em arquivos de texto e utilizados durante toda a execução do programa. Foram utilizados métodos como escreve() situados dentro das classes CadastroDespesa e CadastroMorador e métodos para leitura dos arquivos

## Cadastro de Moradores

A classe “CadastroMoradores” é a responsável por criar uma lista de moradores. Sendo ela capaz de tratar as exceções: sem categoria (CategoriaNaoInformadaException), sem descrição (DescricaoNaoInformadaException), sem Valor (ValorNaoInformadoException) entre outras. A classe “CadastroMoradores” implementa a interface "Impressora", logo essa classe necessita possuir o método void  “escreve”, ele é o responsável por escrever os moradores em um arquivo .txt. Essa classe também possui o método “apagarRep”, que permite apagar o arquivo com os dados dos moradores, caso seja pedido pelo usuário, além de ler o arquivo para poder continuar com com os dados que o usuário já teria computado. Calcula também o rendimento total dos moradores, para que outras classes que necessitem desse dado os tenha por meio do método “getRendimentoTotal”.

## O cadastro das despesas

A classe (CadastroDespesas) é responsável por criar três lista encadeadas que serão responsáveis por toda a implementação do cadastro de despesas da república. Para isso, dentro dessa classe foram criados três métodos:
cadastrarCategoria
cadatrarSubcategoria
cadastrarDespesas

O sistema segue essa ordem, ou seja, não é possível cadastrar uma despesa sem antes cadastrar uma categoria de despesa, da mesma forma, não é possível cadastrar uma subcategoria sem antes cadastrar uma categoria. 

Utilizamos de vários recursos da Orientação a Objetos, por exemplo, a classe implementa a interface impressora para poder persistir os dados em arquivos Txt. 

Para diminuir a chance de erro do usuário, utilizamos o JOptionPane com Drop Down List, um ótimo exemplo dessa implementação está no cadastro de subcategoria, pois o usuário terá que selecionar uma categoria da lista antes de poder cadastrar uma subcategoria dela (Visualizar linha 353 da classe CadastroDespesas).

## UML
Link para o digrama UML: [somente visualizar](https://drive.google.com/file/d/1OaB-kX9WJt7fJtqTJK44727gU-VlxuPL/view?usp=sharing).
<!-- ; [editar](). -->


