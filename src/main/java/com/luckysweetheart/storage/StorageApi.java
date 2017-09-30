package com.luckysweetheart.storage;

import com.aliyun.oss.model.ObjectMetadata;
import com.luckysweetheart.storage.dto.Group;
import com.luckysweetheart.storage.exception.StorageException;
import com.luckysweetheart.storage.request.PutObject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 存储服务API
 * Created by yangxin on 2017/6/12.
 */
@Component
public interface StorageApi {

    /**
     * 列出所有的Bucket
     *
     * @return
     * @throws StorageException
     */
    List<Group> groupList() throws StorageException;

    /**
     * 上传文件
     *
     * @param putObject
     * @return
     * @throws StorageException
     */
    String putObject(PutObject putObject) throws StorageException;

    /**
     * 下载文件
     *
     * @param storeId
     * @return
     * @throws StorageException
     */
    byte[] getObject(String storeId) throws StorageException;

    /**
     * 删除文件
     *
     * @param storeId
     * @return
     * @throws StorageException
     */
    boolean deleteObject(String storeId) throws StorageException;

    /**
     * 获取图片的网络访问地址，有效期为100年
     *
     * @param storeId
     * @return
     * @throws StorageException
     */
    String getHttpUrl(String storeId) throws StorageException;

    /**
     * 获取图片的网络访问地址，并指定有效期
     *
     * @param storeId
     * @param expire  过期时间
     * @return
     * @throws StorageException
     */
    String getHttpUrl(String storeId, Long expire) throws StorageException;

    /**
     * 判断某个文件是否存在
     *
     * @param storeId
     * @return
     * @throws StorageException
     */
    boolean doesObjectExist(String storeId) throws StorageException;

    /**
     * 获取文件的元信息
     *
     * @param storeId
     * @return
     * @throws StorageException
     */
    ObjectMetadata getObjectMetadata(String storeId) throws StorageException;

}
