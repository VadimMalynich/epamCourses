package by.training.task08xml.service.validators;

import by.training.task08xml.service.exceptions.PostCardErrorHandler;
import by.training.task08xml.service.exceptions.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLFileValidator {
    public void validateXMLFile(String fileName, String schemaFile) throws ServiceException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File file = new File(schemaFile);
        try {
            Schema schema = factory.newSchema(file);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new PostCardErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            throw new ServiceException(e);
        }
    }
}
