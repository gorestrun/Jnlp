package com.example.model.binding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.constants.JnlpConstants;

@XmlRootElement(name = "applet-desc")
public class AppletDescTag  {

    @XmlAttribute(name = "main-class")
    private String mainClass = JnlpConstants.APPLET_DESC_MAIN_CLASS;
    
    @XmlAttribute
    private String name = JnlpConstants.APPLET_DESC_NAME;
    
    @XmlAttribute
    private String width = JnlpConstants.APPLET_DESC_WIDTH;
    
    @XmlAttribute
    private String height = JnlpConstants.APPLET_DESC_HEIGHT;
    
    @XmlElement(name = "param")
    private List<Param> params = new ArrayList<>();
    
    public AppletDescTag() {
    }
    
    public AppletDescTag(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Param param = new Param(entry.getKey(), entry.getValue());
            this.params.add(param);
        }
    }
}

@XmlRootElement
class Param {
    @XmlAttribute
    private String name;
    
    @XmlAttribute
    private String value;
    
    public Param() {
    }

    public Param(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
