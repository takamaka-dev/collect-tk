/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.takamaka.app.collecttkg.utils;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author tyranneo
 */
public class TkmTextUtils {
    
    public static final boolean isNullOrBlank(String text) {
        return (text == null
                || ("".equals(text.trim()))
                || (StringUtils.isBlank(text))
                || (text.isBlank())
                || (text.isEmpty()));
    }
    
}
