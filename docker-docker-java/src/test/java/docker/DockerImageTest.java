package docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.command.PullImageResultCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * Docker 镜像操作
 *
 * @author hzlyun
 */
public class DockerImageTest {

    private static final Logger logger = LoggerFactory.getLogger(DockerImageTest.class);

    private static final DockerClient docker = DockerTestUtil.getDockerClientWithoutTLS();

    @Test
    public void testListImage() {
        List<Image> imageList = docker.listImagesCmd().exec();
        for (Image image : imageList) {
            logger.info("镜像ID：{}", image.getId());
            logger.info(image.toString());
            logger.info("镜像父ID：{}", image.getParentId());
            String[] tags = image.getRepoTags() == null ? new String[]{""} : image.getRepoTags();
            logger.info("镜像标签：{}", String.join(",", tags));
            logger.info("镜像创建时间：{}", new Date(image.getCreated() * 1000));
            logger.info("镜像大小：{}", image.getSize());
            logger.info("镜像虚拟大小：{}", image.getVirtualSize());
            System.out.println();
        }
    }

    @Test
    public void testSearchImage() {
        List<SearchItem> searchItemList = docker.searchImagesCmd("mysql").exec();
        for (SearchItem item : searchItemList) {
            logger.info(item.getName());
        }
    }

    @Test
    public void testPullImage() {
        PullImageResultCallback pullImageResultCallback =
                docker.pullImageCmd("redis:4.0")
//                        .withTag("v1")
                        .exec(new PullImageResultCallback() {
                            @Override
                            public void onNext(PullResponseItem item) {
                                System.out.println(item.toString());
                                super.onNext(item);
                            }
                        });
        try {
            pullImageResultCallback.awaitCompletion();
            pullImageResultCallback.onComplete();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testRemoveImageByTag() {
        try {
            docker.removeImageCmd(DockerTestConf.REPO_BUSYBOX+":v1").withForce(true).exec();
        } catch (NotFoundException e) {
            // just ignore if not exist
        }
    }

    @Test
    public void testRemoveImageById() {
        try {
            docker.removeImageCmd("fce289e99eb9").withForce(true).exec();
        } catch (NotFoundException e) {
            // just ignore if not exist
        }
    }

}
