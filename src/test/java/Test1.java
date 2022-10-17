import com.mumu.learn.json.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import com.google.common.base.Stopwatch;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author gulinqing
 * @date 2022/8/29 10:17 下午
 */

@Slf4j
public class Test1 {

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {



        Class<?> stuClass = Class.forName("com.mumu.learn.json.Student");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("--------");
        Map<String, Field> contextMap = new ConcurrentHashMap<>();
        Arrays.stream(fieldArray).parallel().forEach(e->{
            e.setAccessible(true);
            contextMap.put(e.getName(), e);
            //System.out.println(e);
            //System.out.println(e.getName());
        });
        System.out.println(contextMap.toString());
        System.out.println(contextMap);


        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = stuClass.getField("public1");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
        //为字段设置值
        f.set(obj, "刘德华");//为Student对象中的name属性赋值--》stu.name = "刘德华"
        //验证
        Student stu = (Student)obj;
        System.out.println("验证姓名：" + stu.getName());


        System.out.println("**************获取私有字段****并调用********************************");
        f = stuClass.getDeclaredField("name");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888889999");
        System.out.println("验证电话：" + stu);






    }
}