package com.regexfinder.util;

import static java.io.File.separator;

public class Constants {

    public static final String PHONE_REGEX = "[0-9]{10,10}|[0-9]{3,3}-[0-9]{3,3}-[0-9]{4,4}|\\([0-9]{3,3}\\) [0-9]{3,3}-[0-9]{4,4}|\\([0-9]{3,3}\\)-[0-9]{3,3}-[0-9]{4,4}";
    public static final String DOMAIN_REGEX = "(^([www]+[0-1]|^[www]+)\\..*\\.([a-z]+){2,6})|(.*\\.([a-z]){2,6})";
    public static final String EMAIL_REGEX = "([a-z]+|[A-Z]+|[a-z]+[0-9]+|[A-Z]+[0-9]+)@([a-z]+)\\.([a-z]{1,6})";
    public static final String EMPTY_STRING = "";
    public static final String NEW_LINE = "\n";

    public static final String USER_HOME_PATH = System.getProperty("user.home");
    public static final String DESKTOP_PATH = USER_HOME_PATH + separator + "Desktop";
    public static final String WRITE_FILE_PATH = DESKTOP_PATH + separator + "results.txt";
    public static final String FILE_CREATED_MESSAGE = "File created for %s regex at path: %s";
    public static final String CANNOT_CREATE_FILE_MESSAGE = "Cannot create file at path: %s";
    public static final String EMAIL_STRING = "Email";
    public static final String PHONE_STRING = "Phone";
    public static final String DOMAIN_STRING = "Domain";
}
