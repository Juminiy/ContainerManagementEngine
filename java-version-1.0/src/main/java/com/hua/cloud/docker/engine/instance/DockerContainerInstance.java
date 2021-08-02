package com.hua.cloud.docker.engine.instance;

import com.hua.cloud.docker.client.DockerContainerClient;
import com.hua.cloud.docker.config.DockerContainerConfig;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerCreation;
import org.springframework.beans.factory.annotation.Autowired;

public class DockerContainerInstance implements IContainerInstance{
    @Autowired
    DockerContainerClient dockerContainerClient ;
    public String getCreationInstance() throws DockerException, InterruptedException {
        DockerClient dockerClient = dockerContainerClient.getDefaultDockerClient("tcp","localhost","2375",null);
        ContainerCreation creation = dockerClient.createContainer(DockerContainerConfig.getDockerContainerConfigInstance());
        String id = creation.id();
        return id ;
    }
}
