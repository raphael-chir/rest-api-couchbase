package com.experience.restapicouchbase;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import com.couchbase.client.java.env.ClusterEnvironment;

@Configuration
public class Config extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://cb.z6tzztcv7ptpiqj.cloud.couchbase.com";
    }

    @Override
    public String getUserName() {
        return "mgt-api-connect";
    }

    @Override
    public String getPassword() {
        return "$MgtApiConnect123";
    }

    @Override
    public String getBucketName() {
        return "my-great-team";
    }

    @Override
    protected String getScopeName() {
        return "organization";
    }

    @Override
    protected void configureEnvironment(final ClusterEnvironment.Builder builder) {
        builder.securityConfig().enableTls(true).trustCertificate(Paths.get("/tmp/capella.pem"));
    }
}