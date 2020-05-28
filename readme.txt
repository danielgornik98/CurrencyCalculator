How to run CurrencyCalculator2:

a)In cmd: !!!xml file must be in the same folder as jar file!!!
	1.Go to CurrencyCalculator2\out\artifacts\CurrencyCalculator2_jar
	2.Open cmd and type "java -jar CurrencyCalculator2.jar arg1 arg2" where:
		i)arg1 is floating-point number, greater or equal to 0, representing value in EUR you want to convert (use "." for point, not ",") 
		ii)arg2 is representing currency name in ISO 4217 you want to convert to
	3.Execute the line

b)In IDE:
	1.Open project CurrencyCalculator2
	2.In Run/Debug Configurations add two program arguments:
		i)first one is floating-point number, greater or equal to 0, representing value in EUR you want to convert (use "." for point, not ",")
		ii)second one is representing currency name in ISO 4217 you want to convert to
	3.Apply changes and run the code