angular.module('app').constant('baseRoute', 'js/domain/').constant('homePage', 'js/core/home.html');

var authenticated = null;

var loadCSS = function(href) {
	  var cssLink = $("<link>");
	  $("head").append(cssLink); //IE hack: append before setting href

	  cssLink.attr({
	    rel:  "stylesheet",
	    type: "text/css",
	    href: href
	  });
}
