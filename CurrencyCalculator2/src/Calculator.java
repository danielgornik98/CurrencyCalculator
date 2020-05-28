import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DecimalFormat;


public class Calculator {

    public static void main(String[] args) {

        try {
            //passing the arguments
            Float val = Float.parseFloat(args[0]); //value in EUR
            if (val < 0) { //check if 1st param is < 0
                System.out.println("First argument should be floating-point number greater or equal to 0");
                return; //if so, exit program
            }
            String curr = args[1]; //currency we want to convert to
            Boolean isFound = false; //check if we found the right currency
            Float finalRate = 0f; //the currency rate we are looking for

            //How many decimal places should be displayed(2)
            DecimalFormat df = new DecimalFormat("0.00");

            //Setup for parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("eurofxref-daily.xml"); //Accessing xml file
            NodeList cubes = document.getElementsByTagName("Cube"); //Getting all <Cube> elements
            for (int i = 0; i < cubes.getLength(); i++) { //iterating through all <Cube> elements
                Node node = cubes.item(i);
                Element element = (Element) node;
                String finalCurr = element.getAttribute("currency"); //Storing currency name
                if (curr.equals(finalCurr)) { //Checking if we found the right currency
                    isFound = true; //yes we found
                    String rateString = element.getAttribute("rate"); //Storing rate value
                    finalRate = Float.parseFloat(rateString); //converting string to float
                    break; //exiting for_loop
                }
            }
            //if we found the right currency we calculate the final value and print it
            if (isFound) {
                Float finalVal = val * finalRate;
                System.out.println(df.format(finalVal));
            } else { //we inform that we didn't find the currency matching to user's input
                System.out.println("Currency not found");
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

