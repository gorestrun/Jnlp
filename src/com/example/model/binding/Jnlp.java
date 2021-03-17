package com.example.model.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.example.constants.JnlpConstants;

@XmlRootElement(name = "jnlp")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"informationTag", "resourcesTag", "appletDescTag", "updateTag"})
public class Jnlp{

    @XmlAttribute
    private String spec = JnlpConstants.JNLP_SPEC;
    
    @XmlAttribute 
    private String codeBase = JnlpConstants.JNLP_CODEBASE; 
    
    @XmlAttribute
    private String href = JnlpConstants.JNLP_FILE_NAME;
    
    @XmlElement(name = "information")
    private InformationTag informationTag;

    @XmlElement(name = "resources")
    private ResourcesTag resourcesTag;
    
    @XmlElement(name = "applet-desc")
    private AppletDescTag appletDescTag;
    
    @XmlElement(name = "update")
    private UpdateTag updateTag;
    
    public Jnlp() {
    }

    public Jnlp(String href, InformationTag informationTag, 
        ResourcesTag resourcesTag, AppletDescTag appletDescTag, UpdateTag updateTag) {
        this.href = href;
        this.informationTag = informationTag;
        this.resourcesTag = resourcesTag;
        this.appletDescTag = appletDescTag;
        this.updateTag = updateTag;
    }
}
