### Pontos que necessitam ser reforçados

1- Companion object

    De acordo com o a documentação do Kotlin, as declarações de objeto ou object declarations criam um Singleton de maneira fácil.

2- Object expression

    Object expressions create objects of anonymous classes, that is, classes that aren't explicitly declared with the class declaration. Such classes are useful for one-time use. You can define them from scratch, inherit from existing classes, or implement interfaces. Instances of anonymous classes are also called anonymous objects because they are defined by an expression, not a name.


3- Object declaration

    The Singleton pattern can be useful in several cases, and Kotlin makes it easy to declare singletons:

4 - Equals and Hashcode differences

5 - Data class
    
    É uma classe para manter os dados, não é possivel ter comportamentos, apenas atributos
    Implementa os métodos de equals, hashCode e toString(), as validações desses metodos serão baseados nas properties

    O construtor precisa ter sempre as properties, nào é possivel passar as variaveis   


    Alem dos metodos que herdam da Object, ainda existem as funções de component e copy
    Com a existencia das functions components, é possivel realizar as desestruturações de membros de uma classe, essa desestruturação é feita através da ordem dos membros.
    Já o metodo copy, faz a copia exata de um objeto, copiando todas os dados do objeto. 


6 - Delegation 
    
   Como utilizar delegation no kotlin


7 - Null safety

   Diferentes checagens de nullables




--- 
### Kotlin  Coleções, arrays e listas
1. Funções agregadoras
