package com.hua.cloud.docker.config;


import com.spotify.docker.client.messages.ContainerConfig;
import org.springframework.beans.factory.annotation.Value;

public class DockerContainerConfig<T> implements IContainerConfig<ContainerConfig>{
    @Value("${docker.config.container_workdir}")
    private static String containerWorkDirectory ;
    @Value("${docker.config.added_volume}")
    private static String addedVolume ;
    @Value("${docker.config.default_image}")
    private static String defaultImage ;
    private static class DockerContainerConfigHolder {
        private final static ContainerConfig containerConfig =
                ContainerConfig.builder()
                        .openStdin(true)
                        .addVolume(addedVolume)
                        .workingDir(containerWorkDirectory)
                        .image(defaultImage).build();
    }
    public static ContainerConfig getDockerContainerConfigInstance() {
        return DockerContainerConfigHolder.containerConfig;
    }
    @Override
    public ContainerConfig config() {
        return getDockerContainerConfigInstance();
    }
}
