<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>cours</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" href="./css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./css/style2.css">

</head>

<body class="main-layout home_page cr">
    <header>
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                        <div class="menu-area">
                            <div class="limit-box">
                                <nav class="main-menu">
                                    <ul class="menu-area-main">
                                        <li class="mean-last"><img src="img/user.jpg"></li>
                                        <li class="active"> <a href="cours.jsp">cours</a></li>
                                        <li> <a href="Apprenant.jsp">Apprenant: ${sessionScope.nom} ${sessionScope.prenom}</a> </li>
                                        <li ><a href="apropos.jsp">a propos</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>





    </header>


    <div class="container login-container" align="center">
    <div class="row">
    
            <div class="col-12">
                <div class="card">
                    <h8 class="card-header" id="nomc">${sessionScope.nomformation}</h5>
                        <br> <br>
                        <div class="card-body">
                            <h5 class="card-title" id="formateurn">${sessionScope.nomformateur}</h5>
                            <p class="card-text text-dark" id="description">voila le cours de cette formation</p>
                            <a href="https://meet.google.com/eia-dtox-ofr" class="btn btn-link">->Lien meet</a>
                        </div>
                </div>
            </div>
        </div>

        <br> <br>

        <c:forEach var="cr" items="${sessionScope.Cours}">

        <div class="row">
            <div class="col-8 offset-2">
        <iframe src="${cr.contenu}" style="width:600px; height:500px;">
        </iframe>        
                
            </div>
        </div>
        <br>
        </c:forEach>         
     
    </div>

</body>

</html>