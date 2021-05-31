<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Add</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" href="./css/bootstrap.min.css"/>
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

                                        <li class="active"> <a href="Formateur.jsp">formateur: ${sessionScope.nom} ${sessionScope.prenom}</a> </li>

                                        <li> <a href="apropos.jsp">A propos</a> </li>                                                                </ul>
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
            <div class="col ">


                <form role="form" method="post" action="Ajoutform">
                    <fieldset>
                        <legend class="text-danger"> Ajouter une Formation</legend>
                        <br><br>
                        <div class="form-check">
                            <label for="exampleInputCours">Nom du formation</label>
                            <input type="text" class="form-control" id="exampleInputCours" name="nomformation"     placeholder="Entrer le nom du formation">
                        </div>

                        <br>

                        <div class="form-group">

                            <div class="form-check">
                                <label for="exampleInputformateur">Formateur</label>
                                <input type="text" class="form-control" id="exampleInputformateur"
                                name="formateur"    placeholder="Entrer le nom du formateur">
                            </div>
                        </div>

                        <br>

                        <div class="form-group">

                            <div class="form-check">
                                <label for="exampleInputDescription">Description</label>
                                <input type="text" class="form-control" id="exampleInputDescription"
                                name="description"    placeholder="Donner une Description">
                            </div>
                        </div>
 <input type="hidden" name="custId" value="${sessionScope.idformateur}">

                        <div class="row">

                             <div class="col-3 "><a class="btn btn-secondary" href="Formateur.jsp" role="button">Annuler</a></div>
                             <div class="col-6"> </div>
                             <div class="col-3 ">
  <button type="submit" class="btn btn bg-danger">Ajouter</button>
                            </div>               
                            
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</body>

</html>