package com.taotao.test;

import com.taotao.utils.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

public class FastDfsTest {

    @Test
    public void test() throws IOException, MyException {
        //创建一个配置文件，文件名任意，内容就是tracker的服务器地址
        //试用全局对象加载配置文件
        ClientGlobal.init("G:\\workspace\\idea\\taotao\\taotao-manager-web\\src\\main\\resources\\conf\\client.conf");
        //创建一个TrackerClient对象
        TrackerClient client = new TrackerClient();
        //通过TrackerClient对象活动TrackerServer对象
        TrackerServer trackerServer = client.getConnection();
        //创建StorageServer的引用，可以是null
        StorageServer storageServer = null;
        //创建一个storageClient
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //使用storageClient 上传文件
        String[] jpgs = storageClient.upload_file("G:\\39cfe30b74b135a99913a79da4930992_r.jpg",
                "jpg", null);
        for (String s :jpgs ) {
            System.out.println(s);
        }
    }


    @Test
    public void testFastDfs  () throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("G:\\workspace\\idea\\taotao\\taotao-manager-web\\src\\main\\resources\\conf\\client.conf");
        String s = fastDFSClient.uploadFile("G:\\2191760bf6136a883ac76342.jpg");
        System.out.println(s);
    }
}
