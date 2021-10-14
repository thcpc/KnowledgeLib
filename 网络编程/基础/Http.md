### Http Header 中 Keep-Alive作用
HTTP的 keep-alive是为了使http变成长连接，在此前的http 1.0中，每次http的请求-响应之后，tcp连接就会被释放掉，这显然是非常浪费的，于是通过加入keep-alive，使得http连接不会被立即释放。