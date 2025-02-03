<b><h3>ToDo лист для отслеживания ежедневных задач. Написан на Spring Boot.</b>

<H2>END POINTS</H2>

<H2>POST</H2>
<li>api/todo/post/{id}<br>
<b>Добавить пользователю задачу для пользователя.</b>
<br>RequestBody: <br>{<br> title: " "  <br>} <br>Query-param: &id = ?<br>
<br><li>api/user/registration<br>
<b>Регистрация нового пользователя.</b>
<br>RequestBody: <br>{<br> username: " " , <br>
password: " "<br>} 
<br>
<H2>GET</H2>
<li>api/user/get-user/{id}
<br><b>Пользователь по id</b>
<br>Query-param: &id = ?<br>
<br>
<li>api/user/get-all-users
<br><b>Все зарегистрированные пользователи</b>
<br>

<H2>PUT</H2>
<li>api/todo/complete/{id}
<br><b>Изменить статус задачи</b>
<br>Query-param: &id = ?<br>

<br>
<H2>DELETE</H2>
<li>api/user/delete-user/{id}</li>
<br><b>Удалить пользователя</b>
<br>Query-param: &id = ?<br>


<br>
<br>
<br>
<H2>Планируется реализовать</H2>
Регистрация и авторизация через Spring Security.<br>
Переверстать главную страницу


