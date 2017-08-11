<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="assets/css/loginstyle.css">
<style>
.error {
	color: red;
	font-weight: small;
}
</style>

</head>

<body>

	<div class="logmod">

		<div class="logmod__wrapper">

			<div class="logmod__container">
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="#"></a></li>
					<!-- <li data-tabtar="lgm-1"><a href="#">Sign Up</a></li> -->
				</ul>
				<div class="logmod__tab-wrapper">
					<div class="logmod__tab lgm-1">
						<div class="logmod__heading">
							
						</div>
		


						<div class="logmod__alter">
							<div class="logmod__alter-container">
								<a href="#" class="connect facebook">
									<div class="connect__icon">
										<i class="fa fa-facebook"></i>
									</div>
									<div class="connect__context">
										<span>Create an account with <strong>Facebook</strong></span>
									</div>
								</a> <a href="#" class="connect googleplus">
									<div class="connect__icon">
										<i class="fa fa-google-plus"></i>
									</div>
									<div class="connect__context">
										<span>Create an account with <strong>Google+</strong></span>
									</div>
								</a>
							</div>
						</div>
					</div>


					<div class="logmod__tab lgm-2">
						<div class="logmod__heading">
							<h1 align="center" style="color: brown">Login</h1>
							
							<h2 style="color: green">${logOutMsg}</h2>
							</span> <span style="color: red">${msg}</span>
						</div>
						<div class="logmod__form">
							<form:form action="login" modelAttribute="loginBean"
								accept-charset="utf-8" class="simform" method="post">
								<div class="sminputs">
									<div class="input full">
										<label class="string optional" for="user-name">Email*<form:errors
												path="email" cssClass="error" /></label>
										<form:input path="email" class="string optional"
											maxlength="255" id="user-email" placeholder="Email" size="50" />

									</div>

								</div>
								<div class="sminputs">
									<div class="input full">
										<label class="string optional" for="user-pw">Password
											*<form:errors path="password" cssClass="error" />
										</label>
										<form:input path="password" class="string optional"
											placeholder="Password" maxlength="255" id="user-pw"
											type="password" size="50" />

										<span class="hide-password">Show</span>
									</div>
								</div>
								<div class="simform__actions">
									<input class="sumbit" name="commit" type="submit"
										value="Log In" /> <span class="simform__actions-sidetext"><a
										class="special" role="link" href="#">Forgot your password?<br>Click
											here
									</a></span>
								</div>
							</form:form>








						</div>
						<div class="logmod__alter">
							<div class="logmod__alter-container">
								<a href="#" class="connect facebook">
									<div class="connect__icon">
										<i class="fa fa-facebook"></i>
									</div>
									<div class="connect__context">
										<span>Sign in with <strong>Facebook</strong></span>
									</div>
								</a> <a href="#" class="connect googleplus">
									<div class="connect__icon">
										<i class="fa fa-google-plus"></i>
									</div>
									<div class="connect__context">
										<span>Sign in with <strong>Google+</strong></span>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="assets/js/index.js"></script>

</body>
</html>
