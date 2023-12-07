package Lesson_4.Home_Work;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExportToXML {
    public ExportToXML(File file) {

        try (FileWriter fr = new FileWriter(file, false);) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<TaskList>\n");
            for (Task task : TaskTree.getList()) {
                //strBuilder.setLength(0);
                strBuilder.append("<task>\n<createDate>");
                strBuilder.append(task.getCreateDate());
                strBuilder.append("</createDate>\n");
                strBuilder.append("<createTime>");
                strBuilder.append(task.getCreateTime());
                strBuilder.append("</createTime>\n");
                strBuilder.append("<deadline>");
                strBuilder.append(task.getDeadline());
                strBuilder.append("</deadline>\n");
                strBuilder.append("<author>");
                strBuilder.append(task.getAuthor());
                strBuilder.append("</author>\n");
                strBuilder.append("<taskDescription>");
                strBuilder.append(task.getTaskDescription());
                strBuilder.append("</taskDescription>\n</task>\n");
            }
            strBuilder.append("</TaskList>");
            fr.append(strBuilder.toString());
        } catch (IOException e) {
            System.out.printf("UPS! Write error. Tasks wasn`t saved to disk. %s", e);
        }
    }
}
