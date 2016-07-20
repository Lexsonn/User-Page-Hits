angular.module('app').controller('LocationDetailController', 
								['LocationDetailService', '$location', '$routeParams', 
								 function(LocationDetailService, $location, $routeParams) {
	var ctrl = this;
	
	LocationDetailService.getLocationDetails($routeParams.id).then(function(result){
		ctrl.location = result.data;
		if (authenticated === null) {
			LocationDetailService.addLocation({title: null, num: $routeParams.id})
		}
	});

}]);