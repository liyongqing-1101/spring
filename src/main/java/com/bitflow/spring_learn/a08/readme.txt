
1. Spring 的 scope
    singleton、prototype、request、session、application
    演示 request session application
    打开不同的浏览器，刷新 http://localhost:8080/test 即可查看效果
    同一个浏览器不同的请求：BeanForRequest会变，BeanForSession不变
    换一个浏览器：         BeanForRequest会变，BeanForSession也会改变，因为属于不同的会话
    如果 jdk > 8, 运行时请添加 --add-opens java.base/java.lang=ALL-UNNAMED

