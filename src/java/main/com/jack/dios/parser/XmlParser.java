package com.jack.dios.parser;

import com.jack.dios.config.Configuration;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathFactory;
import java.io.File;

/**
 *
 * @Author: peng.du1
 * @Date: 2020/4/11 22:00
 */
public class XmlParser {

    private static DocumentBuilderFactory documentBuilderFactory;
    public static XPathFactory xPathFactory;


    static {
        documentBuilderFactory=DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        xPathFactory=XPathFactory.newInstance();
    }
    public Configuration parse(File file)  {
        Document document=null;
        try {
             document = getDocument(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return doParse(document);
    }

    public Document getDocument(File fileName) throws Exception {
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void warning(SAXParseException exception) throws SAXException {
                // NOP
            }
        });
        return builder.parse(fileName);
    }

    public Configuration doParse(Document document){
        return null;
    }

}
