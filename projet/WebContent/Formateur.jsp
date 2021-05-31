<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
  <title>Formateur</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

   <link rel="stylesheet" href="./css/bootstrap.min.css"/>
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
                            <li class="mean-last"><img src="img/user.jpg"> </li>
                            <li class="active"> <a href="Formateur.jsp">formateur: ${sessionScope.nom} ${sessionScope.prenom}</a> </li>
                            <li> <a href="apropos.jsp">A propos</a> </li>                            
                           </ul>
                        </nav>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </header>
<br>
    <div class="container login-container" align="center">
    <div class="row">
<div class="col-10">
</div>
<div class="col-1">
<li class="mean-last"> <a href="Add.jsp"><img src="img/Ajout1.jpg"></a> </li>
</div>
<div class="col-1">
<form action="Deconnexion" method="post">
<li class="mean-last"> <button type="submit" class="btn btn text-danger bg-light">Déconnection</button> </li>
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
 
                         <div class="col-5 ">
                <form role="form" method="get" action="Modifier">
                <input type="hidden" name="custId5" value="${ formation.idformation }">
                  <button type="submit" class="btn btn  bg-light">Edit</button>
                  </form>
                  <form action="Cours" method="post">
                 <input type="hidden" name="custId1" value="${ formation.idformation }">
            </form>
                       
 </div>
  <div class="col-4 "></div>
  <div class="col-3 ">
  <form role="form" method="post" action="Supprimer">
   <input type="hidden" name="custId1" value="${ formation.idformation }">
   <input type="hidden" name="custId2" value="${sessionScope.idformateur}">
  <button data-dismiss="alert" data-target="#closeablecard" type="submit" class="close"
                            aria-label="Close">
                            <span aria-hidden="true">&times;</span>
  </button>
  </form>
  </div>
   </div>
    </div>
  <div class="card-body bg-Secondaryr">
  
    <h2 class="card-title"><c:out value="${ formation.nom }" /></h2>
     <h4 class="card-text"></h4>
     <p class="card-text text-dark"><c:out value="${ formation.description }" /></p>
     
  </div>
 </div>
</div>
   </c:forEach>         
            
            
            </div>
          </div>
        
    


</body>
</html>