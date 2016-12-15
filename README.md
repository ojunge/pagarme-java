 PagarMe Java
 =============

'Biblioteca não Oficial'

Essa biblioteca  tem como objetivo, auxiliar o desenvolvedor Java a integrar seu projeto com os serviços do Gateway de Pagamento 'PagarMe'.
Através da mesma é possível executar as funções básicas de buscas, alteração, remoção e execução de novas transações.

Recursos
-----------
*Planos
*Codigos Postais
*Recebedores em casos de marketplace


Dependências
-----------
httpasyncclient-4.0.2.jar
httpclient-4.3.6.jar
httpcore-4.3.3.jar
httpcore-nio-4.3.jar
httpmime-4.3.6.jar
json-20140107.jar
org-apache-commons-logging.jar
unirest-java-1.4.9.jar

Maven
-----------
O pom.xml do projeto esta dentro do diretorio Pagarme. Use-o para abrir o projeto usando o Maven.
Para compilar basta executar o `mvn package` dentro do diretório Pagarme


Demo
-----------
Nesse respositório há um projeto nomeado PagarmeTest, nele contem a demonstração de todas as funcionalidades

Segue Exemplo Abaiixo:

```java
	PagarMeProvider instance = PagarMeProvider.getInstance();
	instance.setApi_key("minha_key");

	PlanService service = new PlanService();
	ArrayList<Plan>	plans = service.findAll();
```
