import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    static Document document;

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // валидация схемы
            String schemaPath = ".\\src\\main\\resources\\xml\\chat.xsd";
            String xmlPath = ".\\src\\main\\resources\\xml\\chat.xml";
            SchemaValidator.schemaValidator(schemaPath, xmlPath);

            File stylesheet = new File(".\\src\\main\\resources\\xml\\users.xsl");
            File fileSource = new File(".\\src\\main\\resources\\xml\\chat.xml");

            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileSource);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            DOMSource source = new DOMSource(document);

            FileOutputStream fos = new FileOutputStream(".\\src\\main\\resources\\xml\\users.html");
            StreamResult result = new StreamResult(fos);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {

            System.out.println("\n** Transformer Factory error");
            System.out.println("   " + ex.getMessage());

            Throwable exception = ex;
            if (ex.getException() != null) {
                exception = ex.getException();
            }
            // tce exception
            exception.printStackTrace();
        } catch (TransformerException ex) {
            System.out.println("\n** Transformation error");
            System.out.println("   " + ex.getMessage());
            Throwable exception = ex;

            if (ex.getException() != null) {
                //transformer exception
                exception = ex.getException();
            }

            exception.printStackTrace();
        } catch (SAXException ex) {
            Exception exception = ex;

            if (ex.getException() != null) {
                // sax exception
                exception = ex.getException();
            }

            exception.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            // io exception
            ex.printStackTrace();
        }
    }
}
