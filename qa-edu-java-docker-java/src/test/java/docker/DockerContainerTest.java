package docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器示例代码
 */
public class DockerContainerTest {

    private static final Logger logger = LoggerFactory.getLogger(DockerContainerTest.class);

    private static DockerClient docker = DockerTestUtil.getDockerClientWithoutTLS();

    @Test
    public void testCreateAndStartContainer(){
        //环境变量配置
        String testVariable = "PROJECT=t10_v";
        //重启配置
        RestartPolicy restartPolicy = RestartPolicy.onFailureRestart(5);
        //配置映射端口，将容器的8080端口映射到主机上随机的一个端口
        ExposedPort tcp8080 = ExposedPort.tcp(8080);
        Ports portBindings = new Ports();
        portBindings.bind(tcp8080, Ports.Binding.empty());
        //Volume 挂载
        Volume volume1 = new Volume("/opt/wiremock/fileDB");
        Volume volume2 = new Volume("/opt/wiremock/log");
        //Mount 挂载
        List<Mount> mounts = new ArrayList<>();
        Driver driver = new Driver();
        driver.withName("vieux/sshfs");
        Mount mount = new Mount();
        mount.withType(MountType.VOLUME);
        mount.withSource("volume-sshfs-mocklab-wiremock");
        mount.withTarget("/opt/wiremock");
        VolumeOptions volumeOptions = new VolumeOptions();
        volumeOptions.withDriverConfig(driver);
        mount.withVolumeOptions(volumeOptions);
        mounts.add(mount);


        //创建容器
        CreateContainerResponse container = docker.createContainerCmd(DockerTestConf.REPO_MOCKLAB_WIREMOCK)
                .withExposedPorts(tcp8080)
                .withHostConfig(new HostConfig()
                        .withPortBindings(portBindings)
                        .withPublishAllPorts(true)
                        .withRestartPolicy(restartPolicy)
//                        .withBinds(new Bind("/opt/wiremock/t10_v/fileDB", volume1), new Bind("/opt/wiremock/t10_v/log", volume2))
                        .withMounts(mounts)
                )
                .withEnv(testVariable)
                .withName("mocklab_wiremock_t10_v")
                .exec();

        //启动容器
        docker.startContainerCmd(container.getId()).exec();

        //等待容器
//        int statusCode = docker.waitContainerCmd(container.getId()).exec(new WaitContainerResultCallback()).awaitStatusCode();
//        logger.info("等待状态码：{}",statusCode);

        //检查容器
        InspectContainerResponse inspectContainerResponse = docker.inspectContainerCmd(container.getId()).exec();
        String port = inspectContainerResponse.getNetworkSettings().getPorts().getBindings().get(tcp8080)[0].getHostPortSpec();
        logger.info("主机随机端口：{}",port);
        InspectContainerResponse.ContainerState state = inspectContainerResponse.getState();
        logger.info("Running：{}",state.getRunning());
        logger.info("{}",state.toString());
//        logger.info("{}",state.getHealth().getStatus());
//        logger.info("{}",state.getHealth().getLog());
    }

    @Test
    public void testRemoveContainerByName(){
        try {
            docker.removeContainerCmd("testmocklab").withForce(true).exec();
        }catch (NotFoundException e){
            System.out.println("之前不存在");
        }
    }

    @Test
    public void testRemoveContainerById(){
        docker.removeContainerCmd("fa366eb7b8e0").exec();
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void removeNonExistingContainer() throws DockerException {
        docker.removeContainerCmd("non-existing").exec();
    }

}
