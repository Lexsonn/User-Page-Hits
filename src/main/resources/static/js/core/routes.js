angular
	.module('app')
	.config(['$routeProvider', 'baseRoute', 'homePage',
    function config($routeProvider, baseRoute, homePage) {
		$routeProvider
      	.when('/home', {
          templateUrl: homePage,
          controller: 'HomeController',
          controllerAs: 'homeController'
        })
        .when('/home/:id', {
          templateUrl: homePage,
          controller: 'HomeController',
          controllerAs: 'homeController'
        })
        .when('/admin', {
          templateUrl: baseRoute + 'admin/adminLogin.html',
          controller: 'AdminLoginController',
          controllerAs: 'adminLoginController',
    	  resolve: {
            allLocations: function(LocationDetailService){
	        	return LocationDetailService.getAllLocations();
	  		}
    	  }
        })
        .when('/user', {
          templateUrl: baseRoute + 'user/userLogin.html',
          controller: 'UserLoginController',
          controllerAs: 'userLoginController',
    	  resolve: {
          	allLocations: function(LocationDetailService){
	          	return LocationDetailService.getAllLocations();
	  	  	}
    	  }
        })
        .when('/locations/get/:id', {
        	templateUrl: baseRoute + 'location/locationDetailTemplate.html',
        	controller: 'LocationDetailController',
        	controllerAs: 'locationDetailController'
        })
        .when('/locations/add', {
        	templateUrl: baseRoute + 'location/AddLocationTemplate.html',
        	controller: 'LocationAddController',
        	controllerAs: 'locationAddController'
        })
        .otherwise('/home');
    }
  ]);