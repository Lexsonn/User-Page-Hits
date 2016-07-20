angular.module('app').service('UserDetailService', ['$http', function($http) {
	
	var url = 'users/';
	
	this.getAllUsers = function() { return $http.get(url) }
	this.getUserDetails = function(id) { return $http.get(url + id) }
	this.getUserDetailsName = function(username) { return $http.get(url + 'name/' + username) }
	this.getUserLogin = function(user) { return $http.post(url + 'login', user) }
	
}])