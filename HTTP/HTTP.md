# HTTP

## Request Header

## Response Header

## 1.缓存失效

```
resp.setHeader("expires","-1");
resp.setHeader("Cache-Control","no-cache");//HTTP 1.1
resp.setHeader("Pragma","no-cache");//HTTP 1.0
```

## 2. 定时刷新

```
resp.setHeader("refresh","3");//3秒刷新一次
```



## 3. 指定返回格式

```
resp.setContentType("image/jpeg");//图片
resp.setContentType("text/html"); //Html文件
```

## 4.重定向

```
resp.setHeader("Location","/r/img")
resp.setStatus(302)
```

和请求转发的区别

请求转发，url不会发生变化，并且code 为307

```
this.getServletContext().getRequestDispatcher("/init").forward(req,resp);
```

