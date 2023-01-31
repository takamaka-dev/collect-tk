/*
 * Copyright 2023 tyranneo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.takamaka.app.collecttkg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tyranneo
 */
@Data
@Slf4j
@AllArgsConstructor
public class GlobalConfigurationBean {

    private final String baseUrlEndpoint;
    private final String requireChallengeApi;
    private final String checkResultApi;
    private final String checkclaimingSolutionsApi;
    private final String getHexTrxApi;
    private final String updateClamingSolutionsApi;
    private final String savePayTodoApi;

    public GlobalConfigurationBean() {
        this.baseUrlEndpoint = "http://192.168.2.143:8080";
        this.requireChallengeApi = "/requirechallenge";
        this.checkResultApi = "/checkresult";
        this.checkclaimingSolutionsApi = "/checkclamingsolutions";
        this.getHexTrxApi = "/gethextrx";
        this.updateClamingSolutionsApi = "/updateclaimsolutions";
        this.savePayTodoApi = "/savepaytodo";
    }
}
