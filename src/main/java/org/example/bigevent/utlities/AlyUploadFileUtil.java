package org.example.bigevent.utlities;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class AlyUploadFileUtil {
    private static final String ENDPOINT = "https://oss-cn-beijing.aliyuncs.com";
    private static final String ACCESS_KEY = "LTAI5tHwF1gUWDX7PrHCBF7L";
    private static final String ACCESS_KEY_SECRET = "3e7CVbNZA7OTGOo6MnCkmc6bToQtEH";
    private static final String BUCKET_NAME = "troubilll";
    public static String upload(String objectName, InputStream in) throws Exception {
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY, ACCESS_KEY_SECRET);
        String url = "";
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, in);
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            url = "https://" + BUCKET_NAME + "." + ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1) + "/" + objectName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
