var module = angular.module('myapp', ['ngResource']);

module.factory('Note', function($resource) {
	return $resource(':username/notes', { username: '@username'});
})
.controller('NotesController', function($scope, $http, Note) {
	var url = function() {
		return {username:$scope.username || 'vladson'};
	};
	
	var update = function() {
		console.log(url());
		$scope.notes = Note.query(url());
	};
	
	$scope.update = update;
	
	$scope.add = function() {
		var note = new Note();
		note.content = $scope.content;
		note.date = new Date();
		note.$save(url(), function() {
			$scope.content = "";
			update();
		});
	};
	
	$scope.delete = function(_id) {
		var note = new Note();
		note.$delete(angular.extend(url(), {id: _id}), function() {
			update();
		});
	};
	
	$scope.search = function() {
		var username = $scope.username || "vladson";
		
		$http.get(username +"/notes/find", {params:{text: $scope.searchText}})
		.success(function(data) {
			$scope.notes = data;
		});
	};
	
	update();
});