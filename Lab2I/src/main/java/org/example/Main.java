package org.example;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Program started");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! Please enter a string:");
        String input = scanner.nextLine();

        String capitalized = StringUtils.capitalize(input);
        String reversed = StringUtils.reverse(input);

        logger.info("Original string: {}", input);
        logger.info("Capitalized string: {}", capitalized);
        logger.info("Reversed string: {}", reversed);

        System.out.println("Capitalized string: " + capitalized);
        System.out.println("Reversed string: " + reversed);

        logger.info("Program finished");

        scanner.close();

        Properties properties = new Properties();

        try (InputStream inputStream = Main.class.getClassLoader()
                .getResourceAsStream("build-passport.properties")) {

            if (inputStream == null) {
                logger.warn("build-passport.properties not found");
            } else {
                properties.load(inputStream);

                logger.info("Build user: {}", properties.getProperty("user"));
                logger.info("OS: {}", properties.getProperty("os"));
                logger.info("Java version: {}", properties.getProperty("javaVersion"));
                logger.info("Build time: {}", properties.getProperty("buildTime"));
                logger.info("Message: {}", properties.getProperty("message"));
            }

        } catch (IOException e) {
            logger.error("Failed to read build-passport.properties", e);
        }

    }
}

