package com.example.model.binding;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "information")
public class InformationTag {

    @XmlElement
    private String title;
    
    @XmlElement
    private String vendor;
    
    public InformationTag() {
    }
    public InformationTag(String title, String vendor) {
        this.title = title;
        this.vendor = vendor;
    }
}