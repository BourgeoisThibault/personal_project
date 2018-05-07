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

    <form class="login-form" style="margin: 100px auto 0;" action="login" method="post">
        <div class="login-wrap">
            <p class="login-img">
                <img id="myImg" src="${contextPath}/resources/img/Logo.png" width="150px"/>
            </p>

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
                    <a href="#"> Mot de passe oublié?</a>
                </span>
            </label>
            <button id="connectButton" class="btn btn-primary btn-lg btn-block" type="submit">Connexion</button>
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
    }
</script>


</html>
