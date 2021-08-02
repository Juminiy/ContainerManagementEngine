package com.hua.cloud.docker.engine;

public class SingletonDockerContainer implements DockerContainer{
    public static SingletonDockerContainer singletonInstance ;
    private SingletonDockerContainer(){

    }

    public static SingletonDockerContainer getSingletonInstance() {
        if (singletonInstance == null) {
            synchronized (SingletonDockerContainer.class) {
                if( singletonInstance == null) {
                    singletonInstance = new SingletonDockerContainer();
                }
            }
        }
        return singletonInstance ;
    }
}
