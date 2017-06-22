package com.bbd.wtyh.report.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.bbd.wtyh.report.service.ScreenCaptureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service("phantomServiceImpl")
public class PhantomServiceImpl implements ScreenCaptureService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhantomServiceImpl.class);
    @Override
    public boolean exec(String... args) {
        Process process = null;
        StringBuilder msg = new StringBuilder();
        try {
            process = Runtime.getRuntime().exec(args);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                LOGGER.warn(line);
            }
            input.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            msg.append("error");
        }
        return !msg.toString().endsWith("error");
    }
}