var module = angular.module('myapp', ['ngResource']);

module.factory('Note', function($resource) {
	return $resource(':username/notes', { username: '@username'});
})
.controller('NotesController', function($scope, Note) {
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
		note.$save(url(), function() {
			$scope.content = "";
			update();
		});
	};
	
	update();
});