angular.module("listaTelefonica").controller("detalhesContatoCtrl", function($scope, contato) {
	$scope.contato = contato.data;
});