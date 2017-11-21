<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>AniamlsCaring.com</title>
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/resources/js/bootstrap.css"
		type="text/css" media="screen" />
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/resources/js/style.css" type="text/css"
		media="screen" />
	<script type="text/javascript"
		src="../resources/js/totop.js">
</script>


</head>
<body class="Home">
	<div class="totopshow">
		<a href="#" class="back-to-top"><img alt="Back to Top"
			src="<%=request.getContextPath()%>/resources/images/gototop0.png" /></a>
	</div>
	<header id="ttr_header">
	<div id="ttr_header_inner">
		<div class="headerforeground01"></div>
		<div class="ttr_headershape01">
			<div class="html_content">
				<p>
					<span style="font-size: 0.857em; color: rgba(243, 243, 243, 1);"><a href="http://localhost:18080/animal-care-web/login.jsf">Sign in</a></span>
				</p>
			</div>
		</div>
		<div class="ttr_headershape02">
			<div class="html_content">
				<p>
					<span style="font-size: 0.857em; color: rgba(243, 243, 243, 1);">yamma a7ayt smella</span>
				</p>
			</div>
		</div>
	</div>
	</header>
	<nav id="ttr_menu" class="navbar-default navbar">
	<div id="ttr_menu_inner_in">
		<div class="menuforeground"></div>
		<div class="ttr_menushape1">
			<div class="html_content">
				<p>
					<span
						style="font-family: 'Arial'; font-weight: 700; font-size: 2.571em; color: rgba(78, 78, 78, 1);">DOG
						CLUB</span>
				</p>
			</div>
		</div>
		<div id="navigationmenu">
			<div class="navbar-header">
				<button id="nav-expander" data-target=".navbar-collapse"
					data-toggle="collapse" class="navbar-toggle" type="button">
					<span class="sr-only"> </span> <span class="icon-bar"> </span> <span
						class="icon-bar"> </span> <span class="icon-bar"> </span>
				</button>
				<a href="http://www.templatetoaster.com" target="_self"> <img
					class="ttr_menu_logo"
					src="<%=request.getContextPath()%>/resources/images/menulogo.png" />
				</a>
			</div>
				<div class="menu-center collapse navbar-collapse">
				<ul class="ttr_menu_items nav navbar-nav navbar-right">
					<li class="ttr_menu_items_parent dropdown active"><a
						href="http://localhost:18080/animal-care-web/layout.jsf" class="ttr_menu_items_parent_link_active"   ><span
							class="menuchildicon"></span>Home</a>
						<hr class="horiz_separator" /></li>
					<li class="ttr_menu_items_parent dropdown">
					<a class="ttr_menu_items_parent_link" href="http://localhost:18080/animal-care-web/affAni.jsf"><span
							class="menuchildicon"></span> Our Animals</a>
						<hr class="horiz_separator" /></li> 
					<li class="ttr_menu_items_parent dropdown"><a
						href="http://localhost:18080/animal-care-web/pages/listConfirmer.jsf" class="ttr_menu_items_parent_link"><span
							class="menuchildicon"></span>Our  Adverts </a>
					<hr class="horiz_separator" /></li>
					<li class="ttr_menu_items_parent dropdown"><a
						href="training.html" class="ttr_menu_items_parent_link"><span
							class="menuchildicon"></span>Training</a>
						<hr class="horiz_separator" /></li>
					<li class="ttr_menu_items_parent dropdown"><a
						href="contact.html" class="ttr_menu_items_parent_link"><span
							class="menuchildicon"></span>Contact</a>
						<hr class="horiz_separator" /></li>
				</ul>
			</div>
		
		</div>
	</div>
	</nav>



   <column>

    <form action="EmailSendingServlet" method="post">
        <table border="0" width="35%" align="center">
            <caption><h2>Send New E-mail</h2></caption>
            <tr>
               
                <td><input type="hidden" name="recipient" size="50" value="sinda.mtar@esprit.tn"/></td>
            </tr>
            <tr>
                <td>Your Email Address </td>
                <td><input type="text" name="subject" size="50" value="${authentificationBean.user.mail}"/></td>
            </tr>
            <tr>
                <td>Content </td>
                <td><textarea rows="10" cols="39" name="content"></textarea> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>

<div style="height: 0px; width: 0px; overflow: hidden;"></div>
	<footer id="ttr_footer">
	<div class="ttr_footerHome_html_row0 row">
		<div class="post_column col-lg-3 col-md-6 col-sm-6 col-xs-12">
			<div class="ttr_footerHome_html_column00">
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
				<div class="html_content">
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<span
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);">LOCATION</span>
					</p>
					<p
						style="margin: 1.43em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span
							style="font-family: 'Arial'; font-weight: 700; color: rgba(255, 255, 255, 1);">125,
							First Flore, Golden Suit,New York</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span
							style="font-family: 'Arial'; font-weight: 700; color: rgba(255, 255, 255, 1);">Phone:
							1800 125 2000</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span
							style="font-family: 'Arial'; font-weight: 700; color: rgba(255, 255, 255, 1);">Fax:
							1800 125 2000</span>
					</p>
				</div>
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
			</div>
		</div>
		<div class="clearfix visible-xs-block"></div>
		<div class="post_column col-lg-3 col-md-6 col-sm-6 col-xs-12">
			<div class="ttr_footerHome_html_column01">
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
				<div class="html_content">
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<span
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);">INFORMATION</span>
					</p>
					<p
						style="margin: 1.43em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">Aliquam </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">L</span><span
							style="color: rgba(255, 255, 255, 1);">ibero nisi</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">I</span><span
							style="color: rgba(255, 255, 255, 1);">perdiet at </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">T</span><span
							style="color: rgba(255, 255, 255, 1);">incidunt </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">G</span><span
							style="color: rgba(255, 255, 255, 1);">ravida </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">V</span><span
							style="color: rgba(255, 255, 255, 1);">ehicula</span>
					</p>
				</div>
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
			</div>
		</div>
		<div
			class="clearfix visible-sm-block visible-md-block visible-xs-block">
		</div>
		<div class="post_column col-lg-3 col-md-6 col-sm-6 col-xs-12">
			<div class="ttr_footerHome_html_column02">
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
				<div class="html_content">
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<span
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);">EXTRAS</span>
					</p>
					<p
						style="margin: 1.43em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">Aliquam </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">L</span><span
							style="color: rgba(255, 255, 255, 1);">ibero nisi</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">I</span><span
							style="color: rgba(255, 255, 255, 1);">perdiet at </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">T</span><span
							style="color: rgba(255, 255, 255, 1);">incidunt </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">G</span><span
							style="color: rgba(255, 255, 255, 1);">ravida </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">V</span><span
							style="color: rgba(255, 255, 255, 1);">ehicula</span>
					</p>
				</div>
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
			</div>
		</div>
		<div class="clearfix visible-xs-block"></div>
		<div class="post_column col-lg-3 col-md-6 col-sm-6 col-xs-12">
			<div class="ttr_footerHome_html_column03">
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
				<div class="html_content">
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<br
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);" />
					</p>
					<p style="margin: 0.36em 0em 0.36em 4.29em;">
						<span
							style="font-family: 'Arial'; font-weight: 700; font-size: 1.286em; color: rgba(255, 255, 255, 1);">FOLLOW
							US</span>
					</p>
					<p
						style="margin: 1.43em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">Facebook</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">Twitter</span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">Linkedin</span><span
							style="color: rgba(255, 255, 255, 1);"> </span>
					</p>
					<p
						style="margin: 0.36em 0em 0.36em 4.29em; line-height: 1.40845070422535;">
						<span style="color: rgba(255, 255, 255, 1);">RSS</span><span
							style="color: rgba(255, 255, 255, 1);"> </span>
					</p>
				</div>
				<div
					style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-top-collapse: separate;"></div>
			</div>
		</div>
		<div
			class="clearfix visible-lg-block visible-sm-block visible-md-block visible-xs-block">
		</div>
	</div>
	<div class="ttr_footer_bottom_footer">
		<div class="ttr_footer_bottom_footer_inner">
			<div id="ttr_footer_designed_by_links">
				<a href="http://templatetoaster.com" target="_self"> Website </a> <span
					id="ttr_footer_designed_by"> Designed With TemplateToaster </span>
			</div>
		</div>
	</div>
	</footer>
	<div
		style="height: 0px; width: 0px; overflow: hidden; -webkit-margin-bottom-collapse: separate;"></div>
	<script type="text/javascript">
WebFontConfig = {
google: { families: [ 'Open+Sans','Open+Sans:700'] }
};
(function() {
var wf = document.createElement('script');
wf.src = ('https:' == document.location.protocol ? 'https' : 'http') + '://ajax.googleapis.com/ajax/libs/webfont/1.0.31/webfont.js';
wf.type = 'text/javascript';
wf.async = 'true';
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(wf, s);
})();
</script>

</column>
</body>




</html>







