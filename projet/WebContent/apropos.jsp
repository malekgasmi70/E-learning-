<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>

<head>
    <title>Apprenant</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/style2.css">

</head>

<body class="main-layout home_page back">


    <header>
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                        <div class="menu-area">
                            <div class="limit-box">
                                <nav class="main-menu">
                                    <ul class="menu-area-main">
                                        <li class="mean-last">
                                        </li>
                                        <li > ${sessionScope.nom} ${sessionScope.prenom} </li>
                                        <li class="active"> <a href="apropos.jsp">à propos</a> </li>                   
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <br><br>
    <div class="container login-container" align="center">
  
<br>
     <div class="container border border-danger">
     <div class="row"><div class="col-12"><h2 class="text-danger">A propos de nous</h2></div></div><br><br>
   <div class="row"><div class="col-12" ><h3 class="text-secondary">Nous avons ete demandes de la realisation d une application web offrant des services E-Learning pour lequel nous avons exprime un grand interet.cette plateform est destine au formateur et au apprenant pour et offre une espace ergonomique pour l'apprentissage en ligne</h3></div>
    </div><br>
     <div class="row"><div class="col-12" ><h3 class="text-secondary">pour plus d'information contacter nous par mail:<br>Fadi.Benzid@isticbc.org<br>Malek.Gasmi@isticbc.org<br>Aymen.Masmoudi@isticbc.org<br><br>ou par telephone sur: 29833301</h3></div></div>
     </div>


</body>

</html>