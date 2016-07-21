angular.module('app').service('LocationDetailService', ['$http', function($http) {
	
	var url = 'locations/';
	
	this.getAllLocations = function() { return $http.get(url) }
	this.getLocationDetails = function(id) { return $http.get(url + id) }
	this.getUserLocationName = function(name) { return $http.get(url + 'name/' + name) }
	this.getLocationsByDays = function(days) { return $http.get(url + days) } //Poopybutthole
	
	this.addLocation = function(location) { return $http.post(url, location) }
	
}])