<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page session="true"%>
    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Video PLayer</title>
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
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css'>
		<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js'></script>
		
		
		
		
		 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="#">
		
		<!-- Custom JS -->
		<script type="text/javascript" src="../js/custom.js"></script>
				
		
		
	</head>
	
	<body >

	<div class="wrapper">

		<!-- header -->
		<header>
			<!-- navigation -->

			<nav class="navbar navbar-default" role="navigation">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><img class="img-responsive" src="img/logo1.png" alt="Logo" /></a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">

							<li><a href="#">${username.username}</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Menu <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#event">Events</a></li>
									<li><a href="#blog">New Blogs</a></li>
									<li><a href="#subscribe">Subscribe</a></li>
									<li><a href="userhome.jsp">home</a></li>
									<li><a href="login.jsp">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>






<c:forEach var="video" items="${videoDet}">

		<!--Display embed video-->


		<div class="event" id="event">
			<div class="container">
				

					<div class="default-heading">
						<h1 style="color:orange; font-weight: bold; text-decoration: underline;">${video.name}</h1>
					</div>


					<div class="cen" id="cen">




						<div class="embed-responsive embed-responsive-16by9">
							<iframe class="embed-responsive-item" src="${video.url}"></iframe>
						</div>
					</div>




					<div class="entry">
						<br><br>
						<h3 style="color:#0000b3; font-weight:bold;">  Name: <em style="color:black"> ${video.name} </em> </h3> 
						<h3 style="color:#0000b3; font-weight:bold;"> Date: <em style="color:grey"> ${video.date} </em> | code:  <em style="color:grey"> ${video.code}</em>  </h3>
						<!-- paragraph -->
						<h3 style="color:grey;"> ${video.description} </h3>
					</div>



				
			</div>
		</div>


		<!-- -video end -->





<!-- Feedback display -->

		<div class="container">
			<div class="d-flex justify-content-center row">
				<div class="d-flex flex-column col-md-12">
					<div class="d-flex flex-row align-items-center text-left comment-top p-2 bg-white border-bottom px-4">


						<div class="d-flex flex-column ml-3">

							<div class="d-flex flex-row align-items-center align-content-center post-title">
								<span class="mr-2 comments" style="color:red; font-weight: bold">${video.count} comments&nbsp;</span>
							</div><br>
						</div>
					</div>
					
					
					<div class="coment-bottom bg-white p-2 px-4">
					
					



<!-- Add comment -->

							<form action="insertFeedback" id="myForm" method="post">



								<div class="d-flex flex-row add-comment-section mt-4 mb-4">
								
										<input type="text" name="feedback" class="form-control mr-3" placeholder="Add comment">

									 	<input type="hidden" name="videoID" value="${video.id}">
																		 									
									<button class="btn btn-primary" type="button" onclick="myFunction()">Comment</button>
								</div>

							</form> <br>
							
<!-- Add comment -->				
							
							
<!-- Display feedback list in forEach loop -->	
							
							
				<c:forEach var="fb" items="${video.feedback}">
							
							
							
							
				<div class="card p-3 mt-2">
                <div class="d-flex justify-content-between align-items-center" id="bloc1">
                    <div class="user d-flex flex-row align-items-center"> <br>
                    	<img src="img/pp.jpg" width="30" class="user-img rounded-circle mr-2" style="border-radius: 50%;"> 
                    	<span>
                    		<small class="font-weight-bold text-primary" style="font-weight: bold; font-size:18px"><b>${fb.fusername}</b></small> <br>
                    		<small class="font-weight-bold"> ${fb.feedbackmessage} </small>
                    	</span> 
                    </div> 
                    		<small style="color:grey">${fb.datetime}</small>
                </div>
                
                
                
                
                	<!-- Validating the user -->
                	
                	
                	<!-- initializing the feedback user and session variable  -->

					<c:set var="feedbackUsername" scope="session" value="${fb.fusername}" />
					<c:set var="sessionUsername" scope="session" value="${username.username}" />
					
					
					
				
																		
					<c:if test="${feedbackUsername == sessionUsername}">
					
			
						<form action="deleteFeedback" method="post" id="delete">
						
								<input type="hidden" id="custId" name="fId" value="${fb.idfeedback}">
								<input type="hidden" id="custId" name="fuser" value="${fb.fusername}">
								<input type="hidden" name="videoID" value="${fb.vid}">		
								
							<div id="bloc2" >
                    			
                    				<button class="btn info" data-toggle="modal" type="button" data-target="#A${fb.idfeedback}" ><i class="fa fa-edit" style="font-size:17px;color:blue;" ></i>  </button>    
                    				
                    				<button class="btn info" type="submit"><i class="fa fa-trash" style="font-size:17px;color:red; "></i>  </button> 
                    								  <i class="fa fa-check-circle-o check-icon text-primary"></i> 
                    			                 								                      									   
                			</div> 
                		
                		</form>

                	</c:if>	
                	<!-- End of the Validating the user -->
                	
                	
            </div>
<!-- Finish Display feedback list in forEach loop -->									
								
								
  <!-- Modal -->
  <div class="modal fade" id="A${fb.idfeedback}" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Form</h4>
        </div>
        <div class="modal-body">
        	<!-- update the feedback table -->



		<form action="updateFeedback" method="post" name="update">
		
			<!-- Hidden input: data -->		
			<input type="hidden" id="custId" name="fId" value="${fb.idfeedback}">
			<input type="hidden" id="custId" name="fuser" value="${fb.fusername}">
			<input type="hidden" name="videoID" value="${fb.vid}">
			<input type="text" name="feedbackUpdate" class="form-control mr-3" value="${fb.feedbackmessage}">

			<br>															 									
			<button class="btn btn-primary" type="submit" style="background-color:red; color:white;">Update</button>


		</form>


        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
		

							
							
							
								
								
			</c:forEach>
							
							<!-- End display feedback -->

						</div>
				</div>
			</div>
		</div>
		
		
		

		
		
		
</c:forEach>













<!-- End of get DB values -->

<!-- Feedback End -->













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