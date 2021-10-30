<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Browse Video and Stream</title>
		<!-- Description, Keywords and Author -->
		<meta name="description" content="Your description">
		<meta name="keywords" content="Your,Keywords">
		<meta name="author" content="ResponsiveWebInc">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- Styles -->
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- Font awesome CSS -->
		<link href="css/font-awesome.min.css" rel="stylesheet">		
		<!-- Custom CSS -->
		<link href="css/style.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="#">
		
		
		<!-- Custom JS -->
		<script type="text/javascript" src="../js/custom.js"></script>
		
		
		
	</head>
	
	<body>
	
		<div class="wrapper">
		
			<!-- header -->
			<header>
				<!-- navigation -->
			
				<nav class="navbar navbar-default" role="navigation">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img class="img-responsive" src="img/logo1.png" alt="Logo" /></a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="#">${username.username}</a></li>
								
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <span class="caret"></span></a>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#event">Events</a></li>
										<li><a href="#blog">New Blogs</a></li>
										<li><a href="#subscribe">Subscribe</a></li>
										<li><a href="#team">Executive Team</a></li>
										<li><a href="login.jsp">Logout</a></li>
									</ul>
								</li>
							</ul>
						</div><!-- /.navbar-collapse -->
					</div><!-- /.container-fluid -->
				</nav>
			</header>
			
			<!-- banner -->
				<section id="hero" class="d-flex justify-cntent-center align-items-center">
			<div class="banner">
				<div class="container">
					<!-- heading -->
					<h2>I'm Banner Heading for This Page</h2>
					<!-- paragraph -->
					<p>It is our belief that in order to be most efficient it requires adaptive technology and software our customers can focus on their core business.</p>
				</div>
			</div>
			</section>
			<!-- banner end -->
			
			
		
			
<!-- Search videos-->	

<div class="event" id="event">

<form action="search" class="search-bar" id="myForm" method="post">



<div class="container">



  <div class="row searchFilter" >
     <div class="col-sm-12" >
      <div class="input-group" >
       <input id="table_filter" type="text" name="search" class="form-control" aria-label="Text input with segmented button dropdown" style="height:50px" >
       <div class="input-group-btn" >
        <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><span class="label-icon" >Filter</span> <span class="caret" >&nbsp;</span></button>
       
       
       
        <div class="dropdown-menu dropdown-menu-right" >
           <ul class="category_filters" >
            <li >
             <input class="cat_type category-input" data-label="All" id="all" value="0" name="filter" type="radio" checked ><label for="all" >All</label>
            </li>
           
            <li >
             <input type="radio" name="filter" id="Design" value="1" ><label class="category-label" for="Design" >Name</label>
            </li>
            
             <li >
             <input type="radio" name="filter" id="Design" value="2" ><label class="category-label" for="Design" >Date</label>
            </li>

           </ul>
        </div>
       
       
       
        <button id="searchBtn" type="button" class="btn btn-secondary btn-search" onclick="myFunction()" ><span class="glyphicon glyphicon-search" >&nbsp;</span> <span class="label-icon" >Search</span></button>
       </div>
      </div>
     </div>
  </div>
</div>

<!-- End of form -->

</form>

</div>


<!-- Display all the Latest video in Database -->	
<!-- Available Videos -->

	<div class="event" id="event">
				<div class="container">
					<div class="default-heading">
						<!-- heading -->
						<h2 style="font-weight: bold; color:orange">Latest videos</h2>
					</div>


				<div class="row">

<c:forEach var = "video" items="${vlist}">

		

						<div class="col-md-4 col-sm-4">
							<!-- event item -->
							<div class="event-item">
							
								<!-- image -->
							<div class="containerImg">
								<img class="img-responsive" src="${video.thumbnail}" alt="Events" />
								<!-- Play video -->

								<form action="play" method="post">

									<!-- Hidden input: ID -->
									<input type="hidden" id="custId" name="vidId" value="${video.id}">

									<button class="play-btn" type="submit" name="submit"> </button>

								</form>
							
								<!-- Play video -->
								
								
								
								</div>
								<!-- heading -->
								<h4><a href="${video.url}">${video.name}</a></h4>
								<!-- sub text -->
								<span class="sub-text">Date: ${video.date} </span>
								<!-- paragraph -->
								<p> ${video.description} </p>
								
								
															
								
							</div>
						
	
						</div>


					</c:forEach>
		
				</div>
				
				</div>
			</div>		
<!-- Video display end -->		









			
			<!-- blog -->
			<div class="blog" id="blog">
				<div class="container">
					<div class="default-heading">
						<!-- heading -->
						<h2>Latest Blogs</h2>
					</div>
					<div class="row">
						<div class="col-md-6 col-sm-6">
							<!-- blog entry -->
							<div class="entry">
								<!-- blog entry image -->
								<img class="img-responsive" src="img/blog/1.jpg" alt="Blog" />
								<!-- heading / blog post title -->
								<h3><a href="#">Communicating with you every step of the way</a></h3>
								<!-- blog information -->
								<span class="meta">
									July 02, 2014 | Tag: Technology | By: David John
								</span>
								<!-- paragraph -->
								<p>We combine continuing education and constant monitoring us with your project details if you are interested to ge of industry trends and innovations to provide the right IT solution at the right time. Contact us with your project details if you are interested to get our Web Solution or Software Development Services.</p>
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<!-- blog entry -->
							<div class="entry">
								<!-- blog entry image -->
								<img class="img-responsive" src="img/blog/2.jpg" alt="Blog" />
								<!-- heading / blog post title -->
								<h3><a href="#">Communicating with you every step of the way</a></h3>
								<!-- blog information -->
								<span class="meta">
									July 02, 2014 | Tag: Technology | By: David John
								</span>
								<!-- paragraph -->
								<p>We combine continuing education and constant monitoring us with your project details if you are interested to ge of industry trends and innovations to provide the right IT solution at the right time. Contact us with your project details if you are interested to get our Web Solution or Software Development Services.</p>
							</div>
						</div>
					</div>
					<div class="text-center">
						<a href="#" class="btn btn-default">See More</a>
					</div>
				</div>
			</div>
			<!-- blog end -->
			
			<!-- subscribe -->
			<div class="subscribe" id="subscribe">
				<div class="container">
					<!-- subscribe content -->
					<div class="sub-content">
						<h3>Subscribe Here for Updates</h3>
						<form role="form">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Email...">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button">Subscribe</button>
									</span>
							</div><!-- /input-group -->
						</form>
					</div>
				</div>
			</div>
			<!-- subscribe end -->
			
			<!-- team -->
			<div class="team" id="team">
				<div class="container">
					<div class="default-heading">
						<!-- heading -->
						<h2>Executing Team</h2>
					</div>
					<div class="row">
						<div class="col-md-3 col-sm-3">
							<!-- team member -->
							<div class="member">
								<!-- images -->
								<img class="img-responsive" src="img/team/1.jpg" alt="Team Member" />
								<!-- heading -->
								<h3>Adam Miser</h3>
								<!-- designation -->
								<span class="dig">CEO</span>
								<!-- email -->
								<a href="#">executive.member@bloger.com</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-3">
							<!-- team member -->
							<div class="member">
								<!-- images -->
								<img class="img-responsive" src="img/team/2.jpg" alt="Team Member" />
								<!-- heading -->
								<h3>Adam Miser</h3>
								<!-- designation -->
								<span class="dig">CEO</span>
								<!-- email -->
								<a href="#">executive.member@bloger.com</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-3">
							<!-- team member -->
							<div class="member">
								<!-- images -->
								<img class="img-responsive" src="img/team/1.jpg" alt="Team Member" />
								<!-- heading -->
								<h3>Adam Miser</h3>
								<!-- designation -->
								<span class="dig">CEO</span>
								<!-- email -->
								<a href="#">executive.member@bloger.com</a>
							</div>
						</div>
						<div class="col-md-3 col-sm-3">
							<!-- team member -->
							<div class="member">
								<!-- images -->
								<img class="img-responsive" src="img/team/2.jpg" alt="Team Member" />
								<!-- heading -->
								<h3>Adam Miser</h3>
								<!-- designation -->
								<span class="dig">CEO</span>
								<!-- email -->
								<a href="#">executive.member@bloger.com</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- team end -->
			
			<!-- footer -->
			<footer>
				<div class="container">
					<p><a href="#">Home</a> | <a href="#work">works</a> | <a href="#team">Team</a> | <a href="#contact">Contact</a></p>
					<div class="social">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-dribbble"></i></a>
						<a href="#"><i class="fa fa-linkedin"></i></a>
						<a href="#"><i class="fa fa-google-plus"></i></a>
					</div>
					<!-- copy right -->
					<!-- This theme comes under Creative Commons Attribution 4.0 Unported. So don't remove below link back -->
					<p class="copy-right">Copyright &copy; 2014 <a href="#">Your Site</a> | Designed By : <a href="http://www.indioweb.in/portfolio">IndioWeb</a>, All rights reserved. </p>
				</div>
			</footer>

		</div>
		
		
		<!-- Javascript files -->
		<!-- jQuery -->
		<script src="js/jquery.js"></script>
		<!-- Bootstrap JS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Respond JS for IE8 -->
		<script src="js/respond.min.js"></script>
		<!-- HTML5 Support for IE -->
		<script src="js/html5shiv.js"></script>
		<!-- Custom JS -->
		<script src="js/custom.js"></script>
	</body>	
</html>