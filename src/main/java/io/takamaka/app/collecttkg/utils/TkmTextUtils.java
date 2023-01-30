/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.takamaka.app.collecttkg.utils;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.LinkedHashMap;
import java.util.Map;
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

public static String exactSearchTransactions(String data, GlobalConstants.ExactSearchField field, boolean dumpTx, int limit) throws ProtocolException, IOException {
        String result = "";
        //String testEndpoint = GlobalConstants.TEST_NET_ENDPOINT;
        String searchTransactionAPI = GlobalConstants.TEST_NET_ENDPOINT + GlobalConstants.EXACT_SEARCH_TRANSACTION_API;
        Map<String, String> params = new LinkedHashMap<>();
        params.put("data", "" + data + "");
        params.put("field", "" + field.name() + "");
        params.put("dumptx", "" + dumpTx + "");
        params.put("limit", "" + limit + "");

        result = ProjectHelper.doPost(searchTransactionAPI, params);

        return result;
    }
}
