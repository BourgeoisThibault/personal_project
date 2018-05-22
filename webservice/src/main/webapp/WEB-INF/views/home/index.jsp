<%--
  Created by IntelliJ IDEA.
  User: thiba
  Date: 11/10/2017
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--main content start-->
<section id="main-content">

    <section class="wrapper">
        <!--overview start-->
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="icon_house_alt"></i> Accueil</h3>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="info-box blue-bg">
                    <i class="fa fa-group"></i>
                    <div class="count">6.674</div>
                    <div class="title">users</div>
                </div>
                <!--/.info-box-->
            </div>
            <!--/.col-->

            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="info-box brown-bg">
                    <i class="fa fa-bookmark"></i>
                    <div class="count">7.538</div>
                    <div class="title">offers</div>
                </div>
                <!--/.info-box-->
            </div>
            <!--/.col-->

            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="info-box dark-bg">
                    <i class="fa fa-thumbs-o-up"></i>
                    <div class="count">4.362</div>
                    <div class="title">matchs</div>
                </div>
                <!--/.info-box-->
            </div>
            <!--/.col-->

            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                <div class="info-box green-bg">
                    <i class="fa fa-thumbs-up"></i>
                    <div class="count">1.426</div>
                    <div class="title">accepts</div>
                </div>
                <!--/.info-box-->
            </div>
            <!--/.col-->

        </div>

        <div class="row">

            <div class="col-lg-2">
                <section class="panel">
                    <header class="panel-heading">
                        Linked items
                    </header>
                    <div style="overflow-y:scroll; height:300px;" class="list-group">
                        <a class="list-group-item " href="javascript:;">Lorem ipsum dolor sit amet</a>
                        <a class="list-group-item active" href="javascript:;">Praesent tempus eleifend risus</a>
                        <a class="list-group-item" href="javascript:;">Praesent tempus eleifend risus</a>
                        <a class="list-group-item" href="javascript:;">Porta ac consectetur ac</a>
                        <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                        <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                        <a class="list-group-item" href="javascript:;">Praesent tempus eleifend risus</a>
                        <a class="list-group-item" href="javascript:;">Praesent tempus eleifend risus</a>
                        <a class="list-group-item" href="javascript:;">Porta ac consectetur ac</a>
                        <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                        <a class="list-group-item" href="javascript:;">Vestibulum at eros</a>
                    </div>
                </section>
            </div>


            <div class="col-lg-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="pull-left">Message</div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="panel-body">
                        <!-- Widget content -->
                        <div style="overflow-y:scroll; height:300px;" class="padd sscroll">

                            <c:choose>
                                <c:when test="${not empty chatroom.chatMessageList.get(1).message}">

                                    <ul class="chats">

                                    <c:forEach items="${ chatroom.chatMessageList }" var="message">
                                        <c:choose>
                                            <c:when test="${ message.sender.profileAccount.pseudo == pseudo }">
                                                <!-- Chat by us. Use the class "by-me". -->
                                                <li class="by-me">
                                                    <!-- Use the class "pull-left" in avatar -->
                                                    <div class="avatar pull-left">
                                                        <i class="fa fa-user"></i>
                                                    </div>

                                                    <div class="chat-content">
                                                        <!-- In meta area, first include "name" and then "time" -->
                                                        <div class="chat-meta">John Smith <span class="pull-right">3 hours ago</span></div>
                                                        <c:out value="${ message.message }" />
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </li>
                                            </c:when>
                                            <c:when test="${ message.sender.profileAccount.pseudo != pseudo  }">
                                                <!-- Chat by other. Use the class "by-other". -->
                                                <li class="by-other">
                                                    <!-- Use the class "pull-right" in avatar -->
                                                    <div class="avatar pull-right">
                                                        <i class="fa fa-user"></i>
                                                    </div>

                                                    <div class="chat-content">
                                                        <!-- In the chat meta, first include "time" then "name" -->
                                                        <div class="chat-meta">3 hours ago <span class="pull-right">Jenifer Smith</span></div>
                                                        <c:out value="${ message.message }" />
                                                        <div class="clearfix"></div>
                                                    </div>
                                                </li>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>

                                    </ul>

                                </c:when>

                                <c:when test="${empty chatroom.chatMessageList}">
                                    Aucun message...
                                </c:when>
                            </c:choose>

                        </div>
                        <!-- Widget footer -->
                        <div class="widget-foot">

                            <div class="row">

                                <div class="col-lg-4">
                                    <form class="form-inline">
                                        <button type="submit" class="btn btn-info">Send</button>
                                    </form>
                                </div>

                                <div class="col-lg-4">
                                    <form class="form-inline">
                                        <button type="submit" class="btn btn-info">Send</button>
                                    </form>
                                </div>

                                <div class="col-lg-4">
                                    <form class="form-inline">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Type your message here...">
                                        </div>
                                        <button type="submit" class="btn btn-info">Send</button>
                                    </form>
                                </div>

                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>


<%@include file="../footer.jsp"%>
