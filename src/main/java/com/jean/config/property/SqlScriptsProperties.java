package com.jean.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by jean on 07.03.16.
 */
@Component
public class SqlScriptsProperties {

    @Value("classpath:scripts/mysql-create-schema.sql")
    private Resource schemaScript;

    @Value("classpath:scripts/mysql-test-data.sql")
    private Resource dataScript;

    @Value("classpath:scripts/mysql-clean.sql")
    private Resource cleanerScript;


    public Resource getSchemaScript() {
        return schemaScript;
    }

    public void setSchemaScript(Resource schemaScript) {
        this.schemaScript = schemaScript;
    }

    public Resource getDataScript() {
        return dataScript;
    }

    public void setDataScript(Resource dataScript) {
        this.dataScript = dataScript;
    }

    public Resource getCleanerScript() {
        return cleanerScript;
    }

    public void setCleanerScript(Resource cleanerScript) {
        this.cleanerScript = cleanerScript;
    }
}
