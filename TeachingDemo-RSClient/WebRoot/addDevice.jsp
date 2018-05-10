<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Add Device</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<header id="header">
						<h1><a href="model2.jsp">Home</a></h1>
						<nav id="nav">
							<ul>
								<li class="special">
									<a href="#menu" class="menuToggle"><span>Menu</span></a>
									<div id="menu">
										<ul>
											<li><a href="#" id="btnTest">Select User</a></li>
											<li><a href="#" id="btnTest1">Select Fuzzly</a></li>
											<li><a href="#" id="btnTest2">Select Accuracy</a></li>	
											<li><a href="addUser.jsp">Add User</a></li>
											<li><a href="addDevice.jsp">Add Device</a></li>
											<li><a href="#" id="btnTest4">Delete Device</a></li>
											<li><a href="updateDevice.jsp" >Update Device</a></li>								
											<li><a href="#" id="btnTest6">Today oil price</a></li>
											<li><a href="#" id="btnTest7">Box office</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</nav>
					</header>

				<!-- Main -->
					<article id="main">
						<section class="wrapper style5">
							<div class="inner">

								<h3>Information</h3>
								<form method="post" action="#">
										<div class="row uniform">
											<div class="6u 12u$(xsmall)">
												<input type="text" name="equName" id="equName" value="" placeholder="Name">
											</div>
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="equDate" id="equDate" value="" placeholder="Date">
											</div>
											<div class="12u$">
												<div class="select-wrapper">
													<select name="equClass" id="equClass">
														<option value="">- Class -</option>
														<option value="1">Micro-Computer</option>
														<option value="1">Server</option>
														<option value="1">ORouter</option>
														<option value="1">Switch</option>
													</select>
												</div>
											</div>
											
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="equDate" id="equUnit" value="" placeholder="Unit">
											</div>

											
											<div class="4u 12u$(small)">
												<input type="radio" id="equSta" name="equSta" checked="">
												<label for="demo-priority-low">Free</label>
											</div>
											<div class="4u 12u$(small)">
												<input type="radio" id="equSta" name="equSta">
												<label for="demo-priority-normal">Loan</label>
											</div>
											<div class="4u$ 12u$(small)">
												<input type="radio" id="equSta" name="equSta">
												<label for="demo-priority-high">Spoil</label>
											</div>
											<div class="6u 12u$(xsmall)">
												<input type="text" name="supplier" id="supplier" value="" placeholder="Supplier">
											</div>
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="unitPrice" id="unitPrice" value="" placeholder="Price">
											</div>
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="presentPosition" id="presentPosition" value="" placeholder="Position">
											</div>
											<div class="6u$ 12u$(xsmall)">
												<input type="text" name="maintainer" id="maintainer" value="" placeholder="Maintainer">
											</div>
											<div class="12u$">
												<textarea name="extra" id="extra" placeholder="Enter your sketch" rows="6"></textarea>
											</div>
											<div class="12u$">
												<ul class="actions">
													<li><input type="button" value="Send Message" class="special" id="btnTest5"></li>
													<li><input type="reset" value="Reset"></li>
											</ul>
											</div>
										</div>
									</form>
							</div>
						</section>
					</article>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="test.js" type="text/javascript"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>