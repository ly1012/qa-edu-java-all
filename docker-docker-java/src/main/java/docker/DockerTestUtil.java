package docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

/**
 * Docker 示例代码辅助工具类
 * @author hzlyun
 */
public class DockerTestUtil {

    private static DockerClient dockerClient;
    private static DockerClient dockerClientWithTLS;

    /**
     * 获取一个未开启TLS的Docker客户端对象，用于示例代码
     * @return Docker客户端对象（未开启TLS）
     */
    public static DockerClient getDockerClientWithoutTLS(){
        if (dockerClient == null){
            //创建配置
            DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                    .withDockerHost(DockerTestConf.DOCKER_HOST)
                    .withApiVersion(DockerTestConf.API_VERSION) // optional
                    .withRegistryUrl(DockerTestConf.REGISTRY_URL)
                    .build();
            //创建docker客户端实例
            dockerClient = DockerClientBuilder.getInstance(config).build();
        }
        return dockerClient;
    }

    /**
     * 【代码未测试，配置不对】获取一个开启TLS的Docker客户端对象，用于示例代码
     * @return Docker客户端对象（开启TLS）
     */
    public static DockerClient getDockerClientWithTLS(){
        if (dockerClient == null){
            //创建配置
            DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                    .withDockerHost(DockerTestConf.DOCKER_HOST)
                    .withDockerTlsVerify(Boolean.TRUE)
                    .withDockerCertPath(DockerTestConf.DOCKER_CERTPATH)
                    .withDockerConfig(DockerTestConf.DOCKER_CONFIG)
                    .withApiVersion(DockerTestConf.API_VERSION) // optional
                    .withRegistryUrl(DockerTestConf.REGISTRY_URL)
                    .withRegistryUsername(DockerTestConf.REGISTRY_USERNAME)
                    .withRegistryPassword(DockerTestConf.REGISTRY_PASSWORD)
                    .withRegistryEmail(DockerTestConf.REGISTRY_EMAIL)
                    .build();
            //创建docker客户端实例
            dockerClientWithTLS = DockerClientBuilder.getInstance(config).build();
        }
        return dockerClientWithTLS;
    }

}
