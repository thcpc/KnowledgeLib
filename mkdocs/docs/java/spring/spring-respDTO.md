### 使用泛型封装 Reopens
```java
import java.io.Serializable;

public class Response<T> implements Serializable {
    private int code;
    private T payLoad;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Response(int code, T responseObject, String msg) {
        this.code = code;
        this.payLoad = responseObject;
        this.msg = msg;
    }
    # 工厂方法，成功返回并返回数据对象
    public static<T> Response<T> ok(T responseObject,String msg){
        return new Response<T>(200,responseObject,msg);
    }
    # 工厂方法，成功返回只返回消息
    public static<T> Response<T> ok(String msg){
        return new Response<T>(200,null, msg);
    }
    # 工厂方法，错误返回并返回错误消息
    public static<T> Response<T> error(int code, String msg){
        return new Response<T>(code,null, msg);
    }
```

### Controller 中调用
```java
    @PostMapping("....")
    @ResponseBody
    public Response<TraineeSignEntity> traineeSign(@RequestBody TraineeSignDto traineeSignDto) {
        TraineeSignEntity traineeSignEntity = traineeService.traineeSign(traineeSignDto);
        return Response.ok(traineeSignEntity,"ok");
    }
```