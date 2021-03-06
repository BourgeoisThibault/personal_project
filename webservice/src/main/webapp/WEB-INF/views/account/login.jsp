<%--
  Created by IntelliJ IDEA.
  User: thiba
  Date: 07/05/2018
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<div class="container">

    <form class="login-form" style="margin: 100px auto 0;" action="/sign/in" method="post">
        <div class="login-wrap">
            <p class="login-img">
                <img id="myImg" src="${contextPath}/resources/img/Logo.png" width="150px"/>
            </p>

            <c:choose>
                <c:when test="${empty param.error}">
                </c:when>
                <c:otherwise>
                    <span id="message" style="background-color: #a10000; color: #aed0ea" class="input-group-addon" style="font-size: large"><strong><c:out value="${param.error}" /></strong></span>
                    </br>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${empty param.message}">
                </c:when>
                <c:otherwise>
                    <span id="message" style="background-color: #5b9909; color: #aed0ea" class="input-group-addon" style="font-size: large"><strong><c:out value="${param.message}" /></strong></span>
                    </br>
                </c:otherwise>
            </c:choose>

            <div id="myMsg" style="display: none" class="input-group">
                <span class="input-group-addon" style="font-size: large">Vérification en cours...</span>
            </div>

            <div id="myLogin" class="input-group">
                <span class="input-group-addon"><i class="icon_profile"></i></span>
                <input name="login" type="text" class="form-control" placeholder="Nom utilisateur" autofocus>
            </div>
            <div id="myPass" class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input name="pass" type="password" class="form-control" placeholder="Mot de passe">
            </div>
            <label id="myForgot" class="checkbox">
                <span class="pull-right">
                    <a href="/sign/forgot"> Mot de passe oublié?</a>
                </span>
            </label>
            <button id="connectButton" class="btn btn-primary btn-lg btn-block" type="submit">Connexion</button>

        <br>

            <div id="downloadApk" style="text-align: center" class="input-group">
                <a class="" href="http://file.jobswitch.inside.esiag.info/app.apk">
                    <img width="80%" src="${contextPath}/resources/img/logo_apk.png">
                </a>
            </div>

            <!--<button class="btn btn-info btn-lg btn-block" type="submit">Signup</button>-->
        </div>
    </form>
</div>

</body>


<script>
    document.getElementById('connectButton').onclick = function(){
        document.getElementById('myImg').src='${contextPath}/resources/img/Loading.gif';
        document.getElementById('myLogin').style.display = 'none';
        document.getElementById('myPass').style.display = 'none';
        document.getElementById('myForgot').style.display = 'none';
        document.getElementById('connectButton').style.display = 'none';
        document.getElementById('myMsg').style.display = 'block';
        document.getElementById('message').style.display = 'none';
    }
</script>


</html>
