<!DOCTYPE html>
<html>

<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="viewport" content="initial-scale=1, maximum-scale=1">
   <title>A9ra-m3ana</title>
   <link rel="stylesheet" href="./css/bootstrap.min.css"/>
   <link rel="stylesheet" href="./css/style.css"/>

</head>

<body class="main-layout home_page login">

   <header>
      <div class="header">
         <div class="container">
            <div class="row">
               <div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
                  <div class="menu-area">
                     <div class="limit-box">
                        <nav class="main-menu">
                           <ul class="menu-area-main">
                            <li> <a href="home.jsp">Acceuil</a> </li>
                            <li> <a href="login.jsp">Mes cours</a></li>
                            <li ><a href="signup.jsp">S'inscrire</a></li>
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
   <div class="log" data-scroll-index="0">
    <div class="row">
    <div class="fdfd col-4">
            <form action="Sauthentifier" method="post" class="container">
    
                <h3>Identifier vous</h3>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Your Emai" name="email" value="" />
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Your Password" name="password" value="" />
                </div>
               <div class="col-6">
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="type" id="inlineRadio1" value="option1">
  <label class="form-check-label text-light" for="inlineRadio1">Formateur</label>
</div>
<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="type" id="inlineRadio2" value="option2">
  <label class="form-check-label text-light" for="inlineRadio2">Apprenant</label>
</div>
  </div>
<div class="row">
<div class="col-4">
  <button type="submit" class="btn btn text-danger bg-light">S'authentifier</button>
</div> 
 </div>
 <div class="row">
<div class="col-12">
<a href="home.jsp" class="btn btn-secondary btn-md active" role="button" >Annuler</a>
   </div>
   </div>
           </form>
        </div>
    </div>
    </div>
   
  

</body>

</html>