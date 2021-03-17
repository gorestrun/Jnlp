package com.example.model.binding;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.example.constants.JnlpConstants;

@XmlRootElement
public class UpdateTag  {

    @XmlAttribute
    private String check = JnlpConstants.UPDATE_CHECK;
    
    @XmlAttribute
    private String policy = JnlpConstants.UPDATE_POLICY;
    
    public UpdateTag() {
    }
}
