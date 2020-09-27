package com.liyun.qa.edu.docker_java;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Version;
import com.github.dockerjava.api.model.VersionComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Docker 信息
 * @author hzlyun
 */
public class DockerInfoTest {

    private static final Logger logger = LoggerFactory.getLogger(DockerInfoTest.class);

    private static final DockerClient docker = DockerTestUtil.getDockerClientWithoutTLS();

    @Test
    public void testDockerVersion(){
        Version version = docker.versionCmd().exec();
        logger.info("Docker 类型：{}",version.getPlatform().getName());
        logger.info("Docker 版本：{}",version.getVersion());
        logger.info("Docker API 版本：{}",version.getApiVersion());
        logger.info("Docker API 最低版本：{}",version.getMinAPIVersion());
        logger.info("Go 语言版本：{}",version.getGoVersion());
        logger.info("构建时间：{}",version.getBuildTime());
        logger.info("Git Commit：{}",version.getGitCommit());

        logger.info("机器操作系统：{}",version.getOperatingSystem());
        logger.info("机器 Arch：{}",version.getArch());
        logger.info("机器 Kernel 版本：{}",version.getKernelVersion());

        for (VersionComponent versionComponent:version.getComponents()){
            logger.info("详细信息：{}",versionComponent.getDetails().toString());
        }
    }

    @Test
    public void testDockerInfo(){
        Info info = docker.infoCmd().exec();
        logger.info("Docker Info：{}",info.toString());
    }
}
