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
                                        <li class="mean-last"><img src="img/user.jpg">
                                        </li>
                                        <li class="active"> <a href="Apprenant.jsp">Apprenant: ${sessionScope.nom} ${sessionScope.prenom}</a> </li>
                                         <li> <a href="mesformations.jsp">mes cours</a></li>
                                        <li> <a href="apropos.jsp">à propos</a> </li>                   
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
    <div class="row">
<div class="col-11">
</div>
<div class="col-1">
<form action="Deconnexion" method="post">

<li class="mean-last">

<button type="submit" class="btn btn text-danger bg-light">Déconnection</button>

 </li>
 </form>
</div>
</div>
<br>
        <div class="row">
        <c:forEach var="formation" items="${sessionScope.Formations}">
        
        
        <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 ">
                <div class="card border-danger mb-3 " style="max-width: 18rem;">
                    <div class="card-header">
                        <div class="row">
                            <div class="col-6 "></div>
                            <div class="col-3 ">
                                <div class="row">
                                    
                                    <form role="form" method="post" action="Mescours">
            
                                    <input type="hidden" name="custId1" value="${ formation.idformation }">
                                    <input type="hidden" name="custId2" value="${sessionScope.idapprenant}">
                                    
                                    
                                    <div class="col-12">  <button type="submit" class="btn btn text-light bg-danger">Rejoindre</button>

                                    </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="card-body bg-Secondaryr">

                        <h2 class="card-title"><c:out value="${ formation.nom }" /></h2>
                        <h4 class="card-text">${ formation.nomfr }</h4>
                        <p class="card-text text-dark"><c:out value="${ formation.description }" /></p>

                    </div>
                </div>
            </div>
        
       
         
            
   </c:forEach>         

            
        
    </div>




</body>

</html>