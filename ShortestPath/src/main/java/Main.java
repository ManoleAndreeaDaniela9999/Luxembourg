
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        jakarta.xml.bind.JAXBContext jaxbContext = null;
        try {

            // Normal JAXB RI
            jaxbContext = JAXBContext.newInstance(Map.class);

            // EclipseLink MOXy needs jaxb.properties at the same package with Fruit.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.
            //jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
            //        .createContext(new Class[]{Node.class}, null);

            File file = new File("src/main/resources/map2.xml");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Map map = (Map) jaxbUnmarshaller.unmarshal(file);

            for (Arc a:
                 map.getArcs().getArcs()) {
                System.out.println(a);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
