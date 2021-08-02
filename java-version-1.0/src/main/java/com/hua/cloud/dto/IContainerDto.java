package com.hua.cloud.dto;

import com.hua.cloud.docker.constant.ContainerEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IContainerDto implements Serializable {
    private static final long serialVersionUID = 10L;
    protected String containerId ;
    protected String baseImage ;
    protected String containerName ;
    protected String commandLine ;
    protected Date createdTime ;
    protected ContainerEnum status ;
    protected String portsMapping ;
}
