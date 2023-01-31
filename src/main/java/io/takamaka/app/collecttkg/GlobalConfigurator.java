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
package io.takamaka.app.collecttkg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.takamaka.app.collecttkg.bean.GlobalConfigurationBean;
import io.takamaka.wallet.utils.FileHelper;
import static io.takamaka.wallet.utils.FileHelper.createDir;
import static io.takamaka.wallet.utils.FileHelper.getDefaultApplicationDirectoryPath;
import static io.takamaka.wallet.utils.FileHelper.homeDirExists;
import java.io.IOException;
import java.nio.file.Path;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tyranneo
 */

@Slf4j
@Data
public class GlobalConfigurator {
    
    private final String CONFIG_FILE_NAME = "collect_tk_client_config_file.json";
    private final GlobalConfigurationBean globalConfigurationBean;
    ObjectMapper m = new ObjectMapper();
    
    public GlobalConfigurator() throws IOException {
        initHome();
        Path pathToConfigFile = Path.of(FileHelper.getDefaultApplicationDirectoryPath().toString(), CONFIG_FILE_NAME);
        if (FileHelper.fileExists(pathToConfigFile)) {
            this.globalConfigurationBean = m.readValue(pathToConfigFile.toFile(), GlobalConfigurationBean.class);
        } else {
            this.globalConfigurationBean = new GlobalConfigurationBean();
            FileHelper.writeStringToFileUTF8(FileHelper.getDefaultApplicationDirectoryPath(), CONFIG_FILE_NAME, serializeGlobalConfigurationBean(this.globalConfigurationBean), false);
        }
    }
    
    private void initHome() throws IOException {
        if (!homeDirExists()) {
            createDir(getDefaultApplicationDirectoryPath());
            log.info("Home directory created");
        }
    }
    
    public final String serializeGlobalConfigurationBean(GlobalConfigurationBean globalConfigurationBean) {
        try {
            return m.writeValueAsString(globalConfigurationBean);
        } catch (JsonProcessingException ex) {
            ex.getMessage();
        }
        return null;
    }
    
}
