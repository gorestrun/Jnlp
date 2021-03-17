package com.example.model.binding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.constants.JnlpConstants;

@XmlRootElement(name = "resources")
public class ResourcesTag {

    @XmlElement(name = "j2se")
    private J2se j2se;
    
    @XmlElement(name = "jar")
    private List<Jar> jars = new ArrayList<>();
    
    @XmlElement(name = "property")
    private Property property = new Property();
    
    public ResourcesTag() {
    }

    public ResourcesTag(String version, Map<String, String> jarToVersion) {
        this.j2se = new J2se(version);
        for (Map.Entry<String, String> entry : jarToVersion.entrySet()) {
            Jar jar = new Jar(entry.getKey(), entry.getValue());
            this.jars.add(jar);
        }
    }
}

@XmlRootElement
class J2se {
    @XmlAttribute
    private String version;

    public J2se() {
    }

    public J2se(String version) {
        this.version = version;
    }
}

@XmlRootElement
class Jar {
    @XmlAttribute
    private String href;
    
    @XmlAttribute
    private String version;
    
    public Jar() {
    }

    public Jar(String href, String version) {
        this.href = href;
        this.version = version;
    }
}

@XmlRootElement
class Property {
    
    @XmlAttribute
    private String name = "jnlp.versionEnabled";
    
    @XmlAttribute
    private String value = JnlpConstants.RESOURCES_JNLP_VERSION_ENABLED;
    
    public Property() {
    }
}