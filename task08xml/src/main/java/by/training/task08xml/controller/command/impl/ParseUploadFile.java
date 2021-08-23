package by.training.task08xml.controller.command.impl;

import by.training.task08xml.controller.command.WebCommand;
import by.training.task08xml.service.builder.AbstractPostcardsBuilder;
import by.training.task08xml.service.builder.PostcardBuilderFactory;
import by.training.task08xml.service.exceptions.ServiceException;
import by.training.task08xml.service.validators.XMLFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.web.WebLoggerContextUtils;


import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

import static org.apache.logging.log4j.web.WebLoggerContextUtils.getServletContext;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class ParseUploadFile /*implements WebCommand*/ extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
    private static final String SCHEMA_FILE = File.separator + "WEB-INF/schema/oldCards.xsd";
//    private static final Logger userLogger = LogManager.getLogger(ParseUploadFile.class);

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        String model = request.getParameter("parserType");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        String schemaPath = appPath + SCHEMA_FILE;
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part part = request.getPart("xmlFile");
        String fileName = extractFileName(part);
        // refines the fileName in case it is an absolute path
        fileName = new File(fileName).getName();
        savePath += File.separator + fileName;
        if (!fileName.isEmpty()) {
            part.write(savePath);
        }

        try {
            XMLFileValidator validator = new XMLFileValidator();
            validator.validateXMLFile(savePath, schemaPath);
            AbstractPostcardsBuilder builder = PostcardBuilderFactory.createPostcardBuilder(model);
            builder.buildSetPostcards(savePath);
            request.setAttribute("message", "Schema was parsed by " + model + " model!");
            request.setAttribute("postcards", builder.getPostcards());
            request.setAttribute("adPostcards", builder.getAdPostcards());
            request.setAttribute("greetingPostcards", builder.getGreetingPostcards());
        } catch (ServiceException e) {
            log(String.valueOf(e));
            request.setAttribute("message", "The uploaded xml file does not match the schema!");
        }
        request.setCharacterEncoding("UTF-8");
        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // gets absolute path of the web application
//
//        String appPath = request.getServletContext().getRealPath("");
//        String model = request.getParameter("parserType");
//        // constructs path of the directory to save uploaded file
//        String savePath = appPath + File.separator + SAVE_DIR;
//        String schemaPath = appPath + SCHEMA_FILE;
//        // creates the save directory if it does not exists
//        File fileSaveDir = new File(savePath);
//        if (!fileSaveDir.exists()) {
//            fileSaveDir.mkdir();
//        }
//
//        Part part = request.getPart("xmlFile");
//        String fileName = extractFileName(part);
//        // refines the fileName in case it is an absolute path
//        fileName = new File(fileName).getName();
//        savePath += File.separator + fileName;
//        if (!fileName.isEmpty()) {
//            part.write(savePath);
//        }
//
//        try {
//            XMLFileValidator validator = new XMLFileValidator();
//            validator.validateXMLFile(savePath, schemaPath);
//            AbstractPostcardsBuilder builder = PostcardBuilderFactory.createPostcardBuilder(model);
//            builder.buildSetPostcards(savePath);
//            request.setAttribute("message", "Schema was parsed by " + model + " model!");
//            request.setAttribute("postcards", builder.getPostcards());
//            request.setAttribute("adPostcards", builder.getAdPostcards());
//            request.setAttribute("greetingPostcards", builder.getGreetingPostcards());
//        } catch (ServiceException e) {
//            final Logger userLogger = LogManager.getLogger(ParseUploadFile.class);
//            userLogger.error(e);
//            request.setAttribute("message", "The uploaded xml file does not match the schema!");
//        }
//
//        getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
//    }
}
