angular.module('app').controller('UserLoginController', 
								['LocationDetailService', 'allLocations', '$location', '$routeParams', 
								 function(LocationDetailService, allLocations, $location, $routeParams) {
	if (authenticated != 'user')
		$location.path('/home')
		
	this.locations = allLocations.data;
	
}]);