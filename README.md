 PagarMejava
 =============
 
'Biblioteca não Oficial'

Essa biblioteca  tem como objetivo, auxiliar o desenvolvedor Java a integrar com os serviços do Gateway de Pagamento 'PagarMe'.
Através da mesma é possível executar as funções básicas de buscas, alteração, remoção e adicionar.

Recursos
-----------
*Planos
*Codigos Postais


Dependências
-----------
httpasyncclient-4.0.2.jar
httpclient-4.3.6.jar
httpcore-4.3.3.jar
httpcore-nio-4.3.jar
httpmime-4.3.6.jar
json-20140107.jar
org-apache-commons-logging.jar
unirest-java-1.4.5.jar

Maven
-----------
Em breve


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

