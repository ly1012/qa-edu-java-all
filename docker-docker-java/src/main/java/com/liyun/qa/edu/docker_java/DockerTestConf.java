package com.liyun.qa.edu.docker_java;

/**
 * Docker 测试代码相关配置信息
 * @author hzlyun
 */
public class DockerTestConf {

    //Docker 连接信息（请修改为自己的测试环境）
    public static final String DOCKER_HOST = "tcp://10.200.130.139:2375";
    public static final String DOCKER_CERTPATH = "/home/user/.docker/certs";
    public static final String DOCKER_CONFIG = "/home/user/.docker";

    //Docker 远程 API 版本
    public static final String API_VERSION = "1.39";

    //Docker Registry 信息
    public static final String REGISTRY_URL = "https://registry.360fintime.cn/v2/";
    public static final String REGISTRY_USERNAME = "dockeruser";
    public static final String REGISTRY_PASSWORD = "ilovedocker";
    public static final String REGISTRY_EMAIL = "dockeruser@github.com";

    //Docker Repositry
    public static final String REPO_BUSYBOX = "registry.360fintime.cn/busybox";
    public static final String REPO_MOCKLAB_WIREMOCK = "registry.360fintime.cn/mocklab_wiremock";

}
