<html>
<body style="background-image: none;">
<h2>hell222o</h2>
<div class="body_wrap">
    <div class="container">
        <div class="alert alert-success text-center" role="alert">Sptring Boot学习资源大奉送，爱我就关注嘟嘟公众号：嘟爷java超神学堂</div>
        <table class="table table-striped table-bordered">
            <tr>
                <td>name</td>
                <td>gender</td>
                <td>hobby</td>
            </tr>
            <c:forEach var="user" items="${arrayList}">
                <tr class="text-info">
                    <td th:text="${user.name}">嘟嘟MD</td>
                    <td th:text="${user.gender}">SPringBoot干货系列</td>
					<td th:text="${user.hobby}"></td>     <br/>               
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
