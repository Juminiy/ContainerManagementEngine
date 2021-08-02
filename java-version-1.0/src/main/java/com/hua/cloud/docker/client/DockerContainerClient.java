package com.hua.cloud.docker.client;


import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class DockerContainerClient {
    public DockerClient getDefaultDockerClient(String protocol , String host , String port, DockerCertificates certificates) {
        return DefaultDockerClient.builder()
                .uri(URI.create(protocol + "://" + host + ":" + port ))
                .dockerCertificates(certificates)
                .build();
    }
}
