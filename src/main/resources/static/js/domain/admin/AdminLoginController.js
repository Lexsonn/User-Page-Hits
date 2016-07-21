angular.module('app').controller('AdminLoginController', 
								['LocationDetailService', '$scope', 'allLocations', '$location', '$routeParams', 
								 function(LocationDetailService, $scope, allLocations, $location, $routeParams) {
	$('.moveup').each(function(index, element){ $(element).css({marginTop: '-15px'}) });
	$('#typeMenu').css({marginTop: '2vh'})
	//loadCSS('css/Styles.css')
	
	if (authenticated != 'admin')
		$location.path('/home')
		
	$scope.locations = allLocations.data;
	this.currentType = 'all';
	this.availableTypes = ['all', 'day', 'week', 'month', 'year'];
	
	this.addLocation = function() {
		$location.path('/locations/add')
	}
	
	this.typeSelected = function(type) {
		this.currentType = type;
		if (type === 'all') {
			$scope.locations = allLocations.data;
		}else {
			LocationDetailService.getLocationsByDays(type)
			.then(function(result) { 
				$scope.locations = result.data;
			});
		}
	}
}]);