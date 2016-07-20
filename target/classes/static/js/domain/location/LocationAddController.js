angular.module('app').controller('LocationAddController', 
								['LocationDetailService', '$scope', '$location', '$routeParams', 
								 function(LocationDetailService, $scope, $location, $routeParams) {							
									
	this.addLocation = function() {
		LocationDetailService.addLocation($scope.loc).then(function(result) {
			$location.path('/admin')
		})
	}
	
}]);