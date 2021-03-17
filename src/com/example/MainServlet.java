package com.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.constants.JnlpConstants;
import com.example.model.binding.AppletDescTag;
import com.example.model.binding.InformationTag;
import com.example.model.binding.Jnlp;
import com.example.model.binding.ResourcesTag;
import com.example.model.binding.UpdateTag;

//TODO: Check JnlpDownloadServlet
@WebServlet("")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = -4989436189609281658L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {
        
        try {
            createJnlpFile();
        } catch (JAXBException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        res.setContentType("application/x-java-jnlp-file");
        res.setHeader("Cache-Control", "no-store");
        res.setHeader("Pragma", "no-cache");
        res.setDateHeader("Expires", 0);
        req.getRequestDispatcher("/WEB-INF/pages/test.jsp").forward(req, res);
    }    
    
    private void createJnlpFile() throws JAXBException {
        
        InformationTag informationTag = new InformationTag(JnlpConstants.INFORMATION_TITLE, JnlpConstants.INFORMATION_VENDOR);
        Map<String, String> jarToVersion = new HashMap<>();
        jarToVersion.put("change_me", "1.0");
        jarToVersion.put("change_me", "1.0");
        jarToVersion.put("change_me", "1.0");
        ResourcesTag resourcesTag = new ResourcesTag(JnlpConstants.RESOURCES_J2SE_VERSION, jarToVersion);
        Map<String, String> parametersByName = new HashMap<>();
        parametersByName.put("param1", "true");
        parametersByName.put("param2", "true");
        parametersByName.put("param3", "true");
        parametersByName.put("param4", "true");
        parametersByName.put("param5", "100");
        AppletDescTag appletDescTag = new AppletDescTag(parametersByName);
        UpdateTag updateTag = new UpdateTag();
        
        Jnlp jnlpFile = new Jnlp(JnlpConstants.JNLP_FILE_NAME, informationTag, 
            resourcesTag, appletDescTag, updateTag);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Jnlp.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(jnlpFile, new File(getServletContext().getRealPath(JnlpConstants.JNLP_FILE_NAME)));
    }
}