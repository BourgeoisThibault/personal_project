<%--
  Created by IntelliJ IDEA.
  User: thiba
  Date: 10/05/2018
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<div class="container">

    <form class="login-form" style="margin: 100px auto 0;" action="/sign/forgot" method="post">
        <div class="login-wrap">
            <p class="login-img">
                <img id="myImg" src="${contextPath}/resources/img/Logo.png" width="150px"/>
            </p>

            <div id="myMsg" style="display: none" class="input-group">
                <span class="input-group-addon" style="font-size: large">Envoi en cours...</span>
            </div>

            <div id="myMail" class="input-group">
                <span class="input-group-addon"><i class="icon_mail"></i></span>
                <input name="mail" type="text" class="form-control" placeholder="Email saisie à l'inscription" autofocus>
            </div>
            <button id="findPassButton" class="btn btn-primary btn-lg btn-block" type="submit">Demander mot de passe</button>
            <!--<button class="btn btn-info btn-lg btn-block" type="submit">Signup</button>-->
        </div>
    </form>
</div>

</body>


<script>
    document.getElementById('findPassButton').onclick = function(){
        document.getElementById('myImg').src='${contextPath}/resources/img/Loading.gif';
        document.getElementById('myMail').style.display = 'none';
        document.getElementById('findPassButton').style.display = 'none';
        document.getElementById('myMsg').style.display = 'block';
    }
</script>


</html>
