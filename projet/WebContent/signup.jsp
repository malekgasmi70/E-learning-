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
                           <li class="active"><a href="signup.jsp">S'inscrire</a></li>
                            <li> <a href="login.jsp">S'authentifier</a> </li>
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
   <div class="log" data-scroll-index="0">
    <div class="row">
    <div class="fdfd col-4">
            <form action="Sinscrire" method="post" class="container">
    <div class="row">
                <h2>S'inscrire</h2></div>
          <p class="text-Light">Veuillez remplir ce formulaire pour créer un compte.</p>
          <div class="row" >  
          <div class="col-6">    
          <input type="text" placeholder="votre nom" name="nom" minlength="2" minlength="25" required></div>
          <div class="col-6">
          <input type="text" placeholder="votre prenom" name="prenom" minlength="2" minlength="25" required>
      </div></div>
     <div class="row" >   
     <div class="col-6">
          <input type="date" placeholder="votre date de naissance" name="dns" required>
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
          
          </div>
          <div class="row" >
         <div class="col-6">    
          <input type="text" placeholder="votre email" name="email" required>
          </div>
          <div class="col-6">
          <input type="password" placeholder="votre mot de passe" name="pass" minlength="8" required>
      </div> 

     </div>
          
      
      
          <div class="row">

      
      <div class="col-3 ">
        <button type="submit" class="btn btn-danger">S'inscrire</button>
      </div></div>
      <div class="row">
      <div class="col-3">  
<a href="home.jsp" class="btn btn-secondary btn-md active" role="button" >Annuler</a>
       </div> 
   </div>
   
          </form>
 
              
        </div>
        </div>
    </div>
   
  

</body>

</html>