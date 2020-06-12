package com.lj.trshop.service.impl;

import com.lj.trshop.dao.ClassesDao;
import com.lj.trshop.service.ClassesService;
import com.lj.trshop.web.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 50713
 */
@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> findAll() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        //List<Map<String,Object>> list= classesDao.findAll();

        Object list;
        //当redis节点全挂了 抛出异常
        try{
            //高并发条件下，此处有点问题：缓存穿透
            //查询缓存
            list = redisTemplate.opsForValue().get("list");
            //双重检测锁
            if (null == list) {
                synchronized (this) {
                    //从redis获取一下
                    list = redisTemplate.opsForValue().get("list");

                    if (null == list) {
                        //缓存为空，查询一遍数据库
                        list = classesDao.findAll();
                        //把数据库查询出来的数据，放入redis中
                        redisTemplate.opsForValue().set("list", list,3000, TimeUnit.SECONDS);
                    }
                }
            }
        }catch (Exception e){
            list = classesDao.findAll();
        }

        Map<String,Object> map= new HashMap<>();
        map.put("list", list);
        return map;
    }

    //根据分类id 分页查询
    @Override
    public Map<String, Object> findObjects(Integer id, int pageCurrent) {
        //1.判定参数数据的有效性
        if(id==null||id<=0){
            System.out.println("前台传过来的分类id无效");
        }
        //2.根据pageCurrent计算startIndex
        int pageSize=2;
        int startIndex = (pageCurrent-1)*pageSize;
        //3.执行查询操作获得当前页数据.
        List<Map<String,Object>> list = classesDao.findObjects(id,startIndex,pageSize);
        //4.获得记录数,计算分页相关信息并进行封装
            //4.1根据条件获得记录数
            int rowCount = classesDao.getRowCount(id);
            //4.2将分页信息封装到PageObject
            PageObject pageObject=new PageObject();
            pageObject.setRowCount(rowCount);
            pageObject.setPageSize(pageSize);
            pageObject.setPageCurrent(pageCurrent);
            pageObject.setStartIndex(startIndex);
        //5.封装数据(当前页记录,分页PageObject)
        Map<String,Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pageObject",pageObject);
        return map;
    }

    //根据产品名字 旅游产品查看详情
    @Override
    public Map<String, Object> findPageObjects(String name, int pageCurrent) {
        //1.判定参数数据的有效性
        if(name==null){
            System.out.println("前台传过来的name无效");
        }
        //2.根据pageCurrent计算startIndex
        int pageSize=2;
        int startIndex = (pageCurrent-1)*pageSize;
        //3.执行查询操作获得当前页数据.
        List<Map<String,Object>> list = classesDao.findPageObjects(name,startIndex,pageSize);
        //4.获得记录数,计算分页相关信息并进行封装
            //4.1根据条件获得记录数
            int rowCount = classesDao.getPageRowCount(name);
            //4.2将分页信息封装到PageObject
            PageObject pageObject=new PageObject();
            pageObject.setRowCount(rowCount);
            pageObject.setPageSize(pageSize);
            pageObject.setPageCurrent(pageCurrent);
            pageObject.setStartIndex(startIndex);
        //5.封装数据(当前页记录,分页PageObject)
        Map<String,Object> map = new HashMap<>();
        map.put("list", list);
        map.put("pageObject",pageObject);
        return map;
    }

}
