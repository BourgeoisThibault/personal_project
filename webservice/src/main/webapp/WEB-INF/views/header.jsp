<%--
  Created by IntelliJ IDEA.
  User: thiba
  Date: 11/10/2017
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<!-- container section start -->
<section id="container" class="">


    <header class="header dark-bg">

        <div class="toggle-nav">
            <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
        </div>

        <!--logo start-->
        <a href="/" class="logo" style="margin-top:5px"><img src="${contextPath}/resources/img/Logo.png" width="50px"/></a>
        <!--logo end-->

        <!--
        <div class="nav search-row" id="top_menu">
            <ul class="nav top-menu">
                <li>
                    <form class="navbar-form">
                        <input class="form-control" placeholder="Search" type="text">
                    </form>
                </li>
            </ul>
        </div>
        -->

        <div class="top-nav notification-row">
            <!-- notificatoin dropdown start-->
            <ul class="nav pull-right top-menu">
                <!-- alert notification end-->
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="#">
                            </span>
                        <span class="username">${session_profile}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li class="eborder-top">
                            <a href="#"><i class="icon_profile"></i> ${session_first_name} ${session_last_name}</a>
                        </li>
                        <li>
                            <a href="/logout"><i class="icon_mail_alt"></i> Boîte à lettre</a>
                        </li>
                        <li>
                            <a href="/logout"><i class="icon_key_alt"></i> Déconnexion</a>
                        </li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!-- notificatoin dropdown end-->
        </div>
    </header>
    <!--header end-->

    <!--sidebar start-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li>
                    <a class="" href="/">
                        <i class="icon_house_alt"></i>
                        <span>Accueil</span>
                    </a>
                </li>
                <li>
                    <a class="" href="/team">
                        <i class="fa fa-users"></i>
                        <span>Equipe</span>
                    </a>
                </li>
                <li>
                    <a class="" href="/notification">
                        <i class="fa fa-paper-plane"></i>
                        <span>Notification</span>
                    </a>
                </li>
                <li>
                    <a class="" href="http://file.esibank.inside.esiag.info/app-debug.apk">
                        <i class="icon_download"></i>
                        <span>Android Application</span>
                    </a>
                </li>
                <li>
                    <a class="" href="/about">
                        <i class="icon_info_alt"></i>
                        <span>A propos</span>
                    </a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->