package com.example.constants;

public class JnlpConstants {
    public static final String JNLP_FILE_NAME="test.jnlp";
    public static final String JNLP_SPEC = "8.20+";
    public static final String JNLP_CODEBASE = "http://localhost:8080/JnlpDemo";
    public static final String INFORMATION_TITLE = "Test JNLP";
    public static final String INFORMATION_VENDOR = "VENDOR_NAME";
    public static final String RESOURCES_J2SE_VERSION = "1.8";
    public static final String RESOURCES_JNLP_VERSION_ENABLED = "true";
    public static final String APPLET_DESC_MAIN_CLASS = "CHANGE_ME";
    public static final String APPLET_DESC_NAME = "APPLET_NAME";
    public static final String APPLET_DESC_WIDTH = "200";
    public static final String APPLET_DESC_HEIGHT = "200";
    public static final String UPDATE_CHECK = "always";
    public static final String UPDATE_POLICY = "always";
    
    private JnlpConstants() {
        throw new AssertionError();
    }
}